package scanner;

import symbols.ErrorToken;

public class ErrorState extends State{
		
	public ErrorState(Scanner Scanboy) {
		super(Scanboy);
		
	}

	@Override
	public void scan(Character c) {
		super.myScanner.addSymbol(new ErrorToken(c));
		super.myScanner.skip();
		super.setInitialState(myScanner);
	}

}
