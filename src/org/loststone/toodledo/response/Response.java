package org.loststone.toodledo.response;

import org.loststone.toodledo.ToodledoApiException;

/**
 * This class holds a response from the server.
 * @author lant
 *
 */
public abstract class Response {
	protected String response;
	protected boolean succeed = false;
	
	public Response(String response) {
		this.response = response;
	}
	
	public abstract int getResponseResult();
	
	public boolean succeeded() {
		return succeed;
	}

	public abstract String getResponseContent() throws ToodledoApiException;

	
}
