package se.gu.ltl.visitors;

import se.gu.ltl.LTLConjunction;
import se.gu.ltl.LTLDisjunction;
import se.gu.ltl.LTLEventually;
import se.gu.ltl.LTLGlobally;
import se.gu.ltl.LTLIff;
import se.gu.ltl.LTLImplies;
import se.gu.ltl.LTLNeg;
import se.gu.ltl.LTLNext;
import se.gu.ltl.LTLSince;
import se.gu.ltl.LTLUntil;
import se.gu.ltl.LTLWeakUntil;
import se.gu.ltl.atoms.PAAtom;
import se.gu.ltl.atoms.PCAtom;
import se.gu.ltl.atoms.PLAtom;
import se.gu.ltl.atoms.PropositionalAtom;
import se.gu.ltl.atoms.True;
import se.gu.ltl.visitors.LTLFormulaToStringVisitor;

public class LTL2NuSMV extends LTLFormulaToStringVisitor{
	
	
	@Override
	public String visit(LTLDisjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") || (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(True formula) {
		return "TRUE";
	}

	@Override
	public String visit(LTLConjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") & (" + formula.getRightChild().accept(this) + " )";
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
	public String visit(PropositionalAtom formula) {
		return formula.getAtomName();
	}

	@Override
	public String visit(LTLEventually mitliEventually) {
		return " F (" + mitliEventually.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLGlobally mitliGlobally) {
		return " G (" + mitliGlobally.getChild().accept(this) + ")";
	}

	@Override
	public String visit(LTLNext ltlNext) {
		return " X (" + ltlNext.getChild().accept(this) + ")";
	}

	@Override
	public String visit(PLAtom ltlplAtom) {
		return "(" + ltlplAtom.getLocationName() + ")";
	}

	@Override
	public String visit(PCAtom ltlpeAtom) {
		return "("+ltlpeAtom.getCondition()+")";
		
	}

	@Override
	public String visit(PAAtom ltlpaAtom) {
		return "(" + ltlpaAtom.getActionName() + ")";
	}

	@Override
	public String visit(LTLWeakUntil ltlWeakUntil) {
		return "(( " + ltlWeakUntil.getLeftChild().accept(this) + ") U (" + ltlWeakUntil.getRightChild().accept(this) + " ) | ( G ("+ltlWeakUntil.getLeftChild().accept(this)+") ) )";
	}
	



}
