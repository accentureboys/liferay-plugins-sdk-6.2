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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.DegreeServiceSoap}.
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.http.DegreeServiceSoap
 * @generated
 */
public class DegreeSoap implements Serializable {
	public static DegreeSoap toSoapModel(Degree model) {
		DegreeSoap soapModel = new DegreeSoap();

		soapModel.setDegreeId(model.getDegreeId());
		soapModel.setDegreeName(model.getDegreeName());

		return soapModel;
	}

	public static DegreeSoap[] toSoapModels(Degree[] models) {
		DegreeSoap[] soapModels = new DegreeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DegreeSoap[][] toSoapModels(Degree[][] models) {
		DegreeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DegreeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DegreeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DegreeSoap[] toSoapModels(List<Degree> models) {
		List<DegreeSoap> soapModels = new ArrayList<DegreeSoap>(models.size());

		for (Degree model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DegreeSoap[soapModels.size()]);
	}

	public DegreeSoap() {
	}

	public long getPrimaryKey() {
		return _degreeId;
	}

	public void setPrimaryKey(long pk) {
		setDegreeId(pk);
	}

	public long getDegreeId() {
		return _degreeId;
	}

	public void setDegreeId(long degreeId) {
		_degreeId = degreeId;
	}

	public String getDegreeName() {
		return _degreeName;
	}

	public void setDegreeName(String degreeName) {
		_degreeName = degreeName;
	}

	private long _degreeId;
	private String _degreeName;
}