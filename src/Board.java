
public class Board {
	public static int SIZE;
	private Square[][] table;

	public Board() {
		table = new Square[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++)
				table[i][j] = new Square();
		}
	}

	public Square[][] getTable() {
		return table;
	}

	public void placeSymbol(Symbol s, int row, int col) {
		table[row][col].setSymbol(s);
	}

	public String toString() {
		String output = "";

		for (int i = 0; i <= SIZE; i++)
			output += String.format("%d ", i);
		output += "\n";

		for (int i = 0; i < SIZE; i++) {
			output += String.format("%d ", i + 1);
			for (int j = 0; j < SIZE; j++)
				output += String.format("%s ", table[i][j]);
			output += "\n";
		}

		return output;
	}
}
