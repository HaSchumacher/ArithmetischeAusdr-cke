package scanner;
/*
 * Responsible for processing Scanner input's whitespace*/
public class WhitespaceState extends State {
		
	public WhitespaceState(Scanner myScanner) {
		super(myScanner);
		// Ruft den Super Constructor auf und bearbeitet im Scan den Whitespace.
	}

	@Override
	public void scan(Character c) {
		super.myScanner.skip();
		super.setInitialState(myScanner);
	}

	
}
