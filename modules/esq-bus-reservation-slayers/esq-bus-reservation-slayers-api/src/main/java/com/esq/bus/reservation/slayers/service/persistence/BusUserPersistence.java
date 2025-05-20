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

import com.esq.bus.reservation.slayers.exception.NoSuchBusUserException;
import com.esq.bus.reservation.slayers.model.BusUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bus user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusUserUtil
 * @generated
 */
@ProviderType
public interface BusUserPersistence extends BasePersistence<BusUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusUserUtil} to access the bus user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bus users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching bus users
	 */
	public java.util.List<BusUser> findByemailAddress(String emailAddress);

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
	public java.util.List<BusUser> findByemailAddress(
		String emailAddress, int start, int end);

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
	public java.util.List<BusUser> findByemailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

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
	public java.util.List<BusUser> findByemailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public BusUser findByemailAddress_First(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<BusUser>
				orderByComparator)
		throws NoSuchBusUserException;

	/**
	 * Returns the first bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public BusUser fetchByemailAddress_First(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

	/**
	 * Returns the last bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public BusUser findByemailAddress_Last(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<BusUser>
				orderByComparator)
		throws NoSuchBusUserException;

	/**
	 * Returns the last bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public BusUser fetchByemailAddress_Last(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

	/**
	 * Returns the bus users before and after the current bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param userId the primary key of the current bus user
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public BusUser[] findByemailAddress_PrevAndNext(
			long userId, String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<BusUser>
				orderByComparator)
		throws NoSuchBusUserException;

	/**
	 * Removes all the bus users where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public void removeByemailAddress(String emailAddress);

	/**
	 * Returns the number of bus users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching bus users
	 */
	public int countByemailAddress(String emailAddress);

	/**
	 * Returns all the bus users where username = &#63;.
	 *
	 * @param username the username
	 * @return the matching bus users
	 */
	public java.util.List<BusUser> findByusername(String username);

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
	public java.util.List<BusUser> findByusername(
		String username, int start, int end);

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
	public java.util.List<BusUser> findByusername(
		String username, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

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
	public java.util.List<BusUser> findByusername(
		String username, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public BusUser findByusername_First(
			String username,
			com.liferay.portal.kernel.util.OrderByComparator<BusUser>
				orderByComparator)
		throws NoSuchBusUserException;

	/**
	 * Returns the first bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public BusUser fetchByusername_First(
		String username,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

	/**
	 * Returns the last bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	public BusUser findByusername_Last(
			String username,
			com.liferay.portal.kernel.util.OrderByComparator<BusUser>
				orderByComparator)
		throws NoSuchBusUserException;

	/**
	 * Returns the last bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	public BusUser fetchByusername_Last(
		String username,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

	/**
	 * Returns the bus users before and after the current bus user in the ordered set where username = &#63;.
	 *
	 * @param userId the primary key of the current bus user
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public BusUser[] findByusername_PrevAndNext(
			long userId, String username,
			com.liferay.portal.kernel.util.OrderByComparator<BusUser>
				orderByComparator)
		throws NoSuchBusUserException;

	/**
	 * Removes all the bus users where username = &#63; from the database.
	 *
	 * @param username the username
	 */
	public void removeByusername(String username);

	/**
	 * Returns the number of bus users where username = &#63;.
	 *
	 * @param username the username
	 * @return the number of matching bus users
	 */
	public int countByusername(String username);

	/**
	 * Caches the bus user in the entity cache if it is enabled.
	 *
	 * @param busUser the bus user
	 */
	public void cacheResult(BusUser busUser);

	/**
	 * Caches the bus users in the entity cache if it is enabled.
	 *
	 * @param busUsers the bus users
	 */
	public void cacheResult(java.util.List<BusUser> busUsers);

	/**
	 * Creates a new bus user with the primary key. Does not add the bus user to the database.
	 *
	 * @param userId the primary key for the new bus user
	 * @return the new bus user
	 */
	public BusUser create(long userId);

	/**
	 * Removes the bus user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user that was removed
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public BusUser remove(long userId) throws NoSuchBusUserException;

	public BusUser updateImpl(BusUser busUser);

	/**
	 * Returns the bus user with the primary key or throws a <code>NoSuchBusUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	public BusUser findByPrimaryKey(long userId) throws NoSuchBusUserException;

	/**
	 * Returns the bus user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user, or <code>null</code> if a bus user with the primary key could not be found
	 */
	public BusUser fetchByPrimaryKey(long userId);

	/**
	 * Returns all the bus users.
	 *
	 * @return the bus users
	 */
	public java.util.List<BusUser> findAll();

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
	public java.util.List<BusUser> findAll(int start, int end);

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
	public java.util.List<BusUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator);

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
	public java.util.List<BusUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BusUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bus users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bus users.
	 *
	 * @return the number of bus users
	 */
	public int countAll();

}