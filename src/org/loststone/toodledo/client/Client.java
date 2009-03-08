package org.loststone.toodledo.client;

import org.loststone.toodledo.ToodledoApi;
import org.loststone.toodledo.ToodledoApiImpl;
import org.loststone.toodledo.response.ToodledoApiException;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToodledoApi api = new ToodledoApiImpl();
		try {
			api.initialize("td49a6af85992a0", "n0ct1rn4l");
		} catch (ToodledoApiException e) {
			e.printStackTrace();
		}
	}

}
