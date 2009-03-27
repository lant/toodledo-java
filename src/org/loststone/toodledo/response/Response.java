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
		if (response.contains("error")) 
			this.succeed = false;
		else
			this.succeed = true;
	}
	
	public boolean succeeded() {
		return succeed;
	}

	/**
	 * This method returns the xml for further parsing.
	 * @return
	 * @throws ToodledoApiException
	 * TODO create getResponseContentAsXml with string
	 * TODO create getParsedResponse in every class.
	 */
	public String getXmlResponseContent() throws ToodledoApiException {
		return this.response;
	}

	
}
