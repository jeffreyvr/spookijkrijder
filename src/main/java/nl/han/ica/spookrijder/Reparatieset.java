package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Reparatieset extends VerzamelObject {
	private final static Sprite reparatiesetSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/reparatieset.png");
	
	public Reparatieset(Spookrijder spookrijder) {
		super(spookrijder, reparatiesetSprite);
	
		this.setHeight(40);
		this.setWidth(40);
		
		reparatiesetSprite.resize((int) this.getWidth(), (int) this.getHeight());
		
		this.geluidsnaam = "Reparatie";
	}
}
