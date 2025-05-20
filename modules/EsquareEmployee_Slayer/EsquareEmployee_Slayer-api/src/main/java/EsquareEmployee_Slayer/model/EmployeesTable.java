/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EsquareEmployee_Slayer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;esquare_Employees&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Employees
 * @generated
 */
public class EmployeesTable extends BaseTable<EmployeesTable> {

	public static final EmployeesTable INSTANCE = new EmployeesTable();

	public final Column<EmployeesTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, String> employeeName = createColumn(
		"employeeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, String> employeeMobileNumber =
		createColumn(
			"employeeMobileNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, String> employeeDesignation =
		createColumn(
			"employeeDesignation", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, String> employeephoto = createColumn(
		"employeephoto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeesTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private EmployeesTable() {
		super("esquare_Employees", EmployeesTable::new);
	}

}