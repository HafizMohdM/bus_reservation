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

import com.esq.bus.reservation.slayers.exception.NoSuchRefundRequestException;
import com.esq.bus.reservation.slayers.model.RefundRequest;
import com.esq.bus.reservation.slayers.model.RefundRequestTable;
import com.esq.bus.reservation.slayers.model.impl.RefundRequestImpl;
import com.esq.bus.reservation.slayers.model.impl.RefundRequestModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.RefundRequestPersistence;
import com.esq.bus.reservation.slayers.service.persistence.RefundRequestUtil;
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
 * The persistence implementation for the refund request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RefundRequestPersistence.class)
public class RefundRequestPersistenceImpl
	extends BasePersistenceImpl<RefundRequest>
	implements RefundRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RefundRequestUtil</code> to access the refund request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RefundRequestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RefundRequestPersistenceImpl() {
		setModelClass(RefundRequest.class);

		setModelImplClass(RefundRequestImpl.class);
		setModelPKClass(long.class);

		setTable(RefundRequestTable.INSTANCE);
	}

	/**
	 * Caches the refund request in the entity cache if it is enabled.
	 *
	 * @param refundRequest the refund request
	 */
	@Override
	public void cacheResult(RefundRequest refundRequest) {
		entityCache.putResult(
			RefundRequestImpl.class, refundRequest.getPrimaryKey(),
			refundRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the refund requests in the entity cache if it is enabled.
	 *
	 * @param refundRequests the refund requests
	 */
	@Override
	public void cacheResult(List<RefundRequest> refundRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (refundRequests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RefundRequest refundRequest : refundRequests) {
			if (entityCache.getResult(
					RefundRequestImpl.class, refundRequest.getPrimaryKey()) ==
						null) {

				cacheResult(refundRequest);
			}
		}
	}

	/**
	 * Clears the cache for all refund requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RefundRequestImpl.class);

		finderCache.clearCache(RefundRequestImpl.class);
	}

	/**
	 * Clears the cache for the refund request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RefundRequest refundRequest) {
		entityCache.removeResult(RefundRequestImpl.class, refundRequest);
	}

	@Override
	public void clearCache(List<RefundRequest> refundRequests) {
		for (RefundRequest refundRequest : refundRequests) {
			entityCache.removeResult(RefundRequestImpl.class, refundRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RefundRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RefundRequestImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new refund request with the primary key. Does not add the refund request to the database.
	 *
	 * @param requestId the primary key for the new refund request
	 * @return the new refund request
	 */
	@Override
	public RefundRequest create(long requestId) {
		RefundRequest refundRequest = new RefundRequestImpl();

		refundRequest.setNew(true);
		refundRequest.setPrimaryKey(requestId);

		return refundRequest;
	}

	/**
	 * Removes the refund request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request that was removed
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	@Override
	public RefundRequest remove(long requestId)
		throws NoSuchRefundRequestException {

		return remove((Serializable)requestId);
	}

	/**
	 * Removes the refund request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the refund request
	 * @return the refund request that was removed
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	@Override
	public RefundRequest remove(Serializable primaryKey)
		throws NoSuchRefundRequestException {

		Session session = null;

		try {
			session = openSession();

			RefundRequest refundRequest = (RefundRequest)session.get(
				RefundRequestImpl.class, primaryKey);

			if (refundRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRefundRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(refundRequest);
		}
		catch (NoSuchRefundRequestException noSuchEntityException) {
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
	protected RefundRequest removeImpl(RefundRequest refundRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(refundRequest)) {
				refundRequest = (RefundRequest)session.get(
					RefundRequestImpl.class, refundRequest.getPrimaryKeyObj());
			}

			if (refundRequest != null) {
				session.delete(refundRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (refundRequest != null) {
			clearCache(refundRequest);
		}

		return refundRequest;
	}

	@Override
	public RefundRequest updateImpl(RefundRequest refundRequest) {
		boolean isNew = refundRequest.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(refundRequest);
			}
			else {
				refundRequest = (RefundRequest)session.merge(refundRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RefundRequestImpl.class, refundRequest, false, true);

		if (isNew) {
			refundRequest.setNew(false);
		}

		refundRequest.resetOriginalValues();

		return refundRequest;
	}

	/**
	 * Returns the refund request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the refund request
	 * @return the refund request
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	@Override
	public RefundRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRefundRequestException {

		RefundRequest refundRequest = fetchByPrimaryKey(primaryKey);

		if (refundRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRefundRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return refundRequest;
	}

	/**
	 * Returns the refund request with the primary key or throws a <code>NoSuchRefundRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	@Override
	public RefundRequest findByPrimaryKey(long requestId)
		throws NoSuchRefundRequestException {

		return findByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns the refund request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request, or <code>null</code> if a refund request with the primary key could not be found
	 */
	@Override
	public RefundRequest fetchByPrimaryKey(long requestId) {
		return fetchByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns all the refund requests.
	 *
	 * @return the refund requests
	 */
	@Override
	public List<RefundRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @return the range of refund requests
	 */
	@Override
	public List<RefundRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of refund requests
	 */
	@Override
	public List<RefundRequest> findAll(
		int start, int end,
		OrderByComparator<RefundRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of refund requests
	 */
	@Override
	public List<RefundRequest> findAll(
		int start, int end, OrderByComparator<RefundRequest> orderByComparator,
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

		List<RefundRequest> list = null;

		if (useFinderCache) {
			list = (List<RefundRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REFUNDREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REFUNDREQUEST;

				sql = sql.concat(RefundRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RefundRequest>)QueryUtil.list(
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
	 * Removes all the refund requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RefundRequest refundRequest : findAll()) {
			remove(refundRequest);
		}
	}

	/**
	 * Returns the number of refund requests.
	 *
	 * @return the number of refund requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REFUNDREQUEST);

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
		return "requestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REFUNDREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RefundRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the refund request persistence.
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

		_setRefundRequestUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRefundRequestUtilPersistence(null);

		entityCache.removeCache(RefundRequestImpl.class.getName());
	}

	private void _setRefundRequestUtilPersistence(
		RefundRequestPersistence refundRequestPersistence) {

		try {
			Field field = RefundRequestUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, refundRequestPersistence);
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

	private static final String _SQL_SELECT_REFUNDREQUEST =
		"SELECT refundRequest FROM RefundRequest refundRequest";

	private static final String _SQL_COUNT_REFUNDREQUEST =
		"SELECT COUNT(refundRequest) FROM RefundRequest refundRequest";

	private static final String _ORDER_BY_ENTITY_ALIAS = "refundRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RefundRequest exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RefundRequestPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}