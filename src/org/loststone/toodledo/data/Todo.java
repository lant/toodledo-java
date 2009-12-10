package org.loststone.toodledo.data;

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
	String rep_advanced; 
	Status status;
	int parent; // 0 if none
	int shorter; 
	int length; 
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
	String note; 
	private boolean hasEnd = false;
	private boolean hasStart = false;
	private boolean hasId = false;
	private boolean hasStar = false;
	private boolean hasComp = false;
	private boolean hasCompafter = false;
	private boolean hasCompbefore = false;
	private boolean hasModbefore = false;
	private boolean hasModafter = false;
	private boolean hasStartafter = false;
	private boolean hasStartbefore = false;
	private boolean hasAfter = false;
	private boolean hasBefore = false;
	private boolean hasLonger = false;
	private boolean hasShorter = false;
	private boolean hasParent = false;
	private boolean hasStatus = false;
	private boolean hasRepeat = false;
	private boolean hasPriority = false;
	private boolean hasGoal = false;
	private boolean hasContext = false;
	private boolean hasFolder = false;
	private boolean hasTag = false;
	private boolean hasTitle = false;
	private boolean hasRepAdvanced = false;
	private boolean hasLength = false; 
	private boolean hasNote = false; 
	
	public Todo() {}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title for the task.
	 * @param title the title to set. If the title is longer than 255 charts it will be cropped.
	 */
	public void setTitle(String title) {
		if (title.length() > 255)
			this.title = title.substring(0,255);
		else
			this.title = title;
		
		this.hasTitle = true;
	}
	
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * Set the rep_advanced.
	 */
	public String getRepAdvanced() {
		return this.rep_advanced;
	}
	
	/**
	 * Get the rep_advanced.
	 */
	public void setRepAdvanced(String repAdv) {
		this.rep_advanced = repAdv; 
		this.hasRepAdvanced = true;
	}
	
	public void setNote(String note) {
		this.note = note; 
		this.hasNote = true;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setLength(int length) {
		this.length = length;
		this.hasLength = true;
	}
	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
		this.hasTag = true;
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
		this.hasFolder = true;
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
		this.hasContext = true;
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
		this.hasGoal = true;
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
		this.hasPriority = true;
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
		this.hasRepeat = true; 
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
		this.hasStatus = true;
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
		this.hasParent = true;
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
		this.hasShorter = true; 
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
		this.hasLonger = true;
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
		this.hasBefore = true;
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
		this.hasAfter = true;
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
		this.hasStartbefore = true;
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
		this.hasStartafter = true;
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
		this.hasModbefore = true;
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
		this.hasModafter = true;
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
		this.hasCompbefore = true;
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
		this.hasCompafter = true;
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
		this.hasComp = true;
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
		this.hasStar = true;
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
		this.hasId = true;
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
		this.hasStart = true;
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
		this.hasEnd = true;
	}

	/**
	 * @return the hasEnd
	 */
	public boolean hasEnd() {
		return hasEnd;
	}

	/**
	 * @return the hasStart
	 */
	public boolean hasStart() {
		return hasStart;
	}

	/**
	 * @return the hasId
	 */
	public boolean hasId() {
		return hasId;
	}

	/**
	 * @return the hasStar
	 */
	public boolean hasStar() {
		return hasStar;
	}

	/**
	 * @return the hasComp
	 */
	public boolean hasComp() {
		return hasComp;
	}

	/**
	 * @return the hasCompafter
	 */
	public boolean isHasCompafter() {
		return hasCompafter;
	}

	/**
	 * @return the hasCompbefore
	 */
	public boolean hasCompbefore() {
		return hasCompbefore;
	}

	/**
	 * @return the hasModbefore
	 */
	public boolean hasModbefore() {
		return hasModbefore;
	}

	/**
	 * @return the hasModafter
	 */
	public boolean hasModafter() {
		return hasModafter;
	}

	/**
	 * @return the hasStartafter
	 */
	public boolean hasStartafter() {
		return hasStartafter;
	}

	/**
	 * @return the hasStartbefore
	 */
	public boolean hasStartbefore() {
		return hasStartbefore;
	}

	/**
	 * @return the hasAfter
	 */
	public boolean hasAfter() {
		return hasAfter;
	}

	/**
	 * @return the hasBefore
	 */
	public boolean hasBefore() {
		return hasBefore;
	}

	/**
	 * @return the hasLonger
	 */
	public boolean hasLonger() {
		return hasLonger;
	}

	/**
	 * @return the hasShorter
	 */
	public boolean hasShorter() {
		return hasShorter;
	}

	/**
	 * @return the hasParent
	 */
	public boolean hasParent() {
		return hasParent;
	}

	/**
	 * @return the hasStatus
	 */
	public boolean hasStatus() {
		return hasStatus;
	}

	/**
	 * @return the hasRepeat
	 */
	public boolean hasRepeat() {
		return hasRepeat;
	}

	/**
	 * @return the hasPriorit
	 */
	public boolean hasPriority() {
		return hasPriority;
	}

	/**
	 * @return the hasGoal
	 */
	public boolean hasGoal() {
		return hasGoal;
	}

	/**
	 * @return the hasContext
	 */
	public boolean hasContext() {
		return hasContext;
	}

	/**
	 * @return the hasFolder
	 */
	public boolean hasFolder() {
		return hasFolder;
	}

	/**
	 * @return the hasTag
	 */
	public boolean hasTag() {
		return hasTag;
	}

	/**
	 * @return the hasTitle
	 */
	public boolean hasTitle() {
		return hasTitle;
	} 
	
	public boolean hasRepAdvanced() {
		return this.hasRepAdvanced;
	}
	
	public boolean hasLength() {
		return this.hasLength;
	}
	
	public boolean hasNote() {
		return this.hasNote;
	}
}
