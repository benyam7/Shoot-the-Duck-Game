/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Entrance 
{
	/*private GameCore gameCore;
	
	public Entrance(GameCore gameCore)
	{
		this.gameCore = gameCore;
	}*/
	
	// animate the entrance tooo 
	
	// to make the buttons we use the rectangle class
	
	public Rectangle startButton = new Rectangle(450, 150, 100, 50);
	
	public Rectangle helpButton = new Rectangle(450, 250, 100, 50);
	
	public Rectangle exitButton = new Rectangle(450, 350, 100, 50);
	
	
	
	public void render(Graphics g)
	{
		// to draw rectangle we need graphics 2d
		
		Graphics2D g2d =(Graphics2D)g;	// cast our graphics to graphics 2d
		
		Font font = new Font("arial", Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Duck Simulation Game",250, 100);
		
		Font font2 = new Font("arial", Font.BOLD, 20);	// change the font
		
		//making buttons
		g.setFont(font2);
		g.drawString("Start", startButton.x + 25, startButton.y + 30);
		
		g2d.draw(startButton);
		g.drawString("How To", helpButton.x + 20, helpButton.y + 30);
		g2d.draw(helpButton);
		g.drawString("Exit", exitButton.x + 35, exitButton .y + 30);
		g2d.draw(exitButton);

		
	}
	

}
