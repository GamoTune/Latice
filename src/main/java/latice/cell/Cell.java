package latice.cell;

import latice.tile.Tile;

public class Cell {
	private final CellType type;
	private Tile tile;
	
	public Cell(CellType type) {
		this.type = type;
	}
	
	public CellType getType() {
		return type;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public String getName() {
		return type.getName();
	}
}
