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
 * The table class for the &quot;BOOKRESERVATION_Booking&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Booking
 * @generated
 */
public class BookingTable extends BaseTable<BookingTable> {

	public static final BookingTable INSTANCE = new BookingTable();

	public final Column<BookingTable, Long> bookingId = createColumn(
		"bookingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BookingTable, Long> scheduleId = createColumn(
		"scheduleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Long> passengerId = createColumn(
		"passengerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Integer> numberOfSeats = createColumn(
		"numberOfSeats", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Double> fareAmount = createColumn(
		"fareAmount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Double> totalAmount = createColumn(
		"totalAmount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Date> dateOfBooking = createColumn(
		"dateOfBooking", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Integer> bookingStatus = createColumn(
		"bookingStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookingTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BookingTable() {
		super("BOOKRESERVATION_Booking", BookingTable::new);
	}

}