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

import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Booking service. Represents a row in the &quot;BOOKRESERVATION_Booking&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.esq.bus.reservation.slayers.model.impl.BookingModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.esq.bus.reservation.slayers.model.impl.BookingImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking
 * @generated
 */
@ProviderType
public interface BookingModel extends BaseModel<Booking> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a booking model instance should use the {@link Booking} interface instead.
	 */

	/**
	 * Returns the primary key of this booking.
	 *
	 * @return the primary key of this booking
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this booking.
	 *
	 * @param primaryKey the primary key of this booking
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the booking ID of this booking.
	 *
	 * @return the booking ID of this booking
	 */
	public long getBookingId();

	/**
	 * Sets the booking ID of this booking.
	 *
	 * @param bookingId the booking ID of this booking
	 */
	public void setBookingId(long bookingId);

	/**
	 * Returns the schedule ID of this booking.
	 *
	 * @return the schedule ID of this booking
	 */
	public long getScheduleId();

	/**
	 * Sets the schedule ID of this booking.
	 *
	 * @param scheduleId the schedule ID of this booking
	 */
	public void setScheduleId(long scheduleId);

	/**
	 * Returns the passenger ID of this booking.
	 *
	 * @return the passenger ID of this booking
	 */
	public long getPassengerId();

	/**
	 * Sets the passenger ID of this booking.
	 *
	 * @param passengerId the passenger ID of this booking
	 */
	public void setPassengerId(long passengerId);

	/**
	 * Returns the number of seats of this booking.
	 *
	 * @return the number of seats of this booking
	 */
	public int getNumberOfSeats();

	/**
	 * Sets the number of seats of this booking.
	 *
	 * @param numberOfSeats the number of seats of this booking
	 */
	public void setNumberOfSeats(int numberOfSeats);

	/**
	 * Returns the fare amount of this booking.
	 *
	 * @return the fare amount of this booking
	 */
	public double getFareAmount();

	/**
	 * Sets the fare amount of this booking.
	 *
	 * @param fareAmount the fare amount of this booking
	 */
	public void setFareAmount(double fareAmount);

	/**
	 * Returns the total amount of this booking.
	 *
	 * @return the total amount of this booking
	 */
	public double getTotalAmount();

	/**
	 * Sets the total amount of this booking.
	 *
	 * @param totalAmount the total amount of this booking
	 */
	public void setTotalAmount(double totalAmount);

	/**
	 * Returns the date of booking of this booking.
	 *
	 * @return the date of booking of this booking
	 */
	public Date getDateOfBooking();

	/**
	 * Sets the date of booking of this booking.
	 *
	 * @param dateOfBooking the date of booking of this booking
	 */
	public void setDateOfBooking(Date dateOfBooking);

	/**
	 * Returns the booking status of this booking.
	 *
	 * @return the booking status of this booking
	 */
	public int getBookingStatus();

	/**
	 * Sets the booking status of this booking.
	 *
	 * @param bookingStatus the booking status of this booking
	 */
	public void setBookingStatus(int bookingStatus);

	/**
	 * Returns the user ID of this booking.
	 *
	 * @return the user ID of this booking
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this booking.
	 *
	 * @param userId the user ID of this booking
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this booking.
	 *
	 * @return the user uuid of this booking
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this booking.
	 *
	 * @param userUuid the user uuid of this booking
	 */
	public void setUserUuid(String userUuid);

	@Override
	public Booking cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}