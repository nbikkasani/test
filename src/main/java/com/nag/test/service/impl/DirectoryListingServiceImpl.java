package com.nag.test.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nag.test.dto.FileDetail;
import com.nag.test.dto.FileDetails;
import com.nag.test.service.DirectoryListingService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Transactional
@Service
public class DirectoryListingServiceImpl implements DirectoryListingService {

	/* (non-Javadoc)
	 * @see com.nag.test.service.DirectoryListingService#getFilesInDirectory(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public FileDetails getFilesInDirectory(String path) {

		FileDetails fileDetails = new FileDetails();
		List<FileDetail> listFiles = new ArrayList<FileDetail>();

		File directory = new File(path);
			List<File> files = (List<File>) FileUtils.listFiles(directory, TrueFileFilter.INSTANCE, null);
			for (File file : files) {
				FileDetail fileDetail = new FileDetail();
				fileDetail.setFileName(file.getName());
				fileDetail.setPath(file.getAbsolutePath());
				listFiles.add(fileDetail);
			}
		fileDetails.setFileDetails(listFiles);
		return fileDetails;
	}

	/* (non-Javadoc)
	 * @see com.nag.test.service.DirectoryListingService#getFileDetailsInDirectory(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public FileDetails getFileDetailsInDirectory(String path) {
		
		FileDetails fileDetails = new FileDetails();
		List<FileDetail> listFiles = new ArrayList<FileDetail>();
		File directory = new File(path);

			List<File> files = (List<File>) FileUtils.listFiles(directory, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
			for (File file : files) {
				FileDetail fileDetail = new FileDetail();
				fileDetail.setFileName(file.getName());
				fileDetail.setPath(file.getAbsolutePath());
				listFiles.add(fileDetail);
			}
		
		fileDetails.setFileDetails(listFiles);
		return fileDetails;
	}

}
