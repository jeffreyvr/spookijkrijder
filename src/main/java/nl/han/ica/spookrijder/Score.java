package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;

/**
 * Gebruik TextObject class hier.
 *
 */
public class Score {
	private Spookrijder spookrijder;
	private TextObject status;
	private TextObject geld;
	
	public Score(Spookrijder spookrijder) {
		this.spookrijder = spookrijder;
		this.status = new TextObject("Status: " + spookrijder.speler.getStatus(), 14);
		this.geld = new TextObject("Money in the bank: " + spookrijder.speler.getGeld(), 14 );
	}
	
	public void maakDashboard(int dashboardWidth,int dashboardHeight) {
        Dashboard dashboard = new Dashboard(10,10, dashboardWidth, dashboardHeight);
        dashboard.addGameObject(this.status, 0, 0);
        dashboard.addGameObject(this.geld, 100, 0);
        spookrijder.addDashboard(dashboard);
    }
	
	public void setStatus(String statusText) {
		this.status.setText(""+statusText);
	}

	public void setGeld(String geldText) {
		this.geld.setText(""+geldText);
	}

}
