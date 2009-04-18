package org.loststone.toodledo.data;

public enum Priority {
	NEGATIVE(-1),
	LOW(0),
	MEDIUM(1),
	HIGH(2),
	TOP(3);

	private final int number;  

	Priority(int number) {
		this.number = number;
	}
	public int getPriorityAsInt()   { return number; }

}
