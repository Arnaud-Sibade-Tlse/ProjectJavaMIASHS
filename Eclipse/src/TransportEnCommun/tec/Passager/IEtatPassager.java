package TransportEnCommun.tec.Passager;

public interface IEtatPassager {

	  public enum Etat {/** passager assis à l'intérieur */  ASSIS, 
          /** passager debout à l'intérieur */ DEBOUT,  
          /** passager à l'extérieur */        DEHORS};
          
	boolean estExterieur();
	boolean estAssis();
	boolean estDebout();
	boolean estInterieur();

}
