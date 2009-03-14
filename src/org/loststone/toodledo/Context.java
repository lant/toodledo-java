package org.loststone.toodledo;

public class Context {
	int id;
	// TODO up to 32 chars
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
	 * @param name the name to set
	 * TODO up to 32 chars
	 */
	public void setName(String name) {
		this.name = name;
		this.hasName = true;
	}
	
}
