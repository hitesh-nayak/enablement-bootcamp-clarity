/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.employee.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Company_Employee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeTable extends BaseTable<EmployeeTable> {

	public static final EmployeeTable INSTANCE = new EmployeeTable();

	public final Column<EmployeeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, Long> companyEmpId = createColumn(
		"companyEmpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, String> empFirstName = createColumn(
		"empFirstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, String> empLastName = createColumn(
		"empLastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, String> companyName = createColumn(
		"companyName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, Long> profImageId = createColumn(
		"profImageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private EmployeeTable() {
		super("Company_Employee", EmployeeTable::new);
	}

}