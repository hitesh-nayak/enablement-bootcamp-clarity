/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;customObjService_StateObject&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see StateObject
 * @generated
 */
public class StateObjectTable extends BaseTable<StateObjectTable> {

	public static final StateObjectTable INSTANCE = new StateObjectTable();

	public final Column<StateObjectTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StateObjectTable, Long> stateId = createColumn(
		"stateId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StateObjectTable, Long> stateObjectDefId = createColumn(
		"stateObjectDefId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StateObjectTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StateObjectTable, Long> pinCode = createColumn(
		"pinCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StateObjectTable, String> extRefId = createColumn(
		"extRefId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private StateObjectTable() {
		super("customObjService_StateObject", StateObjectTable::new);
	}

}