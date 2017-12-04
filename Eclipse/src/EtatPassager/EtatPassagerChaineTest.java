package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassagerChaine.Etat;

public class EtatPassagerChaineTest {


	@Test
	public void testEstAssis() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.ASSIS);
		assertEquals("<assis>",monPassager.toString());
	}

	@Test
	public void testEstDebout() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.DEBOUT);
		assertEquals("<debout>",monPassager.toString());
	}
	
	@Test
	public void testEstExterieur() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine(Etat.DEHORS);
		assertEquals("<dehors>",monPassager.toString());
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
