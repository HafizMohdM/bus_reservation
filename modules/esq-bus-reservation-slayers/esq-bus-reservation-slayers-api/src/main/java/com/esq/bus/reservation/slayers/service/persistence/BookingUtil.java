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

import com.esq.bus.reservation.slayers.model.Booking;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the booking service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.BookingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingPersistence
 * @generated
 */
public class BookingUtil {

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
	public static void clearCache(Booking booking) {
		getPersistence().clearCache(booking);
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
	public static Map<Serializable, Booking> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Booking> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Booking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Booking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Booking> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Booking update(Booking booking) {
		return getPersistence().update(booking);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Booking update(
		Booking booking, ServiceContext serviceContext) {

		return getPersistence().update(booking, serviceContext);
	}

	/**
	 * Returns all the bookings where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the matching bookings
	 */
	public static List<Booking> findByscheduleId(long scheduleId) {
		return getPersistence().findByscheduleId(scheduleId);
	}

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
	public static List<Booking> findByscheduleId(
		long scheduleId, int start, int end) {

		return getPersistence().findByscheduleId(scheduleId, start, end);
	}

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
	public static List<Booking> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Booking> orderByComparator) {

		return getPersistence().findByscheduleId(
			scheduleId, start, end, orderByComparator);
	}

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
	public static List<Booking> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Booking> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByscheduleId(
			scheduleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public static Booking findByscheduleId_First(
			long scheduleId, OrderByComparator<Booking> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findByscheduleId_First(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the first booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public static Booking fetchByscheduleId_First(
		long scheduleId, OrderByComparator<Booking> orderByComparator) {

		return getPersistence().fetchByscheduleId_First(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the last booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public static Booking findByscheduleId_Last(
			long scheduleId, OrderByComparator<Booking> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findByscheduleId_Last(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the last booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public static Booking fetchByscheduleId_Last(
		long scheduleId, OrderByComparator<Booking> orderByComparator) {

		return getPersistence().fetchByscheduleId_Last(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the bookings before and after the current booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param bookingId the primary key of the current booking
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public static Booking[] findByscheduleId_PrevAndNext(
			long bookingId, long scheduleId,
			OrderByComparator<Booking> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findByscheduleId_PrevAndNext(
			bookingId, scheduleId, orderByComparator);
	}

	/**
	 * Removes all the bookings where scheduleId = &#63; from the database.
	 *
	 * @param scheduleId the schedule ID
	 */
	public static void removeByscheduleId(long scheduleId) {
		getPersistence().removeByscheduleId(scheduleId);
	}

	/**
	 * Returns the number of bookings where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the number of matching bookings
	 */
	public static int countByscheduleId(long scheduleId) {
		return getPersistence().countByscheduleId(scheduleId);
	}

	/**
	 * Returns all the bookings where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @return the matching bookings
	 */
	public static List<Booking> findBypassengerId(long passengerId) {
		return getPersistence().findBypassengerId(passengerId);
	}

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
	public static List<Booking> findBypassengerId(
		long passengerId, int start, int end) {

		return getPersistence().findBypassengerId(passengerId, start, end);
	}

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
	public static List<Booking> findBypassengerId(
		long passengerId, int start, int end,
		OrderByComparator<Booking> orderByComparator) {

		return getPersistence().findBypassengerId(
			passengerId, start, end, orderByComparator);
	}

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
	public static List<Booking> findBypassengerId(
		long passengerId, int start, int end,
		OrderByComparator<Booking> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBypassengerId(
			passengerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public static Booking findBypassengerId_First(
			long passengerId, OrderByComparator<Booking> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findBypassengerId_First(
			passengerId, orderByComparator);
	}

	/**
	 * Returns the first booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public static Booking fetchBypassengerId_First(
		long passengerId, OrderByComparator<Booking> orderByComparator) {

		return getPersistence().fetchBypassengerId_First(
			passengerId, orderByComparator);
	}

	/**
	 * Returns the last booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	public static Booking findBypassengerId_Last(
			long passengerId, OrderByComparator<Booking> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findBypassengerId_Last(
			passengerId, orderByComparator);
	}

	/**
	 * Returns the last booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking, or <code>null</code> if a matching booking could not be found
	 */
	public static Booking fetchBypassengerId_Last(
		long passengerId, OrderByComparator<Booking> orderByComparator) {

		return getPersistence().fetchBypassengerId_Last(
			passengerId, orderByComparator);
	}

	/**
	 * Returns the bookings before and after the current booking in the ordered set where passengerId = &#63;.
	 *
	 * @param bookingId the primary key of the current booking
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public static Booking[] findBypassengerId_PrevAndNext(
			long bookingId, long passengerId,
			OrderByComparator<Booking> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findBypassengerId_PrevAndNext(
			bookingId, passengerId, orderByComparator);
	}

	/**
	 * Removes all the bookings where passengerId = &#63; from the database.
	 *
	 * @param passengerId the passenger ID
	 */
	public static void removeBypassengerId(long passengerId) {
		getPersistence().removeBypassengerId(passengerId);
	}

	/**
	 * Returns the number of bookings where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @return the number of matching bookings
	 */
	public static int countBypassengerId(long passengerId) {
		return getPersistence().countBypassengerId(passengerId);
	}

	/**
	 * Caches the booking in the entity cache if it is enabled.
	 *
	 * @param booking the booking
	 */
	public static void cacheResult(Booking booking) {
		getPersistence().cacheResult(booking);
	}

	/**
	 * Caches the bookings in the entity cache if it is enabled.
	 *
	 * @param bookings the bookings
	 */
	public static void cacheResult(List<Booking> bookings) {
		getPersistence().cacheResult(bookings);
	}

	/**
	 * Creates a new booking with the primary key. Does not add the booking to the database.
	 *
	 * @param bookingId the primary key for the new booking
	 * @return the new booking
	 */
	public static Booking create(long bookingId) {
		return getPersistence().create(bookingId);
	}

	/**
	 * Removes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking that was removed
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public static Booking remove(long bookingId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().remove(bookingId);
	}

	public static Booking updateImpl(Booking booking) {
		return getPersistence().updateImpl(booking);
	}

	/**
	 * Returns the booking with the primary key or throws a <code>NoSuchBookingException</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	public static Booking findByPrimaryKey(long bookingId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBookingException {

		return getPersistence().findByPrimaryKey(bookingId);
	}

	/**
	 * Returns the booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking, or <code>null</code> if a booking with the primary key could not be found
	 */
	public static Booking fetchByPrimaryKey(long bookingId) {
		return getPersistence().fetchByPrimaryKey(bookingId);
	}

	/**
	 * Returns all the bookings.
	 *
	 * @return the bookings
	 */
	public static List<Booking> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Booking> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Booking> findAll(
		int start, int end, OrderByComparator<Booking> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Booking> findAll(
		int start, int end, OrderByComparator<Booking> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bookings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bookings.
	 *
	 * @return the number of bookings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookingPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BookingPersistence _persistence;

}