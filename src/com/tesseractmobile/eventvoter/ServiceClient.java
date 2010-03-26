package com.tesseractmobile.eventvoter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ServiceClient {

	private static final String WEB_SERVICE_BASE_URI = "http://saymoreofthat.appspot.com";
	private URI baseURI;
	private DefaultHttpClient client;

	public ServiceClient() throws URISyntaxException {
		client = new DefaultHttpClient();
		client.setUserTokenHandler(new UserTokenHandler() {
			
			public Object getUserToken(HttpContext context) {
				return context.getAttribute("JSESSIONID");
			}
		});
		this.baseURI = new URI(WEB_SERVICE_BASE_URI);
	}

	public String acquireNewSession() throws ClientProtocolException, IOException {
		HttpPost request = createRequest("rest/users/session/new");
		HttpContext context = new BasicHttpContext();
		HttpResponse response = client.execute(request, context);
		Log.d("ServiceClient", "< " + response.getStatusLine());
		return response.getStatusLine().toString();
//		return (String) context.getAttribute(ClientContext.USER_TOKEN);
	}

	public void RegisterUser(String email) throws ClientProtocolException, IOException, JSONException {
		HttpPost request = createRequest("rest/users/new");
		
		request.setEntity(new StringEntity(new JSONObject().put("email", email).toString()));
		
		HttpResponse response = client.execute(request);
		Log.d("ServiceClient", "< " + response.getStatusLine());
	}
	
	private HttpPost createRequest(String relativePath) {
		URI uri = baseURI.resolve(relativePath);
		Log.d("ServiceClient", "Requesting from URI: " + uri);
		HttpPost request = new HttpPost(uri);
		Log.d("ServiceClient", "> " + request.getRequestLine());
		return request;
	}


}
