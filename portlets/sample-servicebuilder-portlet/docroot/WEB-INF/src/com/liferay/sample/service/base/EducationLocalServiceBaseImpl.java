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

package com.liferay.sample.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.sample.model.Education;
import com.liferay.sample.service.EducationLocalService;
import com.liferay.sample.service.persistence.DegreePersistence;
import com.liferay.sample.service.persistence.EducationPersistence;
import com.liferay.sample.service.persistence.HonourPersistence;
import com.liferay.sample.service.persistence.MajorPersistence;
import com.liferay.sample.service.persistence.PropertyPersistence;
import com.liferay.sample.service.persistence.ThesisPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the education local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.sample.service.impl.EducationLocalServiceImpl}.
 * </p>
 *
 * @author jasonxiang
 * @see com.liferay.sample.service.impl.EducationLocalServiceImpl
 * @see com.liferay.sample.service.EducationLocalServiceUtil
 * @generated
 */
public abstract class EducationLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements EducationLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.sample.service.EducationLocalServiceUtil} to access the education local service.
	 */

	/**
	 * Adds the education to the database. Also notifies the appropriate model listeners.
	 *
	 * @param education the education
	 * @return the education that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Education addEducation(Education education)
		throws SystemException {
		education.setNew(true);

		return educationPersistence.update(education);
	}

	/**
	 * Creates a new education with the primary key. Does not add the education to the database.
	 *
	 * @param educationId the primary key for the new education
	 * @return the new education
	 */
	@Override
	public Education createEducation(long educationId) {
		return educationPersistence.create(educationId);
	}

	/**
	 * Deletes the education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the education
	 * @return the education that was removed
	 * @throws PortalException if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Education deleteEducation(long educationId)
		throws PortalException, SystemException {
		return educationPersistence.remove(educationId);
	}

	/**
	 * Deletes the education from the database. Also notifies the appropriate model listeners.
	 *
	 * @param education the education
	 * @return the education that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Education deleteEducation(Education education)
		throws SystemException {
		return educationPersistence.remove(education);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Education.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return educationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return educationPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.model.impl.EducationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return educationPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return educationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return educationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Education fetchEducation(long educationId) throws SystemException {
		return educationPersistence.fetchByPrimaryKey(educationId);
	}

	/**
	 * Returns the education with the primary key.
	 *
	 * @param educationId the primary key of the education
	 * @return the education
	 * @throws PortalException if a education with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Education getEducation(long educationId)
		throws PortalException, SystemException {
		return educationPersistence.findByPrimaryKey(educationId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return educationPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Education> getEducations(int start, int end)
		throws SystemException {
		return educationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of educations.
	 *
	 * @return the number of educations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEducationsCount() throws SystemException {
		return educationPersistence.countAll();
	}

	/**
	 * Updates the education in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param education the education
	 * @return the education that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Education updateEducation(Education education)
		throws SystemException {
		return educationPersistence.update(education);
	}

	/**
	 * Returns the degree local service.
	 *
	 * @return the degree local service
	 */
	public com.liferay.sample.service.DegreeLocalService getDegreeLocalService() {
		return degreeLocalService;
	}

	/**
	 * Sets the degree local service.
	 *
	 * @param degreeLocalService the degree local service
	 */
	public void setDegreeLocalService(
		com.liferay.sample.service.DegreeLocalService degreeLocalService) {
		this.degreeLocalService = degreeLocalService;
	}

	/**
	 * Returns the degree remote service.
	 *
	 * @return the degree remote service
	 */
	public com.liferay.sample.service.DegreeService getDegreeService() {
		return degreeService;
	}

	/**
	 * Sets the degree remote service.
	 *
	 * @param degreeService the degree remote service
	 */
	public void setDegreeService(
		com.liferay.sample.service.DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	/**
	 * Returns the degree persistence.
	 *
	 * @return the degree persistence
	 */
	public DegreePersistence getDegreePersistence() {
		return degreePersistence;
	}

	/**
	 * Sets the degree persistence.
	 *
	 * @param degreePersistence the degree persistence
	 */
	public void setDegreePersistence(DegreePersistence degreePersistence) {
		this.degreePersistence = degreePersistence;
	}

	/**
	 * Returns the education local service.
	 *
	 * @return the education local service
	 */
	public com.liferay.sample.service.EducationLocalService getEducationLocalService() {
		return educationLocalService;
	}

	/**
	 * Sets the education local service.
	 *
	 * @param educationLocalService the education local service
	 */
	public void setEducationLocalService(
		com.liferay.sample.service.EducationLocalService educationLocalService) {
		this.educationLocalService = educationLocalService;
	}

	/**
	 * Returns the education remote service.
	 *
	 * @return the education remote service
	 */
	public com.liferay.sample.service.EducationService getEducationService() {
		return educationService;
	}

	/**
	 * Sets the education remote service.
	 *
	 * @param educationService the education remote service
	 */
	public void setEducationService(
		com.liferay.sample.service.EducationService educationService) {
		this.educationService = educationService;
	}

	/**
	 * Returns the education persistence.
	 *
	 * @return the education persistence
	 */
	public EducationPersistence getEducationPersistence() {
		return educationPersistence;
	}

	/**
	 * Sets the education persistence.
	 *
	 * @param educationPersistence the education persistence
	 */
	public void setEducationPersistence(
		EducationPersistence educationPersistence) {
		this.educationPersistence = educationPersistence;
	}

	/**
	 * Returns the honour local service.
	 *
	 * @return the honour local service
	 */
	public com.liferay.sample.service.HonourLocalService getHonourLocalService() {
		return honourLocalService;
	}

	/**
	 * Sets the honour local service.
	 *
	 * @param honourLocalService the honour local service
	 */
	public void setHonourLocalService(
		com.liferay.sample.service.HonourLocalService honourLocalService) {
		this.honourLocalService = honourLocalService;
	}

	/**
	 * Returns the honour remote service.
	 *
	 * @return the honour remote service
	 */
	public com.liferay.sample.service.HonourService getHonourService() {
		return honourService;
	}

	/**
	 * Sets the honour remote service.
	 *
	 * @param honourService the honour remote service
	 */
	public void setHonourService(
		com.liferay.sample.service.HonourService honourService) {
		this.honourService = honourService;
	}

	/**
	 * Returns the honour persistence.
	 *
	 * @return the honour persistence
	 */
	public HonourPersistence getHonourPersistence() {
		return honourPersistence;
	}

	/**
	 * Sets the honour persistence.
	 *
	 * @param honourPersistence the honour persistence
	 */
	public void setHonourPersistence(HonourPersistence honourPersistence) {
		this.honourPersistence = honourPersistence;
	}

	/**
	 * Returns the major local service.
	 *
	 * @return the major local service
	 */
	public com.liferay.sample.service.MajorLocalService getMajorLocalService() {
		return majorLocalService;
	}

	/**
	 * Sets the major local service.
	 *
	 * @param majorLocalService the major local service
	 */
	public void setMajorLocalService(
		com.liferay.sample.service.MajorLocalService majorLocalService) {
		this.majorLocalService = majorLocalService;
	}

	/**
	 * Returns the major remote service.
	 *
	 * @return the major remote service
	 */
	public com.liferay.sample.service.MajorService getMajorService() {
		return majorService;
	}

	/**
	 * Sets the major remote service.
	 *
	 * @param majorService the major remote service
	 */
	public void setMajorService(
		com.liferay.sample.service.MajorService majorService) {
		this.majorService = majorService;
	}

	/**
	 * Returns the major persistence.
	 *
	 * @return the major persistence
	 */
	public MajorPersistence getMajorPersistence() {
		return majorPersistence;
	}

	/**
	 * Sets the major persistence.
	 *
	 * @param majorPersistence the major persistence
	 */
	public void setMajorPersistence(MajorPersistence majorPersistence) {
		this.majorPersistence = majorPersistence;
	}

	/**
	 * Returns the property local service.
	 *
	 * @return the property local service
	 */
	public com.liferay.sample.service.PropertyLocalService getPropertyLocalService() {
		return propertyLocalService;
	}

	/**
	 * Sets the property local service.
	 *
	 * @param propertyLocalService the property local service
	 */
	public void setPropertyLocalService(
		com.liferay.sample.service.PropertyLocalService propertyLocalService) {
		this.propertyLocalService = propertyLocalService;
	}

	/**
	 * Returns the property remote service.
	 *
	 * @return the property remote service
	 */
	public com.liferay.sample.service.PropertyService getPropertyService() {
		return propertyService;
	}

	/**
	 * Sets the property remote service.
	 *
	 * @param propertyService the property remote service
	 */
	public void setPropertyService(
		com.liferay.sample.service.PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	/**
	 * Returns the property persistence.
	 *
	 * @return the property persistence
	 */
	public PropertyPersistence getPropertyPersistence() {
		return propertyPersistence;
	}

	/**
	 * Sets the property persistence.
	 *
	 * @param propertyPersistence the property persistence
	 */
	public void setPropertyPersistence(PropertyPersistence propertyPersistence) {
		this.propertyPersistence = propertyPersistence;
	}

	/**
	 * Returns the thesis local service.
	 *
	 * @return the thesis local service
	 */
	public com.liferay.sample.service.ThesisLocalService getThesisLocalService() {
		return thesisLocalService;
	}

	/**
	 * Sets the thesis local service.
	 *
	 * @param thesisLocalService the thesis local service
	 */
	public void setThesisLocalService(
		com.liferay.sample.service.ThesisLocalService thesisLocalService) {
		this.thesisLocalService = thesisLocalService;
	}

	/**
	 * Returns the thesis remote service.
	 *
	 * @return the thesis remote service
	 */
	public com.liferay.sample.service.ThesisService getThesisService() {
		return thesisService;
	}

	/**
	 * Sets the thesis remote service.
	 *
	 * @param thesisService the thesis remote service
	 */
	public void setThesisService(
		com.liferay.sample.service.ThesisService thesisService) {
		this.thesisService = thesisService;
	}

	/**
	 * Returns the thesis persistence.
	 *
	 * @return the thesis persistence
	 */
	public ThesisPersistence getThesisPersistence() {
		return thesisPersistence;
	}

	/**
	 * Sets the thesis persistence.
	 *
	 * @param thesisPersistence the thesis persistence
	 */
	public void setThesisPersistence(ThesisPersistence thesisPersistence) {
		this.thesisPersistence = thesisPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.sample.model.Education",
			educationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.sample.model.Education");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Education.class;
	}

	protected String getModelClassName() {
		return Education.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = educationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.sample.service.DegreeLocalService.class)
	protected com.liferay.sample.service.DegreeLocalService degreeLocalService;
	@BeanReference(type = com.liferay.sample.service.DegreeService.class)
	protected com.liferay.sample.service.DegreeService degreeService;
	@BeanReference(type = DegreePersistence.class)
	protected DegreePersistence degreePersistence;
	@BeanReference(type = com.liferay.sample.service.EducationLocalService.class)
	protected com.liferay.sample.service.EducationLocalService educationLocalService;
	@BeanReference(type = com.liferay.sample.service.EducationService.class)
	protected com.liferay.sample.service.EducationService educationService;
	@BeanReference(type = EducationPersistence.class)
	protected EducationPersistence educationPersistence;
	@BeanReference(type = com.liferay.sample.service.HonourLocalService.class)
	protected com.liferay.sample.service.HonourLocalService honourLocalService;
	@BeanReference(type = com.liferay.sample.service.HonourService.class)
	protected com.liferay.sample.service.HonourService honourService;
	@BeanReference(type = HonourPersistence.class)
	protected HonourPersistence honourPersistence;
	@BeanReference(type = com.liferay.sample.service.MajorLocalService.class)
	protected com.liferay.sample.service.MajorLocalService majorLocalService;
	@BeanReference(type = com.liferay.sample.service.MajorService.class)
	protected com.liferay.sample.service.MajorService majorService;
	@BeanReference(type = MajorPersistence.class)
	protected MajorPersistence majorPersistence;
	@BeanReference(type = com.liferay.sample.service.PropertyLocalService.class)
	protected com.liferay.sample.service.PropertyLocalService propertyLocalService;
	@BeanReference(type = com.liferay.sample.service.PropertyService.class)
	protected com.liferay.sample.service.PropertyService propertyService;
	@BeanReference(type = PropertyPersistence.class)
	protected PropertyPersistence propertyPersistence;
	@BeanReference(type = com.liferay.sample.service.ThesisLocalService.class)
	protected com.liferay.sample.service.ThesisLocalService thesisLocalService;
	@BeanReference(type = com.liferay.sample.service.ThesisService.class)
	protected com.liferay.sample.service.ThesisService thesisService;
	@BeanReference(type = ThesisPersistence.class)
	protected ThesisPersistence thesisPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private EducationLocalServiceClpInvoker _clpInvoker = new EducationLocalServiceClpInvoker();
}