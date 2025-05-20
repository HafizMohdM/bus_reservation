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

import com.esq.bus.reservation.slayers.model.Booking;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Booking in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookingCacheModel implements CacheModel<Booking>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookingCacheModel)) {
			return false;
		}

		BookingCacheModel bookingCacheModel = (BookingCacheModel)object;

		if (bookingId == bookingCacheModel.bookingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bookingId=");
		sb.append(bookingId);
		sb.append(", scheduleId=");
		sb.append(scheduleId);
		sb.append(", passengerId=");
		sb.append(passengerId);
		sb.append(", numberOfSeats=");
		sb.append(numberOfSeats);
		sb.append(", fareAmount=");
		sb.append(fareAmount);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append(", dateOfBooking=");
		sb.append(dateOfBooking);
		sb.append(", bookingStatus=");
		sb.append(bookingStatus);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Booking toEntityModel() {
		BookingImpl bookingImpl = new BookingImpl();

		bookingImpl.setBookingId(bookingId);
		bookingImpl.setScheduleId(scheduleId);
		bookingImpl.setPassengerId(passengerId);
		bookingImpl.setNumberOfSeats(numberOfSeats);
		bookingImpl.setFareAmount(fareAmount);
		bookingImpl.setTotalAmount(totalAmount);

		if (dateOfBooking == Long.MIN_VALUE) {
			bookingImpl.setDateOfBooking(null);
		}
		else {
			bookingImpl.setDateOfBooking(new Date(dateOfBooking));
		}

		bookingImpl.setBookingStatus(bookingStatus);
		bookingImpl.setUserId(userId);

		bookingImpl.resetOriginalValues();

		return bookingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookingId = objectInput.readLong();

		scheduleId = objectInput.readLong();

		passengerId = objectInput.readLong();

		numberOfSeats = objectInput.readInt();

		fareAmount = objectInput.readDouble();

		totalAmount = objectInput.readDouble();
		dateOfBooking = objectInput.readLong();

		bookingStatus = objectInput.readInt();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(scheduleId);

		objectOutput.writeLong(passengerId);

		objectOutput.writeInt(numberOfSeats);

		objectOutput.writeDouble(fareAmount);

		objectOutput.writeDouble(totalAmount);
		objectOutput.writeLong(dateOfBooking);

		objectOutput.writeInt(bookingStatus);

		objectOutput.writeLong(userId);
	}

	public long bookingId;
	public long scheduleId;
	public long passengerId;
	public int numberOfSeats;
	public double fareAmount;
	public double totalAmount;
	public long dateOfBooking;
	public int bookingStatus;
	public long userId;

}