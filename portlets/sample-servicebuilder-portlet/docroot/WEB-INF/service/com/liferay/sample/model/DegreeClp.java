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

import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.DegreeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonxiang
 */
public class DegreeClp extends BaseModelImpl<Degree> implements Degree {
	public DegreeClp() {
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
	public long getPrimaryKey() {
		return _degreeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDegreeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _degreeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDegreeId() {
		return _degreeId;
	}

	@Override
	public void setDegreeId(long degreeId) {
		_degreeId = degreeId;

		if (_degreeRemoteModel != null) {
			try {
				Class<?> clazz = _degreeRemoteModel.getClass();

				Method method = clazz.getMethod("setDegreeId", long.class);

				method.invoke(_degreeRemoteModel, degreeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDegreeName() {
		return _degreeName;
	}

	@Override
	public void setDegreeName(String degreeName) {
		_degreeName = degreeName;

		if (_degreeRemoteModel != null) {
			try {
				Class<?> clazz = _degreeRemoteModel.getClass();

				Method method = clazz.getMethod("setDegreeName", String.class);

				method.invoke(_degreeRemoteModel, degreeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDegreeRemoteModel() {
		return _degreeRemoteModel;
	}

	public void setDegreeRemoteModel(BaseModel<?> degreeRemoteModel) {
		_degreeRemoteModel = degreeRemoteModel;
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

		Class<?> remoteModelClass = _degreeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_degreeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DegreeLocalServiceUtil.addDegree(this);
		}
		else {
			DegreeLocalServiceUtil.updateDegree(this);
		}
	}

	@Override
	public Degree toEscapedModel() {
		return (Degree)ProxyUtil.newProxyInstance(Degree.class.getClassLoader(),
			new Class[] { Degree.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DegreeClp clone = new DegreeClp();

		clone.setDegreeId(getDegreeId());
		clone.setDegreeName(getDegreeName());

		return clone;
	}

	@Override
	public int compareTo(Degree degree) {
		long primaryKey = degree.getPrimaryKey();

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

		if (!(obj instanceof DegreeClp)) {
			return false;
		}

		DegreeClp degree = (DegreeClp)obj;

		long primaryKey = degree.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{degreeId=");
		sb.append(getDegreeId());
		sb.append(", degreeName=");
		sb.append(getDegreeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Degree");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>degreeId</column-name><column-value><![CDATA[");
		sb.append(getDegreeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>degreeName</column-name><column-value><![CDATA[");
		sb.append(getDegreeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _degreeId;
	private String _degreeName;
	private BaseModel<?> _degreeRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}