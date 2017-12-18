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
	public void testPasPlaceAssise() throws UsagerInvalideException{
		   Usager kaylee = new PassagerStandard("Kaylee", 5);
		   Usager kaylee2 = new PassagerStandard("Kaylee", 5);

		   kaylee.monterDans(monBus);
		   kaylee2.monterDans(monBus);
		assertFalse("Place Assise",monBus.aPlaceAssise());
	}
	@Test
	public void testAPlaceDebout(){
		assertTrue("Place Debout",monBus.aPlaceDebout());
	}
	
	@Test
	public void testPasPlaceDebout() throws UsagerInvalideException{
		   Usager kaylee = new PassagerStandard("Kaylee", 5);
		   Usager kaylee2 = new PassagerStandard("Kaylee2", 5);
		   Usager kaylee3 = new PassagerStandard("Kaylee3", 5);

		   kaylee.monterDans(monBus);
		   kaylee2.monterDans(monBus);
		   kaylee3.monterDans(monBus);

		assertFalse("Place Debout",monBus.aPlaceDebout());
	}
	
	@Test
	public void testPasPlaceDeboutDoncDehors() throws UsagerInvalideException{
		   Usager kaylee = new PassagerStandard("Kaylee", 5);
		   Usager kaylee2 = new PassagerStandard("Kaylee2", 5);
		   Usager kaylee3 = new PassagerStandard("Kaylee3", 5);
		   Usager kaylee4 = new PassagerStandard("Kaylee3", 5);

		   kaylee.monterDans(monBus);
		   kaylee2.monterDans(monBus);
		   kaylee3.monterDans(monBus);
		   kaylee4.monterDans(monBus);


		assertFalse("Kaylee4 reste dehors",((PassagerStandard)kaylee4).estDehors()==true);
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
	
	@Test
	public void descentauBonArret() throws UsagerInvalideException{
			int arretDescente = monBus.getArret()+3;
		   Usager kaylee = new PassagerStandard("Kaylee", arretDescente);
		   kaylee.monterDans(monBus);
		   for(int i = monBus.getArret() ; i<arretDescente+5 ; i++){
			   monBus.allerArretSuivant();
			   if(((PassagerStandard)kaylee).getDestination()==i){
				   break;
			   }
		   }
		   assertTrue("kaylee est descendu au bon moment ", true==((PassagerStandard)kaylee).estDehors());
	}
	

	
}
