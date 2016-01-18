package data;

import org.newdawn.slick.opengl.Texture;

public interface TileInterface {
	public Texture getTexture();
	public boolean canBeMovedTo();
	public String getDescription();
}
