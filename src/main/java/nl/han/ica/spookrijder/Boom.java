package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Boom extends StatischObject {

	private Spookrijder spookrijder;
	private int breedte = 960;
	private int hoogte = 600;

	Boom(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		this.spookrijder=spookrijder;
		sprite.resize(breedte,hoogte);
		setxSpeed(-1);
	}
	
	public Boom(Spookrijder spookrijder) {
		this(
			spookrijder, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/background-elements_1.png")
		);
	}

	@Override
	public void update() {
		if ( this.getX() < ( 0 - this.getWidth() ) ) {
	        this.setX( spookrijder.getWidth() + this.getWidth() );
		}
	}

}
