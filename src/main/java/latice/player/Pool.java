package latice.player;

import java.util.List;

import latice.tile.Tile;

public class Pool {
    private List<Tile> tiles;

    public Pool(int id, List<Tile> tiles) {
        this.tiles = tiles;
    }
}
