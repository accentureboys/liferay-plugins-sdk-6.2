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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.ThesisServiceSoap}.
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.http.ThesisServiceSoap
 * @generated
 */
public class ThesisSoap implements Serializable {
	public static ThesisSoap toSoapModel(Thesis model) {
		ThesisSoap soapModel = new ThesisSoap();

		soapModel.setThesisId(model.getThesisId());
		soapModel.setThesisName(model.getThesisName());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ThesisSoap[] toSoapModels(Thesis[] models) {
		ThesisSoap[] soapModels = new ThesisSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThesisSoap[][] toSoapModels(Thesis[][] models) {
		ThesisSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThesisSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThesisSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThesisSoap[] toSoapModels(List<Thesis> models) {
		List<ThesisSoap> soapModels = new ArrayList<ThesisSoap>(models.size());

		for (Thesis model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThesisSoap[soapModels.size()]);
	}

	public ThesisSoap() {
	}

	public long getPrimaryKey() {
		return _thesisId;
	}

	public void setPrimaryKey(long pk) {
		setThesisId(pk);
	}

	public long getThesisId() {
		return _thesisId;
	}

	public void setThesisId(long thesisId) {
		_thesisId = thesisId;
	}

	public String getThesisName() {
		return _thesisName;
	}

	public void setThesisName(String thesisName) {
		_thesisName = thesisName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _thesisId;
	private String _thesisName;
	private long _userId;
}