package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetFoldersResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class GetFoldersRequest extends Request {

	public GetFoldersRequest(AuthToken token) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getFolders;key="+token.getKey();	
	}
	

	@Override
	public Response exec() {
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(this.url);
		Response addResp = null; 
		try {
			client.executeMethod(method);
			addResp = new GetFoldersResponse(method.getResponseBodyAsString());
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
