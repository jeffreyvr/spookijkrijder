package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.TextObject;

/**
 * Gebruik TextObject class hier.
 *
 */
public class Score {
	private Spookrijder wereld;

	public Score(Spookrijder wereld) {
		this.wereld = wereld;
	}
	
	public void createDashboard(int dashboardWidth,int dashboardHeight) {
        Dashboard dashboard = new Dashboard(100,100, dashboardWidth, dashboardHeight);
        TextObject dashboardText=new TextObject("Hoi Jurrian", 14);
        TextObject dashboardText2=new TextObject("Hoi Jeffrey", 14);
        dashboard.addGameObject(dashboardText, 0, 0);
        dashboard.addGameObject(dashboardText2, 0, 20 );
        wereld.addDashboard(dashboard);
    }

}
