package se.gu.ltl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ltl.visitors.LTLVisitor;

public class LTLEventually  implements UnaryFormula<LTLFormula>,LTLFormula {

	private final LTLFormula subformula;

	public LTLEventually(LTLFormula subformula) {
		super();
		Preconditions.checkNotNull(subformula, "The subFormula cannot be null");
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "F (" + this.getChild() + ")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public LTLFormula getChild() {
		return this.subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<LTLFormula> getChildren() {
		Set<LTLFormula> formulae = new HashSet<>();
		formulae.add(subformula);
		return formulae;
	}

	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
