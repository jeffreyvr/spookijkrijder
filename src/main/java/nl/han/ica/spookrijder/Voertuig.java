package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public abstract class Voertuig extends SpriteObject {
	private Spookrijder spookrijder;
	private boolean aangeraakt = false;
	private int hoogte;
	private int breedte;
	protected int oorspronkelijkeSnelheid = 0;
	protected String geluidsnaam;
	protected int doetSchade = 0;

	public Voertuig(Spookrijder spookrijder, Sprite sprite) {
		super(sprite);

		this.spookrijder = spookrijder;
	}

	/**
	 * Update
	 * 
	 * Maak geluid bij passeren speler en handelt herpositionering af.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void update() {
		if (spookrijder.getGameStatus() != "spel")
			return;

		if (this instanceof Speler)
			return;

		if (this.getX() < 202 && this.getX() > 194) {
			this.doeGeluid();
		}

		if (this.getX() < (0 - this.getWidth())) {
			this.setX(spookrijder.getWidth() + this.getWidth());
			this.setAangeraakt(false);

			int currentBaan = this.getCurrentBaan();

			if (currentBaan == 0) {
				this.setY(spookrijder.banen[1] - this.getHeight() / 2);
			} else if (currentBaan == 1) {
				this.setY(spookrijder.banen[2] - this.getHeight() / 2);
			} else if (currentBaan == 2) {
				this.setY(spookrijder.banen[0] - this.getHeight() / 2);
			}

			this.setxSpeed(this.oorspronkelijkeSnelheid);
		}

		this.pasVerkeerAan();
	}

	/**
	 * Doe geluid
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

	/**
	 * Geeft de baan van het voertuig
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return Baan waar voertuig zich op bevindt.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public int getCurrentBaan() {
		if (this.getY() == spookrijder.banen[0] - this.getHeight() / 2) {
			return 0;
		} else if (this.getY() == spookrijder.banen[1] - this.getHeight() / 2) {
			return 1;
		}
		return 2;
	}

	/**
	 * Pas het verkeer aan
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
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
				int marge = 200;

				if ((objectXPos - thisXPos) < marge && (objectXPos - thisXPos) > 0) {
					System.out.println("Bijna botsing, snelheid en X aanpassen");

					object.setxSpeed(0);

					int terugzetX = (int) (objectXPos + marge);

					object.setX(terugzetX);

					object.setxSpeed(-4); // minst snelle object

				}
			}

		}
	}

	/**
	 * Zet voertuig aangeraakt status
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setAangeraakt(boolean aangeraakt) {
		this.aangeraakt = aangeraakt;
	}

	/**
	 * Geeft voertuig aangeraakt status
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return Boolean waarde of het voertuig is aangeraakt of niet.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public boolean getAangeraakt() {
		return this.aangeraakt;
	}

	/**
	 * Geeft hoogte van voertuig
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return Hoogte van het voertuig.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public float getHeight() {
		return this.hoogte;
	}

	/**
	 * Geeft breedte van voertuig
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return Breedte van het voertuig.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public float getWidth() {
		return this.breedte;
	}

	/**
	 * Zet hoogte van voertuig
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setHeight(int hoogte) {
		this.hoogte = hoogte;
	}

	/**
	 * Zet breedte van voertuig
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setWidth(int breedte) {
		this.breedte = breedte;
	}

	/**
	 * setxSpeed
	 * 
	 * Stel snelheid in en zet de oorspronkelijke snelheid.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void setxSpeed(float speed) {
		super.setxSpeed(speed);
		this.oorspronkelijkeSnelheid = (int) speed;
	}

}
