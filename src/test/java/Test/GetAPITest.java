package Test;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Client.RestClient;

public class GetAPITest extends TestBase {
	
	TestBase testBase;
	RestClient restclient;
	String url;
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, Exception {
		testBase = new TestBase();
		String serviceurl = prop.getProperty("URL");
		String apiurl = prop.getProperty("serviceURL");
		
		 url = serviceurl+apiurl;
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, Exception   {
		restclient=new RestClient();
		restclient.get(url);
		
	}

}
