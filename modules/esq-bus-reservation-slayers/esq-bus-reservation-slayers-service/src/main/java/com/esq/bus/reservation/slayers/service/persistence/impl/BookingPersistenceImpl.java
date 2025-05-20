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

import com.esq.bus.reservation.slayers.exception.NoSuchBookingException;
import com.esq.bus.reservation.slayers.model.Booking;
import com.esq.bus.reservation.slayers.model.BookingTable;
import com.esq.bus.reservation.slayers.model.impl.BookingImpl;
import com.esq.bus.reservation.slayers.model.impl.BookingModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.BookingPersistence;
import com.esq.bus.reservation.slayers.service.persistence.BookingUtil;
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
 * The persistence implementation for the booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookingPersistence.class)
public class BookingPersistenceImpl
	extends BasePersistenceImpl<Booking> implements BookingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookingUtil</code> to access the booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookingImpl.class.getName();

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
	 * Returns all the bookings where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the matching bookings
	 */
	@Override
	public List<Booking> findByscheduleId(long scheduleId) {
		return findByscheduleId(
			scheduleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bookings where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of matching bookings
	 */
	@Override
	public List<Booking> findByscheduleId(long scheduleId, int start, int end) {
		return findByscheduleId(scheduleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bookings where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookings
	 */
	@Override
	public List<Booking> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Booking> orderByComparator) {

		return findByscheduleId(
			scheduleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bookings where scheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleId the schedule ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookings
	 */
	@Override
	public List<Booking> findByscheduleId(
		long scheduleId, int start, int end,
		OrderByComparator<Booking> orderByComparator, boolean useFinderCache) {

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

		List<Booking> list = null;

		if (useFinderCache) {
			list = (List<Booking>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Booking booking : list) {
					if (scheduleId != booking.getScheduleId()) {
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

			sb.append(_SQL_SELECT_BOOKING_WHERE);

			sb.append(_FINDER_COLUMN_SCHEDULEID_SCHEDULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleId);

				list = (List<Booking>)QueryUtil.list(
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
	 * Returns the first booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	@Override
	public Booking findByscheduleId_First(
			long scheduleId, OrderByComparator<Booking> orderByComparator)
		throws NoSuchBookingException {

		Booking booking = fetchByscheduleId_First(
			scheduleId, orderByComparator);

		if (booking != null) {
			return booking;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleId=");
		sb.append(scheduleId);

		sb.append("}");

		throw new NoSuchBookingException(sb.toString());
	}

	/**
	 * Returns the first booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking, or <code>null</code> if a matching booking could not be found
	 */
	@Override
	public Booking fetchByscheduleId_First(
		long scheduleId, OrderByComparator<Booking> orderByComparator) {

		List<Booking> list = findByscheduleId(
			scheduleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	@Override
	public Booking findByscheduleId_Last(
			long scheduleId, OrderByComparator<Booking> orderByComparator)
		throws NoSuchBookingException {

		Booking booking = fetchByscheduleId_Last(scheduleId, orderByComparator);

		if (booking != null) {
			return booking;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleId=");
		sb.append(scheduleId);

		sb.append("}");

		throw new NoSuchBookingException(sb.toString());
	}

	/**
	 * Returns the last booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking, or <code>null</code> if a matching booking could not be found
	 */
	@Override
	public Booking fetchByscheduleId_Last(
		long scheduleId, OrderByComparator<Booking> orderByComparator) {

		int count = countByscheduleId(scheduleId);

		if (count == 0) {
			return null;
		}

		List<Booking> list = findByscheduleId(
			scheduleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bookings before and after the current booking in the ordered set where scheduleId = &#63;.
	 *
	 * @param bookingId the primary key of the current booking
	 * @param scheduleId the schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking[] findByscheduleId_PrevAndNext(
			long bookingId, long scheduleId,
			OrderByComparator<Booking> orderByComparator)
		throws NoSuchBookingException {

		Booking booking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			Booking[] array = new BookingImpl[3];

			array[0] = getByscheduleId_PrevAndNext(
				session, booking, scheduleId, orderByComparator, true);

			array[1] = booking;

			array[2] = getByscheduleId_PrevAndNext(
				session, booking, scheduleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Booking getByscheduleId_PrevAndNext(
		Session session, Booking booking, long scheduleId,
		OrderByComparator<Booking> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKING_WHERE);

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
			sb.append(BookingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(scheduleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(booking)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Booking> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bookings where scheduleId = &#63; from the database.
	 *
	 * @param scheduleId the schedule ID
	 */
	@Override
	public void removeByscheduleId(long scheduleId) {
		for (Booking booking :
				findByscheduleId(
					scheduleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(booking);
		}
	}

	/**
	 * Returns the number of bookings where scheduleId = &#63;.
	 *
	 * @param scheduleId the schedule ID
	 * @return the number of matching bookings
	 */
	@Override
	public int countByscheduleId(long scheduleId) {
		FinderPath finderPath = _finderPathCountByscheduleId;

		Object[] finderArgs = new Object[] {scheduleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKING_WHERE);

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
		"booking.scheduleId = ?";

	private FinderPath _finderPathWithPaginationFindBypassengerId;
	private FinderPath _finderPathWithoutPaginationFindBypassengerId;
	private FinderPath _finderPathCountBypassengerId;

	/**
	 * Returns all the bookings where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @return the matching bookings
	 */
	@Override
	public List<Booking> findBypassengerId(long passengerId) {
		return findBypassengerId(
			passengerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bookings where passengerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param passengerId the passenger ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of matching bookings
	 */
	@Override
	public List<Booking> findBypassengerId(
		long passengerId, int start, int end) {

		return findBypassengerId(passengerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bookings where passengerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param passengerId the passenger ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookings
	 */
	@Override
	public List<Booking> findBypassengerId(
		long passengerId, int start, int end,
		OrderByComparator<Booking> orderByComparator) {

		return findBypassengerId(
			passengerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bookings where passengerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param passengerId the passenger ID
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookings
	 */
	@Override
	public List<Booking> findBypassengerId(
		long passengerId, int start, int end,
		OrderByComparator<Booking> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypassengerId;
				finderArgs = new Object[] {passengerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypassengerId;
			finderArgs = new Object[] {
				passengerId, start, end, orderByComparator
			};
		}

		List<Booking> list = null;

		if (useFinderCache) {
			list = (List<Booking>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Booking booking : list) {
					if (passengerId != booking.getPassengerId()) {
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

			sb.append(_SQL_SELECT_BOOKING_WHERE);

			sb.append(_FINDER_COLUMN_PASSENGERID_PASSENGERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookingModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(passengerId);

				list = (List<Booking>)QueryUtil.list(
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
	 * Returns the first booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	@Override
	public Booking findBypassengerId_First(
			long passengerId, OrderByComparator<Booking> orderByComparator)
		throws NoSuchBookingException {

		Booking booking = fetchBypassengerId_First(
			passengerId, orderByComparator);

		if (booking != null) {
			return booking;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("passengerId=");
		sb.append(passengerId);

		sb.append("}");

		throw new NoSuchBookingException(sb.toString());
	}

	/**
	 * Returns the first booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking, or <code>null</code> if a matching booking could not be found
	 */
	@Override
	public Booking fetchBypassengerId_First(
		long passengerId, OrderByComparator<Booking> orderByComparator) {

		List<Booking> list = findBypassengerId(
			passengerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking
	 * @throws NoSuchBookingException if a matching booking could not be found
	 */
	@Override
	public Booking findBypassengerId_Last(
			long passengerId, OrderByComparator<Booking> orderByComparator)
		throws NoSuchBookingException {

		Booking booking = fetchBypassengerId_Last(
			passengerId, orderByComparator);

		if (booking != null) {
			return booking;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("passengerId=");
		sb.append(passengerId);

		sb.append("}");

		throw new NoSuchBookingException(sb.toString());
	}

	/**
	 * Returns the last booking in the ordered set where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking, or <code>null</code> if a matching booking could not be found
	 */
	@Override
	public Booking fetchBypassengerId_Last(
		long passengerId, OrderByComparator<Booking> orderByComparator) {

		int count = countBypassengerId(passengerId);

		if (count == 0) {
			return null;
		}

		List<Booking> list = findBypassengerId(
			passengerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bookings before and after the current booking in the ordered set where passengerId = &#63;.
	 *
	 * @param bookingId the primary key of the current booking
	 * @param passengerId the passenger ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking[] findBypassengerId_PrevAndNext(
			long bookingId, long passengerId,
			OrderByComparator<Booking> orderByComparator)
		throws NoSuchBookingException {

		Booking booking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			Booking[] array = new BookingImpl[3];

			array[0] = getBypassengerId_PrevAndNext(
				session, booking, passengerId, orderByComparator, true);

			array[1] = booking;

			array[2] = getBypassengerId_PrevAndNext(
				session, booking, passengerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Booking getBypassengerId_PrevAndNext(
		Session session, Booking booking, long passengerId,
		OrderByComparator<Booking> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKING_WHERE);

		sb.append(_FINDER_COLUMN_PASSENGERID_PASSENGERID_2);

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
			sb.append(BookingModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(passengerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(booking)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Booking> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bookings where passengerId = &#63; from the database.
	 *
	 * @param passengerId the passenger ID
	 */
	@Override
	public void removeBypassengerId(long passengerId) {
		for (Booking booking :
				findBypassengerId(
					passengerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(booking);
		}
	}

	/**
	 * Returns the number of bookings where passengerId = &#63;.
	 *
	 * @param passengerId the passenger ID
	 * @return the number of matching bookings
	 */
	@Override
	public int countBypassengerId(long passengerId) {
		FinderPath finderPath = _finderPathCountBypassengerId;

		Object[] finderArgs = new Object[] {passengerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKING_WHERE);

			sb.append(_FINDER_COLUMN_PASSENGERID_PASSENGERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(passengerId);

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

	private static final String _FINDER_COLUMN_PASSENGERID_PASSENGERID_2 =
		"booking.passengerId = ?";

	public BookingPersistenceImpl() {
		setModelClass(Booking.class);

		setModelImplClass(BookingImpl.class);
		setModelPKClass(long.class);

		setTable(BookingTable.INSTANCE);
	}

	/**
	 * Caches the booking in the entity cache if it is enabled.
	 *
	 * @param booking the booking
	 */
	@Override
	public void cacheResult(Booking booking) {
		entityCache.putResult(
			BookingImpl.class, booking.getPrimaryKey(), booking);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bookings in the entity cache if it is enabled.
	 *
	 * @param bookings the bookings
	 */
	@Override
	public void cacheResult(List<Booking> bookings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bookings.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Booking booking : bookings) {
			if (entityCache.getResult(
					BookingImpl.class, booking.getPrimaryKey()) == null) {

				cacheResult(booking);
			}
		}
	}

	/**
	 * Clears the cache for all bookings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookingImpl.class);

		finderCache.clearCache(BookingImpl.class);
	}

	/**
	 * Clears the cache for the booking.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Booking booking) {
		entityCache.removeResult(BookingImpl.class, booking);
	}

	@Override
	public void clearCache(List<Booking> bookings) {
		for (Booking booking : bookings) {
			entityCache.removeResult(BookingImpl.class, booking);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BookingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new booking with the primary key. Does not add the booking to the database.
	 *
	 * @param bookingId the primary key for the new booking
	 * @return the new booking
	 */
	@Override
	public Booking create(long bookingId) {
		Booking booking = new BookingImpl();

		booking.setNew(true);
		booking.setPrimaryKey(bookingId);

		return booking;
	}

	/**
	 * Removes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking that was removed
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking remove(long bookingId) throws NoSuchBookingException {
		return remove((Serializable)bookingId);
	}

	/**
	 * Removes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking
	 * @return the booking that was removed
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking remove(Serializable primaryKey)
		throws NoSuchBookingException {

		Session session = null;

		try {
			session = openSession();

			Booking booking = (Booking)session.get(
				BookingImpl.class, primaryKey);

			if (booking == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(booking);
		}
		catch (NoSuchBookingException noSuchEntityException) {
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
	protected Booking removeImpl(Booking booking) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(booking)) {
				booking = (Booking)session.get(
					BookingImpl.class, booking.getPrimaryKeyObj());
			}

			if (booking != null) {
				session.delete(booking);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (booking != null) {
			clearCache(booking);
		}

		return booking;
	}

	@Override
	public Booking updateImpl(Booking booking) {
		boolean isNew = booking.isNew();

		if (!(booking instanceof BookingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(booking.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(booking);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in booking proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Booking implementation " +
					booking.getClass());
		}

		BookingModelImpl bookingModelImpl = (BookingModelImpl)booking;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(booking);
			}
			else {
				booking = (Booking)session.merge(booking);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BookingImpl.class, bookingModelImpl, false, true);

		if (isNew) {
			booking.setNew(false);
		}

		booking.resetOriginalValues();

		return booking;
	}

	/**
	 * Returns the booking with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking
	 * @return the booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookingException {

		Booking booking = fetchByPrimaryKey(primaryKey);

		if (booking == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return booking;
	}

	/**
	 * Returns the booking with the primary key or throws a <code>NoSuchBookingException</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking findByPrimaryKey(long bookingId)
		throws NoSuchBookingException {

		return findByPrimaryKey((Serializable)bookingId);
	}

	/**
	 * Returns the booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking, or <code>null</code> if a booking with the primary key could not be found
	 */
	@Override
	public Booking fetchByPrimaryKey(long bookingId) {
		return fetchByPrimaryKey((Serializable)bookingId);
	}

	/**
	 * Returns all the bookings.
	 *
	 * @return the bookings
	 */
	@Override
	public List<Booking> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of bookings
	 */
	@Override
	public List<Booking> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bookings
	 */
	@Override
	public List<Booking> findAll(
		int start, int end, OrderByComparator<Booking> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bookings
	 */
	@Override
	public List<Booking> findAll(
		int start, int end, OrderByComparator<Booking> orderByComparator,
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

		List<Booking> list = null;

		if (useFinderCache) {
			list = (List<Booking>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOKING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKING;

				sql = sql.concat(BookingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Booking>)QueryUtil.list(
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
	 * Removes all the bookings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Booking booking : findAll()) {
			remove(booking);
		}
	}

	/**
	 * Returns the number of bookings.
	 *
	 * @return the number of bookings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOKING);

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
		return "bookingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOKING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the booking persistence.
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

		_finderPathWithPaginationFindBypassengerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypassengerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"passengerId"}, true);

		_finderPathWithoutPaginationFindBypassengerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypassengerId",
			new String[] {Long.class.getName()}, new String[] {"passengerId"},
			true);

		_finderPathCountBypassengerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypassengerId",
			new String[] {Long.class.getName()}, new String[] {"passengerId"},
			false);

		_setBookingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBookingUtilPersistence(null);

		entityCache.removeCache(BookingImpl.class.getName());
	}

	private void _setBookingUtilPersistence(
		BookingPersistence bookingPersistence) {

		try {
			Field field = BookingUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, bookingPersistence);
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

	private static final String _SQL_SELECT_BOOKING =
		"SELECT booking FROM Booking booking";

	private static final String _SQL_SELECT_BOOKING_WHERE =
		"SELECT booking FROM Booking booking WHERE ";

	private static final String _SQL_COUNT_BOOKING =
		"SELECT COUNT(booking) FROM Booking booking";

	private static final String _SQL_COUNT_BOOKING_WHERE =
		"SELECT COUNT(booking) FROM Booking booking WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "booking.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Booking exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Booking exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BookingPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}