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
 * The table class for the &quot;BOOKRESERVATION_Payment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Payment
 * @generated
 */
public class PaymentTable extends BaseTable<PaymentTable> {

	public static final PaymentTable INSTANCE = new PaymentTable();

	public final Column<PaymentTable, Long> paymentId = createColumn(
		"paymentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PaymentTable, Long> bookingId = createColumn(
		"bookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PaymentTable, Double> amountPaid = createColumn(
		"amountPaid", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<PaymentTable, Date> paymentDate = createColumn(
		"paymentDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PaymentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PaymentTable() {
		super("BOOKRESERVATION_Payment", PaymentTable::new);
	}

}