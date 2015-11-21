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

import com.liferay.sample.model.Honour;

/**
 * The persistence interface for the honour service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see HonourPersistenceImpl
 * @see HonourUtil
 * @generated
 */
public interface HonourPersistence extends BasePersistence<Honour> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HonourUtil} to access the honour persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the honours where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching honours
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Honour> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the honours where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.HonourModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of honours
	* @param end the upper bound of the range of honours (not inclusive)
	* @return the range of matching honours
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Honour> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the honours where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.HonourModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of honours
	* @param end the upper bound of the range of honours (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching honours
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Honour> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first honour in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching honour
	* @throws com.liferay.sample.NoSuchHonourException if a matching honour could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException;

	/**
	* Returns the first honour in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching honour, or <code>null</code> if a matching honour could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last honour in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching honour
	* @throws com.liferay.sample.NoSuchHonourException if a matching honour could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException;

	/**
	* Returns the last honour in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching honour, or <code>null</code> if a matching honour could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the honours before and after the current honour in the ordered set where userId = &#63;.
	*
	* @param honourId the primary key of the current honour
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next honour
	* @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour[] findByuserId_PrevAndNext(
		long honourId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException;

	/**
	* Removes all the honours where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of honours where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching honours
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the honour in the entity cache if it is enabled.
	*
	* @param honour the honour
	*/
	public void cacheResult(com.liferay.sample.model.Honour honour);

	/**
	* Caches the honours in the entity cache if it is enabled.
	*
	* @param honours the honours
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Honour> honours);

	/**
	* Creates a new honour with the primary key. Does not add the honour to the database.
	*
	* @param honourId the primary key for the new honour
	* @return the new honour
	*/
	public com.liferay.sample.model.Honour create(long honourId);

	/**
	* Removes the honour with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param honourId the primary key of the honour
	* @return the honour that was removed
	* @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour remove(long honourId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException;

	public com.liferay.sample.model.Honour updateImpl(
		com.liferay.sample.model.Honour honour)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the honour with the primary key or throws a {@link com.liferay.sample.NoSuchHonourException} if it could not be found.
	*
	* @param honourId the primary key of the honour
	* @return the honour
	* @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour findByPrimaryKey(long honourId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchHonourException;

	/**
	* Returns the honour with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param honourId the primary key of the honour
	* @return the honour, or <code>null</code> if a honour with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Honour fetchByPrimaryKey(long honourId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the honours.
	*
	* @return the honours
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Honour> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.Honour> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sample.model.Honour> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the honours from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of honours.
	*
	* @return the number of honours
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}