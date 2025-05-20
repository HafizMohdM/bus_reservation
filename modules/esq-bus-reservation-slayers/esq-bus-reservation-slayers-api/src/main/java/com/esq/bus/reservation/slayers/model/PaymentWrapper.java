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

package com.esq.bus.reservation.slayers.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Payment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Payment
 * @generated
 */
public class PaymentWrapper
	extends BaseModelWrapper<Payment>
	implements ModelWrapper<Payment>, Payment {

	public PaymentWrapper(Payment payment) {
		super(payment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paymentId", getPaymentId());
		attributes.put("bookingId", getBookingId());
		attributes.put("amountPaid", getAmountPaid());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long paymentId = (Long)attributes.get("paymentId");

		if (paymentId != null) {
			setPaymentId(paymentId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Double amountPaid = (Double)attributes.get("amountPaid");

		if (amountPaid != null) {
			setAmountPaid(amountPaid);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Payment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the amount paid of this payment.
	 *
	 * @return the amount paid of this payment
	 */
	@Override
	public double getAmountPaid() {
		return model.getAmountPaid();
	}

	/**
	 * Returns the booking ID of this payment.
	 *
	 * @return the booking ID of this payment
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the payment date of this payment.
	 *
	 * @return the payment date of this payment
	 */
	@Override
	public Date getPaymentDate() {
		return model.getPaymentDate();
	}

	/**
	 * Returns the payment ID of this payment.
	 *
	 * @return the payment ID of this payment
	 */
	@Override
	public long getPaymentId() {
		return model.getPaymentId();
	}

	/**
	 * Returns the primary key of this payment.
	 *
	 * @return the primary key of this payment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this payment.
	 *
	 * @return the user ID of this payment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this payment.
	 *
	 * @return the user uuid of this payment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amount paid of this payment.
	 *
	 * @param amountPaid the amount paid of this payment
	 */
	@Override
	public void setAmountPaid(double amountPaid) {
		model.setAmountPaid(amountPaid);
	}

	/**
	 * Sets the booking ID of this payment.
	 *
	 * @param bookingId the booking ID of this payment
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the payment date of this payment.
	 *
	 * @param paymentDate the payment date of this payment
	 */
	@Override
	public void setPaymentDate(Date paymentDate) {
		model.setPaymentDate(paymentDate);
	}

	/**
	 * Sets the payment ID of this payment.
	 *
	 * @param paymentId the payment ID of this payment
	 */
	@Override
	public void setPaymentId(long paymentId) {
		model.setPaymentId(paymentId);
	}

	/**
	 * Sets the primary key of this payment.
	 *
	 * @param primaryKey the primary key of this payment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this payment.
	 *
	 * @param userId the user ID of this payment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this payment.
	 *
	 * @param userUuid the user uuid of this payment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PaymentWrapper wrap(Payment payment) {
		return new PaymentWrapper(payment);
	}

}