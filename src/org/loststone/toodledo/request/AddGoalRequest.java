package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.Goal;
import org.loststone.toodledo.ToodledoApiException;
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
	public Response exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		Response addResp = null; 
		try {
			client.executeMethod(method);
			addResp = new AddGoalResponse(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return addResp;
	}

}
