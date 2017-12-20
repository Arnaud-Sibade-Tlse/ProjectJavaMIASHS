package TransportEnCommun.tec.Passager;

import static org.junit.Assert.*;

import org.junit.Test;

import TransportEnCommun.tec.Transport.Autobus;
import TransportEnCommun.usageDeFaux.FauxBusAssis;
import TransportEnCommun.usageDeFaux.FauxBusDebout;
import TransportEnCommun.usageDeFaux.FauxBusPlein;
import TransportEnCommun.usageDeFaux.FauxBusVide;

public class PassagerLunatiqueTest extends PassagerAbstractTest {

	PassagerLunatique monP;
	
	public PassagerLunatique creerPassager(){
		return new PassagerLunatique("Test",4);
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
		assertFalse("Pas assis",monP.estAssis());
		assertFalse("Pas dehors",monP.estDehors());
		assertTrue("Debout",monP.estDebout());
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
		assertFalse("Pas assis",monP.estAssis());
		assertFalse("Pas dehors",monP.estDehors());
		assertTrue("Debout",monP.estDebout());
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
	public void testNouvelArret(){
		monP = creerPassager();
		Autobus monBus= new Autobus(2,2);
		
		int currentStatus = 1; // 1 = Debout ; 0 = Assis
		
		try {
			monP.monterDans(monBus);
			currentStatus = 1;
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		
		int arretSortis = 0;

		for(int i=1;i<5;i++){
			if(currentStatus == 1){
				assertTrue("Debout",monP.estDebout());
				currentStatus = 0;
			}
			else{
				assertTrue("Assis",monP.estAssis());
				currentStatus = 1;
			}
			monBus.allerArretSuivant();
			if(monP.estDehors()){
				arretSortis = i;
				break;
			}
		}
		assertEquals(3,arretSortis);
	}
	
	
}
