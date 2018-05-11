package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Vrachtwagen extends Voertuig {
	private final static Sprite vrachtwagenSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/truck.png");
	
	public Vrachtwagen(Spookrijder spookrijder) {
		super(spookrijder, vrachtwagenSprite);
		
		this.setHeight(75);
		this.setWidth(182);
		
		vrachtwagenSprite.resize((int) this.getWidth(), (int) this.getHeight());
		
		setxSpeed(-4);
		
		this.geluidsnaam = "Vrachtwagen";
		this.doetSchade = 40;
	}
	
}