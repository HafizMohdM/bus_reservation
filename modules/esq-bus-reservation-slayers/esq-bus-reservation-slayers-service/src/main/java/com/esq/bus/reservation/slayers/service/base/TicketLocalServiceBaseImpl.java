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

import com.esq.bus.reservation.slayers.model.Ticket;
import com.esq.bus.reservation.slayers.service.TicketLocalService;
import com.esq.bus.reservation.slayers.service.TicketLocalServiceUtil;
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
 * Provides the base implementation for the ticket local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.esq.bus.reservation.slayers.service.impl.TicketLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.esq.bus.reservation.slayers.service.impl.TicketLocalServiceImpl
 * @generated
 */
public abstract class TicketLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, TicketLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TicketLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TicketLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ticket to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticket the ticket
	 * @return the ticket that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Ticket addTicket(Ticket ticket) {
		ticket.setNew(true);

		return ticketPersistence.update(ticket);
	}

	/**
	 * Creates a new ticket with the primary key. Does not add the ticket to the database.
	 *
	 * @param ticketId the primary key for the new ticket
	 * @return the new ticket
	 */
	@Override
	@Transactional(enabled = false)
	public Ticket createTicket(long ticketId) {
		return ticketPersistence.create(ticketId);
	}

	/**
	 * Deletes the ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticketId the primary key of the ticket
	 * @return the ticket that was removed
	 * @throws PortalException if a ticket with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Ticket deleteTicket(long ticketId) throws PortalException {
		return ticketPersistence.remove(ticketId);
	}

	/**
	 * Deletes the ticket from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticket the ticket
	 * @return the ticket that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Ticket deleteTicket(Ticket ticket) {
		return ticketPersistence.remove(ticket);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return ticketPersistence.dslQuery(dslQuery);
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
			Ticket.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ticketPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TicketModelImpl</code>.
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

		return ticketPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TicketModelImpl</code>.
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

		return ticketPersistence.findWithDynamicQuery(
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
		return ticketPersistence.countWithDynamicQuery(dynamicQuery);
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

		return ticketPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Ticket fetchTicket(long ticketId) {
		return ticketPersistence.fetchByPrimaryKey(ticketId);
	}

	/**
	 * Returns the ticket with the primary key.
	 *
	 * @param ticketId the primary key of the ticket
	 * @return the ticket
	 * @throws PortalException if a ticket with the primary key could not be found
	 */
	@Override
	public Ticket getTicket(long ticketId) throws PortalException {
		return ticketPersistence.findByPrimaryKey(ticketId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ticketLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Ticket.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ticketId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(ticketLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Ticket.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("ticketId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ticketLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Ticket.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ticketId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ticketPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement TicketLocalServiceImpl#deleteTicket(Ticket) to avoid orphaned data");
		}

		return ticketLocalService.deleteTicket((Ticket)persistedModel);
	}

	@Override
	public BasePersistence<Ticket> getBasePersistence() {
		return ticketPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ticketPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esq.bus.reservation.slayers.model.impl.TicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tickets
	 * @param end the upper bound of the range of tickets (not inclusive)
	 * @return the range of tickets
	 */
	@Override
	public List<Ticket> getTickets(int start, int end) {
		return ticketPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of tickets.
	 *
	 * @return the number of tickets
	 */
	@Override
	public int getTicketsCount() {
		return ticketPersistence.countAll();
	}

	/**
	 * Updates the ticket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticket the ticket
	 * @return the ticket that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketPersistence.update(ticket);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TicketLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ticketLocalService = (TicketLocalService)aopProxy;

		_setLocalServiceUtilService(ticketLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TicketLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Ticket.class;
	}

	protected String getModelClassName() {
		return Ticket.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ticketPersistence.getDataSource();

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
		TicketLocalService ticketLocalService) {

		try {
			Field field = TicketLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, ticketLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AdminSettingPersistence adminSettingPersistence;

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

	protected TicketLocalService ticketLocalService;

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
		TicketLocalServiceBaseImpl.class);

}