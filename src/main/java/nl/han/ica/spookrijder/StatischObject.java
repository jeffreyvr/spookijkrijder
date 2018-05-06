package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class StatischObject extends SpriteObject {
	private Spookrijder spookrijder;
	
	StatischObject(Spookrijder wereld, Sprite sprite) {
		super(sprite);
		
		this.spookrijder=spookrijder;
	}
	
	
}
