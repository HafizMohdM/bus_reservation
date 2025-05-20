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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRole
 * @generated
 */
public class UserRoleWrapper
	extends BaseModelWrapper<UserRole>
	implements ModelWrapper<UserRole>, UserRole {

	public UserRoleWrapper(UserRole userRole) {
		super(userRole);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userRoleId", getUserRoleId());
		attributes.put("userId", getUserId());
		attributes.put("roleName", getRoleName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userRoleId = (Long)attributes.get("userRoleId");

		if (userRoleId != null) {
			setUserRoleId(userRoleId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}
	}

	@Override
	public UserRole cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this user role.
	 *
	 * @return the primary key of this user role
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role name of this user role.
	 *
	 * @return the role name of this user role
	 */
	@Override
	public String getRoleName() {
		return model.getRoleName();
	}

	/**
	 * Returns the user ID of this user role.
	 *
	 * @return the user ID of this user role
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user role ID of this user role.
	 *
	 * @return the user role ID of this user role
	 */
	@Override
	public long getUserRoleId() {
		return model.getUserRoleId();
	}

	/**
	 * Returns the user uuid of this user role.
	 *
	 * @return the user uuid of this user role
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
	 * Sets the primary key of this user role.
	 *
	 * @param primaryKey the primary key of this user role
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role name of this user role.
	 *
	 * @param roleName the role name of this user role
	 */
	@Override
	public void setRoleName(String roleName) {
		model.setRoleName(roleName);
	}

	/**
	 * Sets the user ID of this user role.
	 *
	 * @param userId the user ID of this user role
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user role ID of this user role.
	 *
	 * @param userRoleId the user role ID of this user role
	 */
	@Override
	public void setUserRoleId(long userRoleId) {
		model.setUserRoleId(userRoleId);
	}

	/**
	 * Sets the user uuid of this user role.
	 *
	 * @param userUuid the user uuid of this user role
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
	protected UserRoleWrapper wrap(UserRole userRole) {
		return new UserRoleWrapper(userRole);
	}

}