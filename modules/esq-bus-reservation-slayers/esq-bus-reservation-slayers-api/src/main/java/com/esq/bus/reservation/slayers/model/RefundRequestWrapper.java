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
 * This class is a wrapper for {@link RefundRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefundRequest
 * @generated
 */
public class RefundRequestWrapper
	extends BaseModelWrapper<RefundRequest>
	implements ModelWrapper<RefundRequest>, RefundRequest {

	public RefundRequestWrapper(RefundRequest refundRequest) {
		super(refundRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requestId", getRequestId());
		attributes.put("bookingId", getBookingId());
		attributes.put("reason", getReason());
		attributes.put("status", getStatus());
		attributes.put("requestDate", getRequestDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date requestDate = (Date)attributes.get("requestDate");

		if (requestDate != null) {
			setRequestDate(requestDate);
		}
	}

	@Override
	public RefundRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the booking ID of this refund request.
	 *
	 * @return the booking ID of this refund request
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the primary key of this refund request.
	 *
	 * @return the primary key of this refund request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this refund request.
	 *
	 * @return the reason of this refund request
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the request date of this refund request.
	 *
	 * @return the request date of this refund request
	 */
	@Override
	public Date getRequestDate() {
		return model.getRequestDate();
	}

	/**
	 * Returns the request ID of this refund request.
	 *
	 * @return the request ID of this refund request
	 */
	@Override
	public long getRequestId() {
		return model.getRequestId();
	}

	/**
	 * Returns the status of this refund request.
	 *
	 * @return the status of this refund request
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the booking ID of this refund request.
	 *
	 * @param bookingId the booking ID of this refund request
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the primary key of this refund request.
	 *
	 * @param primaryKey the primary key of this refund request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this refund request.
	 *
	 * @param reason the reason of this refund request
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the request date of this refund request.
	 *
	 * @param requestDate the request date of this refund request
	 */
	@Override
	public void setRequestDate(Date requestDate) {
		model.setRequestDate(requestDate);
	}

	/**
	 * Sets the request ID of this refund request.
	 *
	 * @param requestId the request ID of this refund request
	 */
	@Override
	public void setRequestId(long requestId) {
		model.setRequestId(requestId);
	}

	/**
	 * Sets the status of this refund request.
	 *
	 * @param status the status of this refund request
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RefundRequestWrapper wrap(RefundRequest refundRequest) {
		return new RefundRequestWrapper(refundRequest);
	}

}