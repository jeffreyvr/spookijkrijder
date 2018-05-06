package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Voertuig extends SpriteObject implements ICollidableWithGameObjects {
	private Spookrijder spookrijder;
	public boolean aangeraakt = false;
	
	public Voertuig(Spookrijder wereld, Sprite sprite) {
		super(sprite);
		
		this.spookrijder=spookrijder;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		
		for ( GameObject object : collidedGameObjects ) {
			
			if ( object instanceof Speler ) {
				
				if ( ! this.aangeraakt ) {
					this.aangeraakt = true;
					
					//System.out.println("botsing");
					((Speler) object).crashSound();
					((Speler) object).setStatus( ((Speler) object).getStatus() - 50 );
					
					System.out.println("Botsing, status: " + ((Speler) object).getStatus());
					
					break;
				}
				
			} 
			
		}
		
	}

	@Override
	public void update() {
		
	}
	
}
