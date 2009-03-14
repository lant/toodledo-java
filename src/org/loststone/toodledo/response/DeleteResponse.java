package org.loststone.toodledo.response;

import org.loststone.toodledo.ToodledoApiException;


public class DeleteResponse extends Response {

	public DeleteResponse(String resp) {
		super(resp);
		if (response.contains("error")) 
			this.succeed = false;
		else
			this.succeed = true;
	}
	
	@Override
	public int getResponseResult() {
		// TODO Auto-generated method stub
		return 0;
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
