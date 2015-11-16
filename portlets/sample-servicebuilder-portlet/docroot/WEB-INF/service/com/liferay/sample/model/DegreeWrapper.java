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
 * This class is a wrapper for {@link Degree}.
 * </p>
 *
 * @author jasonxiang
 * @see Degree
 * @generated
 */
public class DegreeWrapper implements Degree, ModelWrapper<Degree> {
	public DegreeWrapper(Degree degree) {
		_degree = degree;
	}

	@Override
	public Class<?> getModelClass() {
		return Degree.class;
	}

	@Override
	public String getModelClassName() {
		return Degree.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("degreeId", getDegreeId());
		attributes.put("degreeName", getDegreeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long degreeId = (Long)attributes.get("degreeId");

		if (degreeId != null) {
			setDegreeId(degreeId);
		}

		String degreeName = (String)attributes.get("degreeName");

		if (degreeName != null) {
			setDegreeName(degreeName);
		}
	}

	/**
	* Returns the primary key of this degree.
	*
	* @return the primary key of this degree
	*/
	@Override
	public long getPrimaryKey() {
		return _degree.getPrimaryKey();
	}

	/**
	* Sets the primary key of this degree.
	*
	* @param primaryKey the primary key of this degree
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_degree.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the degree ID of this degree.
	*
	* @return the degree ID of this degree
	*/
	@Override
	public long getDegreeId() {
		return _degree.getDegreeId();
	}

	/**
	* Sets the degree ID of this degree.
	*
	* @param degreeId the degree ID of this degree
	*/
	@Override
	public void setDegreeId(long degreeId) {
		_degree.setDegreeId(degreeId);
	}

	/**
	* Returns the degree name of this degree.
	*
	* @return the degree name of this degree
	*/
	@Override
	public java.lang.String getDegreeName() {
		return _degree.getDegreeName();
	}

	/**
	* Sets the degree name of this degree.
	*
	* @param degreeName the degree name of this degree
	*/
	@Override
	public void setDegreeName(java.lang.String degreeName) {
		_degree.setDegreeName(degreeName);
	}

	@Override
	public boolean isNew() {
		return _degree.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_degree.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _degree.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_degree.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _degree.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _degree.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_degree.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _degree.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_degree.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_degree.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_degree.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DegreeWrapper((Degree)_degree.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Degree degree) {
		return _degree.compareTo(degree);
	}

	@Override
	public int hashCode() {
		return _degree.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Degree> toCacheModel() {
		return _degree.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Degree toEscapedModel() {
		return new DegreeWrapper(_degree.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Degree toUnescapedModel() {
		return new DegreeWrapper(_degree.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _degree.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _degree.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_degree.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DegreeWrapper)) {
			return false;
		}

		DegreeWrapper degreeWrapper = (DegreeWrapper)obj;

		if (Validator.equals(_degree, degreeWrapper._degree)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Degree getWrappedDegree() {
		return _degree;
	}

	@Override
	public Degree getWrappedModel() {
		return _degree;
	}

	@Override
	public void resetOriginalValues() {
		_degree.resetOriginalValues();
	}

	private Degree _degree;
}