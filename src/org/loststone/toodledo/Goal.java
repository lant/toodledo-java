package org.loststone.toodledo;

import org.loststone.toodledo.exception.ToodledoApiException;

/**
 * This class represents the goal in toodledo.
 * @author lant
 */
public class Goal {

	int id; 
	// 0 lifetime, 1 long-term, 2 short term.
	int level; 
	// id of other goals that this goal contributes.
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
	 * Returns the internal id of this goal.
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the internal goal id. This should only be used when creating a goal from an xml that
	 * comes from the REST API.
	 * @param id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the level of this goal:
	 * <ul>
	 * <li> 0 - lifetime
	 * <li> 1 - long term
	 * <li> 2 - short term
	 * </ul>
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Sets the level for this goal:
	 * <ul>
	 * <li> 0 - lifetime
	 * <li> 1 - long term
	 * <li> 2 - short term
	 * </ul>
	 * @param the level to set
	 * @throws ToodledoApiException 
	 */
	public void setLevel(int level) throws ToodledoApiException {
		if (level < 0 || level > 2) 
			throw new ToodledoApiException("The level must be a number between 0 and 2");
		this.level = level;
		this.hasLevel = true;
	}
	
	/**
	 * Return the id of the goal this goal contributes to.
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
	 * Gets the name of this goal.
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
