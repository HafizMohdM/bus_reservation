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

package com.esq.bus.reservation.slayers.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditLog
 * @generated
 */
public class AuditLogWrapper
	extends BaseModelWrapper<AuditLog>
	implements AuditLog, ModelWrapper<AuditLog> {

	public AuditLogWrapper(AuditLog auditLog) {
		super(auditLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("auditId", getAuditId());
		attributes.put("entityName", getEntityName());
		attributes.put("entityId", getEntityId());
		attributes.put("action", getAction());
		attributes.put("userId", getUserId());
		attributes.put("actionDate", getActionDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long auditId = (Long)attributes.get("auditId");

		if (auditId != null) {
			setAuditId(auditId);
		}

		String entityName = (String)attributes.get("entityName");

		if (entityName != null) {
			setEntityName(entityName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date actionDate = (Date)attributes.get("actionDate");

		if (actionDate != null) {
			setActionDate(actionDate);
		}
	}

	@Override
	public AuditLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action of this audit log.
	 *
	 * @return the action of this audit log
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the action date of this audit log.
	 *
	 * @return the action date of this audit log
	 */
	@Override
	public Date getActionDate() {
		return model.getActionDate();
	}

	/**
	 * Returns the audit ID of this audit log.
	 *
	 * @return the audit ID of this audit log
	 */
	@Override
	public long getAuditId() {
		return model.getAuditId();
	}

	/**
	 * Returns the entity ID of this audit log.
	 *
	 * @return the entity ID of this audit log
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the entity name of this audit log.
	 *
	 * @return the entity name of this audit log
	 */
	@Override
	public String getEntityName() {
		return model.getEntityName();
	}

	/**
	 * Returns the primary key of this audit log.
	 *
	 * @return the primary key of this audit log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this audit log.
	 *
	 * @return the user ID of this audit log
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this audit log.
	 *
	 * @return the user uuid of this audit log
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this audit log.
	 *
	 * @param action the action of this audit log
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the action date of this audit log.
	 *
	 * @param actionDate the action date of this audit log
	 */
	@Override
	public void setActionDate(Date actionDate) {
		model.setActionDate(actionDate);
	}

	/**
	 * Sets the audit ID of this audit log.
	 *
	 * @param auditId the audit ID of this audit log
	 */
	@Override
	public void setAuditId(long auditId) {
		model.setAuditId(auditId);
	}

	/**
	 * Sets the entity ID of this audit log.
	 *
	 * @param entityId the entity ID of this audit log
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the entity name of this audit log.
	 *
	 * @param entityName the entity name of this audit log
	 */
	@Override
	public void setEntityName(String entityName) {
		model.setEntityName(entityName);
	}

	/**
	 * Sets the primary key of this audit log.
	 *
	 * @param primaryKey the primary key of this audit log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this audit log.
	 *
	 * @param userId the user ID of this audit log
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this audit log.
	 *
	 * @param userUuid the user uuid of this audit log
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AuditLogWrapper wrap(AuditLog auditLog) {
		return new AuditLogWrapper(auditLog);
	}

}