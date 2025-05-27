package latice.view;

import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import latice.application.GameBoard;
import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;

public class GameBoardPanel extends StackPane {
    private static final int GRID_SIZE = GameBoard.ROWS;
    private static final double CELL_SIZE = 64;
    private static final double Y_OFFSET = -30;

    private Image cellImage;
    private Image sunCellImage;
    private Image centerCellImage;

    private GridPane grid;

    public GameBoardPanel() {
        cellImage = new Image(getClass().getResource("/assets/bg_sea.png").toExternalForm());
        sunCellImage = new Image(getClass().getResource("/assets/bg_sun.png").toExternalForm());
        centerCellImage = new Image(getClass().getResource("/assets/bg_moon.png").toExternalForm());

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(0);
        grid.setHgap(0);
        grid.setTranslateY(Y_OFFSET);

        // Set the size of the grid
        setPadding(new Insets(60, 0, 0, 0)); // top, right, bottom, left

        drawBoard();

        getChildren().add(grid);
    }

    private void drawBoard() {
    	// Clear the grid and redraw the cells
        Map<Position, Cell> cells = GameBoard.getCells();
        grid.getChildren().clear();

        // Loop through each cell in the grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Position pos = new Position(row, col);
                Image img = cellImage;

                // Check if the cell exists in the game board
                // and set the appropriate image based on its type
                if (cells.containsKey(pos)) {
                    Cell cell = cells.get(pos);
                    if (cell.getType() == CellType.MOON) {
                        img = centerCellImage;
                    } else if (cell.getType() == CellType.SUN) {
                        img = sunCellImage;
                    }
                }

                // Create an ImageView for the cell image
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(CELL_SIZE);
                imageView.setFitHeight(CELL_SIZE);

                
                StackPane cellPane = new StackPane(imageView);
                cellPane.setPrefSize(CELL_SIZE, CELL_SIZE);
                grid.add(cellPane, col, row);
            }
        }
    }
}
