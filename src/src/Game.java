package src;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) 
	{
		new Game();
	}
	
	Scanner reader;
	private Game()
	{
		reader = new Scanner(System.in);
		boolean play = true;
		while(play)
		{
			Die d = new Die();
			DieFace currentFace = d.getDie()[(int)(Math.random() * 5)+1]; //we start with a random face
			System.out.println(currentFace.getValue());
			int direction;
			while(currentFace.getValue() != 1)
			{
				direction = promptUser(true);
				currentFace = rotateDie(direction, currentFace);
				System.out.println(currentFace.getValue());
			}
			
			System.out.println("game over, input N to play again, input S, E, or W to quit");
			if(promptUser(false) != 0)
			{
				play = false;
			}
		}
	}
	
	private DieFace rotateDie(int direction, DieFace current) 
	{
		//0 = N, 1 = E, 2 = S, 3 = W
		DieFace[] neighbors = current.getNeighbors();
		int ref =1-direction%2; //1 if even, 0 if odd 
		int reference = neighbors[ref].getValue(); //grabs E if even, N if odd
		current = neighbors[direction]; //make the switch
		
		//rotate the die using the reference
		boolean found = false;
		for(int i = 0; i < 4; i++)
		{
			if(!found && reference == neighbors[i].getValue())
			{
				found = true;
				while(ref != i)
				{
					//list order needs to be shifted
					rotateFace(current);
				}
			}
		}
		
		if(!found)
		{
			return new DieFace(0);//this is an error
		}
		return current;
	}
	
	//generalize this for fewer loops
	private void rotateFace(DieFace d)
	{
		DieFace[] temp = new DieFace[4];
		for(int i = 0; i < 3; i++)
		{
			temp[i+1] = d.getNeighbors()[i];
		}
		temp[0] = d.getNeighbors()[3];
		d.setNeighbors(temp);
	}
	
	private int promptUser(boolean print)
	{
		boolean valid = false;
		
		int val = -3;
		while(!valid)
		{	
			if (print)
			{
				System.out.println("Enter a direction (N, E, S, W) ");
			}
			String n = reader.next();
			if(n.length() == 1)
			{
				if(n.equals("N"))
				{
					val = 0;
					valid = true;
				}
				else if(n.equals("E"))
				{
					val = 1;
					valid = true;
				}
				else if(n.equals("S"))
				{
					val = 2;
					valid = true;
				}
				else if(n.equals("W"))
				{
					val = 3;
					valid = true;
				}
				else
					System.out.println("invalid input: not NESW");
			}
			else
				System.out.println("invalid input: too long");
		}
		//reader.close();
		return val;
	}
}
