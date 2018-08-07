package se.gu.ltl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ltl.LTLFormula;
import se.gu.ltl.visitors.LTLVisitor;

public class LTLPropositionalAtom extends PropositionalAtom implements LTLFormula {

	public LTLPropositionalAtom(String atom) {
		super(atom);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<LTLFormula> getChildren() {
		Set<LTLFormula> formulae=new HashSet<>();
		return formulae;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
