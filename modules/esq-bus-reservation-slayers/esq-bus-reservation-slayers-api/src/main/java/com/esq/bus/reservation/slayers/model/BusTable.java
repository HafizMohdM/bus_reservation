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
 * The table class for the &quot;BOOKRESERVATION_Bus&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Bus
 * @generated
 */
public class BusTable extends BaseTable<BusTable> {

	public static final BusTable INSTANCE = new BusTable();

	public final Column<BusTable, Long> busId = createColumn(
		"busId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BusTable, String> busNumber = createColumn(
		"busNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusTable, String> busPlateNumber = createColumn(
		"busPlateNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusTable, Integer> busType = createColumn(
		"busType", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BusTable, Integer> capacity = createColumn(
		"capacity", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BusTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BusTable, String> image1 = createColumn(
		"image1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusTable, String> image2 = createColumn(
		"image2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusTable, String> image3 = createColumn(
		"image3", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusTable, String> image4 = createColumn(
		"image4", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BusTable, String> image5 = createColumn(
		"image5", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BusTable() {
		super("BOOKRESERVATION_Bus", BusTable::new);
	}

}