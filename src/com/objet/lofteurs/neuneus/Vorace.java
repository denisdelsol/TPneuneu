package com.objet.lofteurs.neuneus;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;

public class Vorace extends Erratique {

	public Vorace(String name, Case caseCourrante, Loft loft) {
		super(name, caseCourrante, loft);
	}
	
	@Override
	public Case seDeplacer(){
		// TODO implémenter la méthode
		return new Case(0,0);
	}

}
