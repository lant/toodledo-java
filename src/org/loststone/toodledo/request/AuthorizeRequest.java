package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.response.AuthorizeResponse;
import org.loststone.toodledo.response.Response;

public class AuthorizeRequest extends Request {

	public AuthorizeRequest(String userId) {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getToken;userid="+userId;
	}
	

	@Override
	public Response exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		AuthorizeResponse authResp = null; 
		try {
			client.executeMethod(method);
			authResp = new AuthorizeResponse(method.getResponseBodyAsString());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return authResp;
	}

}
