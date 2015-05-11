package com.nag.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nag.test.dto.Database;
import com.nag.test.dto.Health;
import com.nag.test.dto.Memory;
import com.nag.test.service.HealthService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Controller
public class HealthController {

	/** The health serivce. */
	@Autowired
	private HealthService healthSerivce;

	/** The url. */
	@Value("${db-url}")
	private String url;

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(HealthController.class);

	/**
	 * Gets the health.
	 *
	 * @return the health
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ModelAndView getHealth() throws Exception {

		logger.info("Request Received for health check ");

		ModelAndView model = new ModelAndView();
		Memory memory = healthSerivce.getMemoryStats();
		Database database = healthSerivce.getDatabaseStats(url);

		Health health = new Health();
		health.setMemory(memory);
		health.setDatabase(database);
		model.addObject("health", health);
		model.setViewName("health");

		logger.info("Completed the health check request ");

		return model;
	}

}
