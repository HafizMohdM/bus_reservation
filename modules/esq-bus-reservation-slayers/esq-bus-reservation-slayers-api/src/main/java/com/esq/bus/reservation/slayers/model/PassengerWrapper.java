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
 * This class is a wrapper for {@link Passenger}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Passenger
 * @generated
 */
public class PassengerWrapper
	extends BaseModelWrapper<Passenger>
	implements ModelWrapper<Passenger>, Passenger {

	public PassengerWrapper(Passenger passenger) {
		super(passenger);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("passengerId", getPassengerId());
		attributes.put("passengerName", getPassengerName());
		attributes.put("passengerContact", getPassengerContact());
		attributes.put("passengerEmail", getPassengerEmail());
		attributes.put("username", getUsername());
		attributes.put("password", getPassword());
		attributes.put("accountStatus", getAccountStatus());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long passengerId = (Long)attributes.get("passengerId");

		if (passengerId != null) {
			setPassengerId(passengerId);
		}

		String passengerName = (String)attributes.get("passengerName");

		if (passengerName != null) {
			setPassengerName(passengerName);
		}

		String passengerContact = (String)attributes.get("passengerContact");

		if (passengerContact != null) {
			setPassengerContact(passengerContact);
		}

		String passengerEmail = (String)attributes.get("passengerEmail");

		if (passengerEmail != null) {
			setPassengerEmail(passengerEmail);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Passenger cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account status of this passenger.
	 *
	 * @return the account status of this passenger
	 */
	@Override
	public int getAccountStatus() {
		return model.getAccountStatus();
	}

	/**
	 * Returns the passenger contact of this passenger.
	 *
	 * @return the passenger contact of this passenger
	 */
	@Override
	public String getPassengerContact() {
		return model.getPassengerContact();
	}

	/**
	 * Returns the passenger email of this passenger.
	 *
	 * @return the passenger email of this passenger
	 */
	@Override
	public String getPassengerEmail() {
		return model.getPassengerEmail();
	}

	/**
	 * Returns the passenger ID of this passenger.
	 *
	 * @return the passenger ID of this passenger
	 */
	@Override
	public long getPassengerId() {
		return model.getPassengerId();
	}

	/**
	 * Returns the passenger name of this passenger.
	 *
	 * @return the passenger name of this passenger
	 */
	@Override
	public String getPassengerName() {
		return model.getPassengerName();
	}

	/**
	 * Returns the password of this passenger.
	 *
	 * @return the password of this passenger
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this passenger.
	 *
	 * @return the primary key of this passenger
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this passenger.
	 *
	 * @return the user ID of this passenger
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the username of this passenger.
	 *
	 * @return the username of this passenger
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	/**
	 * Returns the user uuid of this passenger.
	 *
	 * @return the user uuid of this passenger
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
	 * Sets the account status of this passenger.
	 *
	 * @param accountStatus the account status of this passenger
	 */
	@Override
	public void setAccountStatus(int accountStatus) {
		model.setAccountStatus(accountStatus);
	}

	/**
	 * Sets the passenger contact of this passenger.
	 *
	 * @param passengerContact the passenger contact of this passenger
	 */
	@Override
	public void setPassengerContact(String passengerContact) {
		model.setPassengerContact(passengerContact);
	}

	/**
	 * Sets the passenger email of this passenger.
	 *
	 * @param passengerEmail the passenger email of this passenger
	 */
	@Override
	public void setPassengerEmail(String passengerEmail) {
		model.setPassengerEmail(passengerEmail);
	}

	/**
	 * Sets the passenger ID of this passenger.
	 *
	 * @param passengerId the passenger ID of this passenger
	 */
	@Override
	public void setPassengerId(long passengerId) {
		model.setPassengerId(passengerId);
	}

	/**
	 * Sets the passenger name of this passenger.
	 *
	 * @param passengerName the passenger name of this passenger
	 */
	@Override
	public void setPassengerName(String passengerName) {
		model.setPassengerName(passengerName);
	}

	/**
	 * Sets the password of this passenger.
	 *
	 * @param password the password of this passenger
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this passenger.
	 *
	 * @param primaryKey the primary key of this passenger
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this passenger.
	 *
	 * @param userId the user ID of this passenger
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the username of this passenger.
	 *
	 * @param username the username of this passenger
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	/**
	 * Sets the user uuid of this passenger.
	 *
	 * @param userUuid the user uuid of this passenger
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
	protected PassengerWrapper wrap(Passenger passenger) {
		return new PassengerWrapper(passenger);
	}

}