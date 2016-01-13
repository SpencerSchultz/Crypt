import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		run();

	}

	static void run() {
		GameMap gameMap = new GameMap("MapOpenRoom20x20y.txt");
		Scanner in = new Scanner(System.in);
		char input = 'r';
		int xPosition = 1;
		int yPosition = 1;
		

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
				if (gameMap.getTile((xPosition - 1), yPosition).canBeMovedTo()) {
					xPosition--;
					System.out.println("Moving left...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 'w') {
				if (gameMap.getTile(xPosition, (yPosition - 1)).canBeMovedTo()) {
					yPosition--;
					System.out.println("Moving forwards...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 's') {
				if (gameMap.getTile(xPosition, (yPosition + 1)).canBeMovedTo()) {
					yPosition++;
					System.out.println("Moving backwards...");
				} else {
					System.out.println("Cannot move there!\n\n\n");
				}
			} else if (input == 'd') {
				if (gameMap.getTile((xPosition + 1), yPosition).canBeMovedTo()) {
					xPosition++;
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
