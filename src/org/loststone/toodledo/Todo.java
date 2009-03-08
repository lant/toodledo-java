package org.loststone.toodledo;

import org.loststone.toodledo.util.TdDate;
import org.loststone.toodledo.util.TdDateTime;

/**
 * This class maps all the components of a toodledo task. For more info
 * go to http://www.toodledo.com/info/api_doc.php
 * @author lant
 *
 */
public class Todo {
	String title;
	String tag; 
	int folder; // id of the folder, 0 means no folder.
	int context; // 0 no context
	int goal; // 0 no goal
	Priority priority;
	Repeat repeat;
	Status status;
	int parent; // 0 if none
	int shorter; 
	int longer;
	TdDate before;
	TdDate after; 
	TdDate startbefore; 
	TdDate startafter;
	TdDateTime modbefore;
	TdDateTime modafter; 
	TdDate compbefore;
	TdDate compafter; 
	boolean notcomp;
	boolean star; 
	int id; 
	int start; 
	int end;
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * @return the folder
	 */
	public int getFolder() {
		return folder;
	}
	
	/**
	 * @param folder the folder to set
	 */
	public void setFolder(int folder) {
		this.folder = folder;
	}
	
	/**
	 * @return the context
	 */
	public int getContext() {
		return context;
	}
	
	/**
	 * @param context the context to set
	 */
	public void setContext(int context) {
		this.context = context;
	}
	
	/**
	 * @return the goal
	 */
	public int getGoal() {
		return goal;
	}
	
	/**
	 * @param goal the goal to set
	 */
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	/**
	 * @return the repeat
	 */
	public Repeat getRepeat() {
		return repeat;
	}
	
	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(Repeat repeat) {
		this.repeat = repeat;
	}
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}
	
	/**
	 * @param parent the parent to set
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	/**
	 * @return the shorter
	 */
	public int getShorter() {
		return shorter;
	}
	
	/**
	 * @param shorter the shorter to set
	 */
	public void setShorter(int shorter) {
		this.shorter = shorter;
	}

	/**
	 * @return the longer
	 */
	public int getLonger() {
		return longer;
	}
	
	/**
	 * @param longer the longer to set
	 */
	public void setLonger(int longer) {
		this.longer = longer;
	}
	
	/**
	 * @return the before
	 */
	public TdDate getBefore() {
		return before;
	}
	
	/**
	 * @param before the before to set
	 */
	public void setBefore(TdDate before) {
		this.before = before;
	}
	
	/**
	 * @return the after
	 */
	public TdDate getAfter() {
		return after;
	}
	
	/**
	 * @param after the after to set
	 */
	public void setAfter(TdDate after) {
		this.after = after;
	}
	
	/**
	 * @return the startbefore
	 */
	public TdDate getStartbefore() {
		return startbefore;
	}
	
	/**
	 * @param startbefore the startbefore to set
	 */
	public void setStartbefore(TdDate startbefore) {
		this.startbefore = startbefore;
	}
	
	/**
	 * @return the startafter
	 */
	public TdDate getStartafter() {
		return startafter;
	}
	
	
	/**
	 * @param startafter the startafter to set
	 */
	public void setStartafter(TdDate startafter) {
		this.startafter = startafter;
	}
	
	/**
	 * @return the modbefore
	 */
	public TdDateTime getModbefore() {
		return modbefore;
	}
	
	/**
	 * @param modbefore the modbefore to set
	 */
	public void setModbefore(TdDateTime modbefore) {
		this.modbefore = modbefore;
	}
	
	/**
	 * @return the modafter
	 */
	public TdDateTime getModafter() {
		return modafter;
	}
	
	/**
	 * @param modafter the modafter to set
	 */
	public void setModafter(TdDateTime modafter) {
		this.modafter = modafter;
	}
	
	/**
	 * @return the compbefore
	 */
	public TdDate getCompbefore() {
		return compbefore;
	}
	
	/**
	 * @param compbefore the compbefore to set
	 */
	public void setCompbefore(TdDate compbefore) {
		this.compbefore = compbefore;
	}
	
	/**
	 * @return the compafter
	 */
	public TdDate getCompafter() {
		return compafter;
	}
	
	/**
	 * @param compafter the compafter to set
	 */
	public void setCompafter(TdDate compafter) {
		this.compafter = compafter;
	}
	
	/**
	 * @return the notcomp
	 */
	public boolean isNotcomp() {
		return notcomp;
	}
	
	/**
	 * @param notcomp the notcomp to set
	 */
	public void setNotcomp(boolean notcomp) {
		this.notcomp = notcomp;
	}

	/**
	 * @return the star
	 */
	public boolean isStar() {
		return star;
	}
	
	/**
	 * @param star the star to set
	 */
	public void setStar(boolean star) {
		this.star = star;
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
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	
	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	} 
	
}
