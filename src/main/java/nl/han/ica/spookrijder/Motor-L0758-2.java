package nl.han.ica.spookrijder;

//import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Motor extends Voertuig {
	private Spookrijder wereld;
	private int height = 40;
	private int width = 73;
	
	public Motor(Spookrijder wereld, Sprite sprite) {
		super(wereld, sprite);
		this.wereld=wereld;
		sprite.resize(width, height);
	}
	
	public Motor(Spookrijder wereld) {
		this(wereld, new Sprite("src/main/java/nl/han/ica/spookrijder/media/motor.png"));
		setxSpeed(-3);
	}

	@Override
	public void update() {
	    if ( this.getX() < wereld.getWidth() ) {
	        this.setX( wereld.getWidth() + this.getWidth() );
	    }
	
	}
	
}
