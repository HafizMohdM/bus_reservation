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

import com.esq.bus.reservation.slayers.exception.NoSuchBookingException;
import com.esq.bus.reservation.slayers.model.Booking;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingUtil
 * @generated
 */
@ProviderType
public interface BookingPersistence extends BasePersistence<Booking> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookingUtil} to access the booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bookings where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the matching bookings
	 */
	public java.util.List<Booking> findByscheduleId(long scheduleId);

	/**
	 * Returns a range of all the bookings where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of matching bookings
	 */
	public java.util.List<Booking> findByscheduleId(
		long scheduleId, int start, int end);

	/**
	 * Returns an ordered range of all the bookings where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookings
	 */
	public java.util.List<Booking> findByscheduleId(
		long scheduleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bookings where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookings
	 */
	public java.util.List<Booking> findByscheduleId(
		long scheduleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public Booking findByscheduleId_First(
			long scheduleId,
			com.liferay.portal.kernel.util.OrderByComparator<Booking>
				orderByComparator)
		throws NoSuchBookingException;

	/**
	 * Returns the first booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public Booking fetchByscheduleId_First(
		long scheduleId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns the last booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public Booking findByscheduleId_Last(
			long scheduleId,
			com.liferay.portal.kernel.util.OrderByComparator<Booking>
				orderByComparator)
		throws NoSuchBookingException;

	/**
	 * Returns the last booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public Booking fetchByscheduleId_Last(
		long scheduleId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns the bookings before and after the current booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param bookingId the primary key of the current booking
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public Booking[] findByscheduleId_PrevAndNext(
			long bookingId, long scheduleId,
			com.liferay.portal.kernel.util.OrderByComparator<Booking>
				orderByComparator)
		throws NoSuchBookingException;

	/**
	 * Removes all the bookings where scheduleId = &#63; from the database.
	 *
	 * @param scheduleId the schedule ID
	 */
	public void removeByscheduleId(long scheduleId);

	/**
	 * Returns the number of bookings where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the number of matching bookings
	 */
	public int countByscheduleId(long scheduleId);

	/**
	 * Returns all the bookings where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @return the matching bookings
	 */
	public java.util.List<Booking> findBypassengerId(long passengerId);

	/**
	 * Returns a range of all the bookings where passengerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param passengerId the passenger ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of matching bookings
	 */
	public java.util.List<Booking> findBypassengerId(
		long passengerId, int start, int end);

	/**
	 * Returns an ordered range of all the bookings where passengerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param passengerId the passenger ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookings
	 */
	public java.util.List<Booking> findBypassengerId(
		long passengerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bookings where passengerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param passengerId the passenger ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookings
	 */
	public java.util.List<Booking> findBypassengerId(
		long passengerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public Booking findBypassengerId_First(
			long passengerId,
			com.liferay.portal.kernel.util.OrderByComparator<Booking>
				orderByComparator)
		throws NoSuchBookingException;

	/**
	 * Returns the first booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public Booking fetchBypassengerId_First(
		long passengerId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns the last booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public Booking findBypassengerId_Last(
			long passengerId,
			com.liferay.portal.kernel.util.OrderByComparator<Booking>
				orderByComparator)
		throws NoSuchBookingException;

	/**
	 * Returns the last booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public Booking fetchBypassengerId_Last(
		long passengerId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns the bookings before and after the current booking in the ordered set where passengerId = &#63;.
	 *
	 * @param bookingId the primary key of the current booking
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public Booking[] findBypassengerId_PrevAndNext(
			long bookingId, long passengerId,
			com.liferay.portal.kernel.util.OrderByComparator<Booking>
				orderByComparator)
		throws NoSuchBookingException;

	/**
	 * Removes all the bookings where passengerId = &#63; from the database.
	 *
	 * @param passengerId the passenger ID
	 */
	public void removeBypassengerId(long passengerId);

	/**
	 * Returns the number of bookings where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @return the number of matching bookings
	 */
	public int countBypassengerId(long passengerId);

	/**
	 * Caches the booking in the entity cache if it is enabled.
	 *
	 * @param booking the booking
	 */
	public void cacheResult(Booking booking);

	/**
	 * Caches the bookings in the entity cache if it is enabled.
	 *
	 * @param bookings the bookings
	 */
	public void cacheResult(java.util.List<Booking> bookings);

	/**
	 * Creates a new booking with the primary key. Does not add the booking to the database.
	 *
	 * @param bookingId the primary key for the new booking
	 * @return the new booking
	 */
	public Booking create(long bookingId);

	/**
	 * Removes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking that was removed
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public Booking remove(long bookingId) throws NoSuchBookingException;

	public Booking updateImpl(Booking booking);

	/**
	 * Returns the booking with the primary key or throws a <code>NoSuchBookingException</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public Booking findByPrimaryKey(long bookingId)
		throws NoSuchBookingException;

	/**
	 * Returns the booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking, or <code>null</code> if a booking with the primary key could not be found
	 */
	public Booking fetchByPrimaryKey(long bookingId);

	/**
	 * Returns all the bookings.
	 *
	 * @return the bookings
	 */
	public java.util.List<Booking> findAll();

	/**
	 * Returns a range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of bookings
	 */
	public java.util.List<Booking> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bookings
	 */
	public java.util.List<Booking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bookings
	 */
	public java.util.List<Booking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bookings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bookings.
	 *
	 * @return the number of bookings
	 */
	public int countAll();

}