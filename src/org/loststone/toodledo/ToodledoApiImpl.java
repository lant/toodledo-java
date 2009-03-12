package org.loststone.toodledo;

import java.util.List;

import org.loststone.toodledo.request.AddTodoRequest;
import org.loststone.toodledo.request.AuthorizeRequest;
import org.loststone.toodledo.request.Request;
import org.loststone.toodledo.response.AddTodoResponse;
import org.loststone.toodledo.response.AuthorizeResponse;
import org.loststone.toodledo.util.AuthToken;

public class ToodledoApiImpl implements ToodledoApi {

	@Override
	public int addTodo(AuthToken auth, Todo todo) throws ToodledoApiException {
		AddTodoRequest request = new AddTodoRequest(auth, todo);
		AddTodoResponse resp = (AddTodoResponse)request.exec();
		if (resp.succeeded())
			return Integer.parseInt(resp.getResponseContent());
		else
			return -1;
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
	public boolean modifyTodo(AuthToken auth, Todo newOne)  throws ToodledoApiException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTodo(AuthToken auth, int id)  throws ToodledoApiException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getContexts(AuthToken auth)  throws ToodledoApiException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getFolders(AuthToken auth)  throws ToodledoApiException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getGoals(AuthToken auth)  throws ToodledoApiException{
		// TODO Auto-generated method stub
		return null;
	}

}
