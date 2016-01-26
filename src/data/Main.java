package data;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import graphics.BattleView;
import graphics.MapView;

import java.util.Random;


public class Main {
	static MonsterFactory monsterFactory = new MonsterFactory();
	static MonsterInterface monster;
	static Random randomGen = new Random();//make seeded with something random (time of day?)
	
	
	public static void main(String[] args) {
		GameMap.getInstance().loadGameMap("res/maps/OpenRoom20x20y.txt");
		MapView.getInstance().showMapView();
		Player.getInstance().setPlayerXPosition(2);
		Player.getInstance().setPlayerYPosition(2);
		run();

	}

	//send this to a separate class
	static void run() {
		Scanner in = new Scanner(System.in);
		char input = 'r';
		System.out.println("Please press the a, w, d, or s keys to move around the map. Pressing q will quit.");
		
		//movement screen
		boolean isRunning = true;
		while (isRunning == true) {
			MapView.getInstance().draw();
			System.out.println("You are standing " + GameMap.getInstance().getTile(Player.getInstance().getPlayerXPosition(), Player.getInstance().getPlayerYPosition()).getDescription() + ".");
			
			try {
				input = (char)System.in.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			in.nextLine();
			if (input == 'a') {
					moveAction();
					Player.getInstance().turnLeft();
					System.out.println("Turning left...");
			} else if (input == 'w') {
				if (GameMap.getInstance().getTile(Player.getInstance().getPlayerNextXPositionForwards(), Player.getInstance().getPlayerNextYPositionForwards()).canBeMovedTo()) {
					moveAction();
					Player.getInstance().moveForwards();
					System.out.println("Moving forwards...");
				} else {
					System.out.println("Cannot move there!");
				}
			} else if (input == 's') {
				if (GameMap.getInstance().getTile(Player.getInstance().getPlayerNextXPositionBackwards(), Player.getInstance().getPlayerNextYPositionBackwards()).canBeMovedTo()) {
					moveAction();
					Player.getInstance().moveBackwards();
					System.out.println("Moving backwards...");
				} else {
					System.out.println("Cannot move there!");
				}
			} else if (input == 'd') {
					moveAction();
					Player.getInstance().turnRight();
					System.out.println("Turning right...");
			} else if (input == 'q') {
				isRunning = false;
				break;
			}
			//clear console
			System.out.print("\n\n\n");
		}
		in.close();
	}
	
	
	//move these into separate class
	static void moveAction() {
		if (randomEncounterCheck()) {
			monsterFight();
		}
	}
	
	static boolean randomEncounterCheck() {
		if (randomGen.nextInt(10) < 2) {
			return true;
		} else {
			return false;
		}
	}
	
	static void monsterFight() {
		System.out.print("Monster Encountered!");
		monster = monsterFactory.makeMonster(randomGen.nextInt(2));
		BattleView.getInstance().draw(monster.getTexture(), monster.getTextureWidth(), monster.getTextureHeight());
		System.out.print("\n\nIt's " + monster.getDescription());
		System.out.println("\n\n\nPress a to attack, or q to give up and go home.");
		
		Scanner in = new Scanner(System.in);
		char input = 'r';
		boolean isFighting = true;
		while (isFighting == true) {
			System.out.println("Health: " + Player.getInstance().getHealth() + "/" + Player.getInstance().getMaxHealth());
			try {
				input = (char)System.in.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			in.nextLine();
			if (input == 'a') {
				System.out.println("\nHit for " + monster.takeDamage(Player.getInstance().attack()));
				if (monster.getHealth() <= 0) {
					System.out.println(monster.getDescription() + " is defeated!");
					System.out.println("Gained " + monster.getExp() + " experience.");
					Player.getInstance().gainExp(monster.getExp());
					//level up check
					if (Player.getInstance().isLevelUp()) {
						Player.getInstance().levelUp();
						System.out.println("\n\nLevel up! Level is now " + Player.getInstance().getLevel() + "!\n\n\n");
					}
					break;
				} else {
					System.out.println("\nYou've been hit for " + Player.getInstance().takeDamage(monster.getAttack()) + "\n\n");
				}
			} else if (input == 'q') {
				isFighting = false;
				break;
			}
		}
	}

	
}
