package TransportEnCommun.tec.Passager;

import static org.junit.Assert.*;

import org.junit.Test;

import TransportEnCommun.usageDeFaux.FauxBusAssis;
import TransportEnCommun.usageDeFaux.FauxBusDebout;
import TransportEnCommun.usageDeFaux.FauxBusPlein;
import TransportEnCommun.usageDeFaux.FauxBusVide;

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
	public void testMonterDansVide(){
		monP = creerPassager();
		FauxBusVide monBusVide = new FauxBusVide();
		try {
			monP.monterDans(monBusVide);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		System.out.println(monP.getEtat());
		assertTrue("Assis",monP.estAssis());
	}
	
	@Test
	public void testMonterDansPlein(){
		monP = creerPassager();
		FauxBusPlein monBusPlein = new FauxBusPlein();
		try {
			monP.monterDans(monBusPlein);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue("Dehors",monP.estDehors());
		assertFalse("Pas assis",monP.estAssis());
		assertFalse("Pas debout",monP.estDebout());
	}
	
	@Test
	public void testMonterAssis(){
		monP = creerPassager();
		FauxBusAssis monBusAssis = new FauxBusAssis();
		try {
			monP.monterDans(monBusAssis);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue("Assis",monP.estAssis());
		assertFalse("Pas dehors",monP.estDehors());
		assertFalse("Pas debout",monP.estDebout());
	}
	
	@Test
	public void testMonterDebout(){
		monP = creerPassager();
		FauxBusDebout monBusDebout = new FauxBusDebout();
		try {
			monP.monterDans(monBusDebout);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertFalse("Pas assis",monP.estAssis());
		assertFalse("Pas dehors",monP.estDehors());
		assertTrue("Debout",monP.estDebout());
	}
	
	
	@Test
	public void testToString(){
		monP = creerPassager();
		assertEquals("Test",monP.nom());
	}
}
