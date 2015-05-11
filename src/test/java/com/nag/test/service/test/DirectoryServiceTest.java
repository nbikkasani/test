package com.nag.test.service.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nag.test.dto.FileDetail;
import com.nag.test.dto.FileDetails;
import com.nag.test.service.DirectoryListingService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
@Transactional
public class DirectoryServiceTest {

	
	/** The directory listing service. */
	@Autowired
	private DirectoryListingService directoryListingService;
	
	/** The path. */
	private String path;
	
	/**
	 * On set up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void onSetUp() throws Exception {
		path = "/Users/449146/Downloads";
	}
	
    /**
     * Test get files.
     */
    @Test
    public void testGetFiles() {
    	FileDetails files = directoryListingService.getFilesInDirectory(path);
       for(FileDetail s:files.getFileDetails())
        System.out.println(s.toString()+"**");
    }
    
    
    /**
     * Test get files by version.
     */
    @Test
    public void testGetFilesByVersion() {
        FileDetails files = directoryListingService.getFileDetailsInDirectory(path);
       for(FileDetail fileDetail:files.getFileDetails())
        System.out.println(fileDetail.getFileName()+"**");
    }


	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		path = null;
	}

}
