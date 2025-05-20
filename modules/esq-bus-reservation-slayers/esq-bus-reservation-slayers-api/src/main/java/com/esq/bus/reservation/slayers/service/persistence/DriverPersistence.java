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

import com.esq.bus.reservation.slayers.exception.NoSuchDriverException;
import com.esq.bus.reservation.slayers.model.Driver;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the driver service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverUtil
 * @generated
 */
@ProviderType
public interface DriverPersistence extends BasePersistence<Driver> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DriverUtil} to access the driver persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the drivers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching drivers
	 */
	public java.util.List<Driver> findByuserId(long userId);

	/**
	 * Returns a range of all the drivers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	public java.util.List<Driver> findByuserId(long userId, int start, int end);

	/**
	 * Returns an ordered range of all the drivers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns an ordered range of all the drivers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first driver in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the first driver in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the last driver in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the last driver in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the drivers before and after the current driver in the ordered set where userId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver[] findByuserId_PrevAndNext(
			long driverId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Removes all the drivers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of drivers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching drivers
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the driver in the entity cache if it is enabled.
	 *
	 * @param driver the driver
	 */
	public void cacheResult(Driver driver);

	/**
	 * Caches the drivers in the entity cache if it is enabled.
	 *
	 * @param drivers the drivers
	 */
	public void cacheResult(java.util.List<Driver> drivers);

	/**
	 * Creates a new driver with the primary key. Does not add the driver to the database.
	 *
	 * @param driverId the primary key for the new driver
	 * @return the new driver
	 */
	public Driver create(long driverId);

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver remove(long driverId) throws NoSuchDriverException;

	public Driver updateImpl(Driver driver);

	/**
	 * Returns the driver with the primary key or throws a <code>NoSuchDriverException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver findByPrimaryKey(long driverId) throws NoSuchDriverException;

	/**
	 * Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver, or <code>null</code> if a driver with the primary key could not be found
	 */
	public Driver fetchByPrimaryKey(long driverId);

	/**
	 * Returns all the drivers.
	 *
	 * @return the drivers
	 */
	public java.util.List<Driver> findAll();

	/**
	 * Returns a range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of drivers
	 */
	public java.util.List<Driver> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of drivers
	 */
	public java.util.List<Driver> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns an ordered range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of drivers
	 */
	public java.util.List<Driver> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the drivers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of drivers.
	 *
	 * @return the number of drivers
	 */
	public int countAll();

}