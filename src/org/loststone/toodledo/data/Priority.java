package org.loststone.toodledo.data;

import java.util.HashMap;
import java.util.Map;

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
	
	public static final Map<Integer, Priority> ValueFromInt = new HashMap<Integer, Priority>() {{
		put(-1, NEGATIVE);
		put(0, LOW);
		put(1, MEDIUM);
		put(2, HIGH);
		put(3, TOP);
	}};
}
