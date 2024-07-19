package com.na.remotewc.web.util;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.repository.model.FileEntry;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ModelListener.class)

public class WebContentModelListener extends BaseModelListener<JournalArticle> {
	private final static Log log = LogFactoryUtil.getLog(WebContentModelListener.class);
	
	@Override
	public void onBeforeRemove(JournalArticle model) throws ModelListenerException {
		try {

			List<FileEntry> entries = model.getImagesFileEntries();

			for (FileEntry fl : entries) {
				
				DLAppLocalServiceUtil.deleteFileEntry(fl.getFileEntryId());
				log.info("File Entry Removed. "+ fl.getFileEntryId());
			}
		} catch (PortalException e) {

			log.error(e.getMessage());
		}
		super.onBeforeRemove(model);
	}

//	@Override
//	public void onbeforeRemove(JournalArticle model) throws ModelListenerException {
//		try {
//
//			List<FileEntry> entries = model.getImagesFileEntries();
//
//			for (FileEntry fl : entries) {
//				
//				DLAppLocalServiceUtil.deleteFileEntry(fl.getFileEntryId());
//				log.info("File Entry Removed. "+ fl.getFileEntryId());
//			}
//		} catch (PortalException e) {
//
//			log.error(e.getMessage());
//		}
//		super.onAfterRemove(model);
//	}

}
