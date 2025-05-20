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

import com.esq.bus.reservation.slayers.exception.NoSuchDiscountException;
import com.esq.bus.reservation.slayers.model.Discount;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiscountUtil
 * @generated
 */
@ProviderType
public interface DiscountPersistence extends BasePersistence<Discount> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DiscountUtil} to access the discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the discounts where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching discounts
	 */
	public java.util.List<Discount> findBycode(String code);

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
	public java.util.List<Discount> findBycode(String code, int start, int end);

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
	public java.util.List<Discount> findBycode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Discount>
			orderByComparator);

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
	public java.util.List<Discount> findBycode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Discount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching discount
	 * @throws NoSuchDiscountException if a matching discount could not be found
	 */
	public Discount findBycode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Discount>
				orderByComparator)
		throws NoSuchDiscountException;

	/**
	 * Returns the first discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching discount, or <code>null</code> if a matching discount could not be found
	 */
	public Discount fetchBycode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Discount>
			orderByComparator);

	/**
	 * Returns the last discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching discount
	 * @throws NoSuchDiscountException if a matching discount could not be found
	 */
	public Discount findBycode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Discount>
				orderByComparator)
		throws NoSuchDiscountException;

	/**
	 * Returns the last discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching discount, or <code>null</code> if a matching discount could not be found
	 */
	public Discount fetchBycode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Discount>
			orderByComparator);

	/**
	 * Returns the discounts before and after the current discount in the ordered set where code = &#63;.
	 *
	 * @param discountId the primary key of the current discount
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	public Discount[] findBycode_PrevAndNext(
			long discountId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Discount>
				orderByComparator)
		throws NoSuchDiscountException;

	/**
	 * Removes all the discounts where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeBycode(String code);

	/**
	 * Returns the number of discounts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching discounts
	 */
	public int countBycode(String code);

	/**
	 * Caches the discount in the entity cache if it is enabled.
	 *
	 * @param discount the discount
	 */
	public void cacheResult(Discount discount);

	/**
	 * Caches the discounts in the entity cache if it is enabled.
	 *
	 * @param discounts the discounts
	 */
	public void cacheResult(java.util.List<Discount> discounts);

	/**
	 * Creates a new discount with the primary key. Does not add the discount to the database.
	 *
	 * @param discountId the primary key for the new discount
	 * @return the new discount
	 */
	public Discount create(long discountId);

	/**
	 * Removes the discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount that was removed
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	public Discount remove(long discountId) throws NoSuchDiscountException;

	public Discount updateImpl(Discount discount);

	/**
	 * Returns the discount with the primary key or throws a <code>NoSuchDiscountException</code> if it could not be found.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	public Discount findByPrimaryKey(long discountId)
		throws NoSuchDiscountException;

	/**
	 * Returns the discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount, or <code>null</code> if a discount with the primary key could not be found
	 */
	public Discount fetchByPrimaryKey(long discountId);

	/**
	 * Returns all the discounts.
	 *
	 * @return the discounts
	 */
	public java.util.List<Discount> findAll();

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
	public java.util.List<Discount> findAll(int start, int end);

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
	public java.util.List<Discount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Discount>
			orderByComparator);

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
	public java.util.List<Discount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Discount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the discounts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of discounts.
	 *
	 * @return the number of discounts
	 */
	public int countAll();

}