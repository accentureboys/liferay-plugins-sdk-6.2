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

import com.liferay.sample.model.Thesis;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Thesis in entity cache.
 *
 * @author jasonxiang
 * @see Thesis
 * @generated
 */
public class ThesisCacheModel implements CacheModel<Thesis>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{thesisId=");
		sb.append(thesisId);
		sb.append(", thesisName=");
		sb.append(thesisName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Thesis toEntityModel() {
		ThesisImpl thesisImpl = new ThesisImpl();

		thesisImpl.setThesisId(thesisId);

		if (thesisName == null) {
			thesisImpl.setThesisName(StringPool.BLANK);
		}
		else {
			thesisImpl.setThesisName(thesisName);
		}

		thesisImpl.setUserId(userId);

		thesisImpl.resetOriginalValues();

		return thesisImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		thesisId = objectInput.readLong();
		thesisName = objectInput.readUTF();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(thesisId);

		if (thesisName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(thesisName);
		}

		objectOutput.writeLong(userId);
	}

	public long thesisId;
	public String thesisName;
	public long userId;
}