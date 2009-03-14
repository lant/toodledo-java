package org.loststone.toodledo;

public class Context {
	int id;
	String name;
	
	boolean hasName = false;
	
	public boolean hasName() {
		return this.hasName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
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
