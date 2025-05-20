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
 * This class is a wrapper for {@link TransactionLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLog
 * @generated
 */
public class TransactionLogWrapper
	extends BaseModelWrapper<TransactionLog>
	implements ModelWrapper<TransactionLog>, TransactionLog {

	public TransactionLogWrapper(TransactionLog transactionLog) {
		super(transactionLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logId", getLogId());
		attributes.put("action", getAction());
		attributes.put("timestamp", getTimestamp());
		attributes.put("userId", getUserId());
		attributes.put("bookingId", getBookingId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logId = (Long)attributes.get("logId");

		if (logId != null) {
			setLogId(logId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}
	}

	@Override
	public TransactionLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action of this transaction log.
	 *
	 * @return the action of this transaction log
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the booking ID of this transaction log.
	 *
	 * @return the booking ID of this transaction log
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the log ID of this transaction log.
	 *
	 * @return the log ID of this transaction log
	 */
	@Override
	public long getLogId() {
		return model.getLogId();
	}

	/**
	 * Returns the primary key of this transaction log.
	 *
	 * @return the primary key of this transaction log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the timestamp of this transaction log.
	 *
	 * @return the timestamp of this transaction log
	 */
	@Override
	public Date getTimestamp() {
		return model.getTimestamp();
	}

	/**
	 * Returns the user ID of this transaction log.
	 *
	 * @return the user ID of this transaction log
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this transaction log.
	 *
	 * @return the user uuid of this transaction log
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
	 * Sets the action of this transaction log.
	 *
	 * @param action the action of this transaction log
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the booking ID of this transaction log.
	 *
	 * @param bookingId the booking ID of this transaction log
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the log ID of this transaction log.
	 *
	 * @param logId the log ID of this transaction log
	 */
	@Override
	public void setLogId(long logId) {
		model.setLogId(logId);
	}

	/**
	 * Sets the primary key of this transaction log.
	 *
	 * @param primaryKey the primary key of this transaction log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the timestamp of this transaction log.
	 *
	 * @param timestamp the timestamp of this transaction log
	 */
	@Override
	public void setTimestamp(Date timestamp) {
		model.setTimestamp(timestamp);
	}

	/**
	 * Sets the user ID of this transaction log.
	 *
	 * @param userId the user ID of this transaction log
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this transaction log.
	 *
	 * @param userUuid the user uuid of this transaction log
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
	protected TransactionLogWrapper wrap(TransactionLog transactionLog) {
		return new TransactionLogWrapper(transactionLog);
	}

}