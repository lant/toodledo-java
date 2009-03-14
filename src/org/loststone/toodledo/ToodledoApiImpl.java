package org.loststone.toodledo;

import java.util.List;

import org.loststone.toodledo.request.AddContextRequest;
import org.loststone.toodledo.request.AddFolderRequest;
import org.loststone.toodledo.request.AddGoalRequest;
import org.loststone.toodledo.request.AddTodoRequest;
import org.loststone.toodledo.request.AuthorizeRequest;
import org.loststone.toodledo.request.DeleteTodoRequest;
import org.loststone.toodledo.request.GetContextsRequest;
import org.loststone.toodledo.request.GetFoldersRequest;
import org.loststone.toodledo.request.GetGoalsRequest;
import org.loststone.toodledo.request.GetTodosRequest;
import org.loststone.toodledo.request.ModifyTodoRequest;
import org.loststone.toodledo.request.Request;
import org.loststone.toodledo.response.AddContextResponse;
import org.loststone.toodledo.response.AddFolderResponse;
import org.loststone.toodledo.response.AddGoalResponse;
import org.loststone.toodledo.response.AddTodoResponse;
import org.loststone.toodledo.response.AuthorizeResponse;
import org.loststone.toodledo.response.DeleteResponse;
import org.loststone.toodledo.response.GetContextsResponse;
import org.loststone.toodledo.response.GetFoldersResponse;
import org.loststone.toodledo.response.GetGoalsResponse;
import org.loststone.toodledo.response.GetTodosResponse;
import org.loststone.toodledo.response.ModifyTodoResponse;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.xml.ContextsParser;
import org.loststone.toodledo.xml.FolderParser;
import org.loststone.toodledo.xml.GetTodosParser;
import org.loststone.toodledo.xml.GoalsParser;

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
	public Todo getTodo(AuthToken auth, int id) throws ToodledoApiException {
		Todo filter = new Todo();
		filter.setId(id);
		List<Todo> res = getTodosList(auth,filter);
		if (res != null && res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Todo> getTodosList(AuthToken auth) throws ToodledoApiException {
		return getTodosList(auth,null);
	}
	
	@Override
	public List<Todo> getTodosList(AuthToken auth, Todo filter) throws ToodledoApiException {
		Request getTodosRequest = new GetTodosRequest(auth, filter);
		GetTodosResponse response = (GetTodosResponse)getTodosRequest.exec();
		if (response.succeeded())
			return new GetTodosParser(response.getResponseContent()).getTodos();
		else
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
		ModifyTodoRequest modifyRequest = new ModifyTodoRequest(auth,newOne);
		ModifyTodoResponse resp = (ModifyTodoResponse)modifyRequest.exec();
		if (resp.succeeded()) {
			Integer _t = Integer.parseInt(resp.getResponseContent());
			if (_t == 1) return true;
			else return false;
		} else
			return false;
	}

	@Override
	public boolean deleteTodo(AuthToken auth, int id)  throws ToodledoApiException{
		DeleteTodoRequest request = new DeleteTodoRequest(auth, id);
		DeleteResponse resp = (DeleteResponse)request.exec();
		if (resp.succeeded()) {
			Integer _t = Integer.parseInt(resp.getResponseContent());
			if (_t == 1) return true;
			else return false;
		} else
			return false;
	}

	@Override
	public List<Context> getContexts(AuthToken auth)  throws ToodledoApiException{
		GetContextsRequest request = new GetContextsRequest(auth);
		GetContextsResponse resp = (GetContextsResponse)request.exec();
		if (resp.succeeded())
			return new ContextsParser(resp.getResponseContent()).getContexts();
		else
			return null;
	}

	@Override
	public List<Folder> getFolders(AuthToken auth)  throws ToodledoApiException{
		GetFoldersRequest request = new GetFoldersRequest(auth);
		GetFoldersResponse resp = (GetFoldersResponse)request.exec();
		if (resp.succeeded())
			return new FolderParser(resp.getResponseContent()).getFolders();
		else
			return null;
	}

	@Override
	public List<Goal> getGoals(AuthToken auth)  throws ToodledoApiException{
		GetGoalsRequest request = new GetGoalsRequest(auth);
		GetGoalsResponse resp = (GetGoalsResponse)request.exec();
		if (resp.succeeded())
			return new GoalsParser(resp.getResponseContent()).getGoals();
		else
			return null;
	}

	@Override
	public int addFolder(AuthToken auth, Folder fold)
			throws ToodledoApiException {
		AddFolderRequest request = new AddFolderRequest(auth,fold);
		AddFolderResponse response = (AddFolderResponse)request.exec();
		if (response.succeeded())
			return Integer.parseInt(response.getResponseContent());
		else
			return -1;
	}

	@Override
	public int addContext(AuthToken auth, Context context)
			throws ToodledoApiException {
		AddContextRequest request = new AddContextRequest(auth, context);
		AddContextResponse response = (AddContextResponse)request.exec();
		if (response.succeeded())
			return Integer.parseInt(response.getResponseContent());
		else
			return -1;
	}

	@Override
	public int addGoal(AuthToken auth, Goal goal) throws ToodledoApiException {
		AddGoalRequest request = new AddGoalRequest(auth, goal);
		AddGoalResponse response = (AddGoalResponse)request.exec();
		if (response.succeeded())
			return Integer.parseInt(response.getResponseContent());
		else
			return -1;
	}

}
