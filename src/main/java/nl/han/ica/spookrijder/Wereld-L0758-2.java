package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public class Wereld {
	private Spookrijder spookrijder;
	
	public Wereld(Spookrijder spookrijder) {
		this.spookrijder = spookrijder;
	}
	
	public void createViewWithoutViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth,screenHeight);
        view.setBackground(spookrijder.loadImage("src/main/java/nl/han/ica/spookrijder/media/background.jpg"));

        spookrijder.setView(view);
        spookrijder.size(screenWidth, screenHeight);
	}
	
	public void createObjects() {
		spookrijder.addGameObject( new Auto(spookrijder), spookrijder.getWidth(), 30 );
		spookrijder.addGameObject( new Vrachtwagen(spookrijder), spookrijder.getWidth(), 80 );
		spookrijder.addGameObject( new Motor(spookrijder), spookrijder.getWidth(), 120 );

		spookrijder.addGameObject( new Speler(spookrijder), 0, 140 );
	}
}
