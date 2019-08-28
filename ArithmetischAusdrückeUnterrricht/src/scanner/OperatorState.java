package scanner;

import basic.OpTable;

public class OperatorState extends State {
	public OperatorState(Scanner Scanboy) {
		super(Scanboy);
	}

	public static boolean hasmapcontent(Character c) {
		return OpTable.hasmapcontent(c);
	}

	@Override
	public void scan(Character c) {
		super.myScanner.skip();
		super.myScanner.addSymbol(OpTable.getSymbol(c));
		super.setInitialState(myScanner);
	}

	
}
