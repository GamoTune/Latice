package latice.view;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class PlayerRackPanel extends HBox {
    public PlayerRackPanel() {
        setSpacing(10);
        // Ajout d'une marge en bas avec Insets(top, right, bottom, left)
        setPadding(new Insets(10, 10, 30, 10)); 
        setStyle("-fx-background-color: linear-gradient(to bottom, #D1A15A, #A87F4A); " +
                 "-fx-border-radius: 15; " +
                 "-fx-background-radius: 15;");
        setEffect(new DropShadow(10, 4, 4, Color.BLACK));
        setAlignment(Pos.CENTER);
        setMaxWidth((5 * 64) + (4 * 10) + 40);
        setPrefWidth((5 * 64) + (4 * 10));

        for (int i = 0; i < 5; i++) {
            Image tileImage = new Image(getClass().getResource("/assets/bird_yellow.png").toExternalForm());
            ImageView tileView = new ImageView(tileImage);
            tileView.setFitWidth(64);
            tileView.setFitHeight(64);
            tileView.setEffect(new DropShadow(5, 2, 2, Color.rgb(0, 0, 0, 0.5)));

            tileView.setTranslateY(5);
            getChildren().add(tileView);
        }
    }
}
