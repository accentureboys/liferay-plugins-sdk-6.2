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

import com.liferay.sample.model.Property;

import java.util.List;

/**
 * The persistence utility for the property service. This utility wraps {@link PropertyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see PropertyPersistence
 * @see PropertyPersistenceImpl
 * @generated
 */
public class PropertyUtil {
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
	public static void clearCache(Property property) {
		getPersistence().clearCache(property);
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
	public static List<Property> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Property> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Property> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Property update(Property property) throws SystemException {
		return getPersistence().update(property);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Property update(Property property,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(property, serviceContext);
	}

	/**
	* Caches the property in the entity cache if it is enabled.
	*
	* @param property the property
	*/
	public static void cacheResult(com.liferay.sample.model.Property property) {
		getPersistence().cacheResult(property);
	}

	/**
	* Caches the properties in the entity cache if it is enabled.
	*
	* @param properties the properties
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sample.model.Property> properties) {
		getPersistence().cacheResult(properties);
	}

	/**
	* Creates a new property with the primary key. Does not add the property to the database.
	*
	* @param propertyId the primary key for the new property
	* @return the new property
	*/
	public static com.liferay.sample.model.Property create(long propertyId) {
		return getPersistence().create(propertyId);
	}

	/**
	* Removes the property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the property
	* @return the property that was removed
	* @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Property remove(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchPropertyException {
		return getPersistence().remove(propertyId);
	}

	public static com.liferay.sample.model.Property updateImpl(
		com.liferay.sample.model.Property property)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(property);
	}

	/**
	* Returns the property with the primary key or throws a {@link com.liferay.sample.NoSuchPropertyException} if it could not be found.
	*
	* @param propertyId the primary key of the property
	* @return the property
	* @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Property findByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchPropertyException {
		return getPersistence().findByPrimaryKey(propertyId);
	}

	/**
	* Returns the property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertyId the primary key of the property
	* @return the property, or <code>null</code> if a property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Property fetchByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(propertyId);
	}

	/**
	* Returns all the properties.
	*
	* @return the properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Property> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.PropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of properties
	* @param end the upper bound of the range of properties (not inclusive)
	* @return the range of properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Property> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.PropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of properties
	* @param end the upper bound of the range of properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Property> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of properties.
	*
	* @return the number of properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PropertyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PropertyPersistence)PortletBeanLocatorUtil.locate(com.liferay.sample.service.ClpSerializer.getServletContextName(),
					PropertyPersistence.class.getName());

			ReferenceRegistry.registerReference(PropertyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PropertyPersistence persistence) {
	}

	private static PropertyPersistence _persistence;
}