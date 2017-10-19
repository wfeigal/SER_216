package Week_2;

public class Assignment2 {

	
	public static void main(String[] args) {
	String test = "100a";
	
	System.out.println(parseBinary(test));
	
	}
	

	private static int parseBinary(String binaryString) throws NumberFormatException {
		//VARIABLES AND DECLARATIONS
		int test = 0, val = 0, result = 0;

		
		//ITERATE THROUGH THE INPUT STRING AND IF ANY VALUE IS GREATER THAN 1, THROW EXCEPTION
		for (int i = 0; i < binaryString.length(); i++) {
			test = Character.getNumericValue(binaryString.charAt(i));
			if (test > 1)
				throw new NumberFormatException();
		}
		
		//ITERATE THROUGH THE INPUT STRING AND IF A 1 IS FOUND RAISE 2 TO THE 
		//POWER IF ITS POSITION IN THE STRING AND ADD THAT TO THE RESULT
		for (int i = 0; i < binaryString.length(); i++) {
			val = Character.getNumericValue(binaryString.charAt(i));
			if (val == 1) {
				result += Math.pow(2, i);
			}
		}

		return result;
	}
}
