package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Spookrijder extends GameEngine {
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
		addGameObject( new Auto(this), this.getWidth(), 30 );
		addGameObject( new Vrachtwagen(this), this.getWidth(), 80 );
		addGameObject( new Motor(this), this.getWidth(), 120 );

		addGameObject( new Speler(this), 0, 160 );
	}

}