/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject
{
	//x and y corrdinate of player
	
/*	private double x;
	private double y;*/
	
	private double smoothX;
	private double smoothY;
	private static int LIFE = 150;
	
	private Textures tex;
	private GameCore gameCore;

	//private Animation playerRightAnim, playerLeftAnim, playerStandingStillLeft, playerStandingStillRight,aimmingAnim;
	
	
	public Player(double x, double y, Textures tex, GameCore gameCore)
	{
		/*this.x = x;
		this.y = y;*/
		super(x,y);
		this.tex = tex;
		this.gameCore = gameCore;
		
		
		//we create SpriteSheet obj b/c we want to get crop method 
		
		
		/*playerRightAnim = new Animation(600,Textures.playerRight);
		playerLeftAnim = new Animation(600, Textures.playerLeft);
		playerStandingStillLeft = new Animation(10000, Textures.playerStandingStillLeft);
		playerStandingStillRight = new Animation(10000, Textures.playerStandingStillRight);
		aimmingAnim = new Animation(10000, Textures.aimming_player);
		*/
	}
	public void tick()
	{
		x += smoothX;
		//y += smoothY;
		/*playerRightAnim.tick();
		playerLeftAnim.tick();
		playerStandingStillRight.tick();*/
		// we are setting the boundary limitation for the player so that it wont be out of our window.
		
		if(x <= 0)		// left boundary
			x =0;
		
		if(x >= 640-32)		// right boundary
			x = 640-32;
		
		/*if(y <= 0)
			y = 0;*/
		if(y >= 480-32)		// our bottom boundary
			y = 480-32;

			
		for(int i = 0; i < gameCore.eggO.size(); i++)
		{
			Egg temporaryEgg = gameCore.eggO.get(i);
			
			if(CheckCollision.collisionEggAndPlayer(this, temporaryEgg))
			{
				System.out.println("death");
				LIFE -=10;
				if(LIFE <= 0)
				{
					
					GameCore.gameState = GameCore.GameState.GameOverState;
					LIFE = 150;
				}
				
			}
			
		}
		
		
	}
	
	public Rectangle getBoundary()
	{
		return new Rectangle((int)x, (int)y, 32,32);
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.player, (int)x,(int)y, null);
 
		/*if(smoothX > 0)
			g.drawImage(playerRightAnim.getCurrentFrame(), (int)x,(int)y, null);
		
		else if(smoothX < 0)
			g.drawImage(playerLeftAnim.getCurrentFrame(), (int)x,(int)y, null);
		
		else if(getSmoothX() < 0)
			if(getSmoothX() == 0)
				return playerStandingStillLeft.getCurrentFrame();
		
			else
				return playerStandingStillRight.getCurrentFrame();
		
		else 
			g.drawImage(playerStandingStillRight.getCurrentFrame(), (int)x,(int)y, null);
*/
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSmoothX() {
		return smoothX;
	}
	public void setSmoothX(double smoothX) {
		this.smoothX = smoothX;
	}
	public double getSmoothY() {
		return smoothY;
	}
	public void setSmoothY(double smoothY) {
		this.smoothY = smoothY;
	}
	public static int  getLIFE() {
		return LIFE;
	}
	
	/*private BufferedImage getCurrentAnimationFrame()
	{
		if(getSmoothX() > 0)
			return playerRightAnim.getCurrentFrame();
		
		else if(getSmoothX() < 0)
			return playerLeftAnim.get	CurrentFrame();
		
		else if(getSmoothX() < 0)
			if(getSmoothX() == 0)
				return playerStandingStillLeft.getCurrentFrame();
		
			else
				return playerStandingStillRight.getCurrentFrame();
		
		else 
			return aimmingAnim.getCurrentFrame();
	}*/
	
	
	
	
}
