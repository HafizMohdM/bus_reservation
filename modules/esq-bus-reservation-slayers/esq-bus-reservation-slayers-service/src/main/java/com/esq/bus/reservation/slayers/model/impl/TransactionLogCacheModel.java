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

import com.esq.bus.reservation.slayers.model.TransactionLog;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TransactionLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TransactionLogCacheModel
	implements CacheModel<TransactionLog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TransactionLogCacheModel)) {
			return false;
		}

		TransactionLogCacheModel transactionLogCacheModel =
			(TransactionLogCacheModel)object;

		if (logId == transactionLogCacheModel.logId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, logId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{logId=");
		sb.append(logId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TransactionLog toEntityModel() {
		TransactionLogImpl transactionLogImpl = new TransactionLogImpl();

		transactionLogImpl.setLogId(logId);

		if (action == null) {
			transactionLogImpl.setAction("");
		}
		else {
			transactionLogImpl.setAction(action);
		}

		if (timestamp == Long.MIN_VALUE) {
			transactionLogImpl.setTimestamp(null);
		}
		else {
			transactionLogImpl.setTimestamp(new Date(timestamp));
		}

		transactionLogImpl.setUserId(userId);
		transactionLogImpl.setBookingId(bookingId);

		transactionLogImpl.resetOriginalValues();

		return transactionLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		logId = objectInput.readLong();
		action = objectInput.readUTF();
		timestamp = objectInput.readLong();

		userId = objectInput.readLong();

		bookingId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(logId);

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		objectOutput.writeLong(timestamp);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(bookingId);
	}

	public long logId;
	public String action;
	public long timestamp;
	public long userId;
	public long bookingId;

}