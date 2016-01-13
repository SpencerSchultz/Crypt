
public class Wall implements TileInterface {

	public boolean canBeMovedTo() {
		return false;
	}

	public String getDescription() {
		return "normal wall";
	}

}
