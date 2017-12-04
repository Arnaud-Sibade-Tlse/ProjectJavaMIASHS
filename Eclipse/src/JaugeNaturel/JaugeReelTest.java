package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeReelTest {

	JaugeReel jauge;
	
	@Before
	public void setUp() throws Exception {
		JaugeNaturel jaugeN = new JaugeNaturel(10,20,15);
		jauge = new JaugeReel(jaugeN);
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
		assertTrue("est pas Rouge",!jauge.estRouge());
		assertTrue("est pas Bleu",!jauge.estBleu());
	}
	
	@Test
	public void testDeplacement(){
		JaugeNaturel jaugeN = new JaugeNaturel(10,20,15);
		JaugeReel maJauge = new JaugeReel(jaugeN);
		
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
		JaugeNaturel jaugeN = new JaugeNaturel(10,20,8);
		JaugeReel maJauge = new JaugeReel(jaugeN);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		
		jaugeN = new JaugeNaturel(10,20,10);
		maJauge = new JaugeReel(jaugeN);
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin(){
		JaugeNaturel jaugeN = new JaugeNaturel(20,10,10);
		JaugeReel maJauge = new JaugeReel(jaugeN);
		assertTrue("Max : 10/1000",maJauge.getMax() == 10);
		assertTrue("Min : 20/1000",maJauge.getMin() == 20);
	}
	
	@Test
	public void testMaxEgaleMin(){
		JaugeNaturel jaugeN = new JaugeNaturel(10,10,10);
		JaugeReel maJauge = new JaugeReel(jaugeN);
		assertTrue("val = Min = Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
		
		jaugeN = new JaugeNaturel(10,10,11);
		maJauge = new JaugeReel(jaugeN);
		assertTrue("val > Min == Max",maJauge.getValeur() > maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeNaturel jaugeN = new JaugeNaturel(10,20,22);
		JaugeReel maJauge = new JaugeReel(jaugeN);
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		
		jaugeN = new JaugeNaturel(10,20,20);
		maJauge = new JaugeReel(jaugeN);
		assertTrue("Min < Max = val",maJauge.getValeur() == maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
	}
}
