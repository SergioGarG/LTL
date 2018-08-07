package se.gu.ltl;

import java.io.Serializable;

import se.gu.ltl.atoms.True;

/**
 * Contains a generic formula
 * 
 * @author Claudio Menghi
 */
public interface Formula extends Serializable{

	
	public static final True TRUE = new True();

	
}
