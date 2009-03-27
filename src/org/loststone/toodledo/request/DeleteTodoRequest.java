package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.DeleteResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class DeleteTodoRequest extends Request {

	public DeleteTodoRequest(AuthToken token, int id) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=deleteTask;key="+token.getKey()+";id="+id;
	}
	
}
