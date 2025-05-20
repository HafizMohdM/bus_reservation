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

package com.esq.bus.reservation.slayers.service.persistence;

import com.esq.bus.reservation.slayers.model.Discount;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the discount service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.DiscountPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiscountPersistence
 * @generated
 */
public class DiscountUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Discount discount) {
		getPersistence().clearCache(discount);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Discount> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Discount> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Discount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Discount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Discount> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Discount update(Discount discount) {
		return getPersistence().update(discount);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Discount update(
		Discount discount, ServiceContext serviceContext) {

		return getPersistence().update(discount, serviceContext);
	}

	/**
	 * Returns all the discounts where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching discounts
	 */
	public static List<Discount> findBycode(String code) {
		return getPersistence().findBycode(code);
	}

	/**
	 * Returns a range of all the discounts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @return the range of matching discounts
	 */
	public static List<Discount> findBycode(String code, int start, int end) {
		return getPersistence().findBycode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the discounts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching discounts
	 */
	public static List<Discount> findBycode(
		String code, int start, int end,
		OrderByComparator<Discount> orderByComparator) {

		return getPersistence().findBycode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the discounts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching discounts
	 */
	public static List<Discount> findBycode(
		String code, int start, int end,
		OrderByComparator<Discount> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching discount
	 * @throws NoSuchDiscountException if a matching discount could not be found
	 */
	public static Discount findBycode_First(
			String code, OrderByComparator<Discount> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDiscountException {

		return getPersistence().findBycode_First(code, orderByComparator);
	}

	/**
	 * Returns the first discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching discount, or <code>null</code> if a matching discount could not be found
	 */
	public static Discount fetchBycode_First(
		String code, OrderByComparator<Discount> orderByComparator) {

		return getPersistence().fetchBycode_First(code, orderByComparator);
	}

	/**
	 * Returns the last discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching discount
	 * @throws NoSuchDiscountException if a matching discount could not be found
	 */
	public static Discount findBycode_Last(
			String code, OrderByComparator<Discount> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDiscountException {

		return getPersistence().findBycode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching discount, or <code>null</code> if a matching discount could not be found
	 */
	public static Discount fetchBycode_Last(
		String code, OrderByComparator<Discount> orderByComparator) {

		return getPersistence().fetchBycode_Last(code, orderByComparator);
	}

	/**
	 * Returns the discounts before and after the current discount in the ordered set where code = &#63;.
	 *
	 * @param discountId the primary key of the current discount
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	public static Discount[] findBycode_PrevAndNext(
			long discountId, String code,
			OrderByComparator<Discount> orderByComparator)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDiscountException {

		return getPersistence().findBycode_PrevAndNext(
			discountId, code, orderByComparator);
	}

	/**
	 * Removes all the discounts where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeBycode(String code) {
		getPersistence().removeBycode(code);
	}

	/**
	 * Returns the number of discounts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching discounts
	 */
	public static int countBycode(String code) {
		return getPersistence().countBycode(code);
	}

	/**
	 * Caches the discount in the entity cache if it is enabled.
	 *
	 * @param discount the discount
	 */
	public static void cacheResult(Discount discount) {
		getPersistence().cacheResult(discount);
	}

	/**
	 * Caches the discounts in the entity cache if it is enabled.
	 *
	 * @param discounts the discounts
	 */
	public static void cacheResult(List<Discount> discounts) {
		getPersistence().cacheResult(discounts);
	}

	/**
	 * Creates a new discount with the primary key. Does not add the discount to the database.
	 *
	 * @param discountId the primary key for the new discount
	 * @return the new discount
	 */
	public static Discount create(long discountId) {
		return getPersistence().create(discountId);
	}

	/**
	 * Removes the discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount that was removed
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	public static Discount remove(long discountId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDiscountException {

		return getPersistence().remove(discountId);
	}

	public static Discount updateImpl(Discount discount) {
		return getPersistence().updateImpl(discount);
	}

	/**
	 * Returns the discount with the primary key or throws a <code>NoSuchDiscountException</code> if it could not be found.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	public static Discount findByPrimaryKey(long discountId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchDiscountException {

		return getPersistence().findByPrimaryKey(discountId);
	}

	/**
	 * Returns the discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount, or <code>null</code> if a discount with the primary key could not be found
	 */
	public static Discount fetchByPrimaryKey(long discountId) {
		return getPersistence().fetchByPrimaryKey(discountId);
	}

	/**
	 * Returns all the discounts.
	 *
	 * @return the discounts
	 */
	public static List<Discount> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @return the range of discounts
	 */
	public static List<Discount> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of discounts
	 */
	public static List<Discount> findAll(
		int start, int end, OrderByComparator<Discount> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of discounts
	 */
	public static List<Discount> findAll(
		int start, int end, OrderByComparator<Discount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the discounts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of discounts.
	 *
	 * @return the number of discounts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DiscountPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DiscountPersistence _persistence;

}