package com.nag.test.service.impl;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nag.test.common.util.DatabaseStatus;
import com.nag.test.dto.Database;
import com.nag.test.dto.Memory;
import com.nag.test.service.HealthService;

/**
 * * @author nag
 * 
 */
@Transactional
@Service
public class HealthServiceImpl implements HealthService {

	private Runtime runtime = Runtime.getRuntime();

	/* (non-Javadoc)
	 * @see com.nag.test.service.HealthService#getMemoryStats()
	 */
	@Override
	public Memory getMemoryStats() {
		Memory memory = new Memory();
		memory.setAllocatedMemory(runtime.totalMemory());
		memory.setFreeMemory(runtime.freeMemory());
		memory.setMaxMemory(runtime.maxMemory());
		return memory;
	}

	/* (non-Javadoc)
	 * @see com.nag.test.service.HealthService#getDatabaseStats(java.lang.String)
	 */
	@Override
	public Database getDatabaseStats(String url) {
		boolean result;
		String message = SUCCESS_MESSAGE;
		Database database = new Database();
		
		try {
			String parse = url.replace("jdbc:mysql", "http");
			URL aURL = new URL(parse);
			Socket socket = new Socket(aURL.getHost(), aURL.getPort());
			socket.close();
			result = true;
		} catch (IOException e) {
			result = false;
			message = e.getMessage();
		}
		if (result) {
			database.setStatus(DatabaseStatus.STATUS_ACTIVE.getvalue());
			database.setMessage(message);
		} else {
			database.setMessage(message);
			database.setStatus(DatabaseStatus.STATUS_INACTIVE.getvalue());
		}

		return database;
	}

}
