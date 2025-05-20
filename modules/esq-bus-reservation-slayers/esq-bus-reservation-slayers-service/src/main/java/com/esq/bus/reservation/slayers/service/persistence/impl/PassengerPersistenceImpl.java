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

import com.esq.bus.reservation.slayers.exception.NoSuchPassengerException;
import com.esq.bus.reservation.slayers.model.Passenger;
import com.esq.bus.reservation.slayers.model.PassengerTable;
import com.esq.bus.reservation.slayers.model.impl.PassengerImpl;
import com.esq.bus.reservation.slayers.model.impl.PassengerModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.PassengerPersistence;
import com.esq.bus.reservation.slayers.service.persistence.PassengerUtil;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
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
 * The persistence implementation for the passenger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PassengerPersistence.class)
public class PassengerPersistenceImpl
	extends BasePersistenceImpl<Passenger> implements PassengerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PassengerUtil</code> to access the passenger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PassengerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypassengerEmail;
	private FinderPath _finderPathWithoutPaginationFindBypassengerEmail;
	private FinderPath _finderPathCountBypassengerEmail;

	/**
	 * Returns all the passengers where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @return the matching passengers
	 */
	@Override
	public List<Passenger> findBypassengerEmail(String passengerEmail) {
		return findBypassengerEmail(
			passengerEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the passengers where passengerEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param passengerEmail the passenger email
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of matching passengers
	 */
	@Override
	public List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end) {

		return findBypassengerEmail(passengerEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the passengers where passengerEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param passengerEmail the passenger email
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching passengers
	 */
	@Override
	public List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end,
		OrderByComparator<Passenger> orderByComparator) {

		return findBypassengerEmail(
			passengerEmail, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the passengers where passengerEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param passengerEmail the passenger email
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching passengers
	 */
	@Override
	public List<Passenger> findBypassengerEmail(
		String passengerEmail, int start, int end,
		OrderByComparator<Passenger> orderByComparator,
		boolean useFinderCache) {

		passengerEmail = Objects.toString(passengerEmail, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypassengerEmail;
				finderArgs = new Object[] {passengerEmail};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypassengerEmail;
			finderArgs = new Object[] {
				passengerEmail, start, end, orderByComparator
			};
		}

		List<Passenger> list = null;

		if (useFinderCache) {
			list = (List<Passenger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Passenger passenger : list) {
					if (!passengerEmail.equals(passenger.getPassengerEmail())) {
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

			sb.append(_SQL_SELECT_PASSENGER_WHERE);

			boolean bindPassengerEmail = false;

			if (passengerEmail.isEmpty()) {
				sb.append(_FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_3);
			}
			else {
				bindPassengerEmail = true;

				sb.append(_FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PassengerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPassengerEmail) {
					queryPos.add(passengerEmail);
				}

				list = (List<Passenger>)QueryUtil.list(
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
	 * Returns the first passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	@Override
	public Passenger findBypassengerEmail_First(
			String passengerEmail,
			OrderByComparator<Passenger> orderByComparator)
		throws NoSuchPassengerException {

		Passenger passenger = fetchBypassengerEmail_First(
			passengerEmail, orderByComparator);

		if (passenger != null) {
			return passenger;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("passengerEmail=");
		sb.append(passengerEmail);

		sb.append("}");

		throw new NoSuchPassengerException(sb.toString());
	}

	/**
	 * Returns the first passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	@Override
	public Passenger fetchBypassengerEmail_First(
		String passengerEmail, OrderByComparator<Passenger> orderByComparator) {

		List<Passenger> list = findBypassengerEmail(
			passengerEmail, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	@Override
	public Passenger findBypassengerEmail_Last(
			String passengerEmail,
			OrderByComparator<Passenger> orderByComparator)
		throws NoSuchPassengerException {

		Passenger passenger = fetchBypassengerEmail_Last(
			passengerEmail, orderByComparator);

		if (passenger != null) {
			return passenger;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("passengerEmail=");
		sb.append(passengerEmail);

		sb.append("}");

		throw new NoSuchPassengerException(sb.toString());
	}

	/**
	 * Returns the last passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	@Override
	public Passenger fetchBypassengerEmail_Last(
		String passengerEmail, OrderByComparator<Passenger> orderByComparator) {

		int count = countBypassengerEmail(passengerEmail);

		if (count == 0) {
			return null;
		}

		List<Passenger> list = findBypassengerEmail(
			passengerEmail, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the passengers before and after the current passenger in the ordered set where passengerEmail = &#63;.
	 *
	 * @param passengerId the primary key of the current passenger
	 * @param passengerEmail the passenger email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger[] findBypassengerEmail_PrevAndNext(
			long passengerId, String passengerEmail,
			OrderByComparator<Passenger> orderByComparator)
		throws NoSuchPassengerException {

		passengerEmail = Objects.toString(passengerEmail, "");

		Passenger passenger = findByPrimaryKey(passengerId);

		Session session = null;

		try {
			session = openSession();

			Passenger[] array = new PassengerImpl[3];

			array[0] = getBypassengerEmail_PrevAndNext(
				session, passenger, passengerEmail, orderByComparator, true);

			array[1] = passenger;

			array[2] = getBypassengerEmail_PrevAndNext(
				session, passenger, passengerEmail, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Passenger getBypassengerEmail_PrevAndNext(
		Session session, Passenger passenger, String passengerEmail,
		OrderByComparator<Passenger> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PASSENGER_WHERE);

		boolean bindPassengerEmail = false;

		if (passengerEmail.isEmpty()) {
			sb.append(_FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_3);
		}
		else {
			bindPassengerEmail = true;

			sb.append(_FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_2);
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
			sb.append(PassengerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPassengerEmail) {
			queryPos.add(passengerEmail);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(passenger)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Passenger> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the passengers where passengerEmail = &#63; from the database.
	 *
	 * @param passengerEmail the passenger email
	 */
	@Override
	public void removeBypassengerEmail(String passengerEmail) {
		for (Passenger passenger :
				findBypassengerEmail(
					passengerEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(passenger);
		}
	}

	/**
	 * Returns the number of passengers where passengerEmail = &#63;.
	 *
	 * @param passengerEmail the passenger email
	 * @return the number of matching passengers
	 */
	@Override
	public int countBypassengerEmail(String passengerEmail) {
		passengerEmail = Objects.toString(passengerEmail, "");

		FinderPath finderPath = _finderPathCountBypassengerEmail;

		Object[] finderArgs = new Object[] {passengerEmail};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PASSENGER_WHERE);

			boolean bindPassengerEmail = false;

			if (passengerEmail.isEmpty()) {
				sb.append(_FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_3);
			}
			else {
				bindPassengerEmail = true;

				sb.append(_FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPassengerEmail) {
					queryPos.add(passengerEmail);
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

	private static final String _FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_2 =
		"passenger.passengerEmail = ?";

	private static final String _FINDER_COLUMN_PASSENGEREMAIL_PASSENGEREMAIL_3 =
		"(passenger.passengerEmail IS NULL OR passenger.passengerEmail = '')";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the passengers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching passengers
	 */
	@Override
	public List<Passenger> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the passengers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of matching passengers
	 */
	@Override
	public List<Passenger> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the passengers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching passengers
	 */
	@Override
	public List<Passenger> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Passenger> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the passengers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching passengers
	 */
	@Override
	public List<Passenger> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Passenger> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Passenger> list = null;

		if (useFinderCache) {
			list = (List<Passenger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Passenger passenger : list) {
					if (userId != passenger.getUserId()) {
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

			sb.append(_SQL_SELECT_PASSENGER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PassengerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Passenger>)QueryUtil.list(
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
	 * Returns the first passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	@Override
	public Passenger findByuserId_First(
			long userId, OrderByComparator<Passenger> orderByComparator)
		throws NoSuchPassengerException {

		Passenger passenger = fetchByuserId_First(userId, orderByComparator);

		if (passenger != null) {
			return passenger;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchPassengerException(sb.toString());
	}

	/**
	 * Returns the first passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	@Override
	public Passenger fetchByuserId_First(
		long userId, OrderByComparator<Passenger> orderByComparator) {

		List<Passenger> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger
	 * @throws NoSuchPassengerException if a matching passenger could not be found
	 */
	@Override
	public Passenger findByuserId_Last(
			long userId, OrderByComparator<Passenger> orderByComparator)
		throws NoSuchPassengerException {

		Passenger passenger = fetchByuserId_Last(userId, orderByComparator);

		if (passenger != null) {
			return passenger;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchPassengerException(sb.toString());
	}

	/**
	 * Returns the last passenger in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching passenger, or <code>null</code> if a matching passenger could not be found
	 */
	@Override
	public Passenger fetchByuserId_Last(
		long userId, OrderByComparator<Passenger> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Passenger> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the passengers before and after the current passenger in the ordered set where userId = &#63;.
	 *
	 * @param passengerId the primary key of the current passenger
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger[] findByuserId_PrevAndNext(
			long passengerId, long userId,
			OrderByComparator<Passenger> orderByComparator)
		throws NoSuchPassengerException {

		Passenger passenger = findByPrimaryKey(passengerId);

		Session session = null;

		try {
			session = openSession();

			Passenger[] array = new PassengerImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, passenger, userId, orderByComparator, true);

			array[1] = passenger;

			array[2] = getByuserId_PrevAndNext(
				session, passenger, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Passenger getByuserId_PrevAndNext(
		Session session, Passenger passenger, long userId,
		OrderByComparator<Passenger> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PASSENGER_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(PassengerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(passenger)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Passenger> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the passengers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Passenger passenger :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(passenger);
		}
	}

	/**
	 * Returns the number of passengers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching passengers
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PASSENGER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"passenger.userId = ?";

	public PassengerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Passenger.class);

		setModelImplClass(PassengerImpl.class);
		setModelPKClass(long.class);

		setTable(PassengerTable.INSTANCE);
	}

	/**
	 * Caches the passenger in the entity cache if it is enabled.
	 *
	 * @param passenger the passenger
	 */
	@Override
	public void cacheResult(Passenger passenger) {
		entityCache.putResult(
			PassengerImpl.class, passenger.getPrimaryKey(), passenger);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the passengers in the entity cache if it is enabled.
	 *
	 * @param passengers the passengers
	 */
	@Override
	public void cacheResult(List<Passenger> passengers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (passengers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Passenger passenger : passengers) {
			if (entityCache.getResult(
					PassengerImpl.class, passenger.getPrimaryKey()) == null) {

				cacheResult(passenger);
			}
		}
	}

	/**
	 * Clears the cache for all passengers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PassengerImpl.class);

		finderCache.clearCache(PassengerImpl.class);
	}

	/**
	 * Clears the cache for the passenger.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Passenger passenger) {
		entityCache.removeResult(PassengerImpl.class, passenger);
	}

	@Override
	public void clearCache(List<Passenger> passengers) {
		for (Passenger passenger : passengers) {
			entityCache.removeResult(PassengerImpl.class, passenger);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PassengerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PassengerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new passenger with the primary key. Does not add the passenger to the database.
	 *
	 * @param passengerId the primary key for the new passenger
	 * @return the new passenger
	 */
	@Override
	public Passenger create(long passengerId) {
		Passenger passenger = new PassengerImpl();

		passenger.setNew(true);
		passenger.setPrimaryKey(passengerId);

		return passenger;
	}

	/**
	 * Removes the passenger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger that was removed
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger remove(long passengerId) throws NoSuchPassengerException {
		return remove((Serializable)passengerId);
	}

	/**
	 * Removes the passenger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the passenger
	 * @return the passenger that was removed
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger remove(Serializable primaryKey)
		throws NoSuchPassengerException {

		Session session = null;

		try {
			session = openSession();

			Passenger passenger = (Passenger)session.get(
				PassengerImpl.class, primaryKey);

			if (passenger == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPassengerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(passenger);
		}
		catch (NoSuchPassengerException noSuchEntityException) {
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
	protected Passenger removeImpl(Passenger passenger) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(passenger)) {
				passenger = (Passenger)session.get(
					PassengerImpl.class, passenger.getPrimaryKeyObj());
			}

			if (passenger != null) {
				session.delete(passenger);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (passenger != null) {
			clearCache(passenger);
		}

		return passenger;
	}

	@Override
	public Passenger updateImpl(Passenger passenger) {
		boolean isNew = passenger.isNew();

		if (!(passenger instanceof PassengerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(passenger.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(passenger);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in passenger proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Passenger implementation " +
					passenger.getClass());
		}

		PassengerModelImpl passengerModelImpl = (PassengerModelImpl)passenger;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(passenger);
			}
			else {
				passenger = (Passenger)session.merge(passenger);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PassengerImpl.class, passengerModelImpl, false, true);

		if (isNew) {
			passenger.setNew(false);
		}

		passenger.resetOriginalValues();

		return passenger;
	}

	/**
	 * Returns the passenger with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the passenger
	 * @return the passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPassengerException {

		Passenger passenger = fetchByPrimaryKey(primaryKey);

		if (passenger == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPassengerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return passenger;
	}

	/**
	 * Returns the passenger with the primary key or throws a <code>NoSuchPassengerException</code> if it could not be found.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger
	 * @throws NoSuchPassengerException if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger findByPrimaryKey(long passengerId)
		throws NoSuchPassengerException {

		return findByPrimaryKey((Serializable)passengerId);
	}

	/**
	 * Returns the passenger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param passengerId the primary key of the passenger
	 * @return the passenger, or <code>null</code> if a passenger with the primary key could not be found
	 */
	@Override
	public Passenger fetchByPrimaryKey(long passengerId) {
		return fetchByPrimaryKey((Serializable)passengerId);
	}

	/**
	 * Returns all the passengers.
	 *
	 * @return the passengers
	 */
	@Override
	public List<Passenger> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @return the range of passengers
	 */
	@Override
	public List<Passenger> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of passengers
	 */
	@Override
	public List<Passenger> findAll(
		int start, int end, OrderByComparator<Passenger> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the passengers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PassengerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of passengers
	 * @param end the upper bound of the range of passengers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of passengers
	 */
	@Override
	public List<Passenger> findAll(
		int start, int end, OrderByComparator<Passenger> orderByComparator,
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

		List<Passenger> list = null;

		if (useFinderCache) {
			list = (List<Passenger>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PASSENGER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PASSENGER;

				sql = sql.concat(PassengerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Passenger>)QueryUtil.list(
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
	 * Removes all the passengers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Passenger passenger : findAll()) {
			remove(passenger);
		}
	}

	/**
	 * Returns the number of passengers.
	 *
	 * @return the number of passengers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PASSENGER);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "passengerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PASSENGER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PassengerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the passenger persistence.
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

		_finderPathWithPaginationFindBypassengerEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypassengerEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"passengerEmail"}, true);

		_finderPathWithoutPaginationFindBypassengerEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypassengerEmail",
			new String[] {String.class.getName()},
			new String[] {"passengerEmail"}, true);

		_finderPathCountBypassengerEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypassengerEmail",
			new String[] {String.class.getName()},
			new String[] {"passengerEmail"}, false);

		_finderPathWithPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setPassengerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPassengerUtilPersistence(null);

		entityCache.removeCache(PassengerImpl.class.getName());
	}

	private void _setPassengerUtilPersistence(
		PassengerPersistence passengerPersistence) {

		try {
			Field field = PassengerUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, passengerPersistence);
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

	private static final String _SQL_SELECT_PASSENGER =
		"SELECT passenger FROM Passenger passenger";

	private static final String _SQL_SELECT_PASSENGER_WHERE =
		"SELECT passenger FROM Passenger passenger WHERE ";

	private static final String _SQL_COUNT_PASSENGER =
		"SELECT COUNT(passenger) FROM Passenger passenger";

	private static final String _SQL_COUNT_PASSENGER_WHERE =
		"SELECT COUNT(passenger) FROM Passenger passenger WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "passenger.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Passenger exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Passenger exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PassengerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}