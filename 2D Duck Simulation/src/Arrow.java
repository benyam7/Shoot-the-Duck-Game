/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Arrow {

	private double x;
	private double y;
	
	
	
	private Textures tex;
	private GameCore gameCore;
	
	public Arrow(double x, double y, Textures tex, GameCore gameCore)
	{
		this.x = x;
		this.y = y;
		this.tex = tex;
		this.gameCore = gameCore;
		
		
	}
	
	public void tick()
	{
		y-=8;
		
		/*if(CheckCollision.collision(this, gameCore.duckO))
		{
			System.out.println("booom");
		}*/
		
		
	}
	
	public Rectangle getBoundary() 
	{
		return new Rectangle((int)x, (int)y, 32,32);
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.arrowImage,(int)x, (int)y, null);

		if(CheckCollision.collision(this, gameCore.duckO))
		
			g.drawImage(tex.deadDuck, (int)x, (int)y, null);
		
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
