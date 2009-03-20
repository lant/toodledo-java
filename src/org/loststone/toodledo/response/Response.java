package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;

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

	/**
	 * This method returns the value if it's a simple value or the xml for further parsing.
	 * @return
	 * @throws ToodledoApiException
	 */
	public abstract String getResponseContent() throws ToodledoApiException;

	
}
