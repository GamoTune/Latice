package latice.view;

import java.util.Map;

import javafx.stage.Screen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import latice.application.GameBoard;
import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;

public class GameBoardPanel extends Pane {
    private static final double GRID_SIZE = GameBoard.ROWS;
    private static final double CELL_SIZE = 64;
    
    private Image background;
    private Image cellImage;
    private Image sunCellImage;
    private Image centerCellImage;

    private Canvas canvas;

    public GameBoardPanel() {
        background = new Image(getClass().getResource("/assets/OceanBackground.png").toExternalForm());
        cellImage = new Image(getClass().getResource("/assets/bg_sea.png").toExternalForm());
        sunCellImage = new Image(getClass().getResource("/assets/bg_sun.png").toExternalForm());
        centerCellImage = new Image(getClass().getResource("/assets/bg_moon.png").toExternalForm());

        ImageView bgView = new ImageView(background);
        bgView.setFitWidth(Screen.getPrimary().getBounds().getWidth());
        bgView.setFitHeight(Screen.getPrimary().getBounds().getHeight());
        bgView.setEffect(new GaussianBlur(25)); 

        canvas = new Canvas(Screen.getPrimary().getBounds().getWidth(),
                            Screen.getPrimary().getBounds().getHeight());

        getChildren().addAll(bgView, canvas);
        drawBoard();
    }

    private static final double Y_OFFSET = -50;

    private void drawBoard() {
        Map<Position, Cell> cells = GameBoard.getCells();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double startX = (canvas.getWidth() - (GRID_SIZE * CELL_SIZE)) / 2;
        double startY = (canvas.getHeight() - (GRID_SIZE * CELL_SIZE)) / 2 + Y_OFFSET;
        double gridWidth = GRID_SIZE * CELL_SIZE;
        double gridHeight = GRID_SIZE * CELL_SIZE;

        gc.applyEffect(new DropShadow(5, 2, 2, Color.rgb(0, 0, 0, 0.5))); 
        gc.setFill(Color.rgb(0, 0, 0, 0.45)); 
        gc.fillRect(startX - 6, startY - 6, gridWidth + 12, gridHeight + 12);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                double x = startX + col * CELL_SIZE;
                double y = startY + row * CELL_SIZE;
                Position pos = new Position(row, col);

                if (cells.containsKey(pos)) {
                    Cell cell = cells.get(pos);
                    if (cell.getType() == CellType.MOON) {
                        gc.drawImage(centerCellImage, x, y, CELL_SIZE, CELL_SIZE);
                    } else if (cell.getType() == CellType.SUN) {
                        gc.drawImage(sunCellImage, x, y, CELL_SIZE, CELL_SIZE);
                    } else {
                        gc.drawImage(cellImage, x, y, CELL_SIZE, CELL_SIZE);
                    }
                } else {
                    gc.drawImage(cellImage, x, y, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }
}
