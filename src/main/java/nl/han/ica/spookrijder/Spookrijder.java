package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Spookrijder extends GameEngine {
	public int banen[] = {75, 153, 233};
	public Speler speler;
	private Score score;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"nl.han.ica.spookrijder.Spookrijder"});
	}
	
	public Spookrijder() {
		this.speler = new Speler(this);
		this.score = new Score(this);
	}
	
	@Override
    public void setupGame() {
		this.maakViewZonderViewport(960, 600);

		this.maakStatischeObjecten();
		this.maakInteractieveObjecten();
		
		this.score.maakDashboard(960, 600);
	}

	@Override
	public void update() {
		this.score.setStatus(""+this.speler.getStatus());
		this.score.setGeld(""+this.speler.getGeld());
	}
	
	public void maakViewZonderViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth,screenHeight);
        this.setView(view);
        this.size(screenWidth, screenHeight);
	}
	
	public void maakInteractieveObjecten() {
		int aantal_autos = 2;
		int aantal_motors = 2;
		
		for ( int i = 0; i < aantal_autos; i++ ) {
			Auto auto = new Auto(this);
			this.addGameObject(new Auto(this), this.getWidth() * i, this.banen[i]-auto.getHeight()/2 );
		}
		
		for ( int i = 0; i < aantal_motors; i++ ) {
			Motor motor = new Motor(this);
			this.addGameObject( motor, this.getWidth(), this.banen[i]-motor.getHeight()/2 );
		}
		
		this.addGameObject( this.speler, 50, this.banen[1]-this.speler.getHeight()/2 );
		
		Vrachtwagen vrachtwagen = new Vrachtwagen(this);
		this.addGameObject( vrachtwagen, this.getWidth(), this.banen[0]-vrachtwagen.getHeight()/2 );
		
		ZakGeld zakgeld = new ZakGeld(this);
		this.addGameObject( zakgeld, 800, this.banen[1]-zakgeld.getHeight()/2 );
		
		Reparatieset reparatieset = new Reparatieset(this); 
		this.addGameObject( reparatieset, 300, this.banen[0]-reparatieset.getHeight()/2 );
		
	}
	
	public void maakStatischeObjecten() {
		for ( int i = 0; i < 3; i++ ) {
			this.addGameObject( new Wereld(this), this.getWidth() * i, 0 );
		}	
	}

}