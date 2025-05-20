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
 * This class is a wrapper for {@link TravelSchedule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelSchedule
 * @generated
 */
public class TravelScheduleWrapper
	extends BaseModelWrapper<TravelSchedule>
	implements ModelWrapper<TravelSchedule>, TravelSchedule {

	public TravelScheduleWrapper(TravelSchedule travelSchedule) {
		super(travelSchedule);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduleId", getScheduleId());
		attributes.put("busId", getBusId());
		attributes.put("driverId", getDriverId());
		attributes.put("startingPoint", getStartingPoint());
		attributes.put("destination", getDestination());
		attributes.put("scheduleDate", getScheduleDate());
		attributes.put("departureTime", getDepartureTime());
		attributes.put("estimatedArrivalTime", getEstimatedArrivalTime());
		attributes.put("fareAmount", getFareAmount());
		attributes.put("remarks", getRemarks());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scheduleId = (Long)attributes.get("scheduleId");

		if (scheduleId != null) {
			setScheduleId(scheduleId);
		}

		Long busId = (Long)attributes.get("busId");

		if (busId != null) {
			setBusId(busId);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		String startingPoint = (String)attributes.get("startingPoint");

		if (startingPoint != null) {
			setStartingPoint(startingPoint);
		}

		String destination = (String)attributes.get("destination");

		if (destination != null) {
			setDestination(destination);
		}

		Date scheduleDate = (Date)attributes.get("scheduleDate");

		if (scheduleDate != null) {
			setScheduleDate(scheduleDate);
		}

		Date departureTime = (Date)attributes.get("departureTime");

		if (departureTime != null) {
			setDepartureTime(departureTime);
		}

		Date estimatedArrivalTime = (Date)attributes.get(
			"estimatedArrivalTime");

		if (estimatedArrivalTime != null) {
			setEstimatedArrivalTime(estimatedArrivalTime);
		}

		Double fareAmount = (Double)attributes.get("fareAmount");

		if (fareAmount != null) {
			setFareAmount(fareAmount);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public TravelSchedule cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bus ID of this travel schedule.
	 *
	 * @return the bus ID of this travel schedule
	 */
	@Override
	public long getBusId() {
		return model.getBusId();
	}

	/**
	 * Returns the departure time of this travel schedule.
	 *
	 * @return the departure time of this travel schedule
	 */
	@Override
	public Date getDepartureTime() {
		return model.getDepartureTime();
	}

	/**
	 * Returns the destination of this travel schedule.
	 *
	 * @return the destination of this travel schedule
	 */
	@Override
	public String getDestination() {
		return model.getDestination();
	}

	/**
	 * Returns the driver ID of this travel schedule.
	 *
	 * @return the driver ID of this travel schedule
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the estimated arrival time of this travel schedule.
	 *
	 * @return the estimated arrival time of this travel schedule
	 */
	@Override
	public Date getEstimatedArrivalTime() {
		return model.getEstimatedArrivalTime();
	}

	/**
	 * Returns the fare amount of this travel schedule.
	 *
	 * @return the fare amount of this travel schedule
	 */
	@Override
	public double getFareAmount() {
		return model.getFareAmount();
	}

	/**
	 * Returns the primary key of this travel schedule.
	 *
	 * @return the primary key of this travel schedule
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this travel schedule.
	 *
	 * @return the remarks of this travel schedule
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the schedule date of this travel schedule.
	 *
	 * @return the schedule date of this travel schedule
	 */
	@Override
	public Date getScheduleDate() {
		return model.getScheduleDate();
	}

	/**
	 * Returns the schedule ID of this travel schedule.
	 *
	 * @return the schedule ID of this travel schedule
	 */
	@Override
	public long getScheduleId() {
		return model.getScheduleId();
	}

	/**
	 * Returns the starting point of this travel schedule.
	 *
	 * @return the starting point of this travel schedule
	 */
	@Override
	public String getStartingPoint() {
		return model.getStartingPoint();
	}

	/**
	 * Returns the user ID of this travel schedule.
	 *
	 * @return the user ID of this travel schedule
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this travel schedule.
	 *
	 * @return the user uuid of this travel schedule
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
	 * Sets the bus ID of this travel schedule.
	 *
	 * @param busId the bus ID of this travel schedule
	 */
	@Override
	public void setBusId(long busId) {
		model.setBusId(busId);
	}

	/**
	 * Sets the departure time of this travel schedule.
	 *
	 * @param departureTime the departure time of this travel schedule
	 */
	@Override
	public void setDepartureTime(Date departureTime) {
		model.setDepartureTime(departureTime);
	}

	/**
	 * Sets the destination of this travel schedule.
	 *
	 * @param destination the destination of this travel schedule
	 */
	@Override
	public void setDestination(String destination) {
		model.setDestination(destination);
	}

	/**
	 * Sets the driver ID of this travel schedule.
	 *
	 * @param driverId the driver ID of this travel schedule
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the estimated arrival time of this travel schedule.
	 *
	 * @param estimatedArrivalTime the estimated arrival time of this travel schedule
	 */
	@Override
	public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
		model.setEstimatedArrivalTime(estimatedArrivalTime);
	}

	/**
	 * Sets the fare amount of this travel schedule.
	 *
	 * @param fareAmount the fare amount of this travel schedule
	 */
	@Override
	public void setFareAmount(double fareAmount) {
		model.setFareAmount(fareAmount);
	}

	/**
	 * Sets the primary key of this travel schedule.
	 *
	 * @param primaryKey the primary key of this travel schedule
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this travel schedule.
	 *
	 * @param remarks the remarks of this travel schedule
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the schedule date of this travel schedule.
	 *
	 * @param scheduleDate the schedule date of this travel schedule
	 */
	@Override
	public void setScheduleDate(Date scheduleDate) {
		model.setScheduleDate(scheduleDate);
	}

	/**
	 * Sets the schedule ID of this travel schedule.
	 *
	 * @param scheduleId the schedule ID of this travel schedule
	 */
	@Override
	public void setScheduleId(long scheduleId) {
		model.setScheduleId(scheduleId);
	}

	/**
	 * Sets the starting point of this travel schedule.
	 *
	 * @param startingPoint the starting point of this travel schedule
	 */
	@Override
	public void setStartingPoint(String startingPoint) {
		model.setStartingPoint(startingPoint);
	}

	/**
	 * Sets the user ID of this travel schedule.
	 *
	 * @param userId the user ID of this travel schedule
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this travel schedule.
	 *
	 * @param userUuid the user uuid of this travel schedule
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
	protected TravelScheduleWrapper wrap(TravelSchedule travelSchedule) {
		return new TravelScheduleWrapper(travelSchedule);
	}

}