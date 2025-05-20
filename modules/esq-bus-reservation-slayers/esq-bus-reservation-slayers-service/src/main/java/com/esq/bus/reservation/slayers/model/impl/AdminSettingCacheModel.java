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

import com.esq.bus.reservation.slayers.model.AdminSetting;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AdminSetting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AdminSettingCacheModel
	implements CacheModel<AdminSetting>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AdminSettingCacheModel)) {
			return false;
		}

		AdminSettingCacheModel adminSettingCacheModel =
			(AdminSettingCacheModel)object;

		if (settingId == adminSettingCacheModel.settingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, settingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{settingId=");
		sb.append(settingId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdminSetting toEntityModel() {
		AdminSettingImpl adminSettingImpl = new AdminSettingImpl();

		adminSettingImpl.setSettingId(settingId);

		if (key == null) {
			adminSettingImpl.setKey("");
		}
		else {
			adminSettingImpl.setKey(key);
		}

		if (value == null) {
			adminSettingImpl.setValue("");
		}
		else {
			adminSettingImpl.setValue(value);
		}

		adminSettingImpl.resetOriginalValues();

		return adminSettingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		settingId = objectInput.readLong();
		key = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(settingId);

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long settingId;
	public String key;
	public String value;

}