package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Spookrijder extends GameEngine {	
	public int banen[] = {75, 153, 233};
	public Speler speler;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.spookrijder.Spookrijder"});
	}
	
	public Spookrijder() {
		this.speler = new Speler(this);
	}
	
	@Override
    public void setupGame() {
		new Score(this).maakDashboard(960, 600, (int) this.speler.getStatus());
		
		Wereld wereld = new Wereld(this);
		
		wereld.maakViewZonderViewport(960, 600);

		wereld.maakStatischeObjecten();
		wereld.maakInteractieveObjecten();
	}

	@Override
	public void update() {
		
	}

}