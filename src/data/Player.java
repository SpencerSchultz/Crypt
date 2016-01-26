package data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/*
 * Player is a singleton that represents the actual player of the game
 */
public class Player {
	private static Player uniqueInstance = new Player();
	private int xPosition = 2;
	private int yPosition = 2;
	private String directionFacing = "Up"; //"Up", "Down", "Left", "Right" as values for direction facing
	
	private int myMaxHealth = 100;
	private int myHealth = 100;
	private int myAttack = 10;
	private int myDefense = 5;
	private int myCritChance = 20;
	private int myExp = 0;
	private int myLevel = 1;

	static Random randomGen = new Random();//make seeded with something random (time of day?)
	
	
	private Player () {}
	
	public static Player getInstance() {
		return uniqueInstance;
	}
	
	//xPosition
	public int getPlayerXPosition() {
		return xPosition;
	}
	
	public void setPlayerXPosition(int i) {
		this.xPosition = i;
	}
	
	public void incrementPlayerXPosition() {
		this.xPosition++;
	}
	
	public void decrementPlayerXPosition() {
		this.xPosition--;
	}
	
	
	
	//yPosition
	public int getPlayerYPosition() {
		return yPosition;
	}
	
	public void setPlayerYPosition(int i) {
		this.yPosition = i;
	}
	
	public void incrementPlayerYPosition() {
		this.yPosition++;
	}
	
	public void decrementPlayerYPosition() {
		this.yPosition--;
	}
	
	
	//Direction
	public String getDirectionFacing() {
		return directionFacing;
	}
	
	public void setDirectionFacing(String direction) {
		this.directionFacing = direction;
	}
	
	
	//Movement Commands------------------------------------------------------
	public void turnRight() {
		if (this.directionFacing == "Right") {
			this.directionFacing = "Down";
		} else if (this.directionFacing == "Down") {
			this.directionFacing = "Left";
		} else if (this.directionFacing == "Left") {
			this.directionFacing = "Up";
		} else if (this.directionFacing == "Up") {
			this.directionFacing = "Right";
		}
	}
	
	public void turnLeft() {
		if (this.directionFacing == "Right") {
			this.directionFacing = "Up";
		} else if (this.directionFacing == "Up") {
			this.directionFacing = "Left";
		} else if (this.directionFacing == "Left") {
			this.directionFacing = "Down";
		} else if (this.directionFacing == "Down") {
			this.directionFacing = "Right";
		}
	}
	
	public void moveForwards() {
		if (this.directionFacing == "Right") {
			xPosition++;
		} else if (this.directionFacing == "Up") {
			yPosition--;
		} else if (this.directionFacing == "Left") {
			xPosition--;
		} else if (this.directionFacing == "Down") {
			yPosition++;
		}
	}
	
	public void moveBackwards() {
		if (this.directionFacing == "Right") {
			xPosition--;
		} else if (this.directionFacing == "Up") {
			yPosition++;
		} else if (this.directionFacing == "Left") {
			xPosition++;
		} else if (this.directionFacing == "Down") {
			yPosition--;
		}
	}
	
	
	//checks for next move position------------------------------------------
	//Forwards-----------
	//checks the player's x position after a move forwards command
	public int getPlayerNextXPositionForwards () {
		if (this.directionFacing == "Right") {
			return xPosition + 1;
		} else if (this.directionFacing == "Left") {
			return xPosition - 1;
		} else {
			return xPosition;
		}
	}
	
	//checks the player's y position after a move forwards command
	public int getPlayerNextYPositionForwards () {
		if (this.directionFacing == "Up") {
			return yPosition - 1;
		} else if (this.directionFacing == "Down") {
			return yPosition + 1;
		} else {
			return yPosition;
		}
	}
	
	//Backwards-----------
	//checks the player's x position after a move backwards command
	public int getPlayerNextXPositionBackwards () {
		if (this.directionFacing == "Right") {
			return xPosition - 1;
		} else if (this.directionFacing == "Left") {
			return xPosition + 1;
		} else {
			return xPosition;
		}
	}
	
	//checks the player's y position after a move backwards command
	public int getPlayerNextYPositionBackwards () {
		if (this.directionFacing == "Up") {
			return yPosition + 1;
		} else if (this.directionFacing == "Down") {
			return yPosition - 1;
		} else {
			return yPosition;
		}
	}
	
	//loads the player texture (arrow showing player directionFacing
	public Texture getTexture() {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream("res/tiles/PlayerPosition" + directionFacing + "16.png");
		try {
			tex = TextureLoader.getTexture("PNG", in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;	
	}
	
	public int takeDamage(int enemyAttackValue) {
		if (enemyAttackValue <= myDefense) {
			return 0;
		} else {
			myHealth = myHealth - (enemyAttackValue - myDefense);
			return (enemyAttackValue - myDefense);
		}
	}
	
	public int attack() {
		if (randomGen.nextInt(100) > myCritChance) {
			return (int) ((int)myAttack * 2.5);
		} else {
			return myAttack;
		}
	}
	
	public void gainExp(int exp) {
		myExp = myExp + exp;
		
	}
	
	public boolean isLevelUp() {
		if (myExp >= (myLevel * 100)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void levelUp() {
		myMaxHealth = myMaxHealth + 10;
		myHealth = myMaxHealth;
		myAttack = myAttack + 2;
		myDefense = myDefense + 1;
		myLevel++;
	}
	
	
	public int getHealth() {
		return myHealth;
	}

	public void setHealth(int myHealth) {
		this.myHealth = myHealth;
	}

	public int getAttack() {
		return myAttack;
	}

	public void setAttack(int myAttack) {
		this.myAttack = myAttack;
	}

	public int getDefense() {
		return myDefense;
	}

	public void setDefense(int myDefense) {
		this.myDefense = myDefense;
	}
	
	public int getMyCritChance() {
		return myCritChance;
	}

	public int getLevel() {
		return myLevel;
	}

	public int getMaxHealth() {
		return myMaxHealth;
	}





	
}
