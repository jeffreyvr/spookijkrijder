package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Reparatieset extends VerzamelObject {
	private int hoogte = 40;
	private int breedte = 40;
	private static Sprite reparatiesetSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/reparatieset.png");
	
	public Reparatieset(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		reparatiesetSprite.resize(breedte,hoogte);
		
		this.setHeight(hoogte);
		this.setWidth(breedte);
	}
	
	public Reparatieset(Spookrijder spookrijder) {
		this(
			spookrijder, 
			reparatiesetSprite
		);
	}

}
