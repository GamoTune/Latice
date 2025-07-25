package latice.cell;

import latice.tile.Color;

public enum CellType {
	SUN (Color.YELLOW.getCode() + "☀️" + Color.RESET.getCode()),
	MOON (Color.WHITE.getCode() + "🌙" + Color.RESET.getCode()),
	NORMAL(Color.CYAN.getCode() + "🟦" + Color.RESET.getCode()),;

	private final String symbol;
	
	// Constructor to initialize the cell type
	CellType(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
}