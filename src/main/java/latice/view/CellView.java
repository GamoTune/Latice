package latice.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import latice.cell.Cell;

public class CellView extends ImageView {
	
	private final Cell cell;
	
	
	public CellView(Cell cell) {
		this.cell = cell;
		Image cellImage = new Image(getClass().getResource("/assets/bg_" + cell.getName() + ".png").toExternalForm());
		setImage(cellImage);
	}
	
	public Cell getCell() {
		return cell;
	}
	
	public void setTile(TileView tileView) {
		 cell.setTile(tileView.getTile());
		 
	}
	
	

}
