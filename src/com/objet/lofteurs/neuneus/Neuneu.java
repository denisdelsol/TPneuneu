package com.objet.lofteurs.neuneus;

import com.lofteur.nourriture.Nourriture;
import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Mangeable;
import com.objet.lofteurs.Saison1;

public abstract class Neuneu implements Mangeable {
	protected final String name;
	protected int energie = Saison1.energieDefault;
	protected final Loft loft;
	protected Case caseCourrante;

	public Neuneu(String name, Case caseDepart, Loft loft) {
		this.name = name;
		this.caseCourrante = caseDepart;
		this.caseCourrante.addNeuneu(this);
		this.loft = loft;
		this.loft.add(this);

	}

	public abstract Case seDeplacer();

	public boolean estMort() {
		if (this.energie == Saison1.energieMort) {
			return true;
		} else {
			return false;
		}
	}

	public void manger() {
		final int nbNourriture = caseCourrante.getNourriture().size();

		if (nbNourriture != 0) {
			final int indexNourriture = (int) (Math.random() * nbNourriture);
			final Nourriture nourriture = caseCourrante.getNourriture().get(
					indexNourriture);
			final int quantiteEnergie = nourriture.estMange();

			if ((this.energie + quantiteEnergie) < Saison1.energieDefault) {
				this.energie = this.energie + quantiteEnergie;
			} else {
				this.energie = Saison1.energieDefault;
			}
		}
	}

	public void seReproduire() {
		final int nbNeuneu = caseCourrante.getNeuneu().size();

		if (nbNeuneu != 0) {
			if ((this.energie - Saison1.energieReproduction) <= Saison1.energieMort) {
				this.energie = Saison1.energieMort;
			}

			else {
				this.energie = this.energie - Saison1.energieReproduction;
			}
		}
	}

	public int estMange() {
		final int quantiteNourriture = (int) (Math.random() * this.energie);
		this.energie = Saison1.energieMort;
		return quantiteNourriture;
	}

}
