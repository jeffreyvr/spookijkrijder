package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Collectable extends SpriteObject implements ICollidableWithGameObjects {
	private boolean aangeraakt = false;
	private Spookrijder wereld;
	
	public Collectable(Spookrijder wereld, Sprite sprite) {
		super(sprite);
		
		this.wereld=wereld;
	}
	
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		this.aangeraakt = true;
	}
	
	public void update() {
		if ( aangeraakt ) {
			// delete, update score
		}
	}
	
}
