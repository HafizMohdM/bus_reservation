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

import com.esq.bus.reservation.slayers.model.BusUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bus user service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.BusUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusUserPersistence
 * @generated
 */
public class BusUserUtil {

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
	public static void clearCache(BusUser busUser) {
		getPersistence().clearCache(busUser);
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
	public static Map<Serializable, BusUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BusUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BusUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BusUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BusUser update(BusUser busUser) {
		return getPersistence().update(busUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BusUser update(
		BusUser busUser, ServiceContext serviceContext) {

		return getPersistence().update(busUser, serviceContext);
	}

	/**
	 * Returns all the bus users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching bus users
	 */
	public static List<BusUser> findByemailAddress(String emailAddress) {
		return getPersistence().findByemailAddress(emailAddress);
	}

	/**
	 * Returns a range of all the bus users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of matching bus users
	 */
	public static List<BusUser> findByemailAddress(
		String emailAddress, int start, int end) {

		return getPersistence().findByemailAddress(emailAddress, start, end);
	}

	/**
	 * Returns an ordered range of all the bus users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus users
	 */
	public static List<BusUser> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().findByemailAddress(
			emailAddress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bus users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bus users
	 */
	public static List<BusUser> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<BusUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByemailAddress(
			emailAddress, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public static BusUser findByemailAddress_First(
			String emailAddress, OrderByComparator<BusUser> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByemailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the first bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public static BusUser fetchByemailAddress_First(
		String emailAddress, OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().fetchByemailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public static BusUser findByemailAddress_Last(
			String emailAddress, OrderByComparator<BusUser> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByemailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public static BusUser fetchByemailAddress_Last(
		String emailAddress, OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().fetchByemailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the bus users before and after the current bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param userId the primary key of the current bus user
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public static BusUser[] findByemailAddress_PrevAndNext(
			long userId, String emailAddress,
			OrderByComparator<BusUser> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByemailAddress_PrevAndNext(
			userId, emailAddress, orderByComparator);
	}

	/**
	 * Removes all the bus users where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public static void removeByemailAddress(String emailAddress) {
		getPersistence().removeByemailAddress(emailAddress);
	}

	/**
	 * Returns the number of bus users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching bus users
	 */
	public static int countByemailAddress(String emailAddress) {
		return getPersistence().countByemailAddress(emailAddress);
	}

	/**
	 * Returns all the bus users where username = &#63;.
	 *
	 * @param username the username
	 * @return the matching bus users
	 */
	public static List<BusUser> findByusername(String username) {
		return getPersistence().findByusername(username);
	}

	/**
	 * Returns a range of all the bus users where username = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param username the username
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of matching bus users
	 */
	public static List<BusUser> findByusername(
		String username, int start, int end) {

		return getPersistence().findByusername(username, start, end);
	}

	/**
	 * Returns an ordered range of all the bus users where username = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param username the username
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus users
	 */
	public static List<BusUser> findByusername(
		String username, int start, int end,
		OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().findByusername(
			username, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bus users where username = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param username the username
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bus users
	 */
	public static List<BusUser> findByusername(
		String username, int start, int end,
		OrderByComparator<BusUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByusername(
			username, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public static BusUser findByusername_First(
			String username, OrderByComparator<BusUser> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByusername_First(
			username, orderByComparator);
	}

	/**
	 * Returns the first bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public static BusUser fetchByusername_First(
		String username, OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().fetchByusername_First(
			username, orderByComparator);
	}

	/**
	 * Returns the last bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public static BusUser findByusername_Last(
			String username, OrderByComparator<BusUser> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByusername_Last(
			username, orderByComparator);
	}

	/**
	 * Returns the last bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public static BusUser fetchByusername_Last(
		String username, OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().fetchByusername_Last(
			username, orderByComparator);
	}

	/**
	 * Returns the bus users before and after the current bus user in the ordered set where username = &#63;.
	 *
	 * @param userId the primary key of the current bus user
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public static BusUser[] findByusername_PrevAndNext(
			long userId, String username,
			OrderByComparator<BusUser> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByusername_PrevAndNext(
			userId, username, orderByComparator);
	}

	/**
	 * Removes all the bus users where username = &#63; from the database.
	 *
	 * @param username the username
	 */
	public static void removeByusername(String username) {
		getPersistence().removeByusername(username);
	}

	/**
	 * Returns the number of bus users where username = &#63;.
	 *
	 * @param username the username
	 * @return the number of matching bus users
	 */
	public static int countByusername(String username) {
		return getPersistence().countByusername(username);
	}

	/**
	 * Caches the bus user in the entity cache if it is enabled.
	 *
	 * @param busUser the bus user
	 */
	public static void cacheResult(BusUser busUser) {
		getPersistence().cacheResult(busUser);
	}

	/**
	 * Caches the bus users in the entity cache if it is enabled.
	 *
	 * @param busUsers the bus users
	 */
	public static void cacheResult(List<BusUser> busUsers) {
		getPersistence().cacheResult(busUsers);
	}

	/**
	 * Creates a new bus user with the primary key. Does not add the bus user to the database.
	 *
	 * @param userId the primary key for the new bus user
	 * @return the new bus user
	 */
	public static BusUser create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	 * Removes the bus user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user that was removed
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public static BusUser remove(long userId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().remove(userId);
	}

	public static BusUser updateImpl(BusUser busUser) {
		return getPersistence().updateImpl(busUser);
	}

	/**
	 * Returns the bus user with the primary key or throws a <code>NoSuchBusUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public static BusUser findByPrimaryKey(long userId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchBusUserException {

		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	 * Returns the bus user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user, or <code>null</code> if a bus user with the primary key could not be found
	 */
	public static BusUser fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	 * Returns all the bus users.
	 *
	 * @return the bus users
	 */
	public static List<BusUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of bus users
	 */
	public static List<BusUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bus users
	 */
	public static List<BusUser> findAll(
		int start, int end, OrderByComparator<BusUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bus users
	 */
	public static List<BusUser> findAll(
		int start, int end, OrderByComparator<BusUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bus users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bus users.
	 *
	 * @return the number of bus users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BusUserPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BusUserPersistence _persistence;

}