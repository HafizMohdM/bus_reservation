/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EsquareEmployee_Slayer.service;

import EsquareEmployee_Slayer.model.Employees;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Employees. This utility wraps
 * <code>EsquareEmployee_Slayer.service.impl.EmployeesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeesLocalService
 * @generated
 */
public class EmployeesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>EsquareEmployee_Slayer.service.impl.EmployeesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employees to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employees the employees
	 * @return the employees that was added
	 */
	public static Employees addEmployees(Employees employees) {
		return getService().addEmployees(employees);
	}

	public static Employees addEmployees(
		long groupId, long companyId, String employeeName,
		String employeeMobileNumber, String employeeDesignation,
		InputStream empPhotoStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addEmployees(
			groupId, companyId, employeeName, employeeMobileNumber,
			employeeDesignation, empPhotoStream, serviceContext);
	}

	public static String convertImageToBase64(InputStream inputStream)
		throws java.io.IOException {

		return getService().convertImageToBase64(inputStream);
	}

	/**
	 * Creates a new employees with the primary key. Does not add the employees to the database.
	 *
	 * @param employeeId the primary key for the new employees
	 * @return the new employees
	 */
	public static Employees createEmployees(long employeeId) {
		return getService().createEmployees(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employees from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employees the employees
	 * @return the employees that was removed
	 */
	public static Employees deleteEmployees(Employees employees) {
		return getService().deleteEmployees(employees);
	}

	/**
	 * Deletes the employees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employees
	 * @return the employees that was removed
	 * @throws PortalException if a employees with the primary key could not be found
	 */
	public static Employees deleteEmployees(long employeeId)
		throws PortalException {

		return getService().deleteEmployees(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsquareEmployee_Slayer.model.impl.EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsquareEmployee_Slayer.model.impl.EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Employees fetchEmployees(long employeeId) {
		return getService().fetchEmployees(employeeId);
	}

	/**
	 * Returns the employees matching the UUID and group.
	 *
	 * @param uuid the employees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchEmployeesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeesByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employees with the primary key.
	 *
	 * @param employeeId the primary key of the employees
	 * @return the employees
	 * @throws PortalException if a employees with the primary key could not be found
	 */
	public static Employees getEmployees(long employeeId)
		throws PortalException {

		return getService().getEmployees(employeeId);
	}

	/**
	 * Returns the employees matching the UUID and group.
	 *
	 * @param uuid the employees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employees
	 * @throws PortalException if a matching employees could not be found
	 */
	public static Employees getEmployeesByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeesByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employeeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EsquareEmployee_Slayer.model.impl.EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @return the range of employeeses
	 */
	public static List<Employees> getEmployeeses(int start, int end) {
		return getService().getEmployeeses(start, end);
	}

	/**
	 * Returns all the employeeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employeeses
	 * @param companyId the primary key of the company
	 * @return the matching employeeses, or an empty list if no matches were found
	 */
	public static List<Employees> getEmployeesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeesesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employeeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employeeses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employeeses, or an empty list if no matches were found
	 */
	public static List<Employees> getEmployeesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employees> orderByComparator) {

		return getService().getEmployeesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employeeses.
	 *
	 * @return the number of employeeses
	 */
	public static int getEmployeesesCount() {
		return getService().getEmployeesesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employees the employees
	 * @return the employees that was updated
	 */
	public static Employees updateEmployees(Employees employees) {
		return getService().updateEmployees(employees);
	}

	public static Employees updateEmployees(
			long employeeId, String employeeName, String employeeMobileNumber,
			String employeeDesignation, InputStream empPhotoStream,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.io.IOException, PortalException {

		return getService().updateEmployees(
			employeeId, employeeName, employeeMobileNumber, employeeDesignation,
			empPhotoStream, serviceContext);
	}

	public static EmployeesLocalService getService() {
		return _service;
	}

	public static void setService(EmployeesLocalService service) {
		_service = service;
	}

	private static volatile EmployeesLocalService _service;

}