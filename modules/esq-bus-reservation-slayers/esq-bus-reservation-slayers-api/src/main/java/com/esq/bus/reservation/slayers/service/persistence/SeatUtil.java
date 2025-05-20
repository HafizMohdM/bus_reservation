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

import com.esq.bus.reservation.slayers.model.Seat;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the seat service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.SeatPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SeatPersistence
 * @generated
 */
public class SeatUtil {

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
	public static void clearCache(Seat seat) {
		getPersistence().clearCache(seat);
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
	public static Map<Serializable, Seat> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Seat> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Seat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Seat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Seat> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Seat update(Seat seat) {
		return getPersistence().update(seat);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Seat update(Seat seat, ServiceContext serviceContext) {
		return getPersistence().update(seat, serviceContext);
	}

	/**
	 * Returns all the seats where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the matching seats
	 */
	public static List<Seat> findByscheduleId(long scheduleId) {
		return getPersistence().findByscheduleId(scheduleId);
	}

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
	public static List<Seat> findByscheduleId(
		long scheduleId, int start, int end) {

		return getPersistence().findByscheduleId(scheduleId, start, end);
	}

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
	public static List<Seat> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Seat> orderByComparator) {

		return getPersistence().findByscheduleId(
			scheduleId, start, end, orderByComparator);
	}

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
	public static List<Seat> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Seat> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByscheduleId(
			scheduleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat
	 * @throws NoSuchSeatException if a matching seat could not be found
	 */
	public static Seat findByscheduleId_First(
			long scheduleId, OrderByComparator<Seat> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.NoSuchSeatException {

		return getPersistence().findByscheduleId_First(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the first seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat, or <code>null</code> if a matching seat could not be found
	 */
	public static Seat fetchByscheduleId_First(
		long scheduleId, OrderByComparator<Seat> orderByComparator) {

		return getPersistence().fetchByscheduleId_First(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the last seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat
	 * @throws NoSuchSeatException if a matching seat could not be found
	 */
	public static Seat findByscheduleId_Last(
			long scheduleId, OrderByComparator<Seat> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.NoSuchSeatException {

		return getPersistence().findByscheduleId_Last(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the last seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat, or <code>null</code> if a matching seat could not be found
	 */
	public static Seat fetchByscheduleId_Last(
		long scheduleId, OrderByComparator<Seat> orderByComparator) {

		return getPersistence().fetchByscheduleId_Last(
			scheduleId, orderByComparator);
	}

	/**
	 * Returns the seats before and after the current seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param seatId the primary key of the current seat
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	public static Seat[] findByscheduleId_PrevAndNext(
			long seatId, long scheduleId,
			OrderByComparator<Seat> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.NoSuchSeatException {

		return getPersistence().findByscheduleId_PrevAndNext(
			seatId, scheduleId, orderByComparator);
	}

	/**
	 * Removes all the seats where scheduleId = &#63; from the database.
	 *
	 * @param scheduleId the schedule ID
	 */
	public static void removeByscheduleId(long scheduleId) {
		getPersistence().removeByscheduleId(scheduleId);
	}

	/**
	 * Returns the number of seats where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the number of matching seats
	 */
	public static int countByscheduleId(long scheduleId) {
		return getPersistence().countByscheduleId(scheduleId);
	}

	/**
	 * Caches the seat in the entity cache if it is enabled.
	 *
	 * @param seat the seat
	 */
	public static void cacheResult(Seat seat) {
		getPersistence().cacheResult(seat);
	}

	/**
	 * Caches the seats in the entity cache if it is enabled.
	 *
	 * @param seats the seats
	 */
	public static void cacheResult(List<Seat> seats) {
		getPersistence().cacheResult(seats);
	}

	/**
	 * Creates a new seat with the primary key. Does not add the seat to the database.
	 *
	 * @param seatId the primary key for the new seat
	 * @return the new seat
	 */
	public static Seat create(long seatId) {
		return getPersistence().create(seatId);
	}

	/**
	 * Removes the seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat that was removed
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	public static Seat remove(long seatId)
		throws com.esq.bus.reservation.slayers.exception.NoSuchSeatException {

		return getPersistence().remove(seatId);
	}

	public static Seat updateImpl(Seat seat) {
		return getPersistence().updateImpl(seat);
	}

	/**
	 * Returns the seat with the primary key or throws a <code>NoSuchSeatException</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	public static Seat findByPrimaryKey(long seatId)
		throws com.esq.bus.reservation.slayers.exception.NoSuchSeatException {

		return getPersistence().findByPrimaryKey(seatId);
	}

	/**
	 * Returns the seat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat, or <code>null</code> if a seat with the primary key could not be found
	 */
	public static Seat fetchByPrimaryKey(long seatId) {
		return getPersistence().fetchByPrimaryKey(seatId);
	}

	/**
	 * Returns all the seats.
	 *
	 * @return the seats
	 */
	public static List<Seat> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Seat> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Seat> findAll(
		int start, int end, OrderByComparator<Seat> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Seat> findAll(
		int start, int end, OrderByComparator<Seat> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the seats from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of seats.
	 *
	 * @return the number of seats
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SeatPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SeatPersistence _persistence;

}