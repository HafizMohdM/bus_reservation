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
 * Provides a wrapper for {@link DriverLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DriverLogLocalService
 * @generated
 */
public class DriverLogLocalServiceWrapper
	implements DriverLogLocalService, ServiceWrapper<DriverLogLocalService> {

	public DriverLogLocalServiceWrapper() {
		this(null);
	}

	public DriverLogLocalServiceWrapper(
		DriverLogLocalService driverLogLocalService) {

		_driverLogLocalService = driverLogLocalService;
	}

	/**
	 * Adds the driver log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverLog the driver log
	 * @return the driver log that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog addDriverLog(
		com.esq.bus.reservation.slayers.model.DriverLog driverLog) {

		return _driverLogLocalService.addDriverLog(driverLog);
	}

	/**
	 * Creates a new driver log with the primary key. Does not add the driver log to the database.
	 *
	 * @param logId the primary key for the new driver log
	 * @return the new driver log
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog createDriverLog(
		long logId) {

		return _driverLogLocalService.createDriverLog(logId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the driver log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverLog the driver log
	 * @return the driver log that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog deleteDriverLog(
		com.esq.bus.reservation.slayers.model.DriverLog driverLog) {

		return _driverLogLocalService.deleteDriverLog(driverLog);
	}

	/**
	 * Deletes the driver log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log that was removed
	 * @throws PortalException if a driver log with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog deleteDriverLog(
			long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLogLocalService.deleteDriverLog(logId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _driverLogLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _driverLogLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _driverLogLocalService.dynamicQuery();
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

		return _driverLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DriverLogModelImpl</code>.
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

		return _driverLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DriverLogModelImpl</code>.
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

		return _driverLogLocalService.dynamicQuery(
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

		return _driverLogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _driverLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog fetchDriverLog(
		long logId) {

		return _driverLogLocalService.fetchDriverLog(logId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _driverLogLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the driver log with the primary key.
	 *
	 * @param logId the primary key of the driver log
	 * @return the driver log
	 * @throws PortalException if a driver log with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog getDriverLog(
			long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLogLocalService.getDriverLog(logId);
	}

	/**
	 * Returns a range of all the driver logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DriverLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver logs
	 * @param end the upper bound of the range of driver logs (not inclusive)
	 * @return the range of driver logs
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.DriverLog>
		getDriverLogs(int start, int end) {

		return _driverLogLocalService.getDriverLogs(start, end);
	}

	/**
	 * Returns the number of driver logs.
	 *
	 * @return the number of driver logs
	 */
	@Override
	public int getDriverLogsCount() {
		return _driverLogLocalService.getDriverLogsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _driverLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _driverLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the driver log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverLog the driver log
	 * @return the driver log that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.DriverLog updateDriverLog(
		com.esq.bus.reservation.slayers.model.DriverLog driverLog) {

		return _driverLogLocalService.updateDriverLog(driverLog);
	}

	@Override
	public DriverLogLocalService getWrappedService() {
		return _driverLogLocalService;
	}

	@Override
	public void setWrappedService(DriverLogLocalService driverLogLocalService) {
		_driverLogLocalService = driverLogLocalService;
	}

	private DriverLogLocalService _driverLogLocalService;

}