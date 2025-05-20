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

import com.esq.bus.reservation.slayers.exception.NoSuchRefundRequestException;
import com.esq.bus.reservation.slayers.model.RefundRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the refund request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefundRequestUtil
 * @generated
 */
@ProviderType
public interface RefundRequestPersistence
	extends BasePersistence<RefundRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RefundRequestUtil} to access the refund request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the refund request in the entity cache if it is enabled.
	 *
	 * @param refundRequest the refund request
	 */
	public void cacheResult(RefundRequest refundRequest);

	/**
	 * Caches the refund requests in the entity cache if it is enabled.
	 *
	 * @param refundRequests the refund requests
	 */
	public void cacheResult(java.util.List<RefundRequest> refundRequests);

	/**
	 * Creates a new refund request with the primary key. Does not add the refund request to the database.
	 *
	 * @param requestId the primary key for the new refund request
	 * @return the new refund request
	 */
	public RefundRequest create(long requestId);

	/**
	 * Removes the refund request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request that was removed
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	public RefundRequest remove(long requestId)
		throws NoSuchRefundRequestException;

	public RefundRequest updateImpl(RefundRequest refundRequest);

	/**
	 * Returns the refund request with the primary key or throws a <code>NoSuchRefundRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request
	 * @throws NoSuchRefundRequestException if a refund request with the primary key could not be found
	 */
	public RefundRequest findByPrimaryKey(long requestId)
		throws NoSuchRefundRequestException;

	/**
	 * Returns the refund request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the refund request
	 * @return the refund request, or <code>null</code> if a refund request with the primary key could not be found
	 */
	public RefundRequest fetchByPrimaryKey(long requestId);

	/**
	 * Returns all the refund requests.
	 *
	 * @return the refund requests
	 */
	public java.util.List<RefundRequest> findAll();

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
	public java.util.List<RefundRequest> findAll(int start, int end);

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
	public java.util.List<RefundRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RefundRequest>
			orderByComparator);

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
	public java.util.List<RefundRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RefundRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the refund requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of refund requests.
	 *
	 * @return the number of refund requests
	 */
	public int countAll();

}