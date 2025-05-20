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
 * This class is a wrapper for {@link DriverLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverLog
 * @generated
 */
public class DriverLogWrapper
	extends BaseModelWrapper<DriverLog>
	implements DriverLog, ModelWrapper<DriverLog> {

	public DriverLogWrapper(DriverLog driverLog) {
		super(driverLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logId", getLogId());
		attributes.put("driverId", getDriverId());
		attributes.put("tripDate", getTripDate());
		attributes.put("scheduleId", getScheduleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logId = (Long)attributes.get("logId");

		if (logId != null) {
			setLogId(logId);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		Date tripDate = (Date)attributes.get("tripDate");

		if (tripDate != null) {
			setTripDate(tripDate);
		}

		Long scheduleId = (Long)attributes.get("scheduleId");

		if (scheduleId != null) {
			setScheduleId(scheduleId);
		}
	}

	@Override
	public DriverLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the driver ID of this driver log.
	 *
	 * @return the driver ID of this driver log
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the log ID of this driver log.
	 *
	 * @return the log ID of this driver log
	 */
	@Override
	public long getLogId() {
		return model.getLogId();
	}

	/**
	 * Returns the primary key of this driver log.
	 *
	 * @return the primary key of this driver log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule ID of this driver log.
	 *
	 * @return the schedule ID of this driver log
	 */
	@Override
	public long getScheduleId() {
		return model.getScheduleId();
	}

	/**
	 * Returns the trip date of this driver log.
	 *
	 * @return the trip date of this driver log
	 */
	@Override
	public Date getTripDate() {
		return model.getTripDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the driver ID of this driver log.
	 *
	 * @param driverId the driver ID of this driver log
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the log ID of this driver log.
	 *
	 * @param logId the log ID of this driver log
	 */
	@Override
	public void setLogId(long logId) {
		model.setLogId(logId);
	}

	/**
	 * Sets the primary key of this driver log.
	 *
	 * @param primaryKey the primary key of this driver log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule ID of this driver log.
	 *
	 * @param scheduleId the schedule ID of this driver log
	 */
	@Override
	public void setScheduleId(long scheduleId) {
		model.setScheduleId(scheduleId);
	}

	/**
	 * Sets the trip date of this driver log.
	 *
	 * @param tripDate the trip date of this driver log
	 */
	@Override
	public void setTripDate(Date tripDate) {
		model.setTripDate(tripDate);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DriverLogWrapper wrap(DriverLog driverLog) {
		return new DriverLogWrapper(driverLog);
	}

}