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
	
	// TODO implement a better base, all that is done in the inherited class 
	// can go here.
	public Response(String response) {
		this.response = response;
	}
	
	// TODO delete this.
	public abstract int getResponseResult();
	
	public boolean succeeded() {
		return succeed;
	}

	/**
	 * This method returns the value if it's a simple value or the xml for further parsing.
	 * @return
	 * @throws ToodledoApiException
	 * TODO create getResponseContentAsXml with string
	 * TODO create getParsedResponse in every class.
	 */
	public abstract String getResponseContent() throws ToodledoApiException;

	
}
