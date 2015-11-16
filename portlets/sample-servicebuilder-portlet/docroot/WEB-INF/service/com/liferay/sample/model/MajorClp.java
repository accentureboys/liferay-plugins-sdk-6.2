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
import com.liferay.sample.service.MajorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonxiang
 */
public class MajorClp extends BaseModelImpl<Major> implements Major {
	public MajorClp() {
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
	public long getPrimaryKey() {
		return _majorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMajorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _majorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getMajorId() {
		return _majorId;
	}

	@Override
	public void setMajorId(long majorId) {
		_majorId = majorId;

		if (_majorRemoteModel != null) {
			try {
				Class<?> clazz = _majorRemoteModel.getClass();

				Method method = clazz.getMethod("setMajorId", long.class);

				method.invoke(_majorRemoteModel, majorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMajorName() {
		return _majorName;
	}

	@Override
	public void setMajorName(String majorName) {
		_majorName = majorName;

		if (_majorRemoteModel != null) {
			try {
				Class<?> clazz = _majorRemoteModel.getClass();

				Method method = clazz.getMethod("setMajorName", String.class);

				method.invoke(_majorRemoteModel, majorName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMajorRemoteModel() {
		return _majorRemoteModel;
	}

	public void setMajorRemoteModel(BaseModel<?> majorRemoteModel) {
		_majorRemoteModel = majorRemoteModel;
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

		Class<?> remoteModelClass = _majorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_majorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MajorLocalServiceUtil.addMajor(this);
		}
		else {
			MajorLocalServiceUtil.updateMajor(this);
		}
	}

	@Override
	public Major toEscapedModel() {
		return (Major)ProxyUtil.newProxyInstance(Major.class.getClassLoader(),
			new Class[] { Major.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MajorClp clone = new MajorClp();

		clone.setMajorId(getMajorId());
		clone.setMajorName(getMajorName());

		return clone;
	}

	@Override
	public int compareTo(Major major) {
		long primaryKey = major.getPrimaryKey();

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

		if (!(obj instanceof MajorClp)) {
			return false;
		}

		MajorClp major = (MajorClp)obj;

		long primaryKey = major.getPrimaryKey();

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

		sb.append("{majorId=");
		sb.append(getMajorId());
		sb.append(", majorName=");
		sb.append(getMajorName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Major");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>majorId</column-name><column-value><![CDATA[");
		sb.append(getMajorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>majorName</column-name><column-value><![CDATA[");
		sb.append(getMajorName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _majorId;
	private String _majorName;
	private BaseModel<?> _majorRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}