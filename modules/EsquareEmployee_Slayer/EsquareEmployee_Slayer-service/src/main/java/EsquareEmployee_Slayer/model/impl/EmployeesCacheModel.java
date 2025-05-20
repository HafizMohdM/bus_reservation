/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EsquareEmployee_Slayer.model.impl;

import EsquareEmployee_Slayer.model.Employees;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employees in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeesCacheModel
	implements CacheModel<Employees>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeesCacheModel)) {
			return false;
		}

		EmployeesCacheModel employeesCacheModel = (EmployeesCacheModel)object;

		if (employeeId == employeesCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeName=");
		sb.append(employeeName);
		sb.append(", employeeMobileNumber=");
		sb.append(employeeMobileNumber);
		sb.append(", employeeDesignation=");
		sb.append(employeeDesignation);
		sb.append(", employeephoto=");
		sb.append(employeephoto);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employees toEntityModel() {
		EmployeesImpl employeesImpl = new EmployeesImpl();

		if (uuid == null) {
			employeesImpl.setUuid("");
		}
		else {
			employeesImpl.setUuid(uuid);
		}

		employeesImpl.setEmployeeId(employeeId);
		employeesImpl.setGroupId(groupId);
		employeesImpl.setCompanyId(companyId);

		if (employeeName == null) {
			employeesImpl.setEmployeeName("");
		}
		else {
			employeesImpl.setEmployeeName(employeeName);
		}

		if (employeeMobileNumber == null) {
			employeesImpl.setEmployeeMobileNumber("");
		}
		else {
			employeesImpl.setEmployeeMobileNumber(employeeMobileNumber);
		}

		if (employeeDesignation == null) {
			employeesImpl.setEmployeeDesignation("");
		}
		else {
			employeesImpl.setEmployeeDesignation(employeeDesignation);
		}

		if (employeephoto == null) {
			employeesImpl.setEmployeephoto("");
		}
		else {
			employeesImpl.setEmployeephoto(employeephoto);
		}

		if (createDate == Long.MIN_VALUE) {
			employeesImpl.setCreateDate(null);
		}
		else {
			employeesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeesImpl.setModifiedDate(null);
		}
		else {
			employeesImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeesImpl.resetOriginalValues();

		return employeesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		employeeName = objectInput.readUTF();
		employeeMobileNumber = objectInput.readUTF();
		employeeDesignation = objectInput.readUTF();
		employeephoto = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (employeeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeName);
		}

		if (employeeMobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeMobileNumber);
		}

		if (employeeDesignation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeDesignation);
		}

		if (employeephoto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeephoto);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long employeeId;
	public long groupId;
	public long companyId;
	public String employeeName;
	public String employeeMobileNumber;
	public String employeeDesignation;
	public String employeephoto;
	public long createDate;
	public long modifiedDate;

}