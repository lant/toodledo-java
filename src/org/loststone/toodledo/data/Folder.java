package org.loststone.toodledo.data;

/**
 * This class represents a folder in toodledo.
 * @author lant
 *
 */
public class Folder {
	int id; 
	// is private ? 
	boolean bPrivate;
	// is it archived ? 
	boolean archived;
	// that's the user prefered order for listing the folders.
	int order;
	String sName;
	
	boolean hasName = false;
	boolean hasPrivate = false;
	
	/**
	 * Checks if this folder has the name field set.
	 * @return true if this folder has the name field correctly set.
	 */
	public boolean hasName() {
		return this.hasName;
	}
	
	/**
	 * Check if the private field is set.
	 * @return Does not return if this folder is private or not, it checks if the private field
	 * is set.
	 */
	public boolean hasPrivate() {
		return this.hasPrivate;
	}
	
	/**
	 * Returns the internal id of this folder.
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the internal id of this folder.
	 * This should only be used when creating the folder from a REST response, as the id is set
	 * internally in toodledo.
	 * @param id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Checks if this folder is private.
	 * @return true if the folder is set to private, false otherwise.
	 */
	public boolean isBPrivate() {
		return bPrivate;
	}
	
	/**
	 * @param true if the folder is to be set to private, false otherwise.
	 */
	public void setBPrivate(boolean private1) {
		bPrivate = private1;
		hasPrivate = true;
	}
	
	/**
	 * @return true if the folder is archived, false otherwise.
	 */
	public boolean isArchived() {
		return archived;
	}
	
	/**
	 * @param true if the folder is archived, false otherwise.
	 */
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	/**
	 * Returns the order of this folder when it's listed.
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	
	/**
	 * Sets the order for this folder. 
	 * @param order to set.
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * Gets the name of the folder.
	 * @return the name of the folder.
	 */
	public String getSName() {
		return sName;
	}
	
	/**
	 * Sets the name of the folder.
	 * @param name the folder. If the name is longer than 32 chars it will be cropped.
	 */
	public void setSName(String name) {
		if (name.length() > 32)
			sName = name.substring(0,31);
		else
			sName = name;
		
		this.hasName = true;
	}
	
	
}
