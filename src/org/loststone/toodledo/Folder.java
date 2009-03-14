package org.loststone.toodledo;

public class Folder {
	int id; 
	boolean bPrivate;
	boolean archived;
	int order;
	// TODO up to 32 charts
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
	 * @param name the sName to set
	 * TODO up to 32 chars
	 */
	public void setSName(String name) {
		sName = name;
		this.hasName = true;
	}
	
	
}
