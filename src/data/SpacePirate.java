package data;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SpacePirate implements MonsterInterface {
	private int myHealth = 50;
	private int myAttack = 12;
	private int myDefense = 7;
	private int myExp = 35;
	
	private int myTextureHeight = 195;
	private int myTextureWidth = 148;

	public Texture getTexture() {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream("res/monsters/SpacePirate.png");
		try {
			tex = TextureLoader.getTexture("PNG", in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;	
	}
	
	public int takeDamage(int enemyAttackValue) {
		myHealth = myHealth - (enemyAttackValue - myDefense);
		return (enemyAttackValue - myDefense);
	}

	public int getHealth() {
		return myHealth;
	}

	public String getDescription() {
		return "a Space Pirate";
	}

	public int getAttack() {
		return myAttack;
	}

	public int getDefense() {
		return myDefense;
	}

	public int getTextureHeight() {
		return myTextureHeight;
	}

	public int getTextureWidth() {
		return myTextureWidth;
	}

	public int getExp() {
		return myExp;
	}

}
