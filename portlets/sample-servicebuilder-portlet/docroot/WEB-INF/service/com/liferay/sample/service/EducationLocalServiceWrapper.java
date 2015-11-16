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
 * Provides a wrapper for {@link EducationLocalService}.
 *
 * @author jasonxiang
 * @see EducationLocalService
 * @generated
 */
public class EducationLocalServiceWrapper implements EducationLocalService,
	ServiceWrapper<EducationLocalService> {
	public EducationLocalServiceWrapper(
		EducationLocalService educationLocalService) {
		_educationLocalService = educationLocalService;
	}

	/**
	* Adds the education to the database. Also notifies the appropriate model listeners.
	*
	* @param education the education
	* @return the education that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Education addEducation(
		com.liferay.sample.model.Education education)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.addEducation(education);
	}

	/**
	* Creates a new education with the primary key. Does not add the education to the database.
	*
	* @param educationId the primary key for the new education
	* @return the new education
	*/
	@Override
	public com.liferay.sample.model.Education createEducation(long educationId) {
		return _educationLocalService.createEducation(educationId);
	}

	/**
	* Deletes the education with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param educationId the primary key of the education
	* @return the education that was removed
	* @throws PortalException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Education deleteEducation(long educationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.deleteEducation(educationId);
	}

	/**
	* Deletes the education from the database. Also notifies the appropriate model listeners.
	*
	* @param education the education
	* @return the education that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Education deleteEducation(
		com.liferay.sample.model.Education education)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.deleteEducation(education);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _educationLocalService.dynamicQuery();
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
		return _educationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _educationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _educationLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _educationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _educationLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.sample.model.Education fetchEducation(long educationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.fetchEducation(educationId);
	}

	/**
	* Returns the education with the primary key.
	*
	* @param educationId the primary key of the education
	* @return the education
	* @throws PortalException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Education getEducation(long educationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.getEducation(educationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the educations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of educations
	* @param end the upper bound of the range of educations (not inclusive)
	* @return the range of educations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.sample.model.Education> getEducations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.getEducations(start, end);
	}

	/**
	* Returns the number of educations.
	*
	* @return the number of educations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEducationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.getEducationsCount();
	}

	/**
	* Updates the education in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param education the education
	* @return the education that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Education updateEducation(
		com.liferay.sample.model.Education education)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _educationLocalService.updateEducation(education);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _educationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_educationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _educationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EducationLocalService getWrappedEducationLocalService() {
		return _educationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEducationLocalService(
		EducationLocalService educationLocalService) {
		_educationLocalService = educationLocalService;
	}

	@Override
	public EducationLocalService getWrappedService() {
		return _educationLocalService;
	}

	@Override
	public void setWrappedService(EducationLocalService educationLocalService) {
		_educationLocalService = educationLocalService;
	}

	private EducationLocalService _educationLocalService;
}