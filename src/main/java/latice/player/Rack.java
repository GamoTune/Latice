package latice.player;

import java.util.List;
import latice.tile.Tile;

public class Rack {
    private List<Tile> tiles;

    public Rack(List<Tile> tiles) {
        this.tiles = tiles;
    }
    
    public void addTile(Tile tile) {
        if (tile != null) {
            tiles.add(tile);
        }
    }

    public void displayRack() {
        System.out.println("Rack: ");
        for (Tile tile : tiles) {
            System.out.println(tile);
        }
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
