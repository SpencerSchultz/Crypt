package data;

public class MonsterFactory {
	MonsterInterface monsterInterface;
	
	public MonsterInterface makeMonster(int monsterID) {
		if (monsterID == 0) {
			monsterInterface = new JohnCena();
			return monsterInterface;
		} else if (monsterID == 1) {
			monsterInterface = new SpacePirate();
			return monsterInterface;
		} else {
			return null;
		}
	}
}