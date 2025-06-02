package latice.view.controller;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.TransferMode;
import latice.console.Console;
import latice.gameboard.GameBoard;
import javafx.scene.transform.Scale;
import latice.view.CellView;
import latice.view.GameBoardPanel;
import latice.view.TileView;
import javafx.scene.paint.Color;

public class DnDTileController {

    private DnDTileController() {
        // Private constructor to prevent instantiation
    }

    private static TileView draggedTileView = null;

    public static void makeDraggable(TileView tileView) {
        tileView.setOnDragDetected(event -> {
            draggedTileView = tileView;

            // Démarre l’opération drag-and-drop avec transfert MOVE
            var db = tileView.startDragAndDrop(TransferMode.MOVE);

            // === PRENDRE UN SNAPSHOT REDIMENSIONNÉ POUR L’APERÇU DE DRAG ===
            WritableImage originalSnapshot = tileView.snapshot(null, null);

            // Taille max souhaitée pour l’image de drag (en px)
            final double maxDragSize = 80;

            // Calcul de l’échelle pour garder le ratio de la tuile
            double scaleX = maxDragSize / originalSnapshot.getWidth();
            double scaleY = maxDragSize / originalSnapshot.getHeight();
            double scale = Math.min(scaleX, scaleY);

            // Paramètres pour snapshot avec transformation scale
            SnapshotParameters params = new SnapshotParameters();
            params.setTransform(new Scale(scale, scale));
            params.setFill(Color.TRANSPARENT);

            // Image redimensionnée (vide au départ)
            WritableImage resizedSnapshot = new WritableImage(
                (int) (originalSnapshot.getWidth() * scale),
                (int) (originalSnapshot.getHeight() * scale)
            );

            // Re-snapshot la tuile avec mise à l’échelle
            resizedSnapshot = tileView.snapshot(params, resizedSnapshot);

            // Définit l’image drag view, centrée sur la souris
            db.setDragView(resizedSnapshot, resizedSnapshot.getWidth() / 2, resizedSnapshot.getHeight() / 2);

            // Contenu du drag (requis même si pas utilisé)
            ClipboardContent content = new ClipboardContent();
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
            // TODO: nettoyer ou actions post drag ici si besoin
            event.consume();
        });
    }
}
