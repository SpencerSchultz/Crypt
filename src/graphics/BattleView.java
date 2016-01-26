package graphics;



import static org.lwjgl.opengl.GL11.*; //go back a d delete improts I dont need

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import data.GameMap;

/*
 * MapView is a singleton designed to draw out the current GameMap with the help
 * 		of the Artist class
 */
public class BattleView {
	private static BattleView uniqueInstance = new BattleView();
	private static int myTextureSize = 16;

	private BattleView () {}
	
	public static BattleView getInstance() {
		return uniqueInstance;
	}
	
/*	public void showBattleView() {
		Artist.setSize(GameMap.getInstance().getGameMapSizeX(), myTextureSize);
		Artist.beginSession();
	}
*/
		
			
	public void draw(Texture tex, int textureWidth, int textureHeight ) {
		//draw monster
		Artist.drawQuadTex(tex, 5 * myTextureSize, 5 * myTextureSize, textureWidth, textureHeight);
		
		Display.update();
		Display.sync(60);
	}
		
	public void setTextureSize(int newTextureSize) {
		this.myTextureSize = newTextureSize;
	}
}
