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

    private static final int RACK_WIDTH = 420;
    private static final int RACK_HEIGHT = 110;
    private static final int TILE_SIZE = 64;
    private static final int RACK_SIZE = 5;

    public PlayerRackPanel(Player player) {
        setSpacing(12);
        setPadding(new Insets(12, 12, 24, 12));
        setStyle(
            "-fx-background-color: linear-gradient(to bottom, #d8b46a, #a87f4a);" +
            "-fx-border-radius: 16;" +
            "-fx-background-radius: 16;" +
            "-fx-border-color: #654321;" +
            "-fx-border-width: 2;"
        );
        setEffect(new DropShadow(12, 4, 4, Color.rgb(0, 0, 0, 0.65)));
        setAlignment(Pos.CENTER);
        setMaxWidth(RACK_WIDTH);
        setPrefHeight(RACK_HEIGHT);

        displayRack(player);
        
    }
    
    
    public void clearRack() {
		getChildren().clear();
	}
    
    public void displayRack(Player player) {
    	getChildren().clear();
		
		// Loop through each tile in the player's rack
    	for (Tile tile: player.getRack().getTiles()) {
        	
        	TileView tileView = new TileView(tile);
            tileView.setFitWidth(TILE_SIZE);
            tileView.setFitHeight(TILE_SIZE);
            DropShadow dropShadow = new DropShadow(6, 3, 3, Color.rgb(0, 0, 0, 0.6));
            tileView.setEffect(dropShadow);
            DnDTileController.makeDraggable(tileView);
            tileView.setTranslateY(6);

            // Highlight on hover
            tileView.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                dropShadow.setRadius(12);
                dropShadow.setOffsetX(0);
                dropShadow.setOffsetY(0);
                dropShadow.setColor(Color.rgb(50, 150, 255, 0.9));
            });
            tileView.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                dropShadow.setRadius(6);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(3);
                dropShadow.setColor(Color.rgb(0, 0, 0, 0.6));
            });

            getChildren().add(tileView);
        }
    }

    // Remove all tiles from the rack
    public void clearRack() {
        getChildren().clear();
    }

    // Add a tile image to the rack (used for UI refresh or testing)
    public void addTile(Image tileImage) {
        if (getChildren().size() < RACK_SIZE) {
            ImageView tileView = new ImageView(tileImage);
            tileView.setFitWidth(TILE_SIZE);
            tileView.setFitHeight(TILE_SIZE);
            DropShadow dropShadow = new DropShadow(6, 3, 3, Color.rgb(0, 0, 0, 0.6));
            tileView.setEffect(dropShadow);
            tileView.setTranslateY(6);

            tileView.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                dropShadow.setRadius(12);
                dropShadow.setOffsetX(0);
                dropShadow.setOffsetY(0);
                dropShadow.setColor(Color.rgb(50, 150, 255, 0.9));
            });
            tileView.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                dropShadow.setRadius(6);
                dropShadow.setOffsetX(3);
                dropShadow.setOffsetY(3);
                dropShadow.setColor(Color.rgb(0, 0, 0, 0.6));
            });

            getChildren().add(tileView);
        }
    }
    
    
}
