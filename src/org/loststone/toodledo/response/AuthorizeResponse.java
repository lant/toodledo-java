package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;

public class AuthorizeResponse extends Response {
	
	public AuthorizeResponse(String response) {
		super(response);
	}

	@Override
	public int getResponseResult() {
		return 0;
	}

	@Override
	public String getResponseContent() throws ToodledoApiException {
		String result = null;		
		// check for errors:
		if (response.contains("error")) {
			this.succeed = false;
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		
		result = response.substring(response.indexOf("<token>")+7, response.indexOf("</token>"));
		this.succeed = true;
		return result; 
	}
}
