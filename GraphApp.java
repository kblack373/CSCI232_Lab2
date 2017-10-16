import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GraphApp {

	public static void main(String[] args)throws FileNotFoundException
	{
		String labelString = new String();
		int[][] matrix;
		char[] labels;
		char[] path; 
		Scanner in = new Scanner(new File("labels.txt"));
		
		labelString = in.nextLine();
		in.close();
		
		labels = labelString.toCharArray();
		
		matrix = readMatrix(labelString.length());
		
		Graph graph = new Graph(labels, matrix);
		
		path = graph.depthFirst();
		System.out.println("Depth First Search Visits:");
		for (int i= 0; i < labels.length; i++)
		{
			System.out.print(path[i]);
		}
		System.out.println();
		
		
	}
	
	
	
	
	private static int[][] readMatrix(int length) throws FileNotFoundException {
		// read in the matrix file
		Scanner in = new Scanner(new File("matrix.txt"));
		
		//two matrices
		
		//first matrix takes in rows as a whole int
		int[] initMatrix = new int[length];
		//second matrix breaks those down into 2-d array
		int[][] finalMatrix = new int[length][length];
		
		//read in
		for (int i = 0; i < length; i++)
		{
			initMatrix[i] = in.nextInt();
		}
		
		in.close();
		
		//break down
		for (int i = 0; i < length; i++)
		{
			//start from back
			for (int j = length - 1; j >= 0; j--)
			{
				//%10 gives last digit
				finalMatrix[i][j] =  initMatrix[i] % 10;
				// divided removes last digit.
				initMatrix[i] = initMatrix[i] / 10;
			}
		}
		
		
		return finalMatrix;
	}
	
}
