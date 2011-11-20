package com.objet.lofteurs.neuneus;

import java.awt.Color;
import java.awt.Graphics;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Saison1;

public class Cannibale extends Vorace {

	public Cannibale(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}

	@Override
	public void seDeplacer() {
		final Case caseArrivee = this.trouverPlusProcheNourritureNeuneu();
		if (caseArrivee != null) {
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
			this.loft.add(new Cannibale(this.caseCourrante, this.loft));
		}
	}

	@Override
	public void manger() {
		super.manger();

		if (this.energie < Saison1.energieDefault) {
			final int nbNeuneu = caseCourrante.getNourriture().size();

			if (nbNeuneu != 0) {
				final int indexNourriture = (int) (Math.random() * (nbNeuneu - 1));
				final Neuneu nourriture = caseCourrante.getNeuneu().get(
						indexNourriture);
				final int quantiteEnergie = nourriture.estMange();

				if ((this.energie + quantiteEnergie) < Saison1.energieDefault) {
					this.energie = this.energie + quantiteEnergie;
				} else {
					this.energie = Saison1.energieDefault;
				}
			}
		}
	}
	
	@Override
	public void dessinerObjet(Graphics g) {
		g.fillOval(this.caseCourrante.getX()*10+10, this.caseCourrante.getY()*10+10, 10, 10);
		g.setColor(Color.red);
	}

}
