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

import com.esq.bus.reservation.slayers.model.AdminSetting;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the admin setting service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.AdminSettingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminSettingPersistence
 * @generated
 */
public class AdminSettingUtil {

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
	public static void clearCache(AdminSetting adminSetting) {
		getPersistence().clearCache(adminSetting);
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
	public static Map<Serializable, AdminSetting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AdminSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdminSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdminSetting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AdminSetting> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AdminSetting update(AdminSetting adminSetting) {
		return getPersistence().update(adminSetting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AdminSetting update(
		AdminSetting adminSetting, ServiceContext serviceContext) {

		return getPersistence().update(adminSetting, serviceContext);
	}

	/**
	 * Caches the admin setting in the entity cache if it is enabled.
	 *
	 * @param adminSetting the admin setting
	 */
	public static void cacheResult(AdminSetting adminSetting) {
		getPersistence().cacheResult(adminSetting);
	}

	/**
	 * Caches the admin settings in the entity cache if it is enabled.
	 *
	 * @param adminSettings the admin settings
	 */
	public static void cacheResult(List<AdminSetting> adminSettings) {
		getPersistence().cacheResult(adminSettings);
	}

	/**
	 * Creates a new admin setting with the primary key. Does not add the admin setting to the database.
	 *
	 * @param settingId the primary key for the new admin setting
	 * @return the new admin setting
	 */
	public static AdminSetting create(long settingId) {
		return getPersistence().create(settingId);
	}

	/**
	 * Removes the admin setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting that was removed
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	public static AdminSetting remove(long settingId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAdminSettingException {

		return getPersistence().remove(settingId);
	}

	public static AdminSetting updateImpl(AdminSetting adminSetting) {
		return getPersistence().updateImpl(adminSetting);
	}

	/**
	 * Returns the admin setting with the primary key or throws a <code>NoSuchAdminSettingException</code> if it could not be found.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	public static AdminSetting findByPrimaryKey(long settingId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchAdminSettingException {

		return getPersistence().findByPrimaryKey(settingId);
	}

	/**
	 * Returns the admin setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting, or <code>null</code> if a admin setting with the primary key could not be found
	 */
	public static AdminSetting fetchByPrimaryKey(long settingId) {
		return getPersistence().fetchByPrimaryKey(settingId);
	}

	/**
	 * Returns all the admin settings.
	 *
	 * @return the admin settings
	 */
	public static List<AdminSetting> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AdminSetting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AdminSetting> findAll(
		int start, int end, OrderByComparator<AdminSetting> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AdminSetting> findAll(
		int start, int end, OrderByComparator<AdminSetting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the admin settings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of admin settings.
	 *
	 * @return the number of admin settings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AdminSettingPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AdminSettingPersistence _persistence;

}