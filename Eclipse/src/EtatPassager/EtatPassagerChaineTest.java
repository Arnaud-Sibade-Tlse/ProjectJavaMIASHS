package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassagerChaine.Etat;

public class EtatPassagerChaineTest {


	@Test
	public void testEstAssis() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstDebout() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.DEBOUT);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertTrue("Est Debout",monPassager.estDebout());
	}
	
	@Test
	public void testEstExterieur() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.DEHORS);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertTrue("Est Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstInterieur() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassagerChaine(Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassagerChaine(Etat.DEHORS);
		assertFalse("N'est pas Interieur",monPassager.estInterieur());
	}

}
