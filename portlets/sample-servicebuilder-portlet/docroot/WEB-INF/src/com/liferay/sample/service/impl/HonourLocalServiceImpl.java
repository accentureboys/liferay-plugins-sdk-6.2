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

package com.liferay.sample.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.sample.model.Honour;
import com.liferay.sample.service.base.HonourLocalServiceBaseImpl;

/**
 * The implementation of the honour local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.HonourLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.base.HonourLocalServiceBaseImpl
 * @see com.liferay.sample.service.HonourLocalServiceUtil
 */
public class HonourLocalServiceImpl extends HonourLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.HonourLocalServiceUtil} to access the honour local service.
	 */
	/**
	 * Get honour list by user id
	 * 
	 * @param userId the user id
	 * @return Honour list
	 */
	public List<Honour> getHonourListByUserId(long userId) {
		try {
			return honourPersistence.findByuserId(userId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Remove honour list by user id
	 * 
	 * @param userId long userId
	 * @throws SystemException
	 */
	public void removeHonourListByUserId(long userId) throws SystemException{
		honourPersistence.removeByuserId(userId);
	}
}