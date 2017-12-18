package TransportEnCommun.tec.Passager;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PassagerStandardTest {

	PassagerStandard monP;
	
	public PassagerStandard creerPassager(){
		return new PassagerStandard("Test",3);
	}

	@Test
	public void testAssis(){
		monP = creerPassager();
		monP.setEtatPassager(IEtatPassager.Etat.ASSIS);
		assertTrue("Assis",monP.estAssis());
	}
}
