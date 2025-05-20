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

import com.esq.bus.reservation.slayers.exception.NoSuchDiscountException;
import com.esq.bus.reservation.slayers.model.Discount;
import com.esq.bus.reservation.slayers.model.DiscountTable;
import com.esq.bus.reservation.slayers.model.impl.DiscountImpl;
import com.esq.bus.reservation.slayers.model.impl.DiscountModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.DiscountPersistence;
import com.esq.bus.reservation.slayers.service.persistence.DiscountUtil;
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
 * The persistence implementation for the discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DiscountPersistence.class)
public class DiscountPersistenceImpl
	extends BasePersistenceImpl<Discount> implements DiscountPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DiscountUtil</code> to access the discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DiscountImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBycode;
	private FinderPath _finderPathWithoutPaginationFindBycode;
	private FinderPath _finderPathCountBycode;

	/**
	 * Returns all the discounts where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching discounts
	 */
	@Override
	public List<Discount> findBycode(String code) {
		return findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the discounts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @return the range of matching discounts
	 */
	@Override
	public List<Discount> findBycode(String code, int start, int end) {
		return findBycode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the discounts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching discounts
	 */
	@Override
	public List<Discount> findBycode(
		String code, int start, int end,
		OrderByComparator<Discount> orderByComparator) {

		return findBycode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the discounts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching discounts
	 */
	@Override
	public List<Discount> findBycode(
		String code, int start, int end,
		OrderByComparator<Discount> orderByComparator, boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycode;
				finderArgs = new Object[] {code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycode;
			finderArgs = new Object[] {code, start, end, orderByComparator};
		}

		List<Discount> list = null;

		if (useFinderCache) {
			list = (List<Discount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Discount discount : list) {
					if (!code.equals(discount.getCode())) {
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

			sb.append(_SQL_SELECT_DISCOUNT_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DiscountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<Discount>)QueryUtil.list(
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
	 * Returns the first discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching discount
	 * @throws NoSuchDiscountException if a matching discount could not be found
	 */
	@Override
	public Discount findBycode_First(
			String code, OrderByComparator<Discount> orderByComparator)
		throws NoSuchDiscountException {

		Discount discount = fetchBycode_First(code, orderByComparator);

		if (discount != null) {
			return discount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchDiscountException(sb.toString());
	}

	/**
	 * Returns the first discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching discount, or <code>null</code> if a matching discount could not be found
	 */
	@Override
	public Discount fetchBycode_First(
		String code, OrderByComparator<Discount> orderByComparator) {

		List<Discount> list = findBycode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching discount
	 * @throws NoSuchDiscountException if a matching discount could not be found
	 */
	@Override
	public Discount findBycode_Last(
			String code, OrderByComparator<Discount> orderByComparator)
		throws NoSuchDiscountException {

		Discount discount = fetchBycode_Last(code, orderByComparator);

		if (discount != null) {
			return discount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchDiscountException(sb.toString());
	}

	/**
	 * Returns the last discount in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching discount, or <code>null</code> if a matching discount could not be found
	 */
	@Override
	public Discount fetchBycode_Last(
		String code, OrderByComparator<Discount> orderByComparator) {

		int count = countBycode(code);

		if (count == 0) {
			return null;
		}

		List<Discount> list = findBycode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the discounts before and after the current discount in the ordered set where code = &#63;.
	 *
	 * @param discountId the primary key of the current discount
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	@Override
	public Discount[] findBycode_PrevAndNext(
			long discountId, String code,
			OrderByComparator<Discount> orderByComparator)
		throws NoSuchDiscountException {

		code = Objects.toString(code, "");

		Discount discount = findByPrimaryKey(discountId);

		Session session = null;

		try {
			session = openSession();

			Discount[] array = new DiscountImpl[3];

			array[0] = getBycode_PrevAndNext(
				session, discount, code, orderByComparator, true);

			array[1] = discount;

			array[2] = getBycode_PrevAndNext(
				session, discount, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Discount getBycode_PrevAndNext(
		Session session, Discount discount, String code,
		OrderByComparator<Discount> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DISCOUNT_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_CODE_CODE_2);
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
			sb.append(DiscountModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(discount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Discount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the discounts where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeBycode(String code) {
		for (Discount discount :
				findBycode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(discount);
		}
	}

	/**
	 * Returns the number of discounts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching discounts
	 */
	@Override
	public int countBycode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBycode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DISCOUNT_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"discount.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(discount.code IS NULL OR discount.code = '')";

	public DiscountPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Discount.class);

		setModelImplClass(DiscountImpl.class);
		setModelPKClass(long.class);

		setTable(DiscountTable.INSTANCE);
	}

	/**
	 * Caches the discount in the entity cache if it is enabled.
	 *
	 * @param discount the discount
	 */
	@Override
	public void cacheResult(Discount discount) {
		entityCache.putResult(
			DiscountImpl.class, discount.getPrimaryKey(), discount);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the discounts in the entity cache if it is enabled.
	 *
	 * @param discounts the discounts
	 */
	@Override
	public void cacheResult(List<Discount> discounts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (discounts.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Discount discount : discounts) {
			if (entityCache.getResult(
					DiscountImpl.class, discount.getPrimaryKey()) == null) {

				cacheResult(discount);
			}
		}
	}

	/**
	 * Clears the cache for all discounts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DiscountImpl.class);

		finderCache.clearCache(DiscountImpl.class);
	}

	/**
	 * Clears the cache for the discount.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Discount discount) {
		entityCache.removeResult(DiscountImpl.class, discount);
	}

	@Override
	public void clearCache(List<Discount> discounts) {
		for (Discount discount : discounts) {
			entityCache.removeResult(DiscountImpl.class, discount);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DiscountImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DiscountImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new discount with the primary key. Does not add the discount to the database.
	 *
	 * @param discountId the primary key for the new discount
	 * @return the new discount
	 */
	@Override
	public Discount create(long discountId) {
		Discount discount = new DiscountImpl();

		discount.setNew(true);
		discount.setPrimaryKey(discountId);

		return discount;
	}

	/**
	 * Removes the discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount that was removed
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	@Override
	public Discount remove(long discountId) throws NoSuchDiscountException {
		return remove((Serializable)discountId);
	}

	/**
	 * Removes the discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the discount
	 * @return the discount that was removed
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	@Override
	public Discount remove(Serializable primaryKey)
		throws NoSuchDiscountException {

		Session session = null;

		try {
			session = openSession();

			Discount discount = (Discount)session.get(
				DiscountImpl.class, primaryKey);

			if (discount == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDiscountException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(discount);
		}
		catch (NoSuchDiscountException noSuchEntityException) {
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
	protected Discount removeImpl(Discount discount) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(discount)) {
				discount = (Discount)session.get(
					DiscountImpl.class, discount.getPrimaryKeyObj());
			}

			if (discount != null) {
				session.delete(discount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (discount != null) {
			clearCache(discount);
		}

		return discount;
	}

	@Override
	public Discount updateImpl(Discount discount) {
		boolean isNew = discount.isNew();

		if (!(discount instanceof DiscountModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(discount.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(discount);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in discount proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Discount implementation " +
					discount.getClass());
		}

		DiscountModelImpl discountModelImpl = (DiscountModelImpl)discount;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(discount);
			}
			else {
				discount = (Discount)session.merge(discount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DiscountImpl.class, discountModelImpl, false, true);

		if (isNew) {
			discount.setNew(false);
		}

		discount.resetOriginalValues();

		return discount;
	}

	/**
	 * Returns the discount with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the discount
	 * @return the discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	@Override
	public Discount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDiscountException {

		Discount discount = fetchByPrimaryKey(primaryKey);

		if (discount == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDiscountException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return discount;
	}

	/**
	 * Returns the discount with the primary key or throws a <code>NoSuchDiscountException</code> if it could not be found.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount
	 * @throws NoSuchDiscountException if a discount with the primary key could not be found
	 */
	@Override
	public Discount findByPrimaryKey(long discountId)
		throws NoSuchDiscountException {

		return findByPrimaryKey((Serializable)discountId);
	}

	/**
	 * Returns the discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param discountId the primary key of the discount
	 * @return the discount, or <code>null</code> if a discount with the primary key could not be found
	 */
	@Override
	public Discount fetchByPrimaryKey(long discountId) {
		return fetchByPrimaryKey((Serializable)discountId);
	}

	/**
	 * Returns all the discounts.
	 *
	 * @return the discounts
	 */
	@Override
	public List<Discount> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @return the range of discounts
	 */
	@Override
	public List<Discount> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of discounts
	 */
	@Override
	public List<Discount> findAll(
		int start, int end, OrderByComparator<Discount> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of discounts
	 * @param end the upper bound of the range of discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of discounts
	 */
	@Override
	public List<Discount> findAll(
		int start, int end, OrderByComparator<Discount> orderByComparator,
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

		List<Discount> list = null;

		if (useFinderCache) {
			list = (List<Discount>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DISCOUNT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DISCOUNT;

				sql = sql.concat(DiscountModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Discount>)QueryUtil.list(
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
	 * Removes all the discounts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Discount discount : findAll()) {
			remove(discount);
		}
	}

	/**
	 * Returns the number of discounts.
	 *
	 * @return the number of discounts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DISCOUNT);

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
		return "discountId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DISCOUNT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DiscountModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the discount persistence.
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

		_finderPathWithPaginationFindBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"code_"}, true);

		_finderPathWithoutPaginationFindBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountBycode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_setDiscountUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDiscountUtilPersistence(null);

		entityCache.removeCache(DiscountImpl.class.getName());
	}

	private void _setDiscountUtilPersistence(
		DiscountPersistence discountPersistence) {

		try {
			Field field = DiscountUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, discountPersistence);
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

	private static final String _SQL_SELECT_DISCOUNT =
		"SELECT discount FROM Discount discount";

	private static final String _SQL_SELECT_DISCOUNT_WHERE =
		"SELECT discount FROM Discount discount WHERE ";

	private static final String _SQL_COUNT_DISCOUNT =
		"SELECT COUNT(discount) FROM Discount discount";

	private static final String _SQL_COUNT_DISCOUNT_WHERE =
		"SELECT COUNT(discount) FROM Discount discount WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "discount.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Discount exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Discount exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DiscountPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}