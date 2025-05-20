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
 * This class is a wrapper for {@link Route}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Route
 * @generated
 */
public class RouteWrapper
	extends BaseModelWrapper<Route> implements ModelWrapper<Route>, Route {

	public RouteWrapper(Route route) {
		super(route);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("routeId", getRouteId());
		attributes.put("startLocationId", getStartLocationId());
		attributes.put("endLocationId", getEndLocationId());
		attributes.put("distanceKm", getDistanceKm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long routeId = (Long)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
		}

		Long startLocationId = (Long)attributes.get("startLocationId");

		if (startLocationId != null) {
			setStartLocationId(startLocationId);
		}

		Long endLocationId = (Long)attributes.get("endLocationId");

		if (endLocationId != null) {
			setEndLocationId(endLocationId);
		}

		Double distanceKm = (Double)attributes.get("distanceKm");

		if (distanceKm != null) {
			setDistanceKm(distanceKm);
		}
	}

	@Override
	public Route cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the distance km of this route.
	 *
	 * @return the distance km of this route
	 */
	@Override
	public double getDistanceKm() {
		return model.getDistanceKm();
	}

	/**
	 * Returns the end location ID of this route.
	 *
	 * @return the end location ID of this route
	 */
	@Override
	public long getEndLocationId() {
		return model.getEndLocationId();
	}

	/**
	 * Returns the primary key of this route.
	 *
	 * @return the primary key of this route
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the route ID of this route.
	 *
	 * @return the route ID of this route
	 */
	@Override
	public long getRouteId() {
		return model.getRouteId();
	}

	/**
	 * Returns the start location ID of this route.
	 *
	 * @return the start location ID of this route
	 */
	@Override
	public long getStartLocationId() {
		return model.getStartLocationId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the distance km of this route.
	 *
	 * @param distanceKm the distance km of this route
	 */
	@Override
	public void setDistanceKm(double distanceKm) {
		model.setDistanceKm(distanceKm);
	}

	/**
	 * Sets the end location ID of this route.
	 *
	 * @param endLocationId the end location ID of this route
	 */
	@Override
	public void setEndLocationId(long endLocationId) {
		model.setEndLocationId(endLocationId);
	}

	/**
	 * Sets the primary key of this route.
	 *
	 * @param primaryKey the primary key of this route
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the route ID of this route.
	 *
	 * @param routeId the route ID of this route
	 */
	@Override
	public void setRouteId(long routeId) {
		model.setRouteId(routeId);
	}

	/**
	 * Sets the start location ID of this route.
	 *
	 * @param startLocationId the start location ID of this route
	 */
	@Override
	public void setStartLocationId(long startLocationId) {
		model.setStartLocationId(startLocationId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RouteWrapper wrap(Route route) {
		return new RouteWrapper(route);
	}

}