package com.tvh.tricsql.test.load.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestDataLoader {
	
	private Map<TestDataConstants.Test, Properties> usersTestInfo = new HashMap<TestDataConstants.Test, Properties>(); 

	private Map<TestDataConstants.Test, Properties> dataTestInfo = new HashMap<TestDataConstants.Test, Properties>(); 

	private Properties settings; 
	
	private static final String GLOBAL_SETTINGS_FILENAME = "/global_settings.properties";
	
	private static final TestDataLoader instance = new TestDataLoader();
	
	protected volatile boolean settingsLoaded; 
	
	private TestDataLoader() {
		loadGlobalSettings();
	}
	
	private void loadGlobalSettings() {
		try {
			settings = new Properties();
			settings.load(new FileInputStream(getClass().getResource(GLOBAL_SETTINGS_FILENAME).getFile()));
			settingsLoaded = true;
		} catch (IOException e) {
			throw new RuntimeException("Can not load test data", e);
		}
	}
	
	private void loadTestDataFromFiles(TestDataConstants.Test test) {
		
		synchronized(test) {
			
			if (dataTestInfo.containsKey(test)) {
				return;
			}
			
			try {
				
				Properties users = new Properties();
				users.load(new FileInputStream(getClass().getResource("/" + test.getTestFilesPrefix()  + 
						"_users.properties").getFile()));//new FileInputStream("users.properties"));
				usersTestInfo.put(test, users);
						
				Properties data = new Properties();
				data.load(new FileInputStream(getClass().getResource("/" + test.getTestFilesPrefix() + 
						"_data.properties").getFile()));
				dataTestInfo.put(test, data);
			
			} catch (IOException e) {
				throw new RuntimeException("Can not load test data", e);
			}
			
		}
	}

	public static TestDataLoader getInstance()  {
		return instance;
	}
	
	protected void checkTestDataAvailable(TestDataConstants.Test test) {
		if (!dataTestInfo.containsKey(test)) {
			loadTestDataFromFiles(test);
		}
	}
	
	public String getUserLogin(TestDataConstants.Test test, int userIndex) {
		checkTestDataAvailable(test);
		return usersTestInfo.get(test).getProperty(String.valueOf(userIndex) + "." + TestDataConstants.User.LOGIN);
	}
	
	public String getUserPassword(TestDataConstants.Test test, int userIndex) {
		checkTestDataAvailable(test);
		return usersTestInfo.get(test).getProperty(String.valueOf(userIndex) + "." + TestDataConstants.User.PASSWORD);
	}
	
	public String getUserTestData(TestDataConstants.Test test, int userIndex) {
		checkTestDataAvailable(test);
		return usersTestInfo.get(test).getProperty(String.valueOf(userIndex) + "." + TestDataConstants.User.TEST_DATA);
	}
	
	public String getTestData(TestDataConstants.Test test, int index, String key) {
		checkTestDataAvailable(test);
		return dataTestInfo.get(test).getProperty(String.valueOf(index) + "." + key);
	}
	
	public String getSetting(String key) {
		return settings.getProperty(key);
	}
}
