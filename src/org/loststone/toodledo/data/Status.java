package org.loststone.toodledo.data;

public enum Status {

    NONE(0),
    NEXT_ACTION(1),
    ACTIVE(2),
    PLANNING(3),
    DELEGATED(4),
    WAITING(5),
    HOLD(6),
    POSTPONED(7),
    SOMEDAY(8),
    CANCELED(9),
    REFERENCE(10);
    
    private final int number; 
    Status(int number) {
    	this.number = number;
    }
    
    public int getStatusAsInteger() {return this.number;}
}
