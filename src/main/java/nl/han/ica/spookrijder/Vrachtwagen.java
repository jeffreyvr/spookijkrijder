package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Vrachtwagen extends Voertuig {
	private Spookrijder wereld;
	private int height = 75;
	private int width = 182;
	
	public Vrachtwagen(Spookrijder wereld, Sprite sprite) {
		super(wereld, sprite);
		this.wereld=wereld;
		sprite.resize(width, height);
	}
	
	public Vrachtwagen(Spookrijder wereld) {
		this(
			wereld, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/truck.png")
		);
		
		setxSpeed(-1);
	}
	
	@Override
	public void update() {
	    if ( this.getX() > wereld.getWidth() ) {
	        this.setX( 0 - this.getWidth() );
	    }
	
	}
}