package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class Voertuig extends GameObject implements ICollidableWithGameObjects {
	private Spookrijder wereld;
	
	public Voertuig(Spookrijder wereld) {
	    this.wereld=wereld;
	}
	
	@Override
	public void update() {
		if ( getX() + getWidth() <= 0 ) {
	        setX( wereld.getWidth() );
	    }
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
