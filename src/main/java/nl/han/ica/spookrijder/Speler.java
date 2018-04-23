package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Speler extends Voertuig {
	private Spookrijder wereld;
	private int height = 50;
	private int width = 118;
	
	public Speler(Spookrijder wereld, Sprite sprite) {
		super(wereld, sprite);
		this.wereld=wereld;
		sprite.resize(width, height);
	}
	
	public Speler(Spookrijder wereld) {
		this(
			wereld, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/car.png")
		);
		
		setxSpeed(0);
	}

	@Override
	public void update() {
	    if ( this.getX() > wereld.getWidth() ) {
	        this.setX( 0 - this.getWidth() );
	    }
	
	}
}
