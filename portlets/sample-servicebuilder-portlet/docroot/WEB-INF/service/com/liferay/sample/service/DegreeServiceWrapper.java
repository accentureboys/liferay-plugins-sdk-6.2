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
 * Provides a wrapper for {@link DegreeService}.
 *
 * @author jasonxiang
 * @see DegreeService
 * @generated
 */
public class DegreeServiceWrapper implements DegreeService,
	ServiceWrapper<DegreeService> {
	public DegreeServiceWrapper(DegreeService degreeService) {
		_degreeService = degreeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _degreeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_degreeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _degreeService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DegreeService getWrappedDegreeService() {
		return _degreeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDegreeService(DegreeService degreeService) {
		_degreeService = degreeService;
	}

	@Override
	public DegreeService getWrappedService() {
		return _degreeService;
	}

	@Override
	public void setWrappedService(DegreeService degreeService) {
		_degreeService = degreeService;
	}

	private DegreeService _degreeService;
}