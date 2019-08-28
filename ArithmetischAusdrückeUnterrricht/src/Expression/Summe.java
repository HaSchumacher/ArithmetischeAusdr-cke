package Expression;

public class Summe implements Expression{
	/**
	 * Eine Summe besteht aus mindestens einem Summanten. 
	 * Erweitert kann der Summand mit der Operator '+' und einem Expression Ausdurck.   
	 **/
	private Expression summand2;
	private Expression summand1;
	
	public Summe(Expression expression , Expression summand2) {
		super();
		this.summand1 = expression;
		this.summand2 = summand2;
	}

	@Override
	public Integer evaluate() {
		Integer result = summand1.evaluate() + summand2.evaluate();
		return result;
	}
	public String toString() {
		return summand1.toString() + "+" + summand2.toString();
	}

}
