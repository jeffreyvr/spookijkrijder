package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;

public class Score {
	private Spookrijder spookrijder;
	private TextObject status;
	private TextObject geld;

	public Score(Spookrijder spookrijder) {
		this.spookrijder = spookrijder;
		this.status = new TextObject("Status: " + spookrijder.speler.getStatus() + "%", 14);
		this.geld = new TextObject("Geld: €" + spookrijder.speler.getGeld(), 14);
	}

	/**
	 * Maak dashboard
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void maakDashboard(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(10, 10, dashboardWidth, dashboardHeight);
		dashboard.addGameObject(this.status, 0, 0);
		dashboard.addGameObject(this.geld, 180, 0);
		spookrijder.addDashboard(dashboard);
	}

	/**
	 * Zet de status van de speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setStatus(String statusText) {
		this.status.setText("Status voertuig: " + statusText + "%");
	}

	/**
	 * Zet het geld van de speler
	 * 
	 * @author Jurrian te Loo, Jeffrey van Rossum
	 * @since 11-05-2018
	 * @version 1.0
	 */
	public void setGeld(String geldText) {
		this.geld.setText("Geld: €" + geldText);
	}

}
