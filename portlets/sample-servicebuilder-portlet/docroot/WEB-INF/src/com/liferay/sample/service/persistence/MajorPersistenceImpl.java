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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.sample.NoSuchMajorException;
import com.liferay.sample.model.Major;
import com.liferay.sample.model.impl.MajorImpl;
import com.liferay.sample.model.impl.MajorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the major service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see MajorPersistence
 * @see MajorUtil
 * @generated
 */
public class MajorPersistenceImpl extends BasePersistenceImpl<Major>
	implements MajorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MajorUtil} to access the major persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MajorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MajorModelImpl.ENTITY_CACHE_ENABLED,
			MajorModelImpl.FINDER_CACHE_ENABLED, MajorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MajorModelImpl.ENTITY_CACHE_ENABLED,
			MajorModelImpl.FINDER_CACHE_ENABLED, MajorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MajorModelImpl.ENTITY_CACHE_ENABLED,
			MajorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MajorPersistenceImpl() {
		setModelClass(Major.class);
	}

	/**
	 * Caches the major in the entity cache if it is enabled.
	 *
	 * @param major the major
	 */
	@Override
	public void cacheResult(Major major) {
		EntityCacheUtil.putResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
			MajorImpl.class, major.getPrimaryKey(), major);

		major.resetOriginalValues();
	}

	/**
	 * Caches the majors in the entity cache if it is enabled.
	 *
	 * @param majors the majors
	 */
	@Override
	public void cacheResult(List<Major> majors) {
		for (Major major : majors) {
			if (EntityCacheUtil.getResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
						MajorImpl.class, major.getPrimaryKey()) == null) {
				cacheResult(major);
			}
			else {
				major.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all majors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MajorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MajorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the major.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Major major) {
		EntityCacheUtil.removeResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
			MajorImpl.class, major.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Major> majors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Major major : majors) {
			EntityCacheUtil.removeResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
				MajorImpl.class, major.getPrimaryKey());
		}
	}

	/**
	 * Creates a new major with the primary key. Does not add the major to the database.
	 *
	 * @param majorId the primary key for the new major
	 * @return the new major
	 */
	@Override
	public Major create(long majorId) {
		Major major = new MajorImpl();

		major.setNew(true);
		major.setPrimaryKey(majorId);

		return major;
	}

	/**
	 * Removes the major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param majorId the primary key of the major
	 * @return the major that was removed
	 * @throws com.liferay.sample.NoSuchMajorException if a major with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Major remove(long majorId)
		throws NoSuchMajorException, SystemException {
		return remove((Serializable)majorId);
	}

	/**
	 * Removes the major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the major
	 * @return the major that was removed
	 * @throws com.liferay.sample.NoSuchMajorException if a major with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Major remove(Serializable primaryKey)
		throws NoSuchMajorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Major major = (Major)session.get(MajorImpl.class, primaryKey);

			if (major == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMajorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(major);
		}
		catch (NoSuchMajorException nsee) {
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
	protected Major removeImpl(Major major) throws SystemException {
		major = toUnwrappedModel(major);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(major)) {
				major = (Major)session.get(MajorImpl.class,
						major.getPrimaryKeyObj());
			}

			if (major != null) {
				session.delete(major);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (major != null) {
			clearCache(major);
		}

		return major;
	}

	@Override
	public Major updateImpl(com.liferay.sample.model.Major major)
		throws SystemException {
		major = toUnwrappedModel(major);

		boolean isNew = major.isNew();

		Session session = null;

		try {
			session = openSession();

			if (major.isNew()) {
				session.save(major);

				major.setNew(false);
			}
			else {
				session.merge(major);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
			MajorImpl.class, major.getPrimaryKey(), major);

		return major;
	}

	protected Major toUnwrappedModel(Major major) {
		if (major instanceof MajorImpl) {
			return major;
		}

		MajorImpl majorImpl = new MajorImpl();

		majorImpl.setNew(major.isNew());
		majorImpl.setPrimaryKey(major.getPrimaryKey());

		majorImpl.setMajorId(major.getMajorId());
		majorImpl.setMajorName(major.getMajorName());

		return majorImpl;
	}

	/**
	 * Returns the major with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the major
	 * @return the major
	 * @throws com.liferay.sample.NoSuchMajorException if a major with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Major findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMajorException, SystemException {
		Major major = fetchByPrimaryKey(primaryKey);

		if (major == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMajorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return major;
	}

	/**
	 * Returns the major with the primary key or throws a {@link com.liferay.sample.NoSuchMajorException} if it could not be found.
	 *
	 * @param majorId the primary key of the major
	 * @return the major
	 * @throws com.liferay.sample.NoSuchMajorException if a major with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Major findByPrimaryKey(long majorId)
		throws NoSuchMajorException, SystemException {
		return findByPrimaryKey((Serializable)majorId);
	}

	/**
	 * Returns the major with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the major
	 * @return the major, or <code>null</code> if a major with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Major fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Major major = (Major)EntityCacheUtil.getResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
				MajorImpl.class, primaryKey);

		if (major == _nullMajor) {
			return null;
		}

		if (major == null) {
			Session session = null;

			try {
				session = openSession();

				major = (Major)session.get(MajorImpl.class, primaryKey);

				if (major != null) {
					cacheResult(major);
				}
				else {
					EntityCacheUtil.putResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
						MajorImpl.class, primaryKey, _nullMajor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MajorModelImpl.ENTITY_CACHE_ENABLED,
					MajorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return major;
	}

	/**
	 * Returns the major with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param majorId the primary key of the major
	 * @return the major, or <code>null</code> if a major with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Major fetchByPrimaryKey(long majorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)majorId);
	}

	/**
	 * Returns all the majors.
	 *
	 * @return the majors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Major> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Major> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Major> findAll(int start, int end,
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

		List<Major> list = (List<Major>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MAJOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAJOR;

				if (pagination) {
					sql = sql.concat(MajorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Major>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Major>(list);
				}
				else {
					list = (List<Major>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the majors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Major major : findAll()) {
			remove(major);
		}
	}

	/**
	 * Returns the number of majors.
	 *
	 * @return the number of majors
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

				Query q = session.createQuery(_SQL_COUNT_MAJOR);

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
	 * Initializes the major persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Major")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Major>> listenersList = new ArrayList<ModelListener<Major>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Major>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MajorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MAJOR = "SELECT major FROM Major major";
	private static final String _SQL_COUNT_MAJOR = "SELECT COUNT(major) FROM Major major";
	private static final String _ORDER_BY_ENTITY_ALIAS = "major.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Major exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MajorPersistenceImpl.class);
	private static Major _nullMajor = new MajorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Major> toCacheModel() {
				return _nullMajorCacheModel;
			}
		};

	private static CacheModel<Major> _nullMajorCacheModel = new CacheModel<Major>() {
			@Override
			public Major toEntityModel() {
				return _nullMajor;
			}
		};
}