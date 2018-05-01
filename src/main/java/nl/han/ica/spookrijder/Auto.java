package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Auto extends Voertuig {
	private Spookrijder spookrijder;
	public int hoogte = 50;
	public int breedte = 118;
	private static Sprite autoSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/audi.png");
	
	public Auto(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		
		autoSprite.resize(breedte,hoogte);
		
		this.setHeight(hoogte);
		this.setWidth(breedte);
		
		this.spookrijder=spookrijder;
	}
	
	public Auto(Spookrijder spookrijder) {
		this(
			spookrijder, 
			autoSprite
		);
		
		setxSpeed(-3);
	}

}
