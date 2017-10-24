package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassager.Etat;

public class EtatPassagerTest {


	@Test
	public void testEstAssis() {
		EtatPassager monPassager = new EtatPassager(Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertTrue("N'est pas Exterieur",!monPassager.estExterieur());
		assertTrue("N'est pas Debout",!monPassager.estDebout());
	}

	@Test
	public void testEstDebout() {
		EtatPassager monPassager = new EtatPassager(Etat.DEBOUT);
		assertTrue("N'est pas Assis",!monPassager.estAssis());
		assertTrue("N'est pas Exterieur",!monPassager.estExterieur());
		assertTrue("Est Debout",monPassager.estDebout());
	}
	
	@Test
	public void testEstExterieur() {
		EtatPassager monPassager = new EtatPassager(Etat.DEHORS);
		assertTrue("N'est pas Assis",!monPassager.estAssis());
		assertTrue("Est Exterieur",monPassager.estExterieur());
		assertTrue("N'est pas Debout",!monPassager.estDebout());
	}

	@Test
	public void testEstInterieur() {
		EtatPassager monPassager = new EtatPassager(Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(Etat.DEHORS);
		assertTrue("N'est pas Interieur",!monPassager.estInterieur());
	}

}
