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

import com.esq.bus.reservation.slayers.exception.NoSuchSeatException;
import com.esq.bus.reservation.slayers.model.Seat;
import com.esq.bus.reservation.slayers.model.SeatTable;
import com.esq.bus.reservation.slayers.model.impl.SeatImpl;
import com.esq.bus.reservation.slayers.model.impl.SeatModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.SeatPersistence;
import com.esq.bus.reservation.slayers.service.persistence.SeatUtil;
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
 * The persistence implementation for the seat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SeatPersistence.class)
public class SeatPersistenceImpl
	extends BasePersistenceImpl<Seat> implements SeatPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SeatUtil</code> to access the seat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SeatImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByscheduleId;
	private FinderPath _finderPathWithoutPaginationFindByscheduleId;
	private FinderPath _finderPathCountByscheduleId;

	/**
	 * Returns all the seats where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the matching seats
	 */
	@Override
	public List<Seat> findByscheduleId(long scheduleId) {
		return findByscheduleId(
			scheduleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seats where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @return the range of matching seats
	 */
	@Override
	public List<Seat> findByscheduleId(long scheduleId, int start, int end) {
		return findByscheduleId(scheduleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the seats where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching seats
	 */
	@Override
	public List<Seat> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Seat> orderByComparator) {

		return findByscheduleId(
			scheduleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the seats where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching seats
	 */
	@Override
	public List<Seat> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Seat> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByscheduleId;
				finderArgs = new Object[] {scheduleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByscheduleId;
			finderArgs = new Object[] {
				scheduleId, start, end, orderByComparator
			};
		}

		List<Seat> list = null;

		if (useFinderCache) {
			list = (List<Seat>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Seat seat : list) {
					if (scheduleId != seat.getScheduleId()) {
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

			sb.append(_SQL_SELECT_SEAT_WHERE);

			sb.append(_FINDER_COLUMN_SCHEDULEID_SCHEDULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SeatModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleId);

				list = (List<Seat>)QueryUtil.list(
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
	 * Returns the first seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat
	 * @throws NoSuchSeatException if a matching seat could not be found
	 */
	@Override
	public Seat findByscheduleId_First(
			long scheduleId, OrderByComparator<Seat> orderByComparator)
		throws NoSuchSeatException {

		Seat seat = fetchByscheduleId_First(scheduleId, orderByComparator);

		if (seat != null) {
			return seat;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleId=");
		sb.append(scheduleId);

		sb.append("}");

		throw new NoSuchSeatException(sb.toString());
	}

	/**
	 * Returns the first seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat, or <code>null</code> if a matching seat could not be found
	 */
	@Override
	public Seat fetchByscheduleId_First(
		long scheduleId, OrderByComparator<Seat> orderByComparator) {

		List<Seat> list = findByscheduleId(scheduleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat
	 * @throws NoSuchSeatException if a matching seat could not be found
	 */
	@Override
	public Seat findByscheduleId_Last(
			long scheduleId, OrderByComparator<Seat> orderByComparator)
		throws NoSuchSeatException {

		Seat seat = fetchByscheduleId_Last(scheduleId, orderByComparator);

		if (seat != null) {
			return seat;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleId=");
		sb.append(scheduleId);

		sb.append("}");

		throw new NoSuchSeatException(sb.toString());
	}

	/**
	 * Returns the last seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat, or <code>null</code> if a matching seat could not be found
	 */
	@Override
	public Seat fetchByscheduleId_Last(
		long scheduleId, OrderByComparator<Seat> orderByComparator) {

		int count = countByscheduleId(scheduleId);

		if (count == 0) {
			return null;
		}

		List<Seat> list = findByscheduleId(
			scheduleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the seats before and after the current seat in the ordered set where scheduleId = &#63;.
	 *
	 * @param seatId the primary key of the current seat
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	@Override
	public Seat[] findByscheduleId_PrevAndNext(
			long seatId, long scheduleId,
			OrderByComparator<Seat> orderByComparator)
		throws NoSuchSeatException {

		Seat seat = findByPrimaryKey(seatId);

		Session session = null;

		try {
			session = openSession();

			Seat[] array = new SeatImpl[3];

			array[0] = getByscheduleId_PrevAndNext(
				session, seat, scheduleId, orderByComparator, true);

			array[1] = seat;

			array[2] = getByscheduleId_PrevAndNext(
				session, seat, scheduleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Seat getByscheduleId_PrevAndNext(
		Session session, Seat seat, long scheduleId,
		OrderByComparator<Seat> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SEAT_WHERE);

		sb.append(_FINDER_COLUMN_SCHEDULEID_SCHEDULEID_2);

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
			sb.append(SeatModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(scheduleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(seat)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Seat> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seats where scheduleId = &#63; from the database.
	 *
	 * @param scheduleId the schedule ID
	 */
	@Override
	public void removeByscheduleId(long scheduleId) {
		for (Seat seat :
				findByscheduleId(
					scheduleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(seat);
		}
	}

	/**
	 * Returns the number of seats where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the number of matching seats
	 */
	@Override
	public int countByscheduleId(long scheduleId) {
		FinderPath finderPath = _finderPathCountByscheduleId;

		Object[] finderArgs = new Object[] {scheduleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SEAT_WHERE);

			sb.append(_FINDER_COLUMN_SCHEDULEID_SCHEDULEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleId);

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

	private static final String _FINDER_COLUMN_SCHEDULEID_SCHEDULEID_2 =
		"seat.scheduleId = ?";

	public SeatPersistenceImpl() {
		setModelClass(Seat.class);

		setModelImplClass(SeatImpl.class);
		setModelPKClass(long.class);

		setTable(SeatTable.INSTANCE);
	}

	/**
	 * Caches the seat in the entity cache if it is enabled.
	 *
	 * @param seat the seat
	 */
	@Override
	public void cacheResult(Seat seat) {
		entityCache.putResult(SeatImpl.class, seat.getPrimaryKey(), seat);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the seats in the entity cache if it is enabled.
	 *
	 * @param seats the seats
	 */
	@Override
	public void cacheResult(List<Seat> seats) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (seats.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Seat seat : seats) {
			if (entityCache.getResult(SeatImpl.class, seat.getPrimaryKey()) ==
					null) {

				cacheResult(seat);
			}
		}
	}

	/**
	 * Clears the cache for all seats.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SeatImpl.class);

		finderCache.clearCache(SeatImpl.class);
	}

	/**
	 * Clears the cache for the seat.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Seat seat) {
		entityCache.removeResult(SeatImpl.class, seat);
	}

	@Override
	public void clearCache(List<Seat> seats) {
		for (Seat seat : seats) {
			entityCache.removeResult(SeatImpl.class, seat);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SeatImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SeatImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new seat with the primary key. Does not add the seat to the database.
	 *
	 * @param seatId the primary key for the new seat
	 * @return the new seat
	 */
	@Override
	public Seat create(long seatId) {
		Seat seat = new SeatImpl();

		seat.setNew(true);
		seat.setPrimaryKey(seatId);

		return seat;
	}

	/**
	 * Removes the seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat that was removed
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	@Override
	public Seat remove(long seatId) throws NoSuchSeatException {
		return remove((Serializable)seatId);
	}

	/**
	 * Removes the seat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the seat
	 * @return the seat that was removed
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	@Override
	public Seat remove(Serializable primaryKey) throws NoSuchSeatException {
		Session session = null;

		try {
			session = openSession();

			Seat seat = (Seat)session.get(SeatImpl.class, primaryKey);

			if (seat == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSeatException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(seat);
		}
		catch (NoSuchSeatException noSuchEntityException) {
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
	protected Seat removeImpl(Seat seat) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(seat)) {
				seat = (Seat)session.get(
					SeatImpl.class, seat.getPrimaryKeyObj());
			}

			if (seat != null) {
				session.delete(seat);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (seat != null) {
			clearCache(seat);
		}

		return seat;
	}

	@Override
	public Seat updateImpl(Seat seat) {
		boolean isNew = seat.isNew();

		if (!(seat instanceof SeatModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(seat.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(seat);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in seat proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Seat implementation " +
					seat.getClass());
		}

		SeatModelImpl seatModelImpl = (SeatModelImpl)seat;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(seat);
			}
			else {
				seat = (Seat)session.merge(seat);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SeatImpl.class, seatModelImpl, false, true);

		if (isNew) {
			seat.setNew(false);
		}

		seat.resetOriginalValues();

		return seat;
	}

	/**
	 * Returns the seat with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the seat
	 * @return the seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	@Override
	public Seat findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSeatException {

		Seat seat = fetchByPrimaryKey(primaryKey);

		if (seat == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSeatException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return seat;
	}

	/**
	 * Returns the seat with the primary key or throws a <code>NoSuchSeatException</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat
	 * @throws NoSuchSeatException if a seat with the primary key could not be found
	 */
	@Override
	public Seat findByPrimaryKey(long seatId) throws NoSuchSeatException {
		return findByPrimaryKey((Serializable)seatId);
	}

	/**
	 * Returns the seat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat
	 * @return the seat, or <code>null</code> if a seat with the primary key could not be found
	 */
	@Override
	public Seat fetchByPrimaryKey(long seatId) {
		return fetchByPrimaryKey((Serializable)seatId);
	}

	/**
	 * Returns all the seats.
	 *
	 * @return the seats
	 */
	@Override
	public List<Seat> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @return the range of seats
	 */
	@Override
	public List<Seat> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of seats
	 */
	@Override
	public List<Seat> findAll(
		int start, int end, OrderByComparator<Seat> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the seats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SeatModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of seats
	 * @param end the upper bound of the range of seats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of seats
	 */
	@Override
	public List<Seat> findAll(
		int start, int end, OrderByComparator<Seat> orderByComparator,
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

		List<Seat> list = null;

		if (useFinderCache) {
			list = (List<Seat>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SEAT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SEAT;

				sql = sql.concat(SeatModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Seat>)QueryUtil.list(
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
	 * Removes all the seats from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Seat seat : findAll()) {
			remove(seat);
		}
	}

	/**
	 * Returns the number of seats.
	 *
	 * @return the number of seats
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SEAT);

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
		return "seatId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SEAT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SeatModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the seat persistence.
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

		_finderPathWithPaginationFindByscheduleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByscheduleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"scheduleId"}, true);

		_finderPathWithoutPaginationFindByscheduleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByscheduleId",
			new String[] {Long.class.getName()}, new String[] {"scheduleId"},
			true);

		_finderPathCountByscheduleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByscheduleId",
			new String[] {Long.class.getName()}, new String[] {"scheduleId"},
			false);

		_setSeatUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSeatUtilPersistence(null);

		entityCache.removeCache(SeatImpl.class.getName());
	}

	private void _setSeatUtilPersistence(SeatPersistence seatPersistence) {
		try {
			Field field = SeatUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, seatPersistence);
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

	private static final String _SQL_SELECT_SEAT = "SELECT seat FROM Seat seat";

	private static final String _SQL_SELECT_SEAT_WHERE =
		"SELECT seat FROM Seat seat WHERE ";

	private static final String _SQL_COUNT_SEAT =
		"SELECT COUNT(seat) FROM Seat seat";

	private static final String _SQL_COUNT_SEAT_WHERE =
		"SELECT COUNT(seat) FROM Seat seat WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "seat.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Seat exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Seat exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SeatPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}