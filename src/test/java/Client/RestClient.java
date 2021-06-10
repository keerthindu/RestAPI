package Client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//1. GET Method
	
	public void get(String url) throws ClientProtocolException, Exception  {
		CloseableHttpClient httpClient = HttpClients.createDefault(); //it create simple client
		HttpGet httpget = new HttpGet(url);  //http get request
		CloseableHttpResponse httpresponse = httpClient.execute(httpget);   //hit the GET URL
		
		//a.status code
		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println("Status code is" +statuscode);
		
		//b. body message
		String bodymessage = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		JSONObject param =new JSONObject(bodymessage);
		System.out.println("Body message is" + param);
		
		//c. Header value
		Header[] heads = httpresponse.getAllHeaders();
		HashMap<String, String> headervalue = new HashMap<String, String>();
		for(Header val : heads) {
			headervalue.put(val.getName(),val.getValue());
		}
		
		System.out.println("Header value" +headervalue);
	}

}
