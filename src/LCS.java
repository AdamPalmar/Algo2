import java.io.*;
import java.util.ArrayList;

public class LCS {
	// Should print the longest common subsequence of a and b
	public void lcs(String a, String b) {
		// Implement this
		int a_length = a.length();
		int b_length = b.length();
		
		//Two dimentional array.
		int[][] table = new int[a_length + 1][b_length + 1];
		int[][] direction = new int[a_length + 1][b_length + 1];
		
		//1 = diagonal
		//2 = up
		//3 = left
		
		for(int i = 0; i <= a_length; i++){
			for (int j = 0; j <= b_length; j++) {
				if (i == 0 || j == 0){
					table[i][j] = 0;			
					
				}	
				else if(a.charAt(i-1) == b.charAt(j-1)) {
					//System.out.println(a.charAt(i) + " "+ b.charAt(j));
					table[i][j] = table[i - 1][j - 1] + 1;	
					direction[i][j] = 1;
				}
				else{
					//
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
					if(table[i][j] == table[i - 1][j]){
						direction[i][j] = 2;
					}else{
						direction[i][j] = 3;
					}
					
				}
						
			}
		}
		
		//Printing of table for debugging
//		for(int i = 0; i < a_length; i++){
//			
//			for (int j = 0; j < b_length; j++) {
//				//If the substrings are of equal length
//				System.out.print(direction[i][j]);
//						
//			}
//			System.out.println();
//		}
		
		//Printing the correct order of the longest subsequence
		String result = "";
		
		//
		int i = a_length;
		int j = b_length;
		//Starting from the max length of both strings.
		while( i >= 0 && j >= 0){
			//If direction[i][j] == 1 this means the characters match
			if(direction[i][j] == 1){
				
				result = result.concat(String.valueOf(a.charAt(i-1)));
				//Diagonal move
				i--;
				j--;
			}else if(direction[i][j] == 2){
				//Move up
				i--;
			}else{
				//Move left
				j--;
			}
		}
		
		//Print string backwards
		System.out.println(new StringBuilder(result).reverse().toString());
		
		
		
		
 		
		
	}
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		new LCS().lcs(input.readLine(), input.readLine());
		//ITS_E_O_!
		//new LCS().lcs("ALGORITHMS_ARE_SO_MUCH_FUN!","IT_IS_TIME_TO_PARTY!");
		
	}
}
