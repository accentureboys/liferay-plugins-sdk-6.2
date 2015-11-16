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
 * This class is a wrapper for {@link Education}.
 * </p>
 *
 * @author jasonxiang
 * @see Education
 * @generated
 */
public class EducationWrapper implements Education, ModelWrapper<Education> {
	public EducationWrapper(Education education) {
		_education = education;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("educationId", getEducationId());
		attributes.put("userId", getUserId());
		attributes.put("schoolName", getSchoolName());
		attributes.put("degreeId", getDegreeId());
		attributes.put("majorId", getMajorId());
		attributes.put("graduateYear", getGraduateYear());

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

		Long majorId = (Long)attributes.get("majorId");

		if (majorId != null) {
			setMajorId(majorId);
		}

		String graduateYear = (String)attributes.get("graduateYear");

		if (graduateYear != null) {
			setGraduateYear(graduateYear);
		}
	}

	/**
	* Returns the primary key of this education.
	*
	* @return the primary key of this education
	*/
	@Override
	public long getPrimaryKey() {
		return _education.getPrimaryKey();
	}

	/**
	* Sets the primary key of this education.
	*
	* @param primaryKey the primary key of this education
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_education.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the education ID of this education.
	*
	* @return the education ID of this education
	*/
	@Override
	public long getEducationId() {
		return _education.getEducationId();
	}

	/**
	* Sets the education ID of this education.
	*
	* @param educationId the education ID of this education
	*/
	@Override
	public void setEducationId(long educationId) {
		_education.setEducationId(educationId);
	}

	/**
	* Returns the user ID of this education.
	*
	* @return the user ID of this education
	*/
	@Override
	public long getUserId() {
		return _education.getUserId();
	}

	/**
	* Sets the user ID of this education.
	*
	* @param userId the user ID of this education
	*/
	@Override
	public void setUserId(long userId) {
		_education.setUserId(userId);
	}

	/**
	* Returns the user uuid of this education.
	*
	* @return the user uuid of this education
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _education.getUserUuid();
	}

	/**
	* Sets the user uuid of this education.
	*
	* @param userUuid the user uuid of this education
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_education.setUserUuid(userUuid);
	}

	/**
	* Returns the school name of this education.
	*
	* @return the school name of this education
	*/
	@Override
	public java.lang.String getSchoolName() {
		return _education.getSchoolName();
	}

	/**
	* Sets the school name of this education.
	*
	* @param schoolName the school name of this education
	*/
	@Override
	public void setSchoolName(java.lang.String schoolName) {
		_education.setSchoolName(schoolName);
	}

	/**
	* Returns the degree ID of this education.
	*
	* @return the degree ID of this education
	*/
	@Override
	public long getDegreeId() {
		return _education.getDegreeId();
	}

	/**
	* Sets the degree ID of this education.
	*
	* @param degreeId the degree ID of this education
	*/
	@Override
	public void setDegreeId(long degreeId) {
		_education.setDegreeId(degreeId);
	}

	/**
	* Returns the major ID of this education.
	*
	* @return the major ID of this education
	*/
	@Override
	public long getMajorId() {
		return _education.getMajorId();
	}

	/**
	* Sets the major ID of this education.
	*
	* @param majorId the major ID of this education
	*/
	@Override
	public void setMajorId(long majorId) {
		_education.setMajorId(majorId);
	}

	/**
	* Returns the graduate year of this education.
	*
	* @return the graduate year of this education
	*/
	@Override
	public java.lang.String getGraduateYear() {
		return _education.getGraduateYear();
	}

	/**
	* Sets the graduate year of this education.
	*
	* @param graduateYear the graduate year of this education
	*/
	@Override
	public void setGraduateYear(java.lang.String graduateYear) {
		_education.setGraduateYear(graduateYear);
	}

	@Override
	public boolean isNew() {
		return _education.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_education.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _education.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_education.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _education.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _education.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_education.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _education.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_education.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_education.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_education.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EducationWrapper((Education)_education.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Education education) {
		return _education.compareTo(education);
	}

	@Override
	public int hashCode() {
		return _education.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Education> toCacheModel() {
		return _education.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Education toEscapedModel() {
		return new EducationWrapper(_education.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Education toUnescapedModel() {
		return new EducationWrapper(_education.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _education.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _education.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_education.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EducationWrapper)) {
			return false;
		}

		EducationWrapper educationWrapper = (EducationWrapper)obj;

		if (Validator.equals(_education, educationWrapper._education)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Education getWrappedEducation() {
		return _education;
	}

	@Override
	public Education getWrappedModel() {
		return _education;
	}

	@Override
	public void resetOriginalValues() {
		_education.resetOriginalValues();
	}

	private Education _education;
}