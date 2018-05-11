package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Spookrijder extends GameEngine {
	public int banen[] = { 75, 153, 233 }; // Y-posities van de banen
	public Speler speler; // de speler
	public Score score; // de score
	private String GameStatus = "start";
	public boolean GameSetup = false;  // game setup status
	private Scherm StartScherm;
	private Scherm GameoverScherm;

	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.spookrijder.Spookrijder" });
	}

	public Spookrijder() {
		this.speler = new Speler(this);
		this.score = new Score(this);
	}
	
	/**
	 * setupGame
	 * 
	 * Initialiseert de viewport, score en schermen
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void setupGame() {
		
		this.maakViewZonderViewport(900, 600);
		
		this.score.maakDashboard(900, 600);
		
		this.StartScherm = new StartScherm(this);
		this.StartScherm.addScherm();
		
		this.GameoverScherm = new GameoverScherm(this);
		this.GameoverScherm.vulScherm();
		
		this.GameoverScherm.addScherm();
		this.GameoverScherm.verberg();
	}
	
	/**
	 * update
	 * 
	 * Update 
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void update() {
		
		if ( this.getGameStatus() == "spel" ) { 
						
			if ( GameSetup == false ) {
				
				this.StartScherm.verberg();
				
				this.GameoverScherm.verberg();
				
				this.maakStatischeObjecten();
				this.maakInteractieveObjecten(3, 2, 1, 1, 1);
			}
			
			GameSetup = true; // setup maar een keer uitvoeren
			
			this.score.setStatus("" + this.speler.getStatus());
			this.score.setGeld("" + this.speler.getGeld());
		}
		
		if ( this.getGameStatus() == "eind" ) {
			this.GameoverScherm.toon();
		}
		
	}

	/**
	 * Maak view zonder viewport
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return Baan waar voertuig zich op bevindt.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void maakViewZonderViewport(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		this.setView(view);
		this.size(screenWidth, screenHeight);
	}

	/**
	 * Maak interactieve objecten
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void maakInteractieveObjecten(int aantal_autos, int aantal_motors, int aantal_vrachtwagens,
			int aantal_zakkengeld, int aantal_reparatiesets) {

		for (int i = 0; i < aantal_autos; i++) {
			Auto auto = new Auto(this);
			this.addGameObject(new Auto(this), this.getWidth() * i, this.banen[i] - auto.getHeight() / 2);
		}

		for (int i = 0; i < aantal_motors; i++) {
			Motor motor = new Motor(this);
			this.addGameObject(motor, this.getWidth(), this.banen[i] - motor.getHeight() / 2);
		}

		for (int i = 0; i < aantal_vrachtwagens; i++) {
			Vrachtwagen vrachtwagen = new Vrachtwagen(this);
			this.addGameObject(vrachtwagen, this.getWidth(), this.banen[i] - vrachtwagen.getHeight() / 2);
		}

		for (int i = 0; i < aantal_zakkengeld; i++) {
			ZakGeld zakgeld = new ZakGeld(this);
			this.addGameObject(zakgeld, 800, this.banen[i] - zakgeld.getHeight() / 2);
		}

		for (int i = 0; i < aantal_reparatiesets; i++) {
			Reparatieset reparatieset = new Reparatieset(this);
			this.addGameObject(reparatieset, 300, this.banen[i] - reparatieset.getHeight() / 2);
		}
		
		this.addGameObject(this.speler, 50, this.banen[1] - this.speler.getHeight() / 2);
	}

	/**
	 * Maak statische objecten
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void maakStatischeObjecten() {
		for (int i = 0; i < 3; i++) {
			this.addGameObject(new Wereld(this), this.getWidth() * i, 0);
		}
	}
	
	public void setGameStatus(String status) {
		System.out.println("Game status: " + status);
		this.GameStatus=status;
	}
	
	public String getGameStatus() {
		return this.GameStatus;
	}
	
	/**
	 * Reset game
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void resetGame() {
		this.deleteAllGameObjectsOfType(Auto.class);
		this.deleteAllGameObjectsOfType(Motor.class);
		this.deleteAllGameObjectsOfType(Vrachtwagen.class);
		this.deleteAllGameObjectsOfType(Speler.class);
		this.deleteAllGameObjectsOfType(ZakGeld.class);
		this.deleteAllGameObjectsOfType(Reparatieset.class);
		
		this.speler.reset();
		
		this.setGameStatus("spel");
		this.GameSetup = false;
	}
}