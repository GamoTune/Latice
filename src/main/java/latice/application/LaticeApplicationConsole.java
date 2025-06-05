package latice.application;

import latice.cell.Position;
import latice.console.Console;
import latice.controller.Referee;
import latice.gameboard.GameBoard;
import latice.view.MainWindow;



public class LaticeApplicationConsole {

	
	public static void main(String[] args) {
		Console.title("Latice Game");
		
		Console.println("Welcome to Latice!");
		
		Console.println("Choose your game mode:");
		Console.println("1. Console");
		Console.println("2. GUI");
		
		String choice = "";
		Boolean isValide = false;
		
		// Loop until the user enters a valid choice
		while (Boolean.TRUE.equals(isValide) == false) {
			choice = Console.ask("Enter your choice (1 or 2): ");
			
			if (choice.equals("1")) {
				isValide = true;
				Console.println("You chose Console mode.");
				Console.println("Starting game in console mode...");
				
				// Start the console game
				startConsoleGame();
				
				
			} else if (choice.equals("2")) {
				isValide = true;
				Console.println("You chose GUI mode.");
				Console.println("Starting game in GUI mode...");
				
				// Start the GUI game
				MainWindow.main(args);
			} else {
				Console.printError("Invalid choice. Please enter 1 or 2.");
			}
		}

	}
	
	
	private static void startConsoleGame() {
		
		// Initialize the referee
		Referee referee = new Referee();
		
		
		Console.title("Latice Game - Console Mode");
		
		Console.println("Game started in console mode.");
		
		
		// Start the game loop
		boolean gameRunning = true;
		
		int playerTileIndex = -1; // Index of the tile the player wants to place
		
		String playerMove = "";
		while (gameRunning) {
			// Print the current game state
			Console.printBoard(GameBoard.getCells());
			
			// Ask the player for the tile they want to place
			Console.printRack(referee.players.get(0).getRack());
			try {
				playerTileIndex = Integer.parseInt(Console.ask("Enter the index of the tile you want to place (1 to " + referee.players.get(0).getRack().getTiles().size() + "): "));
			} catch (NumberFormatException e) {
				Console.printError("Invalid input. Please enter a valid index.");
				continue; // Skip to the next iteration if input is invalid
			}
			
		
			// Ask the player for their move
			playerMove = Console.ask("Enter your move (e.g., '11 ; 42 ; 36'), or type 'exit' to quit the game: ");
			
			if (playerMove.equalsIgnoreCase("exit")) {
				Console.println("Exiting the game. Goodbye!");
				gameRunning = false;
			} else if (playerMove.isEmpty()) {
				Console.printError("Move cannot be empty. Please try again.");
			} else {
				// Process the player's move
				int x = playerMove.charAt(0) - '0'; // Convert char to int
				int y = playerMove.charAt(1) - '0';
				Console.println("Placing tile at position: (" + x + ", " + y + ")");
				Position movePosition = new Position(x - 1, y - 1);
				
				// Try to place the tile
				try {
					GameBoard.setTile(movePosition, referee.players.get(0).getRack().getTiles().get(playerTileIndex - 1));
				} catch (IllegalArgumentException e) {
					Console.printError("Error placing tile: " + e.getMessage());
					continue; // Skip to the next iteration if placement fails
				}
			}
			
		}
	}

}
