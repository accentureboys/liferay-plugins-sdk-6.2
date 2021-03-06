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

package com.liferay.sample.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.sample.model.Thesis;

import java.util.List;

/**
 * The persistence utility for the thesis service. This utility wraps {@link ThesisPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see ThesisPersistence
 * @see ThesisPersistenceImpl
 * @generated
 */
public class ThesisUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Thesis thesis) {
		getPersistence().clearCache(thesis);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Thesis> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Thesis> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Thesis> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Thesis update(Thesis thesis) throws SystemException {
		return getPersistence().update(thesis);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Thesis update(Thesis thesis, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(thesis, serviceContext);
	}

	/**
	* Returns all the thesises where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching thesises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns a range of all the thesises where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ThesisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of thesises
	* @param end the upper bound of the range of thesises (not inclusive)
	* @return the range of matching thesises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the thesises where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ThesisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of thesises
	* @param end the upper bound of the range of thesises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thesises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first thesis in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thesis
	* @throws com.liferay.sample.NoSuchThesisException if a matching thesis could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchThesisException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first thesis in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thesis, or <code>null</code> if a matching thesis could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last thesis in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thesis
	* @throws com.liferay.sample.NoSuchThesisException if a matching thesis could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchThesisException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last thesis in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thesis, or <code>null</code> if a matching thesis could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the thesises before and after the current thesis in the ordered set where userId = &#63;.
	*
	* @param thesisId the primary key of the current thesis
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thesis
	* @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis[] findByuserId_PrevAndNext(
		long thesisId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchThesisException {
		return getPersistence()
				   .findByuserId_PrevAndNext(thesisId, userId, orderByComparator);
	}

	/**
	* Removes all the thesises where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of thesises where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching thesises
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Caches the thesis in the entity cache if it is enabled.
	*
	* @param thesis the thesis
	*/
	public static void cacheResult(com.liferay.sample.model.Thesis thesis) {
		getPersistence().cacheResult(thesis);
	}

	/**
	* Caches the thesises in the entity cache if it is enabled.
	*
	* @param thesises the thesises
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sample.model.Thesis> thesises) {
		getPersistence().cacheResult(thesises);
	}

	/**
	* Creates a new thesis with the primary key. Does not add the thesis to the database.
	*
	* @param thesisId the primary key for the new thesis
	* @return the new thesis
	*/
	public static com.liferay.sample.model.Thesis create(long thesisId) {
		return getPersistence().create(thesisId);
	}

	/**
	* Removes the thesis with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thesisId the primary key of the thesis
	* @return the thesis that was removed
	* @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis remove(long thesisId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchThesisException {
		return getPersistence().remove(thesisId);
	}

	public static com.liferay.sample.model.Thesis updateImpl(
		com.liferay.sample.model.Thesis thesis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(thesis);
	}

	/**
	* Returns the thesis with the primary key or throws a {@link com.liferay.sample.NoSuchThesisException} if it could not be found.
	*
	* @param thesisId the primary key of the thesis
	* @return the thesis
	* @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis findByPrimaryKey(
		long thesisId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchThesisException {
		return getPersistence().findByPrimaryKey(thesisId);
	}

	/**
	* Returns the thesis with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param thesisId the primary key of the thesis
	* @return the thesis, or <code>null</code> if a thesis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Thesis fetchByPrimaryKey(
		long thesisId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(thesisId);
	}

	/**
	* Returns all the thesises.
	*
	* @return the thesises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.sample.model.Thesis> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the thesises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.ThesisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of thesises
	* @param end the upper bound of the range of thesises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thesises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Thesis> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the thesises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of thesises.
	*
	* @return the number of thesises
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ThesisPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ThesisPersistence)PortletBeanLocatorUtil.locate(com.liferay.sample.service.ClpSerializer.getServletContextName(),
					ThesisPersistence.class.getName());

			ReferenceRegistry.registerReference(ThesisUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ThesisPersistence persistence) {
	}

	private static ThesisPersistence _persistence;
}