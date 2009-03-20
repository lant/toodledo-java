package org.loststone.toodledo.exception;

public class MissingPasswordException extends Exception {


	public MissingPasswordException(String substring) {
		super(substring);
	}


	private static final long serialVersionUID = 1L;

}
