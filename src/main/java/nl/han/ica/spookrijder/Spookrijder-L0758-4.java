package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Spookrijder extends GameEngine {
	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.spookrijder.Spookrijder"});
	}
	
	@Override
    public void setupGame() {
		new Score(this).createDashboard(1280, 400);
		Wereld wereld = new Wereld(this);
		
		wereld.createViewWithoutViewport(1280, 800);
		
		wereld.createObjects();
	}

	@Override
	public void update() {
		
	}

}