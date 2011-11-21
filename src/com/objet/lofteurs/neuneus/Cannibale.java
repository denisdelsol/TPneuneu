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

		this.caseCourrante.removeNeuneu(this);
		this.caseCourrante = this.mouvementAleatoire();
		this.caseCourrante.addNeuneu(this);
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public void seReproduire() {
		if (super.copuler()) {
			Cannibale cannibale = new Cannibale(this.caseCourrante, this.loft);
		}
	}

	@Override
	public void manger() {
		final int nbNeuneu = caseCourrante.getNeuneu().size();

		if (nbNeuneu > 1) {
			int indexNourriture = (int) (Math.random() * (nbNeuneu));
			while (caseCourrante.getNeuneu().get(indexNourriture)== this) {
				indexNourriture = (int) (Math.random() * (nbNeuneu));
			}
			final Neuneu nourriture = caseCourrante.getNeuneu().get(
					indexNourriture);
			final int quantiteEnergie = nourriture.estMange();

			if ((this.energie + quantiteEnergie) < Saison1.energieDefault) {
				this.energie = this.energie + quantiteEnergie;
			} else {
				this.energie = Saison1.energieDefault;
			}
		} else {
			super.manger();
		}
	}

	@Override
	public void dessinerObjet(Graphics g) {
		super.dessinerObjet(g, Color.red);
	}

}
