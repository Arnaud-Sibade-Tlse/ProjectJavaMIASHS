package TransportEnCommun.tec.Passager;

import static org.junit.Assert.*;

import org.junit.Test;

import TransportEnCommun.tec.Transport.Autobus;
import TransportEnCommun.usageDeFaux.FauxBusAssis;
import TransportEnCommun.usageDeFaux.FauxBusDebout;
import TransportEnCommun.usageDeFaux.FauxBusPlein;
import TransportEnCommun.usageDeFaux.FauxBusVide;

public class PassagerStresseTest extends PassagerAbstractTest {

	PassagerStresse monP;
	
	public PassagerStresse creerPassager(){
		return new PassagerStresse("Test",4);
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
		PassagerStresse random1 = new PassagerStresse("random1",2);
		PassagerStresse random2 = new PassagerStresse("random2",2);
		PassagerStresse random3 = new PassagerStresse("random3",2);
		PassagerStresse random4 = new PassagerStresse("random4",2);

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
		PassagerStresse random1 = new PassagerStresse("random1",2);
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
		PassagerStresse random1 = new PassagerStresse("random1",2);
		PassagerStresse random2 = new PassagerStresse("random2",2);
		try {
			random1.monterDans(monBusDebout);
			random2.monterDans(monBusDebout);
			monP.monterDans(monBusDebout);
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		assertFalse("Pas assis",monP.estAssis());
		assertTrue("Dehors",monP.estDehors());
		assertFalse("Pas Debout",monP.estDebout());
	}
	
	@Test
	public void testNouvelArret(){
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
		assertEquals(4,arretSortis);
	}
	
	
}
