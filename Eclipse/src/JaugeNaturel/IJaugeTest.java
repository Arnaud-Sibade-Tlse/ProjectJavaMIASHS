package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IJaugeTest {

IJauge jauge;

	

	
	public IJauge creerJauge(float a , float b, float c){
		try{
			return new JaugeReel(a,b,c);
		}catch(JaugeException e){
			
		}
		return null;
	}
	
	@Before
	public void setUp(){
		jauge = creerJauge(1,3,2);
	}
	
	@After
	public void tearDown()  {
		jauge = null;

	}

	private void testCreationNonValide ( ) {
		IJauge inverse = creerJauge ( 78 , 13 , 0 ) ;
		IJauge egale = creerJauge ( -45 , -45, -45);
	}
	
	@Test
	public void testIJauge() {
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
		assertTrue("Jauge decrementee",(float)jauge.getValeur() == currentVal - 1 );
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
	public void testDeplacement() {
		IJauge maJauge = creerJauge(10,20,15);
		
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
		IJauge maJauge = creerJauge(10,20,8);
		assertTrue("val < Min < Max",maJauge.getValeur() < maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
		maJauge = creerJauge(10,20,10);
		assertTrue("val = Min < Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() < maJauge.getMax());
	
		}
	
//	@Test
//	public void testLimiteVigieMaxInferieurVigieMin(){
//		IJauge maJauge = creerJauge(20,10,10);
//		assertTrue("Max : 10",maJauge.getMax() == 10);
//		assertTrue("Min : 20",maJauge.getMin() == 20);
//	}
	
	
//	@Test
//	public void testMaxEgaleMin(){
//		IJauge maJauge = creerJauge(10,10,10);
//		assertTrue("val = Min = Max",maJauge.getValeur() == maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
//		maJauge = creerJauge(10,10,11);
//		assertTrue("val > Min == Max",maJauge.getValeur() > maJauge.getMin() && maJauge.getMin() == maJauge.getMax());
//	}
	
	@Test
	public void testSuperieurIntervalle(){
		IJauge maJauge = creerJauge(10,20,22);
		assertTrue("Min < Max < val",maJauge.getValeur() > maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
		maJauge =creerJauge(10,20,20);
		assertTrue("Min < Max = val",maJauge.getValeur() == maJauge.getMax() && maJauge.getMin() < maJauge.getMax());
	}
}
