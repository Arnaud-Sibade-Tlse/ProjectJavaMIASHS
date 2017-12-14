package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {

	JaugeNaturel jauge;
	
	@Before
	public void setUp() throws Exception {
		jauge = new JaugeNaturel(10,20,15);
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
		String monToString = "<"+jauge.getValeur()+" ["+jauge.getMin()+"," + jauge.getMax() + "]>";
		assertTrue("Jauge toString",monToString.equals(jauge.toString()));
	}
	
	@Test
	public void testDansIntervalle(){
		assertTrue("est Vert",jauge.estVert());
		assertFalse("N'est pas Rouge",jauge.estRouge());
		assertFalse("N'est pas Bleu",jauge.estBleu());
	}
	
	@Test
	public void testDeplacement(){
		JaugeNaturel maJauge = null;
		try {
			maJauge = new JaugeNaturel(10,20,15);
		} catch (Exception e) {
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
		JaugeNaturel maJauge = null;
		try {
			maJauge = new JaugeNaturel(10,20,8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		
		try {
			maJauge = new JaugeNaturel(10,20,10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin(){
		JaugeNaturel maJauge = null;
		try {
			maJauge = new JaugeNaturel(20,10,10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Max : 10",maJauge.getMax() == 10);
		assertTrue("Min : 20",maJauge.getMin() == 20);
	}
	
	@Test
	public void testMaxEgaleMin(){
		JaugeNaturel maJauge = null;
		try {
			maJauge = new JaugeNaturel(10,10,10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("val = Min = Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
		
		try {
			maJauge = new JaugeNaturel(10,10,11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("val > Min == Max",maJauge.getValeur() > maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeNaturel maJauge = null;
		try {
			maJauge = new JaugeNaturel(10,20,22);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		
		try {
			maJauge = new JaugeNaturel(10,20,20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Min < Max = val",maJauge.getValeur() == maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
	}
}
