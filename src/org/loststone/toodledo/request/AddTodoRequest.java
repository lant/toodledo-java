package org.loststone.toodledo.request;

import org.loststone.toodledo.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class AddTodoRequest extends Request {

	public AddTodoRequest(AuthToken token, Todo todo) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addTask;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (todo.hasTitle()) { buff.append(";title=").append(todo.getTitle()); 
		} else { 
			throw new ToodledoApiException("Todo object at least must have a title!");
		}
		if (todo.hasTag()) buff.append(";tag=").append(todo.getTag());
		if (todo.hasFolder()) buff.append(";folder=").append(todo.getFolder());
		if (todo.hasContext()) buff.append(";context=").append(todo.getContext());
		if (todo.hasGoal()) buff.append(";goal=").append(todo.getGoal());
		if (todo.hasParent()) buff.append(";parent=").append(todo.getParent());
		if (todo.hasBefore()) buff.append(";before=").append(todo.getBefore());
		if (todo.hasStartbefore()) buff.append(";startbefore=").append(todo.getStartbefore());
		// TODO seems there's something missing if (todo.has)
		if (todo.hasRepeat()) buff.append(";repeat=").append(todo.getRepeat());
		// TODO repeat advances
		if (todo.hasStatus()) buff.append(";status=").append(todo.getStatus());
		// TODO length in minutes
		if (todo.hasPriority()) buff.append(";priority=").append(todo.getPriority());
		if (todo.hasStar()) buff.append(";star=").append(todo.getStart());
		// TODO add a note
		
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		AddTodoResponse response = new AddTodoResponse(this.xmlResponse);
		return response;
	}
	
}
