package TransportEnCommun.tec;

public interface IJauge {	  
	  boolean estRouge();
	  boolean estVert();
	  boolean estBleu();
	  void incrementer();
	  void decrementer();
	  float getValeur();
	  float getMin();
	  float getMax();
}
