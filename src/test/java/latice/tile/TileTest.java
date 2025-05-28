package latice.tile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void testTileCreationReturnsCorrectColorAndShape() {
        Tile tile = new Tile(Color.GREEN, Shape.FLOWER);
        assertEquals("\u001B[32m", tile.getColor(), "La couleur doit être VERTE");
        assertEquals("🌼", tile.getShape(), "La forme doit être 🌼");
    }

    @Test
    void testToStringReturnsFormattedTile() {
        Tile tile = new Tile(Color.PINK, Shape.LIZARD);
        String expected = "\u001B[35m🦎\u001B[0m";
        assertEquals(expected, tile.toString(), "La méthode toString() doit retourner une tuile formatée correctement");
    }

    @Test
    void testToStringWithDifferentCombinations() {
        Tile tile1 = new Tile(Color.CYAN, Shape.FEATHER);
        assertEquals("\u001B[36m🪶\u001B[0m", tile1.toString());

        Tile tile2 = new Tile(Color.YELLOW, Shape.DOLPHIN);
        assertEquals("\u001B[33m🐬\u001B[0m", tile2.toString());

        Tile tile3 = new Tile(Color.RED, Shape.BIRD);
        assertEquals("\u001B[31m🦅\u001B[0m", tile3.toString());
    }
    
    @Test
    void testTileGetName() {
    	Tile tile = new Tile(Color.CYAN, Shape.FEATHER);
    	assertEquals("feather_cyan", tile.getName());
    }
}