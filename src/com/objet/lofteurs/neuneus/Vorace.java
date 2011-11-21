package com.objet.lofteurs.neuneus;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;

public class Vorace extends Erratique {

	public Vorace(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}

	@Override
	public void seDeplacer() {
		Case caseArrivee = this.trouverPlusProcheNourriture();
		if (caseArrivee != null) {
			this.caseCourrante.removeNeuneu(this);
			this.caseCourrante = caseArrivee;
			this.caseCourrante.addNeuneu(this);
			return;
		}

		this.caseCourrante.removeNeuneu(this);
		this.caseCourrante = this.mouvementAleatoire();
		this.caseCourrante.addNeuneu(this);
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public void seReproduire() {
		if (super.copuler()) {
			Vorace vorace = new Vorace(this.caseCourrante, this.loft);
		}
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.orange);
	}

}
