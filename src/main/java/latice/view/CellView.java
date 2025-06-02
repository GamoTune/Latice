package latice.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import latice.cell.Cell;

public class CellView extends ImageView {
	
	private final Cell cell;
	private final String pathToImage;
	
	
	public CellView(Cell cell) {
		this.cell = cell;
		if (cell.getTile() != null) {
			pathToImage = cell.getTile().getName();
		} else {
			pathToImage = "bg_" + cell.getName();
		}
		Image cellImage = new Image(getClass().getResource("/assets/"+ pathToImage +".png").toExternalForm());
		setImage(cellImage);
	}
	
	public Cell getCell() {
		return cell;
	}
	
	

}
