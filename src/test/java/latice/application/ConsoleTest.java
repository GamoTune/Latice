package latice.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;
import latice.player.Pool;
import latice.player.Rack;
import latice.tile.Color;
import latice.tile.Shape;
import latice.tile.Tile;

class ConsoleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
        outContent.reset();
        errContent.reset();
    }

    @Test
    void testPrint() {
        LaticeApplicationConsole.Console.print("Test");
        assertEquals("Test", outContent.toString());
    }

    @Test
    void testPrintln() {
        LaticeApplicationConsole.Console.println("Hello");
        assertEquals("Hello" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testPrintError() {
        LaticeApplicationConsole.Console.printError("Error message");
        assertEquals("Error message" + System.lineSeparator(), errContent.toString());
    }

    @Test
    void testAsk() {
        String simulatedInput = "response\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String result = LaticeApplicationConsole.Console.ask("Enter: ");
        assertEquals("response", result);
        assertTrue(outContent.toString().startsWith("Enter: "));
    }

    @Test
    void testTitle() {
        LaticeApplicationConsole.Console.title("Latice");
        String expected = 
            "========================================" + System.lineSeparator() +
            "  Latice" + System.lineSeparator() +
            "========================================" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPrintRack() {
        Rack rack = new Rack();
        rack.addTile(new Tile(Color.RED, Shape.BIRD));
        rack.addTile(new Tile(Color.GREEN, Shape.DOLPHIN));

        LaticeApplicationConsole.Console.printRack(rack);
        String output = outContent.toString();
        assertTrue(output.contains("🦅"));
        assertTrue(output.contains("🐬"));
        assertTrue(output.contains("|"));
    }

    @Test
    void testPrintPool() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(Color.BLUE, Shape.TURTLE));
        tiles.add(new Tile(Color.YELLOW, Shape.FLOWER));
        Pool pool = new Pool(tiles);

        LaticeApplicationConsole.Console.printPool(pool);
        String output = outContent.toString();
        assertTrue(output.contains("🐢"));
        assertTrue(output.contains("🌼"));
    }

    @Test
    void testPrintBoard() {
        GameBoard board = new GameBoard();  // initialise les cellules avec SUN et MOON
        Map<Position, Cell> cells = GameBoard.getCells();
        LaticeApplicationConsole.Console.printBoard(cells);
        String output = outContent.toString();
        assertTrue(output.contains(CellType.SUN.getSymbol()) || output.contains(CellType.MOON.getSymbol()));
    }
}