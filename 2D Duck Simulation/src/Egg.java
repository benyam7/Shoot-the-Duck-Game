/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg 
{
	private double x;
	private double y;
	
	Random rand = new Random();
	
	private Textures tex;
	private Animation eggAnim;
	
	
	public Egg(double x, double y, Textures tex)
	{
		this.x = x;
		this.y = y;
		this.tex = tex;
		eggAnim = new Animation(200, Textures.eggFalling);
		
		
		
	}
	
	public void tick()
	{
		eggAnim.tick();
		y+=15;
		
		x +=4.5;		
		// when the egg reache end of screen it 
		
		//is gonning to be back at random postition
		
		/*if(y > 540)
		{
			y = 0;
			x = 0;
			x = rand.nextInt(590);
			
		}*/
	
		
		
		
	}
	
	public void render(Graphics g)
	{
	
		g.drawImage(eggAnim.getCurrentFrame(),(int)x, (int)y, null);
		
		
		
	}
	
	public Rectangle getBoundary()
	{
		return new Rectangle((int)x, (int)y, 32,32);
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getX()
	{
		return x;
	}
	
	
}
