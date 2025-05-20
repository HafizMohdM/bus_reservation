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
 * The table class for the &quot;BOOKRESERVATION_Discount&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Discount
 * @generated
 */
public class DiscountTable extends BaseTable<DiscountTable> {

	public static final DiscountTable INSTANCE = new DiscountTable();

	public final Column<DiscountTable, Long> discountId = createColumn(
		"discountId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DiscountTable, String> code = createColumn(
		"code_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DiscountTable, Double> percentage = createColumn(
		"percentage", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<DiscountTable, Date> validFrom = createColumn(
		"validFrom", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DiscountTable, Date> validTo = createColumn(
		"validTo", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DiscountTable() {
		super("BOOKRESERVATION_Discount", DiscountTable::new);
	}

}