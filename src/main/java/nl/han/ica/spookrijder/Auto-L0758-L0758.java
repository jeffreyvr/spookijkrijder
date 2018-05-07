package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Auto extends Voertuig {
	private Spookrijder spookrijder;
	public int hoogte = 50;
	public int breedte = 118;
	private static Sprite autoSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/audi.png");
	
	public Auto(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		
		autoSprite.resize(breedte,hoogte);
		
		this.spookrijder=spookrijder;
	}
	
	public Auto(Spookrijder spookrijder) {
		this(
			spookrijder, 
			autoSprite
		);
		
		setxSpeed(-3);
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
