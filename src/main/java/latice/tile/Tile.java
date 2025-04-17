package latice.tile;


public class Tile {
	private Color color;
	private Shape shape;
	
	
	public Tile(Color color, Shape shape) {
		this.color = color;
		this.shape = shape;
	}
	
	
	//Methods to get the color and shape of the tile
	public Color getColor() {
		return color;
	}
	
	// Method to get the shape of the tile
	public Shape getShape() {
		return shape;
	}

}
