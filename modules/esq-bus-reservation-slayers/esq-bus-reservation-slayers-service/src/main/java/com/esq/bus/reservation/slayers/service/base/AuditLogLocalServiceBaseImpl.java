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

package com.esq.bus.reservation.slayers.service.base;

import com.esq.bus.reservation.slayers.model.AuditLog;
import com.esq.bus.reservation.slayers.service.AuditLogLocalService;
import com.esq.bus.reservation.slayers.service.AuditLogLocalServiceUtil;
import com.esq.bus.reservation.slayers.service.persistence.AdminSettingPersistence;
import com.esq.bus.reservation.slayers.service.persistence.AuditLogPersistence;
import com.esq.bus.reservation.slayers.service.persistence.BookingPersistence;
import com.esq.bus.reservation.slayers.service.persistence.BusPersistence;
import com.esq.bus.reservation.slayers.service.persistence.BusUserPersistence;
import com.esq.bus.reservation.slayers.service.persistence.DiscountPersistence;
import com.esq.bus.reservation.slayers.service.persistence.DriverLogPersistence;
import com.esq.bus.reservation.slayers.service.persistence.DriverPersistence;
import com.esq.bus.reservation.slayers.service.persistence.FeedbackPersistence;
import com.esq.bus.reservation.slayers.service.persistence.LocationPersistence;
import com.esq.bus.reservation.slayers.service.persistence.NotificationPersistence;
import com.esq.bus.reservation.slayers.service.persistence.PassengerPersistence;
import com.esq.bus.reservation.slayers.service.persistence.PaymentPersistence;
import com.esq.bus.reservation.slayers.service.persistence.RefundRequestPersistence;
import com.esq.bus.reservation.slayers.service.persistence.RoutePersistence;
import com.esq.bus.reservation.slayers.service.persistence.SeatPersistence;
import com.esq.bus.reservation.slayers.service.persistence.SupportTicketPersistence;
import com.esq.bus.reservation.slayers.service.persistence.TicketPersistence;
import com.esq.bus.reservation.slayers.service.persistence.TransactionLogPersistence;
import com.esq.bus.reservation.slayers.service.persistence.TravelSchedulePersistence;
import com.esq.bus.reservation.slayers.service.persistence.UserRolePersistence;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the audit log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.esq.bus.reservation.slayers.service.impl.AuditLogLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.esq.bus.reservation.slayers.service.impl.AuditLogLocalServiceImpl
 * @generated
 */
public abstract class AuditLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, AuditLogLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AuditLogLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AuditLogLocalServiceUtil</code>.
	 */

	/**
	 * Adds the audit log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLog the audit log
	 * @return the audit log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AuditLog addAuditLog(AuditLog auditLog) {
		auditLog.setNew(true);

		return auditLogPersistence.update(auditLog);
	}

	/**
	 * Creates a new audit log with the primary key. Does not add the audit log to the database.
	 *
	 * @param auditId the primary key for the new audit log
	 * @return the new audit log
	 */
	@Override
	@Transactional(enabled = false)
	public AuditLog createAuditLog(long auditId) {
		return auditLogPersistence.create(auditId);
	}

	/**
	 * Deletes the audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log that was removed
	 * @throws PortalException if a audit log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AuditLog deleteAuditLog(long auditId) throws PortalException {
		return auditLogPersistence.remove(auditId);
	}

	/**
	 * Deletes the audit log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLog the audit log
	 * @return the audit log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AuditLog deleteAuditLog(AuditLog auditLog) {
		return auditLogPersistence.remove(auditLog);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return auditLogPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			AuditLog.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return auditLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return auditLogPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return auditLogPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return auditLogPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return auditLogPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AuditLog fetchAuditLog(long auditId) {
		return auditLogPersistence.fetchByPrimaryKey(auditId);
	}

	/**
	 * Returns the audit log with the primary key.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log
	 * @throws PortalException if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog getAuditLog(long auditId) throws PortalException {
		return auditLogPersistence.findByPrimaryKey(auditId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(auditLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AuditLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("auditId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			auditLogLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AuditLog.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("auditId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(auditLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AuditLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("auditId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return auditLogPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement AuditLogLocalServiceImpl#deleteAuditLog(AuditLog) to avoid orphaned data");
		}

		return auditLogLocalService.deleteAuditLog((AuditLog)persistedModel);
	}

	@Override
	public BasePersistence<AuditLog> getBasePersistence() {
		return auditLogPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return auditLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @return the range of audit logs
	 */
	@Override
	public List<AuditLog> getAuditLogs(int start, int end) {
		return auditLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of audit logs.
	 *
	 * @return the number of audit logs
	 */
	@Override
	public int getAuditLogsCount() {
		return auditLogPersistence.countAll();
	}

	/**
	 * Updates the audit log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuditLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditLog the audit log
	 * @return the audit log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AuditLog updateAuditLog(AuditLog auditLog) {
		return auditLogPersistence.update(auditLog);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AuditLogLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		auditLogLocalService = (AuditLogLocalService)aopProxy;

		_setLocalServiceUtilService(auditLogLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AuditLogLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AuditLog.class;
	}

	protected String getModelClassName() {
		return AuditLog.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = auditLogPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		AuditLogLocalService auditLogLocalService) {

		try {
			Field field = AuditLogLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, auditLogLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AdminSettingPersistence adminSettingPersistence;

	protected AuditLogLocalService auditLogLocalService;

	@Reference
	protected AuditLogPersistence auditLogPersistence;

	@Reference
	protected BookingPersistence bookingPersistence;

	@Reference
	protected BusPersistence busPersistence;

	@Reference
	protected BusUserPersistence busUserPersistence;

	@Reference
	protected DiscountPersistence discountPersistence;

	@Reference
	protected DriverPersistence driverPersistence;

	@Reference
	protected DriverLogPersistence driverLogPersistence;

	@Reference
	protected FeedbackPersistence feedbackPersistence;

	@Reference
	protected LocationPersistence locationPersistence;

	@Reference
	protected NotificationPersistence notificationPersistence;

	@Reference
	protected PassengerPersistence passengerPersistence;

	@Reference
	protected PaymentPersistence paymentPersistence;

	@Reference
	protected RefundRequestPersistence refundRequestPersistence;

	@Reference
	protected RoutePersistence routePersistence;

	@Reference
	protected SeatPersistence seatPersistence;

	@Reference
	protected SupportTicketPersistence supportTicketPersistence;

	@Reference
	protected TicketPersistence ticketPersistence;

	@Reference
	protected TransactionLogPersistence transactionLogPersistence;

	@Reference
	protected TravelSchedulePersistence travelSchedulePersistence;

	@Reference
	protected UserRolePersistence userRolePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		AuditLogLocalServiceBaseImpl.class);

}