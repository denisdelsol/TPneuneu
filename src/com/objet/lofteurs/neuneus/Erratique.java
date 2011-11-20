package com.objet.lofteurs.neuneus;

import com.objet.lofteurs.Case;
import com.objet.lofteurs.Loft;
import com.objet.lofteurs.Saison1;

/**
 * Represente un Neuneu de type Erratique (se deplace aleatoirement)
 * 
 * @author bastien
 * 
 */
public class Erratique extends Neuneu {

	/**
	 * Constructeur d'un Erratique
	 * 
	 * @param caseCourrante
	 *            - Case de depart de l'Erratique
	 * @param loft
	 *            - Loft dans lequel evolue l'Erratique
	 */
	public Erratique(Case caseCourrante, Loft loft) {
		super(caseCourrante, loft);
	}

	@Override
	public Case seDeplacer() {
		// TODO Implémenter la méthode
		return new Case(0, 0);
	}

	@Override
	public void seReproduire() {
		super.seReproduire();
		if (this.energie != Saison1.energieMort) {
			this.loft.add(new Erratique(this.caseCourrante, this.loft));
		}
	}

}
