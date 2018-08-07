package se.gu.ltl.atoms;


import java.util.HashSet;
import java.util.Set;

import se.gu.ltl.LTLFormula;
import se.gu.ltl.visitors.LTLVisitor;

public class PropositionalAtom extends Atom {

	private final String atomName;
	private final int hash;

	public PropositionalAtom(String atom) {
		this.atomName = atom;
		this.hash = this.generateHash();
	}

	

	public String getAtomName() {
		return atomName;
	}

	private int generateHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atomName == null) ? 0 : atomName.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return hash;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropositionalAtom other = (PropositionalAtom) obj;
		if (atomName == null) {
			if (other.atomName != null)
				return false;
		} else if (!atomName.equals(other.atomName))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "("+this.atomName+")";
	}
	

}
