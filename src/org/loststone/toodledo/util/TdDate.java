package org.loststone.toodledo.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TdDate {
	
	protected DateTime dt; 
	
	public TdDate() {
		dt = new DateTime();
	}
	
	public TdDate(int year, int month, int day) {
		dt = new DateTime(year, month, day, 0,0,0,0);
	}
	
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
		return dt.toString(fmt);
	}
}
