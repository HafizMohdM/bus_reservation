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

package com.esq.bus.reservation.slayers.service.persistence.impl.constants;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BOOKRESERVATIONPersistenceConstants {

	public static final String BUNDLE_SYMBOLIC_NAME =
		"com.esq.bus.reservation.slayers.service";

	public static final String ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER =
		"(origin.bundle.symbolic.name=" + BUNDLE_SYMBOLIC_NAME + ")";

	public static final String SERVICE_CONFIGURATION_FILTER =
		"(&" + ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER + "(name=service))";

}