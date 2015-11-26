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
 * Provides a wrapper for {@link HonourLocalService}.
 *
 * @author jasonxiang
 * @see HonourLocalService
 * @generated
 */
public class HonourLocalServiceWrapper implements HonourLocalService,
	ServiceWrapper<HonourLocalService> {
	public HonourLocalServiceWrapper(HonourLocalService honourLocalService) {
		_honourLocalService = honourLocalService;
	}

	/**
	* Adds the honour to the database. Also notifies the appropriate model listeners.
	*
	* @param honour the honour
	* @return the honour that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Honour addHonour(
		com.liferay.sample.model.Honour honour)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.addHonour(honour);
	}

	/**
	* Creates a new honour with the primary key. Does not add the honour to the database.
	*
	* @param honourId the primary key for the new honour
	* @return the new honour
	*/
	@Override
	public com.liferay.sample.model.Honour createHonour(long honourId) {
		return _honourLocalService.createHonour(honourId);
	}

	/**
	* Deletes the honour with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param honourId the primary key of the honour
	* @return the honour that was removed
	* @throws PortalException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Honour deleteHonour(long honourId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.deleteHonour(honourId);
	}

	/**
	* Deletes the honour from the database. Also notifies the appropriate model listeners.
	*
	* @param honour the honour
	* @return the honour that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Honour deleteHonour(
		com.liferay.sample.model.Honour honour)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.deleteHonour(honour);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _honourLocalService.dynamicQuery();
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
		return _honourLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.HonourModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _honourLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.HonourModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _honourLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _honourLocalService.dynamicQueryCount(dynamicQuery);
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
		return _honourLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.sample.model.Honour fetchHonour(long honourId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.fetchHonour(honourId);
	}

	/**
	* Returns the honour with the primary key.
	*
	* @param honourId the primary key of the honour
	* @return the honour
	* @throws PortalException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Honour getHonour(long honourId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.getHonour(honourId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the honours.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.HonourModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of honours
	* @param end the upper bound of the range of honours (not inclusive)
	* @return the range of honours
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.sample.model.Honour> getHonours(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.getHonours(start, end);
	}

	/**
	* Returns the number of honours.
	*
	* @return the number of honours
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHonoursCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.getHonoursCount();
	}

	/**
	* Updates the honour in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param honour the honour
	* @return the honour that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.sample.model.Honour updateHonour(
		com.liferay.sample.model.Honour honour)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _honourLocalService.updateHonour(honour);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _honourLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_honourLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _honourLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Get honour list by user id
	*
	* @param userId the user id
	* @return Honour list
	*/
	@Override
	public java.util.List<com.liferay.sample.model.Honour> getHonourListByUserId(
		long userId) {
		return _honourLocalService.getHonourListByUserId(userId);
	}

	/**
	* Remove honour list by user id
	*
	* @param userId long userId
	* @throws SystemException
	*/
	@Override
	public void removeHonourListByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_honourLocalService.removeHonourListByUserId(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HonourLocalService getWrappedHonourLocalService() {
		return _honourLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHonourLocalService(
		HonourLocalService honourLocalService) {
		_honourLocalService = honourLocalService;
	}

	@Override
	public HonourLocalService getWrappedService() {
		return _honourLocalService;
	}

	@Override
	public void setWrappedService(HonourLocalService honourLocalService) {
		_honourLocalService = honourLocalService;
	}

	private HonourLocalService _honourLocalService;
}