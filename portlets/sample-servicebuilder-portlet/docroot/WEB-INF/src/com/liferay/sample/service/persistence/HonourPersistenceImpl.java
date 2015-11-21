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

import com.liferay.sample.NoSuchHonourException;
import com.liferay.sample.model.Honour;
import com.liferay.sample.model.impl.HonourImpl;
import com.liferay.sample.model.impl.HonourModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the honour service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see HonourPersistence
 * @see HonourUtil
 * @generated
 */
public class HonourPersistenceImpl extends BasePersistenceImpl<Honour>
	implements HonourPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HonourUtil} to access the honour persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HonourImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourModelImpl.FINDER_CACHE_ENABLED, HonourImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourModelImpl.FINDER_CACHE_ENABLED, HonourImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourModelImpl.FINDER_CACHE_ENABLED, HonourImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourModelImpl.FINDER_CACHE_ENABLED, HonourImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			HonourModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the honours where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching honours
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Honour> findByuserId(long userId) throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Honour> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

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
	@Override
	public List<Honour> findByuserId(long userId, int start, int end,
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

		List<Honour> list = (List<Honour>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Honour honour : list) {
				if ((userId != honour.getUserId())) {
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

			query.append(_SQL_SELECT_HONOUR_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HonourModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Honour>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Honour>(list);
				}
				else {
					list = (List<Honour>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first honour in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honour
	 * @throws com.liferay.sample.NoSuchHonourException if a matching honour could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchHonourException, SystemException {
		Honour honour = fetchByuserId_First(userId, orderByComparator);

		if (honour != null) {
			return honour;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHonourException(msg.toString());
	}

	/**
	 * Returns the first honour in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honour, or <code>null</code> if a matching honour could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Honour> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last honour in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honour
	 * @throws com.liferay.sample.NoSuchHonourException if a matching honour could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchHonourException, SystemException {
		Honour honour = fetchByuserId_Last(userId, orderByComparator);

		if (honour != null) {
			return honour;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHonourException(msg.toString());
	}

	/**
	 * Returns the last honour in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honour, or <code>null</code> if a matching honour could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Honour> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Honour[] findByuserId_PrevAndNext(long honourId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchHonourException, SystemException {
		Honour honour = findByPrimaryKey(honourId);

		Session session = null;

		try {
			session = openSession();

			Honour[] array = new HonourImpl[3];

			array[0] = getByuserId_PrevAndNext(session, honour, userId,
					orderByComparator, true);

			array[1] = honour;

			array[2] = getByuserId_PrevAndNext(session, honour, userId,
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

	protected Honour getByuserId_PrevAndNext(Session session, Honour honour,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HONOUR_WHERE);

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
			query.append(HonourModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(honour);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Honour> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the honours where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (Honour honour : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(honour);
		}
	}

	/**
	 * Returns the number of honours where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching honours
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

			query.append(_SQL_COUNT_HONOUR_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "honour.userId = ?";

	public HonourPersistenceImpl() {
		setModelClass(Honour.class);
	}

	/**
	 * Caches the honour in the entity cache if it is enabled.
	 *
	 * @param honour the honour
	 */
	@Override
	public void cacheResult(Honour honour) {
		EntityCacheUtil.putResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourImpl.class, honour.getPrimaryKey(), honour);

		honour.resetOriginalValues();
	}

	/**
	 * Caches the honours in the entity cache if it is enabled.
	 *
	 * @param honours the honours
	 */
	@Override
	public void cacheResult(List<Honour> honours) {
		for (Honour honour : honours) {
			if (EntityCacheUtil.getResult(
						HonourModelImpl.ENTITY_CACHE_ENABLED, HonourImpl.class,
						honour.getPrimaryKey()) == null) {
				cacheResult(honour);
			}
			else {
				honour.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all honours.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HonourImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HonourImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the honour.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Honour honour) {
		EntityCacheUtil.removeResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourImpl.class, honour.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Honour> honours) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Honour honour : honours) {
			EntityCacheUtil.removeResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
				HonourImpl.class, honour.getPrimaryKey());
		}
	}

	/**
	 * Creates a new honour with the primary key. Does not add the honour to the database.
	 *
	 * @param honourId the primary key for the new honour
	 * @return the new honour
	 */
	@Override
	public Honour create(long honourId) {
		Honour honour = new HonourImpl();

		honour.setNew(true);
		honour.setPrimaryKey(honourId);

		return honour;
	}

	/**
	 * Removes the honour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param honourId the primary key of the honour
	 * @return the honour that was removed
	 * @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour remove(long honourId)
		throws NoSuchHonourException, SystemException {
		return remove((Serializable)honourId);
	}

	/**
	 * Removes the honour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the honour
	 * @return the honour that was removed
	 * @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour remove(Serializable primaryKey)
		throws NoSuchHonourException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Honour honour = (Honour)session.get(HonourImpl.class, primaryKey);

			if (honour == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHonourException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(honour);
		}
		catch (NoSuchHonourException nsee) {
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
	protected Honour removeImpl(Honour honour) throws SystemException {
		honour = toUnwrappedModel(honour);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(honour)) {
				honour = (Honour)session.get(HonourImpl.class,
						honour.getPrimaryKeyObj());
			}

			if (honour != null) {
				session.delete(honour);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (honour != null) {
			clearCache(honour);
		}

		return honour;
	}

	@Override
	public Honour updateImpl(com.liferay.sample.model.Honour honour)
		throws SystemException {
		honour = toUnwrappedModel(honour);

		boolean isNew = honour.isNew();

		HonourModelImpl honourModelImpl = (HonourModelImpl)honour;

		Session session = null;

		try {
			session = openSession();

			if (honour.isNew()) {
				session.save(honour);

				honour.setNew(false);
			}
			else {
				session.merge(honour);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HonourModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((honourModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { honourModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { honourModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
			HonourImpl.class, honour.getPrimaryKey(), honour);

		return honour;
	}

	protected Honour toUnwrappedModel(Honour honour) {
		if (honour instanceof HonourImpl) {
			return honour;
		}

		HonourImpl honourImpl = new HonourImpl();

		honourImpl.setNew(honour.isNew());
		honourImpl.setPrimaryKey(honour.getPrimaryKey());

		honourImpl.setHonourId(honour.getHonourId());
		honourImpl.setHonoraryName(honour.getHonoraryName());
		honourImpl.setUserId(honour.getUserId());

		return honourImpl;
	}

	/**
	 * Returns the honour with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the honour
	 * @return the honour
	 * @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHonourException, SystemException {
		Honour honour = fetchByPrimaryKey(primaryKey);

		if (honour == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHonourException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return honour;
	}

	/**
	 * Returns the honour with the primary key or throws a {@link com.liferay.sample.NoSuchHonourException} if it could not be found.
	 *
	 * @param honourId the primary key of the honour
	 * @return the honour
	 * @throws com.liferay.sample.NoSuchHonourException if a honour with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour findByPrimaryKey(long honourId)
		throws NoSuchHonourException, SystemException {
		return findByPrimaryKey((Serializable)honourId);
	}

	/**
	 * Returns the honour with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the honour
	 * @return the honour, or <code>null</code> if a honour with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Honour honour = (Honour)EntityCacheUtil.getResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
				HonourImpl.class, primaryKey);

		if (honour == _nullHonour) {
			return null;
		}

		if (honour == null) {
			Session session = null;

			try {
				session = openSession();

				honour = (Honour)session.get(HonourImpl.class, primaryKey);

				if (honour != null) {
					cacheResult(honour);
				}
				else {
					EntityCacheUtil.putResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
						HonourImpl.class, primaryKey, _nullHonour);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HonourModelImpl.ENTITY_CACHE_ENABLED,
					HonourImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return honour;
	}

	/**
	 * Returns the honour with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param honourId the primary key of the honour
	 * @return the honour, or <code>null</code> if a honour with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Honour fetchByPrimaryKey(long honourId) throws SystemException {
		return fetchByPrimaryKey((Serializable)honourId);
	}

	/**
	 * Returns all the honours.
	 *
	 * @return the honours
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Honour> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Honour> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Honour> findAll(int start, int end,
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

		List<Honour> list = (List<Honour>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HONOUR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HONOUR;

				if (pagination) {
					sql = sql.concat(HonourModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Honour>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Honour>(list);
				}
				else {
					list = (List<Honour>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the honours from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Honour honour : findAll()) {
			remove(honour);
		}
	}

	/**
	 * Returns the number of honours.
	 *
	 * @return the number of honours
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

				Query q = session.createQuery(_SQL_COUNT_HONOUR);

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
	 * Initializes the honour persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Honour")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Honour>> listenersList = new ArrayList<ModelListener<Honour>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Honour>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HonourImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HONOUR = "SELECT honour FROM Honour honour";
	private static final String _SQL_SELECT_HONOUR_WHERE = "SELECT honour FROM Honour honour WHERE ";
	private static final String _SQL_COUNT_HONOUR = "SELECT COUNT(honour) FROM Honour honour";
	private static final String _SQL_COUNT_HONOUR_WHERE = "SELECT COUNT(honour) FROM Honour honour WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "honour.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Honour exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Honour exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HonourPersistenceImpl.class);
	private static Honour _nullHonour = new HonourImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Honour> toCacheModel() {
				return _nullHonourCacheModel;
			}
		};

	private static CacheModel<Honour> _nullHonourCacheModel = new CacheModel<Honour>() {
			@Override
			public Honour toEntityModel() {
				return _nullHonour;
			}
		};
}