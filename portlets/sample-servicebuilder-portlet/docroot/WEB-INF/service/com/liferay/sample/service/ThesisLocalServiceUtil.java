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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Thesis. This utility wraps
 * {@link com.liferay.sample.service.impl.ThesisLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jasonxiang
 * @see ThesisLocalService
 * @see com.liferay.sample.service.base.ThesisLocalServiceBaseImpl
 * @see com.liferay.sample.service.impl.ThesisLocalServiceImpl
 * @generated
 */
public class ThesisLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.sample.service.impl.ThesisLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the thesis to the database. Also notifies the appropriate model listeners.
	*
	* @param thesis the thesis
	* @return the thesis that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis addThesis(
		com.liferay.sample.model.Thesis thesis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addThesis(thesis);
	}

	/**
	* Creates a new thesis with the primary key. Does not add the thesis to the database.
	*
	* @param thesisId the primary key for the new thesis
	* @return the new thesis
	*/
	public static com.liferay.sample.model.Thesis createThesis(long thesisId) {
		return getService().createThesis(thesisId);
	}

	/**
	* Deletes the thesis with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thesisId the primary key of the thesis
	* @return the thesis that was removed
	* @throws PortalException if a thesis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis deleteThesis(long thesisId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteThesis(thesisId);
	}

	/**
	* Deletes the thesis from the database. Also notifies the appropriate model listeners.
	*
	* @param thesis the thesis
	* @return the thesis that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis deleteThesis(
		com.liferay.sample.model.Thesis thesis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteThesis(thesis);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ThesisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ThesisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.sample.model.Thesis fetchThesis(long thesisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchThesis(thesisId);
	}

	/**
	* Returns the thesis with the primary key.
	*
	* @param thesisId the primary key of the thesis
	* @return the thesis
	* @throws PortalException if a thesis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis getThesis(long thesisId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getThesis(thesisId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the thesises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ThesisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of thesises
	* @param end the upper bound of the range of thesises (not inclusive)
	* @return the range of thesises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> getThesises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThesises(start, end);
	}

	/**
	* Returns the number of thesises.
	*
	* @return the number of thesises
	* @throws SystemException if a system exception occurred
	*/
	public static int getThesisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getThesisesCount();
	}

	/**
	* Updates the thesis in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thesis the thesis
	* @return the thesis that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis updateThesis(
		com.liferay.sample.model.Thesis thesis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThesis(thesis);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Get thesis list by userId
	*
	* @param userId the userId
	* @return thesis list
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> getThesisListByUserId(
		long userId) {
		return getService().getThesisListByUserId(userId);
	}

	/**
	* Remove thesis list by userId
	*
	* @param userId long userId
	* @throws SystemException
	*/
	public static void removeThesisListByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeThesisListByUserId(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ThesisLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ThesisLocalService.class.getName());

			if (invokableLocalService instanceof ThesisLocalService) {
				_service = (ThesisLocalService)invokableLocalService;
			}
			else {
				_service = new ThesisLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ThesisLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ThesisLocalService service) {
	}

	private static ThesisLocalService _service;
}