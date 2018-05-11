package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class ZakGeld extends VerzamelObject {
	private final static Sprite zakgeldSprite = new Sprite("src/main/java/nl/han/ica/spookrijder/media/zakgeld.png");

	public ZakGeld(Spookrijder spookrijder) {
		super(spookrijder, zakgeldSprite);

		this.setHeight(40);
		this.setWidth(40);

		zakgeldSprite.resize((int) this.getWidth(), (int) this.getHeight());

		this.geluidsnaam = "Geld";
	}

}
