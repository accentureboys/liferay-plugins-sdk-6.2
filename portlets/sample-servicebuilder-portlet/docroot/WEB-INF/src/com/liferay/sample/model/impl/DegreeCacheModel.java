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

import com.liferay.sample.model.Degree;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Degree in entity cache.
 *
 * @author jasonxiang
 * @see Degree
 * @generated
 */
public class DegreeCacheModel implements CacheModel<Degree>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{degreeId=");
		sb.append(degreeId);
		sb.append(", degreeName=");
		sb.append(degreeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Degree toEntityModel() {
		DegreeImpl degreeImpl = new DegreeImpl();

		degreeImpl.setDegreeId(degreeId);

		if (degreeName == null) {
			degreeImpl.setDegreeName(StringPool.BLANK);
		}
		else {
			degreeImpl.setDegreeName(degreeName);
		}

		degreeImpl.resetOriginalValues();

		return degreeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		degreeId = objectInput.readLong();
		degreeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(degreeId);

		if (degreeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(degreeName);
		}
	}

	public long degreeId;
	public String degreeName;
}