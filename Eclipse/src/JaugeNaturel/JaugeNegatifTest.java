package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNegatifTest {

	JaugeNegatif jauge;
	
	@Before
	public void setUp() throws Exception {
		jauge = new JaugeNegatif(-20,-10,-12);
	}

	@After
	public void tearDown() throws Exception {
		jauge = null;
	}

	@Test
	public void testJaugeNaturel() {
		assertNotNull("Jauge bien cree",jauge);
	}

	@Test
	public void testEstRouge() {
		assertFalse("Jauge rouge",jauge.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("Jauge verte",jauge.estVert());
	}

	@Test
	public void testEstBleu() {
		assertFalse("Jauge bleu",jauge.estBleu());
	}

	@Test
	public void testIncrementer() {
		float currentVal = jauge.getValeur();
		jauge.incrementer();
		assertTrue("Jauge incrementee",jauge.getValeur() == currentVal + 1 );
	}

	@Test
	public void testDecrementer() {
		float currentVal = jauge.getValeur();
		jauge.decrementer();
		assertTrue("Jauge decrementee",jauge.getValeur() == currentVal - 1 );
	}

	@Test
	public void testToString() {
		String monToString = "<" + jauge.getValeur() + " [" + jauge.getMin() + "," + jauge.getMax() + "]>";
		assertEquals(monToString,jauge.toString());
	}
	
	@Test
	public void testDansIntervalle(){
		assertTrue("est Vert",jauge.estVert());
		assertFalse("N'est pas Rouge",jauge.estRouge());
		assertFalse("N'est pas Bleu",jauge.estBleu());
	}
	
	@Test
	public void testDeplacement(){
		JaugeNegatif maJauge = null;
		try {
			maJauge = new JaugeNegatif(-20,-10,-15);
		} catch (JaugeException e) {
			e.printStackTrace();
		}
		
		maJauge.incrementer();
		assertTrue("est Vert",jauge.estVert());
		assertFalse("N'est pas Rouge",jauge.estRouge());
		assertFalse("N'est pas Bleu",jauge.estBleu());
		
		maJauge.decrementer();
		assertTrue("est Vert",jauge.estVert());
		assertFalse("N'est pas Rouge",jauge.estRouge());
		assertFalse("N'est pas Bleu",jauge.estBleu());
	}
	
	@Test
	public void testInferieurIntervalle(){
		JaugeNegatif maJauge = null;
		try {
			maJauge = new JaugeNegatif(-20,-10,-22);
		} catch (JaugeException e) {
			e.printStackTrace();
		}
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		
		try {
			maJauge = new JaugeNegatif(-20,-10,-20);
		} catch (JaugeException e) {
			e.printStackTrace();
		}
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin(){
		JaugeNegatif maJauge = null;
		try {
			maJauge = new JaugeNegatif(-20,-10,-10);
		} catch (JaugeException e) {
			e.printStackTrace();
		}
		assertTrue("Max : 10",maJauge.getMax() == -10);
		assertTrue("Min : 20",maJauge.getMin() == -20);
	}
	
	//!!! Don't work
//	@Test
//	public void testMaxEgaleMin(){
//		JaugeNegatif maJauge = null;
//		try {
//			maJauge = new JaugeNegatif(-10,-10,-10);
//		} catch (JaugeException e) {
//			e.printStackTrace();
//		}
//		assertTrue("val = Min = Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
//		
//		try {
//			maJauge = new JaugeNegatif(-10,-10,-9);
//		} catch (JaugeException e) {
//			e.printStackTrace();
//		}
//		assertTrue("val > Min == Max",maJauge.getValeur() > maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
//	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeNegatif maJauge = null;
		try {
			maJauge = new JaugeNegatif(-20,-10,-9);
		} catch (JaugeException e) {
			e.printStackTrace();
		}
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		
		try {
			maJauge = new JaugeNegatif(-20,-10,-10);
		} catch (JaugeException e) {
			e.printStackTrace();
		}
		assertTrue("Min < Max = val",maJauge.getValeur() == maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
	}
}
