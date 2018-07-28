package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {
	TestBase testBase;
	String baseURL;
	String apiURL;
	String URL;
	RestClient restClient;
	@BeforeTest
	public void setUp()throws ClientProtocolException, IOException{
		testBase = new TestBase();
		 baseURL =prop.getProperty("URL");
		 apiURL = prop.getProperty("serviceURL");
		 URL = baseURL+apiURL;
		
	
	}

	
	@Test
	public void getTest() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		restClient.get(URL);
	}
	
	
	
	
	
}
