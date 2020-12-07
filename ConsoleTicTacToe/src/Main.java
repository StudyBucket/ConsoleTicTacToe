
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ConsoleTicTacToe game = new ConsoleTicTacToe();
	
		Scanner scanner = new Scanner(System.in);
		
		String currentPlayer = "X";
		
		boolean isInDraw = false;
		Integer determinedRow = null;
		Integer determinedColumn = null;
		
		do {
			if(!isInDraw) {
				System.out.println(game.printBoardToConsole());
				System.out.println("[Game] Enter a row for " + currentPlayer + " or /exit: ");
			} else {
				if(determinedRow == null) {
					System.out.println("[Game] Please enter a row between 1 and 3: ");
				}
				if(determinedRow != null && determinedColumn == null) {
					System.out.println("[Game] Please enter a column between 1 and 3: ");
				}
			}
			
			String input = scanner.next();
			
			if(input.equalsIgnoreCase("/exit")) break;
			
			if(determinedRow == null) {
				if(isInteger(input) && isInValidRange(input)) {
					determinedRow = Integer.parseInt(input);
					isInDraw = true;
					continue;
				} else {
					System.out.println("[Game] Only Integer inputs between 1 and 3 allowed! Please try again or /exit: ");
				}
			}
			
			if(isInDraw && determinedRow != null && determinedColumn == null) {
				if(isInteger(input) && isInValidRange(input)) {
					determinedColumn = Integer.parseInt(input);
					game.executeDraw(
							translateHumanCoordinateToComputerReadable(determinedRow),  
							translateHumanCoordinateToComputerReadable(determinedColumn), 
							currentPlayer);
					
					// reset
					determinedRow = null;
					determinedColumn = null;
					isInDraw = false;
					
					if(game.hasWinner()) {
						System.out.println(game.printBoardToConsole() + "\n" + currentPlayer +" wins!");
						break;
					}
					
					currentPlayer = swapCurrentPlayer(currentPlayer);
					continue;
					
				} else {
					System.out.println("[Game] Only Integer inputs between 1 and 3 allowed! Please try again or /exit: ");
				}
			}
			
		}while(true);
		System.out.println("Bye!");
	}
	
	private static boolean isInteger(String string) {
	    if (string == null) {
	        return false;
	    }
	    try {
	        Integer value = Integer.parseInt(string);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	private static boolean isInValidRange(String string) {
		Integer value = Integer.parseInt(string);
		if(value < 1) return false;
		if(value > 3) return false;
	    return true;
	}
	
	
	private static Integer translateHumanCoordinateToComputerReadable(Integer value){
		return value - 1;
	}
	
	
	private static String swapCurrentPlayer(String player) {
		String newCurrentPlayer;
		if(player == "X") {
			newCurrentPlayer = "O";				
		}
		else {
			newCurrentPlayer = "X";
		}
		return newCurrentPlayer;
	}
}