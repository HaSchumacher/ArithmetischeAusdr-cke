package Parser;

import Expression.Summe;
import symbols.BracketOpen;
import symbols.NaturalNumber;
import symbols.PlusOp;

public class SummandVisitor extends SymbolVisitor {
	private SummenParser myParser;

	public SummandVisitor(SummenParser summenParser) {
		this.myParser = summenParser;
	}

	@Override
	public void handle(NaturalNumber number) {
		myParser.skip(); // remove Number
		if (this.myParser.getList().isEmpty()) {
			super.setExpr(number);
			return;
		}

		if (this.myParser.getList().get(0) == PlusOp.getInstance()) { // check for Mult-Op
			this.myParser.skip();
			super.setExpr(new Summe(new SummenParser().toExpression(myParser.getList()), number));
		} else {
			this.myParser.getList().add(0, number);
			super.setExpr(new FactorParser().toExpression(this.myParser.getList()));
		}

	}

	@Override
	public void handle(BracketOpen bro) {
		super.setExpr(new FactorParser().toExpression(this.myParser.getList()));
	}

}
