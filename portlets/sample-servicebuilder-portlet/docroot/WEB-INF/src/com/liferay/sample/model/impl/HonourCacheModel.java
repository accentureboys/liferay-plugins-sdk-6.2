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

import com.liferay.sample.model.Honour;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Honour in entity cache.
 *
 * @author jasonxiang
 * @see Honour
 * @generated
 */
public class HonourCacheModel implements CacheModel<Honour>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{honourId=");
		sb.append(honourId);
		sb.append(", honoraryName=");
		sb.append(honoraryName);
		sb.append(", recommender=");
		sb.append(recommender);
		sb.append(", introduction=");
		sb.append(introduction);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Honour toEntityModel() {
		HonourImpl honourImpl = new HonourImpl();

		honourImpl.setHonourId(honourId);

		if (honoraryName == null) {
			honourImpl.setHonoraryName(StringPool.BLANK);
		}
		else {
			honourImpl.setHonoraryName(honoraryName);
		}

		if (recommender == null) {
			honourImpl.setRecommender(StringPool.BLANK);
		}
		else {
			honourImpl.setRecommender(recommender);
		}

		if (introduction == null) {
			honourImpl.setIntroduction(StringPool.BLANK);
		}
		else {
			honourImpl.setIntroduction(introduction);
		}

		honourImpl.setUserId(userId);

		honourImpl.resetOriginalValues();

		return honourImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		honourId = objectInput.readLong();
		honoraryName = objectInput.readUTF();
		recommender = objectInput.readUTF();
		introduction = objectInput.readUTF();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(honourId);

		if (honoraryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(honoraryName);
		}

		if (recommender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recommender);
		}

		if (introduction == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(introduction);
		}

		objectOutput.writeLong(userId);
	}

	public long honourId;
	public String honoraryName;
	public String recommender;
	public String introduction;
	public long userId;
}