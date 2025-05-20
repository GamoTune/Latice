package latice.cell;

import latice.tile.Tile;
import latice.tile.Color;
import latice.tile.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testGetTypeNormal() {
        Cell cell = new Cell(CellType.NORMAL);
        assertEquals(CellType.NORMAL, cell.getType());
    }


    @Test
    public void testSetAndGetTile() {
        Tile tile = new Tile(Color.RED, Shape.TURTLE);
        Cell cell = new Cell(CellType.NORMAL);
        
        cell.setTile(tile);
        
        assertNotNull(cell.getTile(), "Tile should not be null after setting it");
        assertEquals(tile, cell.getTile(), "Tile returned should be the same as the one set");
        assertEquals(Color.RED.getCode(), cell.getTile().getColor());
        assertEquals(Shape.TURTLE.getShape(), cell.getTile().getShape());
    }
}