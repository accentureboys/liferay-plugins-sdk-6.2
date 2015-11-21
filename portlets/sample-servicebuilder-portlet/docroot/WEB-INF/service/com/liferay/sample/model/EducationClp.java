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
import com.liferay.sample.service.EducationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonxiang
 */
public class EducationClp extends BaseModelImpl<Education> implements Education {
	public EducationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Education.class;
	}

	@Override
	public String getModelClassName() {
		return Education.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _educationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEducationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _educationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("educationId", getEducationId());
		attributes.put("userId", getUserId());
		attributes.put("schoolName", getSchoolName());
		attributes.put("degreeId", getDegreeId());
		attributes.put("graduateYear", getGraduateYear());
		attributes.put("recommender", getRecommender());
		attributes.put("introduction", getIntroduction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long educationId = (Long)attributes.get("educationId");

		if (educationId != null) {
			setEducationId(educationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String schoolName = (String)attributes.get("schoolName");

		if (schoolName != null) {
			setSchoolName(schoolName);
		}

		Long degreeId = (Long)attributes.get("degreeId");

		if (degreeId != null) {
			setDegreeId(degreeId);
		}

		String graduateYear = (String)attributes.get("graduateYear");

		if (graduateYear != null) {
			setGraduateYear(graduateYear);
		}

		String recommender = (String)attributes.get("recommender");

		if (recommender != null) {
			setRecommender(recommender);
		}

		String introduction = (String)attributes.get("introduction");

		if (introduction != null) {
			setIntroduction(introduction);
		}
	}

	@Override
	public long getEducationId() {
		return _educationId;
	}

	@Override
	public void setEducationId(long educationId) {
		_educationId = educationId;

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setEducationId", long.class);

				method.invoke(_educationRemoteModel, educationId);
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

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_educationRemoteModel, userId);
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

	@Override
	public String getSchoolName() {
		return _schoolName;
	}

	@Override
	public void setSchoolName(String schoolName) {
		_schoolName = schoolName;

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setSchoolName", String.class);

				method.invoke(_educationRemoteModel, schoolName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDegreeId() {
		return _degreeId;
	}

	@Override
	public void setDegreeId(long degreeId) {
		_degreeId = degreeId;

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setDegreeId", long.class);

				method.invoke(_educationRemoteModel, degreeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGraduateYear() {
		return _graduateYear;
	}

	@Override
	public void setGraduateYear(String graduateYear) {
		_graduateYear = graduateYear;

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setGraduateYear", String.class);

				method.invoke(_educationRemoteModel, graduateYear);
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

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setRecommender", String.class);

				method.invoke(_educationRemoteModel, recommender);
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

		if (_educationRemoteModel != null) {
			try {
				Class<?> clazz = _educationRemoteModel.getClass();

				Method method = clazz.getMethod("setIntroduction", String.class);

				method.invoke(_educationRemoteModel, introduction);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEducationRemoteModel() {
		return _educationRemoteModel;
	}

	public void setEducationRemoteModel(BaseModel<?> educationRemoteModel) {
		_educationRemoteModel = educationRemoteModel;
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

		Class<?> remoteModelClass = _educationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_educationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EducationLocalServiceUtil.addEducation(this);
		}
		else {
			EducationLocalServiceUtil.updateEducation(this);
		}
	}

	@Override
	public Education toEscapedModel() {
		return (Education)ProxyUtil.newProxyInstance(Education.class.getClassLoader(),
			new Class[] { Education.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EducationClp clone = new EducationClp();

		clone.setEducationId(getEducationId());
		clone.setUserId(getUserId());
		clone.setSchoolName(getSchoolName());
		clone.setDegreeId(getDegreeId());
		clone.setGraduateYear(getGraduateYear());
		clone.setRecommender(getRecommender());
		clone.setIntroduction(getIntroduction());

		return clone;
	}

	@Override
	public int compareTo(Education education) {
		long primaryKey = education.getPrimaryKey();

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

		if (!(obj instanceof EducationClp)) {
			return false;
		}

		EducationClp education = (EducationClp)obj;

		long primaryKey = education.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{educationId=");
		sb.append(getEducationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", schoolName=");
		sb.append(getSchoolName());
		sb.append(", degreeId=");
		sb.append(getDegreeId());
		sb.append(", graduateYear=");
		sb.append(getGraduateYear());
		sb.append(", recommender=");
		sb.append(getRecommender());
		sb.append(", introduction=");
		sb.append(getIntroduction());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Education");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>educationId</column-name><column-value><![CDATA[");
		sb.append(getEducationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schoolName</column-name><column-value><![CDATA[");
		sb.append(getSchoolName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>degreeId</column-name><column-value><![CDATA[");
		sb.append(getDegreeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graduateYear</column-name><column-value><![CDATA[");
		sb.append(getGraduateYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommender</column-name><column-value><![CDATA[");
		sb.append(getRecommender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>introduction</column-name><column-value><![CDATA[");
		sb.append(getIntroduction());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _educationId;
	private long _userId;
	private String _userUuid;
	private String _schoolName;
	private long _degreeId;
	private String _graduateYear;
	private String _recommender;
	private String _introduction;
	private BaseModel<?> _educationRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.sample.service.ClpSerializer.class;
}