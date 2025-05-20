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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Discount}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Discount
 * @generated
 */
public class DiscountWrapper
	extends BaseModelWrapper<Discount>
	implements Discount, ModelWrapper<Discount> {

	public DiscountWrapper(Discount discount) {
		super(discount);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("discountId", getDiscountId());
		attributes.put("code", getCode());
		attributes.put("percentage", getPercentage());
		attributes.put("validFrom", getValidFrom());
		attributes.put("validTo", getValidTo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long discountId = (Long)attributes.get("discountId");

		if (discountId != null) {
			setDiscountId(discountId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Double percentage = (Double)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		Date validFrom = (Date)attributes.get("validFrom");

		if (validFrom != null) {
			setValidFrom(validFrom);
		}

		Date validTo = (Date)attributes.get("validTo");

		if (validTo != null) {
			setValidTo(validTo);
		}
	}

	@Override
	public Discount cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this discount.
	 *
	 * @return the code of this discount
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the discount ID of this discount.
	 *
	 * @return the discount ID of this discount
	 */
	@Override
	public long getDiscountId() {
		return model.getDiscountId();
	}

	/**
	 * Returns the percentage of this discount.
	 *
	 * @return the percentage of this discount
	 */
	@Override
	public double getPercentage() {
		return model.getPercentage();
	}

	/**
	 * Returns the primary key of this discount.
	 *
	 * @return the primary key of this discount
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the valid from of this discount.
	 *
	 * @return the valid from of this discount
	 */
	@Override
	public Date getValidFrom() {
		return model.getValidFrom();
	}

	/**
	 * Returns the valid to of this discount.
	 *
	 * @return the valid to of this discount
	 */
	@Override
	public Date getValidTo() {
		return model.getValidTo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this discount.
	 *
	 * @param code the code of this discount
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the discount ID of this discount.
	 *
	 * @param discountId the discount ID of this discount
	 */
	@Override
	public void setDiscountId(long discountId) {
		model.setDiscountId(discountId);
	}

	/**
	 * Sets the percentage of this discount.
	 *
	 * @param percentage the percentage of this discount
	 */
	@Override
	public void setPercentage(double percentage) {
		model.setPercentage(percentage);
	}

	/**
	 * Sets the primary key of this discount.
	 *
	 * @param primaryKey the primary key of this discount
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the valid from of this discount.
	 *
	 * @param validFrom the valid from of this discount
	 */
	@Override
	public void setValidFrom(Date validFrom) {
		model.setValidFrom(validFrom);
	}

	/**
	 * Sets the valid to of this discount.
	 *
	 * @param validTo the valid to of this discount
	 */
	@Override
	public void setValidTo(Date validTo) {
		model.setValidTo(validTo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DiscountWrapper wrap(Discount discount) {
		return new DiscountWrapper(discount);
	}

}