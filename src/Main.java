import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	static MapAnimator mapAnimator = new MapAnimator();
	static int xPosition = 1;
	static int yPosition = 1;
	
	public static void main(String[] args) {
		run();

	}

	static void run() {
		GameMap gameMap = new GameMap("MapOpenRoom20x20y.txt");
		Scanner in = new Scanner(System.in);
		char input = 'r';
		
		mapAnimator.loadMap();
		mapAnimator.drawMap();

		//movement screen
		boolean isRunning = true;
		while (isRunning == true) {
			System.out.println("You are standing on a " + gameMap.getTile(xPosition, yPosition).getDescription() + ".\n");
			System.out.println("Please press the a, w, d, or s keys to move around the map. Pressing q will quit.");
			
			try {
				input = (char)System.in.read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			in.nextLine();
			if (input == 'a') {
				if (gameMap.getTile((yPosition - 1), xPosition).canBeMovedTo()) {
					yPosition--;
					System.out.println("Moving left...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 'w') {
				if (gameMap.getTile(yPosition, (xPosition - 1)).canBeMovedTo()) {
					xPosition--;
					System.out.println("Moving forwards...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 's') {
				if (gameMap.getTile(yPosition, (xPosition + 1)).canBeMovedTo()) {
					xPosition++;
					System.out.println("Moving backwards...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 'd') {
				if (gameMap.getTile((yPosition + 1), xPosition).canBeMovedTo()) {
					yPosition++;
					System.out.println("Moving right...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 'q') {
				isRunning = false;
				break;
			}
			//pause for reading
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//clear console
			System.out.print("\n\n\n\n\n");
		}
		in.close();
	}
	
}
