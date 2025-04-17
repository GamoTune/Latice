package latice.application;


public class LaticeApplicationConsole {

	public static void main(String[] args) {

	}
	
	// This class is used to print messages to the console
    public static class Console {
    	public static void print(String message) {
			System.out.print(message);
		}

		public static void println(String message) {
			System.out.println(message);
		}

		public static void printError(String message) {
			System.err.println(message);
		}
    }

}
