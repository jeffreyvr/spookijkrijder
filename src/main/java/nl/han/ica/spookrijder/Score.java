package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;

/**
 * Gebruik TextObject class hier.
 *
 */
public class Score {
	private Spookrijder spookrijder;

	public Score(Spookrijder spookrijder) {
		this.spookrijder = spookrijder;
	}
	
	public void maakDashboard(int dashboardWidth,int dashboardHeight, int status) {
        Dashboard dashboard = new Dashboard(10,10, dashboardWidth, dashboardHeight);
        TextObject dashboardText=new TextObject("Status: " + status, 14);
        dashboard.addGameObject(dashboardText, 0, 0);
        spookrijder.addDashboard(dashboard);
    }

}
