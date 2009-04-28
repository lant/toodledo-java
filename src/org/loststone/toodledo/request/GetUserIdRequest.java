package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetUserIdResponse;
import org.loststone.toodledo.response.Response;

public class GetUserIdRequest extends Request {

	public GetUserIdRequest(String email, String password) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getUserid;email="+email+";pass="+password+";";
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetUserIdResponse response = new GetUserIdResponse(this.xmlResponse);
		return response;
	}
	
}
