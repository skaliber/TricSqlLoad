package com.tvh.tricsql.test.load.util;

public interface TestDataConstants {

	public enum Test {

		LOAD_TEST("loadTest");
		
		private String testFilesPrefix;
		
		private Test (String testFilesPrefix) {
			this.testFilesPrefix = testFilesPrefix;
		}
		
		public String getTestFilesPrefix() {
			return testFilesPrefix;
		}
	}
	
	public interface User {
		
		final String LOGIN = "login";
		
		final String PASSWORD = "password";

		final String TEST_DATA = "test.data";
	}
}
