package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;
import processing.core.PGraphics;

public class GameoverScherm extends Scherm {
	private Spookrijder spookrijder;
	private boolean update = false;

	GameoverScherm(Spookrijder spookrijder) {
		super(spookrijder);

		this.spookrijder = spookrijder;
	}
	
	/**
	 * Vul scherm
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void vulScherm() {
		super.scherm.setBackgroundImage(new Sprite("src/main/java/nl/han/ica/spookrijder/media/gameoverscreen.jpg"));

		this.setTekst("Helaas, je auto is kapot.", 14, 20, 540);
		this.setTekst("Druk op Enter om opnieuw beginnen", 18, 20, 580);
	}
	
	/**
	 * Zet tekst
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setTekst(String tekst, int fontsize, int x, int y) {
		TextObject object = new TextObject(tekst, fontsize);
		object.setForeColor(255, 255, 255, 255);
		super.scherm.addGameObject(object, x, y);
	}
	
	/**
	 * Update
	 * 
	 * Print eind score.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void update() {
		if (spookrijder.getGameStatus() == "eind" && update == false) {
			System.out.println("Update Game over");
			this.setTekst("Geld: €" + this.spookrijder.speler.getGeld(), 14, 20, 560);
			update = true;
		}
	}

	@Override
	public void draw(PGraphics g) {
	}
	
	/**
	 * keyPressed
	 * 
	 * Bij einde game en enter toets spel resetten.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void keyPressed(int keyCode, char key) {
		if (keyCode == (int) 10 && spookrijder.getGameStatus() == "eind") {
			spookrijder.resetGame();
		}
	}
}
