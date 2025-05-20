/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EsquareEmployee_Slayer.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employees}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employees
 * @generated
 */
public class EmployeesWrapper
	extends BaseModelWrapper<Employees>
	implements Employees, ModelWrapper<Employees> {

	public EmployeesWrapper(Employees employees) {
		super(employees);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeName", getEmployeeName());
		attributes.put("employeeMobileNumber", getEmployeeMobileNumber());
		attributes.put("employeeDesignation", getEmployeeDesignation());
		attributes.put("employeephoto", getEmployeephoto());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}
         
		
	
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String employeeName = (String)attributes.get("employeeName");

		if (employeeName != null) {
			setEmployeeName(employeeName);
		}

		String employeeMobileNumber = (String)attributes.get(
			"employeeMobileNumber");

		if (employeeMobileNumber != null) {
			setEmployeeMobileNumber(employeeMobileNumber);
		}

		String employeeDesignation = (String)attributes.get(
			"employeeDesignation");

		if (employeeDesignation != null) {
			setEmployeeDesignation(employeeDesignation);
		}

		String employeephoto = (String)attributes.get("employeephoto");

		if (employeephoto != null) {
			setEmployeephoto(employeephoto);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Employees cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employees.
	 *
	 * @return the company ID of this employees
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employees.
	 *
	 * @return the create date of this employees
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the employee designation of this employees.
	 *
	 * @return the employee designation of this employees
	 */
	@Override
	public String getEmployeeDesignation() {
		return model.getEmployeeDesignation();
	}

	/**
	 * Returns the employee ID of this employees.
	 *
	 * @return the employee ID of this employees
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee mobile number of this employees.
	 *
	 * @return the employee mobile number of this employees
	 */
	@Override
	public String getEmployeeMobileNumber() {
		return model.getEmployeeMobileNumber();
	}

	/**
	 * Returns the employee name of this employees.
	 *
	 * @return the employee name of this employees
	 */
	@Override
	public String getEmployeeName() {
		return model.getEmployeeName();
	}

	/**
	 * Returns the employeephoto of this employees.
	 *
	 * @return the employeephoto of this employees
	 */
	@Override
	public String getEmployeephoto() {
		return model.getEmployeephoto();
	}

	/**
	 * Returns the group ID of this employees.
	 *
	 * @return the group ID of this employees
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this employees.
	 *
	 * @return the modified date of this employees
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employees.
	 *
	 * @return the primary key of this employees
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this employees.
	 *
	 * @return the uuid of this employees
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employees.
	 *
	 * @param companyId the company ID of this employees
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employees.
	 *
	 * @param createDate the create date of this employees
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the employee designation of this employees.
	 *
	 * @param employeeDesignation the employee designation of this employees
	 */
	@Override
	public void setEmployeeDesignation(String employeeDesignation) {
		model.setEmployeeDesignation(employeeDesignation);
	}

	/**
	 * Sets the employee ID of this employees.
	 *
	 * @param employeeId the employee ID of this employees
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee mobile number of this employees.
	 *
	 * @param employeeMobileNumber the employee mobile number of this employees
	 */
	@Override
	public void setEmployeeMobileNumber(String employeeMobileNumber) {
		model.setEmployeeMobileNumber(employeeMobileNumber);
	}

	/**
	 * Sets the employee name of this employees.
	 *
	 * @param employeeName the employee name of this employees
	 */
	@Override
	public void setEmployeeName(String employeeName) {
		model.setEmployeeName(employeeName);
	}

	/**
	 * Sets the employeephoto of this employees.
	 *
	 * @param employeephoto the employeephoto of this employees
	 */
	@Override
	public void setEmployeephoto(String employeephoto) {
		model.setEmployeephoto(employeephoto);
	}

	/**
	 * Sets the group ID of this employees.
	 *
	 * @param groupId the group ID of this employees
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this employees.
	 *
	 * @param modifiedDate the modified date of this employees
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employees.
	 *
	 * @param primaryKey the primary key of this employees
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this employees.
	 *
	 * @param uuid the uuid of this employees
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EmployeesWrapper wrap(Employees employees) {
		return new EmployeesWrapper(employees);
	}

}