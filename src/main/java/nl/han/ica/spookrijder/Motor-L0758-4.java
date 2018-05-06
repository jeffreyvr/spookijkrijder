package nl.han.ica.spookrijder;

//import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Motor extends Voertuig {
	private Spookrijder spookrijder;
	private int hoogte = 40;
	private int breedte = 73;
	
	public Motor(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		this.spookrijder=spookrijder;
		sprite.resize(hoogte, breedte);
	}
	
	public Motor(Spookrijder spookrijder) {
		this(spookrijder, new Sprite("src/main/java/nl/han/ica/spookrijder/media/motor.png"));
		setxSpeed(-3);
	}

	@Override
	public void update() {
	    if ( this.getX() < 0 ) {
	        this.setX( spookrijder.getWidth() + this.getWidth() );
	        this.aangeraakt=false;
	    }
	
	}
	
}
