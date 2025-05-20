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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOOKRESERVATION_Route&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Route
 * @generated
 */
public class RouteTable extends BaseTable<RouteTable> {

	public static final RouteTable INSTANCE = new RouteTable();

	public final Column<RouteTable, Long> routeId = createColumn(
		"routeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RouteTable, Long> startLocationId = createColumn(
		"startLocationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RouteTable, Long> endLocationId = createColumn(
		"endLocationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RouteTable, Double> distanceKm = createColumn(
		"distanceKm", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private RouteTable() {
		super("BOOKRESERVATION_Route", RouteTable::new);
	}

}