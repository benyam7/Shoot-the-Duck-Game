/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class GameCore implements Runnable {

	private Display display;

	public int width, height;

	public String title;

	private boolean running = false;

	private Thread thread;

	private BufferStrategy bs;

	private Graphics g;
	

	// we need this spriteSheet in another class(player class)so we make public
	// getter at the butttom
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	//private BufferedImage newSpriteSheet = null;
	// temporary
	// private BufferedImage player;

	private boolean is_shooting = false; // to correct the shooting

	private Player p;
	private Controller c;
	private Textures tex;
	private Ducks d;
	private Entrance entrance;	// this is importing
	private GameOver gameover;
	
	public LinkedList<Arrow> arrowO;
	public LinkedList<Ducks> duckO;
	public LinkedList<Egg> eggO;
	
	public static enum GameState		// creating enum
	{
		PlayState, MenuState, GameOverState
	};
	
	// we can use this state variable to check in which state we're in
	// modifier as GameState and the name as gameState
	
	public static GameState gameState = GameState.MenuState;
	
	
	public GameCore(String title, int width, int height) {

		this.width = width;

		this.height = height;

		this.title = title;
	}

	private void init() {

		display = new Display(title, width, height);
		display.getCanvas().requestFocus();

		ImageLoader loader = new ImageLoader();	// this class will return  the buffered image of the original picture
		
		try {
			spriteSheet = loader.loadImage("/gameObjects.png");
			
			background = loader.loadImage("/backgroundClearSky.png");
			
			//newSpriteSheet = loader.loadImage("/gameObjects.png");
		} catch (IOException e) {		// IO is checked execption need to be handled 
			e.printStackTrace();
		}

// we add keylistenr before the player object

		display.getCanvas().addKeyListener(new KeyInput(this)); // we get it from jframe
		display.getCanvas().addMouseListener(new MouseInput(this));
		
		tex = new Textures(this); // it has to be placed before the player and controler cuz they use the textures

		p = new Player(300, 470, tex, this);
		
		

		c = new Controller(this, tex);
		
		d = new Ducks(10,10, tex, this, c);

		arrowO = c.getArrowObject();

		duckO = c.getDucksObject();
		
		eggO = c.getEggObject();
		
		entrance = new Entrance(); // we're intializing it
		
		gameover = new GameOver();
		

		// d = new Ducks(100,0, tex);
		// c = new Controller(this, tex);

//temp
//SpriteSheet ss = new SpriteSheet(spriteSheet);
//temp

//player = ss.cropImage(4, 18, 50, 70);

	}

//temp
//double x = 10;
//double y = 300;
	private void tick() {
		// x+= 0.12;
		// y-= 0.41;
		if(gameState == GameState.PlayState) {
		p.tick();
		d.tick();
		c.tick();
		}
	}

	private void render() 
	{
		
		// we create the object of bs (bufferstategy tells comp how to draw)
        // it uses buffer to draw( "so simply, buffer is a hidden comp screen with comp, not technical defnition,
    // but it help as to remove the flicking that we see in old games...(so our screen will not flash)
		
		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {

			display.getCanvas().createBufferStrategy(3);

			return;
		}
		
		g = bs.getDrawGraphics();		// g is like the paint brush, that allow as to draw on our canvas
		
//Clear Screen
		//g.clearRect(0, 0, width, height);
//Draw Here!
//g.setColor(GREEN);
//g.fillRect(0, 0, width, height);

//temp
//g.drawRect((int)x, 10, 50, 60);
//g.fillRect(45, (int)y, 50, 80);
//temp
//g.drawImage(player, (int)x, 100,null);
		if(gameState == GameState.PlayState) {
		g.drawImage(background, 0, 0, null);
		p.render(g);
		//d.render(g);
		c.render(g);
		
		g.drawImage(tex.player,0, 0, null);
		
		g.setColor(Color.GREEN);
		
		g.fillRect(630, 350,10, Player.getLIFE());
		}
		// so we draw our menu if it is in the menu state
		
		else if(gameState == gameState.MenuState )
		{
			g.clearRect(0, 0, width, height);
			
			// change your entrance background
			g.drawImage(background, 0, 0, null);
			
			entrance.render(g);
			
			//if(gameOver) {g.drawImage(background,0,0, null); g.drawString("Game Over", 300, 200);}
			
		}
		
		else if(gameState == gameState.GameOverState)
		{
			gameover.render(g);
		}
//End Drawing!
		bs.show();
		g.dispose();
	}

	public void keyPressed(KeyEvent e) 
	{
	
		if(gameState == GameState.PlayState)
		{
		int key = e.getKeyCode();

		// so to update the position of
		// player we need to have its cordinates
		// so, we define getters and setter for coordinates
		// and use them here and set them by updating
		if (key == KeyEvent.VK_RIGHT) {
			p.setSmoothX(6);
		}

		else if (key == KeyEvent.VK_LEFT) {
			p.setSmoothX(-6);
		}

		else if (key == KeyEvent.VK_SPACE && is_shooting == false) {
			
			is_shooting = true;
			
			c.addArrow(new Arrow(p.getX(), p.getY(), tex, this));
			// c.addEgg(new Egg(d.getX(),d.getY(),tex));
		}
		/*
		 * else if(key == KeyEvent.VK_D) { c.addEgg(new Egg(d.getX(),d.getY(),tex)); }
		 */

		/*
		 * else if(key == KeyEvent.VK_DOWN) { p.setSmoothY(6);
		 * 
		 * }
		 * 
		 * else if(key == KeyEvent.VK_UP) { p.setSmoothY(-6); }
		 */

		// after doing this we need key listener do accoplish this
		// movement, so add keyListner to init() method in our game class
		// and also notice we add the keyListner before the we create the
		// player object, so we can move it.... else it won't work
	}
	}

	public void keyReleased(KeyEvent e)

	{
		if(gameState == GameState.PlayState)
		{
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) 
		{
			p.setSmoothX(0);
			
		}

		else if (key == KeyEvent.VK_LEFT)
		{
			p.setSmoothX(0);
		} 
		else if (key == KeyEvent.VK_SPACE) 
		{
			is_shooting = false; // this is gonna force the player to release the key inorder to shoot another
									// bullet
			c.addEgg(new Egg(d.getX(), d.getY(), tex));
		}

		/*
		 * else if(key == KeyEvent.VK_DOWN) { p.setSmoothY(0);
		 * 
		 * }
		 * 
		 * else if(key == KeyEvent.VK_UP) { p.setSmoothY(0); }
		 */
	}
	}

	public void run() {

		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			// ShopingSystem.out.println("game loop");
			if (delta >= 1)

			{
				tick();
				updates++;
				delta--;

			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " tics : fps " + frames);
				updates = 0;
				frames = 0;

			}

		}
		stop();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}

	

	
	
	

	


	

}
