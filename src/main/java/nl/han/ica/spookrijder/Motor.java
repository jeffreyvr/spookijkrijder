package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Motor extends Voertuig {
	private Spookrijder spookrijder;
	private int hoogte = 40;
	private int breedte = 73;
	private static Sprite motorSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/motor.png");
	
	public Motor(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		
		motorSprite.resize(breedte,hoogte);
		
		this.setHeight(hoogte);
		this.setWidth(breedte);
		
		this.spookrijder=spookrijder;
	}
	
	public Motor(Spookrijder spookrijder) {
		this(spookrijder, motorSprite);
		setxSpeed(-4);
	}
	
}
