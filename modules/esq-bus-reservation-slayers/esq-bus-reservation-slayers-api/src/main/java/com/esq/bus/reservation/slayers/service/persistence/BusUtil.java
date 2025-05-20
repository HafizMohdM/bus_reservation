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

import com.esq.bus.reservation.slayers.model.Bus;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bus service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.BusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusPersistence
 * @generated
 */
public class BusUtil {

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
	public static void clearCache(Bus bus) {
		getPersistence().clearCache(bus);
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
	public static Map<Serializable, Bus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Bus> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Bus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Bus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Bus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Bus update(Bus bus) {
		return getPersistence().update(bus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Bus update(Bus bus, ServiceContext serviceContext) {
		return getPersistence().update(bus, serviceContext);
	}

	/**
	 * Returns all the buses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching buses
	 */
	public static List<Bus> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

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
	public static List<Bus> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static List<Bus> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Bus> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<Bus> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Bus> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus
	 * @throws NoSuchBusException if a matching bus could not be found
	 */
	public static Bus findByuserId_First(
			long userId, OrderByComparator<Bus> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.NoSuchBusException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus, or <code>null</code> if a matching bus could not be found
	 */
	public static Bus fetchByuserId_First(
		long userId, OrderByComparator<Bus> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus
	 * @throws NoSuchBusException if a matching bus could not be found
	 */
	public static Bus findByuserId_Last(
			long userId, OrderByComparator<Bus> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.NoSuchBusException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus, or <code>null</code> if a matching bus could not be found
	 */
	public static Bus fetchByuserId_Last(
		long userId, OrderByComparator<Bus> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the buses before and after the current bus in the ordered set where userId = &#63;.
	 *
	 * @param busId the primary key of the current bus
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	public static Bus[] findByuserId_PrevAndNext(
			long busId, long userId, OrderByComparator<Bus> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.NoSuchBusException {

		return getPersistence().findByuserId_PrevAndNext(
			busId, userId, orderByComparator);
	}

	/**
	 * Removes all the buses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of buses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching buses
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the bus in the entity cache if it is enabled.
	 *
	 * @param bus the bus
	 */
	public static void cacheResult(Bus bus) {
		getPersistence().cacheResult(bus);
	}

	/**
	 * Caches the buses in the entity cache if it is enabled.
	 *
	 * @param buses the buses
	 */
	public static void cacheResult(List<Bus> buses) {
		getPersistence().cacheResult(buses);
	}

	/**
	 * Creates a new bus with the primary key. Does not add the bus to the database.
	 *
	 * @param busId the primary key for the new bus
	 * @return the new bus
	 */
	public static Bus create(long busId) {
		return getPersistence().create(busId);
	}

	/**
	 * Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus that was removed
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	public static Bus remove(long busId)
		throws com.esq.bus.reservation.slayers.exception.NoSuchBusException {

		return getPersistence().remove(busId);
	}

	public static Bus updateImpl(Bus bus) {
		return getPersistence().updateImpl(bus);
	}

	/**
	 * Returns the bus with the primary key or throws a <code>NoSuchBusException</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	public static Bus findByPrimaryKey(long busId)
		throws com.esq.bus.reservation.slayers.exception.NoSuchBusException {

		return getPersistence().findByPrimaryKey(busId);
	}

	/**
	 * Returns the bus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus, or <code>null</code> if a bus with the primary key could not be found
	 */
	public static Bus fetchByPrimaryKey(long busId) {
		return getPersistence().fetchByPrimaryKey(busId);
	}

	/**
	 * Returns all the buses.
	 *
	 * @return the buses
	 */
	public static List<Bus> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Bus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Bus> findAll(
		int start, int end, OrderByComparator<Bus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Bus> findAll(
		int start, int end, OrderByComparator<Bus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the buses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of buses.
	 *
	 * @return the number of buses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BusPersistence _persistence;

}