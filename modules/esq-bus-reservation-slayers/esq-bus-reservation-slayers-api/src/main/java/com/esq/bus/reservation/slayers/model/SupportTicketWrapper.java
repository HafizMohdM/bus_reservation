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
 * This class is a wrapper for {@link SupportTicket}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportTicket
 * @generated
 */
public class SupportTicketWrapper
	extends BaseModelWrapper<SupportTicket>
	implements ModelWrapper<SupportTicket>, SupportTicket {

	public SupportTicketWrapper(SupportTicket supportTicket) {
		super(supportTicket);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supportTicketId", getSupportTicketId());
		attributes.put("userId", getUserId());
		attributes.put("subject", getSubject());
		attributes.put("message", getMessage());
		attributes.put("status", getStatus());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supportTicketId = (Long)attributes.get("supportTicketId");

		if (supportTicketId != null) {
			setSupportTicketId(supportTicketId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public SupportTicket cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created date of this support ticket.
	 *
	 * @return the created date of this support ticket
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the message of this support ticket.
	 *
	 * @return the message of this support ticket
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the primary key of this support ticket.
	 *
	 * @return the primary key of this support ticket
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this support ticket.
	 *
	 * @return the status of this support ticket
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subject of this support ticket.
	 *
	 * @return the subject of this support ticket
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the support ticket ID of this support ticket.
	 *
	 * @return the support ticket ID of this support ticket
	 */
	@Override
	public long getSupportTicketId() {
		return model.getSupportTicketId();
	}

	/**
	 * Returns the user ID of this support ticket.
	 *
	 * @return the user ID of this support ticket
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this support ticket.
	 *
	 * @return the user uuid of this support ticket
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
	 * Sets the created date of this support ticket.
	 *
	 * @param createdDate the created date of this support ticket
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the message of this support ticket.
	 *
	 * @param message the message of this support ticket
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the primary key of this support ticket.
	 *
	 * @param primaryKey the primary key of this support ticket
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this support ticket.
	 *
	 * @param status the status of this support ticket
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subject of this support ticket.
	 *
	 * @param subject the subject of this support ticket
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the support ticket ID of this support ticket.
	 *
	 * @param supportTicketId the support ticket ID of this support ticket
	 */
	@Override
	public void setSupportTicketId(long supportTicketId) {
		model.setSupportTicketId(supportTicketId);
	}

	/**
	 * Sets the user ID of this support ticket.
	 *
	 * @param userId the user ID of this support ticket
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this support ticket.
	 *
	 * @param userUuid the user uuid of this support ticket
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
	protected SupportTicketWrapper wrap(SupportTicket supportTicket) {
		return new SupportTicketWrapper(supportTicket);
	}

}