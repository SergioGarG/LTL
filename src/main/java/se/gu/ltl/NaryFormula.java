package se.gu.ltl;

import java.util.Set;

public interface NaryFormula<T>  extends java.io.Serializable{

	public Set<T> getChildren();

}
