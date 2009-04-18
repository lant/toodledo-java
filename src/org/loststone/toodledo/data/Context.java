package org.loststone.toodledo.data;

/**
 * This class represents a Context in toodledo.
 * <p>
 * From the toodledo webpage:
 * <p>
 * <i>Contexts help you organize your tasks by where you are and what you are doing. 
 * The context filter on Toodledo will hide every task that does not match your current context,
 *  so you can quickly see only those items which are important to you at the moment.</i>
 * @author lant
 *
 */
public class Context {
	int id;
	String name;
	
	boolean hasName = false;
	
	/**
	 * Checks if the context has an assigned name.
	 * @return
	 */
	public boolean hasName() {
		return this.hasName;
	}
	
	/**
	 * Gets the toodledo internal id of this context.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the toodledo internal id for this context.
	 * @param id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return The name of this context.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name for this context.
	 * @param Sets the name for the context. This is 32 chars maximum, names with more that that will be cropped.
	 */
	public void setName(String name) {
		if (name.length() > 32)
			this.name = name.substring(0,31);
		else
			this.name = name;
		
		this.hasName = true;
	}
	
}
