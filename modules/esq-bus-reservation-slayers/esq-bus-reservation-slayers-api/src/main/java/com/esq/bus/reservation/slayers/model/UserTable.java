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
 * The table class for the &quot;BOOKRESERVATION_User&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see User
 * @generated
 */
public class UserTable extends BaseTable<UserTable> {

	public static final UserTable INSTANCE = new UserTable();

	public final Column<UserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserTable, String> fullName = createColumn(
		"fullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserTable, String> contactNo = createColumn(
		"contactNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserTable, String> emailAddress = createColumn(
		"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserTable, String> username = createColumn(
		"username", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserTable, String> userpassword = createColumn(
		"userpassword", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserTable, Integer> accountCategory = createColumn(
		"accountCategory", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<UserTable, Integer> accountStatus = createColumn(
		"accountStatus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private UserTable() {
		super("BOOKRESERVATION_User", UserTable::new);
	}

}