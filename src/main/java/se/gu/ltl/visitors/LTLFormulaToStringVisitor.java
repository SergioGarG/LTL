package se.gu.ltl.visitors;

import se.gu.ltl.LTLConjunction;
import se.gu.ltl.LTLEventually;
import se.gu.ltl.LTLDisjunction;
import se.gu.ltl.LTLGlobally;
import se.gu.ltl.LTLIff;
import se.gu.ltl.LTLImplies;
import se.gu.ltl.LTLNeg;
import se.gu.ltl.LTLSince;
import se.gu.ltl.LTLUntil;
import se.gu.ltl.LTLWeakUntil;
import se.gu.ltl.LTLNext;
import se.gu.ltl.atoms.LTLPAAtom;
import se.gu.ltl.atoms.LTLPEAtom;
import se.gu.ltl.atoms.LTLPLAtom;
import se.gu.ltl.atoms.LTLPropositionalAtom;
import se.gu.ltl.atoms.LTLTrue;

public class LTLFormulaToStringVisitor implements LTLVisitor<String> {

	@Override
	public String visit(LTLDisjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") || (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLTrue formula) {
		return "TRUE";
	}

	@Override
	public String visit(LTLConjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") && (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLNeg formula) {
		return " ! (" + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLUntil formula) {
		return "( " + formula.getLeftChild().accept(this) + ") U (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLImplies formula) {
		return "( " + formula.getLeftChild().accept(this) + ") -> (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLIff formula) {
		return "( " + formula.getLeftChild().accept(this) + ") <-> (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLSince formula) {
		return "( " + formula.getLeftChild().accept(this) + ") S (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLPropositionalAtom formula) {
		return formula.getAtomName();
	}

	@Override
	public String visit(LTLEventually mitliEventually) {
		return " <> (" + mitliEventually.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLGlobally mitliGlobally) {
		return " [] (" + mitliGlobally.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLNext ltlNext) {
		return " X (" + ltlNext.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLPLAtom ltlplAtom) {
		return "(" + ltlplAtom.getRobotName() + " in " + ltlplAtom.getLocationName() + ")";
	}

	@Override
	public String visit(LTLPEAtom ltlpeAtom) {
		return "("+ltlpeAtom.getCondition()+")";
		
	}

	@Override
	public String visit(LTLPAAtom ltlpaAtom) {
		return "(" + ltlpaAtom.getRobotName() + " exec " + ltlpaAtom.getActionName() + ")";
	}

	@Override
	public String visit(LTLWeakUntil ltlWeakUntil) {
		return "( " + ltlWeakUntil.getLeftChild().accept(this) + ") W (" + ltlWeakUntil.getRightChild().accept(this) + " )";
	}

}
