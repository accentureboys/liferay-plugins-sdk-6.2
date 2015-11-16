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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.PropertyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonxiang
 */
public class PropertyClp extends BaseModelImpl<Property> implements Property {
	public PropertyClp() {
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
	public long getPrimaryKey() {
		return _propertyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPropertyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _propertyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getPropertyId() {
		return _propertyId;
	}

	@Override
	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;

		if (_propertyRemoteModel != null) {
			try {
				Class<?> clazz = _propertyRemoteModel.getClass();

				Method method = clazz.getMethod("setPropertyId", long.class);

				method.invoke(_propertyRemoteModel, propertyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPropertyName() {
		return _propertyName;
	}

	@Override
	public void setPropertyName(String propertyName) {
		_propertyName = propertyName;

		if (_propertyRemoteModel != null) {
			try {
				Class<?> clazz = _propertyRemoteModel.getClass();

				Method method = clazz.getMethod("setPropertyName", String.class);

				method.invoke(_propertyRemoteModel, propertyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_propertyRemoteModel != null) {
			try {
				Class<?> clazz = _propertyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_propertyRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getPropertyRemoteModel() {
		return _propertyRemoteModel;
	}

	public void setPropertyRemoteModel(BaseModel<?> propertyRemoteModel) {
		_propertyRemoteModel = propertyRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _propertyRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_propertyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PropertyLocalServiceUtil.addProperty(this);
		}
		else {
			PropertyLocalServiceUtil.updateProperty(this);
		}
	}

	@Override
	public Property toEscapedModel() {
		return (Property)ProxyUtil.newProxyInstance(Property.class.getClassLoader(),
			new Class[] { Property.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PropertyClp clone = new PropertyClp();

		clone.setPropertyId(getPropertyId());
		clone.setPropertyName(getPropertyName());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Property property) {
		long primaryKey = property.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PropertyClp)) {
			return false;
		}

		PropertyClp property = (PropertyClp)obj;

		long primaryKey = property.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{propertyId=");
		sb.append(getPropertyId());
		sb.append(", propertyName=");
		sb.append(getPropertyName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Property");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>propertyId</column-name><column-value><![CDATA[");
		sb.append(getPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propertyName</column-name><column-value><![CDATA[");
		sb.append(getPropertyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _propertyId;
	private String _propertyName;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _propertyRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}