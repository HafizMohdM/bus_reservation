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

import com.esq.bus.reservation.slayers.exception.NoSuchTransactionLogException;
import com.esq.bus.reservation.slayers.model.TransactionLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the transaction log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLogUtil
 * @generated
 */
@ProviderType
public interface TransactionLogPersistence
	extends BasePersistence<TransactionLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TransactionLogUtil} to access the transaction log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the transaction log in the entity cache if it is enabled.
	 *
	 * @param transactionLog the transaction log
	 */
	public void cacheResult(TransactionLog transactionLog);

	/**
	 * Caches the transaction logs in the entity cache if it is enabled.
	 *
	 * @param transactionLogs the transaction logs
	 */
	public void cacheResult(java.util.List<TransactionLog> transactionLogs);

	/**
	 * Creates a new transaction log with the primary key. Does not add the transaction log to the database.
	 *
	 * @param logId the primary key for the new transaction log
	 * @return the new transaction log
	 */
	public TransactionLog create(long logId);

	/**
	 * Removes the transaction log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log that was removed
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	public TransactionLog remove(long logId)
		throws NoSuchTransactionLogException;

	public TransactionLog updateImpl(TransactionLog transactionLog);

	/**
	 * Returns the transaction log with the primary key or throws a <code>NoSuchTransactionLogException</code> if it could not be found.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log
	 * @throws NoSuchTransactionLogException if a transaction log with the primary key could not be found
	 */
	public TransactionLog findByPrimaryKey(long logId)
		throws NoSuchTransactionLogException;

	/**
	 * Returns the transaction log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log, or <code>null</code> if a transaction log with the primary key could not be found
	 */
	public TransactionLog fetchByPrimaryKey(long logId);

	/**
	 * Returns all the transaction logs.
	 *
	 * @return the transaction logs
	 */
	public java.util.List<TransactionLog> findAll();

	/**
	 * Returns a range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @return the range of transaction logs
	 */
	public java.util.List<TransactionLog> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of transaction logs
	 */
	public java.util.List<TransactionLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransactionLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of transaction logs
	 */
	public java.util.List<TransactionLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TransactionLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the transaction logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of transaction logs.
	 *
	 * @return the number of transaction logs
	 */
	public int countAll();

}