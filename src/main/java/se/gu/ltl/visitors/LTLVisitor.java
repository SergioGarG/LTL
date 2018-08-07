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
import se.gu.ltl.atoms.PAAtom;
import se.gu.ltl.atoms.PCAtom;
import se.gu.ltl.atoms.PLAtom;
import se.gu.ltl.atoms.PropositionalAtom;
import se.gu.ltl.atoms.True;

public interface LTLVisitor<T> {

	public T visit(LTLDisjunction formula);

	public T visit(True formula);

	public T visit(LTLConjunction formula);

	public T visit(LTLNeg formula);

	public T visit(LTLUntil formula);

	public T visit(LTLImplies formula);

	public T visit(LTLIff formula);

	public T visit(LTLSince formula);

	public T visit(PropositionalAtom formula);

	public T visit(LTLEventually mitliEventually);

	public T visit(LTLGlobally mitliGlobally);

	public T visit(LTLNext ltlNext);

	public T visit(PLAtom ltlplAtom);

	public T visit(PCAtom ltlpeAtom);

	public T visit(PAAtom ltlpaAtom);

	public T visit(LTLWeakUntil ltlWeakUntil);

}
