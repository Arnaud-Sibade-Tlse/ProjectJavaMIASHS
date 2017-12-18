package TransportEnCommun.tec.Transport;

import java.util.ArrayList;

import TransportEnCommun.tec.Passager.Passager;
import TransportEnCommun.tec.Passager.PassagerStandard;
import TransportEnCommun.tec.Passager.UsagerInvalideException;

public class Autobus implements Bus{
	
	private JaugeNaturel assis;
	private JaugeNaturel debout;
	private int arret;
	private ArrayList<PassagerStandard> mesPassagers;

	
	public Autobus(int assis, int debout){
		this.assis = new JaugeNaturel(0,assis,0);
		this.debout = new JaugeNaturel(0,debout,0);
		mesPassagers = new ArrayList<PassagerStandard>();
		this.arret=0;
	}
	@Override
	public boolean aPlaceAssise() {
		if(assis.estVert() || assis.estBleu()){
			return true;
		}
		return false;
	}

	@Override
	public boolean aPlaceDebout() {
		if(debout.estVert() || debout.estBleu()){
			return true;
		}
		return false;
	}

	@Override
	public void demanderPlaceAssise(Passager p) {
		if(aPlaceAssise()){
			p.accepterPlaceAssise();
			mesPassagers.add((PassagerStandard)p);
			assis.incrementer();
		}
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if(aPlaceDebout()){
			p.accepterPlaceDebout();
			mesPassagers.add((PassagerStandard)p);

			debout.incrementer();
		}
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		if(aPlaceDebout() && p.estAssis()){
			p.accepterPlaceDebout();
			assis.decrementer();
			debout.incrementer();
		}			
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if(aPlaceAssise() && p.estDebout()){
			p.accepterPlaceAssise();
			debout.decrementer();
			assis.incrementer();
		}		
	}

	@Override
	public void demanderSortie(Passager p) {
		if(p.estAssis()){
			assis.decrementer();
		} else {
			debout.decrementer();
			
		}
		p.accepterSortie();
	}

	public JaugeNaturel getAssis() {
		return assis;
	}

	public JaugeNaturel getDebout() {
		return debout;
	}

	public String toString(){
		String monBus ="[arret:";
		monBus += arret;
		monBus+=", assis:"+(int)this.assis.getValeur()+", debout:"+(int)this.debout.getValeur()+"]";
		return monBus;
	}
	public int getArret() {
		return arret;
	}
	
	@Override
	public void allerArretSuivant() {
		this.arret ++;
		for(int i=0;i<mesPassagers.size();i++){
			mesPassagers.get(i).nouvelArret(this, arret);

		}
	}

}
