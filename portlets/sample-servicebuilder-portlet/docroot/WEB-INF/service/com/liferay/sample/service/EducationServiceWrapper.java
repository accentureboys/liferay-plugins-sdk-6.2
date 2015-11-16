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

package com.liferay.sample.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EducationService}.
 *
 * @author jasonxiang
 * @see EducationService
 * @generated
 */
public class EducationServiceWrapper implements EducationService,
	ServiceWrapper<EducationService> {
	public EducationServiceWrapper(EducationService educationService) {
		_educationService = educationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _educationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_educationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _educationService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EducationService getWrappedEducationService() {
		return _educationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEducationService(EducationService educationService) {
		_educationService = educationService;
	}

	@Override
	public EducationService getWrappedService() {
		return _educationService;
	}

	@Override
	public void setWrappedService(EducationService educationService) {
		_educationService = educationService;
	}

	private EducationService _educationService;
}