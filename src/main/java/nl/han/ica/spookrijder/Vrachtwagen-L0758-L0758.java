package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Vrachtwagen extends Voertuig {
	private Spookrijder spookrijder;
	private int hoogte = 75;
	private int breedte = 182;
	private static Sprite vrachtwagenSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/truck.png");
	
	public Vrachtwagen(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		vrachtwagenSprite.resize(breedte,hoogte);
		this.spookrijder=spookrijder;
	}
	
	public Vrachtwagen(Spookrijder spookrijder) {
		this(
			spookrijder, 
			vrachtwagenSprite
		);
		
		setxSpeed(-2);
	}
	
	@Override
	public void update() {
		if ( this.getX() < ( 0 - this.getWidth() ) ) {
	        this.setX( spookrijder.getWidth() + this.getWidth() );
	    }
	
	}
	
	@Override
	public float getHeight() {
		return this.hoogte;
	}
	
}