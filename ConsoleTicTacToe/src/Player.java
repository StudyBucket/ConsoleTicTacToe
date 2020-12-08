
public class Player {

	final static int PLAYER_X =  1;
	final static int PLAYER_O =  0;
	private int currentIdentity;
	
	public Player() {
		this.currentIdentity = PLAYER_X;
	}
	
	public String toString() {
		return playerValueToString(currentIdentity);
	}
	
	public int toInt(){
		return this.currentIdentity;
	}
	
	public void setX() {
		this.currentIdentity = PLAYER_X;
	}
	
	public void setO() {
		this.currentIdentity = PLAYER_O;
	}
	
	public void swap() {
		if(currentIdentity == PLAYER_X) currentIdentity = PLAYER_O;
		currentIdentity = PLAYER_X;
	}
	
	public static String playerValueToString(int player) {
		if(player == PLAYER_X) return "X";
		if(player == PLAYER_O) return "O";
		throw new IllegalStateException("Invalid Player");
	}
	
}
