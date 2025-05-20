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

package com.esq.bus.reservation.slayers.model.impl;

import com.esq.bus.reservation.slayers.model.Ticket;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ticket in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketCacheModel implements CacheModel<Ticket>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TicketCacheModel)) {
			return false;
		}

		TicketCacheModel ticketCacheModel = (TicketCacheModel)object;

		if (ticketId == ticketCacheModel.ticketId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ticketId=");
		sb.append(ticketId);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", qrCode=");
		sb.append(qrCode);
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ticket toEntityModel() {
		TicketImpl ticketImpl = new TicketImpl();

		ticketImpl.setTicketId(ticketId);
		ticketImpl.setBookingId(bookingId);

		if (qrCode == null) {
			ticketImpl.setQrCode("");
		}
		else {
			ticketImpl.setQrCode(qrCode);
		}

		if (issuedDate == Long.MIN_VALUE) {
			ticketImpl.setIssuedDate(null);
		}
		else {
			ticketImpl.setIssuedDate(new Date(issuedDate));
		}

		ticketImpl.resetOriginalValues();

		return ticketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketId = objectInput.readLong();

		bookingId = objectInput.readLong();
		qrCode = objectInput.readUTF();
		issuedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketId);

		objectOutput.writeLong(bookingId);

		if (qrCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qrCode);
		}

		objectOutput.writeLong(issuedDate);
	}

	public long ticketId;
	public long bookingId;
	public String qrCode;
	public long issuedDate;

}