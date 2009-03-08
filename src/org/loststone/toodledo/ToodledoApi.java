package org.loststone.toodledo;

import java.util.List;

import org.loststone.toodledo.response.ToodledoApiException;
import org.loststone.toodledo.util.AuthToken;

/**
 * toodle do api implemented by this library.
 * @author lant
 *
 */
public interface ToodledoApi {

	AuthToken initialize(String username, String password) throws ToodledoApiException;
	boolean addTodo(AuthToken auth, Todo todo); 
	Todo getTodo(AuthToken auth, int id);
	boolean modifyTodo(AuthToken auth, Todo newOne);
	List<String> getTodosList(AuthToken auth);
	
}
