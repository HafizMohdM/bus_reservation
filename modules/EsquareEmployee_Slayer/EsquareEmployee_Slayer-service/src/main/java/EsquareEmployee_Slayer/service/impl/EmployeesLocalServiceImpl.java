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

package EsquareEmployee_Slayer.service.impl;

import EsquareEmployee_Slayer.model.Employees;
import EsquareEmployee_Slayer.service.base.EmployeesLocalServiceBaseImpl;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=EsquareEmployee_Slayer.model.Employees", service = AopService.class)
public class EmployeesLocalServiceImpl extends EmployeesLocalServiceBaseImpl {

	@Override
	public Employees addEmployees(long groupId, long companyId, String employeeName, String employeeMobileNumber,
			String employeeDesignation, InputStream empPhotoStream, ServiceContext serviceContext) {

		long employeeId = counterLocalService.increment(Employees.class.getName());
		Employees employee = employeesPersistence.create(employeeId);
		try {
			employee.setGroupId(groupId);
			employee.setCompanyId(companyId);
			employee.setEmployeeName(employeeName);
			employee.setEmployeeMobileNumber(employeeMobileNumber);
			employee.setEmployeeDesignation(employeeDesignation);
			String empPhotoBase64;
			empPhotoBase64 = convertImageToBase64(empPhotoStream);
			employee.setEmployeephoto(empPhotoBase64);
			employee.setCreateDate(new Date());
			employee.setModifiedDate(new Date());
			employeesLocalService.addEmployees(employee);
			return super.addEmployees(employee);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return employee;

	}

	public String convertImageToBase64(InputStream inputStream) throws java.io.IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		byte[] imageBytes = outputStream.toByteArray();
		return Base64.getEncoder().encodeToString(imageBytes);
	}

	@Override
	public Employees deleteEmployees(long employeeId) throws PortalException {

		Employees employee = employeesPersistence.findByPrimaryKey(employeeId);

		return super.deleteEmployees(employee);
	}

	@Override
	public Employees updateEmployees(long employeeId, String employeeName, String employeeMobileNumber,
			String employeeDesignation, InputStream empPhotoStream, ServiceContext serviceContext) throws PortalException, java.io.IOException {

		Employees employee = employeesPersistence.findByPrimaryKey(employeeId);

		employee.setEmployeeName(employeeName);
		employee.setEmployeeMobileNumber(employeeMobileNumber);
		employee.setEmployeeDesignation(employeeDesignation);
		/*
		 * String empPhotoBase64 = null; try { empPhotoBase64 =
		 * convertImageToBase64(empPhotoStream); } catch (java.io.IOException e) {
		 * 
		 * e.printStackTrace(); } employee.setEmployeephoto(empPhotoBase64);
		 */
		
		  if (empPhotoStream != null) {
		        String empPhotoBase64;
		        try {
		            empPhotoBase64 = convertImageToBase64(empPhotoStream);
		            employee.setEmployeephoto(empPhotoBase64);
		        } catch (IOException e) {
		            //_log.error("Error converting image to Base64: " + e.getMessage(), e);
		            throw new PortalException("Error processing the employee photo", e);
		        }
		    }
		employee = employeesPersistence.update(employee);
		return super.updateEmployees(employee);
	}

}