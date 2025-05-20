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
 * Provides a wrapper for {@link BusUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BusUserLocalService
 * @generated
 */
public class BusUserLocalServiceWrapper
	implements BusUserLocalService, ServiceWrapper<BusUserLocalService> {

	public BusUserLocalServiceWrapper() {
		this(null);
	}

	public BusUserLocalServiceWrapper(BusUserLocalService busUserLocalService) {
		_busUserLocalService = busUserLocalService;
	}

	/**
	 * Adds the bus user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param busUser the bus user
	 * @return the bus user that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.BusUser addBusUser(
		com.esq.bus.reservation.slayers.model.BusUser busUser) {

		return _busUserLocalService.addBusUser(busUser);
	}

	/**
	 * Creates a new bus user with the primary key. Does not add the bus user to the database.
	 *
	 * @param userId the primary key for the new bus user
	 * @return the new bus user
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.BusUser createBusUser(
		long userId) {

		return _busUserLocalService.createBusUser(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _busUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the bus user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param busUser the bus user
	 * @return the bus user that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.BusUser deleteBusUser(
		com.esq.bus.reservation.slayers.model.BusUser busUser) {

		return _busUserLocalService.deleteBusUser(busUser);
	}

	/**
	 * Deletes the bus user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user that was removed
	 * @throws PortalException if a bus user with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.BusUser deleteBusUser(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _busUserLocalService.deleteBusUser(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _busUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _busUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _busUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _busUserLocalService.dynamicQuery();
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

		return _busUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.BusUserModelImpl</code>.
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

		return _busUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.BusUserModelImpl</code>.
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

		return _busUserLocalService.dynamicQuery(
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

		return _busUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _busUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.BusUser fetchBusUser(
		long userId) {

		return _busUserLocalService.fetchBusUser(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _busUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bus user with the primary key.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user
	 * @throws PortalException if a bus user with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.BusUser getBusUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _busUserLocalService.getBusUser(userId);
	}

	/**
	 * Returns a range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of bus users
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.BusUser>
		getBusUsers(int start, int end) {

		return _busUserLocalService.getBusUsers(start, end);
	}

	/**
	 * Returns the number of bus users.
	 *
	 * @return the number of bus users
	 */
	@Override
	public int getBusUsersCount() {
		return _busUserLocalService.getBusUsersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _busUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _busUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _busUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bus user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BusUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param busUser the bus user
	 * @return the bus user that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.BusUser updateBusUser(
		com.esq.bus.reservation.slayers.model.BusUser busUser) {

		return _busUserLocalService.updateBusUser(busUser);
	}

	@Override
	public BusUserLocalService getWrappedService() {
		return _busUserLocalService;
	}

	@Override
	public void setWrappedService(BusUserLocalService busUserLocalService) {
		_busUserLocalService = busUserLocalService;
	}

	private BusUserLocalService _busUserLocalService;

}