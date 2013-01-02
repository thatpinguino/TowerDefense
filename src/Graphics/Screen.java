package Graphics;

import java.util.Random;

public class Screen {

	private int width;
	private int height;
	
	public int[] tiles = new int[64*64];
	public int[] pixels;
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		//Applies random colors to the tiles
		for(int i = 0; i < 64 * 64; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
		
		
	}
	
	public void render(){
		
		for(int y = 0; y < height; y++){
			if(y >= height || y < 0) break;			
			for(int x = 0; x < width; x++){
				if(x >= width || y < 0) break;
				int tileIndex = (x >> 4) + (y >> 4) * 64; //Decides how large the tiles are.  IMPORTANT
				pixels[x + y * width] = tiles[tileIndex];
				
			}
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
}
