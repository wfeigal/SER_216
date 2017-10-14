package Week_1;

import java.util.*;

public class Magic {

	public static void main(String[] args) {
		
		
		
		
		
	}

	private int[][] inpSquare(){
		//VARIABLES AND DECLARATIONS
		int count = 0;
		String inp;
		Scanner scan = new Scanner(System.in);
		
		//TAKE IN INPUT FROM USER
		System.out.println("Enter the values of the magic square, each seperated by a comma");
		inp = scan.next();
		
		//PARSE THE INPUT
		List<String> list = Arrays.asList(inp.split(","));
		
		//CHECK TO SEE IF THE NUMBER OF INMPUTS IS VALID FOR A SQUARE
		int sqrt = (int)Math.sqrt((double)list.size());
		if (sqrt *sqrt != list.size());{
			System.out.println("Invalid number of inputs");
			System.exit(0);
		}
		
		//CREATE 2D ARRAY FOR STORAGE OF SQUARE
		int[][] arr = new int[sqrt][sqrt];
		
		for (int i = 0; i < sqrt; i++) {
			for (int j = 0; j < sqrt; j++){
				arr[i][j] = Integer.parseInt(list.get(count));
				count++;
			}
		}
		
		return arr;
	}
	
	private boolean isMagic(int[][] arr) {
		
		
		
		
		
	}
}
