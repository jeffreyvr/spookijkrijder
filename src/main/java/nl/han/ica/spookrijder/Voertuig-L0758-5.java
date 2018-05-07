package nl.han.ica.spookrijder;

import java.util.List;
import java.util.Vector;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Voertuig extends SpriteObject {
	private Spookrijder spookrijder;
	private boolean aangeraakt = false;
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
		
		for ( GameObject object : spookrijder.getGameObjectItems() ) {
			
			if ( object == this ) break;
			
			if ( ! ( object instanceof Voertuig) ) break; 
			
			if ( object instanceof Speler ) break;
			
			System.out.println(object + ": " + this.getX() + " - " + object.getX() + " - " + object.getxSpeed());

			
			/*
			if ( object.getY() == this.getY() ) {
				System.out.println(object + ": " + this.getX() + " - " + object.getX() + " - " + object.getxSpeed());

				if ( ! ( object instanceof Voertuig) ) break; 
				if ( object instanceof Speler ) break;
				
				if ( this.getX() - object.getX() < 200 ) {
					//System.out.println(this.getX());
					//System.out.println(object.getX());
					
					if ( object instanceof Motor ) {
						System.out.println(object + ": " + this.getX() + " - " + object.getX() + " - " + object.getxSpeed());
					}
					
					object.setxSpeed(-4);
				}
				
			}
			*/
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
