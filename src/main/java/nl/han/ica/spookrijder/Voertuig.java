package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Voertuig extends SpriteObject {
	private Spookrijder spookrijder;
	private boolean aangeraakt = false;
	private int hoogte;
	private int breedte;
	protected int oorspronkelijke_snelheid;

	public Voertuig(Spookrijder spookrijder, Sprite sprite) {
		super(sprite);

		this.spookrijder = spookrijder;
	}

	@Override
	public void update() {
		if (this.getX() < (0 - this.getWidth())) {
			this.setX(spookrijder.getWidth() + this.getWidth());
			this.setAangeraakt(false);
			
			int currentBaan = this.getCurrentBaan();
			
			if ( currentBaan == 0 ) {
				this.setY( spookrijder.banen[1]-this.getHeight()/2 );
			} else if ( currentBaan == 1 ) {
				this.setY( spookrijder.banen[2]-this.getHeight()/2 );
			} else if ( currentBaan == 2 ) {
				this.setY( spookrijder.banen[0]-this.getHeight()/2 );
			}
			
			// System.out.println("Snelheid: "+this.oorspronkelijke_snelheid);
			//this.setxSpeed(this.oorspronkelijke_snelheid);
		}

		this.pasVerkeerAan();
	}
	
	public int getCurrentBaan() {
		if ( this.getY() == spookrijder.banen[0]-this.getHeight()/2 ) {
			return 0;
		} else if ( this.getY() == spookrijder.banen[1]-this.getHeight()/2 ) { 
			return 1;
		}
		return 2;
	}

	public void pasVerkeerAan() {
		for (GameObject object : spookrijder.getGameObjectItems()) {

			if (object instanceof Speler || this instanceof Speler)
				continue;

			if (object instanceof VerzamelObject || object instanceof Wereld)
				continue;

			if (this == object)
				continue;

			if ((object.getY() + object.getHeight() / 2) == (this.getY() + this.getHeight() / 2)) {

				int objectXPos = (int) (object.getX());
				int thisXPos = (int) (this.getX());

				if ((objectXPos - thisXPos) < 200 && (objectXPos - thisXPos) > 0) {
					System.out.println("Bijna botsing, snelheid en X aanpassen");

					object.setxSpeed(0);

					int terugzetX = (int) (objectXPos + 200);

					object.setX(terugzetX);

					object.setxSpeed(-4); // minst snelle object

				}
			}

		}
	}

	public void setAangeraakt(boolean aangeraakt) {
		this.aangeraakt = aangeraakt;
	}

	public boolean getAangeraakt() {
		return this.aangeraakt;
	}

	public float getHeight() {
		return this.hoogte;
	}

	public float getWidth() {
		return this.breedte;
	}

	public void setHeight(int hoogte) {
		this.hoogte = hoogte;
	}

	public void setWidth(int breedte) {
		this.breedte = breedte;
	}

}
