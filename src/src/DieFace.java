package src;

public class DieFace {

	private int value;
	private DieFace[] neighbors; //[north ,east, south, west]
	
	
	public DieFace(int v)
	{
		value = v;
		neighbors = new DieFace[4];
	}
	
	public void setNorth(DieFace d)
	{
		neighbors[0] = d;
	}
	
	public void setSouth(DieFace d)
	{
		neighbors[2] = d;
	}
	
	public void setEast(DieFace d)
	{
		neighbors[1] = d;
	}
	
	public void setWest(DieFace d)
	{
		neighbors[3] = d;
	}
	
	public int getValue()
	{
		return value;
	}

	public DieFace[] getNeighbors()
	{
		return neighbors;
	}
	
	public void setNeighbors(DieFace[] n)
	{
		neighbors = n;
	}
}
