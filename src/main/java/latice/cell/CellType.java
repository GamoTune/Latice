package latice.cell;

public enum CellType {
	SUN ("☀️"),
	MOON ("🌙"),
	NORMAL("🟦");

	private final String symbol;
	
	// Constructor to initialize the cell type
	CellType(String symbol) {
		this.symbol = symbol;
	}
}