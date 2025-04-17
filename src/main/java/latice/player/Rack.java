package latice.player;

import java.util.List;

import latice.tile.Tile;

public class Rack {
    private List<Tile> tiles;

    public Rack(List tiles) {
        this.tiles = tiles;
    }

    public List get_Tiles() {
        return tiles;
    }


}
