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

package com.esq.bus.reservation.slayers.service.persistence;

import com.esq.bus.reservation.slayers.model.RefundRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the refund request service. This utility wraps <code>com.esq.bus.reservation.slayers.service.persistence.impl.RefundRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefundRequestPersistence
 * @generated
 */
public class RefundRequestUtil {

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
	public static void clearCache(RefundRequest refundRequest) {
		getPersistence().clearCache(refundRequest);
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
	public static Map<Serializable, RefundRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RefundRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RefundRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RefundRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RefundRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RefundRequest update(RefundRequest refundRequest) {
		return getPersistence().update(refundRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RefundRequest update(
		RefundRequest refundRequest, ServiceContext serviceContext) {

		return getPersistence().update(refundRequest, serviceContext);
	}

	/**
	 * Caches the refund request in the entity cache if it is enabled.
	 *
	 * @param refundRequest the refund request
	 */
	public static void cacheResult(RefundRequest refundRequest) {
		getPersistence().cacheResult(refundRequest);
	}

	/**
	 * Caches the refund requests in the entity cache if it is enabled.
	 *
	 * @param refundRequests the refund requests
	 */
	public static void cacheResult(List<RefundRequest> refundRequests) {
		getPersistence().cacheResult(refundRequests);
	}

	/**
	 * Creates a new refund request with the primary key. Does not add the refund request to the database.
	 *
	 * @param requestId the primary key for the new refund request
	 * @return the new refund request
	 */
	public static RefundRequest create(long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	 * Removes the refund request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request that was removed
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	public static RefundRequest remove(long requestId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchRefundRequestException {

		return getPersistence().remove(requestId);
	}

	public static RefundRequest updateImpl(RefundRequest refundRequest) {
		return getPersistence().updateImpl(refundRequest);
	}

	/**
	 * Returns the refund request with the primary key or throws a <code>NoSuchRefundRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	public static RefundRequest findByPrimaryKey(long requestId)
		throws com.esq.bus.reservation.slayers.exception.
			NoSuchRefundRequestException {

		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	 * Returns the refund request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request, or <code>null</code> if a refund request with the primary key could not be found
	 */
	public static RefundRequest fetchByPrimaryKey(long requestId) {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	/**
	 * Returns all the refund requests.
	 *
	 * @return the refund requests
	 */
	public static List<RefundRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @return the range of refund requests
	 */
	public static List<RefundRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of refund requests
	 */
	public static List<RefundRequest> findAll(
		int start, int end,
		OrderByComparator<RefundRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the refund requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefundRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refund requests
	 * @param end the upper bound of the range of refund requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of refund requests
	 */
	public static List<RefundRequest> findAll(
		int start, int end, OrderByComparator<RefundRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the refund requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of refund requests.
	 *
	 * @return the number of refund requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RefundRequestPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RefundRequestPersistence _persistence;

}