package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassagerMonter.Etat;

public class EtatPassagerMonterTest {


	@Test
	public void testEstAssis() {
		EtatPassagerMonter monPassager = new EtatPassagerMonter(Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstDebout() {
		EtatPassagerMonter monPassager = new EtatPassagerMonter(Etat.DEBOUT);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertTrue("Est Debout",monPassager.estDebout());
	}
	
	@Test
	public void testEstExterieur() {
		EtatPassagerMonter monPassager = new EtatPassagerMonter(Etat.DEHORS);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstInterieur() {
		EtatPassagerMonter monPassager = new EtatPassagerMonter(Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassagerMonter(Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassagerMonter(Etat.DEHORS);
		assertFalse("N'est pas Interieur",monPassager.estInterieur());
	}

}
