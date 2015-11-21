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
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.service.http.EducationServiceSoap}.
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.http.EducationServiceSoap
 * @generated
 */
public class EducationSoap implements Serializable {
	public static EducationSoap toSoapModel(Education model) {
		EducationSoap soapModel = new EducationSoap();

		soapModel.setEducationId(model.getEducationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSchoolName(model.getSchoolName());
		soapModel.setDegreeId(model.getDegreeId());
		soapModel.setGraduateYear(model.getGraduateYear());
		soapModel.setRecommender(model.getRecommender());
		soapModel.setIntroduction(model.getIntroduction());

		return soapModel;
	}

	public static EducationSoap[] toSoapModels(Education[] models) {
		EducationSoap[] soapModels = new EducationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EducationSoap[][] toSoapModels(Education[][] models) {
		EducationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EducationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EducationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EducationSoap[] toSoapModels(List<Education> models) {
		List<EducationSoap> soapModels = new ArrayList<EducationSoap>(models.size());

		for (Education model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EducationSoap[soapModels.size()]);
	}

	public EducationSoap() {
	}

	public long getPrimaryKey() {
		return _educationId;
	}

	public void setPrimaryKey(long pk) {
		setEducationId(pk);
	}

	public long getEducationId() {
		return _educationId;
	}

	public void setEducationId(long educationId) {
		_educationId = educationId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getSchoolName() {
		return _schoolName;
	}

	public void setSchoolName(String schoolName) {
		_schoolName = schoolName;
	}

	public long getDegreeId() {
		return _degreeId;
	}

	public void setDegreeId(long degreeId) {
		_degreeId = degreeId;
	}

	public String getGraduateYear() {
		return _graduateYear;
	}

	public void setGraduateYear(String graduateYear) {
		_graduateYear = graduateYear;
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

	private long _educationId;
	private long _userId;
	private String _schoolName;
	private long _degreeId;
	private String _graduateYear;
	private String _recommender;
	private String _introduction;
}