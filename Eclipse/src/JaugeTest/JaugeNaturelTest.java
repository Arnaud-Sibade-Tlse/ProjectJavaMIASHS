package JaugeTest;
//import org.junit.Before;
import junit.framework.* ;

public class JaugeNaturelTest extends TestCase {

	public TestResult run() {
	     System.out.print("Test de JaugeNaturel:");

	     System.out.print(".");
	     testDansIntervalle();

	      System.out.print(".");
	      testInferieurIntervalle();

	     System.out.println("OK");
		return null;
	  }
	


	public void testDansIntervalle(){
		
		try {
			testVert();
		} catch (Exception e) {
			System.out.println("testVert à return true .... erreur");
		}
	}
	
	public void testVert() throws Exception {
		JaugeNaturel maJauge = new JaugeNaturel(100,200,300);
		assertTrue("le test jauge vert echoue ", maJauge.estVert());
	}

	public void testInferieurIntervalle() {
		// TODO Auto-generated method stub
		
	}
}
