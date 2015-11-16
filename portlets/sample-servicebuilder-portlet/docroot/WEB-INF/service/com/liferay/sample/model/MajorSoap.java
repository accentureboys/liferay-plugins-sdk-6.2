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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.MajorServiceSoap}.
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.http.MajorServiceSoap
 * @generated
 */
public class MajorSoap implements Serializable {
	public static MajorSoap toSoapModel(Major model) {
		MajorSoap soapModel = new MajorSoap();

		soapModel.setMajorId(model.getMajorId());
		soapModel.setMajorName(model.getMajorName());

		return soapModel;
	}

	public static MajorSoap[] toSoapModels(Major[] models) {
		MajorSoap[] soapModels = new MajorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MajorSoap[][] toSoapModels(Major[][] models) {
		MajorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MajorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MajorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MajorSoap[] toSoapModels(List<Major> models) {
		List<MajorSoap> soapModels = new ArrayList<MajorSoap>(models.size());

		for (Major model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MajorSoap[soapModels.size()]);
	}

	public MajorSoap() {
	}

	public long getPrimaryKey() {
		return _majorId;
	}

	public void setPrimaryKey(long pk) {
		setMajorId(pk);
	}

	public long getMajorId() {
		return _majorId;
	}

	public void setMajorId(long majorId) {
		_majorId = majorId;
	}

	public String getMajorName() {
		return _majorName;
	}

	public void setMajorName(String majorName) {
		_majorName = majorName;
	}

	private long _majorId;
	private String _majorName;
}