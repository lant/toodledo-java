package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GenericDeleteResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class DeleteFolderRequest extends Request {

	public DeleteFolderRequest(AuthToken token, int id) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=deleteFolder;key="+token.getKey()+";id="+id;
	}

	@Override
	public Response getResponse() {
		this.exec();
		GenericDeleteResponse response = new GenericDeleteResponse(this.xmlResponse);
		return response;
	}
	
}
