package se.gu.ltl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ltl.LTLFormula;
import se.gu.ltl.visitors.LTLVisitor;

public class LTLPCAtom extends PCAtom implements LTLFormula {

	public LTLPCAtom(PCAtom atom){
		super(atom.getCondition());
	}
	public LTLPCAtom(String condition) {
		super(condition);
	}

	@Override
	public Set<LTLFormula> getChildren() {

		Set<LTLFormula> formulae = new HashSet<>();
		formulae.add(this);
		return formulae;
	}
	
	

	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
