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

import com.esq.bus.reservation.slayers.exception.NoSuchLocationException;
import com.esq.bus.reservation.slayers.model.Location;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocationUtil
 * @generated
 */
@ProviderType
public interface LocationPersistence extends BasePersistence<Location> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocationUtil} to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	public void cacheResult(Location location);

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	public void cacheResult(java.util.List<Location> locations);

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locationId the primary key for the new location
	 * @return the new location
	 */
	public Location create(long locationId);

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public Location remove(long locationId) throws NoSuchLocationException;

	public Location updateImpl(Location location);

	/**
	 * Returns the location with the primary key or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public Location findByPrimaryKey(long locationId)
		throws NoSuchLocationException;

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 */
	public Location fetchByPrimaryKey(long locationId);

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 */
	public java.util.List<Location> findAll();

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 */
	public java.util.List<Location> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations
	 */
	public java.util.List<Location> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Location>
			orderByComparator);

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of locations
	 */
	public java.util.List<Location> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Location>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the locations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 */
	public int countAll();

}