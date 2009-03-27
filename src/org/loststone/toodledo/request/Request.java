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
	
	/**
	 * Should execute the exec method and give back an appropiate response type. 
	 * @return
	 */
	public abstract Response getResponse();
	
	/**
	 * This methods executes the HTTP GET of the URL and stores the result
	 * in String format in the xmlResponse field.
	 */
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
