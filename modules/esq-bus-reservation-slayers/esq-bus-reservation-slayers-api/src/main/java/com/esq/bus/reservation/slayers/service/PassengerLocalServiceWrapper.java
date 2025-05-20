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
 * Provides a wrapper for {@link PassengerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PassengerLocalService
 * @generated
 */
public class PassengerLocalServiceWrapper
	implements PassengerLocalService, ServiceWrapper<PassengerLocalService> {

	public PassengerLocalServiceWrapper() {
		this(null);
	}

	public PassengerLocalServiceWrapper(
		PassengerLocalService passengerLocalService) {

		_passengerLocalService = passengerLocalService;
	}

	/**
	 * Adds the passenger to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PassengerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param passenger the passenger
	 * @return the passenger that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Passenger addPassenger(
		com.esq.bus.reservation.slayers.model.Passenger passenger) {

		return _passengerLocalService.addPassenger(passenger);
	}

	/**
	 * Creates a new passenger with the primary key. Does not add the passenger to the database.
	 *
	 * @param passengerId the primary key for the new passenger
	 * @return the new passenger
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Passenger createPassenger(
		long passengerId) {

		return _passengerLocalService.createPassenger(passengerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _passengerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the passenger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PassengerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger that was removed
	 * @throws PortalException if a passenger with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Passenger deletePassenger(
			long passengerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _passengerLocalService.deletePassenger(passengerId);
	}

	/**
	 * Deletes the passenger from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PassengerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param passenger the passenger
	 * @return the passenger that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Passenger deletePassenger(
		com.esq.bus.reservation.slayers.model.Passenger passenger) {

		return _passengerLocalService.deletePassenger(passenger);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _passengerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _passengerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _passengerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _passengerLocalService.dynamicQuery();
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

		return _passengerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.PassengerModelImpl</code>.
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

		return _passengerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.PassengerModelImpl</code>.
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

		return _passengerLocalService.dynamicQuery(
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

		return _passengerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _passengerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.Passenger fetchPassenger(
		long passengerId) {

		return _passengerLocalService.fetchPassenger(passengerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _passengerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _passengerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _passengerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the passenger with the primary key.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger
	 * @throws PortalException if a passenger with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Passenger getPassenger(
			long passengerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _passengerLocalService.getPassenger(passengerId);
	}

	/**
	 * Returns a range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of passengers
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.Passenger>
		getPassengers(int start, int end) {

		return _passengerLocalService.getPassengers(start, end);
	}

	/**
	 * Returns the number of passengers.
	 *
	 * @return the number of passengers
	 */
	@Override
	public int getPassengersCount() {
		return _passengerLocalService.getPassengersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _passengerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the passenger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PassengerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param passenger the passenger
	 * @return the passenger that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Passenger updatePassenger(
		com.esq.bus.reservation.slayers.model.Passenger passenger) {

		return _passengerLocalService.updatePassenger(passenger);
	}

	@Override
	public PassengerLocalService getWrappedService() {
		return _passengerLocalService;
	}

	@Override
	public void setWrappedService(PassengerLocalService passengerLocalService) {
		_passengerLocalService = passengerLocalService;
	}

	private PassengerLocalService _passengerLocalService;

}