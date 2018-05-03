package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Wereld extends SpriteObject {
	private Spookrijder spookrijder;
	private int breedte = 960;
	private int hoogte = 600;
	
	Wereld (Spookrijder spookrijder, Sprite sprite) {
		super(sprite);
		
		this.spookrijder=spookrijder;
		
		sprite.resize(breedte,hoogte);
		
		setxSpeed(-3);
	}
	
	public Wereld(Spookrijder spookrijder) {
		this(
			spookrijder, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/background-elements_2.png")
		);
	}

	@Override
	public void update() {
		if ( this.getX() < ( 0 - this.getWidth() ) ) {
	        this.setX( spookrijder.getWidth() );
		}
	}
	
	
}
