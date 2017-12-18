package TransportEnCommun.tec.Passager;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerStandardTest {

	PassagerStandard monP;
	
	public PassagerStandard creerPassager(){
		return new PassagerStandard("Test",3);
	}

	@Test
	public void testDehors(){
		monP = creerPassager();
		assertTrue("Dehors",monP.estDehors());
		assertFalse("pas Assis",monP.estAssis());
		assertFalse("pas Debout",monP.estDebout());
	}
	
	@Test
	public void testAssis(){
		monP = creerPassager();
		monP.accepterPlaceAssise();
		assertTrue("Assis",monP.estAssis());
		assertFalse("pas Dehors",monP.estDehors());
		assertFalse("pas Debout",monP.estDebout());
	}
	
	@Test
	public void testDebout(){
		monP = creerPassager();
		monP.accepterPlaceDebout();
		assertTrue("Debout",monP.estDebout());
		assertFalse("pas Assis",monP.estAssis());
		assertFalse("pas Dehors",monP.estDehors());
	}
	
	
	
	
	@Test
	public void testToString(){
		monP = creerPassager();
		assertEquals("Test",monP.nom());
	}
}
