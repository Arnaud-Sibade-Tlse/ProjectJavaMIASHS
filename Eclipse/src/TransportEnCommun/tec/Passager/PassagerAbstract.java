package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Transport.Autobus;
import TransportEnCommun.tec.Transport.Bus;
import TransportEnCommun.tec.Transport.Transport;

public abstract class PassagerAbstract implements Passager {

	private String nom;
	private EtatPassager monEtat;
	private int destination;
	
	public PassagerAbstract(String nom, int d){
		this.nom=nom;
		this.destination=d;
		monEtat = new EtatPassager(IEtatPassager.Etat.DEHORS);
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if(t instanceof Autobus){
			Autobus monAutobus = (Autobus) t;
			choixPlaceMontee(monAutobus);
		}
	}

	public abstract void choixPlaceMontee(Bus bus) throws UsagerInvalideException;
	
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
		monEtat = new EtatPassager(IEtatPassager.Etat.DEHORS);
	}

	@Override
	public void accepterPlaceAssise() {
		monEtat = new EtatPassager(IEtatPassager.Etat.ASSIS);
	}

	@Override
	public void accepterPlaceDebout() {
		monEtat = new EtatPassager(IEtatPassager.Etat.DEBOUT);
	}


	@Override
	public void nouvelArret(Bus bus, int numeroArret){
		choixChangerPlace(bus,numeroArret);
	}

	public abstract void choixChangerPlace(Bus bus, int numeroArret);

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public String toString(){
		return this.nom +" "+this.monEtat;
	}


	public String getEtat() {
		return this.monEtat.toString();
	}

}
