package latice.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import latice.application.GameBoard;

public class MainWindow extends Application {
	
	static final int WIN_WIDTH = 800;
	static final int WIN_HEIGHT = 900;

    @Override
    public void start(Stage primaryStage) {
    	
    	GameBoard gameBoard = new GameBoard();
        
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        PlayerRackPanel playerRackPanel = new PlayerRackPanel();

        
        BorderPane root = new BorderPane();
        root.setCenter(gameBoardPanel);
        root.setBottom(playerRackPanel);

        
        Scene scene = new Scene(root, WIN_WIDTH, WIN_HEIGHT); 

        primaryStage.setTitle("Plateau de jeu Latice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}