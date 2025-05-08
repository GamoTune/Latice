package latice.view;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class PlayerRackPanel extends HBox {
    public PlayerRackPanel() {
        // Espacement entre les tuiles
        setSpacing(10);
        // Padding autour du rack
        setPadding(new Insets(10));
        // Style du fond avec une couleur boisée dégradée
        setStyle("-fx-background-color: linear-gradient(to bottom, #9b7f51, #6a4f2f);");
        
        // Centrer les éléments dans le HBox
        setAlignment(javafx.geometry.Pos.CENTER);
        
        // Réduire la largeur du rack en ajustant légèrement
        double rackWidth = (5 * 64) + (4 * 10); // Largeur des 5 tuiles et des 4 espacements
        setPrefWidth(rackWidth - 20); // Réduire la largeur totale pour être plus compact (par exemple, retirer 20px)
        
        for (int i = 0; i < 5; i++) {
            Image tileImage = new Image(getClass().getResource("/assets/bird_yellow.png").toExternalForm()); 
            ImageView tileView = new ImageView(tileImage);
            tileView.setFitWidth(64);
            tileView.setFitHeight(64);
            getChildren().add(tileView);
        }
    }
}
