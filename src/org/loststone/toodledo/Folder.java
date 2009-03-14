package org.loststone.toodledo;

public class Folder {
	int id; 
	boolean bPrivate;
	boolean archived;
	int order;
	String sName;
	
	boolean hasName = false;
	boolean hasPrivate = false;
	
	public boolean hasName() {
		return this.hasName;
	}
	
	public boolean hasPrivate() {
		return this.hasPrivate;
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
	 * @return the bPrivate
	 */
	public boolean isBPrivate() {
		return bPrivate;
	}
	/**
	 * @param private1 the bPrivate to set
	 */
	public void setBPrivate(boolean private1) {
		bPrivate = private1;
		hasPrivate = true;
	}
	/**
	 * @return the archived
	 */
	public boolean isArchived() {
		return archived;
	}
	/**
	 * @param archived the archived to set
	 */
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * @return the sName
	 */
	public String getSName() {
		return sName;
	}
	
	/**
	 * Set the name of the folder.
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
