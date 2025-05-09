package latice.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;
import latice.tile.Tile;

public class GameBoard {
	private HashMap<Position, Cell> cells;
	private HashMap<Position, Tile> tiles;
	public static final int ROWS = 9;
	public static final int COLS = 9;
	private final Integer MID_ROW = Math.round(ROWS / 2);
    private final Integer MID_COL = Math.round(COLS / 2);
	
	public GameBoard() {
		initializeBoard();
	}
	
	
	private void initializeBoard() {
		cells = new HashMap<Position, Cell>();
		tiles = new HashMap<Position, Tile>();
		
		// Initialize local variables
		final int GRID_PAD = 1; // Used to align cell positions on the grid of the game when ROWS or COLS are used.
		
		// Initialize the cells with SUN type
		// Diagonal cells
		for (int i = 0; i < 3; i++) {
				cells.put(new Position(i, i), new Cell(CellType.SUN));
				cells.put(new Position(ROWS - i - GRID_PAD, i), new Cell(CellType.SUN));
				cells.put(new Position(i, COLS - i - GRID_PAD), new Cell(CellType.SUN));
				cells.put(new Position(ROWS - i - GRID_PAD, COLS - i - GRID_PAD), new Cell(CellType.SUN));
		}
		
		// Middle cells
		cells.put(new Position(MID_ROW, 0), new Cell(CellType.SUN));
		cells.put(new Position(MID_ROW, COLS - GRID_PAD), new Cell(CellType.SUN));
		cells.put(new Position(0, MID_COL), new Cell(CellType.SUN));
		cells.put(new Position(ROWS - GRID_PAD, MID_COL), new Cell(CellType.SUN));
		
		
		// Initialize the cell with MOON type
		cells.put(new Position(Math.round(ROWS / 2), Math.round(COLS / 2)), new Cell(CellType.MOON));
		
	}
	
	public Map<Position, Cell> getCells() {
		return cells;
	}
}
