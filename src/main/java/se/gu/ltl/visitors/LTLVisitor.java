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

public interface LTLVisitor<T> {

	public T visit(LTLDisjunction formula);

	public T visit(LTLTrue formula);

	public T visit(LTLConjunction formula);

	public T visit(LTLNeg formula);

	public T visit(LTLUntil formula);

	public T visit(LTLImplies formula);

	public T visit(LTLIff formula);

	public T visit(LTLSince formula);

	public T visit(LTLPropositionalAtom formula);

	public T visit(LTLEventually mitliEventually);

	public T visit(LTLGlobally mitliGlobally);

	public T visit(LTLNext ltlNext);

	public T visit(LTLPLAtom ltlplAtom);

	public T visit(LTLPEAtom ltlpeAtom);

	public T visit(LTLPAAtom ltlpaAtom);

	public T visit(LTLWeakUntil ltlWeakUntil);

}
