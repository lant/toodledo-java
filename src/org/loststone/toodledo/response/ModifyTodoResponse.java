package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.ToodledoApiException;


public class ModifyTodoResponse extends Response {

	public ModifyTodoResponse(String resp) {
		super(resp);
	}
	

	
	public String getResponseContent() throws ToodledoApiException {
		String result = null;		
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		
		result = response.substring(response.indexOf("<success>")+9, response.indexOf("</success>"));
		return result; 
	}

}
