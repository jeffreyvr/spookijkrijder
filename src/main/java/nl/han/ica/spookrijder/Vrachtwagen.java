package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Vrachtwagen extends Auto {
	private Spookrijder wereld;
	
	public Vrachtwagen(Spookrijder wereld) {
	    this(new Sprite("src/main/java/nl/han/ica/spookrijder/media/truck.png"));
	    this.wereld=wereld;
	}

	public Vrachtwagen(Sprite sprite) {
		super(sprite);
	    setxSpeed(-1);
	}
	
	@Override
	public void update() {
	    if ( this.getX() > wereld.getWidth() ) {
	        this.setX( 0 - this.getWidth() );
	    }
	
	}
}
