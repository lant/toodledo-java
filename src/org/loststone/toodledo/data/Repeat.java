package org.loststone.toodledo.data;

public enum Repeat {
	NO_REPEAT(0),
	WEEKLY(1),
	MONTHLY(2),
	YEARLY(3),
	DAILY(4),
	BIWEEKLY(5),
	BIMONTHLY(6),
	SEMIANNUALLY(7),
	QUARTERLY(8),
	WITH_PARENT(9);
	
	private final int number;
	Repeat(int number) {
		this.number = number;
	}
	public int getRepeatAsInteger() {return this.number;}

}
