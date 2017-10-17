package Week_1;

import java.util.*;
/**
 * This program takes in integer inputs from the user and 
 * determines if they comprise a 'magic square'. A magic square is one
 * that has the same sum of values for all horizontals, verticals, and 
 * diagonals. 
 * 
 * @author Bill Feigal
 * @version 1.0
 *
 */
public class MagicSquare {

	public static void main(String[] args) {
		
		System.out.println(makeMagic());

	}
	/**
	 * This static method takes in the user input, validates that it
	 * is appropriate, and performs the calculations that confirm whether 
	 * the user input constitutes a magic square
	 * 
	 * @author Bill Feigal
	 * @version 1.0
	 * @return Boolean value of whether the input is a magic square
	 * @param none No parameters
	 * 
	 */
	public static boolean makeMagic(){
		//VARIABLES AND DECLARATIONS
		boolean first = true;
		int count = 0, sqrt = 0;
		int dSum1 = 0, dSum2 = 0,hSum = 0,vSum = 0,sum = 0;
		String inp;
		Scanner scan = new Scanner(System.in);
		
		//TAKE IN INPUT FROM USER
		System.out.println("Enter the values of the magic square, each seperated by a comma");
		inp = scan.nextLine();
		
		//PARSE THE INPUT - STRING LIST PRESERVES THE ORDER OF INPUT
		//INT LIST IS USED FOR INPUT VALIDATION
		List<String> list = Arrays.asList(inp.split(","));
		List<Integer> intList = new ArrayList<Integer>();
		
		//TRY CATCH BLOCK SERVES AS INPUT VALIDATION TO MAKE SURE ALL ENTERIES ARE NUMERIC
		for(String s : list) {
			try {
				intList.add(Integer.valueOf(s));
			}
			catch (NumberFormatException e){
				return false;
			}
		}
		
		//CHECK TO SEE IF THE NUMBER OF INPUTS IS VALID FOR A SQUARE
		sqrt = (int)Math.sqrt((double)list.size());
		if (sqrt * sqrt != list.size()){
			return false;
		}
		
		//CHECK TO SEE VALUES BETWEEN 1 AND N^2 APPEAR EXACTLY ONCE
		intList.sort(null);
		//CHECK FOR SEQUNTIAL VALUES IN ORDERED LIST
		for (int i = 1; i < intList.size()-1; i++) {
			if ((intList.get(i)+1) != intList.get(i+1)) {
				return false;
			}
		}
		
		//CREATE 2D ARRAY FOR STORAGE OF SQUARE AND FILL WITH VALUES
		int[][] arr = new int[sqrt][sqrt];
		for (int i = 0; i < sqrt; i++) {
			for (int j = 0; j < sqrt; j++){
				arr[i][j] = Integer.parseInt(list.get(count));
				count++;
			}
		}
		
		//TRAVERSE THE ARRAY SUMMING UP THE HORIZ, VERT, AND ONE OF THE DIAGONALS
		for (int i = 0; i < sqrt; i++) {
			dSum1 += arr[i][i];//sum up diagonal (top left to bottom right)
			for (int c = 0; c < sqrt; c++) {
				hSum += arr[i][c];//sum up horizontal
			}
			for (int r = 0; r < sqrt; r++) {
				vSum += arr[r][i];//sum up vertical
			}
			//CHECK THAT THE VERTICAL AND HORIZONTAL SUMS ARE EQUAL
			if (vSum != hSum) {
				return false;
			}
			//CHECK THAT THE CURRENT HORIZ AND VERT SUMS ARE EQUAL TO THE LAST OUTER LOOP ITERATION
			if (!first) {
				if (sum != hSum) {//only need compare to one of the sums since they have already been proven equal above
					return false;
				}
			}
			sum = hSum; //Save one of the sums to use as a comparison next time through the outer loop
			
			//SET THE FIRST ITERATION FLAG FALSE AND RESET THE HORIZONTAL AND VERTICAL COUNTERS
			first = false;
			hSum = 0;
			vSum = 0;
		}
		
		for (int i = 0; i < sqrt; i++) {//sum up other diagonal (top right to bottom left)
			int j = arr.length - 1 - i;
			dSum2 += arr[j][i];
			
		}
		//CHECK TO SEE IF DIAGONALS ARE EQUAL AS WELL AS THE LAST COMPARISON VALUE FOR THE HORIZ AND VERT COMPARISONS
		if (dSum1 != dSum2 || dSum1 != sum) {
			return false;
		}

		//IF EXECUTION MAKES IT TO THIS POINT WE HAVE A MAGIC SQUARE, RETURN FALSE
		return true;
	}
}
