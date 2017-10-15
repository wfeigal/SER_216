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
public class Magic {

	public static void main(String[] args) {
		
		
		
		
		
	}

	private int[][] makeMagic(){
		//VARIABLES AND DECLARATIONS
		int count = 0;
		int dSum1 = 0, dSum2 = 0,hSum = 0,vSum = 0,Sum = 0;
		String inp;
		Scanner scan = new Scanner(System.in);
		
		//TAKE IN INPUT FROM USER
		System.out.println("Enter the values of the magic square, each seperated by a comma");
		inp = scan.nextLine();
		
		//PARSE THE INPUT - STRING LIST PRESERVES THE ORDER OF INPUT
		//INT LIST IS USED FOR INPUT VALIDATION
		List<String> list = Arrays.asList(inp.split(","));
		List<Integer> intList = new ArrayList<Integer>();
		
		for(String s : list) 
			intList.add(Integer.valueOf(s));
		
		//CHECK TO SEE IF THE NUMBER OF INPUTS IS VALID FOR A SQUARE
		int sqrt = (int)Math.sqrt((double)list.size());
		if (sqrt *sqrt != list.size());{
			System.out.println("FALSE");
			System.exit(0);
		}
		
		//CHECK TO SEE VALUES BETWEEN 1 AND N^2 APPEAR EXACTLY ONCE
		intList.sort(null);
		//CHECK FOR SEQUNTIAL VALUES IN ORDERED LIST
		for (int i = 1; i < intList.size(); i++) {
			if ((intList.get(i)+1) != intList.get(i+1)) {
				System.out.println("FALSE");
				System.exit(0);
			}
		}
		
		//CREATE 2D ARRAY FOR STORAGE OF SQUARE
		int[][] arr = new int[sqrt][sqrt];
		
		for (int i = 0; i < sqrt; i++) {
			for (int j = 0; j < sqrt; j++){
				arr[i][j] = Integer.parseInt(list.get(count));
				count++;
			}
		}
		
		//TRAVERSE DIAGONALLY ACROSS THE ARRAY SUMMING UP THE HORIZONTALS AND VERTICALS 
		//AND KEEPING TRACK OF THE 
		for (int r = 0; r < sqrt; r++) {
			dSum1 += arr[r][r];//sum up diagonal (top left to bottom right)
			for (int c = 0; c < sqrt; c++) {
				hSum += arr[r][c];//sum up horizontal
				for (int i = 0; i < sqrt; i++) {
					vSum =+ arr[i][c];//sum up vertical
					if (dSum1 != hSum || vSum != hSum || dSum1 != vSum) {
						System.out.println("FALSE");
						System.exit(0);
					}
				}
			}
		}
		
		
		
		
		
		scan.close();
		return arr;
	}
}
