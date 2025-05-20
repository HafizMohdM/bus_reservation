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

package com.esq.bus.reservation.slayers.service.impl;

import com.esq.bus.reservation.slayers.model.Booking;
import com.esq.bus.reservation.slayers.service.base.BookingLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.esq.bus.reservation.slayers.model.Booking",
	service = AopService.class
)
public class BookingLocalServiceImpl extends BookingLocalServiceBaseImpl {

	/*
	 * @Override public Booking addBooking(String busNumber, String
	 * busPlateNumber,int busType, int capacity,long userId,String image1, String
	 * image2,String image3,String image4,String image5) {
	 * 
	 * 
	 * return super.addBooking(booking); }
	 */

	@Override
	public Booking deleteBooking(Booking booking) {
		
		return super.deleteBooking(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		
		return super.updateBooking(booking);
	}

	@Override
	public Booking addBooking(String busNumber, String busPlateNumber, int busType, int capacity, long userId,
			String image1, String image2, String image3, String image4, String image5) {
		// TODO Auto-generated method stub
		return null;
	}
     
	
	
	    

     }
