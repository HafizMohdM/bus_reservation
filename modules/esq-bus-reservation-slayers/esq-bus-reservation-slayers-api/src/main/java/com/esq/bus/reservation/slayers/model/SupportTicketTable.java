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
 * The table class for the &quot;BOOKRESERVATION_SupportTicket&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SupportTicket
 * @generated
 */
public class SupportTicketTable extends BaseTable<SupportTicketTable> {

	public static final SupportTicketTable INSTANCE = new SupportTicketTable();

	public final Column<SupportTicketTable, Long> supportTicketId =
		createColumn(
			"supportTicketId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SupportTicketTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SupportTicketTable, String> subject = createColumn(
		"subject", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SupportTicketTable, String> message = createColumn(
		"message", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SupportTicketTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SupportTicketTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SupportTicketTable() {
		super("BOOKRESERVATION_SupportTicket", SupportTicketTable::new);
	}

}