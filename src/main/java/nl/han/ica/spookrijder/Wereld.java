package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public class Wereld {
	private Spookrijder spookrijder;
	
	public Wereld(Spookrijder spookrijder) {
		this.spookrijder = spookrijder;
	}
	
	public void maakViewZonderViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth,screenHeight);
        view.setBackground(spookrijder.loadImage("src/main/java/nl/han/ica/spookrijder/media/background_1.jpg"));

        spookrijder.setView(view);
        spookrijder.size(screenWidth, screenHeight);
	}
	
	public void maakInteractieveObjecten() {
		
		
		int aantal_autos = 3;
		
		for ( int i = 0; i < aantal_autos; i++ ) {
			Auto auto = new Auto(spookrijder);
			spookrijder.addGameObject(new Auto(spookrijder), spookrijder.getWidth() * i, spookrijder.banen[i]-auto.getHeight()/2 );
		}
		
		
		Vrachtwagen vrachtwagen = new Vrachtwagen(spookrijder);
		spookrijder.addGameObject( vrachtwagen, spookrijder.getWidth(), spookrijder.banen[0]-vrachtwagen.getHeight()/2 );
		
		Motor motor = new Motor(spookrijder);
		spookrijder.addGameObject( motor, spookrijder.getWidth(), spookrijder.banen[2]-motor.getHeight()/2 );
		
		ZakGeld zakgeld = new ZakGeld(spookrijder);
		spookrijder.addGameObject( zakgeld, 100, spookrijder.banen[1]-zakgeld.getHeight()/2 );
		
		Reparatieset reparatieset = new Reparatieset(spookrijder); 
		spookrijder.addGameObject( reparatieset, 200, spookrijder.banen[2]-reparatieset.getHeight()/2 );
		
		Speler speler = new Speler(spookrijder);
		spookrijder.addGameObject( speler, 0, spookrijder.banen[1]-speler.getHeight()/2 );
		
	}
	
	public void maakStatischeObjecten() {
		spookrijder.addGameObject( new Boom(spookrijder), 0, 0 );
		spookrijder.addGameObject( new Boom(spookrijder), spookrijder.getWidth(), 0 );
		spookrijder.addGameObject( new Boom(spookrijder), spookrijder.getWidth() * 2, 0 );
	}
}
