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

import com.esq.bus.reservation.slayers.exception.NoSuchTravelScheduleException;
import com.esq.bus.reservation.slayers.model.TravelSchedule;
import com.esq.bus.reservation.slayers.model.TravelScheduleTable;
import com.esq.bus.reservation.slayers.model.impl.TravelScheduleImpl;
import com.esq.bus.reservation.slayers.model.impl.TravelScheduleModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.TravelSchedulePersistence;
import com.esq.bus.reservation.slayers.service.persistence.TravelScheduleUtil;
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

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the travel schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TravelSchedulePersistence.class)
public class TravelSchedulePersistenceImpl
	extends BasePersistenceImpl<TravelSchedule>
	implements TravelSchedulePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelScheduleUtil</code> to access the travel schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelScheduleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBybusId;
	private FinderPath _finderPathWithoutPaginationFindBybusId;
	private FinderPath _finderPathCountBybusId;

	/**
	 * Returns all the travel schedules where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the matching travel schedules
	 */
	@Override
	public List<TravelSchedule> findBybusId(long busId) {
		return findBybusId(busId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel schedules where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @return the range of matching travel schedules
	 */
	@Override
	public List<TravelSchedule> findBybusId(long busId, int start, int end) {
		return findBybusId(busId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel schedules where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel schedules
	 */
	@Override
	public List<TravelSchedule> findBybusId(
		long busId, int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator) {

		return findBybusId(busId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel schedules where busId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param busId the bus ID
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel schedules
	 */
	@Override
	public List<TravelSchedule> findBybusId(
		long busId, int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBybusId;
				finderArgs = new Object[] {busId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBybusId;
			finderArgs = new Object[] {busId, start, end, orderByComparator};
		}

		List<TravelSchedule> list = null;

		if (useFinderCache) {
			list = (List<TravelSchedule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelSchedule travelSchedule : list) {
					if (busId != travelSchedule.getBusId()) {
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

			sb.append(_SQL_SELECT_TRAVELSCHEDULE_WHERE);

			sb.append(_FINDER_COLUMN_BUSID_BUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelScheduleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(busId);

				list = (List<TravelSchedule>)QueryUtil.list(
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
	 * Returns the first travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel schedule
	 * @throws NoSuchTravelScheduleException if a matching travel schedule could not be found
	 */
	@Override
	public TravelSchedule findBybusId_First(
			long busId, OrderByComparator<TravelSchedule> orderByComparator)
		throws NoSuchTravelScheduleException {

		TravelSchedule travelSchedule = fetchBybusId_First(
			busId, orderByComparator);

		if (travelSchedule != null) {
			return travelSchedule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("busId=");
		sb.append(busId);

		sb.append("}");

		throw new NoSuchTravelScheduleException(sb.toString());
	}

	/**
	 * Returns the first travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel schedule, or <code>null</code> if a matching travel schedule could not be found
	 */
	@Override
	public TravelSchedule fetchBybusId_First(
		long busId, OrderByComparator<TravelSchedule> orderByComparator) {

		List<TravelSchedule> list = findBybusId(busId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel schedule
	 * @throws NoSuchTravelScheduleException if a matching travel schedule could not be found
	 */
	@Override
	public TravelSchedule findBybusId_Last(
			long busId, OrderByComparator<TravelSchedule> orderByComparator)
		throws NoSuchTravelScheduleException {

		TravelSchedule travelSchedule = fetchBybusId_Last(
			busId, orderByComparator);

		if (travelSchedule != null) {
			return travelSchedule;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("busId=");
		sb.append(busId);

		sb.append("}");

		throw new NoSuchTravelScheduleException(sb.toString());
	}

	/**
	 * Returns the last travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel schedule, or <code>null</code> if a matching travel schedule could not be found
	 */
	@Override
	public TravelSchedule fetchBybusId_Last(
		long busId, OrderByComparator<TravelSchedule> orderByComparator) {

		int count = countBybusId(busId);

		if (count == 0) {
			return null;
		}

		List<TravelSchedule> list = findBybusId(
			busId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel schedules before and after the current travel schedule in the ordered set where busId = &#63;.
	 *
	 * @param scheduleId the primary key of the current travel schedule
	 * @param busId the bus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	@Override
	public TravelSchedule[] findBybusId_PrevAndNext(
			long scheduleId, long busId,
			OrderByComparator<TravelSchedule> orderByComparator)
		throws NoSuchTravelScheduleException {

		TravelSchedule travelSchedule = findByPrimaryKey(scheduleId);

		Session session = null;

		try {
			session = openSession();

			TravelSchedule[] array = new TravelScheduleImpl[3];

			array[0] = getBybusId_PrevAndNext(
				session, travelSchedule, busId, orderByComparator, true);

			array[1] = travelSchedule;

			array[2] = getBybusId_PrevAndNext(
				session, travelSchedule, busId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelSchedule getBybusId_PrevAndNext(
		Session session, TravelSchedule travelSchedule, long busId,
		OrderByComparator<TravelSchedule> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELSCHEDULE_WHERE);

		sb.append(_FINDER_COLUMN_BUSID_BUSID_2);

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
			sb.append(TravelScheduleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(busId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						travelSchedule)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelSchedule> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel schedules where busId = &#63; from the database.
	 *
	 * @param busId the bus ID
	 */
	@Override
	public void removeBybusId(long busId) {
		for (TravelSchedule travelSchedule :
				findBybusId(
					busId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelSchedule);
		}
	}

	/**
	 * Returns the number of travel schedules where busId = &#63;.
	 *
	 * @param busId the bus ID
	 * @return the number of matching travel schedules
	 */
	@Override
	public int countBybusId(long busId) {
		FinderPath finderPath = _finderPathCountBybusId;

		Object[] finderArgs = new Object[] {busId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELSCHEDULE_WHERE);

			sb.append(_FINDER_COLUMN_BUSID_BUSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(busId);

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

	private static final String _FINDER_COLUMN_BUSID_BUSID_2 =
		"travelSchedule.busId = ?";

	public TravelSchedulePersistenceImpl() {
		setModelClass(TravelSchedule.class);

		setModelImplClass(TravelScheduleImpl.class);
		setModelPKClass(long.class);

		setTable(TravelScheduleTable.INSTANCE);
	}

	/**
	 * Caches the travel schedule in the entity cache if it is enabled.
	 *
	 * @param travelSchedule the travel schedule
	 */
	@Override
	public void cacheResult(TravelSchedule travelSchedule) {
		entityCache.putResult(
			TravelScheduleImpl.class, travelSchedule.getPrimaryKey(),
			travelSchedule);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel schedules in the entity cache if it is enabled.
	 *
	 * @param travelSchedules the travel schedules
	 */
	@Override
	public void cacheResult(List<TravelSchedule> travelSchedules) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelSchedules.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelSchedule travelSchedule : travelSchedules) {
			if (entityCache.getResult(
					TravelScheduleImpl.class, travelSchedule.getPrimaryKey()) ==
						null) {

				cacheResult(travelSchedule);
			}
		}
	}

	/**
	 * Clears the cache for all travel schedules.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelScheduleImpl.class);

		finderCache.clearCache(TravelScheduleImpl.class);
	}

	/**
	 * Clears the cache for the travel schedule.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelSchedule travelSchedule) {
		entityCache.removeResult(TravelScheduleImpl.class, travelSchedule);
	}

	@Override
	public void clearCache(List<TravelSchedule> travelSchedules) {
		for (TravelSchedule travelSchedule : travelSchedules) {
			entityCache.removeResult(TravelScheduleImpl.class, travelSchedule);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TravelScheduleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TravelScheduleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel schedule with the primary key. Does not add the travel schedule to the database.
	 *
	 * @param scheduleId the primary key for the new travel schedule
	 * @return the new travel schedule
	 */
	@Override
	public TravelSchedule create(long scheduleId) {
		TravelSchedule travelSchedule = new TravelScheduleImpl();

		travelSchedule.setNew(true);
		travelSchedule.setPrimaryKey(scheduleId);

		return travelSchedule;
	}

	/**
	 * Removes the travel schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule that was removed
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	@Override
	public TravelSchedule remove(long scheduleId)
		throws NoSuchTravelScheduleException {

		return remove((Serializable)scheduleId);
	}

	/**
	 * Removes the travel schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel schedule
	 * @return the travel schedule that was removed
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	@Override
	public TravelSchedule remove(Serializable primaryKey)
		throws NoSuchTravelScheduleException {

		Session session = null;

		try {
			session = openSession();

			TravelSchedule travelSchedule = (TravelSchedule)session.get(
				TravelScheduleImpl.class, primaryKey);

			if (travelSchedule == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelScheduleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelSchedule);
		}
		catch (NoSuchTravelScheduleException noSuchEntityException) {
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
	protected TravelSchedule removeImpl(TravelSchedule travelSchedule) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelSchedule)) {
				travelSchedule = (TravelSchedule)session.get(
					TravelScheduleImpl.class,
					travelSchedule.getPrimaryKeyObj());
			}

			if (travelSchedule != null) {
				session.delete(travelSchedule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelSchedule != null) {
			clearCache(travelSchedule);
		}

		return travelSchedule;
	}

	@Override
	public TravelSchedule updateImpl(TravelSchedule travelSchedule) {
		boolean isNew = travelSchedule.isNew();

		if (!(travelSchedule instanceof TravelScheduleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelSchedule.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelSchedule);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelSchedule proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelSchedule implementation " +
					travelSchedule.getClass());
		}

		TravelScheduleModelImpl travelScheduleModelImpl =
			(TravelScheduleModelImpl)travelSchedule;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelSchedule);
			}
			else {
				travelSchedule = (TravelSchedule)session.merge(travelSchedule);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelScheduleImpl.class, travelScheduleModelImpl, false, true);

		if (isNew) {
			travelSchedule.setNew(false);
		}

		travelSchedule.resetOriginalValues();

		return travelSchedule;
	}

	/**
	 * Returns the travel schedule with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel schedule
	 * @return the travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	@Override
	public TravelSchedule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelScheduleException {

		TravelSchedule travelSchedule = fetchByPrimaryKey(primaryKey);

		if (travelSchedule == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelScheduleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelSchedule;
	}

	/**
	 * Returns the travel schedule with the primary key or throws a <code>NoSuchTravelScheduleException</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule
	 * @throws NoSuchTravelScheduleException if a travel schedule with the primary key could not be found
	 */
	@Override
	public TravelSchedule findByPrimaryKey(long scheduleId)
		throws NoSuchTravelScheduleException {

		return findByPrimaryKey((Serializable)scheduleId);
	}

	/**
	 * Returns the travel schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the travel schedule
	 * @return the travel schedule, or <code>null</code> if a travel schedule with the primary key could not be found
	 */
	@Override
	public TravelSchedule fetchByPrimaryKey(long scheduleId) {
		return fetchByPrimaryKey((Serializable)scheduleId);
	}

	/**
	 * Returns all the travel schedules.
	 *
	 * @return the travel schedules
	 */
	@Override
	public List<TravelSchedule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @return the range of travel schedules
	 */
	@Override
	public List<TravelSchedule> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel schedules
	 */
	@Override
	public List<TravelSchedule> findAll(
		int start, int end,
		OrderByComparator<TravelSchedule> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel schedules
	 * @param end the upper bound of the range of travel schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel schedules
	 */
	@Override
	public List<TravelSchedule> findAll(
		int start, int end, OrderByComparator<TravelSchedule> orderByComparator,
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

		List<TravelSchedule> list = null;

		if (useFinderCache) {
			list = (List<TravelSchedule>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELSCHEDULE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELSCHEDULE;

				sql = sql.concat(TravelScheduleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelSchedule>)QueryUtil.list(
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
	 * Removes all the travel schedules from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelSchedule travelSchedule : findAll()) {
			remove(travelSchedule);
		}
	}

	/**
	 * Returns the number of travel schedules.
	 *
	 * @return the number of travel schedules
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRAVELSCHEDULE);

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
		return "scheduleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELSCHEDULE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelScheduleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel schedule persistence.
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

		_finderPathWithPaginationFindBybusId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybusId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"busId"}, true);

		_finderPathWithoutPaginationFindBybusId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybusId",
			new String[] {Long.class.getName()}, new String[] {"busId"}, true);

		_finderPathCountBybusId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybusId",
			new String[] {Long.class.getName()}, new String[] {"busId"}, false);

		_setTravelScheduleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelScheduleUtilPersistence(null);

		entityCache.removeCache(TravelScheduleImpl.class.getName());
	}

	private void _setTravelScheduleUtilPersistence(
		TravelSchedulePersistence travelSchedulePersistence) {

		try {
			Field field = TravelScheduleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelSchedulePersistence);
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

	private static final String _SQL_SELECT_TRAVELSCHEDULE =
		"SELECT travelSchedule FROM TravelSchedule travelSchedule";

	private static final String _SQL_SELECT_TRAVELSCHEDULE_WHERE =
		"SELECT travelSchedule FROM TravelSchedule travelSchedule WHERE ";

	private static final String _SQL_COUNT_TRAVELSCHEDULE =
		"SELECT COUNT(travelSchedule) FROM TravelSchedule travelSchedule";

	private static final String _SQL_COUNT_TRAVELSCHEDULE_WHERE =
		"SELECT COUNT(travelSchedule) FROM TravelSchedule travelSchedule WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "travelSchedule.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelSchedule exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelSchedule exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelSchedulePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}