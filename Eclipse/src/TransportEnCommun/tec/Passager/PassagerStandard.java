package TransportEnCommun.tec.Passager;

import TransportEnCommun.tec.Transport.Autobus;
import TransportEnCommun.tec.Transport.Bus;
import TransportEnCommun.tec.Transport.Transport;

public class PassagerStandard extends PassagerAbstract{
	
	public PassagerStandard(String nom, int d){
		super(nom,d);
	}
	
	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(this.getDestination()==bus.getArret()){
			bus.demanderSortie(this);
			this.accepterSortie();
		}
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if(t instanceof Autobus){
			Autobus monAutobus = (Autobus) t;
			if(monAutobus.aPlaceAssise()){
				monAutobus.demanderPlaceAssise(this);
			}
			else{
				monAutobus.demanderPlaceDebout(this);
			}
		}
	}
}
