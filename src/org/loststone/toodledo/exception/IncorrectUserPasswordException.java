package org.loststone.toodledo.exception;

public class IncorrectUserPasswordException extends Exception {


	public IncorrectUserPasswordException(String substring) {
		super(substring);
	}


	private static final long serialVersionUID = 1L;

}
