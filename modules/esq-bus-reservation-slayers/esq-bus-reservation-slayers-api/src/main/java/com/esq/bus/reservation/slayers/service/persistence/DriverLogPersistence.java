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

import com.esq.bus.reservation.slayers.exception.NoSuchDriverLogException;
import com.esq.bus.reservation.slayers.model.DriverLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the driver log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverLogUtil
 * @generated
 */
@ProviderType
public interface DriverLogPersistence extends BasePersistence<DriverLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DriverLogUtil} to access the driver log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the driver log in the entity cache if it is enabled.
	 *
	 * @param driverLog the driver log
	 */
	public void cacheResult(DriverLog driverLog);

	/**
	 * Caches the driver logs in the entity cache if it is enabled.
	 *
	 * @param driverLogs the driver logs
	 */
	public void cacheResult(java.util.List<DriverLog> driverLogs);

	/**
	 * Creates a new driver log with the primary key. Does not add the driver log to the database.
	 *
	 * @param logId the primary key for the new driver log
	 * @return the new driver log
	 */
	public DriverLog create(long logId);

	/**
	 * Removes the driver log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log that was removed
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	public DriverLog remove(long logId) throws NoSuchDriverLogException;

	public DriverLog updateImpl(DriverLog driverLog);

	/**
	 * Returns the driver log with the primary key or throws a <code>NoSuchDriverLogException</code> if it could not be found.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log
	 * @throws NoSuchDriverLogException if a driver log with the primary key could not be found
	 */
	public DriverLog findByPrimaryKey(long logId)
		throws NoSuchDriverLogException;

	/**
	 * Returns the driver log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log, or <code>null</code> if a driver log with the primary key could not be found
	 */
	public DriverLog fetchByPrimaryKey(long logId);

	/**
	 * Returns all the driver logs.
	 *
	 * @return the driver logs
	 */
	public java.util.List<DriverLog> findAll();

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
	public java.util.List<DriverLog> findAll(int start, int end);

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
	public java.util.List<DriverLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DriverLog>
			orderByComparator);

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
	public java.util.List<DriverLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DriverLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the driver logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of driver logs.
	 *
	 * @return the number of driver logs
	 */
	public int countAll();

}