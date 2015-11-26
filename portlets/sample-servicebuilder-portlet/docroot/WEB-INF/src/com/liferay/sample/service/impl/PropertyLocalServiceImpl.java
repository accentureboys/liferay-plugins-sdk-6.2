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
import com.liferay.sample.model.Property;
import com.liferay.sample.service.base.PropertyLocalServiceBaseImpl;

/**
 * The implementation of the property local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.PropertyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.base.PropertyLocalServiceBaseImpl
 * @see com.liferay.sample.service.PropertyLocalServiceUtil
 */
public class PropertyLocalServiceImpl extends PropertyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.PropertyLocalServiceUtil} to access the property local service.
	 */
	/**
	 * Get property list by userId
	 * 
	 * @param userId the user id
	 * @return property list
	 */
	public List<Property> getPropertyListByUserId(long userId) {
		try {
			return propertyPersistence.findByuserId(userId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Remove property list by user id
	 * 
	 * @param userId long userId
	 * @throws SystemException
	 */
	public void removePropertyListByUserId(long userId) throws SystemException {
		propertyPersistence.removeByuserId(userId);
	}
}