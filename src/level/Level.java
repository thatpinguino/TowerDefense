package level;

import level.tile.Tile;
import graphics.Screen;

public class Level {

	public int width, height;
	public int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
	}
	
	private void generateLevel(){
		
	}
	
	private void loadLevel(String path){
		
	}
	
	
	public void update() {
		
	}
	
	private void time(){
		
	}
	
	public void render(Screen screen){
		/*
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		*/
		for(int y = 0; y < screen.height >> 4; y++){
			for(int x = 0; x < screen.width >> 4; x++){
				getTile(x,y).render(x, y, screen);
			}
		}
		
	}
	
	public Tile getTile(int x, int y){
		if(tiles[x+y*width] == 0) return Tile.grass;
		return Tile.voidTile; 
	}
	
	
}
