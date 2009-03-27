package org.loststone.toodledo.request;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.loststone.toodledo.Folder;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddFolderResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class AddFolderRequest extends Request {

	public AddFolderRequest(AuthToken token, Folder fold) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addFolder;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (fold.hasName()) { buff.append(";title=").append(fold.getSName()); 
		} else { 
			throw new ToodledoApiException("Folder object at least must have a name!");
		}
		if (fold.hasPrivate()) {
			buff.append(";private=");
			if (fold.isBPrivate())
				buff.append("1");
			else
				buff.append("0");
		}
		
		this.url = this.url.concat(buff.toString());
	}
	
}
