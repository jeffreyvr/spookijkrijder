package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;
import processing.core.PGraphics;

public class StartScherm extends Scherm {
	private Spookrijder spookrijder;
	
	StartScherm(Spookrijder spookrijder) {
		super(spookrijder);
		
		this.vulScherm();
		
		this.spookrijder = spookrijder;
	}
	
	/**
	 * Vul Scherm
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void vulScherm() {
		super.scherm.setBackgroundImage(new Sprite("src/main/java/nl/han/ica/spookrijder/media/splashscreen.jpg"));
		
		this.setTekst("Druk op Enter om te beginnen", 18, 20, 540);
		this.setTekst("Gebruik de pijltjes toetsen (omhoog; omlaag) om van rijstrook te wisselen om zo het verkeer te ontwijken.", 14, 20, 560);
		this.setTekst("Verzamel reparatiesets om je auto te repareren en verdien geld door geldzakken te verzamelen.", 14, 20, 580);
	}
	
	/**
	 * Zet Tekst
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setTekst(String tekst, int fontsize, int x, int y) {
		TextObject object = new TextObject(tekst, fontsize);
		object.setForeColor(255, 255, 255, 255);
		super.scherm.addGameObject(object , x, y);
	}
	
	@Override
	public void update() {}

	@Override
	public void draw(PGraphics g) {}
	
	/**
	 * keyPressed
	 * 
	 * Zet game status op spel als status start is.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
    public void keyPressed(int keyCode, char key) {
		if ( keyCode == (int) 10 && spookrijder.getGameStatus() == "start" ) {
			spookrijder.setGameStatus("spel");
		}
	}
}
