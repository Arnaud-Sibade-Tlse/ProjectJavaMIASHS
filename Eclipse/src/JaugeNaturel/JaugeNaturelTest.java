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
		assertTrue("Jauge rouge",jauge.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("Jauge verte",jauge.estVert());
	}

	@Test
	public void testEstBleu() {
		assertTrue("Jauge bleu",jauge.estBleu());
	}

	@Test
	public void testIncrementer() {
		long currentVal = jauge.getValeur();
		jauge.incrementer();
		assertTrue("Jauge incrementee",jauge.getValeur() == currentVal + 1 );
	}

	@Test
	public void testDecrementer() {
		long currentVal = jauge.getValeur();
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
		assertTrue("est pas Rouge",!jauge.estRouge());
		assertTrue("est pas Bleu",!jauge.estBleu());
	}
	
	@Test
	public void testDeplacement(){
		JaugeNaturel maJauge = new JaugeNaturel(10,20,15);
		
		maJauge.incrementer();
		assertTrue("est Vert",jauge.estVert());
		assertTrue("est pas Rouge",!jauge.estRouge());
		assertTrue("est pas Bleu",!jauge.estBleu());
		
		maJauge.decrementer();
		assertTrue("est Vert",jauge.estVert());
		assertTrue("est pas Rouge",!jauge.estRouge());
		assertTrue("est pas Bleu",!jauge.estBleu());
	}
	
	@Test
	public void testInferieurIntervalle(){
		JaugeNaturel maJauge = new JaugeNaturel(10,20,8);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		
		JaugeNaturel maJauge2 = new JaugeNaturel(10,20,10);
		assertTrue("val = Min < Max",maJauge2.getValeur() == maJauge2.getMin() && maJauge2.getMin() < maJauge2.getMax());
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin(){
		JaugeNaturel maJauge = new JaugeNaturel(20,10,10);
		assertTrue("Max : 10",maJauge.getMax() == 10);
		assertTrue("Min : 20",maJauge.getMin() == 20);
	}
	
	@Test
	public void testMaxEgaleMin(){
		JaugeNaturel maJauge = new JaugeNaturel(10,10,10);
		assertTrue("val = Min = Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
		
		JaugeNaturel maJauge2 = new JaugeNaturel(10,10,11);
		assertTrue("val > Min == Max",maJauge2.getValeur() > maJauge2.getMin() && maJauge2.getMin() == maJauge2.getMax());
	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeNaturel maJauge = new JaugeNaturel(10,20,22);
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		
		JaugeNaturel maJauge2 = new JaugeNaturel(10,20,20);
		assertTrue("Min < Max = val",maJauge2.getValeur() == maJauge2.getMax() && maJauge2.getMin() < maJauge2.getMax());
	}
}
