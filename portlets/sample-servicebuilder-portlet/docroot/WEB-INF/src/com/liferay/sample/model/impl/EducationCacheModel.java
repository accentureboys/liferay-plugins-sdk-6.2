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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.Education;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Education in entity cache.
 *
 * @author jasonxiang
 * @see Education
 * @generated
 */
public class EducationCacheModel implements CacheModel<Education>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{educationId=");
		sb.append(educationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", schoolName=");
		sb.append(schoolName);
		sb.append(", degreeId=");
		sb.append(degreeId);
		sb.append(", majorId=");
		sb.append(majorId);
		sb.append(", graduateYear=");
		sb.append(graduateYear);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Education toEntityModel() {
		EducationImpl educationImpl = new EducationImpl();

		educationImpl.setEducationId(educationId);
		educationImpl.setUserId(userId);

		if (schoolName == null) {
			educationImpl.setSchoolName(StringPool.BLANK);
		}
		else {
			educationImpl.setSchoolName(schoolName);
		}

		educationImpl.setDegreeId(degreeId);
		educationImpl.setMajorId(majorId);

		if (graduateYear == null) {
			educationImpl.setGraduateYear(StringPool.BLANK);
		}
		else {
			educationImpl.setGraduateYear(graduateYear);
		}

		educationImpl.resetOriginalValues();

		return educationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		educationId = objectInput.readLong();
		userId = objectInput.readLong();
		schoolName = objectInput.readUTF();
		degreeId = objectInput.readLong();
		majorId = objectInput.readLong();
		graduateYear = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(educationId);
		objectOutput.writeLong(userId);

		if (schoolName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schoolName);
		}

		objectOutput.writeLong(degreeId);
		objectOutput.writeLong(majorId);

		if (graduateYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(graduateYear);
		}
	}

	public long educationId;
	public long userId;
	public String schoolName;
	public long degreeId;
	public long majorId;
	public String graduateYear;
}