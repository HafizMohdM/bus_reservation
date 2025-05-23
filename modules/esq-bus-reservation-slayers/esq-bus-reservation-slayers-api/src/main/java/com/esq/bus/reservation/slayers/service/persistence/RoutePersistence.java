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

package com.esq.bus.reservation.slayers.service.persistence;

import com.esq.bus.reservation.slayers.exception.NoSuchRouteException;
import com.esq.bus.reservation.slayers.model.Route;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RouteUtil
 * @generated
 */
@ProviderType
public interface RoutePersistence extends BasePersistence<Route> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RouteUtil} to access the route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the route in the entity cache if it is enabled.
	 *
	 * @param route the route
	 */
	public void cacheResult(Route route);

	/**
	 * Caches the routes in the entity cache if it is enabled.
	 *
	 * @param routes the routes
	 */
	public void cacheResult(java.util.List<Route> routes);

	/**
	 * Creates a new route with the primary key. Does not add the route to the database.
	 *
	 * @param routeId the primary key for the new route
	 * @return the new route
	 */
	public Route create(long routeId);

	/**
	 * Removes the route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param routeId the primary key of the route
	 * @return the route that was removed
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	public Route remove(long routeId) throws NoSuchRouteException;

	public Route updateImpl(Route route);

	/**
	 * Returns the route with the primary key or throws a <code>NoSuchRouteException</code> if it could not be found.
	 *
	 * @param routeId the primary key of the route
	 * @return the route
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	public Route findByPrimaryKey(long routeId) throws NoSuchRouteException;

	/**
	 * Returns the route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param routeId the primary key of the route
	 * @return the route, or <code>null</code> if a route with the primary key could not be found
	 */
	public Route fetchByPrimaryKey(long routeId);

	/**
	 * Returns all the routes.
	 *
	 * @return the routes
	 */
	public java.util.List<Route> findAll();

	/**
	 * Returns a range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @return the range of routes
	 */
	public java.util.List<Route> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of routes
	 */
	public java.util.List<Route> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator);

	/**
	 * Returns an ordered range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of routes
	 */
	public java.util.List<Route> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the routes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of routes.
	 *
	 * @return the number of routes
	 */
	public int countAll();

}