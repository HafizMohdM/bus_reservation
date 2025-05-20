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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Location
 * @generated
 */
public class LocationWrapper
	extends BaseModelWrapper<Location>
	implements Location, ModelWrapper<Location> {

	public LocationWrapper(Location location) {
		super(location);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("city", getCity());
		attributes.put("station", getStation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String station = (String)attributes.get("station");

		if (station != null) {
			setStation(station);
		}
	}

	@Override
	public Location cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the city of this location.
	 *
	 * @return the city of this location
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the location ID of this location.
	 *
	 * @return the location ID of this location
	 */
	@Override
	public long getLocationId() {
		return model.getLocationId();
	}

	/**
	 * Returns the primary key of this location.
	 *
	 * @return the primary key of this location
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the station of this location.
	 *
	 * @return the station of this location
	 */
	@Override
	public String getStation() {
		return model.getStation();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the city of this location.
	 *
	 * @param city the city of this location
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the location ID of this location.
	 *
	 * @param locationId the location ID of this location
	 */
	@Override
	public void setLocationId(long locationId) {
		model.setLocationId(locationId);
	}

	/**
	 * Sets the primary key of this location.
	 *
	 * @param primaryKey the primary key of this location
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the station of this location.
	 *
	 * @param station the station of this location
	 */
	@Override
	public void setStation(String station) {
		model.setStation(station);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LocationWrapper wrap(Location location) {
		return new LocationWrapper(location);
	}

}