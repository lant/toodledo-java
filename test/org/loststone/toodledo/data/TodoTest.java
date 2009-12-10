package org.loststone.toodledo.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TodoTest {
	
	private Todo td; 
	
	@Before
	public void setUp() {
		td = new Todo();
	}
	
	@After
	public void after() {
		td = null;
	}
	
	@Test
	public void testTitle() {
		td.setTitle("bla");
		assertEquals(td.getTitle(),"bla");
		
		td.setTitle("this is a far toooooooo long title for a Todo, because there is a limit of characters, "
				+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				);
		
		assertEquals(td.getTitle().length(),255);
	}
}
