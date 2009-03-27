package org.loststone.toodledo.request;

import org.loststone.toodledo.response.AuthorizeResponse;
import org.loststone.toodledo.response.Response;

public class AuthorizeRequest extends Request {

	public AuthorizeRequest(String userId) {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getToken;userid="+userId;
	}

	@Override
	public Response getResponse() {
		this.exec();
		AuthorizeResponse response = new AuthorizeResponse(this.xmlResponse);
		return response;
	}
	
	
}
