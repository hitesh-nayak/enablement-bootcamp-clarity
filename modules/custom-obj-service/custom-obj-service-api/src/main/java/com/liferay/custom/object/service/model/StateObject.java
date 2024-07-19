/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the StateObject service. Represents a row in the &quot;customObjService_StateObject&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StateObjectModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.custom.object.service.model.impl.StateObjectImpl"
)
@ProviderType
public interface StateObject extends PersistedModel, StateObjectModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.custom.object.service.model.impl.StateObjectImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StateObject, Long> STATE_ID_ACCESSOR =
		new Accessor<StateObject, Long>() {

			@Override
			public Long get(StateObject stateObject) {
				return stateObject.getStateId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StateObject> getTypeClass() {
				return StateObject.class;
			}

		};

}