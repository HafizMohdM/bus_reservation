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

import com.esq.bus.reservation.slayers.model.Seat;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Seat in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SeatCacheModel implements CacheModel<Seat>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SeatCacheModel)) {
			return false;
		}

		SeatCacheModel seatCacheModel = (SeatCacheModel)object;

		if (seatId == seatCacheModel.seatId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, seatId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{seatId=");
		sb.append(seatId);
		sb.append(", scheduleId=");
		sb.append(scheduleId);
		sb.append(", seatNumber=");
		sb.append(seatNumber);
		sb.append(", isBooked=");
		sb.append(isBooked);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Seat toEntityModel() {
		SeatImpl seatImpl = new SeatImpl();

		seatImpl.setSeatId(seatId);
		seatImpl.setScheduleId(scheduleId);

		if (seatNumber == null) {
			seatImpl.setSeatNumber("");
		}
		else {
			seatImpl.setSeatNumber(seatNumber);
		}

		seatImpl.setIsBooked(isBooked);

		seatImpl.resetOriginalValues();

		return seatImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		seatId = objectInput.readLong();

		scheduleId = objectInput.readLong();
		seatNumber = objectInput.readUTF();

		isBooked = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(seatId);

		objectOutput.writeLong(scheduleId);

		if (seatNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(seatNumber);
		}

		objectOutput.writeBoolean(isBooked);
	}

	public long seatId;
	public long scheduleId;
	public String seatNumber;
	public boolean isBooked;

}