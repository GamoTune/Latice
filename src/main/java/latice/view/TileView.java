package latice.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import latice.tile.Tile;

public class TileView extends ImageView{
	
	private final Tile tile;

	
	public TileView(Tile tile) {
		this.tile = tile;
		Image tileImage = new Image(getClass().getResource("/assets/"+tile.getName()+".png").toExternalForm());
		setImage(tileImage);
	}
	
	
	public Tile getTile() {
		return tile;
	}
	
	public String getTileName() {
		return tile.getName();
	}
	
	
	
}
