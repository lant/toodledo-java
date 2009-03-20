package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetUserIdResponse;
import org.loststone.toodledo.response.Response;

public class GetUserIdRequest extends Request {

	public GetUserIdRequest(String email, String password) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getUserId;email="+email+";pass="+password+";";
	}
	

	@Override
	public Response exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		Response getUser = null; 
		try {
			client.executeMethod(method);
			getUser = new GetUserIdResponse(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return getUser;
	}

}
