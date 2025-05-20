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

import com.esq.bus.reservation.slayers.model.DriverLog;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the driver log service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.DriverLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverLogPersistence
 * @generated
 */
public class DriverLogUtil {

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
	public static void clearCache(DriverLog driverLog) {
		getPersistence().clearCache(driverLog);
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
	public static Map<Serializable, DriverLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DriverLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DriverLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DriverLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DriverLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DriverLog update(DriverLog driverLog) {
		return getPersistence().update(driverLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DriverLog update(
		DriverLog driverLog, ServiceContext serviceContext) {

		return getPersistence().update(driverLog, serviceContext);
	}

	/**
	 * Caches the driver log in the entity cache if it is enabled.
	 *
	 * @param driverLog the driver log
	 */
	public static void cacheResult(DriverLog driverLog) {
		getPersistence().cacheResult(driverLog);
	}

	/**
	 * Caches the driver logs in the entity cache if it is enabled.
	 *
	 * @param driverLogs the driver logs
	 */
	public static void cacheResult(List<DriverLog> driverLogs) {
		getPersistence().cacheResult(driverLogs);
	}

	/**
	 * Creates a new driver log with the primary key. Does not add the driver log to the database.
	 *
	 * @param logId the primary key for the new driver log
	 * @return the new driver log
	 */
	public static DriverLog create(long logId) {
		return getPersistence().create(logId);
	}

	/**
	 * Removes the driver log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log that was removed
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	public static DriverLog remove(long logId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDriverLogException {

		return getPersistence().remove(logId);
	}

	public static DriverLog updateImpl(DriverLog driverLog) {
		return getPersistence().updateImpl(driverLog);
	}

	/**
	 * Returns the driver log with the primary key or throws a <code>NoSuchDriverLogException</code> if it could not be found.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	public static DriverLog findByPrimaryKey(long logId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDriverLogException {

		return getPersistence().findByPrimaryKey(logId);
	}

	/**
	 * Returns the driver log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log, or <code>null</code> if a driver log with the primary key could not be found
	 */
	public static DriverLog fetchByPrimaryKey(long logId) {
		return getPersistence().fetchByPrimaryKey(logId);
	}

	/**
	 * Returns all the driver logs.
	 *
	 * @return the driver logs
	 */
	public static List<DriverLog> findAll() {
		return getPersistence().findAll();
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
	public static List<DriverLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DriverLog> findAll(
		int start, int end, OrderByComparator<DriverLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DriverLog> findAll(
		int start, int end, OrderByComparator<DriverLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the driver logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of driver logs.
	 *
	 * @return the number of driver logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DriverLogPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DriverLogPersistence _persistence;

}