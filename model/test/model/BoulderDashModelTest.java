package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import static org
public class BoulderDashModelTest {

	private BoulderDashModel BoulderDashModel;
	
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
	public void testBoulderDashModel() {
		//fail("Not yet implemented");
		
	}

	@Test
	public void testMoveUp() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testMoveDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowGameStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiamondsFound() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRockfordPosition() {
		//fail("Not yet implemented");
		Assert.assertThat(this.BoulderDashModel.getRockfordPosition(0),instanceOf(BoulderDashModel.Class));
	}

	@Test
	public void testOpenDoor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLevelCompleted() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetGameOver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiamonds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSteps() {
		fail("Not yet implemented");
	}

	@Test
	public void testTick() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCaveArray() {
		fail("Not yet implemented");
	}

}
