
public interface InteractionHelpers {

	public static boolean isInteger(String string) {
	    if (string == null) {
	        return false;
	    }
	    try {
	        int value = Integer.parseInt(string);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}


	public static boolean isInValidRange(String string, int low, int high) {
		Integer value = Integer.parseInt(string);
		if(value < low) return false;
		if(value > high) return false;
	    return true;
	}
	
	
	public static int translateHumanCoordinateToComputerReadable(Integer value){
		return value - 1;
	}
	
}
