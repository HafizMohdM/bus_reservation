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

import com.esq.bus.reservation.slayers.exception.NoSuchTransactionLogException;
import com.esq.bus.reservation.slayers.model.TransactionLog;
import com.esq.bus.reservation.slayers.model.TransactionLogTable;
import com.esq.bus.reservation.slayers.model.impl.TransactionLogImpl;
import com.esq.bus.reservation.slayers.model.impl.TransactionLogModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.TransactionLogPersistence;
import com.esq.bus.reservation.slayers.service.persistence.TransactionLogUtil;
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
 * The persistence implementation for the transaction log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TransactionLogPersistence.class)
public class TransactionLogPersistenceImpl
	extends BasePersistenceImpl<TransactionLog>
	implements TransactionLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TransactionLogUtil</code> to access the transaction log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TransactionLogImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TransactionLogPersistenceImpl() {
		setModelClass(TransactionLog.class);

		setModelImplClass(TransactionLogImpl.class);
		setModelPKClass(long.class);

		setTable(TransactionLogTable.INSTANCE);
	}

	/**
	 * Caches the transaction log in the entity cache if it is enabled.
	 *
	 * @param transactionLog the transaction log
	 */
	@Override
	public void cacheResult(TransactionLog transactionLog) {
		entityCache.putResult(
			TransactionLogImpl.class, transactionLog.getPrimaryKey(),
			transactionLog);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the transaction logs in the entity cache if it is enabled.
	 *
	 * @param transactionLogs the transaction logs
	 */
	@Override
	public void cacheResult(List<TransactionLog> transactionLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (transactionLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TransactionLog transactionLog : transactionLogs) {
			if (entityCache.getResult(
					TransactionLogImpl.class, transactionLog.getPrimaryKey()) ==
						null) {

				cacheResult(transactionLog);
			}
		}
	}

	/**
	 * Clears the cache for all transaction logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TransactionLogImpl.class);

		finderCache.clearCache(TransactionLogImpl.class);
	}

	/**
	 * Clears the cache for the transaction log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TransactionLog transactionLog) {
		entityCache.removeResult(TransactionLogImpl.class, transactionLog);
	}

	@Override
	public void clearCache(List<TransactionLog> transactionLogs) {
		for (TransactionLog transactionLog : transactionLogs) {
			entityCache.removeResult(TransactionLogImpl.class, transactionLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TransactionLogImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TransactionLogImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new transaction log with the primary key. Does not add the transaction log to the database.
	 *
	 * @param logId the primary key for the new transaction log
	 * @return the new transaction log
	 */
	@Override
	public TransactionLog create(long logId) {
		TransactionLog transactionLog = new TransactionLogImpl();

		transactionLog.setNew(true);
		transactionLog.setPrimaryKey(logId);

		return transactionLog;
	}

	/**
	 * Removes the transaction log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log that was removed
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	@Override
	public TransactionLog remove(long logId)
		throws NoSuchTransactionLogException {

		return remove((Serializable)logId);
	}

	/**
	 * Removes the transaction log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transaction log
	 * @return the transaction log that was removed
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	@Override
	public TransactionLog remove(Serializable primaryKey)
		throws NoSuchTransactionLogException {

		Session session = null;

		try {
			session = openSession();

			TransactionLog transactionLog = (TransactionLog)session.get(
				TransactionLogImpl.class, primaryKey);

			if (transactionLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransactionLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(transactionLog);
		}
		catch (NoSuchTransactionLogException noSuchEntityException) {
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
	protected TransactionLog removeImpl(TransactionLog transactionLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(transactionLog)) {
				transactionLog = (TransactionLog)session.get(
					TransactionLogImpl.class,
					transactionLog.getPrimaryKeyObj());
			}

			if (transactionLog != null) {
				session.delete(transactionLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (transactionLog != null) {
			clearCache(transactionLog);
		}

		return transactionLog;
	}

	@Override
	public TransactionLog updateImpl(TransactionLog transactionLog) {
		boolean isNew = transactionLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(transactionLog);
			}
			else {
				transactionLog = (TransactionLog)session.merge(transactionLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TransactionLogImpl.class, transactionLog, false, true);

		if (isNew) {
			transactionLog.setNew(false);
		}

		transactionLog.resetOriginalValues();

		return transactionLog;
	}

	/**
	 * Returns the transaction log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaction log
	 * @return the transaction log
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	@Override
	public TransactionLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTransactionLogException {

		TransactionLog transactionLog = fetchByPrimaryKey(primaryKey);

		if (transactionLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTransactionLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return transactionLog;
	}

	/**
	 * Returns the transaction log with the primary key or throws a <code>NoSuchTransactionLogException</code> if it could not be found.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	@Override
	public TransactionLog findByPrimaryKey(long logId)
		throws NoSuchTransactionLogException {

		return findByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns the transaction log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log, or <code>null</code> if a transaction log with the primary key could not be found
	 */
	@Override
	public TransactionLog fetchByPrimaryKey(long logId) {
		return fetchByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns all the transaction logs.
	 *
	 * @return the transaction logs
	 */
	@Override
	public List<TransactionLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @return the range of transaction logs
	 */
	@Override
	public List<TransactionLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of transaction logs
	 */
	@Override
	public List<TransactionLog> findAll(
		int start, int end,
		OrderByComparator<TransactionLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of transaction logs
	 */
	@Override
	public List<TransactionLog> findAll(
		int start, int end, OrderByComparator<TransactionLog> orderByComparator,
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

		List<TransactionLog> list = null;

		if (useFinderCache) {
			list = (List<TransactionLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRANSACTIONLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSACTIONLOG;

				sql = sql.concat(TransactionLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TransactionLog>)QueryUtil.list(
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
	 * Removes all the transaction logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TransactionLog transactionLog : findAll()) {
			remove(transactionLog);
		}
	}

	/**
	 * Returns the number of transaction logs.
	 *
	 * @return the number of transaction logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRANSACTIONLOG);

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
		return _SQL_SELECT_TRANSACTIONLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TransactionLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the transaction log persistence.
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

		_setTransactionLogUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTransactionLogUtilPersistence(null);

		entityCache.removeCache(TransactionLogImpl.class.getName());
	}

	private void _setTransactionLogUtilPersistence(
		TransactionLogPersistence transactionLogPersistence) {

		try {
			Field field = TransactionLogUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, transactionLogPersistence);
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

	private static final String _SQL_SELECT_TRANSACTIONLOG =
		"SELECT transactionLog FROM TransactionLog transactionLog";

	private static final String _SQL_COUNT_TRANSACTIONLOG =
		"SELECT COUNT(transactionLog) FROM TransactionLog transactionLog";

	private static final String _ORDER_BY_ENTITY_ALIAS = "transactionLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TransactionLog exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TransactionLogPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}