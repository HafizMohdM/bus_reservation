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
 * The table class for the &quot;BOOKRESERVATION_Passenger&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Passenger
 * @generated
 */
public class PassengerTable extends BaseTable<PassengerTable> {

	public static final PassengerTable INSTANCE = new PassengerTable();

	public final Column<PassengerTable, Long> passengerId = createColumn(
		"passengerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PassengerTable, String> passengerName = createColumn(
		"passengerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PassengerTable, String> passengerContact = createColumn(
		"passengerContact", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PassengerTable, String> passengerEmail = createColumn(
		"passengerEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PassengerTable, String> username = createColumn(
		"username", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PassengerTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PassengerTable, Integer> accountStatus = createColumn(
		"accountStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PassengerTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PassengerTable() {
		super("BOOKRESERVATION_Passenger", PassengerTable::new);
	}

}