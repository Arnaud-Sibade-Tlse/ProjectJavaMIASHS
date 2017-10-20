package JaugeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {

	JaugeNaturel jauge;
	
	@Before
	public void setUp() throws Exception {
		jauge = new JaugeNaturel(10,20,30);
	}

	@After
	public void tearDown() throws Exception {
		jauge = null;
	}

	@Test
	public void testJaugeNaturel() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstRouge() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstVert() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstBleu() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecrementer() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
