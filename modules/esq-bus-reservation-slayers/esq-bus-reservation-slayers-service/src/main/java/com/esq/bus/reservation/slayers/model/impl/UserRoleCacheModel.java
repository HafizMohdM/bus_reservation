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

import com.esq.bus.reservation.slayers.model.UserRole;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRoleCacheModel
	implements CacheModel<UserRole>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRoleCacheModel)) {
			return false;
		}

		UserRoleCacheModel userRoleCacheModel = (UserRoleCacheModel)object;

		if (userRoleId == userRoleCacheModel.userRoleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRoleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userRoleId=");
		sb.append(userRoleId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", roleName=");
		sb.append(roleName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserRole toEntityModel() {
		UserRoleImpl userRoleImpl = new UserRoleImpl();

		userRoleImpl.setUserRoleId(userRoleId);
		userRoleImpl.setUserId(userId);

		if (roleName == null) {
			userRoleImpl.setRoleName("");
		}
		else {
			userRoleImpl.setRoleName(roleName);
		}

		userRoleImpl.resetOriginalValues();

		return userRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRoleId = objectInput.readLong();

		userId = objectInput.readLong();
		roleName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userRoleId);

		objectOutput.writeLong(userId);

		if (roleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleName);
		}
	}

	public long userRoleId;
	public long userId;
	public String roleName;

}