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
 * Provides a wrapper for {@link SupportTicketLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportTicketLocalService
 * @generated
 */
public class SupportTicketLocalServiceWrapper
	implements ServiceWrapper<SupportTicketLocalService>,
			   SupportTicketLocalService {

	public SupportTicketLocalServiceWrapper() {
		this(null);
	}

	public SupportTicketLocalServiceWrapper(
		SupportTicketLocalService supportTicketLocalService) {

		_supportTicketLocalService = supportTicketLocalService;
	}

	/**
	 * Adds the support ticket to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SupportTicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param supportTicket the support ticket
	 * @return the support ticket that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket addSupportTicket(
		com.esq.bus.reservation.slayers.model.SupportTicket supportTicket) {

		return _supportTicketLocalService.addSupportTicket(supportTicket);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTicketLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new support ticket with the primary key. Does not add the support ticket to the database.
	 *
	 * @param supportTicketId the primary key for the new support ticket
	 * @return the new support ticket
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket
		createSupportTicket(long supportTicketId) {

		return _supportTicketLocalService.createSupportTicket(supportTicketId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTicketLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the support ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SupportTicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket that was removed
	 * @throws PortalException if a support ticket with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket
			deleteSupportTicket(long supportTicketId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTicketLocalService.deleteSupportTicket(supportTicketId);
	}

	/**
	 * Deletes the support ticket from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SupportTicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param supportTicket the support ticket
	 * @return the support ticket that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket
		deleteSupportTicket(
			com.esq.bus.reservation.slayers.model.SupportTicket supportTicket) {

		return _supportTicketLocalService.deleteSupportTicket(supportTicket);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _supportTicketLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _supportTicketLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supportTicketLocalService.dynamicQuery();
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

		return _supportTicketLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.SupportTicketModelImpl</code>.
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

		return _supportTicketLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.SupportTicketModelImpl</code>.
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

		return _supportTicketLocalService.dynamicQuery(
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

		return _supportTicketLocalService.dynamicQueryCount(dynamicQuery);
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

		return _supportTicketLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket
		fetchSupportTicket(long supportTicketId) {

		return _supportTicketLocalService.fetchSupportTicket(supportTicketId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _supportTicketLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _supportTicketLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportTicketLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTicketLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the support ticket with the primary key.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket
	 * @throws PortalException if a support ticket with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket getSupportTicket(
			long supportTicketId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTicketLocalService.getSupportTicket(supportTicketId);
	}

	/**
	 * Returns a range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @return the range of support tickets
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.SupportTicket>
		getSupportTickets(int start, int end) {

		return _supportTicketLocalService.getSupportTickets(start, end);
	}

	/**
	 * Returns the number of support tickets.
	 *
	 * @return the number of support tickets
	 */
	@Override
	public int getSupportTicketsCount() {
		return _supportTicketLocalService.getSupportTicketsCount();
	}

	/**
	 * Updates the support ticket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SupportTicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param supportTicket the support ticket
	 * @return the support ticket that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.SupportTicket
		updateSupportTicket(
			com.esq.bus.reservation.slayers.model.SupportTicket supportTicket) {

		return _supportTicketLocalService.updateSupportTicket(supportTicket);
	}

	@Override
	public SupportTicketLocalService getWrappedService() {
		return _supportTicketLocalService;
	}

	@Override
	public void setWrappedService(
		SupportTicketLocalService supportTicketLocalService) {

		_supportTicketLocalService = supportTicketLocalService;
	}

	private SupportTicketLocalService _supportTicketLocalService;

}