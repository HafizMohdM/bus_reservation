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

import com.esq.bus.reservation.slayers.exception.NoSuchPaymentException;
import com.esq.bus.reservation.slayers.model.Payment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentUtil
 * @generated
 */
@ProviderType
public interface PaymentPersistence extends BasePersistence<Payment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PaymentUtil} to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the payments where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the matching payments
	 */
	public java.util.List<Payment> findBybookingId(long bookingId);

	/**
	 * Returns a range of all the payments where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of matching payments
	 */
	public java.util.List<Payment> findBybookingId(
		long bookingId, int start, int end);

	/**
	 * Returns an ordered range of all the payments where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payments
	 */
	public java.util.List<Payment> findBybookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the payments where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payments
	 */
	public java.util.List<Payment> findBybookingId(
		long bookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	public Payment findBybookingId_First(
			long bookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Payment>
				orderByComparator)
		throws NoSuchPaymentException;

	/**
	 * Returns the first payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment, or <code>null</code> if a matching payment could not be found
	 */
	public Payment fetchBybookingId_First(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment>
			orderByComparator);

	/**
	 * Returns the last payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	public Payment findBybookingId_Last(
			long bookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Payment>
				orderByComparator)
		throws NoSuchPaymentException;

	/**
	 * Returns the last payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment, or <code>null</code> if a matching payment could not be found
	 */
	public Payment fetchBybookingId_Last(
		long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment>
			orderByComparator);

	/**
	 * Returns the payments before and after the current payment in the ordered set where bookingId = &#63;.
	 *
	 * @param paymentId the primary key of the current payment
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	public Payment[] findBybookingId_PrevAndNext(
			long paymentId, long bookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Payment>
				orderByComparator)
		throws NoSuchPaymentException;

	/**
	 * Removes all the payments where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 */
	public void removeBybookingId(long bookingId);

	/**
	 * Returns the number of payments where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching payments
	 */
	public int countBybookingId(long bookingId);

	/**
	 * Caches the payment in the entity cache if it is enabled.
	 *
	 * @param payment the payment
	 */
	public void cacheResult(Payment payment);

	/**
	 * Caches the payments in the entity cache if it is enabled.
	 *
	 * @param payments the payments
	 */
	public void cacheResult(java.util.List<Payment> payments);

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	public Payment create(long paymentId);

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	public Payment remove(long paymentId) throws NoSuchPaymentException;

	public Payment updateImpl(Payment payment);

	/**
	 * Returns the payment with the primary key or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	public Payment findByPrimaryKey(long paymentId)
		throws NoSuchPaymentException;

	/**
	 * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment, or <code>null</code> if a payment with the primary key could not be found
	 */
	public Payment fetchByPrimaryKey(long paymentId);

	/**
	 * Returns all the payments.
	 *
	 * @return the payments
	 */
	public java.util.List<Payment> findAll();

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	public java.util.List<Payment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payments
	 */
	public java.util.List<Payment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payments
	 */
	public java.util.List<Payment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the payments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	public int countAll();

}