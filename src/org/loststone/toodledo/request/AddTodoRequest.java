package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TextEncoder;

public class AddTodoRequest extends Request {

	private TextEncoder tEnc = new TextEncoder();
	
	public AddTodoRequest(AuthToken token, Todo todo) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addTask;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (todo.hasTitle()) { buff.append(";title=").append(tEnc.encode(todo.getTitle())); 
		} else { 
			throw new ToodledoApiException("Todo object at least must have a title!");
		}
		if (todo.hasTag()) buff.append(";tag=").append(tEnc.encode(todo.getTag()));
		if (todo.hasFolder()) buff.append(";folder=").append(todo.getFolder());
		if (todo.hasContext()) buff.append(";context=").append(todo.getContext());
		if (todo.hasGoal()) buff.append(";goal=").append(todo.getGoal());
		if (todo.hasParent()) buff.append(";parent=").append(todo.getParent());
		if (todo.hasBefore()) buff.append(";before=").append(todo.getBefore());
		if (todo.hasStartbefore()) buff.append(";startbefore=").append(todo.getStartbefore());
		
		// TODO missiing duetime and starttime
		
		if (todo.hasRepeat()) buff.append(";repeat=").append(todo.getRepeat());
		if (todo.hasRepAdvanced()) buff.append(";rep_advanced=").append(tEnc.encode(todo.getRepAdvanced()));
		if (todo.hasStatus()) buff.append(";status=").append(todo.getStatus());
		if (todo.hasLength()) buff.append(";length=").append(todo.getLength());
		if (todo.hasPriority()) buff.append(";priority=").append(todo.getPriority());
		if (todo.hasStar()) buff.append(";star=").append(todo.getStart());
		if (todo.hasNote()) buff.append(";note=").append(tEnc.encode(todo.getNote()));
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		AddTodoResponse response = new AddTodoResponse(this.xmlResponse);
		return response;
	}
	
}
