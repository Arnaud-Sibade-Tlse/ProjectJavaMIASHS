package TransportEnCommun.tec.Passager;

import static org.junit.Assert.*;

import org.junit.Test;

import TransportEnCommun.tec.Transport.Autobus;
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
		monP.accepterSortie();
		assertTrue("Dehors",monP.estDehors());
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
		Autobus monBusVide = new Autobus(2,2);
		try {
			monP.monterDans(monBusVide);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertTrue("Assis",monP.estAssis());
		assertFalse("Pas dehors",monP.estDehors());
		assertFalse("Pas debout",monP.estDebout());
	}
	
	@Test
	public void testMonterDansPlein(){
		monP = creerPassager();
		PassagerStandard random1 = new PassagerStandard("random1",2);
		PassagerStandard random2 = new PassagerStandard("random2",2);
		PassagerStandard random3 = new PassagerStandard("random3",2);
		PassagerStandard random4 = new PassagerStandard("random4",2);

		Autobus monBusPlein = new Autobus(2,2);
		
		try {
			random1.monterDans(monBusPlein);
			random2.monterDans(monBusPlein);
			random3.monterDans(monBusPlein);
			random4.monterDans(monBusPlein);
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
		Autobus monBusAssis = new Autobus(2,2);
		PassagerStandard random1 = new PassagerStandard("random1",2);
		try {
			random1.monterDans(monBusAssis);
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
		Autobus monBusDebout = new Autobus(2,2);
		PassagerStandard random1 = new PassagerStandard("random1",2);
		PassagerStandard random2 = new PassagerStandard("random2",2);
		try {
			random1.monterDans(monBusDebout);
			random2.monterDans(monBusDebout);
			monP.monterDans(monBusDebout);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertFalse("Pas assis",monP.estAssis());
		assertFalse("Pas dehors",monP.estDehors());
		assertTrue("Debout",monP.estDebout());
	}
	
	@Test
	public void testNouvelArrêt(){
		monP = creerPassager();
		Autobus monBus= new Autobus(2,2);
		try {
			monP.monterDans(monBus);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		
		int arretSortis = 0;
		for(int i=1;i<5;i++){
			monBus.allerArretSuivant();
			monP.nouvelArret(monBus,i);
			if(monP.estDehors()){
				arretSortis = i;
				break;
			}
		}
		assertEquals(3,arretSortis);
	}
	
	
	@Test
	public void testDestination(){
		monP = creerPassager();
		assertEquals(3,monP.getDestination());
		
		monP.setDestination(2);
		assertEquals(2,monP.getDestination());
	}
	
	@Test
	public void testToString(){
		monP = creerPassager();
		assertEquals("Test",monP.nom());
	}
}
