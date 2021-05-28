package controller;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import model.BoulderDashModel;
import model.element.Player;

public class BoulderDashControllerTest {
	private BoulderDashModel boulderdashmodel;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@Before
	public void setUp() throws Exception {
		this.boulderdashmodel = new BoulderDashModel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBoulderDashController() {
		//fail("Not yet implemented");
		
	}

	@Test
	public void testKeyPressed() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyReleased() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeyTyped() {
		fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLevel() {
		//fail("Not yet implemented");
		Assert.assertThat(this.testGetLevel(), instanceOf(level.class));
	}

	//private Matcher instanceOf(Class<level> class1) {
		// TODO Auto-generated method stub
		//return null;
	//}
	@Test
	public void getPlayer() {
    	Assert.assertThat(this.model.getPlayer(), instanceOf(Player.class));
	}

}
