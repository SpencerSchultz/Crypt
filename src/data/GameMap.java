package data;
import java.io.*;
////////////////////MAKE SINGLETON

/*
 * GameMap is a singleton that represents the single map that is being dealt with in the game
 * 		at the current state. It can loadGameMap(String mapName) where mapName is the name of 
 * 		the map to load, and then other classes can interact with the GameMap class to interact
 * 		with the specific map.
 */
public class GameMap {
	private static GameMap uniqueInstance = new GameMap();
	
	//instance variables
	private String name;
	private static TileInterface[][] gameMapArray;
	private static int mapHeight;
	private static int mapWidth;
	//factory to make tiles
	static TileFactory tileFactory = new TileFactory();
	
	
	private GameMap() {}
	
	public static GameMap getInstance() {
		return uniqueInstance;
	}

	
	//loadGameMap loads up the game map with the given passed String mapName
	public void loadGameMap(String mapName) {
		int xCounter = 0;
		int yCounter = 0;
		
		//loading up a file with mapName
		String line = null;
		try {
			FileReader fileReader = new FileReader(mapName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//read first 2 lines to read size
			line = bufferedReader.readLine();
			mapWidth = Integer.valueOf(line);
		    line = bufferedReader.readLine();
		    mapHeight = Integer.valueOf(line);
		    //make gameMapArray the size of the map file
		    gameMapArray = new TileInterface[mapWidth][mapHeight];
			
			while((line = bufferedReader.readLine()) != null) {
				//if statement check to see if the line is a comment
				if(line.contains("#")) {
					//do nothing
				} else {
					gameMapArray[xCounter][yCounter] = tileFactory.makeTile(Integer.valueOf(line));///////////////////////////////////////
					xCounter++;
					//move on to next row if xCounter is equal to map width
					if (xCounter >= mapWidth) {
						yCounter++;
						xCounter = 0;
					}
				}
			}
			bufferedReader.close(); 
		}
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + mapName + "'");                
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
	}
	

	public TileInterface getTile(int x, int y) {
		return gameMapArray[x][y];
	}

	
	public void setTile(int x, int y, int tileID) {
		gameMapArray[x][y] = tileFactory.makeTile(tileID);
	}
	
	public int getGameMapSizeX() {
		return mapWidth;
	}
	
	public int getGameMapSizeY() {
		return mapHeight;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String mapName) {
		this.name = mapName;
	}

}
