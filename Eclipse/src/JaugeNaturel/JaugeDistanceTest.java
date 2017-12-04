package JaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeDistanceTest {

	JaugeDistance jauge;
	
	@Before
	public void setUp() throws Exception {
		jauge = new JaugeDistance(56,44);
	}

	@After
	public void tearDown() throws Exception {
		jauge = null;
	}

	@Test
	public void testJaugeDistance() {
		assertNotNull("Jauge bien cree",jauge);
	}

	@Test
	public void testEstRouge() {
		assertFalse("Jauge pas rouge",jauge.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("Jauge verte",jauge.estVert());
	}

	@Test
	public void testEstBleu() {
		assertFalse("Jauge pas bleu",jauge.estBleu());
	}

	@Test
	public void testIncrementer() {
		long currentVal = jauge.getToMin();
		jauge.incrementer();
		assertTrue("Jauge incrementee",jauge.getToMin() == currentVal + 1 );
	}

	@Test
	public void testDecrementer() {
		long currentVal = jauge.getToMin();
		jauge.decrementer();
		assertTrue("Jauge decrementee",jauge.getToMin() == currentVal - 1 );
	}

	@Test
	public void testToString() {
		String monToString = "<"+jauge.getToMin()+" [0," + (jauge.getToMin()+jauge.getToMax()) + "]>";
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
		JaugeDistance maJauge = new JaugeDistance(56,44);
		
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
		JaugeDistance maJauge = new JaugeDistance(-5,45);
		assertFalse("val < Min < Max",maJauge.getToMin() > 0);
		
		maJauge = new JaugeDistance(0,50);
		assertTrue("val = Min < Max",maJauge.getToMin() == 0 && maJauge.getToMin() < maJauge.getToMax());
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin(){
		JaugeDistance maJauge = new JaugeDistance(56,44);
		assertTrue("Max : 100",maJauge.getToMax() + maJauge.getToMin() == 100);
	}
	
	@Test
	public void testMaxEgaleMin(){
		JaugeDistance maJauge = new JaugeDistance(0,0);
		assertTrue("val = Min = Max",maJauge.getToMin() == 0 && maJauge.getToMin() == maJauge.getToMax() );
		
	}
	
	@Test
	public void testSuperieurIntervalle(){
		JaugeDistance maJauge = new JaugeDistance(105,-5);
		assertFalse("Min < Max < val",maJauge.getToMax() > 0);
		
		maJauge = new JaugeDistance(50,0);
		assertTrue("Min < Max = val",maJauge.getToMin() > maJauge.getToMax() && 0 == maJauge.getToMax());
	}
}
