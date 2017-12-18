package TransportEnCommun.tec.Transport;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import TransportEnCommun.tec.Passager.PassagerStandard;
import TransportEnCommun.tec.Passager.Usager;
import TransportEnCommun.tec.Passager.UsagerInvalideException;

public class AutobusTest {

	Autobus monBus;
	
	@Before
	public void setUp() throws Exception {
		monBus= new Autobus(1,2);
	}

	
	@After
	public void tearDown()  {
		monBus = null;
	}
	
	@Test
	public void testAPlaceAssise(){
		assertTrue("Place Assise",monBus.aPlaceAssise());
	}
	@Test
	public void testAPlaceDebout(){
		assertTrue("Place Debout",monBus.aPlaceDebout());
	}
	
	@Test
	public void testAjoutAssis() throws UsagerInvalideException{
	   float nbPassager= monBus.getAssis().getValeur();
	   Usager kaylee = new PassagerStandard("Kaylee", 5);
	   kaylee.monterDans(monBus);
	   assertTrue("Est monter", nbPassager+1 == monBus.getAssis().getValeur());
	}
	
	@Test
	public void testAjoutDebout() throws UsagerInvalideException{
		   float nbPassager= monBus.getDebout().getValeur();
		   Usager kaylee = new PassagerStandard("Kaylee", 5);
		   Usager kaylee2 = new PassagerStandard("Kaylee", 5);

		   kaylee.monterDans(monBus);
		   kaylee2.monterDans(monBus);

		   assertTrue("Est monter", nbPassager+1 == monBus.getDebout().getValeur());
		}
	
	@Test
	public void testSontDessendu() throws UsagerInvalideException{
			monBus.allerArretSuivant();
			monBus.allerArretSuivant();
			monBus.allerArretSuivant();
			monBus.allerArretSuivant();
			monBus.allerArretSuivant();

		   assertTrue("Sont dessendu", 0 == monBus.getDebout().getValeur() && 0 == monBus.getAssis().getValeur());
		}
	
	
}
