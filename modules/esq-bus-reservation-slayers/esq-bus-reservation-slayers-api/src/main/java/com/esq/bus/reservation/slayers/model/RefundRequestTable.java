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
 * The table class for the &quot;BOOKRESERVATION_RefundRequest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RefundRequest
 * @generated
 */
public class RefundRequestTable extends BaseTable<RefundRequestTable> {

	public static final RefundRequestTable INSTANCE = new RefundRequestTable();

	public final Column<RefundRequestTable, Long> requestId = createColumn(
		"requestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RefundRequestTable, Long> bookingId = createColumn(
		"bookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RefundRequestTable, String> reason = createColumn(
		"reason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefundRequestTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefundRequestTable, Date> requestDate = createColumn(
		"requestDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private RefundRequestTable() {
		super("BOOKRESERVATION_RefundRequest", RefundRequestTable::new);
	}

}