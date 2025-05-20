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
 * Provides a wrapper for {@link DriverLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DriverLocalService
 * @generated
 */
public class DriverLocalServiceWrapper
	implements DriverLocalService, ServiceWrapper<DriverLocalService> {

	public DriverLocalServiceWrapper() {
		this(null);
	}

	public DriverLocalServiceWrapper(DriverLocalService driverLocalService) {
		_driverLocalService = driverLocalService;
	}

	/**
	 * Adds the driver to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driver the driver
	 * @return the driver that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Driver addDriver(
		com.esq.bus.reservation.slayers.model.Driver driver) {

		return _driverLocalService.addDriver(driver);
	}

	/**
	 * Creates a new driver with the primary key. Does not add the driver to the database.
	 *
	 * @param driverId the primary key for the new driver
	 * @return the new driver
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Driver createDriver(
		long driverId) {

		return _driverLocalService.createDriver(driverId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the driver from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driver the driver
	 * @return the driver that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Driver deleteDriver(
		com.esq.bus.reservation.slayers.model.Driver driver) {

		return _driverLocalService.deleteDriver(driver);
	}

	/**
	 * Deletes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver that was removed
	 * @throws PortalException if a driver with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Driver deleteDriver(
			long driverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLocalService.deleteDriver(driverId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _driverLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _driverLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _driverLocalService.dynamicQuery();
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

		return _driverLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DriverModelImpl</code>.
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

		return _driverLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DriverModelImpl</code>.
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

		return _driverLocalService.dynamicQuery(
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

		return _driverLocalService.dynamicQueryCount(dynamicQuery);
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

		return _driverLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.Driver fetchDriver(
		long driverId) {

		return _driverLocalService.fetchDriver(driverId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _driverLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the driver with the primary key.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver
	 * @throws PortalException if a driver with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Driver getDriver(long driverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLocalService.getDriver(driverId);
	}

	/**
	 * Returns a range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of drivers
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.Driver>
		getDrivers(int start, int end) {

		return _driverLocalService.getDrivers(start, end);
	}

	/**
	 * Returns the number of drivers.
	 *
	 * @return the number of drivers
	 */
	@Override
	public int getDriversCount() {
		return _driverLocalService.getDriversCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _driverLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _driverLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the driver in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driver the driver
	 * @return the driver that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Driver updateDriver(
		com.esq.bus.reservation.slayers.model.Driver driver) {

		return _driverLocalService.updateDriver(driver);
	}

	@Override
	public DriverLocalService getWrappedService() {
		return _driverLocalService;
	}

	@Override
	public void setWrappedService(DriverLocalService driverLocalService) {
		_driverLocalService = driverLocalService;
	}

	private DriverLocalService _driverLocalService;

}