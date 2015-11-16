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

import com.liferay.sample.model.Honour;

import java.util.List;

/**
 * The persistence utility for the honour service. This utility wraps {@link HonourPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see HonourPersistence
 * @see HonourPersistenceImpl
 * @generated
 */
public class HonourUtil {
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
	public static void clearCache(Honour honour) {
		getPersistence().clearCache(honour);
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
	public static List<Honour> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Honour> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Honour> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Honour update(Honour honour) throws SystemException {
		return getPersistence().update(honour);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Honour update(Honour honour, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(honour, serviceContext);
	}

	/**
	* Caches the honour in the entity cache if it is enabled.
	*
	* @param honour the honour
	*/
	public static void cacheResult(com.liferay.sample.model.Honour honour) {
		getPersistence().cacheResult(honour);
	}

	/**
	* Caches the honours in the entity cache if it is enabled.
	*
	* @param honours the honours
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sample.model.Honour> honours) {
		getPersistence().cacheResult(honours);
	}

	/**
	* Creates a new honour with the primary key. Does not add the honour to the database.
	*
	* @param honourId the primary key for the new honour
	* @return the new honour
	*/
	public static com.liferay.sample.model.Honour create(long honourId) {
		return getPersistence().create(honourId);
	}

	/**
	* Removes the honour with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param honourId the primary key of the honour
	* @return the honour that was removed
	* @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Honour remove(long honourId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException {
		return getPersistence().remove(honourId);
	}

	public static com.liferay.sample.model.Honour updateImpl(
		com.liferay.sample.model.Honour honour)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(honour);
	}

	/**
	* Returns the honour with the primary key or throws a {@link com.liferay.sample.NoSuchHonourException} if it could not be found.
	*
	* @param honourId the primary key of the honour
	* @return the honour
	* @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Honour findByPrimaryKey(
		long honourId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException {
		return getPersistence().findByPrimaryKey(honourId);
	}

	/**
	* Returns the honour with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param honourId the primary key of the honour
	* @return the honour, or <code>null</code> if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Honour fetchByPrimaryKey(
		long honourId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(honourId);
	}

	/**
	* Returns all the honours.
	*
	* @return the honours
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Honour> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.sample.model.Honour> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the honours.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.HonourModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of honours
	* @param end the upper bound of the range of honours (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of honours
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Honour> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the honours from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of honours.
	*
	* @return the number of honours
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HonourPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HonourPersistence)PortletBeanLocatorUtil.locate(com.liferay.sample.service.ClpSerializer.getServletContextName(),
					HonourPersistence.class.getName());

			ReferenceRegistry.registerReference(HonourUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HonourPersistence persistence) {
	}

	private static HonourPersistence _persistence;
}