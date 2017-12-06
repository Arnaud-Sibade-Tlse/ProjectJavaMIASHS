package JaugeNaturel;

public interface IJauge {

	  long valeur;
	  final long min;
	  final long max;

	  /**
	   * Construit une instance en précisant la valeur de départ de la Jauge
	   * et l'intervalle de vigie.
	   *
	   * @param vigieMin valeur minimale de l'intervalle de vigie.
	   * @param vigieMax valeur maximale de l'intervalle de vigie.
	   * @param depart   valeur initiale de la jauge.
	   */
	  


	  /**
	   * L'état de la jauge est-il rouge ?
	   *
	   * @return vrai si niveau >=  vigieMax.
	   *
	   */
	  public default boolean estRouge() {
	    return valeur >= max;
	  }

	  /**
	   * L'état de la jauge est-il vert ?
	   *
	   * @return vrai si niveau appartient à ]vigieMin, vigieMax[.
	   *
	   */
	  public default boolean estVert() {
	    //return !(estBleu() && estRouge());
	    return valeur > min && valeur < max;
	  }

	  /**
	   * L'état de la jauge est-il bleu ?
	   *
	   * @return vrai si niveau <= vigieMin.
	   */
	  public default boolean estBleu() {
	    return valeur <= min;
	  }

	  /**
	   * Incrémente le niveau d'une unité.
	   * L'état peut devenir supérieur à vigieMax.
	   */
	  public default void incrementer() {
	    
	  }

	  /**
	   * Décrémente le niveau d'une unité.
	   * L'état peut devenir inférieur à la vigieMin.
	   */
	  public default void decrementer() {
		  
	  }




	  public default long getValeur(){return this.valeur;}
	  public default long getMin(){return this.min;}
	  public default long getMax(){return this.max;}
	  
	

}
