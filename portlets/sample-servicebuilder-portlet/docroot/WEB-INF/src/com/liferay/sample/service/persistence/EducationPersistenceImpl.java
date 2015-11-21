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

import com.liferay.sample.NoSuchEducationException;
import com.liferay.sample.model.Education;
import com.liferay.sample.model.impl.EducationImpl;
import com.liferay.sample.model.impl.EducationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see EducationPersistence
 * @see EducationUtil
 * @generated
 */
public class EducationPersistenceImpl extends BasePersistenceImpl<Education>
	implements EducationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EducationUtil} to access the education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EducationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationModelImpl.FINDER_CACHE_ENABLED, EducationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationModelImpl.FINDER_CACHE_ENABLED, EducationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationModelImpl.FINDER_CACHE_ENABLED, EducationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] { Long.class.getName() },
			EducationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the education where userId = &#63; or throws a {@link com.liferay.sample.NoSuchEducationException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching education
	 * @throws com.liferay.sample.NoSuchEducationException if a matching education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education findByuserId(long userId)
		throws NoSuchEducationException, SystemException {
		Education education = fetchByuserId(userId);

		if (education == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEducationException(msg.toString());
		}

		return education;
	}

	/**
	 * Returns the education where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching education, or <code>null</code> if a matching education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education fetchByuserId(long userId) throws SystemException {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the education where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching education, or <code>null</code> if a matching education could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education fetchByuserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof Education) {
			Education education = (Education)result;

			if ((userId != education.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EDUCATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Education> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EducationPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Education education = list.get(0);

					result = education;

					cacheResult(education);

					if ((education.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, education);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Education)result;
		}
	}

	/**
	 * Removes the education where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the education that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education removeByuserId(long userId)
		throws NoSuchEducationException, SystemException {
		Education education = findByuserId(userId);

		return remove(education);
	}

	/**
	 * Returns the number of educations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching educations
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

			query.append(_SQL_COUNT_EDUCATION_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "education.userId = ?";

	public EducationPersistenceImpl() {
		setModelClass(Education.class);
	}

	/**
	 * Caches the education in the entity cache if it is enabled.
	 *
	 * @param education the education
	 */
	@Override
	public void cacheResult(Education education) {
		EntityCacheUtil.putResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationImpl.class, education.getPrimaryKey(), education);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { education.getUserId() }, education);

		education.resetOriginalValues();
	}

	/**
	 * Caches the educations in the entity cache if it is enabled.
	 *
	 * @param educations the educations
	 */
	@Override
	public void cacheResult(List<Education> educations) {
		for (Education education : educations) {
			if (EntityCacheUtil.getResult(
						EducationModelImpl.ENTITY_CACHE_ENABLED,
						EducationImpl.class, education.getPrimaryKey()) == null) {
				cacheResult(education);
			}
			else {
				education.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all educations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EducationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EducationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the education.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Education education) {
		EntityCacheUtil.removeResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationImpl.class, education.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(education);
	}

	@Override
	public void clearCache(List<Education> educations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Education education : educations) {
			EntityCacheUtil.removeResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
				EducationImpl.class, education.getPrimaryKey());

			clearUniqueFindersCache(education);
		}
	}

	protected void cacheUniqueFindersCache(Education education) {
		if (education.isNew()) {
			Object[] args = new Object[] { education.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				education);
		}
		else {
			EducationModelImpl educationModelImpl = (EducationModelImpl)education;

			if ((educationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { education.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					education);
			}
		}
	}

	protected void clearUniqueFindersCache(Education education) {
		EducationModelImpl educationModelImpl = (EducationModelImpl)education;

		Object[] args = new Object[] { education.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((educationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { educationModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new education with the primary key. Does not add the education to the database.
	 *
	 * @param educationId the primary key for the new education
	 * @return the new education
	 */
	@Override
	public Education create(long educationId) {
		Education education = new EducationImpl();

		education.setNew(true);
		education.setPrimaryKey(educationId);

		return education;
	}

	/**
	 * Removes the education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the education
	 * @return the education that was removed
	 * @throws com.liferay.sample.NoSuchEducationException if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education remove(long educationId)
		throws NoSuchEducationException, SystemException {
		return remove((Serializable)educationId);
	}

	/**
	 * Removes the education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the education
	 * @return the education that was removed
	 * @throws com.liferay.sample.NoSuchEducationException if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education remove(Serializable primaryKey)
		throws NoSuchEducationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Education education = (Education)session.get(EducationImpl.class,
					primaryKey);

			if (education == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEducationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(education);
		}
		catch (NoSuchEducationException nsee) {
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
	protected Education removeImpl(Education education)
		throws SystemException {
		education = toUnwrappedModel(education);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(education)) {
				education = (Education)session.get(EducationImpl.class,
						education.getPrimaryKeyObj());
			}

			if (education != null) {
				session.delete(education);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (education != null) {
			clearCache(education);
		}

		return education;
	}

	@Override
	public Education updateImpl(com.liferay.sample.model.Education education)
		throws SystemException {
		education = toUnwrappedModel(education);

		boolean isNew = education.isNew();

		Session session = null;

		try {
			session = openSession();

			if (education.isNew()) {
				session.save(education);

				education.setNew(false);
			}
			else {
				session.merge(education);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EducationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
			EducationImpl.class, education.getPrimaryKey(), education);

		clearUniqueFindersCache(education);
		cacheUniqueFindersCache(education);

		return education;
	}

	protected Education toUnwrappedModel(Education education) {
		if (education instanceof EducationImpl) {
			return education;
		}

		EducationImpl educationImpl = new EducationImpl();

		educationImpl.setNew(education.isNew());
		educationImpl.setPrimaryKey(education.getPrimaryKey());

		educationImpl.setEducationId(education.getEducationId());
		educationImpl.setUserId(education.getUserId());
		educationImpl.setSchoolName(education.getSchoolName());
		educationImpl.setDegreeId(education.getDegreeId());
		educationImpl.setGraduateYear(education.getGraduateYear());
		educationImpl.setRecommender(education.getRecommender());
		educationImpl.setIntroduction(education.getIntroduction());

		return educationImpl;
	}

	/**
	 * Returns the education with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the education
	 * @return the education
	 * @throws com.liferay.sample.NoSuchEducationException if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEducationException, SystemException {
		Education education = fetchByPrimaryKey(primaryKey);

		if (education == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEducationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return education;
	}

	/**
	 * Returns the education with the primary key or throws a {@link com.liferay.sample.NoSuchEducationException} if it could not be found.
	 *
	 * @param educationId the primary key of the education
	 * @return the education
	 * @throws com.liferay.sample.NoSuchEducationException if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education findByPrimaryKey(long educationId)
		throws NoSuchEducationException, SystemException {
		return findByPrimaryKey((Serializable)educationId);
	}

	/**
	 * Returns the education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the education
	 * @return the education, or <code>null</code> if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Education education = (Education)EntityCacheUtil.getResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
				EducationImpl.class, primaryKey);

		if (education == _nullEducation) {
			return null;
		}

		if (education == null) {
			Session session = null;

			try {
				session = openSession();

				education = (Education)session.get(EducationImpl.class,
						primaryKey);

				if (education != null) {
					cacheResult(education);
				}
				else {
					EntityCacheUtil.putResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
						EducationImpl.class, primaryKey, _nullEducation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EducationModelImpl.ENTITY_CACHE_ENABLED,
					EducationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return education;
	}

	/**
	 * Returns the education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education
	 * @return the education, or <code>null</code> if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education fetchByPrimaryKey(long educationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)educationId);
	}

	/**
	 * Returns all the educations.
	 *
	 * @return the educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Education> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Education> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Education> findAll(int start, int end,
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

		List<Education> list = (List<Education>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EDUCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EDUCATION;

				if (pagination) {
					sql = sql.concat(EducationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Education>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Education>(list);
				}
				else {
					list = (List<Education>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the educations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Education education : findAll()) {
			remove(education);
		}
	}

	/**
	 * Returns the number of educations.
	 *
	 * @return the number of educations
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

				Query q = session.createQuery(_SQL_COUNT_EDUCATION);

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
	 * Initializes the education persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Education")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Education>> listenersList = new ArrayList<ModelListener<Education>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Education>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EducationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EDUCATION = "SELECT education FROM Education education";
	private static final String _SQL_SELECT_EDUCATION_WHERE = "SELECT education FROM Education education WHERE ";
	private static final String _SQL_COUNT_EDUCATION = "SELECT COUNT(education) FROM Education education";
	private static final String _SQL_COUNT_EDUCATION_WHERE = "SELECT COUNT(education) FROM Education education WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "education.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Education exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Education exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EducationPersistenceImpl.class);
	private static Education _nullEducation = new EducationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Education> toCacheModel() {
				return _nullEducationCacheModel;
			}
		};

	private static CacheModel<Education> _nullEducationCacheModel = new CacheModel<Education>() {
			@Override
			public Education toEntityModel() {
				return _nullEducation;
			}
		};
}