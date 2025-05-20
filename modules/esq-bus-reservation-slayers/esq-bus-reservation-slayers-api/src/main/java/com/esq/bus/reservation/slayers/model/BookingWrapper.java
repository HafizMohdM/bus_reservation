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
 * This class is a wrapper for {@link Booking}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking
 * @generated
 */
public class BookingWrapper
	extends BaseModelWrapper<Booking>
	implements Booking, ModelWrapper<Booking> {

	public BookingWrapper(Booking booking) {
		super(booking);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("scheduleId", getScheduleId());
		attributes.put("passengerId", getPassengerId());
		attributes.put("numberOfSeats", getNumberOfSeats());
		attributes.put("fareAmount", getFareAmount());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("dateOfBooking", getDateOfBooking());
		attributes.put("bookingStatus", getBookingStatus());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long scheduleId = (Long)attributes.get("scheduleId");

		if (scheduleId != null) {
			setScheduleId(scheduleId);
		}

		Long passengerId = (Long)attributes.get("passengerId");

		if (passengerId != null) {
			setPassengerId(passengerId);
		}

		Integer numberOfSeats = (Integer)attributes.get("numberOfSeats");

		if (numberOfSeats != null) {
			setNumberOfSeats(numberOfSeats);
		}

		Double fareAmount = (Double)attributes.get("fareAmount");

		if (fareAmount != null) {
			setFareAmount(fareAmount);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		Date dateOfBooking = (Date)attributes.get("dateOfBooking");

		if (dateOfBooking != null) {
			setDateOfBooking(dateOfBooking);
		}

		Integer bookingStatus = (Integer)attributes.get("bookingStatus");

		if (bookingStatus != null) {
			setBookingStatus(bookingStatus);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Booking cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the booking ID of this booking.
	 *
	 * @return the booking ID of this booking
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the booking status of this booking.
	 *
	 * @return the booking status of this booking
	 */
	@Override
	public int getBookingStatus() {
		return model.getBookingStatus();
	}

	/**
	 * Returns the date of booking of this booking.
	 *
	 * @return the date of booking of this booking
	 */
	@Override
	public Date getDateOfBooking() {
		return model.getDateOfBooking();
	}

	/**
	 * Returns the fare amount of this booking.
	 *
	 * @return the fare amount of this booking
	 */
	@Override
	public double getFareAmount() {
		return model.getFareAmount();
	}

	/**
	 * Returns the number of seats of this booking.
	 *
	 * @return the number of seats of this booking
	 */
	@Override
	public int getNumberOfSeats() {
		return model.getNumberOfSeats();
	}

	/**
	 * Returns the passenger ID of this booking.
	 *
	 * @return the passenger ID of this booking
	 */
	@Override
	public long getPassengerId() {
		return model.getPassengerId();
	}

	/**
	 * Returns the primary key of this booking.
	 *
	 * @return the primary key of this booking
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule ID of this booking.
	 *
	 * @return the schedule ID of this booking
	 */
	@Override
	public long getScheduleId() {
		return model.getScheduleId();
	}

	/**
	 * Returns the total amount of this booking.
	 *
	 * @return the total amount of this booking
	 */
	@Override
	public double getTotalAmount() {
		return model.getTotalAmount();
	}

	/**
	 * Returns the user ID of this booking.
	 *
	 * @return the user ID of this booking
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this booking.
	 *
	 * @return the user uuid of this booking
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
	 * Sets the booking ID of this booking.
	 *
	 * @param bookingId the booking ID of this booking
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the booking status of this booking.
	 *
	 * @param bookingStatus the booking status of this booking
	 */
	@Override
	public void setBookingStatus(int bookingStatus) {
		model.setBookingStatus(bookingStatus);
	}

	/**
	 * Sets the date of booking of this booking.
	 *
	 * @param dateOfBooking the date of booking of this booking
	 */
	@Override
	public void setDateOfBooking(Date dateOfBooking) {
		model.setDateOfBooking(dateOfBooking);
	}

	/**
	 * Sets the fare amount of this booking.
	 *
	 * @param fareAmount the fare amount of this booking
	 */
	@Override
	public void setFareAmount(double fareAmount) {
		model.setFareAmount(fareAmount);
	}

	/**
	 * Sets the number of seats of this booking.
	 *
	 * @param numberOfSeats the number of seats of this booking
	 */
	@Override
	public void setNumberOfSeats(int numberOfSeats) {
		model.setNumberOfSeats(numberOfSeats);
	}

	/**
	 * Sets the passenger ID of this booking.
	 *
	 * @param passengerId the passenger ID of this booking
	 */
	@Override
	public void setPassengerId(long passengerId) {
		model.setPassengerId(passengerId);
	}

	/**
	 * Sets the primary key of this booking.
	 *
	 * @param primaryKey the primary key of this booking
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule ID of this booking.
	 *
	 * @param scheduleId the schedule ID of this booking
	 */
	@Override
	public void setScheduleId(long scheduleId) {
		model.setScheduleId(scheduleId);
	}

	/**
	 * Sets the total amount of this booking.
	 *
	 * @param totalAmount the total amount of this booking
	 */
	@Override
	public void setTotalAmount(double totalAmount) {
		model.setTotalAmount(totalAmount);
	}

	/**
	 * Sets the user ID of this booking.
	 *
	 * @param userId the user ID of this booking
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this booking.
	 *
	 * @param userUuid the user uuid of this booking
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
	protected BookingWrapper wrap(Booking booking) {
		return new BookingWrapper(booking);
	}

}