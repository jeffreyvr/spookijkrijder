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
	protected int oorspronkelijke_snelheid;
	
	public Voertuig(Spookrijder spookrijder, Sprite sprite) {
		super(sprite);
		
		this.spookrijder=spookrijder;
	}

	@Override
	public void update() {
		if ( this.getX() < ( 0 - this.getWidth() ) ) {
			this.setX( spookrijder.getWidth() + this.getWidth() );
	        this.setAangeraakt(false);
	        System.out.println("Snelheid: "+this.oorspronkelijke_snelheid);
	        this.setxSpeed(this.oorspronkelijke_snelheid);
	    }
		
		//GameObject huidig_voertuig = this;
		
		for ( GameObject object : spookrijder.getGameObjectItems() ) {
			
			if ( object instanceof Speler || this instanceof Speler ) continue;
			
			if ( object instanceof VerzamelObject || object instanceof Wereld ) continue;
			
			if ( this == object ) continue;
			
			//System.out.println("Object: "+object+" | This: " + this + " | Y:" + this.getY() + " - " + object.getY() );
			
			//System.out.println(this.getX() + " -- " + object.getX());
			
			if ( (object.getY() + object.getHeight()/2) == (this.getY() + this.getHeight()/2) ) {
				
				System.out.println( (object.getY() + object.getHeight()/2) + " -- " + (this.getY() + this.getHeight()/2));
				
				if ( ( this.getX() - object.getX() ) < 200 ) {
					
					//System.out.println(this.getX() - object.getX());
					
					object.setxSpeed(-4);
					
					object.setX( (object.getX() + object.getWidth()) + 200 );
										
					System.out.println(this.getX() + " -- " + object.getX());
					
				}
			}
			
			
			/*
			if ( object == huidig_voertuig ) continue;
			
			if ( !(object instanceof Voertuig) ) continue; 
			
			if ( object instanceof Speler ) continue;
			
			System.out.println(object + ": " + this.getX() + " - " + object.getX() + " - " + object.getxSpeed());

			if ( object.getY() == huidig_voertuig.getY() ) {
				System.out.println(huidig_voertuig.getY() + " -- " + object.getY());
				
				if ( huidig_voertuig.getX() - object.getX() < 200 ) {
					System.out.println(object + ": " + huidig_voertuig.getX() + " - " + object.getX() + " - " + object.getxSpeed());
					
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
