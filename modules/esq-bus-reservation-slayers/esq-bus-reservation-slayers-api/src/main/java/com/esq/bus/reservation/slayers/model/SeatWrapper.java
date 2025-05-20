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
 * This class is a wrapper for {@link Seat}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Seat
 * @generated
 */
public class SeatWrapper
	extends BaseModelWrapper<Seat> implements ModelWrapper<Seat>, Seat {

	public SeatWrapper(Seat seat) {
		super(seat);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seatId", getSeatId());
		attributes.put("scheduleId", getScheduleId());
		attributes.put("seatNumber", getSeatNumber());
		attributes.put("isBooked", isIsBooked());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seatId = (Long)attributes.get("seatId");

		if (seatId != null) {
			setSeatId(seatId);
		}

		Long scheduleId = (Long)attributes.get("scheduleId");

		if (scheduleId != null) {
			setScheduleId(scheduleId);
		}

		String seatNumber = (String)attributes.get("seatNumber");

		if (seatNumber != null) {
			setSeatNumber(seatNumber);
		}

		Boolean isBooked = (Boolean)attributes.get("isBooked");

		if (isBooked != null) {
			setIsBooked(isBooked);
		}
	}

	@Override
	public Seat cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the is booked of this seat.
	 *
	 * @return the is booked of this seat
	 */
	@Override
	public boolean getIsBooked() {
		return model.getIsBooked();
	}

	/**
	 * Returns the primary key of this seat.
	 *
	 * @return the primary key of this seat
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule ID of this seat.
	 *
	 * @return the schedule ID of this seat
	 */
	@Override
	public long getScheduleId() {
		return model.getScheduleId();
	}

	/**
	 * Returns the seat ID of this seat.
	 *
	 * @return the seat ID of this seat
	 */
	@Override
	public long getSeatId() {
		return model.getSeatId();
	}

	/**
	 * Returns the seat number of this seat.
	 *
	 * @return the seat number of this seat
	 */
	@Override
	public String getSeatNumber() {
		return model.getSeatNumber();
	}

	/**
	 * Returns <code>true</code> if this seat is is booked.
	 *
	 * @return <code>true</code> if this seat is is booked; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsBooked() {
		return model.isIsBooked();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this seat is is booked.
	 *
	 * @param isBooked the is booked of this seat
	 */
	@Override
	public void setIsBooked(boolean isBooked) {
		model.setIsBooked(isBooked);
	}

	/**
	 * Sets the primary key of this seat.
	 *
	 * @param primaryKey the primary key of this seat
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule ID of this seat.
	 *
	 * @param scheduleId the schedule ID of this seat
	 */
	@Override
	public void setScheduleId(long scheduleId) {
		model.setScheduleId(scheduleId);
	}

	/**
	 * Sets the seat ID of this seat.
	 *
	 * @param seatId the seat ID of this seat
	 */
	@Override
	public void setSeatId(long seatId) {
		model.setSeatId(seatId);
	}

	/**
	 * Sets the seat number of this seat.
	 *
	 * @param seatNumber the seat number of this seat
	 */
	@Override
	public void setSeatNumber(String seatNumber) {
		model.setSeatNumber(seatNumber);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SeatWrapper wrap(Seat seat) {
		return new SeatWrapper(seat);
	}

}