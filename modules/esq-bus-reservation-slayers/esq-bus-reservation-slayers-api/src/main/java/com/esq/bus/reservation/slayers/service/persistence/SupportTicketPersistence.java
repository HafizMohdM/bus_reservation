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

import com.esq.bus.reservation.slayers.exception.NoSuchSupportTicketException;
import com.esq.bus.reservation.slayers.model.SupportTicket;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the support ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportTicketUtil
 * @generated
 */
@ProviderType
public interface SupportTicketPersistence
	extends BasePersistence<SupportTicket> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportTicketUtil} to access the support ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the support ticket in the entity cache if it is enabled.
	 *
	 * @param supportTicket the support ticket
	 */
	public void cacheResult(SupportTicket supportTicket);

	/**
	 * Caches the support tickets in the entity cache if it is enabled.
	 *
	 * @param supportTickets the support tickets
	 */
	public void cacheResult(java.util.List<SupportTicket> supportTickets);

	/**
	 * Creates a new support ticket with the primary key. Does not add the support ticket to the database.
	 *
	 * @param supportTicketId the primary key for the new support ticket
	 * @return the new support ticket
	 */
	public SupportTicket create(long supportTicketId);

	/**
	 * Removes the support ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket that was removed
	 * @throws NoSuchSupportTicketException if a support ticket with the primary key could not be found
	 */
	public SupportTicket remove(long supportTicketId)
		throws NoSuchSupportTicketException;

	public SupportTicket updateImpl(SupportTicket supportTicket);

	/**
	 * Returns the support ticket with the primary key or throws a <code>NoSuchSupportTicketException</code> if it could not be found.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket
	 * @throws NoSuchSupportTicketException if a support ticket with the primary key could not be found
	 */
	public SupportTicket findByPrimaryKey(long supportTicketId)
		throws NoSuchSupportTicketException;

	/**
	 * Returns the support ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportTicketId the primary key of the support ticket
	 * @return the support ticket, or <code>null</code> if a support ticket with the primary key could not be found
	 */
	public SupportTicket fetchByPrimaryKey(long supportTicketId);

	/**
	 * Returns all the support tickets.
	 *
	 * @return the support tickets
	 */
	public java.util.List<SupportTicket> findAll();

	/**
	 * Returns a range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @return the range of support tickets
	 */
	public java.util.List<SupportTicket> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support tickets
	 */
	public java.util.List<SupportTicket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTicket>
			orderByComparator);

	/**
	 * Returns an ordered range of all the support tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTicketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support tickets
	 * @param end the upper bound of the range of support tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support tickets
	 */
	public java.util.List<SupportTicket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTicket>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the support tickets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of support tickets.
	 *
	 * @return the number of support tickets
	 */
	public int countAll();

}