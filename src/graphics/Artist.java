package graphics;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import data.TileInterface;

public class Artist {
	private static int myWidth = 800; //initial window size is the size of 50 16x16 tiles
	private static int myHeight = 800; 
	
	public Artist() {
		//do nothing
	}
	
	public static void beginSession () {
		//using the light weight java game library (lwjgl)
		Display.setTitle("Crypt");
		try {
			Display.setDisplayMode(new DisplayMode(myWidth, myHeight));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		//set up graphics
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, myWidth, myHeight, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
	}
	
	//draw square
	public static void drawQuad(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y); //Top left
		glVertex2f(x + width, y); //Top right
		glVertex2f(x + width, y + height); //Bottom right
		glVertex2f(x, y + height); //Bottom left
		glEnd();
	}
	
	//draw textures
	public static void drawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x, y, 0); //0 is for the 3d element.
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	
	
	//set screen width size
	public void setWidth(int numOfTiles, int sizeOfTiles) {
		myWidth = numOfTiles * sizeOfTiles;
	}
	
	//set screen height size
	public void setHeight(int numOfTiles, int sizeOfTiles) {
		myHeight = numOfTiles * sizeOfTiles;
	}
	
	//combination of setWidth and setHeight if user wants the display to be a square
	public static void setSize(int numOfTiles, int sizeOfTiles) {
		myHeight = numOfTiles * sizeOfTiles;
		myWidth = numOfTiles * sizeOfTiles;
	}
}
