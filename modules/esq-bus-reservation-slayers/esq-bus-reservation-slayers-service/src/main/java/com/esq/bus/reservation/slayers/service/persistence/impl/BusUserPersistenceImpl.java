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

import com.esq.bus.reservation.slayers.exception.NoSuchBusUserException;
import com.esq.bus.reservation.slayers.model.BusUser;
import com.esq.bus.reservation.slayers.model.BusUserTable;
import com.esq.bus.reservation.slayers.model.impl.BusUserImpl;
import com.esq.bus.reservation.slayers.model.impl.BusUserModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.BusUserPersistence;
import com.esq.bus.reservation.slayers.service.persistence.BusUserUtil;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the bus user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BusUserPersistence.class)
public class BusUserPersistenceImpl
	extends BasePersistenceImpl<BusUser> implements BusUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BusUserUtil</code> to access the bus user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BusUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByemailAddress;
	private FinderPath _finderPathWithoutPaginationFindByemailAddress;
	private FinderPath _finderPathCountByemailAddress;

	/**
	 * Returns all the bus users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching bus users
	 */
	@Override
	public List<BusUser> findByemailAddress(String emailAddress) {
		return findByemailAddress(
			emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of matching bus users
	 */
	@Override
	public List<BusUser> findByemailAddress(
		String emailAddress, int start, int end) {

		return findByemailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus users
	 */
	@Override
	public List<BusUser> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<BusUser> orderByComparator) {

		return findByemailAddress(
			emailAddress, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bus users where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bus users
	 */
	@Override
	public List<BusUser> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<BusUser> orderByComparator, boolean useFinderCache) {

		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemailAddress;
				finderArgs = new Object[] {emailAddress};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemailAddress;
			finderArgs = new Object[] {
				emailAddress, start, end, orderByComparator
			};
		}

		List<BusUser> list = null;

		if (useFinderCache) {
			list = (List<BusUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BusUser busUser : list) {
					if (!emailAddress.equals(busUser.getEmailAddress())) {
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

			sb.append(_SQL_SELECT_BUSUSER_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BusUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				list = (List<BusUser>)QueryUtil.list(
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
	 * Returns the first bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	@Override
	public BusUser findByemailAddress_First(
			String emailAddress, OrderByComparator<BusUser> orderByComparator)
		throws NoSuchBusUserException {

		BusUser busUser = fetchByemailAddress_First(
			emailAddress, orderByComparator);

		if (busUser != null) {
			return busUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchBusUserException(sb.toString());
	}

	/**
	 * Returns the first bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	@Override
	public BusUser fetchByemailAddress_First(
		String emailAddress, OrderByComparator<BusUser> orderByComparator) {

		List<BusUser> list = findByemailAddress(
			emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	@Override
	public BusUser findByemailAddress_Last(
			String emailAddress, OrderByComparator<BusUser> orderByComparator)
		throws NoSuchBusUserException {

		BusUser busUser = fetchByemailAddress_Last(
			emailAddress, orderByComparator);

		if (busUser != null) {
			return busUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchBusUserException(sb.toString());
	}

	/**
	 * Returns the last bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	@Override
	public BusUser fetchByemailAddress_Last(
		String emailAddress, OrderByComparator<BusUser> orderByComparator) {

		int count = countByemailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<BusUser> list = findByemailAddress(
			emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus users before and after the current bus user in the ordered set where emailAddress = &#63;.
	 *
	 * @param userId the primary key of the current bus user
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser[] findByemailAddress_PrevAndNext(
			long userId, String emailAddress,
			OrderByComparator<BusUser> orderByComparator)
		throws NoSuchBusUserException {

		emailAddress = Objects.toString(emailAddress, "");

		BusUser busUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			BusUser[] array = new BusUserImpl[3];

			array[0] = getByemailAddress_PrevAndNext(
				session, busUser, emailAddress, orderByComparator, true);

			array[1] = busUser;

			array[2] = getByemailAddress_PrevAndNext(
				session, busUser, emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusUser getByemailAddress_PrevAndNext(
		Session session, BusUser busUser, String emailAddress,
		OrderByComparator<BusUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BUSUSER_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			sb.append(BusUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmailAddress) {
			queryPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(busUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BusUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus users where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	@Override
	public void removeByemailAddress(String emailAddress) {
		for (BusUser busUser :
				findByemailAddress(
					emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(busUser);
		}
	}

	/**
	 * Returns the number of bus users where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching bus users
	 */
	@Override
	public int countByemailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByemailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUSUSER_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 =
		"busUser.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(busUser.emailAddress IS NULL OR busUser.emailAddress = '')";

	private FinderPath _finderPathWithPaginationFindByusername;
	private FinderPath _finderPathWithoutPaginationFindByusername;
	private FinderPath _finderPathCountByusername;

	/**
	 * Returns all the bus users where username = &#63;.
	 *
	 * @param username the username
	 * @return the matching bus users
	 */
	@Override
	public List<BusUser> findByusername(String username) {
		return findByusername(
			username, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus users where username = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param username the username
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of matching bus users
	 */
	@Override
	public List<BusUser> findByusername(String username, int start, int end) {
		return findByusername(username, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus users where username = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param username the username
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bus users
	 */
	@Override
	public List<BusUser> findByusername(
		String username, int start, int end,
		OrderByComparator<BusUser> orderByComparator) {

		return findByusername(username, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bus users where username = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param username the username
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bus users
	 */
	@Override
	public List<BusUser> findByusername(
		String username, int start, int end,
		OrderByComparator<BusUser> orderByComparator, boolean useFinderCache) {

		username = Objects.toString(username, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByusername;
				finderArgs = new Object[] {username};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByusername;
			finderArgs = new Object[] {username, start, end, orderByComparator};
		}

		List<BusUser> list = null;

		if (useFinderCache) {
			list = (List<BusUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BusUser busUser : list) {
					if (!username.equals(busUser.getUsername())) {
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

			sb.append(_SQL_SELECT_BUSUSER_WHERE);

			boolean bindUsername = false;

			if (username.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUsername = true;

				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BusUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUsername) {
					queryPos.add(username);
				}

				list = (List<BusUser>)QueryUtil.list(
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
	 * Returns the first bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	@Override
	public BusUser findByusername_First(
			String username, OrderByComparator<BusUser> orderByComparator)
		throws NoSuchBusUserException {

		BusUser busUser = fetchByusername_First(username, orderByComparator);

		if (busUser != null) {
			return busUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("username=");
		sb.append(username);

		sb.append("}");

		throw new NoSuchBusUserException(sb.toString());
	}

	/**
	 * Returns the first bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	@Override
	public BusUser fetchByusername_First(
		String username, OrderByComparator<BusUser> orderByComparator) {

		List<BusUser> list = findByusername(username, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user
	 * @throws NoSuchBusUserException if a matching bus user could not be found
	 */
	@Override
	public BusUser findByusername_Last(
			String username, OrderByComparator<BusUser> orderByComparator)
		throws NoSuchBusUserException {

		BusUser busUser = fetchByusername_Last(username, orderByComparator);

		if (busUser != null) {
			return busUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("username=");
		sb.append(username);

		sb.append("}");

		throw new NoSuchBusUserException(sb.toString());
	}

	/**
	 * Returns the last bus user in the ordered set where username = &#63;.
	 *
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus user, or <code>null</code> if a matching bus user could not be found
	 */
	@Override
	public BusUser fetchByusername_Last(
		String username, OrderByComparator<BusUser> orderByComparator) {

		int count = countByusername(username);

		if (count == 0) {
			return null;
		}

		List<BusUser> list = findByusername(
			username, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bus users before and after the current bus user in the ordered set where username = &#63;.
	 *
	 * @param userId the primary key of the current bus user
	 * @param username the username
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser[] findByusername_PrevAndNext(
			long userId, String username,
			OrderByComparator<BusUser> orderByComparator)
		throws NoSuchBusUserException {

		username = Objects.toString(username, "");

		BusUser busUser = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			BusUser[] array = new BusUserImpl[3];

			array[0] = getByusername_PrevAndNext(
				session, busUser, username, orderByComparator, true);

			array[1] = busUser;

			array[2] = getByusername_PrevAndNext(
				session, busUser, username, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusUser getByusername_PrevAndNext(
		Session session, BusUser busUser, String username,
		OrderByComparator<BusUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BUSUSER_WHERE);

		boolean bindUsername = false;

		if (username.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUsername = true;

			sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
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
			sb.append(BusUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUsername) {
			queryPos.add(username);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(busUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BusUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bus users where username = &#63; from the database.
	 *
	 * @param username the username
	 */
	@Override
	public void removeByusername(String username) {
		for (BusUser busUser :
				findByusername(
					username, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(busUser);
		}
	}

	/**
	 * Returns the number of bus users where username = &#63;.
	 *
	 * @param username the username
	 * @return the number of matching bus users
	 */
	@Override
	public int countByusername(String username) {
		username = Objects.toString(username, "");

		FinderPath finderPath = _finderPathCountByusername;

		Object[] finderArgs = new Object[] {username};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUSUSER_WHERE);

			boolean bindUsername = false;

			if (username.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUsername = true;

				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUsername) {
					queryPos.add(username);
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

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 =
		"busUser.username = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(busUser.username IS NULL OR busUser.username = '')";

	public BusUserPersistenceImpl() {
		setModelClass(BusUser.class);

		setModelImplClass(BusUserImpl.class);
		setModelPKClass(long.class);

		setTable(BusUserTable.INSTANCE);
	}

	/**
	 * Caches the bus user in the entity cache if it is enabled.
	 *
	 * @param busUser the bus user
	 */
	@Override
	public void cacheResult(BusUser busUser) {
		entityCache.putResult(
			BusUserImpl.class, busUser.getPrimaryKey(), busUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bus users in the entity cache if it is enabled.
	 *
	 * @param busUsers the bus users
	 */
	@Override
	public void cacheResult(List<BusUser> busUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (busUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BusUser busUser : busUsers) {
			if (entityCache.getResult(
					BusUserImpl.class, busUser.getPrimaryKey()) == null) {

				cacheResult(busUser);
			}
		}
	}

	/**
	 * Clears the cache for all bus users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BusUserImpl.class);

		finderCache.clearCache(BusUserImpl.class);
	}

	/**
	 * Clears the cache for the bus user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusUser busUser) {
		entityCache.removeResult(BusUserImpl.class, busUser);
	}

	@Override
	public void clearCache(List<BusUser> busUsers) {
		for (BusUser busUser : busUsers) {
			entityCache.removeResult(BusUserImpl.class, busUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BusUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BusUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bus user with the primary key. Does not add the bus user to the database.
	 *
	 * @param userId the primary key for the new bus user
	 * @return the new bus user
	 */
	@Override
	public BusUser create(long userId) {
		BusUser busUser = new BusUserImpl();

		busUser.setNew(true);
		busUser.setPrimaryKey(userId);

		return busUser;
	}

	/**
	 * Removes the bus user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user that was removed
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser remove(long userId) throws NoSuchBusUserException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the bus user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus user
	 * @return the bus user that was removed
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser remove(Serializable primaryKey)
		throws NoSuchBusUserException {

		Session session = null;

		try {
			session = openSession();

			BusUser busUser = (BusUser)session.get(
				BusUserImpl.class, primaryKey);

			if (busUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(busUser);
		}
		catch (NoSuchBusUserException noSuchEntityException) {
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
	protected BusUser removeImpl(BusUser busUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(busUser)) {
				busUser = (BusUser)session.get(
					BusUserImpl.class, busUser.getPrimaryKeyObj());
			}

			if (busUser != null) {
				session.delete(busUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (busUser != null) {
			clearCache(busUser);
		}

		return busUser;
	}

	@Override
	public BusUser updateImpl(BusUser busUser) {
		boolean isNew = busUser.isNew();

		if (!(busUser instanceof BusUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(busUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(busUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in busUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BusUser implementation " +
					busUser.getClass());
		}

		BusUserModelImpl busUserModelImpl = (BusUserModelImpl)busUser;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(busUser);
			}
			else {
				busUser = (BusUser)session.merge(busUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BusUserImpl.class, busUserModelImpl, false, true);

		if (isNew) {
			busUser.setNew(false);
		}

		busUser.resetOriginalValues();

		return busUser;
	}

	/**
	 * Returns the bus user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus user
	 * @return the bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusUserException {

		BusUser busUser = fetchByPrimaryKey(primaryKey);

		if (busUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return busUser;
	}

	/**
	 * Returns the bus user with the primary key or throws a <code>NoSuchBusUserException</code> if it could not be found.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user
	 * @throws NoSuchBusUserException if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser findByPrimaryKey(long userId) throws NoSuchBusUserException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the bus user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the bus user
	 * @return the bus user, or <code>null</code> if a bus user with the primary key could not be found
	 */
	@Override
	public BusUser fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the bus users.
	 *
	 * @return the bus users
	 */
	@Override
	public List<BusUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @return the range of bus users
	 */
	@Override
	public List<BusUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bus users
	 */
	@Override
	public List<BusUser> findAll(
		int start, int end, OrderByComparator<BusUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bus users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bus users
	 * @param end the upper bound of the range of bus users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bus users
	 */
	@Override
	public List<BusUser> findAll(
		int start, int end, OrderByComparator<BusUser> orderByComparator,
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

		List<BusUser> list = null;

		if (useFinderCache) {
			list = (List<BusUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BUSUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BUSUSER;

				sql = sql.concat(BusUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BusUser>)QueryUtil.list(
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
	 * Removes all the bus users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BusUser busUser : findAll()) {
			remove(busUser);
		}
	}

	/**
	 * Returns the number of bus users.
	 *
	 * @return the number of bus users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BUSUSER);

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
		return "userId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BUSUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BusUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bus user persistence.
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

		_finderPathWithPaginationFindByemailAddress = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemailAddress",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"emailAddress"}, true);

		_finderPathWithoutPaginationFindByemailAddress = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemailAddress",
			new String[] {String.class.getName()},
			new String[] {"emailAddress"}, true);

		_finderPathCountByemailAddress = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAddress",
			new String[] {String.class.getName()},
			new String[] {"emailAddress"}, false);

		_finderPathWithPaginationFindByusername = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByusername",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"username"}, true);

		_finderPathWithoutPaginationFindByusername = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByusername",
			new String[] {String.class.getName()}, new String[] {"username"},
			true);

		_finderPathCountByusername = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByusername",
			new String[] {String.class.getName()}, new String[] {"username"},
			false);

		_setBusUserUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBusUserUtilPersistence(null);

		entityCache.removeCache(BusUserImpl.class.getName());
	}

	private void _setBusUserUtilPersistence(
		BusUserPersistence busUserPersistence) {

		try {
			Field field = BusUserUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, busUserPersistence);
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

	private static final String _SQL_SELECT_BUSUSER =
		"SELECT busUser FROM BusUser busUser";

	private static final String _SQL_SELECT_BUSUSER_WHERE =
		"SELECT busUser FROM BusUser busUser WHERE ";

	private static final String _SQL_COUNT_BUSUSER =
		"SELECT COUNT(busUser) FROM BusUser busUser";

	private static final String _SQL_COUNT_BUSUSER_WHERE =
		"SELECT COUNT(busUser) FROM BusUser busUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "busUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BusUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BusUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BusUserPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}