
public class Vertex {
	
	private boolean visitStat;
	private int[] neighbors;
	private int pos;
	
	public Vertex(int[] inNeighbors, int inPos)
	{
		visitStat = false;
		this.neighbors = inNeighbors;
		this.pos = inPos;
		
	}
	
	public int[] visit()
	{
		visitStat = true;
		return neighbors;
	}

	public boolean isVisited()
	{
		return visitStat;
	}
	
	public void reset()
	{
		visitStat=false;
	}
	
	public int getPos()
	{
		return pos;
	}
}
