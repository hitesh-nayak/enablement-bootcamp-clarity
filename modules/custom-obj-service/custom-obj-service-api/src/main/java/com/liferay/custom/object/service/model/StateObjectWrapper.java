/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StateObject}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StateObject
 * @generated
 */
public class StateObjectWrapper
	extends BaseModelWrapper<StateObject>
	implements ModelWrapper<StateObject>, StateObject {

	public StateObjectWrapper(StateObject stateObject) {
		super(stateObject);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stateId", getStateId());
		attributes.put("stateObjectDefId", getStateObjectDefId());
		attributes.put("name", getName());
		attributes.put("pinCode", getPinCode());
		attributes.put("extRefId", getExtRefId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long stateObjectDefId = (Long)attributes.get("stateObjectDefId");

		if (stateObjectDefId != null) {
			setStateObjectDefId(stateObjectDefId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long pinCode = (Long)attributes.get("pinCode");

		if (pinCode != null) {
			setPinCode(pinCode);
		}

		String extRefId = (String)attributes.get("extRefId");

		if (extRefId != null) {
			setExtRefId(extRefId);
		}
	}

	@Override
	public StateObject cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ext ref ID of this state object.
	 *
	 * @return the ext ref ID of this state object
	 */
	@Override
	public String getExtRefId() {
		return model.getExtRefId();
	}

	/**
	 * Returns the name of this state object.
	 *
	 * @return the name of this state object
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pin code of this state object.
	 *
	 * @return the pin code of this state object
	 */
	@Override
	public long getPinCode() {
		return model.getPinCode();
	}

	/**
	 * Returns the primary key of this state object.
	 *
	 * @return the primary key of this state object
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this state object.
	 *
	 * @return the state ID of this state object
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the state object def ID of this state object.
	 *
	 * @return the state object def ID of this state object
	 */
	@Override
	public long getStateObjectDefId() {
		return model.getStateObjectDefId();
	}

	/**
	 * Returns the uuid of this state object.
	 *
	 * @return the uuid of this state object
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ext ref ID of this state object.
	 *
	 * @param extRefId the ext ref ID of this state object
	 */
	@Override
	public void setExtRefId(String extRefId) {
		model.setExtRefId(extRefId);
	}

	/**
	 * Sets the name of this state object.
	 *
	 * @param name the name of this state object
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pin code of this state object.
	 *
	 * @param pinCode the pin code of this state object
	 */
	@Override
	public void setPinCode(long pinCode) {
		model.setPinCode(pinCode);
	}

	/**
	 * Sets the primary key of this state object.
	 *
	 * @param primaryKey the primary key of this state object
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this state object.
	 *
	 * @param stateId the state ID of this state object
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the state object def ID of this state object.
	 *
	 * @param stateObjectDefId the state object def ID of this state object
	 */
	@Override
	public void setStateObjectDefId(long stateObjectDefId) {
		model.setStateObjectDefId(stateObjectDefId);
	}

	/**
	 * Sets the uuid of this state object.
	 *
	 * @param uuid the uuid of this state object
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected StateObjectWrapper wrap(StateObject stateObject) {
		return new StateObjectWrapper(stateObject);
	}

}