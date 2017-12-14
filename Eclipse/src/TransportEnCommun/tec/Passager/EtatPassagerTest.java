package TransportEnCommun.tec.Passager;

import static org.junit.Assert.*;

import org.junit.Test;


public class EtatPassagerTest {


	@Test
	public void testEstAssis() {
		EtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstDebout() {
		EtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.DEBOUT);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertTrue("Est Debout",monPassager.estDebout());
	}
	
	@Test
	public void testEstExterieur() {
		EtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.DEHORS);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertTrue("Est Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstInterieur() {
		EtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(IEtatPassager.Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(IEtatPassager.Etat.DEHORS);
		assertFalse("N'est pas Interieur",monPassager.estInterieur());
	}

}
