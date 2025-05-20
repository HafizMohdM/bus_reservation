/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EsquareEmployee_Slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeesService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeesService
 * @generated
 */
public class EmployeesServiceWrapper
	implements EmployeesService, ServiceWrapper<EmployeesService> {

	public EmployeesServiceWrapper() {
		this(null);
	}

	public EmployeesServiceWrapper(EmployeesService employeesService) {
		_employeesService = employeesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeesService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeesService getWrappedService() {
		return _employeesService;
	}

	@Override
	public void setWrappedService(EmployeesService employeesService) {
		_employeesService = employeesService;
	}

	private EmployeesService _employeesService;

}