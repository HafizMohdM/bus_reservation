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
 * Provides a wrapper for {@link SeatLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SeatLocalService
 * @generated
 */
public class SeatLocalServiceWrapper
	implements SeatLocalService, ServiceWrapper<SeatLocalService> {

	public SeatLocalServiceWrapper() {
		this(null);
	}

	public SeatLocalServiceWrapper(SeatLocalService seatLocalService) {
		_seatLocalService = seatLocalService;
	}

	/**
	 * Adds the seat to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SeatLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param seat the seat
	 * @return the seat that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Seat addSeat(
		com.esq.bus.reservation.slayers.model.Seat seat) {

		return _seatLocalService.addSeat(seat);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _seatLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new seat with the primary key. Does not add the seat to the database.
	 *
	 * @param seatId the primary key for the new seat
	 * @return the new seat
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Seat createSeat(long seatId) {
		return _seatLocalService.createSeat(seatId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _seatLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SeatLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat that was removed
	 * @throws PortalException if a seat with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Seat deleteSeat(long seatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _seatLocalService.deleteSeat(seatId);
	}

	/**
	 * Deletes the seat from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SeatLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param seat the seat
	 * @return the seat that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Seat deleteSeat(
		com.esq.bus.reservation.slayers.model.Seat seat) {

		return _seatLocalService.deleteSeat(seat);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _seatLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _seatLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _seatLocalService.dynamicQuery();
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

		return _seatLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.SeatModelImpl</code>.
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

		return _seatLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.SeatModelImpl</code>.
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

		return _seatLocalService.dynamicQuery(
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

		return _seatLocalService.dynamicQueryCount(dynamicQuery);
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

		return _seatLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.Seat fetchSeat(long seatId) {
		return _seatLocalService.fetchSeat(seatId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _seatLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _seatLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _seatLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _seatLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the seat with the primary key.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat
	 * @throws PortalException if a seat with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Seat getSeat(long seatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _seatLocalService.getSeat(seatId);
	}

	/**
	 * Returns a range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @return the range of seats
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.Seat> getSeats(
		int start, int end) {

		return _seatLocalService.getSeats(start, end);
	}

	/**
	 * Returns the number of seats.
	 *
	 * @return the number of seats
	 */
	@Override
	public int getSeatsCount() {
		return _seatLocalService.getSeatsCount();
	}

	/**
	 * Updates the seat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SeatLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param seat the seat
	 * @return the seat that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Seat updateSeat(
		com.esq.bus.reservation.slayers.model.Seat seat) {

		return _seatLocalService.updateSeat(seat);
	}

	@Override
	public SeatLocalService getWrappedService() {
		return _seatLocalService;
	}

	@Override
	public void setWrappedService(SeatLocalService seatLocalService) {
		_seatLocalService = seatLocalService;
	}

	private SeatLocalService _seatLocalService;

}