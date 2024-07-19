/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.service.persistence;

import com.liferay.custom.object.service.model.StateObject;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the state object service. This utility wraps <code>com.liferay.custom.object.service.service.persistence.impl.StateObjectPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StateObjectPersistence
 * @generated
 */
public class StateObjectUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StateObject stateObject) {
		getPersistence().clearCache(stateObject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StateObject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StateObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StateObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StateObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StateObject> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StateObject update(StateObject stateObject) {
		return getPersistence().update(stateObject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StateObject update(
		StateObject stateObject, ServiceContext serviceContext) {

		return getPersistence().update(stateObject, serviceContext);
	}

	/**
	 * Returns all the state objects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching state objects
	 */
	public static List<StateObject> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the state objects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @return the range of matching state objects
	 */
	public static List<StateObject> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the state objects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching state objects
	 */
	public static List<StateObject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StateObject> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the state objects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching state objects
	 */
	public static List<StateObject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StateObject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state object
	 * @throws NoSuchStateObjectException if a matching state object could not be found
	 */
	public static StateObject findByUuid_First(
			String uuid, OrderByComparator<StateObject> orderByComparator)
		throws com.liferay.custom.object.service.exception.
			NoSuchStateObjectException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state object, or <code>null</code> if a matching state object could not be found
	 */
	public static StateObject fetchByUuid_First(
		String uuid, OrderByComparator<StateObject> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state object
	 * @throws NoSuchStateObjectException if a matching state object could not be found
	 */
	public static StateObject findByUuid_Last(
			String uuid, OrderByComparator<StateObject> orderByComparator)
		throws com.liferay.custom.object.service.exception.
			NoSuchStateObjectException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state object, or <code>null</code> if a matching state object could not be found
	 */
	public static StateObject fetchByUuid_Last(
		String uuid, OrderByComparator<StateObject> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the state objects before and after the current state object in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current state object
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state object
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	public static StateObject[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			OrderByComparator<StateObject> orderByComparator)
		throws com.liferay.custom.object.service.exception.
			NoSuchStateObjectException {

		return getPersistence().findByUuid_PrevAndNext(
			stateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the state objects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of state objects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching state objects
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the state object in the entity cache if it is enabled.
	 *
	 * @param stateObject the state object
	 */
	public static void cacheResult(StateObject stateObject) {
		getPersistence().cacheResult(stateObject);
	}

	/**
	 * Caches the state objects in the entity cache if it is enabled.
	 *
	 * @param stateObjects the state objects
	 */
	public static void cacheResult(List<StateObject> stateObjects) {
		getPersistence().cacheResult(stateObjects);
	}

	/**
	 * Creates a new state object with the primary key. Does not add the state object to the database.
	 *
	 * @param stateId the primary key for the new state object
	 * @return the new state object
	 */
	public static StateObject create(long stateId) {
		return getPersistence().create(stateId);
	}

	/**
	 * Removes the state object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object that was removed
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	public static StateObject remove(long stateId)
		throws com.liferay.custom.object.service.exception.
			NoSuchStateObjectException {

		return getPersistence().remove(stateId);
	}

	public static StateObject updateImpl(StateObject stateObject) {
		return getPersistence().updateImpl(stateObject);
	}

	/**
	 * Returns the state object with the primary key or throws a <code>NoSuchStateObjectException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	public static StateObject findByPrimaryKey(long stateId)
		throws com.liferay.custom.object.service.exception.
			NoSuchStateObjectException {

		return getPersistence().findByPrimaryKey(stateId);
	}

	/**
	 * Returns the state object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object, or <code>null</code> if a state object with the primary key could not be found
	 */
	public static StateObject fetchByPrimaryKey(long stateId) {
		return getPersistence().fetchByPrimaryKey(stateId);
	}

	/**
	 * Returns all the state objects.
	 *
	 * @return the state objects
	 */
	public static List<StateObject> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the state objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @return the range of state objects
	 */
	public static List<StateObject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the state objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of state objects
	 */
	public static List<StateObject> findAll(
		int start, int end, OrderByComparator<StateObject> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the state objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of state objects
	 * @param end the upper bound of the range of state objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of state objects
	 */
	public static List<StateObject> findAll(
		int start, int end, OrderByComparator<StateObject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the state objects from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of state objects.
	 *
	 * @return the number of state objects
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StateObjectPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(StateObjectPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile StateObjectPersistence _persistence;

}