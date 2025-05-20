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
 * The table class for the &quot;BOOKRESERVATION_Feedback&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Feedback
 * @generated
 */
public class FeedbackTable extends BaseTable<FeedbackTable> {

	public static final FeedbackTable INSTANCE = new FeedbackTable();

	public final Column<FeedbackTable, Long> feedbackId = createColumn(
		"feedbackId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FeedbackTable, Long> passengerId = createColumn(
		"passengerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeedbackTable, Long> bookingId = createColumn(
		"bookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FeedbackTable, Integer> rating = createColumn(
		"rating", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FeedbackTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FeedbackTable() {
		super("BOOKRESERVATION_Feedback", FeedbackTable::new);
	}

}