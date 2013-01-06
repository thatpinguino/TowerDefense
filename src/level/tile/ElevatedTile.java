package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class ElevatedTile extends Tile {

	public ElevatedTile(Sprite sprite){
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
	
	
	
	
}
