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

import java.util.Date;

/**
 * The table class for the &quot;BOOKRESERVATION_DriverLog&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DriverLog
 * @generated
 */
public class DriverLogTable extends BaseTable<DriverLogTable> {

	public static final DriverLogTable INSTANCE = new DriverLogTable();

	public final Column<DriverLogTable, Long> logId = createColumn(
		"logId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DriverLogTable, Long> driverId = createColumn(
		"driverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DriverLogTable, Date> tripDate = createColumn(
		"tripDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DriverLogTable, Long> scheduleId = createColumn(
		"scheduleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DriverLogTable() {
		super("BOOKRESERVATION_DriverLog", DriverLogTable::new);
	}

}