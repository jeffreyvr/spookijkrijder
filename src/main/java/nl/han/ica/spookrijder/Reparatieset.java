package nl.han.ica.spookrijder;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Reparatieset extends VerzamelObject {
	private Spookrijder spookrijder;
	private int hoogte = 40;
	private int breedte = 40;
	
	public Reparatieset(Spookrijder spookrijder, Sprite sprite) {
		super(spookrijder, sprite);
		this.spookrijder=spookrijder;
		sprite.resize(breedte,hoogte);
	}
	
	public Reparatieset(Spookrijder spookrijder) {
		this(
			spookrijder, 
			new Sprite("src/main/java/nl/han/ica/spookrijder/media/reparatieset.png")
		);
	}

	@Override
	public void update() {
	}

}
