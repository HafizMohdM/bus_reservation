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

import com.esq.bus.reservation.slayers.exception.NoSuchDriverLogException;
import com.esq.bus.reservation.slayers.model.DriverLog;
import com.esq.bus.reservation.slayers.model.DriverLogTable;
import com.esq.bus.reservation.slayers.model.impl.DriverLogImpl;
import com.esq.bus.reservation.slayers.model.impl.DriverLogModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.DriverLogPersistence;
import com.esq.bus.reservation.slayers.service.persistence.DriverLogUtil;
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
 * The persistence implementation for the driver log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DriverLogPersistence.class)
public class DriverLogPersistenceImpl
	extends BasePersistenceImpl<DriverLog> implements DriverLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DriverLogUtil</code> to access the driver log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DriverLogImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DriverLogPersistenceImpl() {
		setModelClass(DriverLog.class);

		setModelImplClass(DriverLogImpl.class);
		setModelPKClass(long.class);

		setTable(DriverLogTable.INSTANCE);
	}

	/**
	 * Caches the driver log in the entity cache if it is enabled.
	 *
	 * @param driverLog the driver log
	 */
	@Override
	public void cacheResult(DriverLog driverLog) {
		entityCache.putResult(
			DriverLogImpl.class, driverLog.getPrimaryKey(), driverLog);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the driver logs in the entity cache if it is enabled.
	 *
	 * @param driverLogs the driver logs
	 */
	@Override
	public void cacheResult(List<DriverLog> driverLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (driverLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DriverLog driverLog : driverLogs) {
			if (entityCache.getResult(
					DriverLogImpl.class, driverLog.getPrimaryKey()) == null) {

				cacheResult(driverLog);
			}
		}
	}

	/**
	 * Clears the cache for all driver logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DriverLogImpl.class);

		finderCache.clearCache(DriverLogImpl.class);
	}

	/**
	 * Clears the cache for the driver log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DriverLog driverLog) {
		entityCache.removeResult(DriverLogImpl.class, driverLog);
	}

	@Override
	public void clearCache(List<DriverLog> driverLogs) {
		for (DriverLog driverLog : driverLogs) {
			entityCache.removeResult(DriverLogImpl.class, driverLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DriverLogImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DriverLogImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new driver log with the primary key. Does not add the driver log to the database.
	 *
	 * @param logId the primary key for the new driver log
	 * @return the new driver log
	 */
	@Override
	public DriverLog create(long logId) {
		DriverLog driverLog = new DriverLogImpl();

		driverLog.setNew(true);
		driverLog.setPrimaryKey(logId);

		return driverLog;
	}

	/**
	 * Removes the driver log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log that was removed
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	@Override
	public DriverLog remove(long logId) throws NoSuchDriverLogException {
		return remove((Serializable)logId);
	}

	/**
	 * Removes the driver log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the driver log
	 * @return the driver log that was removed
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	@Override
	public DriverLog remove(Serializable primaryKey)
		throws NoSuchDriverLogException {

		Session session = null;

		try {
			session = openSession();

			DriverLog driverLog = (DriverLog)session.get(
				DriverLogImpl.class, primaryKey);

			if (driverLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDriverLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(driverLog);
		}
		catch (NoSuchDriverLogException noSuchEntityException) {
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
	protected DriverLog removeImpl(DriverLog driverLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(driverLog)) {
				driverLog = (DriverLog)session.get(
					DriverLogImpl.class, driverLog.getPrimaryKeyObj());
			}

			if (driverLog != null) {
				session.delete(driverLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (driverLog != null) {
			clearCache(driverLog);
		}

		return driverLog;
	}

	@Override
	public DriverLog updateImpl(DriverLog driverLog) {
		boolean isNew = driverLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(driverLog);
			}
			else {
				driverLog = (DriverLog)session.merge(driverLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DriverLogImpl.class, driverLog, false, true);

		if (isNew) {
			driverLog.setNew(false);
		}

		driverLog.resetOriginalValues();

		return driverLog;
	}

	/**
	 * Returns the driver log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the driver log
	 * @return the driver log
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	@Override
	public DriverLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDriverLogException {

		DriverLog driverLog = fetchByPrimaryKey(primaryKey);

		if (driverLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDriverLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return driverLog;
	}

	/**
	 * Returns the driver log with the primary key or throws a <code>NoSuchDriverLogException</code> if it could not be found.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	@Override
	public DriverLog findByPrimaryKey(long logId)
		throws NoSuchDriverLogException {

		return findByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns the driver log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log, or <code>null</code> if a driver log with the primary key could not be found
	 */
	@Override
	public DriverLog fetchByPrimaryKey(long logId) {
		return fetchByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns all the driver logs.
	 *
	 * @return the driver logs
	 */
	@Override
	public List<DriverLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the driver logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver logs
	 * @param end the upper bound of the range of driver logs (not inclusive)
	 * @return the range of driver logs
	 */
	@Override
	public List<DriverLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the driver logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver logs
	 * @param end the upper bound of the range of driver logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of driver logs
	 */
	@Override
	public List<DriverLog> findAll(
		int start, int end, OrderByComparator<DriverLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the driver logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver logs
	 * @param end the upper bound of the range of driver logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of driver logs
	 */
	@Override
	public List<DriverLog> findAll(
		int start, int end, OrderByComparator<DriverLog> orderByComparator,
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

		List<DriverLog> list = null;

		if (useFinderCache) {
			list = (List<DriverLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DRIVERLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DRIVERLOG;

				sql = sql.concat(DriverLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DriverLog>)QueryUtil.list(
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
	 * Removes all the driver logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DriverLog driverLog : findAll()) {
			remove(driverLog);
		}
	}

	/**
	 * Returns the number of driver logs.
	 *
	 * @return the number of driver logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DRIVERLOG);

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
		return "logId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DRIVERLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DriverLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the driver log persistence.
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

		_setDriverLogUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDriverLogUtilPersistence(null);

		entityCache.removeCache(DriverLogImpl.class.getName());
	}

	private void _setDriverLogUtilPersistence(
		DriverLogPersistence driverLogPersistence) {

		try {
			Field field = DriverLogUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, driverLogPersistence);
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

	private static final String _SQL_SELECT_DRIVERLOG =
		"SELECT driverLog FROM DriverLog driverLog";

	private static final String _SQL_COUNT_DRIVERLOG =
		"SELECT COUNT(driverLog) FROM DriverLog driverLog";

	private static final String _ORDER_BY_ENTITY_ALIAS = "driverLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DriverLog exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DriverLogPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}