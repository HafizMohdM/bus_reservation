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

import com.esq.bus.reservation.slayers.model.Passenger;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the passenger service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.PassengerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PassengerPersistence
 * @generated
 */
public class PassengerUtil {

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
	public static void clearCache(Passenger passenger) {
		getPersistence().clearCache(passenger);
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
	public static Map<Serializable, Passenger> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Passenger> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Passenger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Passenger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Passenger update(Passenger passenger) {
		return getPersistence().update(passenger);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Passenger update(
		Passenger passenger, ServiceContext serviceContext) {

		return getPersistence().update(passenger, serviceContext);
	}

	/**
	 * Returns all the passengers where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @return the matching passengers
	 */
	public static List<Passenger> findBypassengerEmail(String passengerEmail) {
		return getPersistence().findBypassengerEmail(passengerEmail);
	}

	/**
	 * Returns a range of all the passengers where passengerEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param passengerEmail the passenger email
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of matching passengers
	 */
	public static List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end) {

		return getPersistence().findBypassengerEmail(
			passengerEmail, start, end);
	}

	/**
	 * Returns an ordered range of all the passengers where passengerEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param passengerEmail the passenger email
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching passengers
	 */
	public static List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end,
		OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().findBypassengerEmail(
			passengerEmail, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the passengers where passengerEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param passengerEmail the passenger email
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching passengers
	 */
	public static List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end,
		OrderByComparator<Passenger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypassengerEmail(
			passengerEmail, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public static Passenger findBypassengerEmail_First(
			String passengerEmail,
			OrderByComparator<Passenger> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findBypassengerEmail_First(
			passengerEmail, orderByComparator);
	}

	/**
	 * Returns the first passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public static Passenger fetchBypassengerEmail_First(
		String passengerEmail, OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().fetchBypassengerEmail_First(
			passengerEmail, orderByComparator);
	}

	/**
	 * Returns the last passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public static Passenger findBypassengerEmail_Last(
			String passengerEmail,
			OrderByComparator<Passenger> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findBypassengerEmail_Last(
			passengerEmail, orderByComparator);
	}

	/**
	 * Returns the last passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public static Passenger fetchBypassengerEmail_Last(
		String passengerEmail, OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().fetchBypassengerEmail_Last(
			passengerEmail, orderByComparator);
	}

	/**
	 * Returns the passengers before and after the current passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerId the primary key of the current passenger
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public static Passenger[] findBypassengerEmail_PrevAndNext(
			long passengerId, String passengerEmail,
			OrderByComparator<Passenger> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findBypassengerEmail_PrevAndNext(
			passengerId, passengerEmail, orderByComparator);
	}

	/**
	 * Removes all the passengers where passengerEmail = &#63; from the database.
	 *
	 * @param passengerEmail the passenger email
	 */
	public static void removeBypassengerEmail(String passengerEmail) {
		getPersistence().removeBypassengerEmail(passengerEmail);
	}

	/**
	 * Returns the number of passengers where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @return the number of matching passengers
	 */
	public static int countBypassengerEmail(String passengerEmail) {
		return getPersistence().countBypassengerEmail(passengerEmail);
	}

	/**
	 * Returns all the passengers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching passengers
	 */
	public static List<Passenger> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the passengers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of matching passengers
	 */
	public static List<Passenger> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the passengers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching passengers
	 */
	public static List<Passenger> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the passengers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching passengers
	 */
	public static List<Passenger> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Passenger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public static Passenger findByuserId_First(
			long userId, OrderByComparator<Passenger> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public static Passenger fetchByuserId_First(
		long userId, OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public static Passenger findByuserId_Last(
			long userId, OrderByComparator<Passenger> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public static Passenger fetchByuserId_Last(
		long userId, OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the passengers before and after the current passenger in the ordered set where userId = &#63;.
	 *
	 * @param passengerId the primary key of the current passenger
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public static Passenger[] findByuserId_PrevAndNext(
			long passengerId, long userId,
			OrderByComparator<Passenger> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findByuserId_PrevAndNext(
			passengerId, userId, orderByComparator);
	}

	/**
	 * Removes all the passengers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of passengers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching passengers
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the passenger in the entity cache if it is enabled.
	 *
	 * @param passenger the passenger
	 */
	public static void cacheResult(Passenger passenger) {
		getPersistence().cacheResult(passenger);
	}

	/**
	 * Caches the passengers in the entity cache if it is enabled.
	 *
	 * @param passengers the passengers
	 */
	public static void cacheResult(List<Passenger> passengers) {
		getPersistence().cacheResult(passengers);
	}

	/**
	 * Creates a new passenger with the primary key. Does not add the passenger to the database.
	 *
	 * @param passengerId the primary key for the new passenger
	 * @return the new passenger
	 */
	public static Passenger create(long passengerId) {
		return getPersistence().create(passengerId);
	}

	/**
	 * Removes the passenger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger that was removed
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public static Passenger remove(long passengerId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().remove(passengerId);
	}

	public static Passenger updateImpl(Passenger passenger) {
		return getPersistence().updateImpl(passenger);
	}

	/**
	 * Returns the passenger with the primary key or throws a <code>NoSuchPassengerException</code> if it could not be found.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public static Passenger findByPrimaryKey(long passengerId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchPassengerException {

		return getPersistence().findByPrimaryKey(passengerId);
	}

	/**
	 * Returns the passenger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger, or <code>null</code> if a passenger with the primary key could not be found
	 */
	public static Passenger fetchByPrimaryKey(long passengerId) {
		return getPersistence().fetchByPrimaryKey(passengerId);
	}

	/**
	 * Returns all the passengers.
	 *
	 * @return the passengers
	 */
	public static List<Passenger> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of passengers
	 */
	public static List<Passenger> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of passengers
	 */
	public static List<Passenger> findAll(
		int start, int end, OrderByComparator<Passenger> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of passengers
	 */
	public static List<Passenger> findAll(
		int start, int end, OrderByComparator<Passenger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the passengers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of passengers.
	 *
	 * @return the number of passengers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PassengerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PassengerPersistence _persistence;

}