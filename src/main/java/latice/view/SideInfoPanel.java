package latice.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SideInfoPanel extends VBox {
    private Label scoreLabel;
    private Label cardsLeftLabel;

    public SideInfoPanel(String playerName, int score, int cardsLeft) {
        // Set alignment, spacing, padding and fixed size for panel
        setAlignment(Pos.CENTER);
        setSpacing(18);
        setPadding(new Insets(32));
        setPrefSize(300, 300);
        setMaxSize(300, 300);
        setMinSize(300, 300);

        // Background color, rounded corners and border styling
        setStyle(
            "-fx-background-color: rgba(0,16,34,0.85);" +
            "-fx-background-radius: 24;" +
            "-fx-border-color: #00bfff;" +  // light sky blue border
            "-fx-border-width: 1.5;" +
            "-fx-border-radius: 24;"
        );
        setEffect(new DropShadow(18, Color.rgb(0, 0, 0, 0.7))); // subtle shadow effect

        // Player name label styling
        Label nameLabel = new Label(playerName);
        nameLabel.setFont(Font.font("Segoe UI", 38));
        nameLabel.setTextFill(Color.web("#ffffff"));
        nameLabel.setStyle("-fx-font-weight: bold;");

        // Score label styling
        scoreLabel = new Label("Points : " + score);
        scoreLabel.setFont(Font.font("Segoe UI", 28));
        scoreLabel.setTextFill(Color.web("#f8f8f8"));

        // Cards left label styling
        cardsLeftLabel = new Label("Cartes : " + cardsLeft);
        cardsLeftLabel.setFont(Font.font("Segoe UI", 28));
        cardsLeftLabel.setTextFill(Color.web("#f8f8f8"));

        // Add all labels to the panel
        getChildren().addAll(nameLabel, scoreLabel, cardsLeftLabel);
    }
}
