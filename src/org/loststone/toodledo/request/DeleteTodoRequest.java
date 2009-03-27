package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.DeleteTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class DeleteTodoRequest extends Request {

	public DeleteTodoRequest(AuthToken token, int id) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=deleteTask;key="+token.getKey()+";id="+id;
	}

	@Override
	public Response getResponse() {
		this.exec();
		DeleteTodoResponse response = new DeleteTodoResponse(this.xmlResponse);
		return response;
	}
	
}
