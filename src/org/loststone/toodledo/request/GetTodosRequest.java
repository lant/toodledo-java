package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetTodosResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class GetTodosRequest extends Request {

	public GetTodosRequest(AuthToken token, Todo filter) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getTasks;key="+token.getKey();
		if (filter != null) {
			
		}
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetTodosResponse response = new GetTodosResponse(this.xmlResponse);
		return response;
	}
	
}
