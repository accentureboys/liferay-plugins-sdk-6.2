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
import com.liferay.sample.model.Degree;
import com.liferay.sample.service.base.DegreeLocalServiceBaseImpl;

/**
 * The implementation of the degree local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.DegreeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.base.DegreeLocalServiceBaseImpl
 * @see com.liferay.sample.service.DegreeLocalServiceUtil
 */
public class DegreeLocalServiceImpl extends DegreeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.sample.service.DegreeLocalServiceUtil} to access the degree local service.
	 */
	/**
	 * Get all degrees from Degree table
	 * 
	 * @return List degree list
	 * @throws SystemException
	 */
	public List<Degree> getAllDegrees() throws SystemException {
		return degreePersistence.findAll();
	}
}