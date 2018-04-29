package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public class Collectable {
	private boolean aangeraakt = false;
	
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		this.aangeraakt = true;
	}
	
	public void update() {
		if ( aangeraakt ) {
			// delete, update score
		}
	}
	
}
