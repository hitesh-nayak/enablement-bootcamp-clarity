/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.employee.service.model.impl;

import com.liferay.employee.service.model.Employee;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		if (companyEmpId == employeeCacheModel.companyEmpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyEmpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyEmpId=");
		sb.append(companyEmpId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", empFirstName=");
		sb.append(empFirstName);
		sb.append(", empLastName=");
		sb.append(empLastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", profImageId=");
		sb.append(profImageId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		if (uuid == null) {
			employeeImpl.setUuid("");
		}
		else {
			employeeImpl.setUuid(uuid);
		}

		employeeImpl.setCompanyEmpId(companyEmpId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setCompanyId(companyId);

		if (empFirstName == null) {
			employeeImpl.setEmpFirstName("");
		}
		else {
			employeeImpl.setEmpFirstName(empFirstName);
		}

		if (empLastName == null) {
			employeeImpl.setEmpLastName("");
		}
		else {
			employeeImpl.setEmpLastName(empLastName);
		}

		if (email == null) {
			employeeImpl.setEmail("");
		}
		else {
			employeeImpl.setEmail(email);
		}

		if (phone == null) {
			employeeImpl.setPhone("");
		}
		else {
			employeeImpl.setPhone(phone);
		}

		if (companyName == null) {
			employeeImpl.setCompanyName("");
		}
		else {
			employeeImpl.setCompanyName(companyName);
		}

		employeeImpl.setProfImageId(profImageId);

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyEmpId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		empFirstName = objectInput.readUTF();
		empLastName = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		companyName = objectInput.readUTF();

		profImageId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(companyEmpId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (empFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(empFirstName);
		}

		if (empLastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(empLastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (companyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		objectOutput.writeLong(profImageId);
		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long companyEmpId;
	public long groupId;
	public long companyId;
	public String empFirstName;
	public String empLastName;
	public String email;
	public String phone;
	public String companyName;
	public long profImageId;
	public long createDate;

}