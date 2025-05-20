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

import com.esq.bus.reservation.slayers.exception.NoSuchUserRoleException;
import com.esq.bus.reservation.slayers.model.UserRole;
import com.esq.bus.reservation.slayers.model.UserRoleTable;
import com.esq.bus.reservation.slayers.model.impl.UserRoleImpl;
import com.esq.bus.reservation.slayers.model.impl.UserRoleModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.UserRolePersistence;
import com.esq.bus.reservation.slayers.service.persistence.UserRoleUtil;
import com.esq.bus.reservation.slayers.service.persistence.impl.constants.BOOKRESERVATIONPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRolePersistence.class)
public class UserRolePersistenceImpl
	extends BasePersistenceImpl<UserRole> implements UserRolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRoleUtil</code> to access the user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRoleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UserRolePersistenceImpl() {
		setModelClass(UserRole.class);

		setModelImplClass(UserRoleImpl.class);
		setModelPKClass(long.class);

		setTable(UserRoleTable.INSTANCE);
	}

	/**
	 * Caches the user role in the entity cache if it is enabled.
	 *
	 * @param userRole the user role
	 */
	@Override
	public void cacheResult(UserRole userRole) {
		entityCache.putResult(
			UserRoleImpl.class, userRole.getPrimaryKey(), userRole);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user roles in the entity cache if it is enabled.
	 *
	 * @param userRoles the user roles
	 */
	@Override
	public void cacheResult(List<UserRole> userRoles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userRoles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserRole userRole : userRoles) {
			if (entityCache.getResult(
					UserRoleImpl.class, userRole.getPrimaryKey()) == null) {

				cacheResult(userRole);
			}
		}
	}

	/**
	 * Clears the cache for all user roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRoleImpl.class);

		finderCache.clearCache(UserRoleImpl.class);
	}

	/**
	 * Clears the cache for the user role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserRole userRole) {
		entityCache.removeResult(UserRoleImpl.class, userRole);
	}

	@Override
	public void clearCache(List<UserRole> userRoles) {
		for (UserRole userRole : userRoles) {
			entityCache.removeResult(UserRoleImpl.class, userRole);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserRoleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserRoleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user role with the primary key. Does not add the user role to the database.
	 *
	 * @param userRoleId the primary key for the new user role
	 * @return the new user role
	 */
	@Override
	public UserRole create(long userRoleId) {
		UserRole userRole = new UserRoleImpl();

		userRole.setNew(true);
		userRole.setPrimaryKey(userRoleId);

		return userRole;
	}

	/**
	 * Removes the user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRoleId the primary key of the user role
	 * @return the user role that was removed
	 * @throws NoSuchUserRoleException if a user role with the primary key could not be found
	 */
	@Override
	public UserRole remove(long userRoleId) throws NoSuchUserRoleException {
		return remove((Serializable)userRoleId);
	}

	/**
	 * Removes the user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user role
	 * @return the user role that was removed
	 * @throws NoSuchUserRoleException if a user role with the primary key could not be found
	 */
	@Override
	public UserRole remove(Serializable primaryKey)
		throws NoSuchUserRoleException {

		Session session = null;

		try {
			session = openSession();

			UserRole userRole = (UserRole)session.get(
				UserRoleImpl.class, primaryKey);

			if (userRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRoleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRole);
		}
		catch (NoSuchUserRoleException noSuchEntityException) {
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
	protected UserRole removeImpl(UserRole userRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRole)) {
				userRole = (UserRole)session.get(
					UserRoleImpl.class, userRole.getPrimaryKeyObj());
			}

			if (userRole != null) {
				session.delete(userRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userRole != null) {
			clearCache(userRole);
		}

		return userRole;
	}

	@Override
	public UserRole updateImpl(UserRole userRole) {
		boolean isNew = userRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userRole);
			}
			else {
				userRole = (UserRole)session.merge(userRole);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(UserRoleImpl.class, userRole, false, true);

		if (isNew) {
			userRole.setNew(false);
		}

		userRole.resetOriginalValues();

		return userRole;
	}

	/**
	 * Returns the user role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user role
	 * @return the user role
	 * @throws NoSuchUserRoleException if a user role with the primary key could not be found
	 */
	@Override
	public UserRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRoleException {

		UserRole userRole = fetchByPrimaryKey(primaryKey);

		if (userRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRoleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRole;
	}

	/**
	 * Returns the user role with the primary key or throws a <code>NoSuchUserRoleException</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role
	 * @return the user role
	 * @throws NoSuchUserRoleException if a user role with the primary key could not be found
	 */
	@Override
	public UserRole findByPrimaryKey(long userRoleId)
		throws NoSuchUserRoleException {

		return findByPrimaryKey((Serializable)userRoleId);
	}

	/**
	 * Returns the user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role
	 * @return the user role, or <code>null</code> if a user role with the primary key could not be found
	 */
	@Override
	public UserRole fetchByPrimaryKey(long userRoleId) {
		return fetchByPrimaryKey((Serializable)userRoleId);
	}

	/**
	 * Returns all the user roles.
	 *
	 * @return the user roles
	 */
	@Override
	public List<UserRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user roles
	 * @param end the upper bound of the range of user roles (not inclusive)
	 * @return the range of user roles
	 */
	@Override
	public List<UserRole> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user roles
	 * @param end the upper bound of the range of user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user roles
	 */
	@Override
	public List<UserRole> findAll(
		int start, int end, OrderByComparator<UserRole> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user roles
	 * @param end the upper bound of the range of user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user roles
	 */
	@Override
	public List<UserRole> findAll(
		int start, int end, OrderByComparator<UserRole> orderByComparator,
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

		List<UserRole> list = null;

		if (useFinderCache) {
			list = (List<UserRole>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERROLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERROLE;

				sql = sql.concat(UserRoleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserRole>)QueryUtil.list(
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
	 * Removes all the user roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRole userRole : findAll()) {
			remove(userRole);
		}
	}

	/**
	 * Returns the number of user roles.
	 *
	 * @return the number of user roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERROLE);

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
		return "userRoleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user role persistence.
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

		_setUserRoleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserRoleUtilPersistence(null);

		entityCache.removeCache(UserRoleImpl.class.getName());
	}

	private void _setUserRoleUtilPersistence(
		UserRolePersistence userRolePersistence) {

		try {
			Field field = UserRoleUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, userRolePersistence);
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

	private static final String _SQL_SELECT_USERROLE =
		"SELECT userRole FROM UserRole userRole";

	private static final String _SQL_COUNT_USERROLE =
		"SELECT COUNT(userRole) FROM UserRole userRole";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userRole.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRole exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRolePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}