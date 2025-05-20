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

import com.esq.bus.reservation.slayers.model.TravelSchedule;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelSchedule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TravelScheduleCacheModel
	implements CacheModel<TravelSchedule>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelScheduleCacheModel)) {
			return false;
		}

		TravelScheduleCacheModel travelScheduleCacheModel =
			(TravelScheduleCacheModel)object;

		if (scheduleId == travelScheduleCacheModel.scheduleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, scheduleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{scheduleId=");
		sb.append(scheduleId);
		sb.append(", busId=");
		sb.append(busId);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", startingPoint=");
		sb.append(startingPoint);
		sb.append(", destination=");
		sb.append(destination);
		sb.append(", scheduleDate=");
		sb.append(scheduleDate);
		sb.append(", departureTime=");
		sb.append(departureTime);
		sb.append(", estimatedArrivalTime=");
		sb.append(estimatedArrivalTime);
		sb.append(", fareAmount=");
		sb.append(fareAmount);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelSchedule toEntityModel() {
		TravelScheduleImpl travelScheduleImpl = new TravelScheduleImpl();

		travelScheduleImpl.setScheduleId(scheduleId);
		travelScheduleImpl.setBusId(busId);
		travelScheduleImpl.setDriverId(driverId);

		if (startingPoint == null) {
			travelScheduleImpl.setStartingPoint("");
		}
		else {
			travelScheduleImpl.setStartingPoint(startingPoint);
		}

		if (destination == null) {
			travelScheduleImpl.setDestination("");
		}
		else {
			travelScheduleImpl.setDestination(destination);
		}

		if (scheduleDate == Long.MIN_VALUE) {
			travelScheduleImpl.setScheduleDate(null);
		}
		else {
			travelScheduleImpl.setScheduleDate(new Date(scheduleDate));
		}

		if (departureTime == Long.MIN_VALUE) {
			travelScheduleImpl.setDepartureTime(null);
		}
		else {
			travelScheduleImpl.setDepartureTime(new Date(departureTime));
		}

		if (estimatedArrivalTime == Long.MIN_VALUE) {
			travelScheduleImpl.setEstimatedArrivalTime(null);
		}
		else {
			travelScheduleImpl.setEstimatedArrivalTime(
				new Date(estimatedArrivalTime));
		}

		travelScheduleImpl.setFareAmount(fareAmount);

		if (remarks == null) {
			travelScheduleImpl.setRemarks("");
		}
		else {
			travelScheduleImpl.setRemarks(remarks);
		}

		travelScheduleImpl.setUserId(userId);

		travelScheduleImpl.resetOriginalValues();

		return travelScheduleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scheduleId = objectInput.readLong();

		busId = objectInput.readLong();

		driverId = objectInput.readLong();
		startingPoint = objectInput.readUTF();
		destination = objectInput.readUTF();
		scheduleDate = objectInput.readLong();
		departureTime = objectInput.readLong();
		estimatedArrivalTime = objectInput.readLong();

		fareAmount = objectInput.readDouble();
		remarks = objectInput.readUTF();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(scheduleId);

		objectOutput.writeLong(busId);

		objectOutput.writeLong(driverId);

		if (startingPoint == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startingPoint);
		}

		if (destination == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(destination);
		}

		objectOutput.writeLong(scheduleDate);
		objectOutput.writeLong(departureTime);
		objectOutput.writeLong(estimatedArrivalTime);

		objectOutput.writeDouble(fareAmount);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(userId);
	}

	public long scheduleId;
	public long busId;
	public long driverId;
	public String startingPoint;
	public String destination;
	public long scheduleDate;
	public long departureTime;
	public long estimatedArrivalTime;
	public double fareAmount;
	public String remarks;
	public long userId;

}