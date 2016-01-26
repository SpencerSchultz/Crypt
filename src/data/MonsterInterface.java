package data;

import org.newdawn.slick.opengl.Texture;

public interface MonsterInterface {
	public Texture getTexture();
	public int getHealth();
	public String getDescription();
	public int getAttack();
	public int getDefense();
	public int getTextureHeight();
	public int getTextureWidth();
	public int getExp();
	public int takeDamage(int enemyAttackValue);
}