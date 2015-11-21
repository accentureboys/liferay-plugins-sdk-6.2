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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.sample.model.Education;
import com.liferay.sample.service.base.EducationLocalServiceBaseImpl;
import com.liferay.sample.service.persistence.EducationPersistence;
import com.liferay.sample.service.persistence.EducationPersistenceImpl;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * The implementation of the education local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.EducationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.base.EducationLocalServiceBaseImpl
 * @see com.liferay.sample.service.EducationLocalServiceUtil
 */
public class EducationLocalServiceImpl extends EducationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.EducationLocalServiceUtil} to access the education local service.
	 */
	/**
	 * Get education object by userId
	 * 
	 * @param userId the user id	
	 * @return Education object
	 */
	public Education getEducationByUserId(long userId) {
		try {
			return educationPersistence.fetchByuserId(userId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}