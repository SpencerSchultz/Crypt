package data;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Wall implements TileInterface {

	public boolean canBeMovedTo() {
		return false;
	}

	public String getDescription() {
		return "normal wall";
	}
	
	
	public Texture getTexture() {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream("res/tiles/GrayBrick16.png");
		try {
			tex = TextureLoader.getTexture("PNG", in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;	
	}

}
