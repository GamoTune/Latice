package latice.gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;

class GameBoardTest {


    private Map<Position, Cell> cells;

    @BeforeEach
    void setUp() {
        new GameBoard();
        cells = GameBoard.getCells();
    }

    @Test
    void testCenterCellIsMoon() {
        Position center = new Position(4, 4);
        assertTrue(cells.containsKey(center), "The center position should exist in the cells map");
        assertEquals(CellType.MOON, cells.get(center).getType(), "The center cell should be of type MOON");
    }

    @Test
    void testSunCellsDiagonalsAndMiddles() {
        // Sun cells are located at the corners and diagonals of the board
        Position[] diagonals = {
            new Position(0, 0),
            new Position(8, 0),
            new Position(0, 8),
            new Position(8, 8),
            new Position(1, 1),
            new Position(7, 1),
            new Position(1, 7),
            new Position(7, 7),
            new Position(2, 2),
            new Position(6, 2),
            new Position(2, 6),
            new Position(6, 6)
        };

        // Middle cells are located at the sides of the board
        Position[] sides = {
            new Position(4, 0),
            new Position(4, 8),
            new Position(0, 4),
            new Position(8, 4)
        };

        for (Position pos : diagonals) {
            assertTrue(cells.containsKey(pos), "Diagonal position is missing : " + pos);
            assertEquals(CellType.SUN, cells.get(pos).getType(), "The cell at " + pos + " should be SUN");
        }

        for (Position pos : sides) {
            assertTrue(cells.containsKey(pos), "Middle position is missing : " + pos);
            assertEquals(CellType.SUN, cells.get(pos).getType(), "The cell at " + pos + " should be SUN");
        }
    }

    @Test
    void testTotalSpecialCells() {
        assertEquals(17, cells.size(), "The total number of special cells should be 17");
    }
}