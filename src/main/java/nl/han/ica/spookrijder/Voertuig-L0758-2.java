package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Voertuig extends SpriteObject implements ICollidableWithGameObjects {
	private Spookrijder wereld;
	private boolean aangeraakt = false;
	
	public Voertuig(Spookrijder wereld, Sprite sprite) {
		super(sprite);
		
		this.wereld=wereld;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		
		for ( GameObject object : collidedGameObjects ) {
			
			if ( object instanceof Speler ) {
				
				if ( ! this.aangeraakt ) {
					this.aangeraakt = true;
					
					System.out.println("botsing");
					
					break;
				}
				
			}
			
		}
		
	}

	@Override
	public void update() {
		
	}
	
	
}
