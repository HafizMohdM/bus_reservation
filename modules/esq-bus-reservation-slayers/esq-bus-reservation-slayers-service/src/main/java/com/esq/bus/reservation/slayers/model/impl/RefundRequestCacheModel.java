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

import com.esq.bus.reservation.slayers.model.RefundRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RefundRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RefundRequestCacheModel
	implements CacheModel<RefundRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RefundRequestCacheModel)) {
			return false;
		}

		RefundRequestCacheModel refundRequestCacheModel =
			(RefundRequestCacheModel)object;

		if (requestId == refundRequestCacheModel.requestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, requestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{requestId=");
		sb.append(requestId);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", status=");
		sb.append(status);
		sb.append(", requestDate=");
		sb.append(requestDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RefundRequest toEntityModel() {
		RefundRequestImpl refundRequestImpl = new RefundRequestImpl();

		refundRequestImpl.setRequestId(requestId);
		refundRequestImpl.setBookingId(bookingId);

		if (reason == null) {
			refundRequestImpl.setReason("");
		}
		else {
			refundRequestImpl.setReason(reason);
		}

		if (status == null) {
			refundRequestImpl.setStatus("");
		}
		else {
			refundRequestImpl.setStatus(status);
		}

		if (requestDate == Long.MIN_VALUE) {
			refundRequestImpl.setRequestDate(null);
		}
		else {
			refundRequestImpl.setRequestDate(new Date(requestDate));
		}

		refundRequestImpl.resetOriginalValues();

		return refundRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requestId = objectInput.readLong();

		bookingId = objectInput.readLong();
		reason = objectInput.readUTF();
		status = objectInput.readUTF();
		requestDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(requestId);

		objectOutput.writeLong(bookingId);

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(requestDate);
	}

	public long requestId;
	public long bookingId;
	public String reason;
	public String status;
	public long requestDate;

}