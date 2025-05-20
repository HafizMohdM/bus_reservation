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
 * Provides a wrapper for {@link DiscountLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DiscountLocalService
 * @generated
 */
public class DiscountLocalServiceWrapper
	implements DiscountLocalService, ServiceWrapper<DiscountLocalService> {

	public DiscountLocalServiceWrapper() {
		this(null);
	}

	public DiscountLocalServiceWrapper(
		DiscountLocalService discountLocalService) {

		_discountLocalService = discountLocalService;
	}

	/**
	 * Adds the discount to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param discount the discount
	 * @return the discount that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Discount addDiscount(
		com.esq.bus.reservation.slayers.model.Discount discount) {

		return _discountLocalService.addDiscount(discount);
	}

	/**
	 * Creates a new discount with the primary key. Does not add the discount to the database.
	 *
	 * @param discountId the primary key for the new discount
	 * @return the new discount
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Discount createDiscount(
		long discountId) {

		return _discountLocalService.createDiscount(discountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _discountLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the discount from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param discount the discount
	 * @return the discount that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Discount deleteDiscount(
		com.esq.bus.reservation.slayers.model.Discount discount) {

		return _discountLocalService.deleteDiscount(discount);
	}

	/**
	 * Deletes the discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount that was removed
	 * @throws PortalException if a discount with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Discount deleteDiscount(
			long discountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _discountLocalService.deleteDiscount(discountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _discountLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _discountLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _discountLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _discountLocalService.dynamicQuery();
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

		return _discountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DiscountModelImpl</code>.
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

		return _discountLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DiscountModelImpl</code>.
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

		return _discountLocalService.dynamicQuery(
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

		return _discountLocalService.dynamicQueryCount(dynamicQuery);
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

		return _discountLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.Discount fetchDiscount(
		long discountId) {

		return _discountLocalService.fetchDiscount(discountId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _discountLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the discount with the primary key.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount
	 * @throws PortalException if a discount with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Discount getDiscount(
			long discountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _discountLocalService.getDiscount(discountId);
	}

	/**
	 * Returns a range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @return the range of discounts
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.Discount>
		getDiscounts(int start, int end) {

		return _discountLocalService.getDiscounts(start, end);
	}

	/**
	 * Returns the number of discounts.
	 *
	 * @return the number of discounts
	 */
	@Override
	public int getDiscountsCount() {
		return _discountLocalService.getDiscountsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _discountLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _discountLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _discountLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the discount in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DiscountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param discount the discount
	 * @return the discount that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.Discount updateDiscount(
		com.esq.bus.reservation.slayers.model.Discount discount) {

		return _discountLocalService.updateDiscount(discount);
	}

	@Override
	public DiscountLocalService getWrappedService() {
		return _discountLocalService;
	}

	@Override
	public void setWrappedService(DiscountLocalService discountLocalService) {
		_discountLocalService = discountLocalService;
	}

	private DiscountLocalService _discountLocalService;

}