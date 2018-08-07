package se.gu.ltl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ltl.LTLFormula;
import se.gu.ltl.visitors.LTLVisitor;

public class LTLPLAtom extends PLAtom implements LTLFormula {

	public LTLPLAtom(PLAtom atom){
		super(atom.getRobotName(), atom.getLocationName());
	}
	public LTLPLAtom(String robotName, String locationName) {
		super(robotName, locationName);
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
