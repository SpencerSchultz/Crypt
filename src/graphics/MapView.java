package graphics;



import static org.lwjgl.opengl.GL11.*; //go back a d delete improts I dont need

import org.lwjgl.opengl.Display;

import data.GameMap;
import data.Player;

/*
 * MapView is a singleton designed to draw out the current GameMap with the help
 * 		of the Artist class
 */
public class MapView {
	private static MapView uniqueInstance = new MapView();
	private static int myTextureSize = 16;

	private MapView () {}
	
	public static MapView getInstance() {
		return uniqueInstance;
	}
	
	public void showMapView() {
		Artist.setSize(GameMap.getInstance().getGameMapSizeX(), myTextureSize);
		Artist.beginSession();
	}
		
		
/*		while(!Display.isCloseRequested()) {
			//draw map
			GameMap.getInstance();
			for (int i = 0; i < GameMap.getInstance().getGameMapSizeX(); i++) {
				for (int j = 0; j < GameMap.getInstance().getGameMapSizeY(); j++) {
					Artist.drawQuadTex(GameMap.getInstance().getTile(j, i).getTexture(), (j * myTextureSize), (i * myTextureSize), myTextureSize, myTextureSize);
				}
			}
			//draw player position
			Artist.drawQuadTex(Player.getInstance().getTexture(), Player.getInstance().getPlayerYPosition(), Player.getInstance().getPlayerXPosition(), myTextureSize, myTextureSize);
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy(); //destroy display. if map closed, want to end game?
*/	
	public void draw() {
		//draw map
		GameMap.getInstance();
		for (int i = 0; i < GameMap.getInstance().getGameMapSizeX(); i++) {
			for (int j = 0; j < GameMap.getInstance().getGameMapSizeY(); j++) {
				Artist.drawQuadTex(GameMap.getInstance().getTile(j, i).getTexture(), (j * myTextureSize), (i * myTextureSize), myTextureSize, myTextureSize);
			}
		}
		//draw player position
		Artist.drawQuadTex(Player.getInstance().getTexture(), Player.getInstance().getPlayerXPosition() * myTextureSize, Player.getInstance().getPlayerYPosition() * myTextureSize, myTextureSize, myTextureSize);
		
		Display.update();
		Display.sync(60);
	}
		
	public void setTextureSize(int newTextureSize) {
		this.myTextureSize = newTextureSize;
	}
}
