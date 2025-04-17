package latice.tile;

public enum Shape{
	BIRD("🦅"),
	DOLPHIN("🐬"),
	FEATHER("🪶"),
	FLOWER("🌼"),
	LIZARD("🦎"),
	TURTLE("🐢"),
	SUN("☀️"),
	MOON("🌙"),
	SEA("🟦");

	private final String form;

	Shape(String shape) {
		this.form = shape;
	}
	
	public String getShape() {
		return form;
	}
}
