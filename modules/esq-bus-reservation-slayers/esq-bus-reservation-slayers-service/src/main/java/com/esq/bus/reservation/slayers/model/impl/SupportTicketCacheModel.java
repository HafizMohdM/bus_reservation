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

import com.esq.bus.reservation.slayers.model.SupportTicket;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupportTicket in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SupportTicketCacheModel
	implements CacheModel<SupportTicket>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SupportTicketCacheModel)) {
			return false;
		}

		SupportTicketCacheModel supportTicketCacheModel =
			(SupportTicketCacheModel)object;

		if (supportTicketId == supportTicketCacheModel.supportTicketId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supportTicketId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{supportTicketId=");
		sb.append(supportTicketId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", message=");
		sb.append(message);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SupportTicket toEntityModel() {
		SupportTicketImpl supportTicketImpl = new SupportTicketImpl();

		supportTicketImpl.setSupportTicketId(supportTicketId);
		supportTicketImpl.setUserId(userId);

		if (subject == null) {
			supportTicketImpl.setSubject("");
		}
		else {
			supportTicketImpl.setSubject(subject);
		}

		if (message == null) {
			supportTicketImpl.setMessage("");
		}
		else {
			supportTicketImpl.setMessage(message);
		}

		if (status == null) {
			supportTicketImpl.setStatus("");
		}
		else {
			supportTicketImpl.setStatus(status);
		}

		if (createdDate == Long.MIN_VALUE) {
			supportTicketImpl.setCreatedDate(null);
		}
		else {
			supportTicketImpl.setCreatedDate(new Date(createdDate));
		}

		supportTicketImpl.resetOriginalValues();

		return supportTicketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supportTicketId = objectInput.readLong();

		userId = objectInput.readLong();
		subject = objectInput.readUTF();
		message = objectInput.readUTF();
		status = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(supportTicketId);

		objectOutput.writeLong(userId);

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(createdDate);
	}

	public long supportTicketId;
	public long userId;
	public String subject;
	public String message;
	public String status;
	public long createdDate;

}