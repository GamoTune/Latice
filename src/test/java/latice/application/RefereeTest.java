package latice.application;

import latice.player.Player;
import latice.player.Pool;
import latice.player.Rack;
import latice.tile.Color;
import latice.tile.Shape;
import latice.tile.Tile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RefereeTest {

    private Player player1;
    private Player player2;
    private Referee referee;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Alice");
        player2 = new Player("Bob");
        referee = new Referee(List.of(player1, player2));
    }

    @Test
    public void testDrawAddsFiveTilesToRack() {
    	 // Create a pool with more than 5 tiles
        List<Tile> tiles = new ArrayList<>();
        for (Color color : Color.values()) {
            if (color != Color.RESET && color != Color.WHITE) {
                for (Shape shape : Shape.values()) {
                    tiles.add(new Tile(color, shape));
                }
            }
        }

        Pool pool = new Pool(new ArrayList<>(tiles));
        Rack rack = new Rack();

        // Draw 5 tiles
        referee.draw(rack, pool);

        assertEquals(5, rack.getTiles().size());
        assertEquals(tiles.size() - 5, pool.size());
    }

    @Test
    public void testCreatePlayerPoolDistributesTiles() {
        referee.createPlayerPool();

        Pool pool1 = player1.getPool();
        Pool pool2 = player2.getPool();

        assertNotNull(pool1);
        assertNotNull(pool2);

        // 6 shapes x 6 colors (excluding RESET and WHITE) x 2 copies = 72 tiles
        int expectedTotalTiles = 6 * 6 * 2;
        int expectedTilesPerPlayer = expectedTotalTiles / 2;

        assertEquals(expectedTilesPerPlayer, pool1.size());
        assertEquals(expectedTilesPerPlayer, pool2.size());
    }
}
