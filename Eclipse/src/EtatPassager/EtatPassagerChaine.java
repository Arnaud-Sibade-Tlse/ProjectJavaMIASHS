package EtatPassager;
/**
 * Cette classe représente l'état d'un passager dans un transport.
 * Il y a un état à l'exterieur du transport (dehors) et deux états à 
 * l'intérieur (assis, debout).
 *  
 * Les instances de cette classe sont des objets constants.
 **/
public class EtatPassagerChaine implements IEtatPassager {
	
  private final String monEtat;

  /**
   * Construit une instance en précisant l'état du passager.
   * 
   * @param etat  valeur de l'état.
   */
  public EtatPassagerChaine(String etat) {
	  if(etat.equals("dehors")||etat.equals("assis")||etat.equals("debout")){
		    monEtat = etat;
	  }
	  else{
		  monEtat = "dehors";
	  }

    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * Le passager est-il à l'extérieur du transport ?
   *
   * @return vrai si instanciation avec DEHORS;
   */
  public boolean estExterieur() {
    return monEtat.equals("dehors");
  }

  /**
   * Le passager est-il assis à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
	    return monEtat.equals("assis");
  }

  /**
   * Le passager est-il debout à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
	    return monEtat.equals("debout");
  }

  /**
   * Le passager est-il a l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
	  boolean interieur = false;
	  switch (this.monEtat)
	  {
	    case "assis":
	    	interieur = true;
	      break;   
	    case "debout":
	    	interieur = true;
	      break;  
	    case "dehors":
	    	interieur = false;
	      break;           
	  }
	  return interieur;
  }



  /**
   * Cette méthode est heritée de la classe {@link java.lang.Object}.
   * Trés utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * <p> Un code par défaut est définit dans 
   * {@link java.lang.Object#toString() la classe Object} 
   * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
   *
   * Pour les chaînes de cararctéres, l'opérateur + correspond a la concaténation. 
   */
  @Override
  public String toString() {
    return "<" + monEtat + ">";
  }
}