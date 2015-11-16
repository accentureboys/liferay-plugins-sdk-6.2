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

import com.liferay.sample.NoSuchPropertyException;
import com.liferay.sample.model.Property;
import com.liferay.sample.model.impl.PropertyImpl;
import com.liferay.sample.model.impl.PropertyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jasonxiang
 * @see PropertyPersistence
 * @see PropertyUtil
 * @generated
 */
public class PropertyPersistenceImpl extends BasePersistenceImpl<Property>
	implements PropertyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PropertyUtil} to access the property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PropertyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PropertyModelImpl.ENTITY_CACHE_ENABLED,
			PropertyModelImpl.FINDER_CACHE_ENABLED, PropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PropertyModelImpl.ENTITY_CACHE_ENABLED,
			PropertyModelImpl.FINDER_CACHE_ENABLED, PropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PropertyModelImpl.ENTITY_CACHE_ENABLED,
			PropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PropertyPersistenceImpl() {
		setModelClass(Property.class);
	}

	/**
	 * Caches the property in the entity cache if it is enabled.
	 *
	 * @param property the property
	 */
	@Override
	public void cacheResult(Property property) {
		EntityCacheUtil.putResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
			PropertyImpl.class, property.getPrimaryKey(), property);

		property.resetOriginalValues();
	}

	/**
	 * Caches the properties in the entity cache if it is enabled.
	 *
	 * @param properties the properties
	 */
	@Override
	public void cacheResult(List<Property> properties) {
		for (Property property : properties) {
			if (EntityCacheUtil.getResult(
						PropertyModelImpl.ENTITY_CACHE_ENABLED,
						PropertyImpl.class, property.getPrimaryKey()) == null) {
				cacheResult(property);
			}
			else {
				property.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PropertyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PropertyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the property.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Property property) {
		EntityCacheUtil.removeResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
			PropertyImpl.class, property.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Property> properties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Property property : properties) {
			EntityCacheUtil.removeResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
				PropertyImpl.class, property.getPrimaryKey());
		}
	}

	/**
	 * Creates a new property with the primary key. Does not add the property to the database.
	 *
	 * @param propertyId the primary key for the new property
	 * @return the new property
	 */
	@Override
	public Property create(long propertyId) {
		Property property = new PropertyImpl();

		property.setNew(true);
		property.setPrimaryKey(propertyId);

		return property;
	}

	/**
	 * Removes the property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param propertyId the primary key of the property
	 * @return the property that was removed
	 * @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Property remove(long propertyId)
		throws NoSuchPropertyException, SystemException {
		return remove((Serializable)propertyId);
	}

	/**
	 * Removes the property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the property
	 * @return the property that was removed
	 * @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Property remove(Serializable primaryKey)
		throws NoSuchPropertyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Property property = (Property)session.get(PropertyImpl.class,
					primaryKey);

			if (property == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(property);
		}
		catch (NoSuchPropertyException nsee) {
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
	protected Property removeImpl(Property property) throws SystemException {
		property = toUnwrappedModel(property);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(property)) {
				property = (Property)session.get(PropertyImpl.class,
						property.getPrimaryKeyObj());
			}

			if (property != null) {
				session.delete(property);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (property != null) {
			clearCache(property);
		}

		return property;
	}

	@Override
	public Property updateImpl(com.liferay.sample.model.Property property)
		throws SystemException {
		property = toUnwrappedModel(property);

		boolean isNew = property.isNew();

		Session session = null;

		try {
			session = openSession();

			if (property.isNew()) {
				session.save(property);

				property.setNew(false);
			}
			else {
				session.merge(property);
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

		EntityCacheUtil.putResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
			PropertyImpl.class, property.getPrimaryKey(), property);

		return property;
	}

	protected Property toUnwrappedModel(Property property) {
		if (property instanceof PropertyImpl) {
			return property;
		}

		PropertyImpl propertyImpl = new PropertyImpl();

		propertyImpl.setNew(property.isNew());
		propertyImpl.setPrimaryKey(property.getPrimaryKey());

		propertyImpl.setPropertyId(property.getPropertyId());
		propertyImpl.setPropertyName(property.getPropertyName());
		propertyImpl.setUserId(property.getUserId());

		return propertyImpl;
	}

	/**
	 * Returns the property with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the property
	 * @return the property
	 * @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Property findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPropertyException, SystemException {
		Property property = fetchByPrimaryKey(primaryKey);

		if (property == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return property;
	}

	/**
	 * Returns the property with the primary key or throws a {@link com.liferay.sample.NoSuchPropertyException} if it could not be found.
	 *
	 * @param propertyId the primary key of the property
	 * @return the property
	 * @throws com.liferay.sample.NoSuchPropertyException if a property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Property findByPrimaryKey(long propertyId)
		throws NoSuchPropertyException, SystemException {
		return findByPrimaryKey((Serializable)propertyId);
	}

	/**
	 * Returns the property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the property
	 * @return the property, or <code>null</code> if a property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Property fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Property property = (Property)EntityCacheUtil.getResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
				PropertyImpl.class, primaryKey);

		if (property == _nullProperty) {
			return null;
		}

		if (property == null) {
			Session session = null;

			try {
				session = openSession();

				property = (Property)session.get(PropertyImpl.class, primaryKey);

				if (property != null) {
					cacheResult(property);
				}
				else {
					EntityCacheUtil.putResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
						PropertyImpl.class, primaryKey, _nullProperty);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PropertyModelImpl.ENTITY_CACHE_ENABLED,
					PropertyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return property;
	}

	/**
	 * Returns the property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param propertyId the primary key of the property
	 * @return the property, or <code>null</code> if a property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Property fetchByPrimaryKey(long propertyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)propertyId);
	}

	/**
	 * Returns all the properties.
	 *
	 * @return the properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Property> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.PropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of properties
	 * @param end the upper bound of the range of properties (not inclusive)
	 * @return the range of properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Property> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.PropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of properties
	 * @param end the upper bound of the range of properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Property> findAll(int start, int end,
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

		List<Property> list = (List<Property>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROPERTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPERTY;

				if (pagination) {
					sql = sql.concat(PropertyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Property>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Property>(list);
				}
				else {
					list = (List<Property>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Property property : findAll()) {
			remove(property);
		}
	}

	/**
	 * Returns the number of properties.
	 *
	 * @return the number of properties
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

				Query q = session.createQuery(_SQL_COUNT_PROPERTY);

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
	 * Initializes the property persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.sample.model.Property")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Property>> listenersList = new ArrayList<ModelListener<Property>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Property>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PropertyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROPERTY = "SELECT property FROM Property property";
	private static final String _SQL_COUNT_PROPERTY = "SELECT COUNT(property) FROM Property property";
	private static final String _ORDER_BY_ENTITY_ALIAS = "property.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Property exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PropertyPersistenceImpl.class);
	private static Property _nullProperty = new PropertyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Property> toCacheModel() {
				return _nullPropertyCacheModel;
			}
		};

	private static CacheModel<Property> _nullPropertyCacheModel = new CacheModel<Property>() {
			@Override
			public Property toEntityModel() {
				return _nullProperty;
			}
		};
}