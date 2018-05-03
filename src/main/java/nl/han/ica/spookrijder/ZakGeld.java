package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class ZakGeld extends VerzamelObject {
	private int hoogte = 40;
	private int breedte = 40;
	private static Sprite zakgeldSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/zakgeld.png");
	
	public ZakGeld(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		zakgeldSprite.resize(breedte,hoogte);
		
		this.setHeight(hoogte);
		this.setWidth(breedte);
	}
	
	public ZakGeld(Spookrijder spookrijder) {
		this(
			spookrijder, 
			zakgeldSprite
		);
	}

}
