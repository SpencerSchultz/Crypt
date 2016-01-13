
public class TileFactory {
	TileInterface tileInterface;
	
	public TileInterface makeTile(int tileID) {
		if (tileID == 1) {
			tileInterface = new Floor();
			return tileInterface;
		} else if (tileID == 2) {
			tileInterface = new Wall();
			return tileInterface;
		}
		return null;
		
	}
}
