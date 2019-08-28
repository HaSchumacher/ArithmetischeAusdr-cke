package scanner;



/**
 * Selection of next state depending on next symbol 
 * Prüft ob <c> eine Zahl ist - in der Op-Table - in der Br-Table - oder ein Whitespace ist. 
 * Ist keins davon der Fall wird ein Fehler-Symbol erstellt!
 */
public class SelectionState extends State {
	
	public SelectionState(Scanner Scanboy) {
		super(Scanboy);
	}

	public void scan(Character c) {
		if(Character.isDigit(c))super.myScanner.setState(new DigitState(super.myScanner));
		else if(OperatorState.hasmapcontent(c))super.myScanner.setState(new OperatorState(super.myScanner));
		else if (BracketState.hasmapcontent(c))super.myScanner.setState(new BracketState(super.myScanner));
		else if (Character.isWhitespace(c))super.myScanner.setState(new WhitespaceState(super.myScanner));
		else {super.myScanner.setState(new ErrorState(myScanner));
			
		  }
	
}
}
