package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	//Tiles are set to non solid by default.  Override in child class to make solid
	public boolean solid(){
		return false;
	}
}
