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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sample.model.Property;

/**
 * The persistence interface for the property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see PropertyPersistenceImpl
 * @see PropertyUtil
 * @generated
 */
public interface PropertyPersistence extends BasePersistence<Property> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PropertyUtil} to access the property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the property in the entity cache if it is enabled.
	*
	* @param property the property
	*/
	public void cacheResult(com.liferay.sample.model.Property property);

	/**
	* Caches the properties in the entity cache if it is enabled.
	*
	* @param properties the properties
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Property> properties);

	/**
	* Creates a new property with the primary key. Does not add the property to the database.
	*
	* @param propertyId the primary key for the new property
	* @return the new property
	*/
	public com.liferay.sample.model.Property create(long propertyId);

	/**
	* Removes the property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the property
	* @return the property that was removed
	* @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Property remove(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchPropertyException;

	public com.liferay.sample.model.Property updateImpl(
		com.liferay.sample.model.Property property)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the property with the primary key or throws a {@link com.liferay.sample.NoSuchPropertyException} if it could not be found.
	*
	* @param propertyId the primary key of the property
	* @return the property
	* @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Property findByPrimaryKey(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchPropertyException;

	/**
	* Returns the property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertyId the primary key of the property
	* @return the property, or <code>null</code> if a property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Property fetchByPrimaryKey(long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the properties.
	*
	* @return the properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Property> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.Property> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.Property> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of properties.
	*
	* @return the number of properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}