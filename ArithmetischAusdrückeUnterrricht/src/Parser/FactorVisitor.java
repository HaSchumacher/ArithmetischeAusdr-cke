package Parser;

import symbols.BracketOpen;
import symbols.NaturalNumber;

public class FactorVisitor extends SymbolVisitor {
	private FactorParser myParser;
	
	public FactorVisitor(FactorParser factorParser) {
		this.myParser = factorParser;
	}
	@Override
	public void handle(NaturalNumber number) {
		this.myParser.skip();
				super.setExpr(number);
	}
	@Override
	public
	void handle (BracketOpen bro) {
		myParser.skip();
		super.setExpr(new ExpressionParser().toExpression(this.myParser.getList()));
		myParser.skip();
			
		}
		
	}
	


