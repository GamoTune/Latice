package latice.application;

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
		
		// Print the initial game board
		Console.printBoard(GameBoard.getCells());
		
		
		// Print the first player's rack
		Console.println("Player 1's Rack:");
		Console.printRack(referee.players.get(0).getRack());
	}

}
