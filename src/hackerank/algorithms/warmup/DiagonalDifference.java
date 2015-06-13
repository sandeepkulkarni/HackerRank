package hackerank.algorithms.warmup;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int matrixSize = s.nextInt();
		int [][] matrix = new int[matrixSize][matrixSize];	//square matrix
		
		//Populate Matrix
		for(int row=0; row < matrixSize; row++){			
			for(int column=0; column < matrixSize; column++){
				matrix[row][column] = s.nextInt();
			}			
		}
		
		int sum1 = 0;
		int sum2 = 0;
		//get main diagonal elements
		for(int i=0; i < matrix.length; i++){
			for(int j=0; j < matrix[i].length; j++){
				if(i==j){
					sum1 += matrix[i][j];
				}
			}			
		}
		
		// get anti-diagonal elements
        for (int i = 0, j = matrix[i].length - 1; i < matrix.length; i++, j--) {
        	sum2 += matrix[i][j];
        }
		
		System.out.println(Math.abs(sum1-sum2));
        
		//print matrix 
		/*for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }*/
		
		s.close();
	}	
	
}
