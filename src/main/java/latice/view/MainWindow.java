package latice.view;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import latice.console.Console;
import latice.controller.Referee;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load and configure background image
        URL imageUrl = getClass().getResource("/assets/Oceanbackground.png");
        if (imageUrl == null) {
            Console.printError("Background image not found!");
            return;
        }
        Image backgroundImage = new Image(imageUrl.toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(false);
        backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());
        backgroundImageView.setEffect(new GaussianBlur(30));

        // Initialize game components
        Referee referee = new Referee();
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        PlayerRackPanel playerRackPanel = new PlayerRackPanel(referee.players.get(0));

        // TODO: Remplacer "Joueur 1", 10 et 5 par les vraies données dynamiques du joueur 1
        SideInfoPanel sideInfoPlayer1 = new SideInfoPanel("Joueur 1", 10, 5);

        // TODO: Remplacer "Joueur 2", 8 et 3 par les vraies données dynamiques du joueur 2
        SideInfoPanel sideInfoPlayer2 = new SideInfoPanel("Joueur 2", 8, 3);

        // Instancier la pioche
        PoolView poolView = new PoolView();
        poolView.setPrefSize(50, 50);

        // Label joueur actuel
        // TODO: Remplacer "Player 1" par le nom dynamique du joueur courant
        Label currentPlayerLabel = new Label("Player 1");
        currentPlayerLabel.setStyle(
            "-fx-font-size: 24px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;" +
            "-fx-effect: dropshadow(gaussian, black, 4, 0.5, 1, 1);"
        );
        currentPlayerLabel.setAlignment(Pos.CENTER);

        // Largeur fixe pour la pioche + espace vide à droite
        double sideWidth = 90; // ajuste selon la taille de ta pioche + marges

        // Conteneur gauche : pioche avec largeur fixe, padding réduit à droite pour décaler vers la gauche
        VBox leftBox = new VBox(poolView);
        leftBox.setPrefWidth(sideWidth);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        leftBox.setPadding(new Insets(0, 40, 0, 20)); // réduit la marge à droite (40 au lieu de 80)

        // Conteneur droite : espace vide pour équilibrer la largeur, même largeur que la gauche
        Region rightSpacer = new Region();
        rightSpacer.setPrefWidth(sideWidth);

        // Conteneur central : le rack avec label
        VBox rackWithLabel = new VBox(25, currentPlayerLabel, playerRackPanel);
        rackWithLabel.setAlignment(Pos.TOP_CENTER);

        // Conteneur horizontal global pour bottomContent avec padding modifié
        HBox bottomContent = new HBox();
        bottomContent.setPadding(new Insets(10, 130, 40, 0)); // padding droite = 40, gauche = 0, décale vers la gauche
        bottomContent.setAlignment(Pos.CENTER);
        bottomContent.getChildren().addAll(leftBox, rackWithLabel, rightSpacer);
        bottomContent.setSpacing(0);

        // Construction de la racine principale
        BorderPane root = new BorderPane();

        root.setTop(null);

        HBox boardWrapper = new HBox(gameBoardPanel);
        boardWrapper.setAlignment(Pos.CENTER);
        root.setCenter(boardWrapper);

        root.setBottom(bottomContent);

        StackPane leftStack = new StackPane(sideInfoPlayer1);
        leftStack.setPrefWidth(300);
        leftStack.setAlignment(Pos.CENTER);
        BorderPane.setMargin(leftStack, new Insets(0, 10, 0, 140));
        root.setLeft(leftStack);

        StackPane rightStack = new StackPane(sideInfoPlayer2);
        rightStack.setPrefWidth(300);
        rightStack.setAlignment(Pos.CENTER);
        BorderPane.setMargin(rightStack, new Insets(0, 140, 0, 10));
        root.setRight(rightStack);

        StackPane mainContainer = new StackPane(backgroundImageView, root);

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
