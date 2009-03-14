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
	
	/**
	 * Adds a Todo ( a task ) to toodledo.
	 * @param auth Authorization token for that user
	 * @param todo Todo object to add.
	 * @return the id of the new task added. -1 if it fails.
	 * @throws ToodledoApiException
	 */
	int addTodo(AuthToken auth, Todo todo) throws ToodledoApiException; 
	
	/**
	 * Adds a folder to toodledo.
	 * @param auth Authorization token for that user.
	 * @param fold Folder to add.
	 * @return id of the folder, -1 if it fails.
	 * @throws ToodledoApiException
	 */
	int addFolder(AuthToken auth, Folder fold) throws ToodledoApiException; 
	
	/**
	 * Adds a context to toodledo.
	 * @param auth Authorization token for that user.
	 * @param context Context to add.
	 * @return id of the new context, -1 if it fails.
	 * @throws ToodledoApiException
	 */
	int addContext(AuthToken auth, Context context) throws ToodledoApiException;
	
	/**
	 * Adds a goal to toodledlo.
	 * @param auth Authorization token for that user.
	 * @param goal Goal to add.
	 * @return id of the new goal, -1 if it fails.
	 * @throws ToodledoApiException
	 */
	int addGoal(AuthToken auth, Goal goal) throws ToodledoApiException;
	
	/**
	 * Gets a given task.
	 * @param auth Authorization token for that user.
	 * @param id id of the task to get.
	 * @return Todo object with the task, null if it fails to retrieve it.
	 */
	Todo getTodo(AuthToken auth, int id) throws ToodledoApiException;
	
	/**
	 * Modify a given Task
	 * @param auth Authorization token for that user.
	 * @param newOne Task with the modifications.
	 * @return true if that task was updated succesfully, false otherwise.
	 * @throws ToodledoApiException
	 */
	boolean modifyTodo(AuthToken auth, Todo newOne) throws ToodledoApiException;
	
	/**
	 * Deletes a Todo. This method will <b>delete</b> the task. If you want to tag
	 * this task as <b>done</b> you should use the <i>modifyTodo</i> method instead.
	 * @param auth Authorization token to use.
	 * @param id id of the Task to delete.
	 * @return true upon succesfull deletion, false otherwise.
	 * @throws ToodledoApiException
	 */
	boolean deleteTodo(AuthToken auth, int id) throws ToodledoApiException;
	
	/**
	 * Gets all the Tasks for that user.
	 * @param auth Authorization token for that user.
	 * @return A list containing all the tasks for that user.
	 * @throws ToodledoApiException
	 */
	List<Todo> getTodosList(AuthToken auth) throws ToodledoApiException;
	
	/**
	 * Gets all the tasks that match the given task.
	 * @param auth Authorization token for that user.
	 * @param filter This task is a dummy task. It's used as a filter for the search.
	 * @return A list containing the tasks that match the filter.
	 * @throws ToodledoApiException
	 */
	List<Todo> getTodosList(AuthToken auth, Todo filter) throws ToodledoApiException;
	
	/**
	 * Gets all the folders
	 * @param auth Authorization token for that user.
	 * @return A list of Folders.
	 * @throws ToodledoApiException
	 */
	List<Folder> getFolders(AuthToken auth) throws ToodledoApiException;
	
	/**
	 * Gets all the contexts for that user.
	 * @param auth Authorization token for that user.
	 * @return A list with all the contexts.
	 * @throws ToodledoApiException
	 */
	List<Context> getContexts(AuthToken auth) throws ToodledoApiException;
	
	/**
	 * Gets all the goals for that user.
	 * @param auth Authorization token for that user.
	 * @return A list containing all the goals for that user.
	 * @throws ToodledoApiException
	 */
	List<Goal> getGoals(AuthToken auth) throws ToodledoApiException;
	
	
}
