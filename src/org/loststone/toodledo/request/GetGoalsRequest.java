package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetGoalsResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class GetGoalsRequest extends Request {

	public GetGoalsRequest(AuthToken token) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getGoals;key="+token.getKey();	
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetGoalsResponse response = new GetGoalsResponse(this.xmlResponse);
		return response;
	}
	

}
