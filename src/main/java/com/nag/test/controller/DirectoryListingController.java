package com.nag.test.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nag.test.dto.CustomException;
import com.nag.test.dto.FileDetails;
import com.nag.test.service.DirectoryListingService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Controller
@RequestMapping("list")
public class DirectoryListingController {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(DirectoryListingController.class);

	/** The directory. */
	@Value("${directory}")
	private String directory;

	/** The directory listing service. */
	@Autowired
	private DirectoryListingService directoryListingService;

	/**
	 * List files.
	 *
	 * @param path the path
	 * @return the model and view
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/{path}", method = RequestMethod.GET)
	public ModelAndView listFiles(@PathVariable(value = "path") String path) throws Exception {
		ModelAndView model = new ModelAndView();

		logger.info("Request Received for directory listing " + path);

		String filePath = null;

		if (StringUtils.isNotEmpty(directory) || StringUtils.isNotEmpty(path))
			filePath = directory + File.separator + path;

		logger.info("Fetching the files in the given directory:" + filePath);

		FileDetails list = directoryListingService.getFilesInDirectory(filePath);
		model.addObject("files", list);
		return model;
	}

	/**
	 * List files by version.
	 *
	 * @param version the version
	 * @param path the path
	 * @return the model and view
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/{version:[a-z-]\\d}/{path}", method = RequestMethod.GET)
	public ModelAndView listFilesByVersion(@PathVariable String version, @PathVariable(value = "path") String path)
			throws Exception {
		ModelAndView model = new ModelAndView();

		logger.info("Request Received for directory listing " + path + "::" + version);

		String filePath = null;

		if (StringUtils.isNotEmpty(directory) || StringUtils.isNotEmpty(path))
			filePath = directory + File.separator + path;

		logger.info("Fetching the files in the given directory:" + filePath);

		FileDetails list = directoryListingService.getFileDetailsInDirectory(filePath);
		model.addObject("files", list);
		return model;
	}

	/**
	 * Handle exception.
	 *
	 * @param req the req
	 * @param exception the exception
	 * @return the model and view
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		ModelAndView model = new ModelAndView();
		CustomException customException = new CustomException();
		customException.setMessage(exception.getMessage());
		customException.setUrlRequested(req.getRequestURL().toString());
		model.addObject("exceptions", customException);
		model.setViewName("error");
		return model;
	}

}
