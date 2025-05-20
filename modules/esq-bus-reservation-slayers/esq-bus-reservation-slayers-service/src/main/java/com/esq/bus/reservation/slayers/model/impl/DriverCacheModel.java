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

import com.esq.bus.reservation.slayers.model.Driver;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Driver in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DriverCacheModel implements CacheModel<Driver>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DriverCacheModel)) {
			return false;
		}

		DriverCacheModel driverCacheModel = (DriverCacheModel)object;

		if (driverId == driverCacheModel.driverId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, driverId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{driverId=");
		sb.append(driverId);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", driverContact=");
		sb.append(driverContact);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Driver toEntityModel() {
		DriverImpl driverImpl = new DriverImpl();

		driverImpl.setDriverId(driverId);

		if (driverName == null) {
			driverImpl.setDriverName("");
		}
		else {
			driverImpl.setDriverName(driverName);
		}

		if (driverContact == null) {
			driverImpl.setDriverContact("");
		}
		else {
			driverImpl.setDriverContact(driverContact);
		}

		driverImpl.setUserId(userId);

		driverImpl.resetOriginalValues();

		return driverImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		driverId = objectInput.readLong();
		driverName = objectInput.readUTF();
		driverContact = objectInput.readUTF();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(driverId);

		if (driverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		if (driverContact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverContact);
		}

		objectOutput.writeLong(userId);
	}

	public long driverId;
	public String driverName;
	public String driverContact;
	public long userId;

}