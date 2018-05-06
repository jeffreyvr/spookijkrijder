package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public class Wereld {
	private Spookrijder wereld;
	
	public Wereld(Spookrijder wereld) {
		this.wereld = wereld;
	}
	
	public void createViewWithoutViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth,screenHeight);
        view.setBackground(wereld.loadImage("src/main/java/nl/han/ica/spookrijder/media/background.jpg"));

        wereld.setView(view);
        wereld.size(screenWidth, screenHeight);
	}
	
	public void createObjects() {
		wereld.addGameObject( new Auto(wereld), wereld.getWidth(), 30 );
		wereld.addGameObject( new Vrachtwagen(wereld), wereld.getWidth(), 80 );
		wereld.addGameObject( new Motor(wereld), wereld.getWidth(), 120 );

		wereld.addGameObject( new Speler(wereld), 0, 140 );
	}
}
