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

import com.liferay.sample.NoSuchDegreeException;
import com.liferay.sample.model.Degree;
import com.liferay.sample.model.impl.DegreeImpl;
import com.liferay.sample.model.impl.DegreeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the degree service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see DegreePersistence
 * @see DegreeUtil
 * @generated
 */
public class DegreePersistenceImpl extends BasePersistenceImpl<Degree>
	implements DegreePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DegreeUtil} to access the degree persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DegreeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DegreeModelImpl.ENTITY_CACHE_ENABLED,
			DegreeModelImpl.FINDER_CACHE_ENABLED, DegreeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DegreeModelImpl.ENTITY_CACHE_ENABLED,
			DegreeModelImpl.FINDER_CACHE_ENABLED, DegreeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DegreeModelImpl.ENTITY_CACHE_ENABLED,
			DegreeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DegreePersistenceImpl() {
		setModelClass(Degree.class);
	}

	/**
	 * Caches the degree in the entity cache if it is enabled.
	 *
	 * @param degree the degree
	 */
	@Override
	public void cacheResult(Degree degree) {
		EntityCacheUtil.putResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
			DegreeImpl.class, degree.getPrimaryKey(), degree);

		degree.resetOriginalValues();
	}

	/**
	 * Caches the degrees in the entity cache if it is enabled.
	 *
	 * @param degrees the degrees
	 */
	@Override
	public void cacheResult(List<Degree> degrees) {
		for (Degree degree : degrees) {
			if (EntityCacheUtil.getResult(
						DegreeModelImpl.ENTITY_CACHE_ENABLED, DegreeImpl.class,
						degree.getPrimaryKey()) == null) {
				cacheResult(degree);
			}
			else {
				degree.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all degrees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DegreeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DegreeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the degree.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Degree degree) {
		EntityCacheUtil.removeResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
			DegreeImpl.class, degree.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Degree> degrees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Degree degree : degrees) {
			EntityCacheUtil.removeResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
				DegreeImpl.class, degree.getPrimaryKey());
		}
	}

	/**
	 * Creates a new degree with the primary key. Does not add the degree to the database.
	 *
	 * @param degreeId the primary key for the new degree
	 * @return the new degree
	 */
	@Override
	public Degree create(long degreeId) {
		Degree degree = new DegreeImpl();

		degree.setNew(true);
		degree.setPrimaryKey(degreeId);

		return degree;
	}

	/**
	 * Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree that was removed
	 * @throws com.liferay.sample.NoSuchDegreeException if a degree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Degree remove(long degreeId)
		throws NoSuchDegreeException, SystemException {
		return remove((Serializable)degreeId);
	}

	/**
	 * Removes the degree with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the degree
	 * @return the degree that was removed
	 * @throws com.liferay.sample.NoSuchDegreeException if a degree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Degree remove(Serializable primaryKey)
		throws NoSuchDegreeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Degree degree = (Degree)session.get(DegreeImpl.class, primaryKey);

			if (degree == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDegreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(degree);
		}
		catch (NoSuchDegreeException nsee) {
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
	protected Degree removeImpl(Degree degree) throws SystemException {
		degree = toUnwrappedModel(degree);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(degree)) {
				degree = (Degree)session.get(DegreeImpl.class,
						degree.getPrimaryKeyObj());
			}

			if (degree != null) {
				session.delete(degree);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (degree != null) {
			clearCache(degree);
		}

		return degree;
	}

	@Override
	public Degree updateImpl(com.liferay.sample.model.Degree degree)
		throws SystemException {
		degree = toUnwrappedModel(degree);

		boolean isNew = degree.isNew();

		Session session = null;

		try {
			session = openSession();

			if (degree.isNew()) {
				session.save(degree);

				degree.setNew(false);
			}
			else {
				session.merge(degree);
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

		EntityCacheUtil.putResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
			DegreeImpl.class, degree.getPrimaryKey(), degree);

		return degree;
	}

	protected Degree toUnwrappedModel(Degree degree) {
		if (degree instanceof DegreeImpl) {
			return degree;
		}

		DegreeImpl degreeImpl = new DegreeImpl();

		degreeImpl.setNew(degree.isNew());
		degreeImpl.setPrimaryKey(degree.getPrimaryKey());

		degreeImpl.setDegreeId(degree.getDegreeId());
		degreeImpl.setDegreeName(degree.getDegreeName());

		return degreeImpl;
	}

	/**
	 * Returns the degree with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the degree
	 * @return the degree
	 * @throws com.liferay.sample.NoSuchDegreeException if a degree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Degree findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDegreeException, SystemException {
		Degree degree = fetchByPrimaryKey(primaryKey);

		if (degree == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDegreeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return degree;
	}

	/**
	 * Returns the degree with the primary key or throws a {@link com.liferay.sample.NoSuchDegreeException} if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree
	 * @throws com.liferay.sample.NoSuchDegreeException if a degree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Degree findByPrimaryKey(long degreeId)
		throws NoSuchDegreeException, SystemException {
		return findByPrimaryKey((Serializable)degreeId);
	}

	/**
	 * Returns the degree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the degree
	 * @return the degree, or <code>null</code> if a degree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Degree fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Degree degree = (Degree)EntityCacheUtil.getResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
				DegreeImpl.class, primaryKey);

		if (degree == _nullDegree) {
			return null;
		}

		if (degree == null) {
			Session session = null;

			try {
				session = openSession();

				degree = (Degree)session.get(DegreeImpl.class, primaryKey);

				if (degree != null) {
					cacheResult(degree);
				}
				else {
					EntityCacheUtil.putResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
						DegreeImpl.class, primaryKey, _nullDegree);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DegreeModelImpl.ENTITY_CACHE_ENABLED,
					DegreeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return degree;
	}

	/**
	 * Returns the degree with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param degreeId the primary key of the degree
	 * @return the degree, or <code>null</code> if a degree with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Degree fetchByPrimaryKey(long degreeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)degreeId);
	}

	/**
	 * Returns all the degrees.
	 *
	 * @return the degrees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Degree> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Degree> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Degree> findAll(int start, int end,
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

		List<Degree> list = (List<Degree>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEGREE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEGREE;

				if (pagination) {
					sql = sql.concat(DegreeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Degree>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Degree>(list);
				}
				else {
					list = (List<Degree>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the degrees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Degree degree : findAll()) {
			remove(degree);
		}
	}

	/**
	 * Returns the number of degrees.
	 *
	 * @return the number of degrees
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

				Query q = session.createQuery(_SQL_COUNT_DEGREE);

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
	 * Initializes the degree persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Degree")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Degree>> listenersList = new ArrayList<ModelListener<Degree>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Degree>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DegreeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEGREE = "SELECT degree FROM Degree degree";
	private static final String _SQL_COUNT_DEGREE = "SELECT COUNT(degree) FROM Degree degree";
	private static final String _ORDER_BY_ENTITY_ALIAS = "degree.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Degree exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DegreePersistenceImpl.class);
	private static Degree _nullDegree = new DegreeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Degree> toCacheModel() {
				return _nullDegreeCacheModel;
			}
		};

	private static CacheModel<Degree> _nullDegreeCacheModel = new CacheModel<Degree>() {
			@Override
			public Degree toEntityModel() {
				return _nullDegree;
			}
		};
}