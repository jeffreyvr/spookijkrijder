package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Wereld extends SpriteObject {
	private Spookrijder spookrijder;
	private int breedte = 960;
	private int hoogte = 600;
	private final static Sprite wereldSprite = new Sprite(
			"src/main/java/nl/han/ica/spookrijder/media/background-elements_2.png");

	public Wereld(Spookrijder spookrijder) {
		super(wereldSprite);

		this.spookrijder = spookrijder;

		wereldSprite.resize(breedte, hoogte);

		setxSpeed(-3);
	}

	/**
	 * Update
	 * 
	 * Object her positioneren.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void update() {
		if (this.getX() < (0 - this.getWidth())) {
			this.setX(spookrijder.getWidth());
		}
	}

}
