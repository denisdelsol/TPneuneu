package com.objet.lofteurs.neuneus;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Saison1;

public class Cannibale extends Vorace {

	public Cannibale(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}
	
	@Override
	public void seDeplacer(){
		// TODO implémenter la méthode
		return;
	}
	
	@Override
	public void seReproduire() {
		super.copuler();
		if (this.energie != Saison1.energieMort) {
			this.loft.add(new Cannibale(this.caseCourrante, this.loft));
		}
	}

}
