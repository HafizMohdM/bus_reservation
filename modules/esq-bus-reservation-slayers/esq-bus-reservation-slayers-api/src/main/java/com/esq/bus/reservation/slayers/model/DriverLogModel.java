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
 * The base model interface for the DriverLog service. Represents a row in the &quot;BOOKRESERVATION_DriverLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.esq.bus.reservation.slayers.model.impl.DriverLogModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.esq.bus.reservation.slayers.model.impl.DriverLogImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverLog
 * @generated
 */
@ProviderType
public interface DriverLogModel extends BaseModel<DriverLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a driver log model instance should use the {@link DriverLog} interface instead.
	 */

	/**
	 * Returns the primary key of this driver log.
	 *
	 * @return the primary key of this driver log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this driver log.
	 *
	 * @param primaryKey the primary key of this driver log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the log ID of this driver log.
	 *
	 * @return the log ID of this driver log
	 */
	public long getLogId();

	/**
	 * Sets the log ID of this driver log.
	 *
	 * @param logId the log ID of this driver log
	 */
	public void setLogId(long logId);

	/**
	 * Returns the driver ID of this driver log.
	 *
	 * @return the driver ID of this driver log
	 */
	public long getDriverId();

	/**
	 * Sets the driver ID of this driver log.
	 *
	 * @param driverId the driver ID of this driver log
	 */
	public void setDriverId(long driverId);

	/**
	 * Returns the trip date of this driver log.
	 *
	 * @return the trip date of this driver log
	 */
	public Date getTripDate();

	/**
	 * Sets the trip date of this driver log.
	 *
	 * @param tripDate the trip date of this driver log
	 */
	public void setTripDate(Date tripDate);

	/**
	 * Returns the schedule ID of this driver log.
	 *
	 * @return the schedule ID of this driver log
	 */
	public long getScheduleId();

	/**
	 * Sets the schedule ID of this driver log.
	 *
	 * @param scheduleId the schedule ID of this driver log
	 */
	public void setScheduleId(long scheduleId);

	@Override
	public DriverLog cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}