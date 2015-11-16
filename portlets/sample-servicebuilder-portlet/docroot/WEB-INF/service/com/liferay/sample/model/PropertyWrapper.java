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
 * This class is a wrapper for {@link Property}.
 * </p>
 *
 * @author jasonxiang
 * @see Property
 * @generated
 */
public class PropertyWrapper implements Property, ModelWrapper<Property> {
	public PropertyWrapper(Property property) {
		_property = property;
	}

	@Override
	public Class<?> getModelClass() {
		return Property.class;
	}

	@Override
	public String getModelClassName() {
		return Property.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("propertyName", getPropertyName());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		String propertyName = (String)attributes.get("propertyName");

		if (propertyName != null) {
			setPropertyName(propertyName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this property.
	*
	* @return the primary key of this property
	*/
	@Override
	public long getPrimaryKey() {
		return _property.getPrimaryKey();
	}

	/**
	* Sets the primary key of this property.
	*
	* @param primaryKey the primary key of this property
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_property.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the property ID of this property.
	*
	* @return the property ID of this property
	*/
	@Override
	public long getPropertyId() {
		return _property.getPropertyId();
	}

	/**
	* Sets the property ID of this property.
	*
	* @param propertyId the property ID of this property
	*/
	@Override
	public void setPropertyId(long propertyId) {
		_property.setPropertyId(propertyId);
	}

	/**
	* Returns the property name of this property.
	*
	* @return the property name of this property
	*/
	@Override
	public java.lang.String getPropertyName() {
		return _property.getPropertyName();
	}

	/**
	* Sets the property name of this property.
	*
	* @param propertyName the property name of this property
	*/
	@Override
	public void setPropertyName(java.lang.String propertyName) {
		_property.setPropertyName(propertyName);
	}

	/**
	* Returns the user ID of this property.
	*
	* @return the user ID of this property
	*/
	@Override
	public long getUserId() {
		return _property.getUserId();
	}

	/**
	* Sets the user ID of this property.
	*
	* @param userId the user ID of this property
	*/
	@Override
	public void setUserId(long userId) {
		_property.setUserId(userId);
	}

	/**
	* Returns the user uuid of this property.
	*
	* @return the user uuid of this property
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _property.getUserUuid();
	}

	/**
	* Sets the user uuid of this property.
	*
	* @param userUuid the user uuid of this property
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_property.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _property.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_property.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _property.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_property.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _property.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _property.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_property.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _property.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_property.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_property.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_property.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PropertyWrapper((Property)_property.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Property property) {
		return _property.compareTo(property);
	}

	@Override
	public int hashCode() {
		return _property.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Property> toCacheModel() {
		return _property.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Property toEscapedModel() {
		return new PropertyWrapper(_property.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Property toUnescapedModel() {
		return new PropertyWrapper(_property.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _property.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _property.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_property.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PropertyWrapper)) {
			return false;
		}

		PropertyWrapper propertyWrapper = (PropertyWrapper)obj;

		if (Validator.equals(_property, propertyWrapper._property)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Property getWrappedProperty() {
		return _property;
	}

	@Override
	public Property getWrappedModel() {
		return _property;
	}

	@Override
	public void resetOriginalValues() {
		_property.resetOriginalValues();
	}

	private Property _property;
}