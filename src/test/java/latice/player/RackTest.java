package latice.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.tile.Color;
import latice.tile.Shape;
import latice.tile.Tile;

class RackTest {

    private Tile tile1;
    private Tile tile2;
    private Rack emptyRack;
    private Rack prefilledRack;

    @BeforeEach
    void setUp() {
        tile1 = new Tile(Color.RED, Shape.BIRD);
        tile2 = new Tile(Color.BLUE, Shape.DOLPHIN);

        emptyRack = new Rack();
        prefilledRack = new Rack(Arrays.asList(tile1, tile2));
    }

    @Test
    void testEmptyRackInitialization() {
        assertNotNull(emptyRack.getTiles());
        assertTrue(emptyRack.getTiles().isEmpty());
    }

    @Test
    void testPrefilledRackInitialization() {
        List<Tile> tiles = prefilledRack.getTiles();
        assertEquals(2, tiles.size());
        assertTrue(tiles.contains(tile1));
        assertTrue(tiles.contains(tile2));
    }

    @Test
    void testAddTile() {
        emptyRack.addTile(tile1);
        List<Tile> tiles = emptyRack.getTiles();
        assertEquals(1, tiles.size());
        assertEquals(tile1, tiles.get(0));
    }

    @Test
    void testAddNullTileDoesNotCrash() {
        emptyRack.addTile(null);
        assertTrue(emptyRack.getTiles().isEmpty());
    }
}