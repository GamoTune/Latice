package latice.application;

import java.util.ArrayList;
import java.util.Map;

import latice.cell.Cell;
import latice.cell.CellType;
import latice.cell.Position;
import latice.player.Player;
import latice.player.Pool;
import latice.player.Rack;

public class LaticeApplicationConsole {

	private static GameBoard gameboard;
	
	public static void main(String[] args) {
		Console.title("Latice Game");
		
		Console.println("Welcome to Latice!");
		
		Console.println("This is a console version of the game.");
		
		gameboard = new GameBoard();
		
		Console.println("Gameboard initialized.");
		
		Console.println("Gameboard cells:");
		Console.printBoard(gameboard.getCells());
	}
	
	
	// This class is used to print a String to the console
    public static class Console {
    	
    	//Function to print a message without a newline
    	public static void print(Object obj) {
			System.out.print(obj);
		}

    	//Function to print a message with a newline
		public static void println(Object obj) {
			System.out.println(obj);
		}

		//Function to print an Error with a newline
		public static void printError(Object obj) {
			System.err.println(obj);
		}
		
		public static void title (String title) {
			println("========================================");
			println("  "+title);
			println("========================================");
		}
		
		public static void printRack(Rack rack) {
			for (int i = 0; i < 5; i++) {
				
				print("|");
				
				if (i < rack.getTiles().size()) {
					print("  "+rack.getTiles().get(i).toString()+"  ");
				} else {
					print(" ");
				}
			}
			
			println("|");
		
		}
		
		public static void printPool(Pool pool) {
			for (int i = 0; i < pool.size(); i++) {
				print("|");
				
				print("  "+pool.getTile(i).toString()+"  ");
				
			}
			println("|");
		}
		
		public static void printBoard(Map<Position,Cell> board) {
			for (int i = 0; i < GameBoard.ROWS; i++) {
				
				for (int j = 0; j < GameBoard.COLS; j++) {
					
					Cell cell = board.get(new Position(i, j));
					
					
					if (cell != null) {
						
						if (cell.getTile() != null) {
							print(cell.getTile().toString());
						} else {
							print(cell.getType().getSymbol());
						}
					} else {
						print(CellType.NORMAL.getSymbol());
					}
					print(" ");
				}
				println("");
			}
  	
		}
    }

}
