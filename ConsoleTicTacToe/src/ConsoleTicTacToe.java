import java.util.Scanner;

public class ConsoleTicTacToe {
		
	private static final String TITLE = "Console TicTacToe";
	
	private Scanner scanner;
	private GameEngine game;
	
	private boolean running = false;
	private boolean drawing = false;
	
	private Integer tempRow;
	private Integer tempColumn;
	
	public ConsoleTicTacToe() {
		this.game = new GameEngine();
		this.scanner = new Scanner(System.in);
		this.resetTempVariables();
	}	
	
	public void play() {
		
		this.running = true;
		this.drawing = false;
		
		do {
			if(!drawing) {
				System.out.println("Player " + this.game.getCurrentPlayer() + " is in line.");
				System.out.println("Pick a ROW (1-3) and confirm with ENTER.");
			} else {
				System.out.println("Pick a COLUMN (1-3) and confirm with ENTER.");
			}
			String input = scanner.next();
			if(!InteractionHelpers.isInteger(input)) {
				if(this.drawing) {
					this.drawing = false;
					System.out.println("Draw canceled.");
				}
				if(input.equalsIgnoreCase("/exit")) {
					running = false;
					break;
				}
				else if(input.equalsIgnoreCase("/h") || input.equalsIgnoreCase("/help")) System.out.println(this.getHelp());
				else if(input.equalsIgnoreCase("/r") || input.equalsIgnoreCase("/rules")) System.out.println(this.getRules());
				else System.out.println(input + " is no defined command. ");
			} else {
				if(!InteractionHelpers.isInValidRange(input, 1, 3)) System.out.println(input + " is not in valid range between 1 and 3!");
				
				if(!this.drawing) {
					this.drawing = true;
					this.tempRow = Integer.parseInt(input);
				} else {
					this.tempColumn = Integer.parseInt(input);
					System.out.println("Player " + this.game.getCurrentPlayer() + " takes " + this.tempRow + ":" + this.tempColumn + "!");
					this.game.executreDraw(
							InteractionHelpers.translateHumanCoordinateToComputerReadable(this.tempRow), 
							InteractionHelpers.translateHumanCoordinateToComputerReadable(this.tempColumn)
					);
					this.game.printBoard();
					this.drawing = false;
					this.resetTempVariables();
				}
				
			}
		} while(running);
		
	}


	private void resetTempVariables() {
		this.tempRow = null;
		this.tempColumn = null;
	}
	
	private String getRules() {
		String output = "\n" + TITLE + " :: Rules\n";
			  output += "1. Players will draw alternating. Starting with X. \n";
			  output += "2. Player mark fields with their sign and will be asked for row and column as separate coordinates. \n";
			  output += "3. Player with three fields in a row wins.\n";
		return output;
	}
	
	private String getHelp() {
		String output = "\n" + TITLE + " :: Help\n";
		  output += "/exit - exit the game \n";
		  output += "/rules - display the rules\n";
		return output;
	}
}
