package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Transport.Bus;

public class PassagerStandard extends PassagerAbstract{
	
	public PassagerStandard(String nom, int d){
		super(nom,d);
	}
	
	@Override
	public void choixChangerPlace(Bus bus, int numeroArret) {
		if(this.getDestination()==bus.getArret()){
			bus.demanderSortie(this);
			this.accepterSortie();
		}
	}
	
	@Override 
	public void choixPlaceMontee(Bus bus){
		if(bus.aPlaceAssise()){
			bus.demanderPlaceAssise(this);
		}
		else{
			bus.demanderPlaceDebout(this);
		}
	}
}
