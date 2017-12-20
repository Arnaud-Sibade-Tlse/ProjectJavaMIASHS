package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Transport.Bus;

public class PassagerLunatique extends PassagerAbstract{

	public PassagerLunatique(String nom, int d) {
		super(nom, d);
	}

	@Override
	public void choixPlaceMontee(Bus bus) {
		if(bus.aPlaceDebout()){
			bus.demanderPlaceDebout(this);
		}
	}

	@Override
	public void choixChangerPlace(Bus bus, int numeroArret) {
		if(this.getDestination()==bus.getArret()){
			bus.demanderSortie(this);
			this.accepterSortie();
		}
		else{
			if(estAssis()){
				if(bus.aPlaceDebout()){
					bus.demanderChangerEnDebout(this);
				}
				else{
					try {
						throw new UsagerInvalideException("Usager Lunatique n'as pas pu se lever");
					} catch (UsagerInvalideException e) {
						e.printStackTrace();
					}
				}
			}
			else{
				if(bus.aPlaceAssise()){
					bus.demanderChangerEnAssis(this);
				}
				else{
					try {
						throw new UsagerInvalideException("Usager Lunatique n'as pas pu s'assoir");
					} catch (UsagerInvalideException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
