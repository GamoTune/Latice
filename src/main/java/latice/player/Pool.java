package latice.player;

import java.util.List;
import java.util.Random;
import latice.tile.Tile;

public class Pool {
    private List<Tile> tiles;

    public Pool(List<Tile> tiles) {
        this.tiles = tiles;
    }

    
    public Tile drawTile() {
        if (tiles.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return tiles.remove(rand.nextInt(tiles.size()));
        }

    
    public boolean isEmpty() {
        return tiles.isEmpty();
    }
}
