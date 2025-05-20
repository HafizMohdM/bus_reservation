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
 * Provides a wrapper for {@link RefundRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RefundRequestLocalService
 * @generated
 */
public class RefundRequestLocalServiceWrapper
	implements RefundRequestLocalService,
			   ServiceWrapper<RefundRequestLocalService> {

	public RefundRequestLocalServiceWrapper() {
		this(null);
	}

	public RefundRequestLocalServiceWrapper(
		RefundRequestLocalService refundRequestLocalService) {

		_refundRequestLocalService = refundRequestLocalService;
	}

	/**
	 * Adds the refund request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefundRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refundRequest the refund request
	 * @return the refund request that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest addRefundRequest(
		com.esq.bus.reservation.slayers.model.RefundRequest refundRequest) {

		return _refundRequestLocalService.addRefundRequest(refundRequest);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refundRequestLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new refund request with the primary key. Does not add the refund request to the database.
	 *
	 * @param requestId the primary key for the new refund request
	 * @return the new refund request
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest
		createRefundRequest(long requestId) {

		return _refundRequestLocalService.createRefundRequest(requestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refundRequestLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the refund request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefundRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request that was removed
	 * @throws PortalException if a refund request with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest
			deleteRefundRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refundRequestLocalService.deleteRefundRequest(requestId);
	}

	/**
	 * Deletes the refund request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefundRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refundRequest the refund request
	 * @return the refund request that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest
		deleteRefundRequest(
			com.esq.bus.reservation.slayers.model.RefundRequest refundRequest) {

		return _refundRequestLocalService.deleteRefundRequest(refundRequest);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _refundRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _refundRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _refundRequestLocalService.dynamicQuery();
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

		return _refundRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.RefundRequestModelImpl</code>.
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

		return _refundRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.RefundRequestModelImpl</code>.
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

		return _refundRequestLocalService.dynamicQuery(
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

		return _refundRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _refundRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest
		fetchRefundRequest(long requestId) {

		return _refundRequestLocalService.fetchRefundRequest(requestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _refundRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _refundRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _refundRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refundRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the refund request with the primary key.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request
	 * @throws PortalException if a refund request with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest getRefundRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refundRequestLocalService.getRefundRequest(requestId);
	}

	/**
	 * Returns a range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @return the range of refund requests
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.RefundRequest>
		getRefundRequests(int start, int end) {

		return _refundRequestLocalService.getRefundRequests(start, end);
	}

	/**
	 * Returns the number of refund requests.
	 *
	 * @return the number of refund requests
	 */
	@Override
	public int getRefundRequestsCount() {
		return _refundRequestLocalService.getRefundRequestsCount();
	}

	/**
	 * Updates the refund request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefundRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refundRequest the refund request
	 * @return the refund request that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.RefundRequest
		updateRefundRequest(
			com.esq.bus.reservation.slayers.model.RefundRequest refundRequest) {

		return _refundRequestLocalService.updateRefundRequest(refundRequest);
	}

	@Override
	public RefundRequestLocalService getWrappedService() {
		return _refundRequestLocalService;
	}

	@Override
	public void setWrappedService(
		RefundRequestLocalService refundRequestLocalService) {

		_refundRequestLocalService = refundRequestLocalService;
	}

	private RefundRequestLocalService _refundRequestLocalService;

}