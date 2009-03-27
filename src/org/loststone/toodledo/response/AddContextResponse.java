package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;


public class AddContextResponse extends Response {

	public AddContextResponse(String resp) {
		super(resp);
	}

	public String getResponseContent() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		
		return response.substring(response.indexOf("<added>")+7, response.indexOf("</added>"));
	}

}
