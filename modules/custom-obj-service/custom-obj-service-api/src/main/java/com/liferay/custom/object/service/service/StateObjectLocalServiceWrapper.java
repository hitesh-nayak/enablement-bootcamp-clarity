/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link StateObjectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StateObjectLocalService
 * @generated
 */
public class StateObjectLocalServiceWrapper
	implements ServiceWrapper<StateObjectLocalService>,
			   StateObjectLocalService {

	public StateObjectLocalServiceWrapper() {
		this(null);
	}

	public StateObjectLocalServiceWrapper(
		StateObjectLocalService stateObjectLocalService) {

		_stateObjectLocalService = stateObjectLocalService;
	}

	/**
	 * Adds the state object to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateObjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateObject the state object
	 * @return the state object that was added
	 */
	@Override
	public com.liferay.custom.object.service.model.StateObject addStateObject(
		com.liferay.custom.object.service.model.StateObject stateObject) {

		return _stateObjectLocalService.addStateObject(stateObject);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateObjectLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new state object with the primary key. Does not add the state object to the database.
	 *
	 * @param stateId the primary key for the new state object
	 * @return the new state object
	 */
	@Override
	public com.liferay.custom.object.service.model.StateObject
		createStateObject(long stateId) {

		return _stateObjectLocalService.createStateObject(stateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateObjectLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the state object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateObjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object that was removed
	 * @throws PortalException if a state object with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.object.service.model.StateObject
			deleteStateObject(long stateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateObjectLocalService.deleteStateObject(stateId);
	}

	/**
	 * Deletes the state object from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateObjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateObject the state object
	 * @return the state object that was removed
	 */
	@Override
	public com.liferay.custom.object.service.model.StateObject
		deleteStateObject(
			com.liferay.custom.object.service.model.StateObject stateObject) {

		return _stateObjectLocalService.deleteStateObject(stateObject);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _stateObjectLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _stateObjectLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stateObjectLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stateObjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.object.service.model.impl.StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stateObjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.object.service.model.impl.StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stateObjectLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stateObjectLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stateObjectLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.custom.object.service.model.StateObject fetchStateObject(
		long stateId) {

		return _stateObjectLocalService.fetchStateObject(stateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stateObjectLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stateObjectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stateObjectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateObjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the state object with the primary key.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object
	 * @throws PortalException if a state object with the primary key could not be found
	 */
	@Override
	public com.liferay.custom.object.service.model.StateObject getStateObject(
			long stateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateObjectLocalService.getStateObject(stateId);
	}

	/**
	 * Returns a range of all the state objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.custom.object.service.model.impl.StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @return the range of state objects
	 */
	@Override
	public java.util.List<com.liferay.custom.object.service.model.StateObject>
		getStateObjects(int start, int end) {

		return _stateObjectLocalService.getStateObjects(start, end);
	}

	/**
	 * Returns the number of state objects.
	 *
	 * @return the number of state objects
	 */
	@Override
	public int getStateObjectsCount() {
		return _stateObjectLocalService.getStateObjectsCount();
	}

	/**
	 * Updates the state object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateObjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateObject the state object
	 * @return the state object that was updated
	 */
	@Override
	public com.liferay.custom.object.service.model.StateObject
		updateStateObject(
			com.liferay.custom.object.service.model.StateObject stateObject) {

		return _stateObjectLocalService.updateStateObject(stateObject);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _stateObjectLocalService.getBasePersistence();
	}

	@Override
	public StateObjectLocalService getWrappedService() {
		return _stateObjectLocalService;
	}

	@Override
	public void setWrappedService(
		StateObjectLocalService stateObjectLocalService) {

		_stateObjectLocalService = stateObjectLocalService;
	}

	private StateObjectLocalService _stateObjectLocalService;

}