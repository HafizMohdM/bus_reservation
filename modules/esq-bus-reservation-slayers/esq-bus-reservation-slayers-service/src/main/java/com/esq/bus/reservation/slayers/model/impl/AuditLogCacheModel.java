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

import com.esq.bus.reservation.slayers.model.AuditLog;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditLogCacheModel
	implements CacheModel<AuditLog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuditLogCacheModel)) {
			return false;
		}

		AuditLogCacheModel auditLogCacheModel = (AuditLogCacheModel)object;

		if (auditId == auditLogCacheModel.auditId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{auditId=");
		sb.append(auditId);
		sb.append(", entityName=");
		sb.append(entityName);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", actionDate=");
		sb.append(actionDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuditLog toEntityModel() {
		AuditLogImpl auditLogImpl = new AuditLogImpl();

		auditLogImpl.setAuditId(auditId);

		if (entityName == null) {
			auditLogImpl.setEntityName("");
		}
		else {
			auditLogImpl.setEntityName(entityName);
		}

		auditLogImpl.setEntityId(entityId);

		if (action == null) {
			auditLogImpl.setAction("");
		}
		else {
			auditLogImpl.setAction(action);
		}

		auditLogImpl.setUserId(userId);

		if (actionDate == Long.MIN_VALUE) {
			auditLogImpl.setActionDate(null);
		}
		else {
			auditLogImpl.setActionDate(new Date(actionDate));
		}

		auditLogImpl.resetOriginalValues();

		return auditLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		auditId = objectInput.readLong();
		entityName = objectInput.readUTF();

		entityId = objectInput.readLong();
		action = objectInput.readUTF();

		userId = objectInput.readLong();
		actionDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(auditId);

		if (entityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityName);
		}

		objectOutput.writeLong(entityId);

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(actionDate);
	}

	public long auditId;
	public String entityName;
	public long entityId;
	public String action;
	public long userId;
	public long actionDate;

}