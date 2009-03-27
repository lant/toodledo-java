package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.Todo;
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
	
}
