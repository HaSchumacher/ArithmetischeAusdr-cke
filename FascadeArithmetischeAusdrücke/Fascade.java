import Expression.Expression;
import Parser.ExpressionParserProxy;
import Parser.SymbolParserException;
import scanner.Scanner;
public class Fascade {

public Expression createExpression(String userenteredexpr) throws SymbolParserException {
	Scanner scanner = new Scanner();
	ExpressionParserProxy parser = new ExpressionParserProxy();
	return parser.toExpression(scanner.toSymbolSequence(userenteredexpr));
}

public Integer evaluateExpression(String userEnteredExpression) throws SymbolParserException {
	return this.createExpression(userEnteredExpression).evaluate();
}

}