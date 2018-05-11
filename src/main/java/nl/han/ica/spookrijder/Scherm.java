package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public abstract class Scherm extends GameObject {
	private Spookrijder spookrijder;
	protected Dashboard scherm;

	Scherm(Spookrijder spookrijder) {
		this.spookrijder = spookrijder;
		this.scherm = new Dashboard(0, 0, spookrijder.getWidth(), spookrijder.getHeight());
	}

	/**
	 * Vul Scherm
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void vulScherm() {
	}

	/**
	 * add Scherm
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void addScherm() {
		spookrijder.addDashboard(this.scherm);
		spookrijder.addGameObject(this);
	}

	/**
	 * Verberg
	 * 
	 * Verberg het scherm.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void verberg() {
		this.scherm.setVisible(false);
	}

	/**
	 * Toon Scherm
	 * 
	 * Toon het scherm.
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void toon() {
		this.scherm.setVisible(true);
	}

}
