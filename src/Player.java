
public class Player {
	private String name, symValue;

	public Player(String name, String symValue) {
		this.name = name;
		this.symValue = symValue;
	}

	public String getName() {
		return name;
	}

	public String getSymValue() {
		return symValue;
	}

	public void placeSymbol(Board b, int row, int col) {
		Symbol s = new Symbol(symValue);
		b.placeSymbol(s, row, col);
	}

	public String toString() {
		return name;
	}
}
