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

package com.esq.bus.reservation.slayers.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdminSettingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AdminSettingLocalService
 * @generated
 */
public class AdminSettingLocalServiceWrapper
	implements AdminSettingLocalService,
			   ServiceWrapper<AdminSettingLocalService> {

	public AdminSettingLocalServiceWrapper() {
		this(null);
	}

	public AdminSettingLocalServiceWrapper(
		AdminSettingLocalService adminSettingLocalService) {

		_adminSettingLocalService = adminSettingLocalService;
	}

	/**
	 * Adds the admin setting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AdminSettingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param adminSetting the admin setting
	 * @return the admin setting that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting addAdminSetting(
		com.esq.bus.reservation.slayers.model.AdminSetting adminSetting) {

		return _adminSettingLocalService.addAdminSetting(adminSetting);
	}

	/**
	 * Creates a new admin setting with the primary key. Does not add the admin setting to the database.
	 *
	 * @param settingId the primary key for the new admin setting
	 * @return the new admin setting
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting
		createAdminSetting(long settingId) {

		return _adminSettingLocalService.createAdminSetting(settingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminSettingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the admin setting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AdminSettingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param adminSetting the admin setting
	 * @return the admin setting that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting
		deleteAdminSetting(
			com.esq.bus.reservation.slayers.model.AdminSetting adminSetting) {

		return _adminSettingLocalService.deleteAdminSetting(adminSetting);
	}

	/**
	 * Deletes the admin setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AdminSettingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting that was removed
	 * @throws PortalException if a admin setting with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting
			deleteAdminSetting(long settingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminSettingLocalService.deleteAdminSetting(settingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminSettingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _adminSettingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _adminSettingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adminSettingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _adminSettingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _adminSettingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _adminSettingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _adminSettingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _adminSettingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting fetchAdminSetting(
		long settingId) {

		return _adminSettingLocalService.fetchAdminSetting(settingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _adminSettingLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the admin setting with the primary key.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting
	 * @throws PortalException if a admin setting with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting getAdminSetting(
			long settingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminSettingLocalService.getAdminSetting(settingId);
	}

	/**
	 * Returns a range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @return the range of admin settings
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.AdminSetting>
		getAdminSettings(int start, int end) {

		return _adminSettingLocalService.getAdminSettings(start, end);
	}

	/**
	 * Returns the number of admin settings.
	 *
	 * @return the number of admin settings
	 */
	@Override
	public int getAdminSettingsCount() {
		return _adminSettingLocalService.getAdminSettingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _adminSettingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _adminSettingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _adminSettingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the admin setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AdminSettingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param adminSetting the admin setting
	 * @return the admin setting that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.AdminSetting
		updateAdminSetting(
			com.esq.bus.reservation.slayers.model.AdminSetting adminSetting) {

		return _adminSettingLocalService.updateAdminSetting(adminSetting);
	}

	@Override
	public AdminSettingLocalService getWrappedService() {
		return _adminSettingLocalService;
	}

	@Override
	public void setWrappedService(
		AdminSettingLocalService adminSettingLocalService) {

		_adminSettingLocalService = adminSettingLocalService;
	}

	private AdminSettingLocalService _adminSettingLocalService;

}