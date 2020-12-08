
public class Board {

	private static final int SIZE = 3;
	final static int EMPTY    = -1;
	
	private int[][] field;
	
	public Board() {
		this.field = new int[SIZE][SIZE];
		this.initiateEmptyField();
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public int[][] getField() {
		return this.field;
	}
	
	public int[][] setField(int[][] preparedFiled) {
		return this.field = preparedFiled;
	}
	
	public void allocateFieldToPlayer(int player, int row, int column){
		if(player != 0 && player != 1) {
            throw new IllegalStateException("Error: " + player + " is not a valid player!");
        }
		if(this.field[row][column] != EMPTY) {
            throw new IllegalStateException("Error: Tile " + row + ":" + column + " is already taken!");
        }
		this.field[row][column] = player;
	}
	
	private void initiateEmptyField() {
		for (int row = 0; row < SIZE ; row++) {
	        for (int column = 0; column < SIZE ; column++) {
	            this.field[row][column] = EMPTY;
	        }
	    }
	}
	
	public String toString() {
		String output = "";
		for(int row = 0; row < SIZE; row++) {
			for(int column = 0; column < SIZE; column++) {
				output += (field[row][column] == -1) ? "   " : " " + Player.playerValueToString(field[row][column]) + " ";
				if(column != SIZE-1) output += "|";
			}
			if(row != SIZE-1) output += "\n---+---+---\n";
		}
		return output;
	}
}
