package se.gu.ltl.visitors;

import se.gu.ltl.LTLConjunction;
import se.gu.ltl.LTLEventually;
import se.gu.ltl.LTLIDisjunction;
import se.gu.ltl.LTLIGlobally;
import se.gu.ltl.LTLIIff;
import se.gu.ltl.LTLIImplies;
import se.gu.ltl.LTLINegation;
import se.gu.ltl.LTLISince;
import se.gu.ltl.LTLIUntil;
import se.gu.ltl.LTLNext;
import se.gu.ltl.atoms.LTLPAAtom;
import se.gu.ltl.atoms.LTLPEAtom;
import se.gu.ltl.atoms.LTLPLAtom;
import se.gu.ltl.atoms.LTLPropositionalAtom;
import se.gu.ltl.atoms.LTLTrue;

public class LTLFormulaToStringVisitor implements LTLVisitor<String> {

	@Override
	public String visit(LTLIDisjunction formula) {
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
	public String visit(LTLINegation formula) {
		return " ! (" + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLIUntil formula) {
		return "( " + formula.getLeftChild().accept(this) + ") U (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLIImplies formula) {
		return "( " + formula.getLeftChild().accept(this) + ") -> (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLIIff formula) {
		return "( " + formula.getLeftChild().accept(this) + ") <-> (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(LTLISince formula) {
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
	public String visit(LTLIGlobally mitliGlobally) {
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

}
