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
 * This class is a wrapper for {@link Bus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Bus
 * @generated
 */
public class BusWrapper
	extends BaseModelWrapper<Bus> implements Bus, ModelWrapper<Bus> {

	public BusWrapper(Bus bus) {
		super(bus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("busId", getBusId());
		attributes.put("busNumber", getBusNumber());
		attributes.put("busPlateNumber", getBusPlateNumber());
		attributes.put("busType", getBusType());
		attributes.put("capacity", getCapacity());
		attributes.put("userId", getUserId());
		attributes.put("image1", getImage1());
		attributes.put("image2", getImage2());
		attributes.put("image3", getImage3());
		attributes.put("image4", getImage4());
		attributes.put("image5", getImage5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		String busNumber = (String)attributes.get("busNumber");

		if (busNumber != null) {
			setBusNumber(busNumber);
		}

		String busPlateNumber = (String)attributes.get("busPlateNumber");

		if (busPlateNumber != null) {
			setBusPlateNumber(busPlateNumber);
		}

		Integer busType = (Integer)attributes.get("busType");

		if (busType != null) {
			setBusType(busType);
		}

		Integer capacity = (Integer)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String image1 = (String)attributes.get("image1");

		if (image1 != null) {
			setImage1(image1);
		}

		String image2 = (String)attributes.get("image2");

		if (image2 != null) {
			setImage2(image2);
		}

		String image3 = (String)attributes.get("image3");

		if (image3 != null) {
			setImage3(image3);
		}

		String image4 = (String)attributes.get("image4");

		if (image4 != null) {
			setImage4(image4);
		}

		String image5 = (String)attributes.get("image5");

		if (image5 != null) {
			setImage5(image5);
		}
	}

	@Override
	public Bus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bus ID of this bus.
	 *
	 * @return the bus ID of this bus
	 */
	@Override
	public long getBusId() {
		return model.getBusId();
	}

	/**
	 * Returns the bus number of this bus.
	 *
	 * @return the bus number of this bus
	 */
	@Override
	public String getBusNumber() {
		return model.getBusNumber();
	}

	/**
	 * Returns the bus plate number of this bus.
	 *
	 * @return the bus plate number of this bus
	 */
	@Override
	public String getBusPlateNumber() {
		return model.getBusPlateNumber();
	}

	/**
	 * Returns the bus type of this bus.
	 *
	 * @return the bus type of this bus
	 */
	@Override
	public int getBusType() {
		return model.getBusType();
	}

	/**
	 * Returns the capacity of this bus.
	 *
	 * @return the capacity of this bus
	 */
	@Override
	public int getCapacity() {
		return model.getCapacity();
	}

	/**
	 * Returns the image1 of this bus.
	 *
	 * @return the image1 of this bus
	 */
	@Override
	public String getImage1() {
		return model.getImage1();
	}

	/**
	 * Returns the image2 of this bus.
	 *
	 * @return the image2 of this bus
	 */
	@Override
	public String getImage2() {
		return model.getImage2();
	}

	/**
	 * Returns the image3 of this bus.
	 *
	 * @return the image3 of this bus
	 */
	@Override
	public String getImage3() {
		return model.getImage3();
	}

	/**
	 * Returns the image4 of this bus.
	 *
	 * @return the image4 of this bus
	 */
	@Override
	public String getImage4() {
		return model.getImage4();
	}

	/**
	 * Returns the image5 of this bus.
	 *
	 * @return the image5 of this bus
	 */
	@Override
	public String getImage5() {
		return model.getImage5();
	}

	/**
	 * Returns the primary key of this bus.
	 *
	 * @return the primary key of this bus
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this bus.
	 *
	 * @return the user ID of this bus
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this bus.
	 *
	 * @return the user uuid of this bus
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
	 * Sets the bus ID of this bus.
	 *
	 * @param busId the bus ID of this bus
	 */
	@Override
	public void setBusId(long busId) {
		model.setBusId(busId);
	}

	/**
	 * Sets the bus number of this bus.
	 *
	 * @param busNumber the bus number of this bus
	 */
	@Override
	public void setBusNumber(String busNumber) {
		model.setBusNumber(busNumber);
	}

	/**
	 * Sets the bus plate number of this bus.
	 *
	 * @param busPlateNumber the bus plate number of this bus
	 */
	@Override
	public void setBusPlateNumber(String busPlateNumber) {
		model.setBusPlateNumber(busPlateNumber);
	}

	/**
	 * Sets the bus type of this bus.
	 *
	 * @param busType the bus type of this bus
	 */
	@Override
	public void setBusType(int busType) {
		model.setBusType(busType);
	}

	/**
	 * Sets the capacity of this bus.
	 *
	 * @param capacity the capacity of this bus
	 */
	@Override
	public void setCapacity(int capacity) {
		model.setCapacity(capacity);
	}

	/**
	 * Sets the image1 of this bus.
	 *
	 * @param image1 the image1 of this bus
	 */
	@Override
	public void setImage1(String image1) {
		model.setImage1(image1);
	}

	/**
	 * Sets the image2 of this bus.
	 *
	 * @param image2 the image2 of this bus
	 */
	@Override
	public void setImage2(String image2) {
		model.setImage2(image2);
	}

	/**
	 * Sets the image3 of this bus.
	 *
	 * @param image3 the image3 of this bus
	 */
	@Override
	public void setImage3(String image3) {
		model.setImage3(image3);
	}

	/**
	 * Sets the image4 of this bus.
	 *
	 * @param image4 the image4 of this bus
	 */
	@Override
	public void setImage4(String image4) {
		model.setImage4(image4);
	}

	/**
	 * Sets the image5 of this bus.
	 *
	 * @param image5 the image5 of this bus
	 */
	@Override
	public void setImage5(String image5) {
		model.setImage5(image5);
	}

	/**
	 * Sets the primary key of this bus.
	 *
	 * @param primaryKey the primary key of this bus
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this bus.
	 *
	 * @param userId the user ID of this bus
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this bus.
	 *
	 * @param userUuid the user uuid of this bus
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
	protected BusWrapper wrap(Bus bus) {
		return new BusWrapper(bus);
	}

}