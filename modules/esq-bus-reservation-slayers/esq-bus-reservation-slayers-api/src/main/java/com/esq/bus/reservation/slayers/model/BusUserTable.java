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
 * The table class for the &quot;BOOKRESERVATION_BusUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BusUser
 * @generated
 */
public class BusUserTable extends BaseTable<BusUserTable> {

	public static final BusUserTable INSTANCE = new BusUserTable();

	public final Column<BusUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BusUserTable, String> fullName = createColumn(
		"fullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusUserTable, String> contactNo = createColumn(
		"contactNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusUserTable, String> emailAddress = createColumn(
		"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusUserTable, String> username = createColumn(
		"username", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusUserTable, String> userpassword = createColumn(
		"userpassword", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusUserTable, Integer> accountCategory = createColumn(
		"accountCategory", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BusUserTable, Integer> accountStatus = createColumn(
		"accountStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private BusUserTable() {
		super("BOOKRESERVATION_BusUser", BusUserTable::new);
	}

}