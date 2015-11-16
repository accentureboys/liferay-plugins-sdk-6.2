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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.HonourServiceSoap}.
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.http.HonourServiceSoap
 * @generated
 */
public class HonourSoap implements Serializable {
	public static HonourSoap toSoapModel(Honour model) {
		HonourSoap soapModel = new HonourSoap();

		soapModel.setHonourId(model.getHonourId());
		soapModel.setHonoraryName(model.getHonoraryName());
		soapModel.setRecommender(model.getRecommender());
		soapModel.setIntroduction(model.getIntroduction());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static HonourSoap[] toSoapModels(Honour[] models) {
		HonourSoap[] soapModels = new HonourSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HonourSoap[][] toSoapModels(Honour[][] models) {
		HonourSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HonourSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HonourSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HonourSoap[] toSoapModels(List<Honour> models) {
		List<HonourSoap> soapModels = new ArrayList<HonourSoap>(models.size());

		for (Honour model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HonourSoap[soapModels.size()]);
	}

	public HonourSoap() {
	}

	public long getPrimaryKey() {
		return _honourId;
	}

	public void setPrimaryKey(long pk) {
		setHonourId(pk);
	}

	public long getHonourId() {
		return _honourId;
	}

	public void setHonourId(long honourId) {
		_honourId = honourId;
	}

	public String getHonoraryName() {
		return _honoraryName;
	}

	public void setHonoraryName(String honoraryName) {
		_honoraryName = honoraryName;
	}

	public String getRecommender() {
		return _recommender;
	}

	public void setRecommender(String recommender) {
		_recommender = recommender;
	}

	public String getIntroduction() {
		return _introduction;
	}

	public void setIntroduction(String introduction) {
		_introduction = introduction;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _honourId;
	private String _honoraryName;
	private String _recommender;
	private String _introduction;
	private long _userId;
}