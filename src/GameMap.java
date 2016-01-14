import java.io.*;
////////////////////MAKE SINGLETON
public class GameMap {
	//instance variables
	private String name;
	private static TileInterface[][] gameMapArray;
	private static int mapHeight;
	private static int mapWidth;
	//factory to make tiles
	TileFactory tileFactory = new TileFactory();
	
	
	public GameMap(String mapName) {
		this.name = mapName; //replace with the load file name
		loadGameMap(mapName);
		
	}

	
	//loadGameMap loads up the game map with the given passed String mapName
	private void loadGameMap(String mapName) {
		int xCounter = 0;
		int yCounter = 0;
		
		//loading up a file with mapName
		String line = null;
		try {
			FileReader fileReader = new FileReader(mapName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//read first 2 lines to read size
			line = bufferedReader.readLine();
			mapHeight = Integer.valueOf(line);
		    line = bufferedReader.readLine();
		    mapWidth = Integer.valueOf(line);
		    //make gameMapArray the size of the map file
		    gameMapArray = new TileInterface[mapHeight][mapWidth];
			
			while((line = bufferedReader.readLine()) != null) {
				//if statement check to see if the line is a comment
				if(line.contains("#")) {
					//do nothing
				} else {
					gameMapArray[yCounter][xCounter] = tileFactory.makeTile(Integer.valueOf(line));///////////////////////////////////////
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
	

	public static TileInterface getTile(int x, int y) {
		return gameMapArray[y][x];
	}

	
	public void setTile(int x, int y, int tileID) {
		gameMapArray[y][x] = tileFactory.makeTile(tileID);
	}
	
	public static int getGameMapSizeX() {
		return mapWidth;
	}
	
	public static int getGameMapSizeY() {
		return mapHeight;
	}
	
	
	public String getName() {
		return name;
	}

}
