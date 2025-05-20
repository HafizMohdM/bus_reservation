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

import com.esq.bus.reservation.slayers.exception.NoSuchPaymentException;
import com.esq.bus.reservation.slayers.model.Payment;
import com.esq.bus.reservation.slayers.model.PaymentTable;
import com.esq.bus.reservation.slayers.model.impl.PaymentImpl;
import com.esq.bus.reservation.slayers.model.impl.PaymentModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.PaymentPersistence;
import com.esq.bus.reservation.slayers.service.persistence.PaymentUtil;
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
 * The persistence implementation for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PaymentPersistence.class)
public class PaymentPersistenceImpl
	extends BasePersistenceImpl<Payment> implements PaymentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PaymentUtil</code> to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PaymentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBybookingId;
	private FinderPath _finderPathWithoutPaginationFindBybookingId;
	private FinderPath _finderPathCountBybookingId;

	/**
	 * Returns all the payments where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the matching payments
	 */
	@Override
	public List<Payment> findBybookingId(long bookingId) {
		return findBybookingId(
			bookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payments where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of matching payments
	 */
	@Override
	public List<Payment> findBybookingId(long bookingId, int start, int end) {
		return findBybookingId(bookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payments where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payments
	 */
	@Override
	public List<Payment> findBybookingId(
		long bookingId, int start, int end,
		OrderByComparator<Payment> orderByComparator) {

		return findBybookingId(bookingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payments where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payments
	 */
	@Override
	public List<Payment> findBybookingId(
		long bookingId, int start, int end,
		OrderByComparator<Payment> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBybookingId;
				finderArgs = new Object[] {bookingId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBybookingId;
			finderArgs = new Object[] {
				bookingId, start, end, orderByComparator
			};
		}

		List<Payment> list = null;

		if (useFinderCache) {
			list = (List<Payment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Payment payment : list) {
					if (bookingId != payment.getBookingId()) {
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

			sb.append(_SQL_SELECT_PAYMENT_WHERE);

			sb.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bookingId);

				list = (List<Payment>)QueryUtil.list(
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
	 * Returns the first payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	@Override
	public Payment findBybookingId_First(
			long bookingId, OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException {

		Payment payment = fetchBybookingId_First(bookingId, orderByComparator);

		if (payment != null) {
			return payment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookingId=");
		sb.append(bookingId);

		sb.append("}");

		throw new NoSuchPaymentException(sb.toString());
	}

	/**
	 * Returns the first payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBybookingId_First(
		long bookingId, OrderByComparator<Payment> orderByComparator) {

		List<Payment> list = findBybookingId(
			bookingId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	@Override
	public Payment findBybookingId_Last(
			long bookingId, OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException {

		Payment payment = fetchBybookingId_Last(bookingId, orderByComparator);

		if (payment != null) {
			return payment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookingId=");
		sb.append(bookingId);

		sb.append("}");

		throw new NoSuchPaymentException(sb.toString());
	}

	/**
	 * Returns the last payment in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBybookingId_Last(
		long bookingId, OrderByComparator<Payment> orderByComparator) {

		int count = countBybookingId(bookingId);

		if (count == 0) {
			return null;
		}

		List<Payment> list = findBybookingId(
			bookingId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payments before and after the current payment in the ordered set where bookingId = &#63;.
	 *
	 * @param paymentId the primary key of the current payment
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment[] findBybookingId_PrevAndNext(
			long paymentId, long bookingId,
			OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException {

		Payment payment = findByPrimaryKey(paymentId);

		Session session = null;

		try {
			session = openSession();

			Payment[] array = new PaymentImpl[3];

			array[0] = getBybookingId_PrevAndNext(
				session, payment, bookingId, orderByComparator, true);

			array[1] = payment;

			array[2] = getBybookingId_PrevAndNext(
				session, payment, bookingId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Payment getBybookingId_PrevAndNext(
		Session session, Payment payment, long bookingId,
		OrderByComparator<Payment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PAYMENT_WHERE);

		sb.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

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
			sb.append(PaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bookingId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(payment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Payment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payments where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 */
	@Override
	public void removeBybookingId(long bookingId) {
		for (Payment payment :
				findBybookingId(
					bookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(payment);
		}
	}

	/**
	 * Returns the number of payments where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching payments
	 */
	@Override
	public int countBybookingId(long bookingId) {
		FinderPath finderPath = _finderPathCountBybookingId;

		Object[] finderArgs = new Object[] {bookingId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAYMENT_WHERE);

			sb.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bookingId);

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

	private static final String _FINDER_COLUMN_BOOKINGID_BOOKINGID_2 =
		"payment.bookingId = ?";

	public PaymentPersistenceImpl() {
		setModelClass(Payment.class);

		setModelImplClass(PaymentImpl.class);
		setModelPKClass(long.class);

		setTable(PaymentTable.INSTANCE);
	}

	/**
	 * Caches the payment in the entity cache if it is enabled.
	 *
	 * @param payment the payment
	 */
	@Override
	public void cacheResult(Payment payment) {
		entityCache.putResult(
			PaymentImpl.class, payment.getPrimaryKey(), payment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the payments in the entity cache if it is enabled.
	 *
	 * @param payments the payments
	 */
	@Override
	public void cacheResult(List<Payment> payments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (payments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Payment payment : payments) {
			if (entityCache.getResult(
					PaymentImpl.class, payment.getPrimaryKey()) == null) {

				cacheResult(payment);
			}
		}
	}

	/**
	 * Clears the cache for all payments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PaymentImpl.class);

		finderCache.clearCache(PaymentImpl.class);
	}

	/**
	 * Clears the cache for the payment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Payment payment) {
		entityCache.removeResult(PaymentImpl.class, payment);
	}

	@Override
	public void clearCache(List<Payment> payments) {
		for (Payment payment : payments) {
			entityCache.removeResult(PaymentImpl.class, payment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PaymentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PaymentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	@Override
	public Payment create(long paymentId) {
		Payment payment = new PaymentImpl();

		payment.setNew(true);
		payment.setPrimaryKey(paymentId);

		return payment;
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment remove(long paymentId) throws NoSuchPaymentException {
		return remove((Serializable)paymentId);
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment remove(Serializable primaryKey)
		throws NoSuchPaymentException {

		Session session = null;

		try {
			session = openSession();

			Payment payment = (Payment)session.get(
				PaymentImpl.class, primaryKey);

			if (payment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPaymentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payment);
		}
		catch (NoSuchPaymentException noSuchEntityException) {
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
	protected Payment removeImpl(Payment payment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payment)) {
				payment = (Payment)session.get(
					PaymentImpl.class, payment.getPrimaryKeyObj());
			}

			if (payment != null) {
				session.delete(payment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payment != null) {
			clearCache(payment);
		}

		return payment;
	}

	@Override
	public Payment updateImpl(Payment payment) {
		boolean isNew = payment.isNew();

		if (!(payment instanceof PaymentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Payment implementation " +
					payment.getClass());
		}

		PaymentModelImpl paymentModelImpl = (PaymentModelImpl)payment;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payment);
			}
			else {
				payment = (Payment)session.merge(payment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PaymentImpl.class, paymentModelImpl, false, true);

		if (isNew) {
			payment.setNew(false);
		}

		payment.resetOriginalValues();

		return payment;
	}

	/**
	 * Returns the payment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPaymentException {

		Payment payment = fetchByPrimaryKey(primaryKey);

		if (payment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPaymentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payment;
	}

	/**
	 * Returns the payment with the primary key or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment findByPrimaryKey(long paymentId)
		throws NoSuchPaymentException {

		return findByPrimaryKey((Serializable)paymentId);
	}

	/**
	 * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment, or <code>null</code> if a payment with the primary key could not be found
	 */
	@Override
	public Payment fetchByPrimaryKey(long paymentId) {
		return fetchByPrimaryKey((Serializable)paymentId);
	}

	/**
	 * Returns all the payments.
	 *
	 * @return the payments
	 */
	@Override
	public List<Payment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	@Override
	public List<Payment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payments
	 */
	@Override
	public List<Payment> findAll(
		int start, int end, OrderByComparator<Payment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payments
	 */
	@Override
	public List<Payment> findAll(
		int start, int end, OrderByComparator<Payment> orderByComparator,
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

		List<Payment> list = null;

		if (useFinderCache) {
			list = (List<Payment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYMENT;

				sql = sql.concat(PaymentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Payment>)QueryUtil.list(
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
	 * Removes all the payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Payment payment : findAll()) {
			remove(payment);
		}
	}

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYMENT);

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
		return "paymentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payment persistence.
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

		_finderPathWithPaginationFindBybookingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybookingId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bookingId"}, true);

		_finderPathWithoutPaginationFindBybookingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookingId",
			new String[] {Long.class.getName()}, new String[] {"bookingId"},
			true);

		_finderPathCountBybookingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookingId",
			new String[] {Long.class.getName()}, new String[] {"bookingId"},
			false);

		_setPaymentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPaymentUtilPersistence(null);

		entityCache.removeCache(PaymentImpl.class.getName());
	}

	private void _setPaymentUtilPersistence(
		PaymentPersistence paymentPersistence) {

		try {
			Field field = PaymentUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, paymentPersistence);
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

	private static final String _SQL_SELECT_PAYMENT =
		"SELECT payment FROM Payment payment";

	private static final String _SQL_SELECT_PAYMENT_WHERE =
		"SELECT payment FROM Payment payment WHERE ";

	private static final String _SQL_COUNT_PAYMENT =
		"SELECT COUNT(payment) FROM Payment payment";

	private static final String _SQL_COUNT_PAYMENT_WHERE =
		"SELECT COUNT(payment) FROM Payment payment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Payment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Payment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PaymentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}