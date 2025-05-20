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
 * This class is a wrapper for {@link User}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see User
 * @generated
 */
public class UserWrapper
	extends BaseModelWrapper<User> implements ModelWrapper<User>, User {

	public UserWrapper(User user) {
		super(user);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("fullName", getFullName());
		attributes.put("contactNo", getContactNo());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("username", getUsername());
		attributes.put("userpassword", getUserpassword());
		attributes.put("accountCategory", getAccountCategory());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String contactNo = (String)attributes.get("contactNo");

		if (contactNo != null) {
			setContactNo(contactNo);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String userpassword = (String)attributes.get("userpassword");

		if (userpassword != null) {
			setUserpassword(userpassword);
		}

		Integer accountCategory = (Integer)attributes.get("accountCategory");

		if (accountCategory != null) {
			setAccountCategory(accountCategory);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}
	}

	@Override
	public User cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account category of this user.
	 *
	 * @return the account category of this user
	 */
	@Override
	public int getAccountCategory() {
		return model.getAccountCategory();
	}

	/**
	 * Returns the account status of this user.
	 *
	 * @return the account status of this user
	 */
	@Override
	public int getAccountStatus() {
		return model.getAccountStatus();
	}

	/**
	 * Returns the contact no of this user.
	 *
	 * @return the contact no of this user
	 */
	@Override
	public String getContactNo() {
		return model.getContactNo();
	}

	/**
	 * Returns the email address of this user.
	 *
	 * @return the email address of this user
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the full name of this user.
	 *
	 * @return the full name of this user
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the primary key of this user.
	 *
	 * @return the primary key of this user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user.
	 *
	 * @return the user ID of this user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the username of this user.
	 *
	 * @return the username of this user
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	/**
	 * Returns the userpassword of this user.
	 *
	 * @return the userpassword of this user
	 */
	@Override
	public String getUserpassword() {
		return model.getUserpassword();
	}

	/**
	 * Returns the user uuid of this user.
	 *
	 * @return the user uuid of this user
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
	 * Sets the account category of this user.
	 *
	 * @param accountCategory the account category of this user
	 */
	@Override
	public void setAccountCategory(int accountCategory) {
		model.setAccountCategory(accountCategory);
	}

	/**
	 * Sets the account status of this user.
	 *
	 * @param accountStatus the account status of this user
	 */
	@Override
	public void setAccountStatus(int accountStatus) {
		model.setAccountStatus(accountStatus);
	}

	/**
	 * Sets the contact no of this user.
	 *
	 * @param contactNo the contact no of this user
	 */
	@Override
	public void setContactNo(String contactNo) {
		model.setContactNo(contactNo);
	}

	/**
	 * Sets the email address of this user.
	 *
	 * @param emailAddress the email address of this user
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the full name of this user.
	 *
	 * @param fullName the full name of this user
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the primary key of this user.
	 *
	 * @param primaryKey the primary key of this user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user.
	 *
	 * @param userId the user ID of this user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the username of this user.
	 *
	 * @param username the username of this user
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	/**
	 * Sets the userpassword of this user.
	 *
	 * @param userpassword the userpassword of this user
	 */
	@Override
	public void setUserpassword(String userpassword) {
		model.setUserpassword(userpassword);
	}

	/**
	 * Sets the user uuid of this user.
	 *
	 * @param userUuid the user uuid of this user
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
	protected UserWrapper wrap(User user) {
		return new UserWrapper(user);
	}

}