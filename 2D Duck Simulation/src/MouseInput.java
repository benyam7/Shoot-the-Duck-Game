/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class MouseInput implements 	MouseListener

{
	// use the constructor... have getters and setter methods for enum
	private GameCore gameCore;
	
	public MouseInput(GameCore gameCore)
	{
		this.gameCore = gameCore;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		/*public Rectangle startButton = new Rectangle(450, 150, 100, 50);
		
		public Rectangle helpButton = new Rectangle(450, 250, 100, 50);
		
		public Rectangle exitButton = new Rectangle(450, 350, 100, 50);
		
		*/
		
		
		// x and y values of mouse
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		//quit
		
		if(mouseX > 450  && mouseX<= 550)
		{
			if(mouseY > 350 && mouseY <=400)
				
				System.exit(1);
		}
		
		//quit
		
		if(mouseX > 450  && mouseX<= 550)
		{
			if(mouseY > 150 && mouseY <=200)
				
				GameCore.gameState = GameCore.GameState.PlayState;		}
	
		
	}
 
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
