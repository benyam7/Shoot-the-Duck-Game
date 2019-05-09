/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller 
{

	private LinkedList<Arrow> a = new LinkedList<Arrow>();	// it holds many arrow objects
	private LinkedList<Ducks> d = new LinkedList<Ducks>();
	private	LinkedList<Egg> e = new LinkedList<Egg>();
	
	Random rand = new Random();
	
	Arrow tempArrow;
	Ducks tempDucks;
	Egg tempEgg;
	
	GameCore game;
	Textures tex;
	
	public Controller(GameCore game, Textures tex)
	{
	
		this.game = game;
		this.tex = tex;
		
		
		addDuck(new Ducks(5, 5,  tex, game, this));
		
		
	}
	
	public void tick()
	
	{
		for(int i = 0; i < a.size(); i++)
		{
			tempArrow = a.get(i);
			
			tempArrow.tick();
		
			//this destoryes the arrow object once it passes
			// the screen
			
			if(tempArrow.getY() < 0)
			{
				removeArrow(tempArrow);
			}
		}	
	
		for(int i = 0; i < d.size(); i++)
		{
			tempDucks = d.get(i);
			
			tempDucks.tick();
		 
			//this destoryes the arrow object once it passes
			// the screen
			
			
		}
		
		for(int i = 0; i < e.size(); i++)
		{
			tempEgg = e.get(i);
			
			tempEgg.tick();
		
			//this destoryes the arrow object once it passes
			// the screen
			
			
		}
	}
	
	
	public void render(Graphics g)
	{ 
		for(int i = 0; i < a.size(); i++)
		{
			tempArrow = a.get(i);
			
			tempArrow.render(g);
			
		}
		
		for(int i = 0; i < d.size(); i++)
		{
			tempDucks = d.get(i);
			
			tempDucks.render(g);
			
		}
		
		for(int i = 0; i < e.size(); i++)
		{
			tempEgg = e.get(i);
			
			tempEgg.render(g);
			
		}
	
		}
	
	public void addArrow(Arrow arrow)
	{
		a.add(arrow);
	}
	
	public void removeArrow(Arrow arrow)
	{
		a.remove(arrow);
	}
	
	public void addDuck(Ducks duck)
	{
		d.add(duck);
	}
	
	public void removeDuck(Ducks duck)
	{
		d.remove(duck);
	}
	
	public LinkedList<Ducks> getDucksObject()
	{
		return d;
	}
	
	public LinkedList<Arrow> getArrowObject()
	{
		return a;
	}
	
	public LinkedList<Egg> getEggObject()
	{
		return e;
	}
	
	
	
	public void addEgg(Egg egg)
	{
		e.add(egg);
	}
	
	public void removeEgg(Egg egg)
	{
		e.remove(egg);
	}
	
}