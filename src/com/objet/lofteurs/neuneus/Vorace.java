package com.objet.lofteurs.neuneus;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Saison1;

public class Vorace extends Erratique {

	public Vorace(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}

	@Override
	public void seDeplacer() {
		Case caseArrivee = this.trouverPlusProcheNourriture();
		if(caseArrivee != null){
			this.caseCourrante.removeNeuneu(this);
			this.caseCourrante = caseArrivee;
			this.caseCourrante.addNeuneu(this);
			return;
		}
		caseArrivee = this.trouverPlusProcheNeuneu();
		if(caseArrivee != null){
			this.caseCourrante.removeNeuneu(this);
			this.caseCourrante = caseArrivee;
			this.caseCourrante.addNeuneu(this);
			return;
		}
		return;
	}
	
	@Override
	public void seReproduire() {
		super.copuler();
		if (this.energie != Saison1.energieMort) {
			this.loft.add(new Vorace(this.caseCourrante, this.loft));
		}
	}
	
	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.orange);
	}

}
