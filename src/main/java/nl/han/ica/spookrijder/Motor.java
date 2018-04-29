package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Motor extends Voertuig {
	private Spookrijder spookrijder;
	private int hoogte = 40;
	private int breedte = 73;
	private static Sprite motorSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/motor.png");
	
	public Motor(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		motorSprite.resize(breedte,hoogte);
		this.spookrijder=spookrijder;
	}
	
	public Motor(Spookrijder spookrijder) {
		this(spookrijder, motorSprite);
		setxSpeed(-4);
	}

	@Override
	public void update() {
	    if ( this.getX() < ( 0 - this.getWidth() ) ) {
	        this.setX( spookrijder.getWidth() + this.getWidth() );
	        this.aangeraakt=false;
	    }
	
	}
	
	@Override
	public float getHeight() {
		return this.hoogte;
	}
	
}
