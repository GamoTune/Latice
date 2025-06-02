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
        setAlignment(Pos.CENTER);
        setSpacing(15);
        setPadding(new Insets(30));
        setPrefSize(300, 300);
        setMaxSize(300, 300);
        setMinSize(300, 300);
        setStyle("-fx-background-color: rgba(0,16,34,0.8); -fx-background-radius: 20;");
        setEffect(new DropShadow(12, Color.BLACK));

        Label nameLabel = new Label(playerName);
        nameLabel.setFont(Font.font("Calibri", 36));
        nameLabel.setTextFill(Color.WHITE);

        scoreLabel = new Label("Points : " + score);
        scoreLabel.setFont(Font.font("Calibri", 30));
        scoreLabel.setTextFill(Color.WHITE);

        cardsLeftLabel = new Label("Cartes : " + cardsLeft);
        cardsLeftLabel.setFont(Font.font("Calibri", 30));
        cardsLeftLabel.setTextFill(Color.WHITE);

        getChildren().addAll(nameLabel, scoreLabel, cardsLeftLabel);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Points : " + score);
    }

    public void updateCardsLeft(int cardsLeft) {
        cardsLeftLabel.setText("Cartes : " + cardsLeft);
    }
}
