package latice.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameBoardPanel extends Pane {
    private static final int GRID_SIZE = 9;
    private static final int CELL_SIZE = 64;

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
        bgView.setFitWidth(800);
        bgView.setFitHeight(800);
        bgView.setEffect(new GaussianBlur(25)); 

	        
	        canvas = new Canvas(800, 800);

        
        getChildren().addAll(bgView, canvas);

        
        drawBoard();
    }

    private void drawBoard() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        
        double startX = (canvas.getWidth() - (GRID_SIZE * CELL_SIZE)) / 2;
        double startY = (canvas.getHeight() - (GRID_SIZE * CELL_SIZE)) / 2;
        double gridWidth = GRID_SIZE * CELL_SIZE;
        double gridHeight = GRID_SIZE * CELL_SIZE;

        
        gc.applyEffect(new javafx.scene.effect.DropShadow(5, 2, 2, javafx.scene.paint.Color.rgb(0, 0, 0, 0.5))); 
        gc.setFill(javafx.scene.paint.Color.rgb(0, 0, 0, 0.45)); 
        gc.fillRect(startX - 6, startY - 6, gridWidth + 12, gridHeight + 12); 

        
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                double x = startX + col * CELL_SIZE;
                double y = startY + row * CELL_SIZE;

                if (isSunCell(row, col)) {
                    gc.drawImage(sunCellImage, x, y, CELL_SIZE, CELL_SIZE);
                } else if (isCenterCell(row, col)) {
                    gc.drawImage(centerCellImage, x, y, CELL_SIZE, CELL_SIZE);
                } else {
                    gc.drawImage(cellImage, x, y, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    private boolean isSunCell(int row, int col) {
        return
            (row == 0 && col == 0) || 
            (row == 4 && col == 0) || 
            (row == 8 && col == 0) || 
            (row == 1 && col == 1) || 
            (row == 7 && col == 1) || 
            (row == 2 && col == 2) || 
            (row == 6 && col == 2) || 
            (row == 0 && col == 4) || 
            (row == 8 && col == 4) || 
            (row == 2 && col == 6) || 
            (row == 6 && col == 6) || 
            (row == 1 && col == 7) || 
            (row == 7 && col == 7) || 
            (row == 0 && col == 8) || 
            (row == 4 && col == 8) || 
            (row == 8 && col == 8);   
    }

    private boolean isCenterCell(int row, int col) {
        return row == GRID_SIZE / 2 && col == GRID_SIZE / 2;
    }
}
