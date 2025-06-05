package latice.view;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import latice.console.Console;
import latice.controller.Referee;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load background video
        URL videoUrl = getClass().getResource("/assets/bg_video.mp4");
        if (videoUrl == null) {
            Console.printError("Background video not found!");
            return;
        }
        Media backgroundMedia = new Media(videoUrl.toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(backgroundMedia);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);

        MediaView backgroundMediaView = new MediaView(mediaPlayer);
        backgroundMediaView.setPreserveRatio(false);
        backgroundMediaView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundMediaView.fitHeightProperty().bind(primaryStage.heightProperty());
        backgroundMediaView.setEffect(new GaussianBlur(10)); // Apply blur effect to background

        // Initialize game components
        Referee referee = new Referee();
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        PlayerRackPanel playerRackPanel = new PlayerRackPanel(referee.players.get(0));

        SideInfoPanel sideInfoPlayer1 = new SideInfoPanel("Joueur 1", 10, 5);
        SideInfoPanel sideInfoPlayer2 = new SideInfoPanel("Joueur 2", 8, 3);

        // Current player label styling
        Label currentPlayerLabel = new Label("Player 1");
        currentPlayerLabel.setStyle(
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;" +
            "-fx-effect: dropshadow(gaussian, black, 4, 0.5, 1, 1);"
        );
        currentPlayerLabel.setAlignment(Pos.CENTER);

        // Container for player's rack, centered vertically
        VBox rackContainer = new VBox(playerRackPanel);
        rackContainer.setAlignment(Pos.CENTER);

        // Container combining player label and rack
        VBox rackWithLabel = new VBox(25, currentPlayerLabel, rackContainer);
        rackWithLabel.setAlignment(Pos.TOP_CENTER);

        // "End Turn" button with styling and hover effects
        Button endTurnButton = new Button("Fin de Tour");
        endTurnButton.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-color: linear-gradient(to bottom, #f2c94c, #c98b00);" +
            "-fx-text-fill: white;" +
            "-fx-background-radius: 24;" +
            "-fx-border-radius: 24;" +
            "-fx-border-color: #fff59d;" +
            "-fx-border-width: 2;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 10, 0, 0, 4);" +
            "-fx-cursor: hand;"
        );
        endTurnButton.setPrefWidth(140);
        endTurnButton.setPrefHeight(60);

        endTurnButton.setOnMouseEntered(e -> {
            endTurnButton.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-color: linear-gradient(to bottom, #f2d44f, #d9a400);" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 24;" +
                "-fx-border-radius: 24;" +
                "-fx-border-color: #fff59d;" +
                "-fx-border-width: 2;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 14, 0, 0, 6);" +
                "-fx-cursor: hand;"
            );
        });
        endTurnButton.setOnMouseExited(e -> {
            endTurnButton.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-color: linear-gradient(to bottom, #f2c94c, #c98b00);" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 24;" +
                "-fx-border-radius: 24;" +
                "-fx-border-color: #fff59d;" +
                "-fx-border-width: 2;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 10, 0, 0, 4);" +
                "-fx-cursor: hand;"
            );
        });

        // Horizontal container for rack + button, vertically centered
        HBox rackAndButton = new HBox(20, rackWithLabel, endTurnButton);
        rackAndButton.setAlignment(Pos.CENTER);

        // Adjust vertical position of the "End Turn" button
        HBox.setMargin(endTurnButton, new Insets(55, 0, 0, 0));

        // Bottom section container with padding to shift content right
        HBox bottomContent = new HBox(rackAndButton);
        bottomContent.setPadding(new Insets(0, 130, 170, 300)); // Left padding increased to shift right
        bottomContent.setAlignment(Pos.CENTER);

        // Main layout setup
        BorderPane root = new BorderPane();

        HBox boardWrapper = new HBox(gameBoardPanel);
        boardWrapper.setAlignment(Pos.CENTER);
        root.setCenter(boardWrapper);
        root.setBottom(bottomContent);

        // Left side panel setup
        StackPane leftStack = new StackPane(sideInfoPlayer1);
        leftStack.setPrefWidth(300);
        leftStack.setAlignment(Pos.CENTER);
        BorderPane.setMargin(leftStack, new Insets(0, 10, 0, 140));
        root.setLeft(leftStack);

        // Right side panel setup
        StackPane rightStack = new StackPane(sideInfoPlayer2);
        rightStack.setPrefWidth(300);
        rightStack.setAlignment(Pos.CENTER);
        BorderPane.setMargin(rightStack, new Insets(0, 140, 0, 10));
        root.setRight(rightStack);

        // Stack background video behind main UI
        StackPane mainContainer = new StackPane(backgroundMediaView, root);

        Scene scene = new Scene(mainContainer);
        primaryStage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Plateau de jeu Latice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
