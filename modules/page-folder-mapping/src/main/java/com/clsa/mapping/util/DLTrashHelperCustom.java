

package com.clsa.mapping.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.Repository;
import com.liferay.portal.kernel.repository.RepositoryProviderUtil;
import com.liferay.portal.kernel.repository.capabilities.TrashCapability;
import com.liferay.trash.TrashHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service = DLTrashHelperCustom.class)
public class DLTrashHelperCustom {

	public boolean isTrashEnabled(long groupId, long repositoryId)
		throws PortalException {

		if (!_trashHelper.isTrashEnabled(groupId)) {
			return false;
		}

		if (repositoryId == groupId) {
			return true;
		}

		Repository repository = RepositoryProviderUtil.getRepository(
			repositoryId);

		return repository.isCapabilityProvided(TrashCapability.class);
	}

	@Reference
	private TrashHelper _trashHelper;

}