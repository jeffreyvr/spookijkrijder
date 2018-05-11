package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Auto extends Voertuig {
	private final static Sprite autoSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/audi.png");

	public Auto(Spookrijder spookrijder) {
		super(spookrijder, autoSprite);

		this.setHeight(50);
		this.setWidth(118);

		autoSprite.resize((int) this.getWidth(), (int) this.getHeight());
		
		setxSpeed(-5);

		this.geluidsnaam = "Auto";
		this.doetSchade = 20;
	}
}
