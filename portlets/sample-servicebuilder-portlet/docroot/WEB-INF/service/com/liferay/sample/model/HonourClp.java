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
import com.liferay.sample.service.HonourLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonxiang
 */
public class HonourClp extends BaseModelImpl<Honour> implements Honour {
	public HonourClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Honour.class;
	}

	@Override
	public String getModelClassName() {
		return Honour.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _honourId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHonourId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _honourId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("honourId", getHonourId());
		attributes.put("honoraryName", getHonoraryName());
		attributes.put("recommender", getRecommender());
		attributes.put("introduction", getIntroduction());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long honourId = (Long)attributes.get("honourId");

		if (honourId != null) {
			setHonourId(honourId);
		}

		String honoraryName = (String)attributes.get("honoraryName");

		if (honoraryName != null) {
			setHonoraryName(honoraryName);
		}

		String recommender = (String)attributes.get("recommender");

		if (recommender != null) {
			setRecommender(recommender);
		}

		String introduction = (String)attributes.get("introduction");

		if (introduction != null) {
			setIntroduction(introduction);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getHonourId() {
		return _honourId;
	}

	@Override
	public void setHonourId(long honourId) {
		_honourId = honourId;

		if (_honourRemoteModel != null) {
			try {
				Class<?> clazz = _honourRemoteModel.getClass();

				Method method = clazz.getMethod("setHonourId", long.class);

				method.invoke(_honourRemoteModel, honourId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHonoraryName() {
		return _honoraryName;
	}

	@Override
	public void setHonoraryName(String honoraryName) {
		_honoraryName = honoraryName;

		if (_honourRemoteModel != null) {
			try {
				Class<?> clazz = _honourRemoteModel.getClass();

				Method method = clazz.getMethod("setHonoraryName", String.class);

				method.invoke(_honourRemoteModel, honoraryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRecommender() {
		return _recommender;
	}

	@Override
	public void setRecommender(String recommender) {
		_recommender = recommender;

		if (_honourRemoteModel != null) {
			try {
				Class<?> clazz = _honourRemoteModel.getClass();

				Method method = clazz.getMethod("setRecommender", String.class);

				method.invoke(_honourRemoteModel, recommender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntroduction() {
		return _introduction;
	}

	@Override
	public void setIntroduction(String introduction) {
		_introduction = introduction;

		if (_honourRemoteModel != null) {
			try {
				Class<?> clazz = _honourRemoteModel.getClass();

				Method method = clazz.getMethod("setIntroduction", String.class);

				method.invoke(_honourRemoteModel, introduction);
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

		if (_honourRemoteModel != null) {
			try {
				Class<?> clazz = _honourRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_honourRemoteModel, userId);
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

	public BaseModel<?> getHonourRemoteModel() {
		return _honourRemoteModel;
	}

	public void setHonourRemoteModel(BaseModel<?> honourRemoteModel) {
		_honourRemoteModel = honourRemoteModel;
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

		Class<?> remoteModelClass = _honourRemoteModel.getClass();

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

		Object returnValue = method.invoke(_honourRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HonourLocalServiceUtil.addHonour(this);
		}
		else {
			HonourLocalServiceUtil.updateHonour(this);
		}
	}

	@Override
	public Honour toEscapedModel() {
		return (Honour)ProxyUtil.newProxyInstance(Honour.class.getClassLoader(),
			new Class[] { Honour.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HonourClp clone = new HonourClp();

		clone.setHonourId(getHonourId());
		clone.setHonoraryName(getHonoraryName());
		clone.setRecommender(getRecommender());
		clone.setIntroduction(getIntroduction());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Honour honour) {
		long primaryKey = honour.getPrimaryKey();

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

		if (!(obj instanceof HonourClp)) {
			return false;
		}

		HonourClp honour = (HonourClp)obj;

		long primaryKey = honour.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{honourId=");
		sb.append(getHonourId());
		sb.append(", honoraryName=");
		sb.append(getHonoraryName());
		sb.append(", recommender=");
		sb.append(getRecommender());
		sb.append(", introduction=");
		sb.append(getIntroduction());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Honour");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>honourId</column-name><column-value><![CDATA[");
		sb.append(getHonourId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>honoraryName</column-name><column-value><![CDATA[");
		sb.append(getHonoraryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommender</column-name><column-value><![CDATA[");
		sb.append(getRecommender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>introduction</column-name><column-value><![CDATA[");
		sb.append(getIntroduction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _honourId;
	private String _honoraryName;
	private String _recommender;
	private String _introduction;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _honourRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}