package latice.view.controller;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.TransferMode;
import latice.console.Console;
import latice.gameboard.GameBoard;
import latice.view.CellView;
import latice.view.GameBoardPanel;
import latice.view.TileView;

public class DnDTileController {
	
	private DnDTileController() {
		// Private constructor to prevent instantiation
	}

    private static TileView draggedTileView = null;

    public static void makeDraggable(TileView tileView) {
        tileView.setOnDragDetected(event -> {
            draggedTileView = tileView;

            // Start the drag-and-drop operation
            var db = tileView.startDragAndDrop(TransferMode.MOVE);

            // Create a drag view (a snapshot of the tile)
            var snapshot = tileView.snapshot(null, null);
            db.setDragView(snapshot, snapshot.getWidth() / 2, snapshot.getHeight() / 2);

            // Set the drag content (not used here, but required)
            var content = new ClipboardContent();
            content.putString("tile");
            db.setContent(content);

            event.consume();
        });
    }

    public static void makeDroppable(CellView targetView) {
        targetView.setOnDragOver(event -> {
            if (event.getGestureSource() != targetView && draggedTileView != null) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        targetView.setOnDragEntered(event -> {
            if (event.getGestureSource() != targetView && draggedTileView != null) {
                targetView.setOpacity(0.5);
            }
            event.consume();
        });

        targetView.setOnDragExited(event -> {
            targetView.setOpacity(1.0);
            event.consume();
        });

        targetView.setOnDragDropped(event -> {
            if (draggedTileView != null) {
            	try {
            		GameBoard.setTile(targetView.getCell().getPosition(), draggedTileView.getTile());
            		GameBoardPanel.drawBoard(); // Redraw the board to reflect the new tile placement
            		event.setDropCompleted(true);
            	} catch (Exception e) {
            		Console.printError("Failed to place tile: " + e.getMessage());
            		event.setDropCompleted(false);
            	}
                draggedTileView = null;
            } else {
                event.setDropCompleted(false);
            }
            event.consume();
        });

        targetView.setOnDragDone(event -> {
            //TODO: Handle any cleanup after the drag is done
            event.consume();
        });
    }
}