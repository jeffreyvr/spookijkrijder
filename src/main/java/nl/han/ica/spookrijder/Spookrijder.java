package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

public class Spookrijder extends GameEngine {
	private int aantal_autos = 3;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.spookrijder.Spookrijder"});
	}
	
	@Override
    public void setupGame() {
		createViewWithoutViewport(1280, 800);
		
		createObjects();
	}

	@Override
	public void update() {
		
	}
	
	private void createViewWithoutViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/spookrijder/media/background.jpg"));

        setView(view);
        size(screenWidth, screenHeight);
	}
	
	private void createObjects() {
	    for ( int i = 0; i < this.aantal_autos; i++ ) {
	    	addGameObject( new Auto(this), i*50, (float) (i*100) + 50 );
	    }
	}

}