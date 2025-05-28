package latice.application;

import latice.player.Player;
import latice.player.Pool;
import latice.player.Rack;
import latice.tile.Color;
import latice.tile.Shape;
import latice.tile.Tile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    public void setUp() {
        referee = new Referee();
    }
    
    
    @Test
    public void testGameBoardInitialization() {
		assertNotNull(referee.getGameBoard(), "Game board should be initialized");
	}

    @Test
    public void testDrawAddsFiveTilesToRack() {
        // Create a pool with more than 5 tiles
        List<Tile> tiles = new ArrayList<>();
        for (Color color : Color.values()) {
            if (color != Color.RESET && color != Color.WHITE) {
                for (Shape shape : Shape.values()) {
                    tiles.add(new Tile(color, shape));
                    tiles.add(new Tile(color, shape)); // Add two copies of each tile
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

        for (Player player : referee.players) {
            Pool pool = player.getPool();
            assertNotNull(pool);

            // 6 shapes x 6 colors (excluding RESET and WHITE) x 2 copies = 72 tiles
            int expectedTotalTiles = 6 * 6 * 2;
            int expectedTilesPerPlayer = expectedTotalTiles / 2;

            assertEquals(expectedTilesPerPlayer, pool.size());
        }
    }
    
    // This test verifies that the choosePlayer method selects a player randomly from the list of players.    
    @Test
    public void testChoosePlayer() {
        List<Player> players = referee.players;

        assertFalse(players.isEmpty(), "The list of players should not be empty");

        Player chosenPlayer = referee.choosePlayer();

        assertNotNull(chosenPlayer, "The chosen player should not be null");
        assertTrue(players.contains(chosenPlayer), "The chosen player should be part of the list of players");
    }
}
