package latice.application;

import java.util.HashMap;

import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;
import latice.tile.Tile;

public class GameBoard {
	private HashMap<Position, Cell> cells;
	private HashMap<Position, Tile> tiles;
	private final int ROWS = 9;
	private final int COLS = 9;
	
	public GameBoard() {
		initializeBoard();
	}
	
	private void initializeBoard() {
		cells = new HashMap<Position, Cell>();
		tiles = new HashMap<>();
		
		// Initialize the cells with SUN type
		for (int row = 0; row < 3; row++) {
				cells.put(new Position(row, row), new Cell(CellType.SUN));
				cells.put(new Position(ROWS - row, row), new Cell(CellType.SUN));
				cells.put(new Position(row, COLS - row), new Cell(CellType.SUN));
				cells.put(new Position(ROWS - row, COLS - row), new Cell(CellType.SUN));
		}
		
		// Initialize the tiles with MOON type
		cells.put(new Position(Math.round(ROWS / 2), Math.round(COLS / 2)), new Cell(CellType.MOON));
		
	}
}
