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

import com.esq.bus.reservation.slayers.model.AuditLog;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the audit log service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.AuditLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogPersistence
 * @generated
 */
public class AuditLogUtil {

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
	public static void clearCache(AuditLog auditLog) {
		getPersistence().clearCache(auditLog);
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
	public static Map<Serializable, AuditLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AuditLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuditLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuditLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AuditLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AuditLog update(AuditLog auditLog) {
		return getPersistence().update(auditLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AuditLog update(
		AuditLog auditLog, ServiceContext serviceContext) {

		return getPersistence().update(auditLog, serviceContext);
	}

	/**
	 * Returns all the audit logs where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @return the matching audit logs
	 */
	public static List<AuditLog> findByactionDate(Date actionDate) {
		return getPersistence().findByactionDate(actionDate);
	}

	/**
	 * Returns a range of all the audit logs where actionDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param actionDate the action date
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @return the range of matching audit logs
	 */
	public static List<AuditLog> findByactionDate(
		Date actionDate, int start, int end) {

		return getPersistence().findByactionDate(actionDate, start, end);
	}

	/**
	 * Returns an ordered range of all the audit logs where actionDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param actionDate the action date
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logs
	 */
	public static List<AuditLog> findByactionDate(
		Date actionDate, int start, int end,
		OrderByComparator<AuditLog> orderByComparator) {

		return getPersistence().findByactionDate(
			actionDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logs where actionDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param actionDate the action date
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logs
	 */
	public static List<AuditLog> findByactionDate(
		Date actionDate, int start, int end,
		OrderByComparator<AuditLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByactionDate(
			actionDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit log
	 * @throws NoSuchAuditLogException if a matching audit log could not be found
	 */
	public static AuditLog findByactionDate_First(
			Date actionDate, OrderByComparator<AuditLog> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAuditLogException {

		return getPersistence().findByactionDate_First(
			actionDate, orderByComparator);
	}

	/**
	 * Returns the first audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit log, or <code>null</code> if a matching audit log could not be found
	 */
	public static AuditLog fetchByactionDate_First(
		Date actionDate, OrderByComparator<AuditLog> orderByComparator) {

		return getPersistence().fetchByactionDate_First(
			actionDate, orderByComparator);
	}

	/**
	 * Returns the last audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit log
	 * @throws NoSuchAuditLogException if a matching audit log could not be found
	 */
	public static AuditLog findByactionDate_Last(
			Date actionDate, OrderByComparator<AuditLog> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAuditLogException {

		return getPersistence().findByactionDate_Last(
			actionDate, orderByComparator);
	}

	/**
	 * Returns the last audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit log, or <code>null</code> if a matching audit log could not be found
	 */
	public static AuditLog fetchByactionDate_Last(
		Date actionDate, OrderByComparator<AuditLog> orderByComparator) {

		return getPersistence().fetchByactionDate_Last(
			actionDate, orderByComparator);
	}

	/**
	 * Returns the audit logs before and after the current audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param auditId the primary key of the current audit log
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	public static AuditLog[] findByactionDate_PrevAndNext(
			long auditId, Date actionDate,
			OrderByComparator<AuditLog> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAuditLogException {

		return getPersistence().findByactionDate_PrevAndNext(
			auditId, actionDate, orderByComparator);
	}

	/**
	 * Removes all the audit logs where actionDate = &#63; from the database.
	 *
	 * @param actionDate the action date
	 */
	public static void removeByactionDate(Date actionDate) {
		getPersistence().removeByactionDate(actionDate);
	}

	/**
	 * Returns the number of audit logs where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @return the number of matching audit logs
	 */
	public static int countByactionDate(Date actionDate) {
		return getPersistence().countByactionDate(actionDate);
	}

	/**
	 * Caches the audit log in the entity cache if it is enabled.
	 *
	 * @param auditLog the audit log
	 */
	public static void cacheResult(AuditLog auditLog) {
		getPersistence().cacheResult(auditLog);
	}

	/**
	 * Caches the audit logs in the entity cache if it is enabled.
	 *
	 * @param auditLogs the audit logs
	 */
	public static void cacheResult(List<AuditLog> auditLogs) {
		getPersistence().cacheResult(auditLogs);
	}

	/**
	 * Creates a new audit log with the primary key. Does not add the audit log to the database.
	 *
	 * @param auditId the primary key for the new audit log
	 * @return the new audit log
	 */
	public static AuditLog create(long auditId) {
		return getPersistence().create(auditId);
	}

	/**
	 * Removes the audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log that was removed
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	public static AuditLog remove(long auditId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAuditLogException {

		return getPersistence().remove(auditId);
	}

	public static AuditLog updateImpl(AuditLog auditLog) {
		return getPersistence().updateImpl(auditLog);
	}

	/**
	 * Returns the audit log with the primary key or throws a <code>NoSuchAuditLogException</code> if it could not be found.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	public static AuditLog findByPrimaryKey(long auditId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAuditLogException {

		return getPersistence().findByPrimaryKey(auditId);
	}

	/**
	 * Returns the audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log, or <code>null</code> if a audit log with the primary key could not be found
	 */
	public static AuditLog fetchByPrimaryKey(long auditId) {
		return getPersistence().fetchByPrimaryKey(auditId);
	}

	/**
	 * Returns all the audit logs.
	 *
	 * @return the audit logs
	 */
	public static List<AuditLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @return the range of audit logs
	 */
	public static List<AuditLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audit logs
	 */
	public static List<AuditLog> findAll(
		int start, int end, OrderByComparator<AuditLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of audit logs
	 */
	public static List<AuditLog> findAll(
		int start, int end, OrderByComparator<AuditLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the audit logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of audit logs.
	 *
	 * @return the number of audit logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AuditLogPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AuditLogPersistence _persistence;

}