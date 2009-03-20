package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.Context;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddContextResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class AddContextRequest extends Request {

	public AddContextRequest(AuthToken token, Context context) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addContext;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (context.hasName()) { buff.append(";title=").append(context.getName()); 
		} else { 
			throw new ToodledoApiException("Folder object at least must have a name!");
		}
		this.url = this.url.concat(buff.toString());
	}
	

	@Override
	public Response exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		Response addResp = null; 
		try {
			client.executeMethod(method);
			addResp = new AddContextResponse(method.getResponseBodyAsString());
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
