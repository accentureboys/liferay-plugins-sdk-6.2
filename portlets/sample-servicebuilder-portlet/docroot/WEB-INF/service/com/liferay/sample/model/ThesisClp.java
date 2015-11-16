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
import com.liferay.sample.service.ThesisLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonxiang
 */
public class ThesisClp extends BaseModelImpl<Thesis> implements Thesis {
	public ThesisClp() {
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
	public long getPrimaryKey() {
		return _thesisId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setThesisId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _thesisId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getThesisId() {
		return _thesisId;
	}

	@Override
	public void setThesisId(long thesisId) {
		_thesisId = thesisId;

		if (_thesisRemoteModel != null) {
			try {
				Class<?> clazz = _thesisRemoteModel.getClass();

				Method method = clazz.getMethod("setThesisId", long.class);

				method.invoke(_thesisRemoteModel, thesisId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getThesisName() {
		return _thesisName;
	}

	@Override
	public void setThesisName(String thesisName) {
		_thesisName = thesisName;

		if (_thesisRemoteModel != null) {
			try {
				Class<?> clazz = _thesisRemoteModel.getClass();

				Method method = clazz.getMethod("setThesisName", String.class);

				method.invoke(_thesisRemoteModel, thesisName);
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

		if (_thesisRemoteModel != null) {
			try {
				Class<?> clazz = _thesisRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_thesisRemoteModel, userId);
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

	public BaseModel<?> getThesisRemoteModel() {
		return _thesisRemoteModel;
	}

	public void setThesisRemoteModel(BaseModel<?> thesisRemoteModel) {
		_thesisRemoteModel = thesisRemoteModel;
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

		Class<?> remoteModelClass = _thesisRemoteModel.getClass();

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

		Object returnValue = method.invoke(_thesisRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ThesisLocalServiceUtil.addThesis(this);
		}
		else {
			ThesisLocalServiceUtil.updateThesis(this);
		}
	}

	@Override
	public Thesis toEscapedModel() {
		return (Thesis)ProxyUtil.newProxyInstance(Thesis.class.getClassLoader(),
			new Class[] { Thesis.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ThesisClp clone = new ThesisClp();

		clone.setThesisId(getThesisId());
		clone.setThesisName(getThesisName());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Thesis thesis) {
		long primaryKey = thesis.getPrimaryKey();

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

		if (!(obj instanceof ThesisClp)) {
			return false;
		}

		ThesisClp thesis = (ThesisClp)obj;

		long primaryKey = thesis.getPrimaryKey();

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

		sb.append("{thesisId=");
		sb.append(getThesisId());
		sb.append(", thesisName=");
		sb.append(getThesisName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Thesis");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>thesisId</column-name><column-value><![CDATA[");
		sb.append(getThesisId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thesisName</column-name><column-value><![CDATA[");
		sb.append(getThesisName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _thesisId;
	private String _thesisName;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _thesisRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}