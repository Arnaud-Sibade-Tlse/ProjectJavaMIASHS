package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Passager.IEtatPassager.Etat;
import TransportEnCommun.tec.Transport.Bus;
import TransportEnCommun.tec.Transport.Transport;

public class PassagerStandard implements Passager{
	
	private String nom;
	private EtatPassager monEtat;
	
	public PassagerStandard(String nom){
		this.nom=nom;
	}
	
	public void EtatPassager(EtatPassager assis) {
		monEtat = assis;
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
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

}
