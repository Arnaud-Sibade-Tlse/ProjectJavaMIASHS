package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Transport.Bus;

public class PassagerStresse extends PassagerAbstract{

	public PassagerStresse(String nom, int d) {
		super(nom, d);
	}
	
	@Override
	public void choixPlaceMontee(Bus bus) {
		if(bus.aPlaceAssise() && bus.aPlaceDebout()){
			bus.demanderPlaceAssise(this);
		}
	}

	@Override
	public void choixChangerPlace(Bus bus, int numeroArret) {
		if(this.getDestination()==bus.getArret()){
			bus.demanderSortie(this);
			this.accepterSortie();
		}else{
			if(numeroArret >= this.getDestination()-3 && bus.aPlaceDebout() && this.estAssis()){
				bus.demanderChangerEnDebout(this);
			}else{
				if(!this.estDebout()){
					try {
						throw new UsagerInvalideException("Usager stresser n'as pas pu se lever 3 arret avant ca destination est a fait sauter le Bus");
					} catch (UsagerInvalideException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
