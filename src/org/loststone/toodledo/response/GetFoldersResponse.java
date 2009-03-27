package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;


public class GetFoldersResponse extends Response {

	public GetFoldersResponse(String resp) {
		super(resp);
	}

	
	// TODO refactor to the parent class.
	public String getResponseContent() throws ToodledoApiException {
		// check for errors:
		if (response.contains("error")) {
			this.succeed = false;
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		this.succeed = true;
		return response;
	}
}
