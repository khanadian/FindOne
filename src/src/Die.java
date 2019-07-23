package src;

public class Die {

	private DieFace[]  dieFaces;
	
	public Die()
	{
		// initialize faces
		dieFaces = new DieFace[7];
		for(int i = 1; i < 7; i++)
		{
			dieFaces[i] = new DieFace(i);
		}
		
			//connect faces
		initDie();
		
	}
	
	
	public DieFace[] getDie()
	{
		return dieFaces;
	}
	
	private void initDie()
	{
		// pick one face
		int start = (int)(Math.random() * 5)+1; //generates random number between 1 and 6
		int opposite = 7-start;
		
		// pick from faces 
		int[] choices = new int[4];
		int index = 0;
		for(int i = 1; i < 7; i++)
		{
			if (start == i || opposite == i)
			{
				//do nothing
			}
			else
			{
				choices[index] = i;
				index++;
			}
		}
		
		//picks first 2 faces
		int pick = (int)(Math.random() * 3); //generates random number between 0 and 3
		
		dieFaces[start].setNorth(dieFaces[choices[pick]]);
		dieFaces[choices[pick]].setSouth(dieFaces[start]);
		
		dieFaces[start].setSouth(dieFaces[7-choices[pick]]);
		dieFaces[7-choices[pick]].setNorth(dieFaces[start]);
		
		dieFaces[opposite].setSouth(dieFaces[choices[pick]]);
		dieFaces[choices[pick]].setNorth(dieFaces[opposite]);
		
		dieFaces[opposite].setNorth(dieFaces[7-choices[pick]]);
		dieFaces[7-choices[pick]].setSouth(dieFaces[opposite]);
		
		//pick next 2 faces
		if(pick == 0 || pick == 3)
		{
			if ((int)(Math.random()) == 1)
				pick = 1;
			else
				pick = 2;
		}
		else
		{
			if ((int)(Math.random()) == 1)
				pick = 0;
			else
				pick = 3;
		}
		dieFaces[start].setEast(dieFaces[choices[pick]]);
		dieFaces[choices[pick]].setWest(dieFaces[start]);
		
		dieFaces[start].setWest(dieFaces[7-choices[pick]]);
		dieFaces[7-choices[pick]].setEast(dieFaces[start]);
		
		dieFaces[opposite].setWest(dieFaces[choices[pick]]);
		dieFaces[choices[pick]].setEast(dieFaces[opposite]);
		
		dieFaces[opposite].setEast(dieFaces[7-choices[pick]]);
		dieFaces[7-choices[pick]].setWest(dieFaces[opposite]);
		
		//link all the middle faces to each other
		
		DieFace[] middle = dieFaces[start].getNeighbors();
		for(int i = 0; i < 4; i++)
		{
			if(i%2 == 0) //if N or S of starting position
			{
				middle[i].setEast(middle[1]);
				middle[i].setWest(middle[3]);
			}
			else
			{
				middle[i].setNorth(middle[0]);
				middle[i].setSouth(middle[2]);
			}
		}
		
	}
}
