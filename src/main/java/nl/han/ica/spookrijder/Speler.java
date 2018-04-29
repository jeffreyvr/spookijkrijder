package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Speler extends Voertuig {
	private Spookrijder spookrijder;
	private int hoogte = 50;
	private int breedte = 118;
	private static Sprite spelerSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/car.png");
	
	public Speler(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		this.spookrijder=spookrijder;
		spelerSprite.resize(breedte,hoogte);
	}
	
	public Speler(Spookrijder spookrijder) {
		this(                      
			spookrijder, 
			spelerSprite
		);
		
		setxSpeed(0);
	}

	@Override
	public void update() {
	    if ( this.getX() > spookrijder.getWidth() ) {
	        this.setX( 0 - this.getWidth() );
	    }
	
	}
	
	@Override
    public void keyPressed(int keyCode, char key) {
        if (keyCode == 38) { // UP
            
            this.setY( this.getY() - this.getHeight() );
            
        } else if ( keyCode == 40 ) { // DOWN
        	
        	this.setY( this.getY() + this.getHeight() );
        	
        }
    }
	
	@Override
	public float getHeight() {
		return this.hoogte;
	}
}
