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
 * Provides a wrapper for {@link TravelScheduleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TravelScheduleLocalService
 * @generated
 */
public class TravelScheduleLocalServiceWrapper
	implements ServiceWrapper<TravelScheduleLocalService>,
			   TravelScheduleLocalService {

	public TravelScheduleLocalServiceWrapper() {
		this(null);
	}

	public TravelScheduleLocalServiceWrapper(
		TravelScheduleLocalService travelScheduleLocalService) {

		_travelScheduleLocalService = travelScheduleLocalService;
	}

	/**
	 * Adds the travel schedule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelSchedule the travel schedule
	 * @return the travel schedule that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
		addTravelSchedule(
			com.esq.bus.reservation.slayers.model.TravelSchedule
				travelSchedule) {

		return _travelScheduleLocalService.addTravelSchedule(travelSchedule);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelScheduleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new travel schedule with the primary key. Does not add the travel schedule to the database.
	 *
	 * @param scheduleId the primary key for the new travel schedule
	 * @return the new travel schedule
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
		createTravelSchedule(long scheduleId) {

		return _travelScheduleLocalService.createTravelSchedule(scheduleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelScheduleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the travel schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule that was removed
	 * @throws PortalException if a travel schedule with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
			deleteTravelSchedule(long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelScheduleLocalService.deleteTravelSchedule(scheduleId);
	}

	/**
	 * Deletes the travel schedule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelSchedule the travel schedule
	 * @return the travel schedule that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
		deleteTravelSchedule(
			com.esq.bus.reservation.slayers.model.TravelSchedule
				travelSchedule) {

		return _travelScheduleLocalService.deleteTravelSchedule(travelSchedule);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _travelScheduleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _travelScheduleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelScheduleLocalService.dynamicQuery();
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

		return _travelScheduleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TravelScheduleModelImpl</code>.
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

		return _travelScheduleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TravelScheduleModelImpl</code>.
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

		return _travelScheduleLocalService.dynamicQuery(
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

		return _travelScheduleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _travelScheduleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
		fetchTravelSchedule(long scheduleId) {

		return _travelScheduleLocalService.fetchTravelSchedule(scheduleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelScheduleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelScheduleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelScheduleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelScheduleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the travel schedule with the primary key.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule
	 * @throws PortalException if a travel schedule with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
			getTravelSchedule(long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelScheduleLocalService.getTravelSchedule(scheduleId);
	}

	/**
	 * Returns a range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @return the range of travel schedules
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.TravelSchedule>
		getTravelSchedules(int start, int end) {

		return _travelScheduleLocalService.getTravelSchedules(start, end);
	}

	/**
	 * Returns the number of travel schedules.
	 *
	 * @return the number of travel schedules
	 */
	@Override
	public int getTravelSchedulesCount() {
		return _travelScheduleLocalService.getTravelSchedulesCount();
	}

	/**
	 * Updates the travel schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelSchedule the travel schedule
	 * @return the travel schedule that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TravelSchedule
		updateTravelSchedule(
			com.esq.bus.reservation.slayers.model.TravelSchedule
				travelSchedule) {

		return _travelScheduleLocalService.updateTravelSchedule(travelSchedule);
	}

	@Override
	public TravelScheduleLocalService getWrappedService() {
		return _travelScheduleLocalService;
	}

	@Override
	public void setWrappedService(
		TravelScheduleLocalService travelScheduleLocalService) {

		_travelScheduleLocalService = travelScheduleLocalService;
	}

	private TravelScheduleLocalService _travelScheduleLocalService;

}