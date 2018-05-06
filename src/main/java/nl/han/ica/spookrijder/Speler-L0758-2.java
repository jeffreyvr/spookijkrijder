package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Speler extends Voertuig {
	private Spookrijder spookrijder;
	private int height = 50;
	private int width = 118;
	
	public Speler(Spookrijder wereld, Sprite sprite) {
		super(wereld, sprite);
		this.spookrijder=spookrijder;
		sprite.resize(width, height);
	}
	
	public Speler(Spookrijder spookrijder) {
		this(
			spookrijder, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/car.png")
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
        if (key == ' ') {
            System.out.println("Spatie!");
            this.setX( this.getX() + this.getHeight() );
        }
    }
}
