
public class Rules {
	
	
	Board board;
	int player;
	
	public Rules(int player, Board board) {
		this.board = board;
		this.player = player;
	}

	public boolean checkWin(){
		
		if(this.checkHorizontalWin() || this.checkVerticalWin()) return true;
		
	    //check diagonal right
		/*
	    countPlayer = 0;
	    for (int row = 0, column= 0; row <this.board.getSize() ; row++, column++) {
	    	if (this.board.field[row][column] == player) countPlayer++;
	    }
	    if(countPlayer == this.board.getSize()) return true;

	    //check diagonal left
	    for (int row = this.board.getSize()-1, column= this.board.getSize()-1; row >= 0 ; row--, column--) {
	    	if (this.board.field[row][column] == 0) countPlayer++;
	    }
	    if(countPlayer == this.board.getSize()) return true;
		*/

	    return false;
	}
	
	
	private boolean checkHorizontalWin() {
		for(int row = 0; row < this.board.getSize(); row++) {
			int streak = 0;
			for(int column = 0; column < this.board.getSize(); column++) {
				if(this.board.getField()[row][column] == this.player) {
					streak++;
				} 
				continue;
			}
			if(streak == this.board.getSize()) return true;
		}
		return false;
	}
	
	private boolean checkVerticalWin() {
		for(int column = 0; column < this.board.getSize(); column++) {
			int streak = 0;
			for(int row = 0; row < this.board.getSize(); row++) {
				if(this.board.getField()[row][column] == this.player) {
					streak++;
				} 
				continue;
			}
			if(streak == this.board.getSize()) return true;
		}
		return false;
	}
	
	/*
	private boolean checkDiagonalWinTopLeftToBottomRight() {
		int streak = 0;
	}
	
	private boolean checkDiagonalWinTopRightToBottomLeft() {
		int streak = 0;
	}
	*/
	
}

