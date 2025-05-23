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

import com.esq.bus.reservation.slayers.exception.NoSuchBusException;
import com.esq.bus.reservation.slayers.model.Bus;
import com.esq.bus.reservation.slayers.model.BusTable;
import com.esq.bus.reservation.slayers.model.impl.BusImpl;
import com.esq.bus.reservation.slayers.model.impl.BusModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.BusPersistence;
import com.esq.bus.reservation.slayers.service.persistence.BusUtil;
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
 * The persistence implementation for the bus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BusPersistence.class)
public class BusPersistenceImpl
	extends BasePersistenceImpl<Bus> implements BusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BusUtil</code> to access the bus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BusImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the buses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching buses
	 */
	@Override
	public List<Bus> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the buses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @return the range of matching buses
	 */
	@Override
	public List<Bus> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the buses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching buses
	 */
	@Override
	public List<Bus> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Bus> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the buses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching buses
	 */
	@Override
	public List<Bus> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Bus> orderByComparator, boolean useFinderCache) {

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

		List<Bus> list = null;

		if (useFinderCache) {
			list = (List<Bus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Bus bus : list) {
					if (userId != bus.getUserId()) {
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

			sb.append(_SQL_SELECT_BUS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Bus>)QueryUtil.list(
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
	 * Returns the first bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus
	 * @throws NoSuchBusException if a matching bus could not be found
	 */
	@Override
	public Bus findByuserId_First(
			long userId, OrderByComparator<Bus> orderByComparator)
		throws NoSuchBusException {

		Bus bus = fetchByuserId_First(userId, orderByComparator);

		if (bus != null) {
			return bus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBusException(sb.toString());
	}

	/**
	 * Returns the first bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bus, or <code>null</code> if a matching bus could not be found
	 */
	@Override
	public Bus fetchByuserId_First(
		long userId, OrderByComparator<Bus> orderByComparator) {

		List<Bus> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus
	 * @throws NoSuchBusException if a matching bus could not be found
	 */
	@Override
	public Bus findByuserId_Last(
			long userId, OrderByComparator<Bus> orderByComparator)
		throws NoSuchBusException {

		Bus bus = fetchByuserId_Last(userId, orderByComparator);

		if (bus != null) {
			return bus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBusException(sb.toString());
	}

	/**
	 * Returns the last bus in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bus, or <code>null</code> if a matching bus could not be found
	 */
	@Override
	public Bus fetchByuserId_Last(
		long userId, OrderByComparator<Bus> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Bus> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the buses before and after the current bus in the ordered set where userId = &#63;.
	 *
	 * @param busId the primary key of the current bus
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	@Override
	public Bus[] findByuserId_PrevAndNext(
			long busId, long userId, OrderByComparator<Bus> orderByComparator)
		throws NoSuchBusException {

		Bus bus = findByPrimaryKey(busId);

		Session session = null;

		try {
			session = openSession();

			Bus[] array = new BusImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, bus, userId, orderByComparator, true);

			array[1] = bus;

			array[2] = getByuserId_PrevAndNext(
				session, bus, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bus getByuserId_PrevAndNext(
		Session session, Bus bus, long userId,
		OrderByComparator<Bus> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BUS_WHERE);

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
			sb.append(BusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Bus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the buses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Bus bus :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bus);
		}
	}

	/**
	 * Returns the number of buses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching buses
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUS_WHERE);

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
		"bus.userId = ?";

	public BusPersistenceImpl() {
		setModelClass(Bus.class);

		setModelImplClass(BusImpl.class);
		setModelPKClass(long.class);

		setTable(BusTable.INSTANCE);
	}

	/**
	 * Caches the bus in the entity cache if it is enabled.
	 *
	 * @param bus the bus
	 */
	@Override
	public void cacheResult(Bus bus) {
		entityCache.putResult(BusImpl.class, bus.getPrimaryKey(), bus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the buses in the entity cache if it is enabled.
	 *
	 * @param buses the buses
	 */
	@Override
	public void cacheResult(List<Bus> buses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (buses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Bus bus : buses) {
			if (entityCache.getResult(BusImpl.class, bus.getPrimaryKey()) ==
					null) {

				cacheResult(bus);
			}
		}
	}

	/**
	 * Clears the cache for all buses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BusImpl.class);

		finderCache.clearCache(BusImpl.class);
	}

	/**
	 * Clears the cache for the bus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bus bus) {
		entityCache.removeResult(BusImpl.class, bus);
	}

	@Override
	public void clearCache(List<Bus> buses) {
		for (Bus bus : buses) {
			entityCache.removeResult(BusImpl.class, bus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bus with the primary key. Does not add the bus to the database.
	 *
	 * @param busId the primary key for the new bus
	 * @return the new bus
	 */
	@Override
	public Bus create(long busId) {
		Bus bus = new BusImpl();

		bus.setNew(true);
		bus.setPrimaryKey(busId);

		return bus;
	}

	/**
	 * Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus that was removed
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	@Override
	public Bus remove(long busId) throws NoSuchBusException {
		return remove((Serializable)busId);
	}

	/**
	 * Removes the bus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bus
	 * @return the bus that was removed
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	@Override
	public Bus remove(Serializable primaryKey) throws NoSuchBusException {
		Session session = null;

		try {
			session = openSession();

			Bus bus = (Bus)session.get(BusImpl.class, primaryKey);

			if (bus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bus);
		}
		catch (NoSuchBusException noSuchEntityException) {
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
	protected Bus removeImpl(Bus bus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bus)) {
				bus = (Bus)session.get(BusImpl.class, bus.getPrimaryKeyObj());
			}

			if (bus != null) {
				session.delete(bus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bus != null) {
			clearCache(bus);
		}

		return bus;
	}

	@Override
	public Bus updateImpl(Bus bus) {
		boolean isNew = bus.isNew();

		if (!(bus instanceof BusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Bus implementation " +
					bus.getClass());
		}

		BusModelImpl busModelImpl = (BusModelImpl)bus;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bus);
			}
			else {
				bus = (Bus)session.merge(bus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BusImpl.class, busModelImpl, false, true);

		if (isNew) {
			bus.setNew(false);
		}

		bus.resetOriginalValues();

		return bus;
	}

	/**
	 * Returns the bus with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bus
	 * @return the bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	@Override
	public Bus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusException {

		Bus bus = fetchByPrimaryKey(primaryKey);

		if (bus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bus;
	}

	/**
	 * Returns the bus with the primary key or throws a <code>NoSuchBusException</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus
	 * @throws NoSuchBusException if a bus with the primary key could not be found
	 */
	@Override
	public Bus findByPrimaryKey(long busId) throws NoSuchBusException {
		return findByPrimaryKey((Serializable)busId);
	}

	/**
	 * Returns the bus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param busId the primary key of the bus
	 * @return the bus, or <code>null</code> if a bus with the primary key could not be found
	 */
	@Override
	public Bus fetchByPrimaryKey(long busId) {
		return fetchByPrimaryKey((Serializable)busId);
	}

	/**
	 * Returns all the buses.
	 *
	 * @return the buses
	 */
	@Override
	public List<Bus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @return the range of buses
	 */
	@Override
	public List<Bus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of buses
	 */
	@Override
	public List<Bus> findAll(
		int start, int end, OrderByComparator<Bus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the buses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of buses
	 * @param end the upper bound of the range of buses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of buses
	 */
	@Override
	public List<Bus> findAll(
		int start, int end, OrderByComparator<Bus> orderByComparator,
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

		List<Bus> list = null;

		if (useFinderCache) {
			list = (List<Bus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BUS;

				sql = sql.concat(BusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Bus>)QueryUtil.list(
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
	 * Removes all the buses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Bus bus : findAll()) {
			remove(bus);
		}
	}

	/**
	 * Returns the number of buses.
	 *
	 * @return the number of buses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BUS);

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
		return "busId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bus persistence.
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

		_setBusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBusUtilPersistence(null);

		entityCache.removeCache(BusImpl.class.getName());
	}

	private void _setBusUtilPersistence(BusPersistence busPersistence) {
		try {
			Field field = BusUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, busPersistence);
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

	private static final String _SQL_SELECT_BUS = "SELECT bus FROM Bus bus";

	private static final String _SQL_SELECT_BUS_WHERE =
		"SELECT bus FROM Bus bus WHERE ";

	private static final String _SQL_COUNT_BUS =
		"SELECT COUNT(bus) FROM Bus bus";

	private static final String _SQL_COUNT_BUS_WHERE =
		"SELECT COUNT(bus) FROM Bus bus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Bus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Bus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BusPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}