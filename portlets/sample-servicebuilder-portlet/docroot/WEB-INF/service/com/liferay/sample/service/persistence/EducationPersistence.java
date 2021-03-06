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

import com.liferay.sample.model.Education;

/**
 * The persistence interface for the education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see EducationPersistenceImpl
 * @see EducationUtil
 * @generated
 */
public interface EducationPersistence extends BasePersistence<Education> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EducationUtil} to access the education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the education where userId = &#63; or throws a {@link com.liferay.sample.NoSuchEducationException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching education
	* @throws com.liferay.sample.NoSuchEducationException if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education findByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEducationException;

	/**
	* Returns the education where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching education, or <code>null</code> if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education fetchByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the education where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching education, or <code>null</code> if a matching education could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education fetchByuserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the education where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the education that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEducationException;

	/**
	* Returns the number of educations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching educations
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the education in the entity cache if it is enabled.
	*
	* @param education the education
	*/
	public void cacheResult(com.liferay.sample.model.Education education);

	/**
	* Caches the educations in the entity cache if it is enabled.
	*
	* @param educations the educations
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Education> educations);

	/**
	* Creates a new education with the primary key. Does not add the education to the database.
	*
	* @param educationId the primary key for the new education
	* @return the new education
	*/
	public com.liferay.sample.model.Education create(long educationId);

	/**
	* Removes the education with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param educationId the primary key of the education
	* @return the education that was removed
	* @throws com.liferay.sample.NoSuchEducationException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education remove(long educationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEducationException;

	public com.liferay.sample.model.Education updateImpl(
		com.liferay.sample.model.Education education)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the education with the primary key or throws a {@link com.liferay.sample.NoSuchEducationException} if it could not be found.
	*
	* @param educationId the primary key of the education
	* @return the education
	* @throws com.liferay.sample.NoSuchEducationException if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education findByPrimaryKey(long educationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchEducationException;

	/**
	* Returns the education with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param educationId the primary key of the education
	* @return the education, or <code>null</code> if a education with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Education fetchByPrimaryKey(
		long educationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the educations.
	*
	* @return the educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Education> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.Education> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the educations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of educations
	* @param end the upper bound of the range of educations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of educations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Education> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the educations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of educations.
	*
	* @return the number of educations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}