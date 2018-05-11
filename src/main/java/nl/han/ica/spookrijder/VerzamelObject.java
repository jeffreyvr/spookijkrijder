package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public abstract class VerzamelObject extends SpriteObject {
	private Spookrijder spookrijder;
	private boolean aangeraakt = false;
	private int breedte;
	private int hoogte;
	protected String geluidsnaam; // naam van geluidsbestand

	public VerzamelObject(Spookrijder spookrijder, Sprite sprite) {
		super(sprite);
		this.spookrijder = spookrijder;

		setxSpeed(-3);
	}
	
	/**
	 * Update
	 * 
	 * Zet aangeraakt status en zichtbaarheid op basis van x positie.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void update() {
		if (this.getX() < (0 - this.getWidth())) {
			this.setX(spookrijder.getWidth() + this.getWidth());
			this.setAangeraakt(false);
			this.setVisible(true);
		}
	}

	/**
	 * Zet aangeraakt
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setAangeraakt(boolean aangeraakt) {
		this.aangeraakt = aangeraakt;
	}

	/**
	 * Verkrijg aangeraakt
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @return Aangeraakt-status van het object.
	 * @version 1.0
	 */
	public boolean getAangeraakt() {
		return this.aangeraakt;
	}

	/**
	 * Verkrijg hoogte
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return De hoogte van het object.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public float getHeight() {
		return this.hoogte;
	}

	/**
	 * Verkrijg breedte
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return De breedte van het object.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public float getWidth() {
		return this.breedte;
	}

	/**
	 * Zet hoogte
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setHeight(int hoogte) {
		this.hoogte = hoogte;
	}

	/**
	 * Zet breedte
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setWidth(int breedte) {
		this.breedte = breedte;
	}

	/**
	 * Doe Geluid
	 * 
	 * Initialiseert een geluidsobject en speelt deze af.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void doeGeluid() {
		Sound geluid = new Sound(spookrijder,
				"src/main/java/nl/han/ica/spookrijder/media/" + this.geluidsnaam + ".mp3");
		geluid.play();
	}

}
