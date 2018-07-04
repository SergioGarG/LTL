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

public interface LTLVisitor<T> {

	public T visit(LTLIDisjunction formula);


	public T visit(LTLTrue formula);

	public T visit(LTLConjunction formula);

	public T visit(LTLINegation formula);

	public T visit(LTLIUntil formula);

	public T visit(LTLIImplies formula);

	public T visit(LTLIIff formula);

	public T visit(LTLISince formula);



	public T visit(LTLPropositionalAtom formula);



	public T visit(LTLEventually mitliEventually);


	public T visit(LTLIGlobally mitliGlobally);


	public T visit(LTLNext ltlNext);


	public T visit(LTLPLAtom ltlplAtom);


	public T visit(LTLPEAtom ltlpeAtom);


	public T visit(LTLPAAtom ltlpaAtom);

}
