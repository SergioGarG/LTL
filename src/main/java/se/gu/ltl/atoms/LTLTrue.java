package se.gu.ltl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ltl.LTLFormula;
import se.gu.ltl.visitors.LTLVisitor;

public class LTLTrue extends True implements LTLFormula{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<LTLFormula> getChildren() {
		Set<LTLFormula> formulae=new HashSet<>();
		return formulae;
	}
}
