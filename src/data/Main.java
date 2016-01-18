package data;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


import graphics.MapView;


public class Main {
	
	
	public static void main(String[] args) {
		GameMap.getInstance().loadGameMap("res/maps/OpenRoom20x20y.txt");
		MapView.getInstance().showMapView();
		Player.getInstance().setPlayerXPosition(2);
		Player.getInstance().setPlayerYPosition(2);
		run();

	}

	static void run() {
		Scanner in = new Scanner(System.in);
		char input = 'r';
		System.out.println("Please press the a, w, d, or s keys to move around the map. Pressing q will quit.");
		
		//movement screen
		boolean isRunning = true;
		while (isRunning == true) {
			MapView.getInstance().draw();
			System.out.println("You are standing on a " + GameMap.getInstance().getTile(Player.getInstance().getPlayerXPosition(), Player.getInstance().getPlayerYPosition()).getDescription() + ".");
			
			try {
				input = (char)System.in.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			in.nextLine();
			if (input == 'a') {
					Player.getInstance().turnLeft();
					System.out.println("Turning left...");
			} else if (input == 'w') {
				if (GameMap.getInstance().getTile(Player.getInstance().getPlayerNextXPositionForwards(), Player.getInstance().getPlayerNextYPositionForwards()).canBeMovedTo()) {
					Player.getInstance().moveForwards();
					System.out.println("Moving forwards...");
				} else {
					System.out.println("Cannot move there!");
				}
			} else if (input == 's') {
				if (GameMap.getInstance().getTile(Player.getInstance().getPlayerNextXPositionBackwards(), Player.getInstance().getPlayerNextYPositionBackwards()).canBeMovedTo()) {
					Player.getInstance().moveBackwards();
					System.out.println("Moving backwards...");
				} else {
					System.out.println("Cannot move there!");
				}
			} else if (input == 'd') {
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
	
	

	
}
