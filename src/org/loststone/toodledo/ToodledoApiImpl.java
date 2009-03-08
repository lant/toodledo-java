package org.loststone.toodledo;

import java.util.List;

import org.loststone.toodledo.request.AuthorizeRequest;
import org.loststone.toodledo.request.Request;
import org.loststone.toodledo.response.AuthorizeResponse;
import org.loststone.toodledo.response.ToodledoApiException;
import org.loststone.toodledo.util.AuthToken;

public class ToodledoApiImpl implements ToodledoApi {

	@Override
	public boolean addTodo(AuthToken auth, Todo todo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Todo getTodo(AuthToken auth, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTodosList(AuthToken auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthToken initialize(String username, String password) throws ToodledoApiException {
		Request initReq = new AuthorizeRequest(username);
		// response gives back the token, now create the AuthToken
		AuthorizeResponse resp = (AuthorizeResponse) initReq.exec();
		AuthToken token = new AuthToken(password, username, resp.getResponseContent());
		
		return token;
	}

	@Override
	public boolean modifyTodo(AuthToken auth, Todo newOne) {
		// TODO Auto-generated method stub
		return false;
	}

}
