package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class VerzamelObject extends SpriteObject {
	private boolean aangeraakt = false;
	private Spookrijder spookrijder;
	private int breedte;
	private int hoogte;
	
	public VerzamelObject(Spookrijder spookrijder, Sprite sprite) {
		super(sprite);
		this.spookrijder=spookrijder;
		
		setxSpeed(-3);
	}
	
	public void update() {
		if ( this.getX() < ( 0 - this.getWidth() ) ) {
			this.setX( spookrijder.getWidth() + this.getWidth() );
	        this.setAangeraakt(false);
	        this.setVisible(true);
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
