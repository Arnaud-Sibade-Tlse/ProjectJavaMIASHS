package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;


public class EtatPassagerTest2 {


	@Test
	public void testEstAssis() {
		IEtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());

		monPassager = new EtatPassagerChaine(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstDebout() {
		IEtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.DEBOUT);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertTrue("Est Debout",monPassager.estDebout());
		

		monPassager = new EtatPassagerChaine(IEtatPassager.Etat.DEBOUT);
		assertFalse("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertTrue("N'est pas Debout",monPassager.estDebout());
	}
	
	@Test
	public void testEstExterieur() {
		IEtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.DEHORS);
		assertFalse("N'est pas Assis",monPassager.estAssis());
		assertTrue("Est Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
		

		monPassager = new EtatPassagerChaine(IEtatPassager.Etat.DEHORS);
		assertFalse("Est Assis",monPassager.estAssis());
		assertTrue("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstInterieur() {
		IEtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		monPassager = new EtatPassagerChaine(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(IEtatPassager.Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		monPassager = new EtatPassagerChaine(IEtatPassager.Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(IEtatPassager.Etat.DEHORS);
		assertFalse("N'est pas Interieur",monPassager.estInterieur());
		monPassager = new EtatPassagerChaine(IEtatPassager.Etat.DEHORS);
		assertFalse("Est Interieur",monPassager.estInterieur());
	}

}
