package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Diamond;

import static org.hamcrest.CoreMatchers.instanceOf;



public class BoulderDashModelTest {

	 
	private BoulderDashModel BoulderDashModel;
	private Object[] diamonds;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	@Before
	public void setUp() throws Exception {
		this.BoulderDashModel = new BoulderDashModel();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	

	
	@Test
	public void testOpenDoor() {
	
	}

	@Test
	public void testGetLevelCompleted() {
		
	
	}

	@Test
	public void testGetGameOver() {
		
	}

	@Test
	public void testGetDiamonds() {
		Diamond diamonds = null;
		final Diamond expected = diamonds;
		assertEquals(expected, this.diamonds);
		
	}

	@Test
	public void testGetSteps() {
		
	}

	@Test
	public void testTick() {
		
	}

	@Test
	public void testGetCaveArray() {
		
	}
	

}
