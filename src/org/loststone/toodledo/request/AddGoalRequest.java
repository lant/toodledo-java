package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Goal;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddGoalResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class AddGoalRequest extends Request {

	public AddGoalRequest(AuthToken token, Goal goal) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addGoal;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (goal.hasName()) { 
			buff.append(";title=").append(goal.getName()); 
		} else { 
			throw new ToodledoApiException("Folder object at least must have a name!");
		}
		if (goal.hasLevel()) 
			buff.append(";level=").append(goal.getLevel());
		if (goal.hasContributes())
			buff.append(";contributes=").append(goal.getContributes());
		
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		AddGoalResponse response = new AddGoalResponse(this.xmlResponse);
		return response;
	}
	

}
