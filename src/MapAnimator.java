import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MapAnimator {
	static int mapHeight; //once singleton, get from GameMap
	static int mapWidth; //once singleton, get from GameMap
	static int pixelSize = 32;
	static String fileType = ".jpg";
	
	public MapAnimator() {}
	
	public void loadMap() {
		//get map dimensions
		mapWidth = GameMap.getGameMapSizeX();
		mapHeight = GameMap.getGameMapSizeY();
	}
	
	public static void drawMap () {
		JFrame mapPanel = new JFrame("Map");
		//mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mapPanel.setLayout(new GridLayout(mapHeight, mapWidth));
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				//if (i == Main.xPosition && j == Main.yPosition) {
				//	mapPanel.add(new JLabel(new ImageIcon(GameMap.getTile(i, j).getPath() + pixelSize + "Player" + fileType)));
				//} else {
				//	mapPanel.add(new JLabel(new ImageIcon(GameMap.getTile(i, j).getPath() + pixelSize + fileType)));
				//}
				mapPanel.add(new JLabel(new ImageIcon(GameMap.getTile(j, i).getPath() + pixelSize + fileType)));
			}
		}
		mapPanel.pack();
		mapPanel.setVisible(true);		
		
		
		
/*		JLayeredPane layeredPane = new JLayeredPane();
		JFrame frame = new JFrame("Map");
		frame.setLayout(new GridLayout(1,1));

		//actual map of tiles
		JPanel mapPanel = new JPanel();
		//mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mapPanel.setLayout(new GridLayout(mapWidth, mapHeight));
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				mapPanel.add(new JLabel(new ImageIcon(GameMap.getTile(i, j).getPath() + pixelSize + fileType)));
			}
		}
		//panel showing player position
		JPanel playerPositionPanel = new JPanel();
		playerPositionPanel.setLayout(new GridLayout(mapWidth, mapHeight));
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				if (i == Main.xPosition && j == Main.yPosition) {
				playerPositionPanel.add(new JLabel(new ImageIcon("Green.jpg")));
				}
				playerPositionPanel.add(new JLabel(new ImageIcon("Opaque" + pixelSize + fileType)));
			}
		}
		mapPanel.setOpaque(true);
		playerPositionPanel.setOpaque(true);
		layeredPane.add(mapPanel, new Integer(0), 0);
		layeredPane.add(playerPositionPanel, new Integer(1), 0);
		mapPanel.setVisible(true);
		playerPositionPanel.setVisible(true);
		layeredPane.setVisible(true);
        frame.add(layeredPane);
		frame.pack();
		frame.setVisible(true);
*/
		
		
		
	}
		
}

