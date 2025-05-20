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

import com.esq.bus.reservation.slayers.exception.NoSuchAuditLogException;
import com.esq.bus.reservation.slayers.model.AuditLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the audit log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLogUtil
 * @generated
 */
@ProviderType
public interface AuditLogPersistence extends BasePersistence<AuditLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditLogUtil} to access the audit log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the audit logs where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @return the matching audit logs
	 */
	public java.util.List<AuditLog> findByactionDate(Date actionDate);

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
	public java.util.List<AuditLog> findByactionDate(
		Date actionDate, int start, int end);

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
	public java.util.List<AuditLog> findByactionDate(
		Date actionDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
			orderByComparator);

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
	public java.util.List<AuditLog> findByactionDate(
		Date actionDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit log
	 * @throws NoSuchAuditLogException if a matching audit log could not be found
	 */
	public AuditLog findByactionDate_First(
			Date actionDate,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
				orderByComparator)
		throws NoSuchAuditLogException;

	/**
	 * Returns the first audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit log, or <code>null</code> if a matching audit log could not be found
	 */
	public AuditLog fetchByactionDate_First(
		Date actionDate,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
			orderByComparator);

	/**
	 * Returns the last audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit log
	 * @throws NoSuchAuditLogException if a matching audit log could not be found
	 */
	public AuditLog findByactionDate_Last(
			Date actionDate,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
				orderByComparator)
		throws NoSuchAuditLogException;

	/**
	 * Returns the last audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit log, or <code>null</code> if a matching audit log could not be found
	 */
	public AuditLog fetchByactionDate_Last(
		Date actionDate,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
			orderByComparator);

	/**
	 * Returns the audit logs before and after the current audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param auditId the primary key of the current audit log
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	public AuditLog[] findByactionDate_PrevAndNext(
			long auditId, Date actionDate,
			com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
				orderByComparator)
		throws NoSuchAuditLogException;

	/**
	 * Removes all the audit logs where actionDate = &#63; from the database.
	 *
	 * @param actionDate the action date
	 */
	public void removeByactionDate(Date actionDate);

	/**
	 * Returns the number of audit logs where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @return the number of matching audit logs
	 */
	public int countByactionDate(Date actionDate);

	/**
	 * Caches the audit log in the entity cache if it is enabled.
	 *
	 * @param auditLog the audit log
	 */
	public void cacheResult(AuditLog auditLog);

	/**
	 * Caches the audit logs in the entity cache if it is enabled.
	 *
	 * @param auditLogs the audit logs
	 */
	public void cacheResult(java.util.List<AuditLog> auditLogs);

	/**
	 * Creates a new audit log with the primary key. Does not add the audit log to the database.
	 *
	 * @param auditId the primary key for the new audit log
	 * @return the new audit log
	 */
	public AuditLog create(long auditId);

	/**
	 * Removes the audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log that was removed
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	public AuditLog remove(long auditId) throws NoSuchAuditLogException;

	public AuditLog updateImpl(AuditLog auditLog);

	/**
	 * Returns the audit log with the primary key or throws a <code>NoSuchAuditLogException</code> if it could not be found.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	public AuditLog findByPrimaryKey(long auditId)
		throws NoSuchAuditLogException;

	/**
	 * Returns the audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log, or <code>null</code> if a audit log with the primary key could not be found
	 */
	public AuditLog fetchByPrimaryKey(long auditId);

	/**
	 * Returns all the audit logs.
	 *
	 * @return the audit logs
	 */
	public java.util.List<AuditLog> findAll();

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
	public java.util.List<AuditLog> findAll(int start, int end);

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
	public java.util.List<AuditLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
			orderByComparator);

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
	public java.util.List<AuditLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the audit logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of audit logs.
	 *
	 * @return the number of audit logs
	 */
	public int countAll();

}