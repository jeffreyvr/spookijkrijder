package nl.han.ica.spookrijder;

//import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Auto extends Voertuig {
	private Spookrijder wereld;
	private int height = 50;
	private int width = 118;
	
	public Auto(Spookrijder wereld, Sprite sprite) {
		super(wereld, sprite);
		this.wereld=wereld;
		sprite.resize(width, height);
	}
	
	public Auto(Spookrijder wereld) {
		this(
			wereld, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/audi.png")
		);
		
		setxSpeed(-2);
	}

	@Override
	public void update() {
	    if ( this.getX() > wereld.getWidth() ) {
	        this.setX( 0 - this.getWidth() );
	    }
	
	}
	
}
