package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.ErrorParser;

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
		ErrorParser errorParser = new ErrorParser(response);
		this.succeed = errorParser.getError() == null;
	}

	public boolean succeeded() {
		return succeed;
	}

	/**
	 * This method returns the xml for further parsing.
	 * @return
	 * @throws ToodledoApiException
	 */
	public String getXmlResponseContent() throws ToodledoApiException {
		return this.response;
	}


}
