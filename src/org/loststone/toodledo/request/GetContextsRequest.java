package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetContextsResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class GetContextsRequest extends Request {

	public GetContextsRequest(AuthToken token) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getContexts;key="+token.getKey();	
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetContextsResponse response = new GetContextsResponse(this.xmlResponse);
		return response;
	}
	
}
