package se.gu.ltl;

import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ltl.atoms.LTLPropositionalAtom;
import se.gu.ltl.atoms.LTLTrue;
import se.gu.ltl.atoms.PropositionalAtom;
import se.gu.ltl.atoms.True;
import se.gu.ltl.visitors.LTLVisitor;

public interface LTLFormula extends Formula {

	public static final LTLTrue TRUE = new LTLTrue();
	
	
	public static LTLFormula getAnd(LTLFormula f1, LTLFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		if (f1.equals(LTLFormula.TRUE)) {
			return f2;
		}
		if (f2.equals(LTLFormula.TRUE)) {
			return f1;
		}
		return new LTLConjunction(f1, f2);
	}
	
	public static LTLFormula getAnd(LTLFormula... formulae) {

		LTLFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			f = new LTLConjunction(f, formulae[i]);
		}
		return f;
	}
	

	public abstract Set<LTLFormula> getChildren();

	public abstract <T> T accept(LTLVisitor<T> visitor);


	// Producers method to build CLTL formulae of the argument formula

	public static LTLFormula atom(String s) {
		return new LTLPropositionalAtom(s);
	}

	public static LTLFormula not(LTLFormula f) {
		if (f instanceof LTLNeg) {
			return ((LTLNeg) f).getChild();
		}

		return new LTLNeg(f);
	}


	public static LTLFormula U(LTLFormula f1, LTLFormula f2) {
		return new LTLUntil(f1, f2);
	}

	public static LTLFormula S(LTLFormula f1, LTLFormula f2) {
		return new LTLSince(f1, f2);
	}

	// Producers method to build derived boolean CLTL formulae
	public static LTLFormula or(LTLFormula... formulae) {
		LTLFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			f = new LTLDisjunction(f, formulae[i]);
		}
		return f;
	}

	public static LTLFormula implies(LTLFormula f1, LTLFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		return new LTLImplies(f1, f2);
	}

	public static LTLFormula iff(LTLFormula f1, LTLFormula f2) {
		return new LTLIff(f1, f2);
	}

	public static LTLFormula next(LTLFormula f) {
		if (f.equals(LTLFormula.TRUE)) {
			return f;
		}
		return new LTLNext(f);
	}

	// Producers method to build derived temporal CLTL formulae
	public static LTLFormula R(LTLFormula f1, LTLFormula f2) {
		return not(U(not(f1), not(f2)));
	}

}
