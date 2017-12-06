package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

public class EtatPassagerChaineTest {

	@Test
	public void testNew(){
		IEtatPassager monPassager = new EtatPassagerChaine("not correct string");
		assertTrue("Default : est dehors",monPassager.estExterieur());
	}
	
	@Test
	public void testEstAssis() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine("assis");
		assertEquals("<assis>",monPassager.toString());
	}

	@Test
	public void testEstDebout() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine("debout");
		assertEquals("<debout>",monPassager.toString());
	}
	
	@Test
	public void testEstExterieur() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine("dehors");
		assertEquals("<dehors>",monPassager.toString());
	}

	@Test
	public void testEstInterieur() {
		EtatPassagerChaine monPassager = new EtatPassagerChaine("assis");
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassagerChaine("debout");
		assertTrue("Est Interieur",monPassager.estInterieur());
		
		monPassager = new EtatPassagerChaine("dehors");
		assertFalse("N'est pas Interieur",monPassager.estInterieur());
	}

}
