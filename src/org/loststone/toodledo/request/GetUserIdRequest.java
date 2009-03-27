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
	
}
