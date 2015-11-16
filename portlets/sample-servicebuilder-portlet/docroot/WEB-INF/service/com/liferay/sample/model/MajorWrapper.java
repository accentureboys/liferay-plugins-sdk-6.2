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
 * This class is a wrapper for {@link Major}.
 * </p>
 *
 * @author jasonxiang
 * @see Major
 * @generated
 */
public class MajorWrapper implements Major, ModelWrapper<Major> {
	public MajorWrapper(Major major) {
		_major = major;
	}

	@Override
	public Class<?> getModelClass() {
		return Major.class;
	}

	@Override
	public String getModelClassName() {
		return Major.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("majorId", getMajorId());
		attributes.put("majorName", getMajorName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long majorId = (Long)attributes.get("majorId");

		if (majorId != null) {
			setMajorId(majorId);
		}

		String majorName = (String)attributes.get("majorName");

		if (majorName != null) {
			setMajorName(majorName);
		}
	}

	/**
	* Returns the primary key of this major.
	*
	* @return the primary key of this major
	*/
	@Override
	public long getPrimaryKey() {
		return _major.getPrimaryKey();
	}

	/**
	* Sets the primary key of this major.
	*
	* @param primaryKey the primary key of this major
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_major.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the major ID of this major.
	*
	* @return the major ID of this major
	*/
	@Override
	public long getMajorId() {
		return _major.getMajorId();
	}

	/**
	* Sets the major ID of this major.
	*
	* @param majorId the major ID of this major
	*/
	@Override
	public void setMajorId(long majorId) {
		_major.setMajorId(majorId);
	}

	/**
	* Returns the major name of this major.
	*
	* @return the major name of this major
	*/
	@Override
	public java.lang.String getMajorName() {
		return _major.getMajorName();
	}

	/**
	* Sets the major name of this major.
	*
	* @param majorName the major name of this major
	*/
	@Override
	public void setMajorName(java.lang.String majorName) {
		_major.setMajorName(majorName);
	}

	@Override
	public boolean isNew() {
		return _major.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_major.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _major.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_major.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _major.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _major.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_major.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _major.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_major.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_major.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_major.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MajorWrapper((Major)_major.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Major major) {
		return _major.compareTo(major);
	}

	@Override
	public int hashCode() {
		return _major.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Major> toCacheModel() {
		return _major.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Major toEscapedModel() {
		return new MajorWrapper(_major.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Major toUnescapedModel() {
		return new MajorWrapper(_major.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _major.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _major.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_major.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MajorWrapper)) {
			return false;
		}

		MajorWrapper majorWrapper = (MajorWrapper)obj;

		if (Validator.equals(_major, majorWrapper._major)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Major getWrappedMajor() {
		return _major;
	}

	@Override
	public Major getWrappedModel() {
		return _major;
	}

	@Override
	public void resetOriginalValues() {
		_major.resetOriginalValues();
	}

	private Major _major;
}