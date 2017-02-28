
public class Square {
	private Symbol symbol;

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol s) {
		symbol = s;
	}

	public String toString() {
		return (symbol == null) ? "_" : symbol.getValue();
	}
}
