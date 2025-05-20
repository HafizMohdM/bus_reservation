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
 * The table class for the &quot;BOOKRESERVATION_TravelSchedule&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TravelSchedule
 * @generated
 */
public class TravelScheduleTable extends BaseTable<TravelScheduleTable> {

	public static final TravelScheduleTable INSTANCE =
		new TravelScheduleTable();

	public final Column<TravelScheduleTable, Long> scheduleId = createColumn(
		"scheduleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TravelScheduleTable, Long> busId = createColumn(
		"busId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, Long> driverId = createColumn(
		"driverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, String> startingPoint =
		createColumn(
			"startingPoint", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, String> destination = createColumn(
		"destination", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, Date> scheduleDate = createColumn(
		"scheduleDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, Date> departureTime = createColumn(
		"departureTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, Date> estimatedArrivalTime =
		createColumn(
			"estimatedArrivalTime", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, Double> fareAmount = createColumn(
		"fareAmount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelScheduleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TravelScheduleTable() {
		super("BOOKRESERVATION_TravelSchedule", TravelScheduleTable::new);
	}

}