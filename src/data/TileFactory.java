package data;

public class TileFactory {
	TileInterface tileInterface;
	
	public TileInterface makeTile(int tileID) {
		if (tileID == 2) {
			tileInterface = new Floor();
			return tileInterface;
		} else if (tileID == 1) {
			tileInterface = new Wall();
			return tileInterface;
		} else if (tileID == 3) {
			tileInterface = new Door();
			return tileInterface;
		} else if (tileID == 4) {
			tileInterface = new Grass();
			return tileInterface;
		}
		
		return null;
		
	}
}
