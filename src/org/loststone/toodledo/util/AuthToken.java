package org.loststone.toodledo.util;

import java.io.UnsupportedEncodingException;
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
		String total; 
		
		try {
			total = MD5(password)+token+username;
			this.key = MD5(total);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
	
	private String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
        	int halfbyte = (data[i] >>> 4) & 0x0F;
        	int two_halfs = 0;
        	do {
	        	if ((0 <= halfbyte) && (halfbyte <= 9))
	                buf.append((char) ('0' + halfbyte));
	            else
	            	buf.append((char) ('a' + (halfbyte - 10)));
	        	halfbyte = data[i] & 0x0F;
        	} while(two_halfs++ < 1);
        }
        return buf.toString();
    }
 
	private String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] md5hash = new byte[32];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5hash = md.digest();
		return convertToHex(md5hash);
	}

}
