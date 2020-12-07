public class ConsoleTicTacToe {
	
	private String[][] board;
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;
	private String regex = "\\s{3}";
	
	
	public ConsoleTicTacToe() {
		board = new String[ROWS][COLUMNS];
		this.setUpTheBoard();
	}
	

	public void setUpTheBoard() {
		for(int row = 0; row < ROWS; row++) {
			for(int column = 0; column < COLUMNS; column++) {
				board[row][column] = "   ";
			}
		}
	}
	
	public void executeDraw(int row, int column, String player) {
		if(board[row][column].matches(regex)) {
			board[row][column] = " "+player+" ";
		}
	}
	
	public boolean hasWinner() {
		
    	if(victoryConditionsInRows()) return true;
    	if(victoryConditionsInColums()) return true;
    	if(victoryConditionsInDiagonal()) return true;
    	
    	//no victory
    	return false;
	}
	
	private boolean victoryConditionsInRows() {
		for(int row = 0; row < ROWS; row++) {
    		if(!board[row][0].matches(regex) && board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {    			
    			return true; 
    		}   			 			
    	}
		return false;
	}
	
	private boolean victoryConditionsInColums() {
		for(int column = 0; column < COLUMNS; column++) {    		
    		if(!board[0][column].matches(regex) && board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])) 
    			return true;  			
    	}
		return false;
	}
	
	private boolean victoryConditionsInDiagonal() {
		if(!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
			return true;
		}
    		
    	if(!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
    		return true;
    	}
		return false;
	}
	
	public String printBoardToConsole() {
		String stringOfBoard = "";
		for(int row = 0; row < ROWS; row++) {
			for(int columns = 0; columns < COLUMNS; columns++) {
				if(columns == COLUMNS-1)
					stringOfBoard += board[row][columns];
				else
					stringOfBoard += board[row][columns] + "|";
			}
			if(row != ROWS-1)
				stringOfBoard += "\n---+---+---\n";
		}
		return stringOfBoard;
	}
}
