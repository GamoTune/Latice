package latice.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;

public class PoolView extends StackPane {

    private ImageView imageView;
    private Label tileCountLabel;
    private DropShadow labelShadow;

    public PoolView() {
        URL imageUrl = getClass().getResource("/assets/pool.png");
        if (imageUrl == null) {
            System.err.println("Image de la pioche introuvable !");
            return;
        }

        Image image = new Image(imageUrl.toExternalForm());
        imageView = new ImageView(image);

        imageView.setPreserveRatio(true);
        imageView.setFitHeight(250);

        tileCountLabel = new Label("0"); // TODO: Remplacer "0" par la donnée dynamique réelle
        tileCountLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 50));
        tileCountLabel.setTextFill(Color.WHITE);
        tileCountLabel.setStyle(
            "-fx-stroke: white;" +
            "-fx-stroke-width: 2;"
        );

        labelShadow = new DropShadow();
        labelShadow.setColor(Color.rgb(0, 0, 0, 0.9));
        labelShadow.setRadius(6);
        labelShadow.setSpread(0.7);
        tileCountLabel.setEffect(labelShadow);

        StackPane.setAlignment(tileCountLabel, Pos.CENTER);

        getChildren().addAll(imageView, tileCountLabel);
    }

    public void setFitHeight(double height) {
        if (imageView != null) {
            imageView.setFitHeight(height);
        }
    }

    public void setTileCount(int count) {
        if (tileCountLabel != null) {
            tileCountLabel.setText(String.valueOf(count));
        }
    }
}
