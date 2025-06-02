package latice.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import latice.player.Player;
import latice.tile.Tile;
import latice.view.controller.DnDTileController;

public class PlayerRackPanel extends HBox {
	
	private static final int RACK_WIDTH = 400; // Width of the rack
	private static final int RACK_HEIGHT = 100; // Height of the rack
	private static final int TILE_SIZE = 64; // Size of each tile
	private static final int RACK_SIZE = 5; // Number of tiles in the rack
	
	
    public PlayerRackPanel(Player player) {
        setSpacing(10);
        
        // Add padding around the entire rack
        setPadding(new Insets(10, 10, 22, 10)); // Top, Right, Bottom, Left padding
        
        setStyle("-fx-background-color: linear-gradient(to bottom, #D1A15A, #A87F4A); " +
                 "-fx-border-radius: 15; " +
                 "-fx-background-radius: 15;");
        setEffect(new DropShadow(10, 4, 4, Color.BLACK));
        
        setAlignment(Pos.CENTER);
        setMaxWidth(RACK_WIDTH);
        setPrefWidth(RACK_HEIGHT);

        for (Tile tile: player.getRack().getTiles()) {
        	
        	TileView tileView = new TileView(tile);
            tileView.setFitWidth(TILE_SIZE);
            tileView.setFitHeight(TILE_SIZE);
            tileView.setEffect(new DropShadow(5, 2, 2, Color.rgb(0, 0, 0, 0.5))); // Add shadow effect to the tile
            
            // Make the tile draggable
            DnDTileController.makeDraggable(tileView);

            tileView.setTranslateY(5);
            getChildren().add(tileView);
        }
    }
    
    
    public void clearRack() {
		getChildren().clear();
	}
    
    
    public void addTile(Image tileImage) {
		if (getChildren().size() < RACK_SIZE) {
			ImageView tileView = new ImageView(tileImage);
			tileView.setFitWidth(TILE_SIZE);
			tileView.setFitHeight(TILE_SIZE);
			tileView.setEffect(new DropShadow(5, 2, 2, Color.rgb(0, 0, 0, 0.5))); // Add shadow effect to the tile

			tileView.setTranslateY(5);
			getChildren().add(tileView);
		}
	}
    
    
}
