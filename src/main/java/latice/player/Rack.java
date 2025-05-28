package latice.player;

import java.util.List;

import latice.console.Console;
import latice.tile.Tile;

public class Rack {
    private List<Tile> tiles;

    public Rack() {
		this.tiles = new java.util.ArrayList<>();
	}
    
    public Rack(List<Tile> tiles) {
        this.tiles = tiles;
    }
    
    public void addTile(Tile tile) {
        if (tile != null) {
            tiles.add(tile);
        }
    }

    public void displayRack() {
        Console.printRack(this);
        
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
