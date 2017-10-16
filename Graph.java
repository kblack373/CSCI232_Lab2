import java.util.Stack;

public class Graph {
	
	private Vertex[] points;
	private char[] labels;


	public Graph(char[] inLabels, int[][] matrix) {
		//creates an array of vertices 
		points = new Vertex[inLabels.length];
		///populates the array with data from the matrix
		for (int i = 0; i < points.length; i++)
		{
			points[i] = new Vertex(matrix[i], i);
		}
		labels = inLabels;
		
	}
	
	public char[] depthFirst()
	{
		char[] path = new char[points.length];
		int[] cands = new int[points.length];
		Stack<Vertex> stack = new Stack<Vertex>();
		Vertex temp = points[0];
		boolean found = false;
		int inc = 0;
		stack.push(points[0]);
		while (!stack.isEmpty())
		{
			temp = stack.peek();
			
			if (!temp.isVisited())
			{
				path[inc] = labels[temp.getPos()];
				inc++;
			}
			cands = temp.visit();
			found = false;
			for (int i = 0; i < cands.length; i++)
			{
				if (cands[i] == 1 && !points[i].isVisited())
				{
					found= true;
					stack.push(points[i]);
					break;
				}
			}
			
			if (!found)
			{
				stack.pop();
			}
		}
		
		
		
		return path;
	}

}
