package org.loststone.toodledo;

public class Goal {

	int id; 
	int level; 
	int contributes; 
	boolean archive; 
	String name;
	
	boolean hasName = false;
	boolean hasLevel = false;
	boolean hasContributes = false; 
	
	public boolean hasName() {
		return this.hasName;
	}
	
	public boolean hasLevel() {
		return this.hasLevel;
	}
	
	public boolean hasContributes() {
		return this.hasContributes;
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
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
		this.hasLevel = true;
	}
	/**
	 * @return the contributes
	 */
	public int getContributes() {
		return contributes;
	}
	/**
	 * @param contributes the contributes to set
	 */
	public void setContributes(int contributes) {
		this.contributes = contributes;
		this.hasContributes = true;
	}
	/**
	 * @return the archive
	 */
	public boolean isArchive() {
		return archive;
	}
	/**
	 * @param archive the archive to set
	 */
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name for that goal.
	 * @param name for this goal. If the name is longer than 255 it will be cropped.
	 */
	public void setName(String name) {
		if (name.length() > 255)
			this.name = name.substring(0,254);
		else
			this.name = name;
		this.hasName = true;
	} 
	
}
