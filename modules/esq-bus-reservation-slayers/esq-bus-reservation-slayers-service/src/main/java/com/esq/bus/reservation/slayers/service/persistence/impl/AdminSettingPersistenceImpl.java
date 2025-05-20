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

import com.esq.bus.reservation.slayers.exception.NoSuchAdminSettingException;
import com.esq.bus.reservation.slayers.model.AdminSetting;
import com.esq.bus.reservation.slayers.model.AdminSettingTable;
import com.esq.bus.reservation.slayers.model.impl.AdminSettingImpl;
import com.esq.bus.reservation.slayers.model.impl.AdminSettingModelImpl;
import com.esq.bus.reservation.slayers.service.persistence.AdminSettingPersistence;
import com.esq.bus.reservation.slayers.service.persistence.AdminSettingUtil;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the admin setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AdminSettingPersistence.class)
public class AdminSettingPersistenceImpl
	extends BasePersistenceImpl<AdminSetting>
	implements AdminSettingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AdminSettingUtil</code> to access the admin setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AdminSettingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AdminSettingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AdminSetting.class);

		setModelImplClass(AdminSettingImpl.class);
		setModelPKClass(long.class);

		setTable(AdminSettingTable.INSTANCE);
	}

	/**
	 * Caches the admin setting in the entity cache if it is enabled.
	 *
	 * @param adminSetting the admin setting
	 */
	@Override
	public void cacheResult(AdminSetting adminSetting) {
		entityCache.putResult(
			AdminSettingImpl.class, adminSetting.getPrimaryKey(), adminSetting);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the admin settings in the entity cache if it is enabled.
	 *
	 * @param adminSettings the admin settings
	 */
	@Override
	public void cacheResult(List<AdminSetting> adminSettings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (adminSettings.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AdminSetting adminSetting : adminSettings) {
			if (entityCache.getResult(
					AdminSettingImpl.class, adminSetting.getPrimaryKey()) ==
						null) {

				cacheResult(adminSetting);
			}
		}
	}

	/**
	 * Clears the cache for all admin settings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AdminSettingImpl.class);

		finderCache.clearCache(AdminSettingImpl.class);
	}

	/**
	 * Clears the cache for the admin setting.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdminSetting adminSetting) {
		entityCache.removeResult(AdminSettingImpl.class, adminSetting);
	}

	@Override
	public void clearCache(List<AdminSetting> adminSettings) {
		for (AdminSetting adminSetting : adminSettings) {
			entityCache.removeResult(AdminSettingImpl.class, adminSetting);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AdminSettingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AdminSettingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new admin setting with the primary key. Does not add the admin setting to the database.
	 *
	 * @param settingId the primary key for the new admin setting
	 * @return the new admin setting
	 */
	@Override
	public AdminSetting create(long settingId) {
		AdminSetting adminSetting = new AdminSettingImpl();

		adminSetting.setNew(true);
		adminSetting.setPrimaryKey(settingId);

		return adminSetting;
	}

	/**
	 * Removes the admin setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting that was removed
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	@Override
	public AdminSetting remove(long settingId)
		throws NoSuchAdminSettingException {

		return remove((Serializable)settingId);
	}

	/**
	 * Removes the admin setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the admin setting
	 * @return the admin setting that was removed
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	@Override
	public AdminSetting remove(Serializable primaryKey)
		throws NoSuchAdminSettingException {

		Session session = null;

		try {
			session = openSession();

			AdminSetting adminSetting = (AdminSetting)session.get(
				AdminSettingImpl.class, primaryKey);

			if (adminSetting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdminSettingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(adminSetting);
		}
		catch (NoSuchAdminSettingException noSuchEntityException) {
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
	protected AdminSetting removeImpl(AdminSetting adminSetting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adminSetting)) {
				adminSetting = (AdminSetting)session.get(
					AdminSettingImpl.class, adminSetting.getPrimaryKeyObj());
			}

			if (adminSetting != null) {
				session.delete(adminSetting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (adminSetting != null) {
			clearCache(adminSetting);
		}

		return adminSetting;
	}

	@Override
	public AdminSetting updateImpl(AdminSetting adminSetting) {
		boolean isNew = adminSetting.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(adminSetting);
			}
			else {
				adminSetting = (AdminSetting)session.merge(adminSetting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AdminSettingImpl.class, adminSetting, false, true);

		if (isNew) {
			adminSetting.setNew(false);
		}

		adminSetting.resetOriginalValues();

		return adminSetting;
	}

	/**
	 * Returns the admin setting with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin setting
	 * @return the admin setting
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	@Override
	public AdminSetting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdminSettingException {

		AdminSetting adminSetting = fetchByPrimaryKey(primaryKey);

		if (adminSetting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdminSettingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return adminSetting;
	}

	/**
	 * Returns the admin setting with the primary key or throws a <code>NoSuchAdminSettingException</code> if it could not be found.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting
	 * @throws NoSuchAdminSettingException if a admin setting with the primary key could not be found
	 */
	@Override
	public AdminSetting findByPrimaryKey(long settingId)
		throws NoSuchAdminSettingException {

		return findByPrimaryKey((Serializable)settingId);
	}

	/**
	 * Returns the admin setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param settingId the primary key of the admin setting
	 * @return the admin setting, or <code>null</code> if a admin setting with the primary key could not be found
	 */
	@Override
	public AdminSetting fetchByPrimaryKey(long settingId) {
		return fetchByPrimaryKey((Serializable)settingId);
	}

	/**
	 * Returns all the admin settings.
	 *
	 * @return the admin settings
	 */
	@Override
	public List<AdminSetting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @return the range of admin settings
	 */
	@Override
	public List<AdminSetting> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of admin settings
	 */
	@Override
	public List<AdminSetting> findAll(
		int start, int end, OrderByComparator<AdminSetting> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the admin settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AdminSettingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin settings
	 * @param end the upper bound of the range of admin settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of admin settings
	 */
	@Override
	public List<AdminSetting> findAll(
		int start, int end, OrderByComparator<AdminSetting> orderByComparator,
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

		List<AdminSetting> list = null;

		if (useFinderCache) {
			list = (List<AdminSetting>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADMINSETTING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADMINSETTING;

				sql = sql.concat(AdminSettingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AdminSetting>)QueryUtil.list(
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
	 * Removes all the admin settings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AdminSetting adminSetting : findAll()) {
			remove(adminSetting);
		}
	}

	/**
	 * Returns the number of admin settings.
	 *
	 * @return the number of admin settings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADMINSETTING);

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
		return "settingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADMINSETTING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AdminSettingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the admin setting persistence.
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

		_setAdminSettingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAdminSettingUtilPersistence(null);

		entityCache.removeCache(AdminSettingImpl.class.getName());
	}

	private void _setAdminSettingUtilPersistence(
		AdminSettingPersistence adminSettingPersistence) {

		try {
			Field field = AdminSettingUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, adminSettingPersistence);
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

	private static final String _SQL_SELECT_ADMINSETTING =
		"SELECT adminSetting FROM AdminSetting adminSetting";

	private static final String _SQL_COUNT_ADMINSETTING =
		"SELECT COUNT(adminSetting) FROM AdminSetting adminSetting";

	private static final String _ORDER_BY_ENTITY_ALIAS = "adminSetting.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AdminSetting exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AdminSettingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}