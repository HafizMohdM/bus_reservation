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

package com.esq.bus.reservation.slayers.service.persistence;

import com.esq.bus.reservation.slayers.model.TransactionLog;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the transaction log service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.TransactionLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLogPersistence
 * @generated
 */
public class TransactionLogUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TransactionLog transactionLog) {
		getPersistence().clearCache(transactionLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TransactionLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TransactionLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TransactionLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TransactionLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TransactionLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TransactionLog update(TransactionLog transactionLog) {
		return getPersistence().update(transactionLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TransactionLog update(
		TransactionLog transactionLog, ServiceContext serviceContext) {

		return getPersistence().update(transactionLog, serviceContext);
	}

	/**
	 * Caches the transaction log in the entity cache if it is enabled.
	 *
	 * @param transactionLog the transaction log
	 */
	public static void cacheResult(TransactionLog transactionLog) {
		getPersistence().cacheResult(transactionLog);
	}

	/**
	 * Caches the transaction logs in the entity cache if it is enabled.
	 *
	 * @param transactionLogs the transaction logs
	 */
	public static void cacheResult(List<TransactionLog> transactionLogs) {
		getPersistence().cacheResult(transactionLogs);
	}

	/**
	 * Creates a new transaction log with the primary key. Does not add the transaction log to the database.
	 *
	 * @param logId the primary key for the new transaction log
	 * @return the new transaction log
	 */
	public static TransactionLog create(long logId) {
		return getPersistence().create(logId);
	}

	/**
	 * Removes the transaction log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log that was removed
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	public static TransactionLog remove(long logId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTransactionLogException {

		return getPersistence().remove(logId);
	}

	public static TransactionLog updateImpl(TransactionLog transactionLog) {
		return getPersistence().updateImpl(transactionLog);
	}

	/**
	 * Returns the transaction log with the primary key or throws a <code>NoSuchTransactionLogException</code> if it could not be found.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	public static TransactionLog findByPrimaryKey(long logId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTransactionLogException {

		return getPersistence().findByPrimaryKey(logId);
	}

	/**
	 * Returns the transaction log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log, or <code>null</code> if a transaction log with the primary key could not be found
	 */
	public static TransactionLog fetchByPrimaryKey(long logId) {
		return getPersistence().fetchByPrimaryKey(logId);
	}

	/**
	 * Returns all the transaction logs.
	 *
	 * @return the transaction logs
	 */
	public static List<TransactionLog> findAll() {
		return getPersistence().findAll();
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
	public static List<TransactionLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<TransactionLog> findAll(
		int start, int end,
		OrderByComparator<TransactionLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<TransactionLog> findAll(
		int start, int end, OrderByComparator<TransactionLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the transaction logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of transaction logs.
	 *
	 * @return the number of transaction logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TransactionLogPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TransactionLogPersistence _persistence;

}