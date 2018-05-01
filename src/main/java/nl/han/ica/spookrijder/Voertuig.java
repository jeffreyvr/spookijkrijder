package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Voertuig extends SpriteObject {
	private Spookrijder spookrijder;
	public boolean aangeraakt = false;
	private int hoogte;
	private int breedte;
	
	public Voertuig(Spookrijder spookrijder, Sprite sprite) {
		super(sprite);
		
		this.spookrijder=spookrijder;
	}

	@Override
	public void update() {
		if ( this.getX() < ( 0 - this.getWidth() ) ) {
			this.setX( spookrijder.getWidth() + this.getWidth() );
	        this.setAangeraakt(false);
	    }
	}
	
	public void setAangeraakt( boolean aangeraakt ) {
		this.aangeraakt = aangeraakt;
	}
	
	public boolean getAangeraakt() {
		return this.aangeraakt;
	}
	
	public float getHeight() {
		return this.hoogte;
	}
	
	public float getWidth() {
		return this.breedte;
	}
	
	public void setHeight(int hoogte) {
		this.hoogte = hoogte;
	}
	
	public void setWidth(int breedte) {
		this.breedte = breedte;
	}
}
