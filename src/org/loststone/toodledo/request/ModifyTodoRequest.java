package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.ModifyTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class ModifyTodoRequest extends Request {

	public ModifyTodoRequest(AuthToken token, Todo todo) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=editTask;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (todo.hasId()) {
			buff.append(";id="+todo.getId());
		} else {
			throw new ToodledoApiException("At least the todo must have the 'id' field.");
		}
		if (todo.hasTitle()) buff.append(";title=").append(todo.getTitle()); 
		if (todo.hasTag()) buff.append(";tag=").append(todo.getTag());
		if (todo.hasFolder()) buff.append(";folder=").append(todo.getFolder());
		if (todo.hasContext()) buff.append(";context=").append(todo.getContext());
		if (todo.hasGoal()) buff.append(";goal=").append(todo.getGoal());
		if (todo.hasParent()) buff.append(";parent=").append(todo.getParent());
		if (todo.hasBefore()) buff.append(";before=").append(todo.getBefore());
		if (todo.hasStartbefore()) buff.append(";startbefore=").append(todo.getStartbefore());
		if (todo.hasRepeat()) buff.append(";repeat=").append(todo.getRepeat());
		if (todo.hasRepAdvanced()) buff.append(";rep_advanced=").append(todo.getRepAdvanced());
		if (todo.hasStatus()) buff.append(";status=").append(todo.getStatus());
		if (todo.hasLength()) buff.append(";length=").append(todo.getLength());
		if (todo.hasPriority()) buff.append(";priority=").append(todo.getPriority());
		if (todo.hasStar()) buff.append(";star=").append(todo.getStart());
		if (todo.hasNote()) buff.append(";note=").append(todo.hasNote());
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		if (this.xmlResponse == null) 
			return null;
		ModifyTodoResponse mresp = new ModifyTodoResponse(this.xmlResponse);
		return mresp;
	}

}
