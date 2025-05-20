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

import com.esq.bus.reservation.slayers.exception.NoSuchSeatException;
import com.esq.bus.reservation.slayers.model.Seat;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the seat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SeatUtil
 * @generated
 */
@ProviderType
public interface SeatPersistence extends BasePersistence<Seat> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SeatUtil} to access the seat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the seats where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the matching seats
	 */
	public java.util.List<Seat> findByscheduleId(long scheduleId);

	/**
	 * Returns a range of all the seats where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @return the range of matching seats
	 */
	public java.util.List<Seat> findByscheduleId(
		long scheduleId, int start, int end);

	/**
	 * Returns an ordered range of all the seats where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching seats
	 */
	public java.util.List<Seat> findByscheduleId(
		long scheduleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Seat>
			orderByComparator);

	/**
	 * Returns an ordered range of all the seats where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching seats
	 */
	public java.util.List<Seat> findByscheduleId(
		long scheduleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Seat>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat
	 * @throws NoSuchSeatException if a matching seat could not be found
	 */
	public Seat findByscheduleId_First(
			long scheduleId,
			com.liferay.portal.kernel.util.OrderByComparator<Seat>
				orderByComparator)
		throws NoSuchSeatException;

	/**
	 * Returns the first seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat, or <code>null</code> if a matching seat could not be found
	 */
	public Seat fetchByscheduleId_First(
		long scheduleId,
		com.liferay.portal.kernel.util.OrderByComparator<Seat>
			orderByComparator);

	/**
	 * Returns the last seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat
	 * @throws NoSuchSeatException if a matching seat could not be found
	 */
	public Seat findByscheduleId_Last(
			long scheduleId,
			com.liferay.portal.kernel.util.OrderByComparator<Seat>
				orderByComparator)
		throws NoSuchSeatException;

	/**
	 * Returns the last seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat, or <code>null</code> if a matching seat could not be found
	 */
	public Seat fetchByscheduleId_Last(
		long scheduleId,
		com.liferay.portal.kernel.util.OrderByComparator<Seat>
			orderByComparator);

	/**
	 * Returns the seats before and after the current seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param seatId the primary key of the current seat
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	public Seat[] findByscheduleId_PrevAndNext(
			long seatId, long scheduleId,
			com.liferay.portal.kernel.util.OrderByComparator<Seat>
				orderByComparator)
		throws NoSuchSeatException;

	/**
	 * Removes all the seats where scheduleId = &#63; from the database.
	 *
	 * @param scheduleId the schedule ID
	 */
	public void removeByscheduleId(long scheduleId);

	/**
	 * Returns the number of seats where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the number of matching seats
	 */
	public int countByscheduleId(long scheduleId);

	/**
	 * Caches the seat in the entity cache if it is enabled.
	 *
	 * @param seat the seat
	 */
	public void cacheResult(Seat seat);

	/**
	 * Caches the seats in the entity cache if it is enabled.
	 *
	 * @param seats the seats
	 */
	public void cacheResult(java.util.List<Seat> seats);

	/**
	 * Creates a new seat with the primary key. Does not add the seat to the database.
	 *
	 * @param seatId the primary key for the new seat
	 * @return the new seat
	 */
	public Seat create(long seatId);

	/**
	 * Removes the seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat that was removed
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	public Seat remove(long seatId) throws NoSuchSeatException;

	public Seat updateImpl(Seat seat);

	/**
	 * Returns the seat with the primary key or throws a <code>NoSuchSeatException</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	public Seat findByPrimaryKey(long seatId) throws NoSuchSeatException;

	/**
	 * Returns the seat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat, or <code>null</code> if a seat with the primary key could not be found
	 */
	public Seat fetchByPrimaryKey(long seatId);

	/**
	 * Returns all the seats.
	 *
	 * @return the seats
	 */
	public java.util.List<Seat> findAll();

	/**
	 * Returns a range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @return the range of seats
	 */
	public java.util.List<Seat> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of seats
	 */
	public java.util.List<Seat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Seat>
			orderByComparator);

	/**
	 * Returns an ordered range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of seats
	 */
	public java.util.List<Seat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Seat>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the seats from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of seats.
	 *
	 * @return the number of seats
	 */
	public int countAll();

}