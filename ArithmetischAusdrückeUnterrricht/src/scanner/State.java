package scanner;
/** 
 * Scanner - State Pattern
 */
public abstract class State {
/**
 * May add symbol to current Scanner result depending on <c>, 
 * May erase <c> in input string 
 * May change state    
 */
	protected Scanner myScanner;
	public State(Scanner Scanboy) {
		this.myScanner = Scanboy;
	}
	public abstract void scan(Character c);
	public void setInitialState(Scanner scanner) {scanner.setState(new SelectionState(myScanner));}
	
	public void onTermination() {
	}
}
