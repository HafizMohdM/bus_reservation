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

import com.esq.bus.reservation.slayers.model.Bus;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Bus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BusCacheModel implements CacheModel<Bus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BusCacheModel)) {
			return false;
		}

		BusCacheModel busCacheModel = (BusCacheModel)object;

		if (busId == busCacheModel.busId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, busId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{busId=");
		sb.append(busId);
		sb.append(", busNumber=");
		sb.append(busNumber);
		sb.append(", busPlateNumber=");
		sb.append(busPlateNumber);
		sb.append(", busType=");
		sb.append(busType);
		sb.append(", capacity=");
		sb.append(capacity);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", image1=");
		sb.append(image1);
		sb.append(", image2=");
		sb.append(image2);
		sb.append(", image3=");
		sb.append(image3);
		sb.append(", image4=");
		sb.append(image4);
		sb.append(", image5=");
		sb.append(image5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bus toEntityModel() {
		BusImpl busImpl = new BusImpl();

		busImpl.setBusId(busId);

		if (busNumber == null) {
			busImpl.setBusNumber("");
		}
		else {
			busImpl.setBusNumber(busNumber);
		}

		if (busPlateNumber == null) {
			busImpl.setBusPlateNumber("");
		}
		else {
			busImpl.setBusPlateNumber(busPlateNumber);
		}

		busImpl.setBusType(busType);
		busImpl.setCapacity(capacity);
		busImpl.setUserId(userId);

		if (image1 == null) {
			busImpl.setImage1("");
		}
		else {
			busImpl.setImage1(image1);
		}

		if (image2 == null) {
			busImpl.setImage2("");
		}
		else {
			busImpl.setImage2(image2);
		}

		if (image3 == null) {
			busImpl.setImage3("");
		}
		else {
			busImpl.setImage3(image3);
		}

		if (image4 == null) {
			busImpl.setImage4("");
		}
		else {
			busImpl.setImage4(image4);
		}

		if (image5 == null) {
			busImpl.setImage5("");
		}
		else {
			busImpl.setImage5(image5);
		}

		busImpl.resetOriginalValues();

		return busImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		busId = objectInput.readLong();
		busNumber = objectInput.readUTF();
		busPlateNumber = objectInput.readUTF();

		busType = objectInput.readInt();

		capacity = objectInput.readInt();

		userId = objectInput.readLong();
		image1 = objectInput.readUTF();
		image2 = objectInput.readUTF();
		image3 = objectInput.readUTF();
		image4 = objectInput.readUTF();
		image5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(busId);

		if (busNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(busNumber);
		}

		if (busPlateNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(busPlateNumber);
		}

		objectOutput.writeInt(busType);

		objectOutput.writeInt(capacity);

		objectOutput.writeLong(userId);

		if (image1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image1);
		}

		if (image2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image2);
		}

		if (image3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image3);
		}

		if (image4 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image4);
		}

		if (image5 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image5);
		}
	}

	public long busId;
	public String busNumber;
	public String busPlateNumber;
	public int busType;
	public int capacity;
	public long userId;
	public String image1;
	public String image2;
	public String image3;
	public String image4;
	public String image5;

}