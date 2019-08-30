import Expression.Expression;
import Parser.SymbolParserException;

public class Userinterface {
	public static void main(String[] args) {
		Fascade facade = new Fascade();
		Expression expression = null;
		try {
			expression = facade.createExpression("3*(5+4");
			System.out.println(expression.evaluate());
		} catch (SymbolParserException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
