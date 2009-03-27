package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;


public class ModifyTodoResponse extends Response {

	public ModifyTodoResponse(String resp) {
		super(resp);
	}
	

	
	// TODO refactor to the parent class.
	public String getResponseContent() throws ToodledoApiException {
		String result = null;		
		// check for errors:
		if (response.contains("error")) {
			this.succeed = false;
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		
		result = response.substring(response.indexOf("<success>")+9, response.indexOf("</success>"));
		this.succeed = true;
		return result; 
	}

}
