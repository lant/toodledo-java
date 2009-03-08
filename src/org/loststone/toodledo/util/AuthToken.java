package org.loststone.toodledo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.joda.time.DateTime;

public class AuthToken {
	private String token; 
	private String key;
	private DateTime date;
	
	
	public AuthToken(String password, String username, String token) {
		System.out.println("password: "+password);
		System.out.println("username: "+username);
		System.out.println("token   : "+token);
		
		this.token = token; 
		
		// get the key
		MessageDigest messagedigest;
		String md5pass; 
		String total; 
		
		try {
			messagedigest = MessageDigest.getInstance("MD5");
			// md5 from the password
			messagedigest.update(password.getBytes());
			md5pass = new String(messagedigest.digest());
			
			total = md5pass+token+username;
			messagedigest.update(total.getBytes());
			this.key = new String(messagedigest.digest());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.date = new DateTime().plusHours(4);
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	
	/**
	 * @return the date
	 */
	public DateTime getDate() {
		return date;
	}
	
	/**
	 * Returns the remainin time of validity for this token in seconds.
	 * @return seconds until this token will be canceled.
	 */
	public int getRemainingTime() {
		return Math.max(0, this.date.getSecondOfDay() - new DateTime().getSecondOfDay());
	}

}
