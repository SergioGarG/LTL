package se.gu.ltl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;


public abstract class LTLPast  implements  UnaryFormula<LTLFormula>,LTLFormula {

	private LTLFormula subformula;

	public LTLPast(LTLFormula subformula) {
		Preconditions.checkNotNull(subformula, "The subformula cannot be null");
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return  "P(" + this.getChild() + ")";
	}
	
	/**
	 * {@inheritDoc}
	 * 
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
		Set<LTLFormula> formulae=new HashSet<>();
		formulae.add(subformula);
		return formulae;
	}
}
