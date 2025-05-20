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
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Feedback
 * @generated
 */
public class FeedbackWrapper
	extends BaseModelWrapper<Feedback>
	implements Feedback, ModelWrapper<Feedback> {

	public FeedbackWrapper(Feedback feedback) {
		super(feedback);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("passengerId", getPassengerId());
		attributes.put("bookingId", getBookingId());
		attributes.put("rating", getRating());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long passengerId = (Long)attributes.get("passengerId");

		if (passengerId != null) {
			setPassengerId(passengerId);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	@Override
	public Feedback cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the booking ID of this feedback.
	 *
	 * @return the booking ID of this feedback
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the comment of this feedback.
	 *
	 * @return the comment of this feedback
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the feedback ID of this feedback.
	 *
	 * @return the feedback ID of this feedback
	 */
	@Override
	public long getFeedbackId() {
		return model.getFeedbackId();
	}

	/**
	 * Returns the passenger ID of this feedback.
	 *
	 * @return the passenger ID of this feedback
	 */
	@Override
	public long getPassengerId() {
		return model.getPassengerId();
	}

	/**
	 * Returns the primary key of this feedback.
	 *
	 * @return the primary key of this feedback
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rating of this feedback.
	 *
	 * @return the rating of this feedback
	 */
	@Override
	public int getRating() {
		return model.getRating();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the booking ID of this feedback.
	 *
	 * @param bookingId the booking ID of this feedback
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the comment of this feedback.
	 *
	 * @param comment the comment of this feedback
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the feedback ID of this feedback.
	 *
	 * @param feedbackId the feedback ID of this feedback
	 */
	@Override
	public void setFeedbackId(long feedbackId) {
		model.setFeedbackId(feedbackId);
	}

	/**
	 * Sets the passenger ID of this feedback.
	 *
	 * @param passengerId the passenger ID of this feedback
	 */
	@Override
	public void setPassengerId(long passengerId) {
		model.setPassengerId(passengerId);
	}

	/**
	 * Sets the primary key of this feedback.
	 *
	 * @param primaryKey the primary key of this feedback
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rating of this feedback.
	 *
	 * @param rating the rating of this feedback
	 */
	@Override
	public void setRating(int rating) {
		model.setRating(rating);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FeedbackWrapper wrap(Feedback feedback) {
		return new FeedbackWrapper(feedback);
	}

}