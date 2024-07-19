/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.model.impl;

import com.liferay.custom.object.service.model.StateObject;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StateObject in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StateObjectCacheModel
	implements CacheModel<StateObject>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StateObjectCacheModel)) {
			return false;
		}

		StateObjectCacheModel stateObjectCacheModel =
			(StateObjectCacheModel)object;

		if (stateId == stateObjectCacheModel.stateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", stateObjectDefId=");
		sb.append(stateObjectDefId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", pinCode=");
		sb.append(pinCode);
		sb.append(", extRefId=");
		sb.append(extRefId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StateObject toEntityModel() {
		StateObjectImpl stateObjectImpl = new StateObjectImpl();

		if (uuid == null) {
			stateObjectImpl.setUuid("");
		}
		else {
			stateObjectImpl.setUuid(uuid);
		}

		stateObjectImpl.setStateId(stateId);
		stateObjectImpl.setStateObjectDefId(stateObjectDefId);

		if (name == null) {
			stateObjectImpl.setName("");
		}
		else {
			stateObjectImpl.setName(name);
		}

		stateObjectImpl.setPinCode(pinCode);

		if (extRefId == null) {
			stateObjectImpl.setExtRefId("");
		}
		else {
			stateObjectImpl.setExtRefId(extRefId);
		}

		stateObjectImpl.resetOriginalValues();

		return stateObjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		stateId = objectInput.readLong();

		stateObjectDefId = objectInput.readLong();
		name = objectInput.readUTF();

		pinCode = objectInput.readLong();
		extRefId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(stateId);

		objectOutput.writeLong(stateObjectDefId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(pinCode);

		if (extRefId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extRefId);
		}
	}

	public String uuid;
	public long stateId;
	public long stateObjectDefId;
	public String name;
	public long pinCode;
	public String extRefId;

}