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

import com.liferay.sample.model.Degree;

/**
 * The persistence interface for the degree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see DegreePersistenceImpl
 * @see DegreeUtil
 * @generated
 */
public interface DegreePersistence extends BasePersistence<Degree> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DegreeUtil} to access the degree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the degree in the entity cache if it is enabled.
	*
	* @param degree the degree
	*/
	public void cacheResult(com.liferay.sample.model.Degree degree);

	/**
	* Caches the degrees in the entity cache if it is enabled.
	*
	* @param degrees the degrees
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Degree> degrees);

	/**
	* Creates a new degree with the primary key. Does not add the degree to the database.
	*
	* @param degreeId the primary key for the new degree
	* @return the new degree
	*/
	public com.liferay.sample.model.Degree create(long degreeId);

	/**
	* Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param degreeId the primary key of the degree
	* @return the degree that was removed
	* @throws com.liferay.sample.NoSuchDegreeException if a degree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Degree remove(long degreeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDegreeException;

	public com.liferay.sample.model.Degree updateImpl(
		com.liferay.sample.model.Degree degree)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the degree with the primary key or throws a {@link com.liferay.sample.NoSuchDegreeException} if it could not be found.
	*
	* @param degreeId the primary key of the degree
	* @return the degree
	* @throws com.liferay.sample.NoSuchDegreeException if a degree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Degree findByPrimaryKey(long degreeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDegreeException;

	/**
	* Returns the degree with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param degreeId the primary key of the degree
	* @return the degree, or <code>null</code> if a degree with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Degree fetchByPrimaryKey(long degreeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the degrees.
	*
	* @return the degrees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Degree> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.Degree> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the degrees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.DegreeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of degrees
	* @param end the upper bound of the range of degrees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of degrees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Degree> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the degrees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of degrees.
	*
	* @return the number of degrees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}