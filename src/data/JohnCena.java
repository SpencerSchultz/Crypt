package data;

import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class JohnCena implements MonsterInterface {
	private int myHealth = 30;
	private int myAttack = 8;
	private int myDefense = 4;
	private int myExp = 20;
	
	private int myTextureHeight = 162;
	private int myTextureWidth = 288;

	public Texture getTexture() {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream("res/monsters/JohnCena1.png");
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
		return "John Cena!!!1!1";
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
