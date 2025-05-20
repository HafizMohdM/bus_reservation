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
 * This class is a wrapper for {@link Driver}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Driver
 * @generated
 */
public class DriverWrapper
	extends BaseModelWrapper<Driver> implements Driver, ModelWrapper<Driver> {

	public DriverWrapper(Driver driver) {
		super(driver);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("driverId", getDriverId());
		attributes.put("driverName", getDriverName());
		attributes.put("driverContact", getDriverContact());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String driverContact = (String)attributes.get("driverContact");

		if (driverContact != null) {
			setDriverContact(driverContact);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Driver cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the driver contact of this driver.
	 *
	 * @return the driver contact of this driver
	 */
	@Override
	public String getDriverContact() {
		return model.getDriverContact();
	}

	/**
	 * Returns the driver ID of this driver.
	 *
	 * @return the driver ID of this driver
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the driver name of this driver.
	 *
	 * @return the driver name of this driver
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the primary key of this driver.
	 *
	 * @return the primary key of this driver
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this driver.
	 *
	 * @return the user ID of this driver
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this driver.
	 *
	 * @return the user uuid of this driver
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
	 * Sets the driver contact of this driver.
	 *
	 * @param driverContact the driver contact of this driver
	 */
	@Override
	public void setDriverContact(String driverContact) {
		model.setDriverContact(driverContact);
	}

	/**
	 * Sets the driver ID of this driver.
	 *
	 * @param driverId the driver ID of this driver
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the driver name of this driver.
	 *
	 * @param driverName the driver name of this driver
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the primary key of this driver.
	 *
	 * @param primaryKey the primary key of this driver
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this driver.
	 *
	 * @param userId the user ID of this driver
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this driver.
	 *
	 * @param userUuid the user uuid of this driver
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
	protected DriverWrapper wrap(Driver driver) {
		return new DriverWrapper(driver);
	}

}