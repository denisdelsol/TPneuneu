package com.objet.lofteurs.neuneus;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;

public class Erratique extends Neuneu {

	public Erratique(String name, Case caseCourrante, Loft loft) {
		super(name, caseCourrante, loft);
	}

	@Override
	public int estMange() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Case seDeplacer(){
		// TODO Implémenter la méthode
		return new Case(0,0);
	}

}
