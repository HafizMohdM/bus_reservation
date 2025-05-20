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

package com.esq.bus.reservation.slayers.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdminSetting}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminSetting
 * @generated
 */
public class AdminSettingWrapper
	extends BaseModelWrapper<AdminSetting>
	implements AdminSetting, ModelWrapper<AdminSetting> {

	public AdminSettingWrapper(AdminSetting adminSetting) {
		super(adminSetting);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("settingId", getSettingId());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long settingId = (Long)attributes.get("settingId");

		if (settingId != null) {
			setSettingId(settingId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public AdminSetting cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the key of this admin setting.
	 *
	 * @return the key of this admin setting
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the primary key of this admin setting.
	 *
	 * @return the primary key of this admin setting
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the setting ID of this admin setting.
	 *
	 * @return the setting ID of this admin setting
	 */
	@Override
	public long getSettingId() {
		return model.getSettingId();
	}

	/**
	 * Returns the value of this admin setting.
	 *
	 * @return the value of this admin setting
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the key of this admin setting.
	 *
	 * @param key the key of this admin setting
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the primary key of this admin setting.
	 *
	 * @param primaryKey the primary key of this admin setting
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the setting ID of this admin setting.
	 *
	 * @param settingId the setting ID of this admin setting
	 */
	@Override
	public void setSettingId(long settingId) {
		model.setSettingId(settingId);
	}

	/**
	 * Sets the value of this admin setting.
	 *
	 * @param value the value of this admin setting
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AdminSettingWrapper wrap(AdminSetting adminSetting) {
		return new AdminSettingWrapper(adminSetting);
	}

}