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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.sample.NoSuchThesisException;
import com.liferay.sample.model.Thesis;
import com.liferay.sample.model.impl.ThesisImpl;
import com.liferay.sample.model.impl.ThesisModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the thesis service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see ThesisPersistence
 * @see ThesisUtil
 * @generated
 */
public class ThesisPersistenceImpl extends BasePersistenceImpl<Thesis>
	implements ThesisPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThesisUtil} to access the thesis persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThesisImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisModelImpl.FINDER_CACHE_ENABLED, ThesisImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisModelImpl.FINDER_CACHE_ENABLED, ThesisImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisModelImpl.FINDER_CACHE_ENABLED, ThesisImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisModelImpl.FINDER_CACHE_ENABLED, ThesisImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			ThesisModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the thesises where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching thesises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Thesis> findByuserId(long userId) throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Thesis> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<Thesis> findByuserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Thesis> list = (List<Thesis>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Thesis thesis : list) {
				if ((userId != thesis.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_THESIS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ThesisModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Thesis>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Thesis>(list);
				}
				else {
					list = (List<Thesis>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Thesis findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchThesisException, SystemException {
		Thesis thesis = fetchByuserId_First(userId, orderByComparator);

		if (thesis != null) {
			return thesis;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThesisException(msg.toString());
	}

	/**
	 * Returns the first thesis in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thesis, or <code>null</code> if a matching thesis could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Thesis> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Thesis findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchThesisException, SystemException {
		Thesis thesis = fetchByuserId_Last(userId, orderByComparator);

		if (thesis != null) {
			return thesis;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThesisException(msg.toString());
	}

	/**
	 * Returns the last thesis in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thesis, or <code>null</code> if a matching thesis could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Thesis> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Thesis[] findByuserId_PrevAndNext(long thesisId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchThesisException, SystemException {
		Thesis thesis = findByPrimaryKey(thesisId);

		Session session = null;

		try {
			session = openSession();

			Thesis[] array = new ThesisImpl[3];

			array[0] = getByuserId_PrevAndNext(session, thesis, userId,
					orderByComparator, true);

			array[1] = thesis;

			array[2] = getByuserId_PrevAndNext(session, thesis, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Thesis getByuserId_PrevAndNext(Session session, Thesis thesis,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THESIS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ThesisModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thesis);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Thesis> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the thesises where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (Thesis thesis : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(thesis);
		}
	}

	/**
	 * Returns the number of thesises where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching thesises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THESIS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "thesis.userId = ?";

	public ThesisPersistenceImpl() {
		setModelClass(Thesis.class);
	}

	/**
	 * Caches the thesis in the entity cache if it is enabled.
	 *
	 * @param thesis the thesis
	 */
	@Override
	public void cacheResult(Thesis thesis) {
		EntityCacheUtil.putResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisImpl.class, thesis.getPrimaryKey(), thesis);

		thesis.resetOriginalValues();
	}

	/**
	 * Caches the thesises in the entity cache if it is enabled.
	 *
	 * @param thesises the thesises
	 */
	@Override
	public void cacheResult(List<Thesis> thesises) {
		for (Thesis thesis : thesises) {
			if (EntityCacheUtil.getResult(
						ThesisModelImpl.ENTITY_CACHE_ENABLED, ThesisImpl.class,
						thesis.getPrimaryKey()) == null) {
				cacheResult(thesis);
			}
			else {
				thesis.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thesises.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThesisImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThesisImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thesis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Thesis thesis) {
		EntityCacheUtil.removeResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisImpl.class, thesis.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Thesis> thesises) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Thesis thesis : thesises) {
			EntityCacheUtil.removeResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
				ThesisImpl.class, thesis.getPrimaryKey());
		}
	}

	/**
	 * Creates a new thesis with the primary key. Does not add the thesis to the database.
	 *
	 * @param thesisId the primary key for the new thesis
	 * @return the new thesis
	 */
	@Override
	public Thesis create(long thesisId) {
		Thesis thesis = new ThesisImpl();

		thesis.setNew(true);
		thesis.setPrimaryKey(thesisId);

		return thesis;
	}

	/**
	 * Removes the thesis with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thesisId the primary key of the thesis
	 * @return the thesis that was removed
	 * @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis remove(long thesisId)
		throws NoSuchThesisException, SystemException {
		return remove((Serializable)thesisId);
	}

	/**
	 * Removes the thesis with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thesis
	 * @return the thesis that was removed
	 * @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis remove(Serializable primaryKey)
		throws NoSuchThesisException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Thesis thesis = (Thesis)session.get(ThesisImpl.class, primaryKey);

			if (thesis == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThesisException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thesis);
		}
		catch (NoSuchThesisException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Thesis removeImpl(Thesis thesis) throws SystemException {
		thesis = toUnwrappedModel(thesis);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thesis)) {
				thesis = (Thesis)session.get(ThesisImpl.class,
						thesis.getPrimaryKeyObj());
			}

			if (thesis != null) {
				session.delete(thesis);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (thesis != null) {
			clearCache(thesis);
		}

		return thesis;
	}

	@Override
	public Thesis updateImpl(com.liferay.sample.model.Thesis thesis)
		throws SystemException {
		thesis = toUnwrappedModel(thesis);

		boolean isNew = thesis.isNew();

		ThesisModelImpl thesisModelImpl = (ThesisModelImpl)thesis;

		Session session = null;

		try {
			session = openSession();

			if (thesis.isNew()) {
				session.save(thesis);

				thesis.setNew(false);
			}
			else {
				session.merge(thesis);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThesisModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thesisModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { thesisModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { thesisModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
			ThesisImpl.class, thesis.getPrimaryKey(), thesis);

		return thesis;
	}

	protected Thesis toUnwrappedModel(Thesis thesis) {
		if (thesis instanceof ThesisImpl) {
			return thesis;
		}

		ThesisImpl thesisImpl = new ThesisImpl();

		thesisImpl.setNew(thesis.isNew());
		thesisImpl.setPrimaryKey(thesis.getPrimaryKey());

		thesisImpl.setThesisId(thesis.getThesisId());
		thesisImpl.setThesisName(thesis.getThesisName());
		thesisImpl.setUserId(thesis.getUserId());

		return thesisImpl;
	}

	/**
	 * Returns the thesis with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the thesis
	 * @return the thesis
	 * @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThesisException, SystemException {
		Thesis thesis = fetchByPrimaryKey(primaryKey);

		if (thesis == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThesisException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return thesis;
	}

	/**
	 * Returns the thesis with the primary key or throws a {@link com.liferay.sample.NoSuchThesisException} if it could not be found.
	 *
	 * @param thesisId the primary key of the thesis
	 * @return the thesis
	 * @throws com.liferay.sample.NoSuchThesisException if a thesis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis findByPrimaryKey(long thesisId)
		throws NoSuchThesisException, SystemException {
		return findByPrimaryKey((Serializable)thesisId);
	}

	/**
	 * Returns the thesis with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thesis
	 * @return the thesis, or <code>null</code> if a thesis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Thesis thesis = (Thesis)EntityCacheUtil.getResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
				ThesisImpl.class, primaryKey);

		if (thesis == _nullThesis) {
			return null;
		}

		if (thesis == null) {
			Session session = null;

			try {
				session = openSession();

				thesis = (Thesis)session.get(ThesisImpl.class, primaryKey);

				if (thesis != null) {
					cacheResult(thesis);
				}
				else {
					EntityCacheUtil.putResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
						ThesisImpl.class, primaryKey, _nullThesis);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ThesisModelImpl.ENTITY_CACHE_ENABLED,
					ThesisImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return thesis;
	}

	/**
	 * Returns the thesis with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param thesisId the primary key of the thesis
	 * @return the thesis, or <code>null</code> if a thesis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Thesis fetchByPrimaryKey(long thesisId) throws SystemException {
		return fetchByPrimaryKey((Serializable)thesisId);
	}

	/**
	 * Returns all the thesises.
	 *
	 * @return the thesises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Thesis> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Thesis> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Thesis> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Thesis> list = (List<Thesis>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THESIS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THESIS;

				if (pagination) {
					sql = sql.concat(ThesisModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Thesis>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Thesis>(list);
				}
				else {
					list = (List<Thesis>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the thesises from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Thesis thesis : findAll()) {
			remove(thesis);
		}
	}

	/**
	 * Returns the number of thesises.
	 *
	 * @return the number of thesises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THESIS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the thesis persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Thesis")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Thesis>> listenersList = new ArrayList<ModelListener<Thesis>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Thesis>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ThesisImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_THESIS = "SELECT thesis FROM Thesis thesis";
	private static final String _SQL_SELECT_THESIS_WHERE = "SELECT thesis FROM Thesis thesis WHERE ";
	private static final String _SQL_COUNT_THESIS = "SELECT COUNT(thesis) FROM Thesis thesis";
	private static final String _SQL_COUNT_THESIS_WHERE = "SELECT COUNT(thesis) FROM Thesis thesis WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thesis.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Thesis exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Thesis exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThesisPersistenceImpl.class);
	private static Thesis _nullThesis = new ThesisImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Thesis> toCacheModel() {
				return _nullThesisCacheModel;
			}
		};

	private static CacheModel<Thesis> _nullThesisCacheModel = new CacheModel<Thesis>() {
			@Override
			public Thesis toEntityModel() {
				return _nullThesis;
			}
		};
}