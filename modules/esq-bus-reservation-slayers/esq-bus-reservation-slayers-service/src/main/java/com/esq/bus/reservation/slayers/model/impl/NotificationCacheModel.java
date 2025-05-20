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

import com.esq.bus.reservation.slayers.model.Notification;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NotificationCacheModel
	implements CacheModel<Notification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotificationCacheModel)) {
			return false;
		}

		NotificationCacheModel notificationCacheModel =
			(NotificationCacheModel)object;

		if (notificationId == notificationCacheModel.notificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{notificationId=");
		sb.append(notificationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", type=");
		sb.append(type);
		sb.append(", sentDate=");
		sb.append(sentDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setNotificationId(notificationId);
		notificationImpl.setUserId(userId);

		if (message == null) {
			notificationImpl.setMessage("");
		}
		else {
			notificationImpl.setMessage(message);
		}

		if (type == null) {
			notificationImpl.setType("");
		}
		else {
			notificationImpl.setType(type);
		}

		if (sentDate == Long.MIN_VALUE) {
			notificationImpl.setSentDate(null);
		}
		else {
			notificationImpl.setSentDate(new Date(sentDate));
		}

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificationId = objectInput.readLong();

		userId = objectInput.readLong();
		message = objectInput.readUTF();
		type = objectInput.readUTF();
		sentDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(notificationId);

		objectOutput.writeLong(userId);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(sentDate);
	}

	public long notificationId;
	public long userId;
	public String message;
	public String type;
	public long sentDate;

}