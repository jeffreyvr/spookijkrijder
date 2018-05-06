package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Spookrijder extends GameEngine {	
	public int banen[] = {75, 153, 233};
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.spookrijder.Spookrijder"});
	}
	
	@Override
    public void setupGame() {
		new Score(this).maakDashboard(960, 600);
		Wereld wereld = new Wereld(this);
		
		wereld.maakViewZonderViewport(960, 600);

		wereld.maakStatischeObjecten();
		wereld.maakInteractieveObjecten();
	}

	@Override
	public void update() {
		
	}

}