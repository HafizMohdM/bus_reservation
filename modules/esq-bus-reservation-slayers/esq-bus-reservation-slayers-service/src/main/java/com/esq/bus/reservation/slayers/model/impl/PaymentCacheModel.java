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

import com.esq.bus.reservation.slayers.model.Payment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Payment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PaymentCacheModel implements CacheModel<Payment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PaymentCacheModel)) {
			return false;
		}

		PaymentCacheModel paymentCacheModel = (PaymentCacheModel)object;

		if (paymentId == paymentCacheModel.paymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{paymentId=");
		sb.append(paymentId);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", amountPaid=");
		sb.append(amountPaid);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Payment toEntityModel() {
		PaymentImpl paymentImpl = new PaymentImpl();

		paymentImpl.setPaymentId(paymentId);
		paymentImpl.setBookingId(bookingId);
		paymentImpl.setAmountPaid(amountPaid);

		if (paymentDate == Long.MIN_VALUE) {
			paymentImpl.setPaymentDate(null);
		}
		else {
			paymentImpl.setPaymentDate(new Date(paymentDate));
		}

		paymentImpl.setUserId(userId);

		paymentImpl.resetOriginalValues();

		return paymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paymentId = objectInput.readLong();

		bookingId = objectInput.readLong();

		amountPaid = objectInput.readDouble();
		paymentDate = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(paymentId);

		objectOutput.writeLong(bookingId);

		objectOutput.writeDouble(amountPaid);
		objectOutput.writeLong(paymentDate);

		objectOutput.writeLong(userId);
	}

	public long paymentId;
	public long bookingId;
	public double amountPaid;
	public long paymentDate;
	public long userId;

}