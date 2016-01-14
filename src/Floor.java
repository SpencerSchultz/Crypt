
public class Floor implements TileInterface {

	public boolean canBeMovedTo() {
		return true;
	}

	public String getDescription() {
		return "normal floor";
	}

	public String getPath() {
		return "GreyShingles";
	}

}
