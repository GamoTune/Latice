package latice.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import latice.application.GameBoard;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameBoard gameBoard = new GameBoard();
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        PlayerRackPanel playerRackPanel = new PlayerRackPanel();

        BorderPane root = new BorderPane();

        HBox boardWrapper = new HBox();
        boardWrapper.setAlignment(Pos.CENTER);
        boardWrapper.getChildren().add(gameBoardPanel);
        root.setCenter(boardWrapper);

        HBox rackWrapper = new HBox();
        rackWrapper.setAlignment(Pos.CENTER);
        rackWrapper.getChildren().add(playerRackPanel);
        root.setBottom(rackWrapper);

        
        BorderPane.setMargin(rackWrapper, new Insets(0, 0, 25, 0));

        Scene scene = new Scene(root);

        
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
