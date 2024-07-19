/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.service.persistence;

import com.liferay.custom.object.service.exception.NoSuchStateObjectException;
import com.liferay.custom.object.service.model.StateObject;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the state object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StateObjectUtil
 * @generated
 */
@ProviderType
public interface StateObjectPersistence extends BasePersistence<StateObject> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StateObjectUtil} to access the state object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the state objects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching state objects
	 */
	public java.util.List<StateObject> findByUuid(String uuid);

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
	public java.util.List<StateObject> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<StateObject> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StateObject>
			orderByComparator);

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
	public java.util.List<StateObject> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StateObject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state object
	 * @throws NoSuchStateObjectException if a matching state object could not be found
	 */
	public StateObject findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StateObject>
				orderByComparator)
		throws NoSuchStateObjectException;

	/**
	 * Returns the first state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state object, or <code>null</code> if a matching state object could not be found
	 */
	public StateObject fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StateObject>
			orderByComparator);

	/**
	 * Returns the last state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state object
	 * @throws NoSuchStateObjectException if a matching state object could not be found
	 */
	public StateObject findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StateObject>
				orderByComparator)
		throws NoSuchStateObjectException;

	/**
	 * Returns the last state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state object, or <code>null</code> if a matching state object could not be found
	 */
	public StateObject fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StateObject>
			orderByComparator);

	/**
	 * Returns the state objects before and after the current state object in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current state object
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state object
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	public StateObject[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StateObject>
				orderByComparator)
		throws NoSuchStateObjectException;

	/**
	 * Removes all the state objects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of state objects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching state objects
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the state object in the entity cache if it is enabled.
	 *
	 * @param stateObject the state object
	 */
	public void cacheResult(StateObject stateObject);

	/**
	 * Caches the state objects in the entity cache if it is enabled.
	 *
	 * @param stateObjects the state objects
	 */
	public void cacheResult(java.util.List<StateObject> stateObjects);

	/**
	 * Creates a new state object with the primary key. Does not add the state object to the database.
	 *
	 * @param stateId the primary key for the new state object
	 * @return the new state object
	 */
	public StateObject create(long stateId);

	/**
	 * Removes the state object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object that was removed
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	public StateObject remove(long stateId) throws NoSuchStateObjectException;

	public StateObject updateImpl(StateObject stateObject);

	/**
	 * Returns the state object with the primary key or throws a <code>NoSuchStateObjectException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	public StateObject findByPrimaryKey(long stateId)
		throws NoSuchStateObjectException;

	/**
	 * Returns the state object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object, or <code>null</code> if a state object with the primary key could not be found
	 */
	public StateObject fetchByPrimaryKey(long stateId);

	/**
	 * Returns all the state objects.
	 *
	 * @return the state objects
	 */
	public java.util.List<StateObject> findAll();

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
	public java.util.List<StateObject> findAll(int start, int end);

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
	public java.util.List<StateObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StateObject>
			orderByComparator);

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
	public java.util.List<StateObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StateObject>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the state objects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of state objects.
	 *
	 * @return the number of state objects
	 */
	public int countAll();

}