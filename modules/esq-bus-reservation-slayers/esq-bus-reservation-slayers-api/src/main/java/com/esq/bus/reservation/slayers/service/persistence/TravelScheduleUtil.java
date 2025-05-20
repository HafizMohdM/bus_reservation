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

import com.esq.bus.reservation.slayers.model.TravelSchedule;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel schedule service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.TravelSchedulePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelSchedulePersistence
 * @generated
 */
public class TravelScheduleUtil {

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
	public static void clearCache(TravelSchedule travelSchedule) {
		getPersistence().clearCache(travelSchedule);
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
	public static Map<Serializable, TravelSchedule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelSchedule update(TravelSchedule travelSchedule) {
		return getPersistence().update(travelSchedule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelSchedule update(
		TravelSchedule travelSchedule, ServiceContext serviceContext) {

		return getPersistence().update(travelSchedule, serviceContext);
	}

	/**
	 * Returns all the travel schedules where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the matching travel schedules
	 */
	public static List<TravelSchedule> findBybusId(long busId) {
		return getPersistence().findBybusId(busId);
	}

	/**
	 * Returns a range of all the travel schedules where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @return the range of matching travel schedules
	 */
	public static List<TravelSchedule> findBybusId(
		long busId, int start, int end) {

		return getPersistence().findBybusId(busId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel schedules where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel schedules
	 */
	public static List<TravelSchedule> findBybusId(
		long busId, int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator) {

		return getPersistence().findBybusId(
			busId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel schedules where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel schedules
	 */
	public static List<TravelSchedule> findBybusId(
		long busId, int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBybusId(
			busId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel schedule
	 * @throws NoSuchTravelScheduleException if a matching travel schedule could not be found
	 */
	public static TravelSchedule findBybusId_First(
			long busId, OrderByComparator<TravelSchedule> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTravelScheduleException {

		return getPersistence().findBybusId_First(busId, orderByComparator);
	}

	/**
	 * Returns the first travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel schedule, or <code>null</code> if a matching travel schedule could not be found
	 */
	public static TravelSchedule fetchBybusId_First(
		long busId, OrderByComparator<TravelSchedule> orderByComparator) {

		return getPersistence().fetchBybusId_First(busId, orderByComparator);
	}

	/**
	 * Returns the last travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel schedule
	 * @throws NoSuchTravelScheduleException if a matching travel schedule could not be found
	 */
	public static TravelSchedule findBybusId_Last(
			long busId, OrderByComparator<TravelSchedule> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTravelScheduleException {

		return getPersistence().findBybusId_Last(busId, orderByComparator);
	}

	/**
	 * Returns the last travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel schedule, or <code>null</code> if a matching travel schedule could not be found
	 */
	public static TravelSchedule fetchBybusId_Last(
		long busId, OrderByComparator<TravelSchedule> orderByComparator) {

		return getPersistence().fetchBybusId_Last(busId, orderByComparator);
	}

	/**
	 * Returns the travel schedules before and after the current travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param scheduleId the primary key of the current travel schedule
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	public static TravelSchedule[] findBybusId_PrevAndNext(
			long scheduleId, long busId,
			OrderByComparator<TravelSchedule> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTravelScheduleException {

		return getPersistence().findBybusId_PrevAndNext(
			scheduleId, busId, orderByComparator);
	}

	/**
	 * Removes all the travel schedules where busId = &#63; from the database.
	 *
	 * @param busId the bus ID
	 */
	public static void removeBybusId(long busId) {
		getPersistence().removeBybusId(busId);
	}

	/**
	 * Returns the number of travel schedules where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the number of matching travel schedules
	 */
	public static int countBybusId(long busId) {
		return getPersistence().countBybusId(busId);
	}

	/**
	 * Caches the travel schedule in the entity cache if it is enabled.
	 *
	 * @param travelSchedule the travel schedule
	 */
	public static void cacheResult(TravelSchedule travelSchedule) {
		getPersistence().cacheResult(travelSchedule);
	}

	/**
	 * Caches the travel schedules in the entity cache if it is enabled.
	 *
	 * @param travelSchedules the travel schedules
	 */
	public static void cacheResult(List<TravelSchedule> travelSchedules) {
		getPersistence().cacheResult(travelSchedules);
	}

	/**
	 * Creates a new travel schedule with the primary key. Does not add the travel schedule to the database.
	 *
	 * @param scheduleId the primary key for the new travel schedule
	 * @return the new travel schedule
	 */
	public static TravelSchedule create(long scheduleId) {
		return getPersistence().create(scheduleId);
	}

	/**
	 * Removes the travel schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule that was removed
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	public static TravelSchedule remove(long scheduleId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTravelScheduleException {

		return getPersistence().remove(scheduleId);
	}

	public static TravelSchedule updateImpl(TravelSchedule travelSchedule) {
		return getPersistence().updateImpl(travelSchedule);
	}

	/**
	 * Returns the travel schedule with the primary key or throws a <code>NoSuchTravelScheduleException</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	public static TravelSchedule findByPrimaryKey(long scheduleId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchTravelScheduleException {

		return getPersistence().findByPrimaryKey(scheduleId);
	}

	/**
	 * Returns the travel schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule, or <code>null</code> if a travel schedule with the primary key could not be found
	 */
	public static TravelSchedule fetchByPrimaryKey(long scheduleId) {
		return getPersistence().fetchByPrimaryKey(scheduleId);
	}

	/**
	 * Returns all the travel schedules.
	 *
	 * @return the travel schedules
	 */
	public static List<TravelSchedule> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @return the range of travel schedules
	 */
	public static List<TravelSchedule> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel schedules
	 */
	public static List<TravelSchedule> findAll(
		int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel schedules
	 */
	public static List<TravelSchedule> findAll(
		int start, int end, OrderByComparator<TravelSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel schedules from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel schedules.
	 *
	 * @return the number of travel schedules
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelSchedulePersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelSchedulePersistence _persistence;

}