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
		for (int i = Board.SIZE - 1; i > 4; i--) {
			for (int j = 0; i - j >= 0; j++) {
				if (b.getTable()[i - j][j].toString().equals(check))
					count++;
				else
					count = 0;
				
				if (count == 5)
					return true;
			}
			count = 0;
		}
		for (int i = Board.SIZE - 1; i > 4; i--) {
			for (int j = 0; i - j >= 0; j++) {
				if (b.getTable()[j][i - j].toString().equals(check))
					count++;
				else
					count = 0;
				
				if (count == 5)
					return true;
			}
			count = 0;
		}
		
		
		return false;
		
	}

	public void inputPlayer() {
		String name, symValue;
		System.out.print("Input Player 1's name: ");
		name = scanner.nextLine();
		System.out.print("Input Player 1's symbol: ");
		symValue = scanner.nextLine();
		p[0] = new Player(name, symValue);
		System.out.print("Input Player 2's name: ");
		name = scanner.nextLine();
		System.out.print("Input Player 2's symbol: ");
		symValue = scanner.nextLine();
		p[1] = new Player(name, symValue);
	}

	public void start() {
		System.out.print("Input size: ");
		Board.SIZE = Integer.parseInt(scanner.nextLine());
		b = new Board();

		inputPlayer();

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
