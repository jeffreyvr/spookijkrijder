package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Speler extends Voertuig implements ICollidableWithGameObjects {
	private Spookrijder spookrijder;
	private int huidigeBaan = 1;
	private final static Sprite spelerSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/car.png");
	private Sound crash;
	private int status = 100;
	private int geld = 0;

	public Speler(Spookrijder spookrijder) {
		super(spookrijder, spelerSprite);
		this.spookrijder = spookrijder;

		this.setHeight(50);
		this.setWidth(118);

		spelerSprite.resize((int) this.getWidth(), (int) this.getHeight());
	}

	/**
	 * Zet huidige baan van speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setHuidigeBaan(int baan) {
		this.huidigeBaan = baan;
	}

	/**
	 * Verkrijg huidige baan van speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public int getHuidigeBaan() {
		return this.huidigeBaan;
	}

	/**
	 * Zet status van speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setStatus(int status) {
		if (!(status > 0)) {
			System.out.println("Status update!!!");
			spookrijder.setGameStatus("eind");
		} else {
			System.out.println("Schade update: " + status);
			this.status = status;
		}
	}

	/**
	 * Verkrijg status van speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * Zet geld van speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setGeld(int geld) {
		this.geld = geld;
	}

	/**
	 * Verkrijg geld van speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @return Geld van speler.
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public int getGeld() {
		return this.geld;
	}

	/**
	 * keyPressed
	 * 
	 * Handelt baan wisselen af van speler.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void keyPressed(int keyCode, char key) {
		String keyName = (keyCode == 40 ? "down" : "up");
		boolean verander = false;

		if (keyName == "up") {

			if (this.getHuidigeBaan() > 0) {
				verander = true;
				System.out.println("Baan switch naar null");
				this.setHuidigeBaan(this.getHuidigeBaan() - 1);
			}

		} else if (keyName == "down") {

			if (this.getHuidigeBaan() < spookrijder.banen.length - 1) {
				verander = true;
				this.setHuidigeBaan(this.getHuidigeBaan() + 1);
			}

		}

		if (verander) {
			System.out.println("Verander is true");
			System.out.println(this.getHeight() / 2);
			System.out.println(this.getHuidigeBaan());

			this.setY(spookrijder.banen[this.getHuidigeBaan()] - this.getHeight() / 2);
		}
	}

	/**
	 * Crash geluid
	 * 
	 * Maakt crash geluid bij botsing van speler.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void crashSound() {
		this.crash = new Sound(spookrijder, "src/main/java/nl/han/ica/spookrijder/media/Botsing.mp3");
		this.crash.play();
	}

	/**
	 * gameObjectCollisionOccurred
	 * 
	 * Handelt botsingen van speler met voertuigen en verzamelobjecten af.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject object : collidedGameObjects) {

			if (object instanceof Voertuig && ((Voertuig) object).getAangeraakt() == false) {
				if (object instanceof Auto) {
					spookrijder.speler.setStatus(spookrijder.speler.getStatus() - ((Auto) object).doetSchade);
				} else if (object instanceof Motor) {
					spookrijder.speler.setStatus(spookrijder.speler.getStatus() - ((Motor) object).doetSchade);
				} else if (object instanceof Vrachtwagen) {
					spookrijder.speler.setStatus(spookrijder.speler.getStatus() - ((Vrachtwagen) object).doetSchade);
				}

				spookrijder.speler.crashSound();
				((Voertuig) object).setAangeraakt(true);

			} else if (object instanceof VerzamelObject && ((VerzamelObject) object).getAangeraakt() == false) {

				if (object instanceof ZakGeld) {
					spookrijder.speler.setGeld(spookrijder.speler.getGeld() + 10);
					((ZakGeld) object).doeGeluid();

				} else if (object instanceof Reparatieset) {
					spookrijder.speler.setStatus(100);
					((Reparatieset) object).doeGeluid();
				}

				((VerzamelObject) object).setVisible(false);
				((VerzamelObject) object).setAangeraakt(true);
			}

		}

	}

	/**
	 * Reset
	 * 
	 * Reset de spelerwaardes.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void reset() {
		this.setStatus(100);
		this.setGeld(0);
		this.setHuidigeBaan(1);
	}

}
