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
 * Provides a wrapper for {@link DegreeLocalService}.
 *
 * @author jasonxiang
 * @see DegreeLocalService
 * @generated
 */
public class DegreeLocalServiceWrapper implements DegreeLocalService,
	ServiceWrapper<DegreeLocalService> {
	public DegreeLocalServiceWrapper(DegreeLocalService degreeLocalService) {
		_degreeLocalService = degreeLocalService;
	}

	/**
	* Adds the degree to the database. Also notifies the appropriate model listeners.
	*
	* @param degree the degree
	* @return the degree that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Degree addDegree(
		com.liferay.sample.model.Degree degree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.addDegree(degree);
	}

	/**
	* Creates a new degree with the primary key. Does not add the degree to the database.
	*
	* @param degreeId the primary key for the new degree
	* @return the new degree
	*/
	@Override
	public com.liferay.sample.model.Degree createDegree(long degreeId) {
		return _degreeLocalService.createDegree(degreeId);
	}

	/**
	* Deletes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param degreeId the primary key of the degree
	* @return the degree that was removed
	* @throws PortalException if a degree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Degree deleteDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.deleteDegree(degreeId);
	}

	/**
	* Deletes the degree from the database. Also notifies the appropriate model listeners.
	*
	* @param degree the degree
	* @return the degree that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Degree deleteDegree(
		com.liferay.sample.model.Degree degree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.deleteDegree(degree);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _degreeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.DegreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.DegreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.sample.model.Degree fetchDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.fetchDegree(degreeId);
	}

	/**
	* Returns the degree with the primary key.
	*
	* @param degreeId the primary key of the degree
	* @return the degree
	* @throws PortalException if a degree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Degree getDegree(long degreeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.getDegree(degreeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the degrees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.DegreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of degrees
	* @param end the upper bound of the range of degrees (not inclusive)
	* @return the range of degrees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.sample.model.Degree> getDegrees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.getDegrees(start, end);
	}

	/**
	* Returns the number of degrees.
	*
	* @return the number of degrees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDegreesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.getDegreesCount();
	}

	/**
	* Updates the degree in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param degree the degree
	* @return the degree that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Degree updateDegree(
		com.liferay.sample.model.Degree degree)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.updateDegree(degree);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _degreeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_degreeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _degreeLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Get all degrees from Degree table
	*
	* @return List degree list
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.liferay.sample.model.Degree> getAllDegrees()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _degreeLocalService.getAllDegrees();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DegreeLocalService getWrappedDegreeLocalService() {
		return _degreeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDegreeLocalService(
		DegreeLocalService degreeLocalService) {
		_degreeLocalService = degreeLocalService;
	}

	@Override
	public DegreeLocalService getWrappedService() {
		return _degreeLocalService;
	}

	@Override
	public void setWrappedService(DegreeLocalService degreeLocalService) {
		_degreeLocalService = degreeLocalService;
	}

	private DegreeLocalService _degreeLocalService;
}