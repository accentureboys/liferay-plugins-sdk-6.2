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
 * This class is a wrapper for {@link Honour}.
 * </p>
 *
 * @author jasonxiang
 * @see Honour
 * @generated
 */
public class HonourWrapper implements Honour, ModelWrapper<Honour> {
	public HonourWrapper(Honour honour) {
		_honour = honour;
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

	/**
	* Returns the primary key of this honour.
	*
	* @return the primary key of this honour
	*/
	@Override
	public long getPrimaryKey() {
		return _honour.getPrimaryKey();
	}

	/**
	* Sets the primary key of this honour.
	*
	* @param primaryKey the primary key of this honour
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_honour.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the honour ID of this honour.
	*
	* @return the honour ID of this honour
	*/
	@Override
	public long getHonourId() {
		return _honour.getHonourId();
	}

	/**
	* Sets the honour ID of this honour.
	*
	* @param honourId the honour ID of this honour
	*/
	@Override
	public void setHonourId(long honourId) {
		_honour.setHonourId(honourId);
	}

	/**
	* Returns the honorary name of this honour.
	*
	* @return the honorary name of this honour
	*/
	@Override
	public java.lang.String getHonoraryName() {
		return _honour.getHonoraryName();
	}

	/**
	* Sets the honorary name of this honour.
	*
	* @param honoraryName the honorary name of this honour
	*/
	@Override
	public void setHonoraryName(java.lang.String honoraryName) {
		_honour.setHonoraryName(honoraryName);
	}

	/**
	* Returns the recommender of this honour.
	*
	* @return the recommender of this honour
	*/
	@Override
	public java.lang.String getRecommender() {
		return _honour.getRecommender();
	}

	/**
	* Sets the recommender of this honour.
	*
	* @param recommender the recommender of this honour
	*/
	@Override
	public void setRecommender(java.lang.String recommender) {
		_honour.setRecommender(recommender);
	}

	/**
	* Returns the introduction of this honour.
	*
	* @return the introduction of this honour
	*/
	@Override
	public java.lang.String getIntroduction() {
		return _honour.getIntroduction();
	}

	/**
	* Sets the introduction of this honour.
	*
	* @param introduction the introduction of this honour
	*/
	@Override
	public void setIntroduction(java.lang.String introduction) {
		_honour.setIntroduction(introduction);
	}

	/**
	* Returns the user ID of this honour.
	*
	* @return the user ID of this honour
	*/
	@Override
	public long getUserId() {
		return _honour.getUserId();
	}

	/**
	* Sets the user ID of this honour.
	*
	* @param userId the user ID of this honour
	*/
	@Override
	public void setUserId(long userId) {
		_honour.setUserId(userId);
	}

	/**
	* Returns the user uuid of this honour.
	*
	* @return the user uuid of this honour
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honour.getUserUuid();
	}

	/**
	* Sets the user uuid of this honour.
	*
	* @param userUuid the user uuid of this honour
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_honour.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _honour.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_honour.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _honour.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_honour.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _honour.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _honour.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_honour.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _honour.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_honour.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_honour.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_honour.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HonourWrapper((Honour)_honour.clone());
	}

	@Override
	public int compareTo(com.liferay.sample.model.Honour honour) {
		return _honour.compareTo(honour);
	}

	@Override
	public int hashCode() {
		return _honour.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Honour> toCacheModel() {
		return _honour.toCacheModel();
	}

	@Override
	public com.liferay.sample.model.Honour toEscapedModel() {
		return new HonourWrapper(_honour.toEscapedModel());
	}

	@Override
	public com.liferay.sample.model.Honour toUnescapedModel() {
		return new HonourWrapper(_honour.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _honour.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _honour.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_honour.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HonourWrapper)) {
			return false;
		}

		HonourWrapper honourWrapper = (HonourWrapper)obj;

		if (Validator.equals(_honour, honourWrapper._honour)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Honour getWrappedHonour() {
		return _honour;
	}

	@Override
	public Honour getWrappedModel() {
		return _honour;
	}

	@Override
	public void resetOriginalValues() {
		_honour.resetOriginalValues();
	}

	private Honour _honour;
}