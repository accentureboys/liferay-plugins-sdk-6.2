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

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
	private static final String _SQL_COUNT_THESIS = "SELECT COUNT(thesis) FROM Thesis thesis";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thesis.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Thesis exists with the primary key ";
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