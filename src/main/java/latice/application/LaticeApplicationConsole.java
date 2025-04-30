package latice.application;

import latice.player.Rack;

public class LaticeApplicationConsole {

	public static void main(String[] args) {
		
		
	}
	
	// This class is used to print a String to the console
    public static class Console {
    	
    	//Function to print a message without a newline
    	public static void print(String message) {
			System.out.print(message);
		}

    	//Function to print a message with a newline
		public static void println(String message) {
			System.out.println(message);
		}

		//Function to print an Error with a newline
		public static void printError(String message) {
			System.err.println(message);
		}
		
		public static void printRack(Rack rack) {
			println("|-----|-----|-----|-----|-----|");
			for (int i = 0; i < 5; i++) {
				
				print("|");
				
				if (i < rack.getTiles().size()) {
					print("  "+rack.getTiles().get(i).toString()+"  ");
				} else {
					print("     ");
				}
			}
			println("|");
			println("|-----|-----|-----|-----|-----|");
		}
    }

}
