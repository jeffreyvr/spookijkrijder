package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Vrachtwagen extends Voertuig {
	private int hoogte = 75;
	private int breedte = 182;
	private static Sprite vrachtwagenSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/truck.png");
	
	public Vrachtwagen(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		
		vrachtwagenSprite.resize(breedte,hoogte);
		
		this.setHeight(hoogte);
		this.setWidth(breedte);
	}
	
	public Vrachtwagen(Spookrijder spookrijder) {
		this(
			spookrijder, 
			vrachtwagenSprite
		);
		
		setxSpeed(-4);
	}
	
}