package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeReelTest {

	JaugeReel jauge;
	 
	@Before
	public void setUp() throws Exception {
		jauge = new JaugeReel((float)10.5 , (float)20.5 , (float)15.5);
	}

	@After
	public void tearDown() throws Exception {
		jauge = null;
	}

	@Test
	public void testJaugeReel() {
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
		float currentVal = (float)jauge.getValeur();
		jauge.incrementer();
		assertTrue("Jauge incrementee",(float)jauge.getValeur() == (float)currentVal + (float)0.001 );
	}

	@Test
	public void testDecrementer() {
		float currentVal = (float)jauge.getValeur();
		jauge.decrementer();
		assertTrue("Jauge decrementee",(float)jauge.getValeur() == (float)currentVal - (float)0.001 );
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
		JaugeReel maJauge = new JaugeReel((float)10.5 , (float)20.5 , (float)8);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		
		maJauge = new JaugeReel((float)10.5 , (float)20.5 , (float)10.5);
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin(){
		JaugeReel maJauge = new JaugeReel((float)20 , (float)10 , (float)10);
		assertTrue("Max : 10/1000",maJauge.getMax() == 10);
		assertTrue("Min : 20/1000",maJauge.getMin() == 20);
	}
	
	@Test
	public void testMaxEgaleMin(){
		JaugeReel maJauge = new JaugeReel((float)10.5 , (float)10.5 , (float)10.5);
		assertTrue("val = Min = Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
		
		maJauge = new JaugeReel((float)10.5 , (float)10.5 , (float)11.5);
		assertTrue("val > Min == Max",maJauge.getValeur() > maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeReel maJauge = new JaugeReel((float)10.5 , (float)20.5 , (float)22.5);
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		
		maJauge = new JaugeReel((float)10.5 , (float)20.5 , (float)20.5);
		assertTrue("Min < Max = val",maJauge.getValeur() == maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
	}
}
