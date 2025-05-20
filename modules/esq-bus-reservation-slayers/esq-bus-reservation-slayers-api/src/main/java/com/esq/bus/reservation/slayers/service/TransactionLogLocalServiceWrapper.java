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

package com.esq.bus.reservation.slayers.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TransactionLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TransactionLogLocalService
 * @generated
 */
public class TransactionLogLocalServiceWrapper
	implements ServiceWrapper<TransactionLogLocalService>,
			   TransactionLogLocalService {

	public TransactionLogLocalServiceWrapper() {
		this(null);
	}

	public TransactionLogLocalServiceWrapper(
		TransactionLogLocalService transactionLogLocalService) {

		_transactionLogLocalService = transactionLogLocalService;
	}

	/**
	 * Adds the transaction log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransactionLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transactionLog the transaction log
	 * @return the transaction log that was added
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
		addTransactionLog(
			com.esq.bus.reservation.slayers.model.TransactionLog
				transactionLog) {

		return _transactionLogLocalService.addTransactionLog(transactionLog);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new transaction log with the primary key. Does not add the transaction log to the database.
	 *
	 * @param logId the primary key for the new transaction log
	 * @return the new transaction log
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
		createTransactionLog(long logId) {

		return _transactionLogLocalService.createTransactionLog(logId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLogLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the transaction log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransactionLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log that was removed
	 * @throws PortalException if a transaction log with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
			deleteTransactionLog(long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLogLocalService.deleteTransactionLog(logId);
	}

	/**
	 * Deletes the transaction log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransactionLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transactionLog the transaction log
	 * @return the transaction log that was removed
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
		deleteTransactionLog(
			com.esq.bus.reservation.slayers.model.TransactionLog
				transactionLog) {

		return _transactionLogLocalService.deleteTransactionLog(transactionLog);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _transactionLogLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _transactionLogLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _transactionLogLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _transactionLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _transactionLogLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _transactionLogLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _transactionLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _transactionLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
		fetchTransactionLog(long logId) {

		return _transactionLogLocalService.fetchTransactionLog(logId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _transactionLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _transactionLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _transactionLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the transaction log with the primary key.
	 *
	 * @param logId the primary key of the transaction log
	 * @return the transaction log
	 * @throws PortalException if a transaction log with the primary key could not be found
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
			getTransactionLog(long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _transactionLogLocalService.getTransactionLog(logId);
	}

	/**
	 * Returns a range of all the transaction logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TransactionLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction logs
	 * @param end the upper bound of the range of transaction logs (not inclusive)
	 * @return the range of transaction logs
	 */
	@Override
	public java.util.List<com.esq.bus.reservation.slayers.model.TransactionLog>
		getTransactionLogs(int start, int end) {

		return _transactionLogLocalService.getTransactionLogs(start, end);
	}

	/**
	 * Returns the number of transaction logs.
	 *
	 * @return the number of transaction logs
	 */
	@Override
	public int getTransactionLogsCount() {
		return _transactionLogLocalService.getTransactionLogsCount();
	}

	/**
	 * Updates the transaction log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TransactionLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param transactionLog the transaction log
	 * @return the transaction log that was updated
	 */
	@Override
	public com.esq.bus.reservation.slayers.model.TransactionLog
		updateTransactionLog(
			com.esq.bus.reservation.slayers.model.TransactionLog
				transactionLog) {

		return _transactionLogLocalService.updateTransactionLog(transactionLog);
	}

	@Override
	public TransactionLogLocalService getWrappedService() {
		return _transactionLogLocalService;
	}

	@Override
	public void setWrappedService(
		TransactionLogLocalService transactionLogLocalService) {

		_transactionLogLocalService = transactionLogLocalService;
	}

	private TransactionLogLocalService _transactionLogLocalService;

}