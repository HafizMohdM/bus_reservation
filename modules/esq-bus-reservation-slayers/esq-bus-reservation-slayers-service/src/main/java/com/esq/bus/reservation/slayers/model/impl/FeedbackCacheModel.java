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

import com.esq.bus.reservation.slayers.model.Feedback;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Feedback in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FeedbackCacheModel
	implements CacheModel<Feedback>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FeedbackCacheModel)) {
			return false;
		}

		FeedbackCacheModel feedbackCacheModel = (FeedbackCacheModel)object;

		if (feedbackId == feedbackCacheModel.feedbackId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, feedbackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{feedbackId=");
		sb.append(feedbackId);
		sb.append(", passengerId=");
		sb.append(passengerId);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(feedbackId);
		feedbackImpl.setPassengerId(passengerId);
		feedbackImpl.setBookingId(bookingId);
		feedbackImpl.setRating(rating);

		if (comment == null) {
			feedbackImpl.setComment("");
		}
		else {
			feedbackImpl.setComment(comment);
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		feedbackId = objectInput.readLong();

		passengerId = objectInput.readLong();

		bookingId = objectInput.readLong();

		rating = objectInput.readInt();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(feedbackId);

		objectOutput.writeLong(passengerId);

		objectOutput.writeLong(bookingId);

		objectOutput.writeInt(rating);

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long feedbackId;
	public long passengerId;
	public long bookingId;
	public int rating;
	public String comment;

}