
public class GameEngine {
	
	private Player player;
	private Board board;
	private boolean playing;
	private int drawCount;
	
	public GameEngine() {
		this.player = new Player();
		this.board = new Board();
		this.playing = false;
		this.drawCount = 0;
	}
	
	// TO DO: second constructor for loading saved games ?
	
	public boolean isPlaying() {
		return this.playing;
	}
	
	public void startGame() {
		this.playing = true;
	}
	
	public void endGame() {
		this.playing = false;
	}
	
	public int getDrawCount() {
		return this.drawCount;
	}
	
	public String getCurrentPlayer() {
		return this.player.toString();
	}
	
	public void executreDraw(int row, int column) {
		try {
			board.allocateFieldToPlayer(player.toInt(), row, column);
			this.player.swap();
			this.drawCount++;
			boolean win = new Rules(this.player.toInt(), this.board).checkWin();
			if(win) System.out.println("WIN!!!!!!!!!!! " + this.player.toString());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printBoard() {
		System.out.println("\n\n" + board.toString() + "\n\n");
	}
}
