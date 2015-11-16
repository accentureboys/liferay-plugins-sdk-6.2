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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Property service. Represents a row in the &quot;Sample_Property&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.sample.model.impl.PropertyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.sample.model.impl.PropertyImpl}.
 * </p>
 *
 * @author jasonxiang
 * @see Property
 * @see com.liferay.sample.model.impl.PropertyImpl
 * @see com.liferay.sample.model.impl.PropertyModelImpl
 * @generated
 */
public interface PropertyModel extends BaseModel<Property> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a property model instance should use the {@link Property} interface instead.
	 */

	/**
	 * Returns the primary key of this property.
	 *
	 * @return the primary key of this property
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this property.
	 *
	 * @param primaryKey the primary key of this property
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the property ID of this property.
	 *
	 * @return the property ID of this property
	 */
	public long getPropertyId();

	/**
	 * Sets the property ID of this property.
	 *
	 * @param propertyId the property ID of this property
	 */
	public void setPropertyId(long propertyId);

	/**
	 * Returns the property name of this property.
	 *
	 * @return the property name of this property
	 */
	@AutoEscape
	public String getPropertyName();

	/**
	 * Sets the property name of this property.
	 *
	 * @param propertyName the property name of this property
	 */
	public void setPropertyName(String propertyName);

	/**
	 * Returns the user ID of this property.
	 *
	 * @return the user ID of this property
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this property.
	 *
	 * @param userId the user ID of this property
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this property.
	 *
	 * @return the user uuid of this property
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this property.
	 *
	 * @param userUuid the user uuid of this property
	 */
	public void setUserUuid(String userUuid);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.liferay.sample.model.Property property);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.sample.model.Property> toCacheModel();

	@Override
	public com.liferay.sample.model.Property toEscapedModel();

	@Override
	public com.liferay.sample.model.Property toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}