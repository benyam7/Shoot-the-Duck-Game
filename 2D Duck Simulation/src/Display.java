
/*
 * Resources used: Google and tutorial
 * 
 * */
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display 

{
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;

	public Display(String title, int width, int height) 
	
	{
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}
	
	// this will set our window
	private void createDisplay()

	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);		// this will center our window
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		// canvas.setFocusable(false); // core to my key movements
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getJframe() {
		return frame;
	}
}
