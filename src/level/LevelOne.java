package level;

public class LevelOne extends Level{

	public LevelOne(int width, int height){
		super(width, height);
	}
	
	protected void generateLevel(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				if(x == 10){
					tiles[x + y * width] = 1;
				}
				else{
					tiles[x + y * width] = 2;
				}
			}
		}
	}
}
