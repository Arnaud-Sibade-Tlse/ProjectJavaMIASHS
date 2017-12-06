package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

public class IEtatPassagerTest {

	@Test
	public void testNew(){
		IEtatPassager monPassager = new EtatPassagerChaine("not correct string");
		assertTrue("Default : est dehors",monPassager.estExterieur());
		monPassager = new EtatPassagerChaine("assis");
		assertTrue("Assis",monPassager.estAssis());
		monPassager = new EtatPassagerChaine("debout");
		assertTrue("Debout",monPassager.estDebout());
		monPassager = new EtatPassagerChaine("dehors");
		assertTrue("Exterieur",monPassager.estExterieur());

		monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Assis",monPassager.estAssis());
		monPassager = new EtatPassager(IEtatPassager.Etat.DEBOUT);
		assertTrue("Debout",monPassager.estDebout());
		monPassager = new EtatPassager(IEtatPassager.Etat.DEHORS);
		assertTrue("Exterieur",monPassager.estExterieur());
	}
	
	@Test
	public void testEstAssis() {
		IEtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Assis",monPassager.estAssis());
		assertFalse("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());

		monPassager = new EtatPassagerChaine("assis");
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
		

		monPassager = new EtatPassagerChaine("debout");
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
		

		monPassager = new EtatPassagerChaine("dehors");
		assertFalse("Est Assis",monPassager.estAssis());
		assertTrue("N'est pas Exterieur",monPassager.estExterieur());
		assertFalse("N'est pas Debout",monPassager.estDebout());
	}

	@Test
	public void testEstInterieur() {
		IEtatPassager monPassager = new EtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Est Interieur",monPassager.estInterieur());
		monPassager = new EtatPassagerChaine("assis");
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(IEtatPassager.Etat.DEBOUT);
		assertTrue("Est Interieur",monPassager.estInterieur());
		monPassager = new EtatPassagerChaine("debout");
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassager(IEtatPassager.Etat.DEHORS);
		assertFalse("N'est pas Interieur",monPassager.estInterieur());
		monPassager = new EtatPassagerChaine("edhors");
		assertFalse("Est Interieur",monPassager.estInterieur());
	}

}
