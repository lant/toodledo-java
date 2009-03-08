package org.loststone.toodledo.request;

import org.loststone.toodledo.response.Response;

public abstract class Request {
	private String authToken = null;
	
	// url to the service
	protected String url = null; 
	
	//public abstract void buildRequest();
	
	public abstract Response exec();
	
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
