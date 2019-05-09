/*
 * Resources used: Google and tutorial
 * 
 * */

import java.util.LinkedList;

public class CheckCollision 
{
	//Arrow arrow;
	
	
	public static boolean collision(Arrow arrow, LinkedList<Ducks> duckList)
	{
		for(int i = 0; i < duckList.size(); i++)
		{
			if(arrow.getBoundary().intersects(duckList.get(i).getBoundary()))
			{
				return true;
			}
		}
		return false;
	}
	
	/*public static boolean collisionEggAndPlayer(Player player, LinkedList<Egg> eggList)
	{
		for(int i = 0; i < eggList.size(); i++)
		{
			if(player.getBoundary().intersects(eggList.get(i).getBoundary()))
			{
				return true;
			}
		}
		return false;
	}*/
	
	public static boolean collisionEggAndPlayer(Player player, Egg egg)
	{
		
			if(player.getBoundary().intersects(egg.getBoundary()))
			{
				return true;
			}
		
		return false;
	}

	/*public static boolean collisionDuckArrow(Ducks duck, LinkedList<Arrow> arrowList)
	{
		for(int i = 0; i < arrowList.size(); i++)
		{
			if(duck.getBoundary().intersects(arrowList.get(i).getBoundary()))
			{
				return true;
			}
		}
		return false;
	}*/
	
	public static boolean collisionDuckArrow(Ducks duck, Arrow arrow)
	{
		
			if(duck.getBoundary().intersects(arrow.getBoundary()))
			{
				return true;
			}
		
		return false;
	}
}
