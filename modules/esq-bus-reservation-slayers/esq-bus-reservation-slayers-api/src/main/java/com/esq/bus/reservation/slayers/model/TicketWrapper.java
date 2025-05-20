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
 * This class is a wrapper for {@link Ticket}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ticket
 * @generated
 */
public class TicketWrapper
	extends BaseModelWrapper<Ticket> implements ModelWrapper<Ticket>, Ticket {

	public TicketWrapper(Ticket ticket) {
		super(ticket);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketId", getTicketId());
		attributes.put("bookingId", getBookingId());
		attributes.put("qrCode", getQrCode());
		attributes.put("issuedDate", getIssuedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketId = (Long)attributes.get("ticketId");

		if (ticketId != null) {
			setTicketId(ticketId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		String qrCode = (String)attributes.get("qrCode");

		if (qrCode != null) {
			setQrCode(qrCode);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}
	}

	@Override
	public Ticket cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the booking ID of this ticket.
	 *
	 * @return the booking ID of this ticket
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the issued date of this ticket.
	 *
	 * @return the issued date of this ticket
	 */
	@Override
	public Date getIssuedDate() {
		return model.getIssuedDate();
	}

	/**
	 * Returns the primary key of this ticket.
	 *
	 * @return the primary key of this ticket
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the qr code of this ticket.
	 *
	 * @return the qr code of this ticket
	 */
	@Override
	public String getQrCode() {
		return model.getQrCode();
	}

	/**
	 * Returns the ticket ID of this ticket.
	 *
	 * @return the ticket ID of this ticket
	 */
	@Override
	public long getTicketId() {
		return model.getTicketId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the booking ID of this ticket.
	 *
	 * @param bookingId the booking ID of this ticket
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the issued date of this ticket.
	 *
	 * @param issuedDate the issued date of this ticket
	 */
	@Override
	public void setIssuedDate(Date issuedDate) {
		model.setIssuedDate(issuedDate);
	}

	/**
	 * Sets the primary key of this ticket.
	 *
	 * @param primaryKey the primary key of this ticket
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qr code of this ticket.
	 *
	 * @param qrCode the qr code of this ticket
	 */
	@Override
	public void setQrCode(String qrCode) {
		model.setQrCode(qrCode);
	}

	/**
	 * Sets the ticket ID of this ticket.
	 *
	 * @param ticketId the ticket ID of this ticket
	 */
	@Override
	public void setTicketId(long ticketId) {
		model.setTicketId(ticketId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TicketWrapper wrap(Ticket ticket) {
		return new TicketWrapper(ticket);
	}

}