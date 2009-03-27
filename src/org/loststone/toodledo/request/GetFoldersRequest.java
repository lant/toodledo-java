package org.loststone.toodledo.request;

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
	public Response getResponse() {
		this.exec();
		GetFoldersResponse response = new GetFoldersResponse(this.xmlResponse);
		return response;
	}
	
}
