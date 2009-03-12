package org.loststone.toodledo;

import java.util.List;

import org.loststone.toodledo.util.AuthToken;

/**
 * toodle do api implemented by this library.
 * @author lant
 */
public interface ToodledoApi {

	/**
	 * This method authenticates a user.
	 * @param username Username of the user.
	 * @param password Password of the user
	 * @return Returns an AuthToken which is the object that holds the authorization key for that user
	 * to use the web service. It expires after 4 hours.
	 * @throws ToodledoApiException
	 */
	AuthToken initialize(String username, String password) throws ToodledoApiException;
	
	int addTodo(AuthToken auth, Todo todo) throws ToodledoApiException; 
	Todo getTodo(AuthToken auth, int id) throws ToodledoApiException;
	boolean modifyTodo(AuthToken auth, Todo newOne) throws ToodledoApiException;
	boolean deleteTodo(AuthToken auth, int id) throws ToodledoApiException;
	List<String> getTodosList(AuthToken auth) throws ToodledoApiException;
	List<String> getFolders(AuthToken auth) throws ToodledoApiException;
	List<String> getContexts(AuthToken auth) throws ToodledoApiException;
	List<String> getGoals(AuthToken auth) throws ToodledoApiException;
	
	
}
