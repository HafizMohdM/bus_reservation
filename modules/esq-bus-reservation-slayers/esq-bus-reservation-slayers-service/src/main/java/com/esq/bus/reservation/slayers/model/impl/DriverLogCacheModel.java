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

import com.esq.bus.reservation.slayers.model.DriverLog;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DriverLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DriverLogCacheModel
	implements CacheModel<DriverLog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DriverLogCacheModel)) {
			return false;
		}

		DriverLogCacheModel driverLogCacheModel = (DriverLogCacheModel)object;

		if (logId == driverLogCacheModel.logId) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{logId=");
		sb.append(logId);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", tripDate=");
		sb.append(tripDate);
		sb.append(", scheduleId=");
		sb.append(scheduleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DriverLog toEntityModel() {
		DriverLogImpl driverLogImpl = new DriverLogImpl();

		driverLogImpl.setLogId(logId);
		driverLogImpl.setDriverId(driverId);

		if (tripDate == Long.MIN_VALUE) {
			driverLogImpl.setTripDate(null);
		}
		else {
			driverLogImpl.setTripDate(new Date(tripDate));
		}

		driverLogImpl.setScheduleId(scheduleId);

		driverLogImpl.resetOriginalValues();

		return driverLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		logId = objectInput.readLong();

		driverId = objectInput.readLong();
		tripDate = objectInput.readLong();

		scheduleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(logId);

		objectOutput.writeLong(driverId);
		objectOutput.writeLong(tripDate);

		objectOutput.writeLong(scheduleId);
	}

	public long logId;
	public long driverId;
	public long tripDate;
	public long scheduleId;

}