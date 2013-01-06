import input.Keyboard;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.util.Random;
import java.util.logging.Level;

import javax.swing.JFrame;

import graphics.Screen;


public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "TowerDefenseGame";
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	private Level level;
	private Keyboard key;
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);		
		frame = new JFrame();		
		key = new Keyboard();
		level = new LevelOne(64, 64);
		
		addKeyListener(key);
	}
	
	//Primary game thread
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	//Closes all of the threads
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;  //Nanosecond to second conversion
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
					
			//Run at a maximum of 60 times per second
			while (delta >= 1){
				update();
				updates++;
				delta--;
			}
						
			//Run as fast as the computer allows
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				frame.setTitle(title + " | FPS: " + frames);
				timer += 1000;
				frames = 0;
				updates = 0;
				
				
			}
		}
		stop();
	}
	
	public void update(){
		key.update();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		level.render(screen);
		
		//Sets the pixels array to the values of the pixels from the screen
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		//Begin graphics displays
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		//End graphics displays
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
