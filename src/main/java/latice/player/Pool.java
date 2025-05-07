package latice.player;

import java.util.Collections;
import java.util.List;
import latice.tile.Tile;

public class Pool {
    private List<Tile> tiles;

    public Pool(List<Tile> tiles) {
        this.tiles = tiles;
        Collections.shuffle(this.tiles);
    }

    public Tile drawTile() {
        if (tiles.isEmpty()) {
            return null;
        }
        return tiles.remove(0);
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

	public int size() {
		return tiles.size();
	}
}