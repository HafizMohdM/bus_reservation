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

import com.esq.bus.reservation.slayers.exception.NoSuchAdminSettingException;
import com.esq.bus.reservation.slayers.model.AdminSetting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the admin setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminSettingUtil
 * @generated
 */
@ProviderType
public interface AdminSettingPersistence extends BasePersistence<AdminSetting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdminSettingUtil} to access the admin setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the admin setting in the entity cache if it is enabled.
	 *
	 * @param adminSetting the admin setting
	 */
	public void cacheResult(AdminSetting adminSetting);

	/**
	 * Caches the admin settings in the entity cache if it is enabled.
	 *
	 * @param adminSettings the admin settings
	 */
	public void cacheResult(java.util.List<AdminSetting> adminSettings);

	/**
	 * Creates a new admin setting with the primary key. Does not add the admin setting to the database.
	 *
	 * @param settingId the primary key for the new admin setting
	 * @return the new admin setting
	 */
	public AdminSetting create(long settingId);

	/**
	 * Removes the admin setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting that was removed
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	public AdminSetting remove(long settingId)
		throws NoSuchAdminSettingException;

	public AdminSetting updateImpl(AdminSetting adminSetting);

	/**
	 * Returns the admin setting with the primary key or throws a <code>NoSuchAdminSettingException</code> if it could not be found.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	public AdminSetting findByPrimaryKey(long settingId)
		throws NoSuchAdminSettingException;

	/**
	 * Returns the admin setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting, or <code>null</code> if a admin setting with the primary key could not be found
	 */
	public AdminSetting fetchByPrimaryKey(long settingId);

	/**
	 * Returns all the admin settings.
	 *
	 * @return the admin settings
	 */
	public java.util.List<AdminSetting> findAll();

	/**
	 * Returns a range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @return the range of admin settings
	 */
	public java.util.List<AdminSetting> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of admin settings
	 */
	public java.util.List<AdminSetting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminSetting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of admin settings
	 */
	public java.util.List<AdminSetting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminSetting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the admin settings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of admin settings.
	 *
	 * @return the number of admin settings
	 */
	public int countAll();

}