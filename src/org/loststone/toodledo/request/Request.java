package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.response.GetFoldersResponse;
import org.loststone.toodledo.response.Response;

public abstract class Request {
	private String authToken = null;
	
	// url to the service
	protected String url = null; 
	
	//public abstract void buildRequest();

	// TODO create a new method that gets back the response, which is a class that inherits
	// from the abstract class response.
	
	// TODO  this is _wrong_ just execute the method and store the result as a string
	public Response exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		Response addResp = null; 
		try {
			client.executeMethod(method);
			addResp = new GetFoldersResponse(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return addResp;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
