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

import com.liferay.sample.model.Major;

/**
 * The persistence interface for the major service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see MajorPersistenceImpl
 * @see MajorUtil
 * @generated
 */
public interface MajorPersistence extends BasePersistence<Major> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MajorUtil} to access the major persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the major in the entity cache if it is enabled.
	*
	* @param major the major
	*/
	public void cacheResult(com.liferay.sample.model.Major major);

	/**
	* Caches the majors in the entity cache if it is enabled.
	*
	* @param majors the majors
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Major> majors);

	/**
	* Creates a new major with the primary key. Does not add the major to the database.
	*
	* @param majorId the primary key for the new major
	* @return the new major
	*/
	public com.liferay.sample.model.Major create(long majorId);

	/**
	* Removes the major with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param majorId the primary key of the major
	* @return the major that was removed
	* @throws com.liferay.sample.NoSuchMajorException if a major with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Major remove(long majorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchMajorException;

	public com.liferay.sample.model.Major updateImpl(
		com.liferay.sample.model.Major major)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the major with the primary key or throws a {@link com.liferay.sample.NoSuchMajorException} if it could not be found.
	*
	* @param majorId the primary key of the major
	* @return the major
	* @throws com.liferay.sample.NoSuchMajorException if a major with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Major findByPrimaryKey(long majorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchMajorException;

	/**
	* Returns the major with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param majorId the primary key of the major
	* @return the major, or <code>null</code> if a major with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Major fetchByPrimaryKey(long majorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the majors.
	*
	* @return the majors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Major> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the majors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.MajorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of majors
	* @param end the upper bound of the range of majors (not inclusive)
	* @return the range of majors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Major> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the majors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.MajorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of majors
	* @param end the upper bound of the range of majors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of majors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Major> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the majors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of majors.
	*
	* @return the number of majors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}