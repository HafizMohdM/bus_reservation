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

import com.esq.bus.reservation.slayers.exception.NoSuchUserRoleException;
import com.esq.bus.reservation.slayers.model.UserRole;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRoleUtil
 * @generated
 */
@ProviderType
public interface UserRolePersistence extends BasePersistence<UserRole> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRoleUtil} to access the user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the user role in the entity cache if it is enabled.
	 *
	 * @param userRole the user role
	 */
	public void cacheResult(UserRole userRole);

	/**
	 * Caches the user roles in the entity cache if it is enabled.
	 *
	 * @param userRoles the user roles
	 */
	public void cacheResult(java.util.List<UserRole> userRoles);

	/**
	 * Creates a new user role with the primary key. Does not add the user role to the database.
	 *
	 * @param userRoleId the primary key for the new user role
	 * @return the new user role
	 */
	public UserRole create(long userRoleId);

	/**
	 * Removes the user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRoleId the primary key of the user role
	 * @return the user role that was removed
	 * @throws NoSuchUserRoleException if a user role with the primary key could not be found
	 */
	public UserRole remove(long userRoleId) throws NoSuchUserRoleException;

	public UserRole updateImpl(UserRole userRole);

	/**
	 * Returns the user role with the primary key or throws a <code>NoSuchUserRoleException</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role
	 * @return the user role
	 * @throws NoSuchUserRoleException if a user role with the primary key could not be found
	 */
	public UserRole findByPrimaryKey(long userRoleId)
		throws NoSuchUserRoleException;

	/**
	 * Returns the user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role
	 * @return the user role, or <code>null</code> if a user role with the primary key could not be found
	 */
	public UserRole fetchByPrimaryKey(long userRoleId);

	/**
	 * Returns all the user roles.
	 *
	 * @return the user roles
	 */
	public java.util.List<UserRole> findAll();

	/**
	 * Returns a range of all the user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user roles
	 * @param end the upper bound of the range of user roles (not inclusive)
	 * @return the range of user roles
	 */
	public java.util.List<UserRole> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user roles
	 * @param end the upper bound of the range of user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user roles
	 */
	public java.util.List<UserRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRole>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user roles
	 * @param end the upper bound of the range of user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user roles
	 */
	public java.util.List<UserRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRole>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user roles.
	 *
	 * @return the number of user roles
	 */
	public int countAll();

}