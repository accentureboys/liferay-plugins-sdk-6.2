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

package com.liferay.sample.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Thesis}.
 * </p>
 *
 * @author jasonxiang
 * @see Thesis
 * @generated
 */
public class ThesisWrapper implements Thesis, ModelWrapper<Thesis> {
	public ThesisWrapper(Thesis thesis) {
		_thesis = thesis;
	}

	@Override
	public Class<?> getModelClass() {
		return Thesis.class;
	}

	@Override
	public String getModelClassName() {
		return Thesis.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("thesisId", getThesisId());
		attributes.put("thesisName", getThesisName());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long thesisId = (Long)attributes.get("thesisId");

		if (thesisId != null) {
			setThesisId(thesisId);
		}

		String thesisName = (String)attributes.get("thesisName");

		if (thesisName != null) {
			setThesisName(thesisName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this thesis.
	*
	* @return the primary key of this thesis
	*/
	@Override
	public long getPrimaryKey() {
		return _thesis.getPrimaryKey();
	}

	/**
	* Sets the primary key of this thesis.
	*
	* @param primaryKey the primary key of this thesis
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_thesis.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the thesis ID of this thesis.
	*
	* @return the thesis ID of this thesis
	*/
	@Override
	public long getThesisId() {
		return _thesis.getThesisId();
	}

	/**
	* Sets the thesis ID of this thesis.
	*
	* @param thesisId the thesis ID of this thesis
	*/
	@Override
	public void setThesisId(long thesisId) {
		_thesis.setThesisId(thesisId);
	}

	/**
	* Returns the thesis name of this thesis.
	*
	* @return the thesis name of this thesis
	*/
	@Override
	public java.lang.String getThesisName() {
		return _thesis.getThesisName();
	}

	/**
	* Sets the thesis name of this thesis.
	*
	* @param thesisName the thesis name of this thesis
	*/
	@Override
	public void setThesisName(java.lang.String thesisName) {
		_thesis.setThesisName(thesisName);
	}

	/**
	* Returns the user ID of this thesis.
	*
	* @return the user ID of this thesis
	*/
	@Override
	public long getUserId() {
		return _thesis.getUserId();
	}

	/**
	* Sets the user ID of this thesis.
	*
	* @param userId the user ID of this thesis
	*/
	@Override
	public void setUserId(long userId) {
		_thesis.setUserId(userId);
	}

	/**
	* Returns the user uuid of this thesis.
	*
	* @return the user uuid of this thesis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thesis.getUserUuid();
	}

	/**
	* Sets the user uuid of this thesis.
	*
	* @param userUuid the user uuid of this thesis
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_thesis.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _thesis.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_thesis.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _thesis.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_thesis.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _thesis.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _thesis.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_thesis.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _thesis.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_thesis.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_thesis.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_thesis.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ThesisWrapper((Thesis)_thesis.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Thesis thesis) {
		return _thesis.compareTo(thesis);
	}

	@Override
	public int hashCode() {
		return _thesis.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Thesis> toCacheModel() {
		return _thesis.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Thesis toEscapedModel() {
		return new ThesisWrapper(_thesis.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Thesis toUnescapedModel() {
		return new ThesisWrapper(_thesis.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _thesis.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _thesis.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_thesis.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThesisWrapper)) {
			return false;
		}

		ThesisWrapper thesisWrapper = (ThesisWrapper)obj;

		if (Validator.equals(_thesis, thesisWrapper._thesis)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Thesis getWrappedThesis() {
		return _thesis;
	}

	@Override
	public Thesis getWrappedModel() {
		return _thesis;
	}

	@Override
	public void resetOriginalValues() {
		_thesis.resetOriginalValues();
	}

	private Thesis _thesis;
}