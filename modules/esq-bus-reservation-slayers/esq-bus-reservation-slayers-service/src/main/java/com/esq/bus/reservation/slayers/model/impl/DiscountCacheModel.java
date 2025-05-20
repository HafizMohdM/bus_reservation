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

package com.esq.bus.reservation.slayers.model.impl;

import com.esq.bus.reservation.slayers.model.Discount;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Discount in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DiscountCacheModel
	implements CacheModel<Discount>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DiscountCacheModel)) {
			return false;
		}

		DiscountCacheModel discountCacheModel = (DiscountCacheModel)object;

		if (discountId == discountCacheModel.discountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, discountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{discountId=");
		sb.append(discountId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", percentage=");
		sb.append(percentage);
		sb.append(", validFrom=");
		sb.append(validFrom);
		sb.append(", validTo=");
		sb.append(validTo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Discount toEntityModel() {
		DiscountImpl discountImpl = new DiscountImpl();

		discountImpl.setDiscountId(discountId);

		if (code == null) {
			discountImpl.setCode("");
		}
		else {
			discountImpl.setCode(code);
		}

		discountImpl.setPercentage(percentage);

		if (validFrom == Long.MIN_VALUE) {
			discountImpl.setValidFrom(null);
		}
		else {
			discountImpl.setValidFrom(new Date(validFrom));
		}

		if (validTo == Long.MIN_VALUE) {
			discountImpl.setValidTo(null);
		}
		else {
			discountImpl.setValidTo(new Date(validTo));
		}

		discountImpl.resetOriginalValues();

		return discountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		discountId = objectInput.readLong();
		code = objectInput.readUTF();

		percentage = objectInput.readDouble();
		validFrom = objectInput.readLong();
		validTo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(discountId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeDouble(percentage);
		objectOutput.writeLong(validFrom);
		objectOutput.writeLong(validTo);
	}

	public long discountId;
	public String code;
	public double percentage;
	public long validFrom;
	public long validTo;

}