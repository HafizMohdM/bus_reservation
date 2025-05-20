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

import com.esq.bus.reservation.slayers.model.Passenger;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Passenger in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PassengerCacheModel
	implements CacheModel<Passenger>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PassengerCacheModel)) {
			return false;
		}

		PassengerCacheModel passengerCacheModel = (PassengerCacheModel)object;

		if (passengerId == passengerCacheModel.passengerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, passengerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{passengerId=");
		sb.append(passengerId);
		sb.append(", passengerName=");
		sb.append(passengerName);
		sb.append(", passengerContact=");
		sb.append(passengerContact);
		sb.append(", passengerEmail=");
		sb.append(passengerEmail);
		sb.append(", username=");
		sb.append(username);
		sb.append(", password=");
		sb.append(password);
		sb.append(", accountStatus=");
		sb.append(accountStatus);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Passenger toEntityModel() {
		PassengerImpl passengerImpl = new PassengerImpl();

		passengerImpl.setPassengerId(passengerId);

		if (passengerName == null) {
			passengerImpl.setPassengerName("");
		}
		else {
			passengerImpl.setPassengerName(passengerName);
		}

		if (passengerContact == null) {
			passengerImpl.setPassengerContact("");
		}
		else {
			passengerImpl.setPassengerContact(passengerContact);
		}

		if (passengerEmail == null) {
			passengerImpl.setPassengerEmail("");
		}
		else {
			passengerImpl.setPassengerEmail(passengerEmail);
		}

		if (username == null) {
			passengerImpl.setUsername("");
		}
		else {
			passengerImpl.setUsername(username);
		}

		if (password == null) {
			passengerImpl.setPassword("");
		}
		else {
			passengerImpl.setPassword(password);
		}

		passengerImpl.setAccountStatus(accountStatus);
		passengerImpl.setUserId(userId);

		passengerImpl.resetOriginalValues();

		return passengerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		passengerId = objectInput.readLong();
		passengerName = objectInput.readUTF();
		passengerContact = objectInput.readUTF();
		passengerEmail = objectInput.readUTF();
		username = objectInput.readUTF();
		password = objectInput.readUTF();

		accountStatus = objectInput.readInt();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(passengerId);

		if (passengerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passengerName);
		}

		if (passengerContact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passengerContact);
		}

		if (passengerEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passengerEmail);
		}

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeInt(accountStatus);

		objectOutput.writeLong(userId);
	}

	public long passengerId;
	public String passengerName;
	public String passengerContact;
	public String passengerEmail;
	public String username;
	public String password;
	public int accountStatus;
	public long userId;

}