package org.loststone.toodledo.response;

/**
 * This class holds a response from the server.
 * @author lant
 *
 */
public abstract class Response {
	protected String response;
	
	public Response(String response) {
		this.response = response;
	}
	
	public abstract int getResponseResult();
	
}
