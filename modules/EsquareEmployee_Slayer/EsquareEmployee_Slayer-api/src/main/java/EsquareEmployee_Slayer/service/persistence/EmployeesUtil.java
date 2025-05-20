/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EsquareEmployee_Slayer.service.persistence;

import EsquareEmployee_Slayer.model.Employees;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employees service. This utility wraps <code>EsquareEmployee_Slayer.service.persistence.impl.EmployeesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeesPersistence
 * @generated
 */
public class EmployeesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Employees employees) {
		getPersistence().clearCache(employees);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Employees> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Employees> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Employees update(Employees employees) {
		return getPersistence().update(employees);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Employees update(
		Employees employees, ServiceContext serviceContext) {

		return getPersistence().update(employees, serviceContext);
	}

	/**
	 * Returns all the employeeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employeeses
	 */
	public static List<Employees> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employeeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @return the range of matching employeeses
	 */
	public static List<Employees> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employeeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employeeses
	 */
	public static List<Employees> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employeeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employeeses
	 */
	public static List<Employees> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Employees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByUuid_First(
			String uuid, OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByUuid_First(
		String uuid, OrderByComparator<Employees> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByUuid_Last(
			String uuid, OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByUuid_Last(
		String uuid, OrderByComparator<Employees> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employeeses before and after the current employees in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employees
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employees
	 * @throws NoSuchEmployeesException if a employees with the primary key could not be found
	 */
	public static Employees[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employeeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employeeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employeeses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employees where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByUUID_G(String uuid, long groupId)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employees where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employees that was removed
	 */
	public static Employees removeByUUID_G(String uuid, long groupId)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employeeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employeeses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employeeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employeeses
	 */
	public static List<Employees> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employeeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @return the range of matching employeeses
	 */
	public static List<Employees> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employeeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employeeses
	 */
	public static List<Employees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employeeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employeeses
	 */
	public static List<Employees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employeeses before and after the current employees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employees
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employees
	 * @throws NoSuchEmployeesException if a employees with the primary key could not be found
	 */
	public static Employees[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employeeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employeeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employeeses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the employeeses where employeeDesignation = &#63;.
	 *
	 * @param employeeDesignation the employee designation
	 * @return the matching employeeses
	 */
	public static List<Employees> findByemployeeDesignation(
		String employeeDesignation) {

		return getPersistence().findByemployeeDesignation(employeeDesignation);
	}

	/**
	 * Returns a range of all the employeeses where employeeDesignation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @return the range of matching employeeses
	 */
	public static List<Employees> findByemployeeDesignation(
		String employeeDesignation, int start, int end) {

		return getPersistence().findByemployeeDesignation(
			employeeDesignation, start, end);
	}

	/**
	 * Returns an ordered range of all the employeeses where employeeDesignation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employeeses
	 */
	public static List<Employees> findByemployeeDesignation(
		String employeeDesignation, int start, int end,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().findByemployeeDesignation(
			employeeDesignation, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employeeses where employeeDesignation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employeeses
	 */
	public static List<Employees> findByemployeeDesignation(
		String employeeDesignation, int start, int end,
		OrderByComparator<Employees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemployeeDesignation(
			employeeDesignation, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employees in the ordered set where employeeDesignation = &#63;.
	 *
	 * @param employeeDesignation the employee designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByemployeeDesignation_First(
			String employeeDesignation,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByemployeeDesignation_First(
			employeeDesignation, orderByComparator);
	}

	/**
	 * Returns the first employees in the ordered set where employeeDesignation = &#63;.
	 *
	 * @param employeeDesignation the employee designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByemployeeDesignation_First(
		String employeeDesignation,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().fetchByemployeeDesignation_First(
			employeeDesignation, orderByComparator);
	}

	/**
	 * Returns the last employees in the ordered set where employeeDesignation = &#63;.
	 *
	 * @param employeeDesignation the employee designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employees
	 * @throws NoSuchEmployeesException if a matching employees could not be found
	 */
	public static Employees findByemployeeDesignation_Last(
			String employeeDesignation,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByemployeeDesignation_Last(
			employeeDesignation, orderByComparator);
	}

	/**
	 * Returns the last employees in the ordered set where employeeDesignation = &#63;.
	 *
	 * @param employeeDesignation the employee designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employees, or <code>null</code> if a matching employees could not be found
	 */
	public static Employees fetchByemployeeDesignation_Last(
		String employeeDesignation,
		OrderByComparator<Employees> orderByComparator) {

		return getPersistence().fetchByemployeeDesignation_Last(
			employeeDesignation, orderByComparator);
	}

	/**
	 * Returns the employeeses before and after the current employees in the ordered set where employeeDesignation = &#63;.
	 *
	 * @param employeeId the primary key of the current employees
	 * @param employeeDesignation the employee designation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employees
	 * @throws NoSuchEmployeesException if a employees with the primary key could not be found
	 */
	public static Employees[] findByemployeeDesignation_PrevAndNext(
			long employeeId, String employeeDesignation,
			OrderByComparator<Employees> orderByComparator)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByemployeeDesignation_PrevAndNext(
			employeeId, employeeDesignation, orderByComparator);
	}

	/**
	 * Removes all the employeeses where employeeDesignation = &#63; from the database.
	 *
	 * @param employeeDesignation the employee designation
	 */
	public static void removeByemployeeDesignation(String employeeDesignation) {
		getPersistence().removeByemployeeDesignation(employeeDesignation);
	}

	/**
	 * Returns the number of employeeses where employeeDesignation = &#63;.
	 *
	 * @param employeeDesignation the employee designation
	 * @return the number of matching employeeses
	 */
	public static int countByemployeeDesignation(String employeeDesignation) {
		return getPersistence().countByemployeeDesignation(employeeDesignation);
	}

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	public static void cacheResult(Employees employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	 * Caches the employeeses in the entity cache if it is enabled.
	 *
	 * @param employeeses the employeeses
	 */
	public static void cacheResult(List<Employees> employeeses) {
		getPersistence().cacheResult(employeeses);
	}

	/**
	 * Creates a new employees with the primary key. Does not add the employees to the database.
	 *
	 * @param employeeId the primary key for the new employees
	 * @return the new employees
	 */
	public static Employees create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the employees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employees
	 * @return the employees that was removed
	 * @throws NoSuchEmployeesException if a employees with the primary key could not be found
	 */
	public static Employees remove(long employeeId)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().remove(employeeId);
	}

	public static Employees updateImpl(Employees employees) {
		return getPersistence().updateImpl(employees);
	}

	/**
	 * Returns the employees with the primary key or throws a <code>NoSuchEmployeesException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employees
	 * @return the employees
	 * @throws NoSuchEmployeesException if a employees with the primary key could not be found
	 */
	public static Employees findByPrimaryKey(long employeeId)
		throws EsquareEmployee_Slayer.exception.NoSuchEmployeesException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the employees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employees
	 * @return the employees, or <code>null</code> if a employees with the primary key could not be found
	 */
	public static Employees fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the employeeses.
	 *
	 * @return the employeeses
	 */
	public static List<Employees> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employeeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @return the range of employeeses
	 */
	public static List<Employees> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employeeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employeeses
	 */
	public static List<Employees> findAll(
		int start, int end, OrderByComparator<Employees> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employeeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employeeses
	 * @param end the upper bound of the range of employeeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employeeses
	 */
	public static List<Employees> findAll(
		int start, int end, OrderByComparator<Employees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employeeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employeeses.
	 *
	 * @return the number of employeeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeesPersistence _persistence;

}