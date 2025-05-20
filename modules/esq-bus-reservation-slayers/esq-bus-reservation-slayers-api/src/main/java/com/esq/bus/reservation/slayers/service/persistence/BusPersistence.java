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

import com.esq.bus.reservation.slayers.exception.NoSuchBusException;
import com.esq.bus.reservation.slayers.model.Bus;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusUtil
 * @generated
 */
@ProviderType
public interface BusPersistence extends BasePersistence<Bus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusUtil} to access the bus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the buses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching buses
	 */
	public java.util.List<Bus> findByuserId(long userId);

	/**
	 * Returns a range of all the buses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @return the range of matching buses
	 */
	public java.util.List<Bus> findByuserId(long userId, int start, int end);

	/**
	 * Returns an ordered range of all the buses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching buses
	 */
	public java.util.List<Bus> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the buses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching buses
	 */
	public java.util.List<Bus> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus
	 * @throws NoSuchBusException if a matching bus could not be found
	 */
	public Bus findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Bus>
				orderByComparator)
		throws NoSuchBusException;

	/**
	 * Returns the first bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus, or <code>null</code> if a matching bus could not be found
	 */
	public Bus fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Bus>
			orderByComparator);

	/**
	 * Returns the last bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus
	 * @throws NoSuchBusException if a matching bus could not be found
	 */
	public Bus findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Bus>
				orderByComparator)
		throws NoSuchBusException;

	/**
	 * Returns the last bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus, or <code>null</code> if a matching bus could not be found
	 */
	public Bus fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Bus>
			orderByComparator);

	/**
	 * Returns the buses before and after the current bus in the ordered set where userId = &#63;.
	 *
	 * @param busId the primary key of the current bus
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	public Bus[] findByuserId_PrevAndNext(
			long busId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Bus>
				orderByComparator)
		throws NoSuchBusException;

	/**
	 * Removes all the buses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of buses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching buses
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the bus in the entity cache if it is enabled.
	 *
	 * @param bus the bus
	 */
	public void cacheResult(Bus bus);

	/**
	 * Caches the buses in the entity cache if it is enabled.
	 *
	 * @param buses the buses
	 */
	public void cacheResult(java.util.List<Bus> buses);

	/**
	 * Creates a new bus with the primary key. Does not add the bus to the database.
	 *
	 * @param busId the primary key for the new bus
	 * @return the new bus
	 */
	public Bus create(long busId);

	/**
	 * Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus that was removed
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	public Bus remove(long busId) throws NoSuchBusException;

	public Bus updateImpl(Bus bus);

	/**
	 * Returns the bus with the primary key or throws a <code>NoSuchBusException</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	public Bus findByPrimaryKey(long busId) throws NoSuchBusException;

	/**
	 * Returns the bus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus, or <code>null</code> if a bus with the primary key could not be found
	 */
	public Bus fetchByPrimaryKey(long busId);

	/**
	 * Returns all the buses.
	 *
	 * @return the buses
	 */
	public java.util.List<Bus> findAll();

	/**
	 * Returns a range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @return the range of buses
	 */
	public java.util.List<Bus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of buses
	 */
	public java.util.List<Bus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of buses
	 */
	public java.util.List<Bus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the buses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of buses.
	 *
	 * @return the number of buses
	 */
	public int countAll();

}