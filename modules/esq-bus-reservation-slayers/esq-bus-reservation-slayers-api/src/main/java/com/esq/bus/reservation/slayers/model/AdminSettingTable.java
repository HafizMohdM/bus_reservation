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
 * The table class for the &quot;BOOKRESERVATION_AdminSetting&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AdminSetting
 * @generated
 */
public class AdminSettingTable extends BaseTable<AdminSettingTable> {

	public static final AdminSettingTable INSTANCE = new AdminSettingTable();

	public final Column<AdminSettingTable, Long> settingId = createColumn(
		"settingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AdminSettingTable, String> key = createColumn(
		"key_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AdminSettingTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AdminSettingTable() {
		super("BOOKRESERVATION_AdminSetting", AdminSettingTable::new);
	}

}