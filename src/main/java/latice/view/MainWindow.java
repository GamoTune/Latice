package latice.view;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import latice.application.GameBoard;
import latice.application.LaticeApplicationConsole.Console;
import latice.application.Referee;

public class MainWindow extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Load background image
		URL imageUrl = getClass().getResource("/assets/Oceanbackground.png");
		if (imageUrl == null) {
			Console.printError("L'image n'a pas été trouvée !");
			return;
		}

		
		// Create an ImageView for the background image
		Image backgroundImage = new Image(imageUrl.toExternalForm());
		ImageView backgroundImageView = new ImageView(backgroundImage);

		backgroundImageView.setPreserveRatio(false);
		backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
		backgroundImageView.fitHeightProperty().bind(primaryStage.heightProperty());

		
		// Add a blur effect to the background image
		backgroundImageView.setEffect(new GaussianBlur(30));

		
		// Create a new referee
		
		Referee referee = new Referee();
		
		GameBoard gameBoard = new GameBoard();
		GameBoardPanel gameBoardPanel = new GameBoardPanel();
		
		PlayerRackPanel playerRackPanel = new PlayerRackPanel(referee.players.get(0));

		// Initialize the game board and player rack panels
		BorderPane root = new BorderPane();

		
		// Set the game board and player rack panels in the layout
		HBox boardWrapper = new HBox(gameBoardPanel);
		boardWrapper.setAlignment(Pos.CENTER);
		root.setCenter(boardWrapper);

		HBox rackWrapper = new HBox(playerRackPanel);
		rackWrapper.setAlignment(Pos.CENTER);
		BorderPane.setMargin(rackWrapper, new Insets(20, 0, 40, 0));
		root.setBottom(rackWrapper);

        
		// Set the background image view as the root of the scene
        StackPane mainContainer = new StackPane(backgroundImageView, root);

		Scene scene = new Scene(mainContainer);

		// Set the scene to the primary stage
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