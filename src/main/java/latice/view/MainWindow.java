package latice.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        PlayerRackPanel playerRackPanel = new PlayerRackPanel();

        
        BorderPane root = new BorderPane();
        root.setCenter(gameBoardPanel);
        root.setBottom(playerRackPanel);

        
        Scene scene = new Scene(root, 800, 900); 

        primaryStage.setTitle("Plateau de jeu Latice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}