package nl.han.ica.spookrijder;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Speler extends Voertuig implements ICollidableWithGameObjects {
	private Spookrijder spookrijder;
	private int hoogte = 50;
	private int breedte = 118;
	private int huidige_baan = 1;
	private static Sprite spelerSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/car.png");
	private Sound crash;
	private int status = 100; // health
	private int geld = 0;
	
	public Speler(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		this.spookrijder=spookrijder;
		spelerSprite.resize(breedte,hoogte);
	}
	
	public Speler(Spookrijder spookrijder) {
		this(                      
			spookrijder, 
			spelerSprite
		);
		
		setxSpeed(0);
	}
	
	public float getWidth() {
		return this.breedte;
	}
	
	public void setHuidigeBaan(int baan) {
		this.huidige_baan = baan;
	}
	
	public int getHuidigeBaan() {
		return this.huidige_baan;
	}
	
	public void setStatus(int status) {
		System.out.println("Schade update: " + status);
		this.status = status;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setGeld(int geld) {
		System.out.println("Geld update: " + geld);
		this.geld = geld;
	}
	
	public int getGeld() {
		return this.geld;
	}
	
	@Override
    public void keyPressed(int keyCode, char key) {
		String keyName = ( keyCode == 40 ? "down" : "up" );
		boolean verander = false;
		
		if ( keyName == "up" ) {
			
			if ( this.getHuidigeBaan() > 0 ) {
				verander=true;
				this.setHuidigeBaan( this.getHuidigeBaan() - 1 );
			}
			
		} else if ( keyName == "down" ) {
			
			if ( this.getHuidigeBaan() < spookrijder.banen.length - 1 ) {
				verander=true;
				this.setHuidigeBaan( this.getHuidigeBaan() + 1 );
			}
			
		}
		
		if ( verander ) {
			this.setY( spookrijder.banen[this.getHuidigeBaan()]-this.getHeight()/2);
		}
    }
	
	@Override
	public float getHeight() {
		return this.hoogte;
	}
	
	public void crashSound() {
        this.crash = new Sound(spookrijder, "src/main/java/nl/han/ica/spookrijder/media/crash.mp3");
        //this.crash.play();
    }
	
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for ( GameObject object : collidedGameObjects ) {
			
			if ( object instanceof Voertuig && ((Voertuig) object).getAangeraakt() == false ) {
				if ( object instanceof Auto ) {
					spookrijder.speler.setStatus( spookrijder.speler.getStatus() - 20 );
				} else if ( object instanceof Motor ) {
					spookrijder.speler.setStatus( spookrijder.speler.getStatus() - 10 );
				} else if ( object instanceof Vrachtwagen ) {
					spookrijder.speler.setStatus( spookrijder.speler.getStatus() - 40 );
				}
				
				spookrijder.speler.crashSound();
				((Voertuig) object).setAangeraakt(true);
			
			} else if ( object instanceof VerzamelObject && ((VerzamelObject) object).getAangeraakt() == false ) {
				
				if ( object instanceof ZakGeld ) {
					spookrijder.speler.setGeld( spookrijder.speler.getGeld() + 10 );
				} else if ( object instanceof Reparatieset ) {
					spookrijder.speler.setStatus( 100 );
				}
				
				((VerzamelObject) object).setVisible(false);
				((VerzamelObject) object).setAangeraakt(true);
			}
			
		}
		
	}
}
