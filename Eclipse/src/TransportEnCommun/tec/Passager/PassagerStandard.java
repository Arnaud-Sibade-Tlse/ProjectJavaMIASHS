package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Transport.Autobus;
import TransportEnCommun.tec.Transport.Bus;
import TransportEnCommun.tec.Transport.Transport;

public class PassagerStandard implements Passager{
	
	private String nom;
	private EtatPassager monEtat;
	private int destination;
	
	public PassagerStandard(String nom, int d){
		this.nom=nom;
		this.destination=d;
		this.monEtat=new EtatPassager(IEtatPassager.Etat.DEHORS);
	}
	
	public void EtatPassager(EtatPassager state) {
		monEtat = state;
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
		if(t instanceof Autobus){
			Autobus monAutobus = (Autobus) t;
			
			if(monAutobus.aPlaceAssise()){
				monAutobus.demanderPlaceAssise(this);
				this.monEtat=new EtatPassager(IEtatPassager.Etat.ASSIS);
			}
			else{
				monAutobus.demanderPlaceDebout(this);
				this.monEtat=new EtatPassager(IEtatPassager.Etat.DEBOUT);
			}
		}
	}

	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public boolean estDehors() {
		return monEtat.estExterieur();
	}

	@Override
	public boolean estAssis() {
		return monEtat.estAssis();
	}

	@Override
	public boolean estDebout() {
		return monEtat.estDebout();
	}

	@Override
	public void accepterSortie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterPlaceAssise() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterPlaceDebout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		// TODO Auto-generated method stub
		
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public String toString(){
		return this.nom +" "+this.monEtat;
	}
}
