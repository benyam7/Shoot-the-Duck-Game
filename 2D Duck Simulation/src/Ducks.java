/*
 * Resources used: Google and tutorial
 * 
 * */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ducks extends GameObject {

	private double x, y;
	
	private Textures tex;
	
	private Animation duckRightAnim;
	
	private GameCore gameCore;
	
	private Controller controller;
	
	Random rand = new Random();
	
	public Ducks(double x, double y, Textures tex, GameCore gameCore, Controller controller)
	{
		super(x,y);
		this.tex = tex;
		this.gameCore = gameCore;
		this.controller = controller;
		duckRightAnim = new Animation(100, Textures.duck_Right);
	}
	
	public void tick()	
	{
		duckRightAnim.tick();
		x +=2.5;		
		// when the duck reache end of screen it 
		
		//is gonning to be back at random postition
		//y +=2.5;
		
		if(x > 640)
		{
			x = 0;
			y = rand.nextInt(100);
		}
		
		/*if(CheckCollision.collisionDuckArrow(this, gameCore.arrowO))
		{
			y+=2;
		}*/
		
		/*if(y > 250)
		{
			y = rand.nextInt(100);
		}*/
		
		
		for(int i = 0; i < gameCore.arrowO.size(); i++)
		{
			Arrow temporaryArrow = gameCore.arrowO.get(i);
			
			if(CheckCollision.collisionDuckArrow(this, temporaryArrow))
			{
				System.out.println("dead duck");
				//controller.removeArrow(temporaryArrow);
				//controller.removeDuck(this);
			}
		}
		
		
	
		
	}

	
	public void render(Graphics g)
	{
	
		g.drawImage(duckRightAnim.getCurrentFrame(), (int)x,(int)y, null);	// draw image handels only integers
		
		/*if(CheckCollision.collisionDuckArrow(this, gameCore.arrowO))
		{
			g.drawImage(tex.deadDuck, (int)x, (int)y, null);
		}*/
		
		for(int i = 0; i < gameCore.arrowO.size(); i++)
		{
			Arrow temporaryArrow = gameCore.arrowO.get(i);
			
			if(CheckCollision.collisionDuckArrow(this, temporaryArrow))
			{
				System.out.println("dead duck");
				
				g.drawImage(tex.deadDuck,(int) temporaryArrow.getX(), (int)temporaryArrow.getY(),null);
				//controller.removeArrow(temporaryArrow);
				//controller.removeDuck(this);
			}
		}
	}
	
	public Rectangle getBoundary()
	{
		return new Rectangle((int)x, (int)y, 32,32);
	}
	
	public double getX()
	{
		return x;
	}
	 
	public double getY()
	{
		return y;
	}
	
	
	
	
	
}
