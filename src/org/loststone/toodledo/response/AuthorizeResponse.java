package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;

public class AuthorizeResponse extends Response {
	
	public AuthorizeResponse(String response) {
		super(response);
	}



	public String getResponseContent() throws ToodledoApiException {
		String result = null;		
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		
		result = response.substring(response.indexOf("<token>")+7, response.indexOf("</token>"));
		return result; 
	}
}
