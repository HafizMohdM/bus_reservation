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

package com.esq.bus.reservation.slayers.model.impl;

import com.esq.bus.reservation.slayers.model.Route;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Route in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RouteCacheModel implements CacheModel<Route>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RouteCacheModel)) {
			return false;
		}

		RouteCacheModel routeCacheModel = (RouteCacheModel)object;

		if (routeId == routeCacheModel.routeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, routeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{routeId=");
		sb.append(routeId);
		sb.append(", startLocationId=");
		sb.append(startLocationId);
		sb.append(", endLocationId=");
		sb.append(endLocationId);
		sb.append(", distanceKm=");
		sb.append(distanceKm);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Route toEntityModel() {
		RouteImpl routeImpl = new RouteImpl();

		routeImpl.setRouteId(routeId);
		routeImpl.setStartLocationId(startLocationId);
		routeImpl.setEndLocationId(endLocationId);
		routeImpl.setDistanceKm(distanceKm);

		routeImpl.resetOriginalValues();

		return routeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		routeId = objectInput.readLong();

		startLocationId = objectInput.readLong();

		endLocationId = objectInput.readLong();

		distanceKm = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(routeId);

		objectOutput.writeLong(startLocationId);

		objectOutput.writeLong(endLocationId);

		objectOutput.writeDouble(distanceKm);
	}

	public long routeId;
	public long startLocationId;
	public long endLocationId;
	public double distanceKm;

}