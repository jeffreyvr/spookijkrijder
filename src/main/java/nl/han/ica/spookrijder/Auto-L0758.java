package nl.han.ica.spookrijder;

//import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Auto extends SpriteObject {
	private Spookrijder wereld;
	
	public Auto(Spookrijder wereld) {
	    this(new Sprite("src/main/java/nl/han/ica/spookrijder/media/car.png"));
	    this.wereld=wereld;
	}
	
	public Auto(Sprite sprite) {
	    super(sprite);
	    setxSpeed(3);
	}

	@Override
	public void update() {
	    if ( this.getX() > wereld.getWidth() ) {
	        this.setX( 0 - this.getWidth() );
	    }
	
	}
	
}
