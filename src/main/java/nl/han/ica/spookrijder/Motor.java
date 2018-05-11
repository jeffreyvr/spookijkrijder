package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Motor extends Voertuig {
	private final static Sprite motorSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/motor.png");
	
	public Motor(Spookrijder spookrijder) {
		super(spookrijder, motorSprite);
		
		this.setHeight(40);
		this.setWidth(73);
		
		motorSprite.resize((int) this.getWidth(), (int) this.getHeight());
		
		setxSpeed(-6);
		
		this.geluidsnaam = "Motor";
		this.doetSchade = 10;
	}
	
}
