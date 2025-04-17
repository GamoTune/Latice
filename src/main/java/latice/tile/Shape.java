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

	// Enum constants for different shapes
	private final String form;

	// Constructor to initialize the shape
	Shape(String shape) {
		this.form = shape;
	}
	
	// Method to get the shape
	public String getShape() {
		return form;
	}
}
