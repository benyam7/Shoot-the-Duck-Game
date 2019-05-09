/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	GameCore game;
	
	// the reason we are not doing the keyInput in player 
	//class it because it will limit us, to have it when only 
	// the player in use
	//is, to have keyboard access for different scenarios other than
	//moving the player
	
	public KeyInput(GameCore game)
	{
		this.game = game;	// we do this b/c we want to call
							// our keyboard input in Gamecore class
	}
	public void keyPressed(KeyEvent e)
	{
		game.keyPressed(e);		// this calls the method in game class and same with realesed
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		game.keyReleased(e);
	}
}
