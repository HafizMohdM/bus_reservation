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
 * The table class for the &quot;BOOKRESERVATION_Driver&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Driver
 * @generated
 */
public class DriverTable extends BaseTable<DriverTable> {

	public static final DriverTable INSTANCE = new DriverTable();

	public final Column<DriverTable, Long> driverId = createColumn(
		"driverId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DriverTable, String> driverName = createColumn(
		"driverName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, String> driverContact = createColumn(
		"driverContact", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DriverTable() {
		super("BOOKRESERVATION_Driver", DriverTable::new);
	}

}