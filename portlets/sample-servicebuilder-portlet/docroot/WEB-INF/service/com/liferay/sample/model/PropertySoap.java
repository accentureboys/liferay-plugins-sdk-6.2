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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.PropertyServiceSoap}.
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.http.PropertyServiceSoap
 * @generated
 */
public class PropertySoap implements Serializable {
	public static PropertySoap toSoapModel(Property model) {
		PropertySoap soapModel = new PropertySoap();

		soapModel.setPropertyId(model.getPropertyId());
		soapModel.setPropertyName(model.getPropertyName());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static PropertySoap[] toSoapModels(Property[] models) {
		PropertySoap[] soapModels = new PropertySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PropertySoap[][] toSoapModels(Property[][] models) {
		PropertySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PropertySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PropertySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PropertySoap[] toSoapModels(List<Property> models) {
		List<PropertySoap> soapModels = new ArrayList<PropertySoap>(models.size());

		for (Property model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PropertySoap[soapModels.size()]);
	}

	public PropertySoap() {
	}

	public long getPrimaryKey() {
		return _propertyId;
	}

	public void setPrimaryKey(long pk) {
		setPropertyId(pk);
	}

	public long getPropertyId() {
		return _propertyId;
	}

	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	public String getPropertyName() {
		return _propertyName;
	}

	public void setPropertyName(String propertyName) {
		_propertyName = propertyName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _propertyId;
	private String _propertyName;
	private long _userId;
}