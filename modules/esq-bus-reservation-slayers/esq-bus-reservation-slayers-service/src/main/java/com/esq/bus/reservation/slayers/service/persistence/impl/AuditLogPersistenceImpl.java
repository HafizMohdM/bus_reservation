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

package com.esq.bus.reservation.slayers.service.persistence.impl;

import com.esq.bus.reservation.slayers.exception.NoSuchAuditLogException;
import com.esq.bus.reservation.slayers.model.AuditLog;
import com.esq.bus.reservation.slayers.model.AuditLogTable;
import com.esq.bus.reservation.slayers.model.impl.AuditLogImpl;
import com.esq.bus.reservation.slayers.model.impl.AuditLogModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.AuditLogPersistence;
import com.esq.bus.reservation.slayers.service.persistence.AuditLogUtil;
import com.esq.bus.reservation.slayers.service.persistence.impl.constants.BOOKRESERVATIONPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the audit log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuditLogPersistence.class)
public class AuditLogPersistenceImpl
	extends BasePersistenceImpl<AuditLog> implements AuditLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuditLogUtil</code> to access the audit log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuditLogImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByactionDate;
	private FinderPath _finderPathWithoutPaginationFindByactionDate;
	private FinderPath _finderPathCountByactionDate;

	/**
	 * Returns all the audit logs where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @return the matching audit logs
	 */
	@Override
	public List<AuditLog> findByactionDate(Date actionDate) {
		return findByactionDate(
			actionDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit logs where actionDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param actionDate the action date
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @return the range of matching audit logs
	 */
	@Override
	public List<AuditLog> findByactionDate(
		Date actionDate, int start, int end) {

		return findByactionDate(actionDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit logs where actionDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param actionDate the action date
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit logs
	 */
	@Override
	public List<AuditLog> findByactionDate(
		Date actionDate, int start, int end,
		OrderByComparator<AuditLog> orderByComparator) {

		return findByactionDate(
			actionDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the audit logs where actionDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param actionDate the action date
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit logs
	 */
	@Override
	public List<AuditLog> findByactionDate(
		Date actionDate, int start, int end,
		OrderByComparator<AuditLog> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactionDate;
				finderArgs = new Object[] {_getTime(actionDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactionDate;
			finderArgs = new Object[] {
				_getTime(actionDate), start, end, orderByComparator
			};
		}

		List<AuditLog> list = null;

		if (useFinderCache) {
			list = (List<AuditLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AuditLog auditLog : list) {
					if (!Objects.equals(actionDate, auditLog.getActionDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUDITLOG_WHERE);

			boolean bindActionDate = false;

			if (actionDate == null) {
				sb.append(_FINDER_COLUMN_ACTIONDATE_ACTIONDATE_1);
			}
			else {
				bindActionDate = true;

				sb.append(_FINDER_COLUMN_ACTIONDATE_ACTIONDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionDate) {
					queryPos.add(new Timestamp(actionDate.getTime()));
				}

				list = (List<AuditLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit log
	 * @throws NoSuchAuditLogException if a matching audit log could not be found
	 */
	@Override
	public AuditLog findByactionDate_First(
			Date actionDate, OrderByComparator<AuditLog> orderByComparator)
		throws NoSuchAuditLogException {

		AuditLog auditLog = fetchByactionDate_First(
			actionDate, orderByComparator);

		if (auditLog != null) {
			return auditLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionDate=");
		sb.append(actionDate);

		sb.append("}");

		throw new NoSuchAuditLogException(sb.toString());
	}

	/**
	 * Returns the first audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit log, or <code>null</code> if a matching audit log could not be found
	 */
	@Override
	public AuditLog fetchByactionDate_First(
		Date actionDate, OrderByComparator<AuditLog> orderByComparator) {

		List<AuditLog> list = findByactionDate(
			actionDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit log
	 * @throws NoSuchAuditLogException if a matching audit log could not be found
	 */
	@Override
	public AuditLog findByactionDate_Last(
			Date actionDate, OrderByComparator<AuditLog> orderByComparator)
		throws NoSuchAuditLogException {

		AuditLog auditLog = fetchByactionDate_Last(
			actionDate, orderByComparator);

		if (auditLog != null) {
			return auditLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionDate=");
		sb.append(actionDate);

		sb.append("}");

		throw new NoSuchAuditLogException(sb.toString());
	}

	/**
	 * Returns the last audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit log, or <code>null</code> if a matching audit log could not be found
	 */
	@Override
	public AuditLog fetchByactionDate_Last(
		Date actionDate, OrderByComparator<AuditLog> orderByComparator) {

		int count = countByactionDate(actionDate);

		if (count == 0) {
			return null;
		}

		List<AuditLog> list = findByactionDate(
			actionDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the audit logs before and after the current audit log in the ordered set where actionDate = &#63;.
	 *
	 * @param auditId the primary key of the current audit log
	 * @param actionDate the action date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog[] findByactionDate_PrevAndNext(
			long auditId, Date actionDate,
			OrderByComparator<AuditLog> orderByComparator)
		throws NoSuchAuditLogException {

		AuditLog auditLog = findByPrimaryKey(auditId);

		Session session = null;

		try {
			session = openSession();

			AuditLog[] array = new AuditLogImpl[3];

			array[0] = getByactionDate_PrevAndNext(
				session, auditLog, actionDate, orderByComparator, true);

			array[1] = auditLog;

			array[2] = getByactionDate_PrevAndNext(
				session, auditLog, actionDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuditLog getByactionDate_PrevAndNext(
		Session session, AuditLog auditLog, Date actionDate,
		OrderByComparator<AuditLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUDITLOG_WHERE);

		boolean bindActionDate = false;

		if (actionDate == null) {
			sb.append(_FINDER_COLUMN_ACTIONDATE_ACTIONDATE_1);
		}
		else {
			bindActionDate = true;

			sb.append(_FINDER_COLUMN_ACTIONDATE_ACTIONDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActionDate) {
			queryPos.add(new Timestamp(actionDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(auditLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AuditLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the audit logs where actionDate = &#63; from the database.
	 *
	 * @param actionDate the action date
	 */
	@Override
	public void removeByactionDate(Date actionDate) {
		for (AuditLog auditLog :
				findByactionDate(
					actionDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(auditLog);
		}
	}

	/**
	 * Returns the number of audit logs where actionDate = &#63;.
	 *
	 * @param actionDate the action date
	 * @return the number of matching audit logs
	 */
	@Override
	public int countByactionDate(Date actionDate) {
		FinderPath finderPath = _finderPathCountByactionDate;

		Object[] finderArgs = new Object[] {_getTime(actionDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUDITLOG_WHERE);

			boolean bindActionDate = false;

			if (actionDate == null) {
				sb.append(_FINDER_COLUMN_ACTIONDATE_ACTIONDATE_1);
			}
			else {
				bindActionDate = true;

				sb.append(_FINDER_COLUMN_ACTIONDATE_ACTIONDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionDate) {
					queryPos.add(new Timestamp(actionDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACTIONDATE_ACTIONDATE_1 =
		"auditLog.actionDate IS NULL";

	private static final String _FINDER_COLUMN_ACTIONDATE_ACTIONDATE_2 =
		"auditLog.actionDate = ?";

	public AuditLogPersistenceImpl() {
		setModelClass(AuditLog.class);

		setModelImplClass(AuditLogImpl.class);
		setModelPKClass(long.class);

		setTable(AuditLogTable.INSTANCE);
	}

	/**
	 * Caches the audit log in the entity cache if it is enabled.
	 *
	 * @param auditLog the audit log
	 */
	@Override
	public void cacheResult(AuditLog auditLog) {
		entityCache.putResult(
			AuditLogImpl.class, auditLog.getPrimaryKey(), auditLog);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the audit logs in the entity cache if it is enabled.
	 *
	 * @param auditLogs the audit logs
	 */
	@Override
	public void cacheResult(List<AuditLog> auditLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (auditLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AuditLog auditLog : auditLogs) {
			if (entityCache.getResult(
					AuditLogImpl.class, auditLog.getPrimaryKey()) == null) {

				cacheResult(auditLog);
			}
		}
	}

	/**
	 * Clears the cache for all audit logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuditLogImpl.class);

		finderCache.clearCache(AuditLogImpl.class);
	}

	/**
	 * Clears the cache for the audit log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditLog auditLog) {
		entityCache.removeResult(AuditLogImpl.class, auditLog);
	}

	@Override
	public void clearCache(List<AuditLog> auditLogs) {
		for (AuditLog auditLog : auditLogs) {
			entityCache.removeResult(AuditLogImpl.class, auditLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AuditLogImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuditLogImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new audit log with the primary key. Does not add the audit log to the database.
	 *
	 * @param auditId the primary key for the new audit log
	 * @return the new audit log
	 */
	@Override
	public AuditLog create(long auditId) {
		AuditLog auditLog = new AuditLogImpl();

		auditLog.setNew(true);
		auditLog.setPrimaryKey(auditId);

		return auditLog;
	}

	/**
	 * Removes the audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log that was removed
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog remove(long auditId) throws NoSuchAuditLogException {
		return remove((Serializable)auditId);
	}

	/**
	 * Removes the audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the audit log
	 * @return the audit log that was removed
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog remove(Serializable primaryKey)
		throws NoSuchAuditLogException {

		Session session = null;

		try {
			session = openSession();

			AuditLog auditLog = (AuditLog)session.get(
				AuditLogImpl.class, primaryKey);

			if (auditLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(auditLog);
		}
		catch (NoSuchAuditLogException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AuditLog removeImpl(AuditLog auditLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(auditLog)) {
				auditLog = (AuditLog)session.get(
					AuditLogImpl.class, auditLog.getPrimaryKeyObj());
			}

			if (auditLog != null) {
				session.delete(auditLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (auditLog != null) {
			clearCache(auditLog);
		}

		return auditLog;
	}

	@Override
	public AuditLog updateImpl(AuditLog auditLog) {
		boolean isNew = auditLog.isNew();

		if (!(auditLog instanceof AuditLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(auditLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(auditLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in auditLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AuditLog implementation " +
					auditLog.getClass());
		}

		AuditLogModelImpl auditLogModelImpl = (AuditLogModelImpl)auditLog;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(auditLog);
			}
			else {
				auditLog = (AuditLog)session.merge(auditLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AuditLogImpl.class, auditLogModelImpl, false, true);

		if (isNew) {
			auditLog.setNew(false);
		}

		auditLog.resetOriginalValues();

		return auditLog;
	}

	/**
	 * Returns the audit log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the audit log
	 * @return the audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditLogException {

		AuditLog auditLog = fetchByPrimaryKey(primaryKey);

		if (auditLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return auditLog;
	}

	/**
	 * Returns the audit log with the primary key or throws a <code>NoSuchAuditLogException</code> if it could not be found.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log
	 * @throws NoSuchAuditLogException if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog findByPrimaryKey(long auditId)
		throws NoSuchAuditLogException {

		return findByPrimaryKey((Serializable)auditId);
	}

	/**
	 * Returns the audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditId the primary key of the audit log
	 * @return the audit log, or <code>null</code> if a audit log with the primary key could not be found
	 */
	@Override
	public AuditLog fetchByPrimaryKey(long auditId) {
		return fetchByPrimaryKey((Serializable)auditId);
	}

	/**
	 * Returns all the audit logs.
	 *
	 * @return the audit logs
	 */
	@Override
	public List<AuditLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @return the range of audit logs
	 */
	@Override
	public List<AuditLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audit logs
	 */
	@Override
	public List<AuditLog> findAll(
		int start, int end, OrderByComparator<AuditLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit logs
	 * @param end the upper bound of the range of audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of audit logs
	 */
	@Override
	public List<AuditLog> findAll(
		int start, int end, OrderByComparator<AuditLog> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AuditLog> list = null;

		if (useFinderCache) {
			list = (List<AuditLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUDITLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITLOG;

				sql = sql.concat(AuditLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AuditLog>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the audit logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AuditLog auditLog : findAll()) {
			remove(auditLog);
		}
	}

	/**
	 * Returns the number of audit logs.
	 *
	 * @return the number of audit logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUDITLOG);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "auditId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUDITLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuditLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the audit log persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByactionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactionDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"actionDate"}, true);

		_finderPathWithoutPaginationFindByactionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactionDate",
			new String[] {Date.class.getName()}, new String[] {"actionDate"},
			true);

		_finderPathCountByactionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactionDate",
			new String[] {Date.class.getName()}, new String[] {"actionDate"},
			false);

		_setAuditLogUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAuditLogUtilPersistence(null);

		entityCache.removeCache(AuditLogImpl.class.getName());
	}

	private void _setAuditLogUtilPersistence(
		AuditLogPersistence auditLogPersistence) {

		try {
			Field field = AuditLogUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, auditLogPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = BOOKRESERVATIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BOOKRESERVATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BOOKRESERVATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_AUDITLOG =
		"SELECT auditLog FROM AuditLog auditLog";

	private static final String _SQL_SELECT_AUDITLOG_WHERE =
		"SELECT auditLog FROM AuditLog auditLog WHERE ";

	private static final String _SQL_COUNT_AUDITLOG =
		"SELECT COUNT(auditLog) FROM AuditLog auditLog";

	private static final String _SQL_COUNT_AUDITLOG_WHERE =
		"SELECT COUNT(auditLog) FROM AuditLog auditLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "auditLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AuditLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AuditLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuditLogPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}