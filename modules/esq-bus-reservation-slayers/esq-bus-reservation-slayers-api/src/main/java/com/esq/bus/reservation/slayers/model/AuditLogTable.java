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
 * The table class for the &quot;BOOKRESERVATION_AuditLog&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AuditLog
 * @generated
 */
public class AuditLogTable extends BaseTable<AuditLogTable> {

	public static final AuditLogTable INSTANCE = new AuditLogTable();

	public final Column<AuditLogTable, Long> auditId = createColumn(
		"auditId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AuditLogTable, String> entityName = createColumn(
		"entityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditLogTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditLogTable, String> action = createColumn(
		"action", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditLogTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditLogTable, Date> actionDate = createColumn(
		"actionDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AuditLogTable() {
		super("BOOKRESERVATION_AuditLog", AuditLogTable::new);
	}

}