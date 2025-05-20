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

import com.esq.bus.reservation.slayers.exception.NoSuchPassengerException;
import com.esq.bus.reservation.slayers.model.Passenger;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the passenger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PassengerUtil
 * @generated
 */
@ProviderType
public interface PassengerPersistence extends BasePersistence<Passenger> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PassengerUtil} to access the passenger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the passengers where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @return the matching passengers
	 */
	public java.util.List<Passenger> findBypassengerEmail(
		String passengerEmail);

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
	public java.util.List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end);

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
	public java.util.List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

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
	public java.util.List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public Passenger findBypassengerEmail_First(
			String passengerEmail,
			com.liferay.portal.kernel.util.OrderByComparator<Passenger>
				orderByComparator)
		throws NoSuchPassengerException;

	/**
	 * Returns the first passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public Passenger fetchBypassengerEmail_First(
		String passengerEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

	/**
	 * Returns the last passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public Passenger findBypassengerEmail_Last(
			String passengerEmail,
			com.liferay.portal.kernel.util.OrderByComparator<Passenger>
				orderByComparator)
		throws NoSuchPassengerException;

	/**
	 * Returns the last passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public Passenger fetchBypassengerEmail_Last(
		String passengerEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

	/**
	 * Returns the passengers before and after the current passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerId the primary key of the current passenger
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public Passenger[] findBypassengerEmail_PrevAndNext(
			long passengerId, String passengerEmail,
			com.liferay.portal.kernel.util.OrderByComparator<Passenger>
				orderByComparator)
		throws NoSuchPassengerException;

	/**
	 * Removes all the passengers where passengerEmail = &#63; from the database.
	 *
	 * @param passengerEmail the passenger email
	 */
	public void removeBypassengerEmail(String passengerEmail);

	/**
	 * Returns the number of passengers where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @return the number of matching passengers
	 */
	public int countBypassengerEmail(String passengerEmail);

	/**
	 * Returns all the passengers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching passengers
	 */
	public java.util.List<Passenger> findByuserId(long userId);

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
	public java.util.List<Passenger> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<Passenger> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

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
	public java.util.List<Passenger> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public Passenger findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Passenger>
				orderByComparator)
		throws NoSuchPassengerException;

	/**
	 * Returns the first passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public Passenger fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

	/**
	 * Returns the last passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	public Passenger findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Passenger>
				orderByComparator)
		throws NoSuchPassengerException;

	/**
	 * Returns the last passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	public Passenger fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

	/**
	 * Returns the passengers before and after the current passenger in the ordered set where userId = &#63;.
	 *
	 * @param passengerId the primary key of the current passenger
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public Passenger[] findByuserId_PrevAndNext(
			long passengerId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Passenger>
				orderByComparator)
		throws NoSuchPassengerException;

	/**
	 * Removes all the passengers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of passengers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching passengers
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the passenger in the entity cache if it is enabled.
	 *
	 * @param passenger the passenger
	 */
	public void cacheResult(Passenger passenger);

	/**
	 * Caches the passengers in the entity cache if it is enabled.
	 *
	 * @param passengers the passengers
	 */
	public void cacheResult(java.util.List<Passenger> passengers);

	/**
	 * Creates a new passenger with the primary key. Does not add the passenger to the database.
	 *
	 * @param passengerId the primary key for the new passenger
	 * @return the new passenger
	 */
	public Passenger create(long passengerId);

	/**
	 * Removes the passenger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger that was removed
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public Passenger remove(long passengerId) throws NoSuchPassengerException;

	public Passenger updateImpl(Passenger passenger);

	/**
	 * Returns the passenger with the primary key or throws a <code>NoSuchPassengerException</code> if it could not be found.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	public Passenger findByPrimaryKey(long passengerId)
		throws NoSuchPassengerException;

	/**
	 * Returns the passenger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger, or <code>null</code> if a passenger with the primary key could not be found
	 */
	public Passenger fetchByPrimaryKey(long passengerId);

	/**
	 * Returns all the passengers.
	 *
	 * @return the passengers
	 */
	public java.util.List<Passenger> findAll();

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
	public java.util.List<Passenger> findAll(int start, int end);

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
	public java.util.List<Passenger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator);

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
	public java.util.List<Passenger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Passenger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the passengers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of passengers.
	 *
	 * @return the number of passengers
	 */
	public int countAll();

}