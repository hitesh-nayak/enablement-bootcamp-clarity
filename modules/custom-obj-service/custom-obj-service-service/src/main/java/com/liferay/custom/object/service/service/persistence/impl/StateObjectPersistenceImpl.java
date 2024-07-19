/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.service.persistence.impl;

import com.liferay.custom.object.service.exception.NoSuchStateObjectException;
import com.liferay.custom.object.service.model.StateObject;
import com.liferay.custom.object.service.model.StateObjectTable;
import com.liferay.custom.object.service.model.impl.StateObjectImpl;
import com.liferay.custom.object.service.model.impl.StateObjectModelImpl;
import com.liferay.custom.object.service.service.persistence.StateObjectPersistence;
import com.liferay.custom.object.service.service.persistence.StateObjectUtil;
import com.liferay.custom.object.service.service.persistence.impl.constants.customObjServicePersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the state object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StateObjectPersistence.class)
public class StateObjectPersistenceImpl
	extends BasePersistenceImpl<StateObject> implements StateObjectPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StateObjectUtil</code> to access the state object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StateObjectImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the state objects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching state objects
	 */
	@Override
	public List<StateObject> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<StateObject> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<StateObject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StateObject> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<StateObject> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StateObject> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<StateObject> list = null;

		if (useFinderCache) {
			list = (List<StateObject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StateObject stateObject : list) {
					if (!uuid.equals(stateObject.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STATEOBJECT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StateObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<StateObject>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state object
	 * @throws NoSuchStateObjectException if a matching state object could not be found
	 */
	@Override
	public StateObject findByUuid_First(
			String uuid, OrderByComparator<StateObject> orderByComparator)
		throws NoSuchStateObjectException {

		StateObject stateObject = fetchByUuid_First(uuid, orderByComparator);

		if (stateObject != null) {
			return stateObject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateObjectException(sb.toString());
	}

	/**
	 * Returns the first state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state object, or <code>null</code> if a matching state object could not be found
	 */
	@Override
	public StateObject fetchByUuid_First(
		String uuid, OrderByComparator<StateObject> orderByComparator) {

		List<StateObject> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state object
	 * @throws NoSuchStateObjectException if a matching state object could not be found
	 */
	@Override
	public StateObject findByUuid_Last(
			String uuid, OrderByComparator<StateObject> orderByComparator)
		throws NoSuchStateObjectException {

		StateObject stateObject = fetchByUuid_Last(uuid, orderByComparator);

		if (stateObject != null) {
			return stateObject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateObjectException(sb.toString());
	}

	/**
	 * Returns the last state object in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state object, or <code>null</code> if a matching state object could not be found
	 */
	@Override
	public StateObject fetchByUuid_Last(
		String uuid, OrderByComparator<StateObject> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StateObject> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public StateObject[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			OrderByComparator<StateObject> orderByComparator)
		throws NoSuchStateObjectException {

		uuid = Objects.toString(uuid, "");

		StateObject stateObject = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			StateObject[] array = new StateObjectImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, stateObject, uuid, orderByComparator, true);

			array[1] = stateObject;

			array[2] = getByUuid_PrevAndNext(
				session, stateObject, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StateObject getByUuid_PrevAndNext(
		Session session, StateObject stateObject, String uuid,
		OrderByComparator<StateObject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATEOBJECT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StateObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stateObject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StateObject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the state objects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StateObject stateObject :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stateObject);
		}
	}

	/**
	 * Returns the number of state objects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching state objects
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATEOBJECT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"stateObject.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(stateObject.uuid IS NULL OR stateObject.uuid = '')";

	public StateObjectPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StateObject.class);

		setModelImplClass(StateObjectImpl.class);
		setModelPKClass(long.class);

		setTable(StateObjectTable.INSTANCE);
	}

	/**
	 * Caches the state object in the entity cache if it is enabled.
	 *
	 * @param stateObject the state object
	 */
	@Override
	public void cacheResult(StateObject stateObject) {
		entityCache.putResult(
			StateObjectImpl.class, stateObject.getPrimaryKey(), stateObject);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the state objects in the entity cache if it is enabled.
	 *
	 * @param stateObjects the state objects
	 */
	@Override
	public void cacheResult(List<StateObject> stateObjects) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (stateObjects.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StateObject stateObject : stateObjects) {
			if (entityCache.getResult(
					StateObjectImpl.class, stateObject.getPrimaryKey()) ==
						null) {

				cacheResult(stateObject);
			}
		}
	}

	/**
	 * Clears the cache for all state objects.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StateObjectImpl.class);

		finderCache.clearCache(StateObjectImpl.class);
	}

	/**
	 * Clears the cache for the state object.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StateObject stateObject) {
		entityCache.removeResult(StateObjectImpl.class, stateObject);
	}

	@Override
	public void clearCache(List<StateObject> stateObjects) {
		for (StateObject stateObject : stateObjects) {
			entityCache.removeResult(StateObjectImpl.class, stateObject);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StateObjectImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StateObjectImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new state object with the primary key. Does not add the state object to the database.
	 *
	 * @param stateId the primary key for the new state object
	 * @return the new state object
	 */
	@Override
	public StateObject create(long stateId) {
		StateObject stateObject = new StateObjectImpl();

		stateObject.setNew(true);
		stateObject.setPrimaryKey(stateId);

		String uuid = PortalUUIDUtil.generate();

		stateObject.setUuid(uuid);

		return stateObject;
	}

	/**
	 * Removes the state object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object that was removed
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	@Override
	public StateObject remove(long stateId) throws NoSuchStateObjectException {
		return remove((Serializable)stateId);
	}

	/**
	 * Removes the state object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the state object
	 * @return the state object that was removed
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	@Override
	public StateObject remove(Serializable primaryKey)
		throws NoSuchStateObjectException {

		Session session = null;

		try {
			session = openSession();

			StateObject stateObject = (StateObject)session.get(
				StateObjectImpl.class, primaryKey);

			if (stateObject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStateObjectException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stateObject);
		}
		catch (NoSuchStateObjectException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StateObject removeImpl(StateObject stateObject) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stateObject)) {
				stateObject = (StateObject)session.get(
					StateObjectImpl.class, stateObject.getPrimaryKeyObj());
			}

			if (stateObject != null) {
				session.delete(stateObject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stateObject != null) {
			clearCache(stateObject);
		}

		return stateObject;
	}

	@Override
	public StateObject updateImpl(StateObject stateObject) {
		boolean isNew = stateObject.isNew();

		if (!(stateObject instanceof StateObjectModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stateObject.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stateObject);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stateObject proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StateObject implementation " +
					stateObject.getClass());
		}

		StateObjectModelImpl stateObjectModelImpl =
			(StateObjectModelImpl)stateObject;

		if (Validator.isNull(stateObject.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			stateObject.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stateObject);
			}
			else {
				stateObject = (StateObject)session.merge(stateObject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StateObjectImpl.class, stateObjectModelImpl, false, true);

		if (isNew) {
			stateObject.setNew(false);
		}

		stateObject.resetOriginalValues();

		return stateObject;
	}

	/**
	 * Returns the state object with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the state object
	 * @return the state object
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	@Override
	public StateObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStateObjectException {

		StateObject stateObject = fetchByPrimaryKey(primaryKey);

		if (stateObject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStateObjectException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stateObject;
	}

	/**
	 * Returns the state object with the primary key or throws a <code>NoSuchStateObjectException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object
	 * @throws NoSuchStateObjectException if a state object with the primary key could not be found
	 */
	@Override
	public StateObject findByPrimaryKey(long stateId)
		throws NoSuchStateObjectException {

		return findByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns the state object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state object
	 * @return the state object, or <code>null</code> if a state object with the primary key could not be found
	 */
	@Override
	public StateObject fetchByPrimaryKey(long stateId) {
		return fetchByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns all the state objects.
	 *
	 * @return the state objects
	 */
	@Override
	public List<StateObject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<StateObject> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<StateObject> findAll(
		int start, int end, OrderByComparator<StateObject> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<StateObject> findAll(
		int start, int end, OrderByComparator<StateObject> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<StateObject> list = null;

		if (useFinderCache) {
			list = (List<StateObject>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STATEOBJECT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STATEOBJECT;

				sql = sql.concat(StateObjectModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StateObject>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the state objects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StateObject stateObject : findAll()) {
			remove(stateObject);
		}
	}

	/**
	 * Returns the number of state objects.
	 *
	 * @return the number of state objects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STATEOBJECT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "stateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STATEOBJECT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StateObjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the state object persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		StateObjectUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		StateObjectUtil.setPersistence(null);

		entityCache.removeCache(StateObjectImpl.class.getName());
	}

	@Override
	@Reference(
		target = customObjServicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = customObjServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = customObjServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STATEOBJECT =
		"SELECT stateObject FROM StateObject stateObject";

	private static final String _SQL_SELECT_STATEOBJECT_WHERE =
		"SELECT stateObject FROM StateObject stateObject WHERE ";

	private static final String _SQL_COUNT_STATEOBJECT =
		"SELECT COUNT(stateObject) FROM StateObject stateObject";

	private static final String _SQL_COUNT_STATEOBJECT_WHERE =
		"SELECT COUNT(stateObject) FROM StateObject stateObject WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stateObject.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StateObject exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StateObject exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StateObjectPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}