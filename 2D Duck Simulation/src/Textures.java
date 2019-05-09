/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.image.BufferedImage;

public class Textures 
{

	private SpriteSheet ss;

	public BufferedImage player, arrowImage, deadDuck, fallingDuck  /*duck*/ /*egg*/;
	
	public static BufferedImage[] duck_Right;
	public static BufferedImage[] eggFalling;
	public static BufferedImage[] playerRight;
	public static BufferedImage[] playerLeft;
	public static BufferedImage[] playerStandingStillLeft;
	public static BufferedImage[] playerStandingStillRight;
	public static BufferedImage[] aimming_player;
	
	public Textures(GameCore game)
	{
		ss = new SpriteSheet(game.getSpriteSheet());
		//ssNew = new SpriteSheet(game.getNewSpriteSheet());
		
		duck_Right = new BufferedImage[3];
		eggFalling = new BufferedImage[3];
		
		/*playerRight = new BufferedImage[3];
		playerLeft = new BufferedImage[3];
		playerStandingStillLeft = new BufferedImage[5];

		playerStandingStillRight = new BufferedImage[5];
		aimming_player = new BufferedImage[1];
		*/
		getTextures();
	}
	
	private void getTextures()
	
	{
		duck_Right[0] = ss.cropImage(4,1,32,32);
		duck_Right[1] = ss.cropImage(4, 2, 32, 32);
		duck_Right[2] = ss.cropImage(4, 3, 32, 32);
		
		eggFalling[0] = ss.cropImage(6, 1, 32, 32);
		eggFalling[1] = ss.cropImage(6, 2, 32, 32);
		eggFalling[2] = ss.cropImage(6, 3, 32, 32);
		
		/*playerRight[0] = ss.cropImage(1,1,32,32);
		playerRight[1] = ss.cropImage(1,2,32,32);
		playerRight[2] = ss.cropImage(1,3,32,32);
		//playerRight[3] = ss.cropImage(1,4,32,32);
		//playerRight[4] = ss.cropImage(1,5,32,32);
		
		
		playerLeft[0] = ss.cropImage(2,2,32,32);
		playerLeft[1] = ss.cropImage(2,3,32,32);
		playerLeft[2] = ss.cropImage(2,4,32,32);*/
	//	playerLeft[3] = ss.cropImage(2,4,32,32);
	//	playerLeft[4] = ss.cropImage(2,5,32,32);
		
		
		/*playerStandingStillRight[0] = ss.cropImage(3,1,32,32);
		playerStandingStillRight[1] = ss.cropImage(3,2,32,32);
		playerStandingStillRight[2] = ss.cropImage(3,3,32,32);
		playerStandingStillRight[3] = ss.cropImage(3,4,32,32);
		playerStandingStillRight[4] = ss.cropImage(3,5,32,32);
		
		playerStandingStillLeft[0] = ss.cropImage(5,1,32,32);
		playerStandingStillLeft[1] = ss.cropImage(5,2,32,32);
		playerStandingStillLeft[2] = ss.cropImage(5,3,32,32);
		playerStandingStillLeft[3] = ss.cropImage(5,4,32,32);
		playerStandingStillLeft[4] = ss.cropImage(5,5,32,32);*/
		
		player = ss.cropImage(3,7,32,32);
		arrowImage = ss.cropImage(4,6,32,32);
		//duck = ss.cropImage(1,1,32,32);
		
		deadDuck = ss.cropImage(4,7, 32, 32);
		//fallingDuck = ss.cropImage(5, 4, 32, 32);
		//aimming_player[0] = ss.cropImage(3, 5, 32, 32);
		
		
		//egg = ss.cropImage(2, 2, 32, 32);
		
	}
}

