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

import com.esq.bus.reservation.slayers.model.BusUser;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BusUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BusUserCacheModel implements CacheModel<BusUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BusUserCacheModel)) {
			return false;
		}

		BusUserCacheModel busUserCacheModel = (BusUserCacheModel)object;

		if (userId == busUserCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", contactNo=");
		sb.append(contactNo);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", username=");
		sb.append(username);
		sb.append(", userpassword=");
		sb.append(userpassword);
		sb.append(", accountCategory=");
		sb.append(accountCategory);
		sb.append(", accountStatus=");
		sb.append(accountStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusUser toEntityModel() {
		BusUserImpl busUserImpl = new BusUserImpl();

		busUserImpl.setUserId(userId);

		if (fullName == null) {
			busUserImpl.setFullName("");
		}
		else {
			busUserImpl.setFullName(fullName);
		}

		if (contactNo == null) {
			busUserImpl.setContactNo("");
		}
		else {
			busUserImpl.setContactNo(contactNo);
		}

		if (emailAddress == null) {
			busUserImpl.setEmailAddress("");
		}
		else {
			busUserImpl.setEmailAddress(emailAddress);
		}

		if (username == null) {
			busUserImpl.setUsername("");
		}
		else {
			busUserImpl.setUsername(username);
		}

		if (userpassword == null) {
			busUserImpl.setUserpassword("");
		}
		else {
			busUserImpl.setUserpassword(userpassword);
		}

		busUserImpl.setAccountCategory(accountCategory);
		busUserImpl.setAccountStatus(accountStatus);

		busUserImpl.resetOriginalValues();

		return busUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		fullName = objectInput.readUTF();
		contactNo = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		username = objectInput.readUTF();
		userpassword = objectInput.readUTF();

		accountCategory = objectInput.readInt();

		accountStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (contactNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNo);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (userpassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userpassword);
		}

		objectOutput.writeInt(accountCategory);

		objectOutput.writeInt(accountStatus);
	}

	public long userId;
	public String fullName;
	public String contactNo;
	public String emailAddress;
	public String username;
	public String userpassword;
	public int accountCategory;
	public int accountStatus;

}