/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.custom.object.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StateObjectService}.
 *
 * @author Brian Wing Shun Chan
 * @see StateObjectService
 * @generated
 */
public class StateObjectServiceWrapper
	implements ServiceWrapper<StateObjectService>, StateObjectService {

	public StateObjectServiceWrapper() {
		this(null);
	}

	public StateObjectServiceWrapper(StateObjectService stateObjectService) {
		_stateObjectService = stateObjectService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stateObjectService.getOSGiServiceIdentifier();
	}

	@Override
	public StateObjectService getWrappedService() {
		return _stateObjectService;
	}

	@Override
	public void setWrappedService(StateObjectService stateObjectService) {
		_stateObjectService = stateObjectService;
	}

	private StateObjectService _stateObjectService;

}