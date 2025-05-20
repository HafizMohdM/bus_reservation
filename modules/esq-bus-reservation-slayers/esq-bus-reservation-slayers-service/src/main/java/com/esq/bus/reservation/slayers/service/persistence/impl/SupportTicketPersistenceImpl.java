/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.esq.bus.reservation.slayers.service.persistence.impl;

import com.esq.bus.reservation.slayers.exception.NoSuchSupportTicketException;
import com.esq.bus.reservation.slayers.model.SupportTicket;
import com.esq.bus.reservation.slayers.model.SupportTicketTable;
import com.esq.bus.reservation.slayers.model.impl.SupportTicketImpl;
import com.esq.bus.reservation.slayers.model.impl.SupportTicketModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.SupportTicketPersistence;
import com.esq.bus.reservation.slayers.service.persistence.SupportTicketUtil;
import com.esq.bus.reservation.slayers.service.persistence.impl.constants.BOOKRESERVATIONPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the support ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SupportTicketPersistence.class)
public class SupportTicketPersistenceImpl
	extends BasePersistenceImpl<SupportTicket>
	implements SupportTicketPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SupportTicketUtil</code> to access the support ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SupportTicketImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SupportTicketPersistenceImpl() {
		setModelClass(SupportTicket.class);

		setModelImplClass(SupportTicketImpl.class);
		setModelPKClass(long.class);

		setTable(SupportTicketTable.INSTANCE);
	}

	/**
	 * Caches the support ticket in the entity cache if it is enabled.
	 *
	 * @param supportTicket the support ticket
	 */
	@Override
	public void cacheResult(SupportTicket supportTicket) {
		entityCache.putResult(
			SupportTicketImpl.class, supportTicket.getPrimaryKey(),
			supportTicket);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the support tickets in the entity cache if it is enabled.
	 *
	 * @param supportTickets the support tickets
	 */
	@Override
	public void cacheResult(List<SupportTicket> supportTickets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (supportTickets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SupportTicket supportTicket : supportTickets) {
			if (entityCache.getResult(
					SupportTicketImpl.class, supportTicket.getPrimaryKey()) ==
						null) {

				cacheResult(supportTicket);
			}
		}
	}

	/**
	 * Clears the cache for all support tickets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupportTicketImpl.class);

		finderCache.clearCache(SupportTicketImpl.class);
	}

	/**
	 * Clears the cache for the support ticket.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupportTicket supportTicket) {
		entityCache.removeResult(SupportTicketImpl.class, supportTicket);
	}

	@Override
	public void clearCache(List<SupportTicket> supportTickets) {
		for (SupportTicket supportTicket : supportTickets) {
			entityCache.removeResult(SupportTicketImpl.class, supportTicket);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SupportTicketImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SupportTicketImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new support ticket with the primary key. Does not add the support ticket to the database.
	 *
	 * @param supportTicketId the primary key for the new support ticket
	 * @return the new support ticket
	 */
	@Override
	public SupportTicket create(long supportTicketId) {
		SupportTicket supportTicket = new SupportTicketImpl();

		supportTicket.setNew(true);
		supportTicket.setPrimaryKey(supportTicketId);

		return supportTicket;
	}

	/**
	 * Removes the support ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket that was removed
	 * @throws NoSuchSupportTicketException if a support ticket with the primary key could not be found
	 */
	@Override
	public SupportTicket remove(long supportTicketId)
		throws NoSuchSupportTicketException {

		return remove((Serializable)supportTicketId);
	}

	/**
	 * Removes the support ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the support ticket
	 * @return the support ticket that was removed
	 * @throws NoSuchSupportTicketException if a support ticket with the primary key could not be found
	 */
	@Override
	public SupportTicket remove(Serializable primaryKey)
		throws NoSuchSupportTicketException {

		Session session = null;

		try {
			session = openSession();

			SupportTicket supportTicket = (SupportTicket)session.get(
				SupportTicketImpl.class, primaryKey);

			if (supportTicket == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupportTicketException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(supportTicket);
		}
		catch (NoSuchSupportTicketException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SupportTicket removeImpl(SupportTicket supportTicket) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supportTicket)) {
				supportTicket = (SupportTicket)session.get(
					SupportTicketImpl.class, supportTicket.getPrimaryKeyObj());
			}

			if (supportTicket != null) {
				session.delete(supportTicket);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (supportTicket != null) {
			clearCache(supportTicket);
		}

		return supportTicket;
	}

	@Override
	public SupportTicket updateImpl(SupportTicket supportTicket) {
		boolean isNew = supportTicket.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(supportTicket);
			}
			else {
				supportTicket = (SupportTicket)session.merge(supportTicket);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SupportTicketImpl.class, supportTicket, false, true);

		if (isNew) {
			supportTicket.setNew(false);
		}

		supportTicket.resetOriginalValues();

		return supportTicket;
	}

	/**
	 * Returns the support ticket with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the support ticket
	 * @return the support ticket
	 * @throws NoSuchSupportTicketException if a support ticket with the primary key could not be found
	 */
	@Override
	public SupportTicket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupportTicketException {

		SupportTicket supportTicket = fetchByPrimaryKey(primaryKey);

		if (supportTicket == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupportTicketException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return supportTicket;
	}

	/**
	 * Returns the support ticket with the primary key or throws a <code>NoSuchSupportTicketException</code> if it could not be found.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket
	 * @throws NoSuchSupportTicketException if a support ticket with the primary key could not be found
	 */
	@Override
	public SupportTicket findByPrimaryKey(long supportTicketId)
		throws NoSuchSupportTicketException {

		return findByPrimaryKey((Serializable)supportTicketId);
	}

	/**
	 * Returns the support ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket, or <code>null</code> if a support ticket with the primary key could not be found
	 */
	@Override
	public SupportTicket fetchByPrimaryKey(long supportTicketId) {
		return fetchByPrimaryKey((Serializable)supportTicketId);
	}

	/**
	 * Returns all the support tickets.
	 *
	 * @return the support tickets
	 */
	@Override
	public List<SupportTicket> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @return the range of support tickets
	 */
	@Override
	public List<SupportTicket> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support tickets
	 */
	@Override
	public List<SupportTicket> findAll(
		int start, int end,
		OrderByComparator<SupportTicket> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support tickets
	 */
	@Override
	public List<SupportTicket> findAll(
		int start, int end, OrderByComparator<SupportTicket> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SupportTicket> list = null;

		if (useFinderCache) {
			list = (List<SupportTicket>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUPPORTTICKET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPORTTICKET;

				sql = sql.concat(SupportTicketModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SupportTicket>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the support tickets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SupportTicket supportTicket : findAll()) {
			remove(supportTicket);
		}
	}

	/**
	 * Returns the number of support tickets.
	 *
	 * @return the number of support tickets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUPPORTTICKET);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "supportTicketId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUPPORTTICKET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SupportTicketModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the support ticket persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setSupportTicketUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSupportTicketUtilPersistence(null);

		entityCache.removeCache(SupportTicketImpl.class.getName());
	}

	private void _setSupportTicketUtilPersistence(
		SupportTicketPersistence supportTicketPersistence) {

		try {
			Field field = SupportTicketUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, supportTicketPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = BOOKRESERVATIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BOOKRESERVATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BOOKRESERVATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUPPORTTICKET =
		"SELECT supportTicket FROM SupportTicket supportTicket";

	private static final String _SQL_COUNT_SUPPORTTICKET =
		"SELECT COUNT(supportTicket) FROM SupportTicket supportTicket";

	private static final String _ORDER_BY_ENTITY_ALIAS = "supportTicket.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SupportTicket exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SupportTicketPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}