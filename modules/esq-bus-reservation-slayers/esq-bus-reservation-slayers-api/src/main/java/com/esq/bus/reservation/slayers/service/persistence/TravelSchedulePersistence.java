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

import com.esq.bus.reservation.slayers.exception.NoSuchTravelScheduleException;
import com.esq.bus.reservation.slayers.model.TravelSchedule;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelScheduleUtil
 * @generated
 */
@ProviderType
public interface TravelSchedulePersistence
	extends BasePersistence<TravelSchedule> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelScheduleUtil} to access the travel schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel schedules where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the matching travel schedules
	 */
	public java.util.List<TravelSchedule> findBybusId(long busId);

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
	public java.util.List<TravelSchedule> findBybusId(
		long busId, int start, int end);

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
	public java.util.List<TravelSchedule> findBybusId(
		long busId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
			orderByComparator);

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
	public java.util.List<TravelSchedule> findBybusId(
		long busId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel schedule
	 * @throws NoSuchTravelScheduleException if a matching travel schedule could not be found
	 */
	public TravelSchedule findBybusId_First(
			long busId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
				orderByComparator)
		throws NoSuchTravelScheduleException;

	/**
	 * Returns the first travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel schedule, or <code>null</code> if a matching travel schedule could not be found
	 */
	public TravelSchedule fetchBybusId_First(
		long busId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
			orderByComparator);

	/**
	 * Returns the last travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel schedule
	 * @throws NoSuchTravelScheduleException if a matching travel schedule could not be found
	 */
	public TravelSchedule findBybusId_Last(
			long busId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
				orderByComparator)
		throws NoSuchTravelScheduleException;

	/**
	 * Returns the last travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel schedule, or <code>null</code> if a matching travel schedule could not be found
	 */
	public TravelSchedule fetchBybusId_Last(
		long busId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
			orderByComparator);

	/**
	 * Returns the travel schedules before and after the current travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param scheduleId the primary key of the current travel schedule
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	public TravelSchedule[] findBybusId_PrevAndNext(
			long scheduleId, long busId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
				orderByComparator)
		throws NoSuchTravelScheduleException;

	/**
	 * Removes all the travel schedules where busId = &#63; from the database.
	 *
	 * @param busId the bus ID
	 */
	public void removeBybusId(long busId);

	/**
	 * Returns the number of travel schedules where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the number of matching travel schedules
	 */
	public int countBybusId(long busId);

	/**
	 * Caches the travel schedule in the entity cache if it is enabled.
	 *
	 * @param travelSchedule the travel schedule
	 */
	public void cacheResult(TravelSchedule travelSchedule);

	/**
	 * Caches the travel schedules in the entity cache if it is enabled.
	 *
	 * @param travelSchedules the travel schedules
	 */
	public void cacheResult(java.util.List<TravelSchedule> travelSchedules);

	/**
	 * Creates a new travel schedule with the primary key. Does not add the travel schedule to the database.
	 *
	 * @param scheduleId the primary key for the new travel schedule
	 * @return the new travel schedule
	 */
	public TravelSchedule create(long scheduleId);

	/**
	 * Removes the travel schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule that was removed
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	public TravelSchedule remove(long scheduleId)
		throws NoSuchTravelScheduleException;

	public TravelSchedule updateImpl(TravelSchedule travelSchedule);

	/**
	 * Returns the travel schedule with the primary key or throws a <code>NoSuchTravelScheduleException</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	public TravelSchedule findByPrimaryKey(long scheduleId)
		throws NoSuchTravelScheduleException;

	/**
	 * Returns the travel schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule, or <code>null</code> if a travel schedule with the primary key could not be found
	 */
	public TravelSchedule fetchByPrimaryKey(long scheduleId);

	/**
	 * Returns all the travel schedules.
	 *
	 * @return the travel schedules
	 */
	public java.util.List<TravelSchedule> findAll();

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
	public java.util.List<TravelSchedule> findAll(int start, int end);

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
	public java.util.List<TravelSchedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
			orderByComparator);

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
	public java.util.List<TravelSchedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelSchedule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel schedules from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel schedules.
	 *
	 * @return the number of travel schedules
	 */
	public int countAll();

}