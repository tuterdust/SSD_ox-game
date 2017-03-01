import java.util.Scanner;

public class Game {
	Scanner scanner;
	Board b;
	Player[] p = new Player[2];

	public Game() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.start();
	}

	public boolean gameEnd(Player p, Board b) {
		String check = p.getSymValue();

		int count = 0;
		for (int i = 0; i < Board.SIZE; i++) {
			for (int j = 0; j < Board.SIZE; j++) {
				if (b.getTable()[i][j].toString().equals(check))
					count++;
				else
					count = 0;

				if (count == 5)
					return true;
			}
			count = 0;
		}

		count = 0;
		for (int i = 0; i < Board.SIZE; i++) {
			for (int j = 0; j < Board.SIZE; j++) {
				if (b.getTable()[j][i].toString().equals(check))
					count++;
				else
					count = 0;

				if (count == 5)
					return true;
			}
			count = 0;
		}

		count = 0;
		for (int i = 0; i < Board.SIZE - 4; i++) {
			for (int j = 0; i + j < Board.SIZE; j++) {
				if (b.getTable()[i + j][j].toString().equals(check))
					count++;
				else
					count = 0;

				if (count == 5)
					return true;
			}
			count = 0;
		}
		for (int i = 0; i < Board.SIZE - 4; i++) {
			for (int j = 0; i + j < Board.SIZE; j++) {
				if (b.getTable()[j][i + j].toString().equals(check))
					count++;
				else
					count = 0;

				if (count == 5)
					return true;
			}
			count = 0;
		}

		count = 0;
		for (int i = 4; i < Board.SIZE; i++) {
			for (int j = 0; j <= i; j++) {
				if (b.getTable()[i - j][j].toString().equals(check))
					count++;
				else
					count = 0;

				if (count == 5)
					return true;
			}
			count = 0;
		}
		for (int i = 4; i < Board.SIZE; i++) {
			for (int j = 0; j <= i; j++) {
				if (b.getTable()[Board.SIZE - (i - j) - 1][Board.SIZE - j - 1].toString().equals(check))
					count++;
				else
					count = 0;

				if (count == 5)
					return true;
			}
		}

		return false;
	}

	public void start() {
		Board.SIZE = 9;
		b = new Board();
		p[0] = new Player("Player 1", "O");
		p[1] = new Player("Player 2", "X");

		int turn = 0;
		boolean end = false;
		do {
			int play = turn % 2, row, col;
			do {
				System.out.printf("%s's turn.\n", p[play]);
				System.out.print("Please select row: ");
				row = Integer.parseInt(scanner.nextLine()) - 1;
				System.out.print("Please select column: ");
				col = Integer.parseInt(scanner.nextLine()) - 1;

				if (row < 0 || col < 0 || row >= Board.SIZE || col >= Board.SIZE
						|| b.getTable()[row][col].getSymbol() != null)
					System.out.println("\nYou can't place on that square.");
			} while (row < 0 || col < 0 || row >= Board.SIZE || col >= Board.SIZE
					|| b.getTable()[row][col].getSymbol() != null);

			p[play].placeSymbol(b, row, col);
			System.out.printf("\n%s placed %s on (%d,%d)\n", p[play], p[play].getSymValue(), row, col);
			System.out.println(b);

			if (gameEnd(p[play], b)) {
				System.out.printf("%s wins.", p[play]);
				end = true;
			}

			turn++;
		} while (!end && turn < Board.SIZE * Board.SIZE);

		if (!end)
			System.out.print("Draw.");
	}
}
