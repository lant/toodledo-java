package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.response.Response;

public abstract class Request {
	private String authToken = null;
	// url to the service
	protected String url = null; 
	protected String xmlResponse = null; 
	
	
	public abstract Response getResponse();
	
	public void exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		try {
			client.executeMethod(method);
			this.xmlResponse = method.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
