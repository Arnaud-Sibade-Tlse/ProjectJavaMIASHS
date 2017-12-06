package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IJaugeTest {

IJauge jaugeN;
IJauge jaugeR;
IJauge jaugeNeg;
	
	@Before
	public void setUp() throws Exception {
		jaugeN = new JaugeNaturel(10,20,15);
		jaugeNeg = new JaugeNegatif(-20,-10,-12);
		jaugeR = new JaugeReel((float)10.5 , (float)20.5 , (float)15.5);
	}

	@After
	public void tearDown() throws Exception {
		jaugeN = null;
		jaugeNeg = null;
		jaugeR = null;
	}

	@Test
	public void testIJauge() {
		assertNotNull("Jauge bien cree",jaugeN);
		assertNotNull("Jauge bien cree",jaugeNeg);
		assertNotNull("Jauge bien cree",jaugeR);
	}

	@Test
	public void testEstRouge() {
		assertFalse("Jauge rouge",jaugeN.estRouge());
		assertFalse("Jauge rouge",jaugeR.estRouge());
		assertFalse("Jauge rouge",jaugeNeg.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("Jauge verte",jaugeN.estVert());
		assertTrue("Jauge verte",jaugeR.estVert());
		assertTrue("Jauge verte",jaugeNeg.estVert());
	}

	@Test
	public void testEstBleu() {
		assertFalse("Jauge bleu",jaugeN.estBleu());
		assertFalse("Jauge bleu",jaugeR.estBleu());
		assertFalse("Jauge bleu",jaugeNeg.estBleu());
	}

	@Test
	public void testIncrementer() {
		float currentVal = jaugeN.getValeur();
		jaugeN.incrementer();
		assertTrue("Jauge incrementee",jaugeN.getValeur() == currentVal + 1 );
		
		currentVal = jaugeR.getValeur();
		jaugeR.incrementer();
		assertTrue("Jauge incrementee",jaugeR.getValeur() == currentVal + 1 );
		
		currentVal = jaugeNeg.getValeur();
		jaugeNeg.incrementer();
		assertTrue("Jauge incrementee",jaugeNeg.getValeur() == currentVal + 1 );
	}

	@Test
	public void testDecrementer() {
		float currentVal = jaugeN.getValeur();
		jaugeN.decrementer();
		assertTrue("Jauge decrementee",jaugeN.getValeur() == currentVal - 1 );
		
		currentVal = jaugeR.getValeur();
		jaugeR.decrementer();
		assertTrue("Jauge decrementee",jaugeR.getValeur() == currentVal - 1 );
		
		currentVal = jaugeNeg.getValeur();
		jaugeNeg.decrementer();
		assertTrue("Jauge decrementee",jaugeNeg.getValeur() == currentVal - 1 );
	}

	@Test
	public void testToString() {
		String monToString = "<"+jaugeN.getValeur()+" ["+jaugeN.getMin()+"," + jaugeN.getMax() + "]>";
		assertTrue("Jauge toString",monToString.equals(jaugeN.toString()));
		
		monToString = "<"+jaugeR.getValeur()+" ["+jaugeR.getMin()+"," + jaugeR.getMax() + "]>";
		assertTrue("Jauge toString",monToString.equals(jaugeR.toString()));
		
		monToString = "<"+jaugeNeg.getValeur()+" ["+jaugeNeg.getMin()+"," + jaugeNeg.getMax() + "]>";
		assertTrue("Jauge toString",monToString.equals(jaugeNeg.toString()));
	}
	
	@Test
	public void testDansIntervalle(){
		assertTrue("est Vert",jaugeN.estVert());
		assertFalse("N'est pas Rouge",jaugeN.estRouge());
		assertFalse("N'est pas Bleu",jaugeN.estBleu());
		
		assertTrue("est Vert",jaugeR.estVert());
		assertFalse("N'est pas Rouge",jaugeR.estRouge());
		assertFalse("N'est pas Bleu",jaugeR.estBleu());
		
		assertTrue("est Vert",jaugeNeg.estVert());
		assertFalse("N'est pas Rouge",jaugeNeg.estRouge());
		assertFalse("N'est pas Bleu",jaugeNeg.estBleu());
	}
	
	@Test
	public void testDeplacement(){
		IJauge maJauge = new JaugeNaturel(10,20,15);
		
		maJauge.incrementer();
		assertTrue("est Vert",maJauge.estVert());
		assertFalse("N'est pas Rouge",maJauge.estRouge());
		assertFalse("N'est pas Bleu",maJauge.estBleu());
		
		maJauge.decrementer();
		assertTrue("est Vert",maJauge.estVert());
		assertFalse("N'est pas Rouge",maJauge.estRouge());
		assertFalse("N'est pas Bleu",maJauge.estBleu());
		
		maJauge = new JaugeReel(10,20,15);
		
		maJauge.incrementer();
		assertTrue("est Vert",maJauge.estVert());
		assertFalse("N'est pas Rouge",maJauge.estRouge());
		assertFalse("N'est pas Bleu",maJauge.estBleu());
		
		maJauge.decrementer();
		assertTrue("est Vert",maJauge.estVert());
		assertFalse("N'est pas Rouge",maJauge.estRouge());
		assertFalse("N'est pas Bleu",maJauge.estBleu());
		
		maJauge = new JaugeNegatif(-20,-10,-15);
		
		maJauge.incrementer();
		assertTrue("est Vert",maJauge.estVert());
		assertFalse("N'est pas Rouge",maJauge.estRouge());
		assertFalse("N'est pas Bleu",maJauge.estBleu());
		
		maJauge.decrementer();
		assertTrue("est Vert",maJauge.estVert());
		assertFalse("N'est pas Rouge",maJauge.estRouge());
		assertFalse("N'est pas Bleu",maJauge.estBleu());
	}
	
	@Test
	public void testInferieurIntervalle(){
		IJauge maJauge = new JaugeNaturel(10,20,8);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		maJauge = new JaugeNaturel(10,20,10);
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
	
		maJauge = new JaugeReel(10,20,8);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		maJauge = new JaugeReel(10,20,10);
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		
		maJauge = new JaugeNegatif(-20,-10,-22);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		maJauge = new JaugeNegatif(-20,-10,-20);
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
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
		
		maJauge = new JaugeNaturel(10,10,11);
		assertTrue("val > Min == Max",maJauge.getValeur() > maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeNaturel maJauge = new JaugeNaturel(10,20,22);
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		
		maJauge = new JaugeNaturel(10,20,20);
		assertTrue("Min < Max = val",maJauge.getValeur() == maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
	}
}
