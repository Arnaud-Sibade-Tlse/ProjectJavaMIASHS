package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

public class IEtatPassagerTest {
	
	IEtatPassager etatPassager;
	
	public IEtatPassager creerAssis(){
		//return new EtatPassager(IEtatPassager.Etat.DEBOUT);
		return new EtatPassagerChaine("assis");
	}
	
	public IEtatPassager creerDebout(){
		//return new EtatPassager(IEtatPassager.Etat.DEBOUT);
		return new EtatPassagerChaine("debout");
	}
	
	public IEtatPassager creerDehors(){
		//return new EtatPassager(IEtatPassager.Etat.DEHORS);
		return new EtatPassagerChaine("dehors");
	}
	
	@Test
	public void testAssis(){
		
		etatPassager = creerAssis();
		assertTrue("Assis",etatPassager.estAssis());
	}
	
	@Test
	public void testDebout(){
		
		etatPassager = creerDebout();
		assertTrue("Debout",etatPassager.estDebout());
	}
	
	@Test
	public void testDehors(){
		
		etatPassager = creerDehors();
		assertTrue("Dehors",etatPassager.estExterieur());
	}
	
	@Test
	public void testEstAssis() {
		etatPassager = creerAssis();
		assertTrue("Est Assis",etatPassager.estAssis());
		assertFalse("N'est pas Exterieur",etatPassager.estExterieur());
		assertFalse("N'est pas Debout",etatPassager.estDebout());
	}

	@Test
	public void testEstDebout() {
		etatPassager = creerDebout();
		assertFalse("N'est pas Assis",etatPassager.estAssis());
		assertFalse("N'est pas Exterieur",etatPassager.estExterieur());
		assertTrue("Est Debout",etatPassager.estDebout());
	}
	
	@Test
	public void testEstExterieur() {
		etatPassager = creerDehors();
		assertFalse("N'est pas Assis",etatPassager.estAssis());
		assertTrue("Est Exterieur",etatPassager.estExterieur());
		assertFalse("N'est pas Debout",etatPassager.estDebout());
		
	}

	@Test
	public void testEstInterieur() {
		etatPassager = creerAssis();
		assertTrue("Est Interieur",etatPassager.estInterieur());

		etatPassager = creerDebout();
		assertTrue("Est Interieur",etatPassager.estInterieur());
		
		etatPassager = creerDehors();
		assertFalse("N'est pas Interieur",etatPassager.estInterieur());
	}

}
