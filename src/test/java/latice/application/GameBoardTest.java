package latice.application;

import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    private GameBoard gameBoard;
    private Map<Position, Cell> cells;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard();
        cells = GameBoard.getCells();
    }

    @Test
    void testCenterCellIsMoon() {
        Position center = new Position(4, 4); // 9x9 board → milieu = (4,4)
        assertTrue(cells.containsKey(center), "La cellule centrale doit exister");
        assertEquals(CellType.MOON, cells.get(center).getType(), "La cellule centrale doit être de type MOON");
    }

    @Test
    void testSunCellsDiagonalsAndMiddles() {
        // Coins diagonaux
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

        // Cellules médianes (au centre de chaque côté)
        Position[] sides = {
            new Position(4, 0),
            new Position(4, 8),
            new Position(0, 4),
            new Position(8, 4)
        };

        for (Position pos : diagonals) {
            assertTrue(cells.containsKey(pos), "Position diagonale manquante : " + pos);
            assertEquals(CellType.SUN, cells.get(pos).getType(), "La cellule en " + pos + " devrait être SUN");
        }

        for (Position pos : sides) {
            assertTrue(cells.containsKey(pos), "Position médiane manquante : " + pos);
            assertEquals(CellType.SUN, cells.get(pos).getType(), "La cellule en " + pos + " devrait être SUN");
        }
    }

    @Test
    void testTotalSpecialCells() {
        // 12 diagonales + 4 médianes + 1 centre = 17
        assertEquals(17, cells.size(), "Il doit y avoir 17 cellules spéciales (SUN + MOON)");
    }
}