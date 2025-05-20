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
 * The table class for the &quot;BOOKRESERVATION_Location&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Location
 * @generated
 */
public class LocationTable extends BaseTable<LocationTable> {

	public static final LocationTable INSTANCE = new LocationTable();

	public final Column<LocationTable, Long> locationId = createColumn(
		"locationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LocationTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LocationTable, String> station = createColumn(
		"station", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LocationTable() {
		super("BOOKRESERVATION_Location", LocationTable::new);
	}

}