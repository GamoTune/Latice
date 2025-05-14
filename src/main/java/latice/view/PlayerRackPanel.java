package latice.view;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class PlayerRackPanel extends HBox {
    public PlayerRackPanel() {
        // Spacing between tiles
        setSpacing(10);
        
        // Padding around the rack
        setPadding(new Insets(10));
        
        // Background color and gradient
        setStyle("-fx-background-color: linear-gradient(to bottom, #9b7f51, #6a4f2f);");
        
        // Center the rack in the window
        setAlignment(javafx.geometry.Pos.CENTER);
        
        // Reduce the width of the rack
        double rackWidth = (5 * 64) + (4 * 10);
        setPrefWidth(rackWidth - 20);
        
        for (int i = 0; i < 5; i++) {
            Image tileImage = new Image(getClass().getResource("/assets/bird_yellow.png").toExternalForm()); 
            ImageView tileView = new ImageView(tileImage);
            tileView.setFitWidth(64);
            tileView.setFitHeight(64);
            getChildren().add(tileView);
        }
    }
}
